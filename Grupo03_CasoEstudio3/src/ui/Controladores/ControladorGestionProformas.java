package ui.Controladores;

import bl.entities.builder.gestor.GestorBuilder;
import bl.entities.builder.objects.Usuario;
import bl.entities.composite.components.Proforma;
import bl.entities.factory.gestor.GestorFactory;
import bl.entities.factory.product.Repuesto;
import bl.entities.proxy.UsuarioProxy;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.Callback;
import bl.entities.composite.components.Detalle;
import bl.entities.composite.gestor.CompositeGestor;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import java.util.Optional;


public class ControladorGestionProformas {
    @FXML
    public ObservableList<Detalle> observableDetalles;
    public ComboBox<Proforma> proformasCB = new ComboBox<>();
    @FXML
    public ObservableList<Proforma> observableProformas;
    public TableView tProformaRepuesto;
    public TableColumn<Repuesto, String> nombre;
    public TableColumn<Repuesto, String> descripcion;
    public TableColumn<Repuesto, Integer> precio;
    public TableColumn razon;
    public TableColumn estado;
    public ComboBox<Usuario> usuariosCB;
    @FXML
    public ObservableList<Usuario> observableUsuarios;
    private CompositeGestor gestorComposite = new CompositeGestor();
    @FXML
    public ObservableList<Repuesto> observableRepuestos;
    private GestorFactory gestorFactory = new GestorFactory();
    @FXML
    private Text textProformaEstado;
    private GestorBuilder gestorBuilder = new GestorBuilder();



    @FXML
    public void initialize() {
        try {
            cargarComboBoxes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarComboBoxes () {
        try {
            observableProformas = FXCollections.observableArrayList(gestorComposite.obtenerProformas());
            proformasCB.setItems(observableProformas);

            Callback<ListView<Proforma>, ListCell<Proforma>> cellFactory = new Callback<>() {

                @Override
                public ListCell<Proforma> call(ListView<Proforma> l) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(Proforma item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item == null || empty) {
                                setGraphic(null);
                            } else {
                                setText("[" + item.getId() + "] " + "Cliente: " +item.getCliente().getNombre() + " " + item.getCliente().getApellido1() + " | Vendedor: " + item.getVendedor().getNombre() + " " + item.getVendedor().getApellido1());
                            }
                        }
                    };
                }
            };

            proformasCB.setButtonCell(cellFactory.call(null));
            proformasCB.setCellFactory(cellFactory);

            observableUsuarios = FXCollections.observableArrayList(gestorBuilder.listarUsuarios());
            usuariosCB.setItems(observableUsuarios);

            Callback<ListView<Usuario>, ListCell<Usuario>> cellFactory1 = new Callback<>() {

                @Override
                public ListCell<Usuario> call(ListView<Usuario> l) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(Usuario item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item == null || empty) {
                                setGraphic(null);
                            } else {
                                setText(item.getNombre() + " " + item.getApellido1() + " " + item.getApellido2());
                            }
                        }
                    };
                }
            };

            usuariosCB.setButtonCell(cellFactory1.call(null));
            usuariosCB.setCellFactory(cellFactory1);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void seleccionarProforma(ActionEvent actionEvent) {
        int id_proforma = proformasCB.getValue().getId();
        cargarTablaDetalleProforma(id_proforma);
        actualizarEstado(id_proforma);
    }

    public void cargarTablaDetalleProforma(int id_proforma) {
        Optional<Proforma> proforma_seleccionada = observableProformas.filtered(proforma -> proforma.getId() == id_proforma)
                .stream()
                .findFirst();

        observableDetalles = FXCollections.observableArrayList(gestorComposite.obtenerDetalles());

        FilteredList<Detalle> detalle_seleccionado = observableDetalles.filtered(detalle -> detalle.getId_proforma() == proforma_seleccionada.get().getId());
        observableRepuestos = FXCollections.observableArrayList(gestorFactory.listarRepuestos());
        ObservableList<Repuesto> repuestosFiltrados = FXCollections.observableArrayList();

        for (Repuesto repuesto : observableRepuestos) {
            int id_repuesto_actual = repuesto.getId_Repuesto();
            if (detalle_seleccionado.stream().anyMatch(detalle -> detalle.getRepuesto().getId_Repuesto() == id_repuesto_actual)) {
                repuestosFiltrados.add(repuesto);
            }
        }
        tProformaRepuesto.setEditable(true);
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        razon.setCellFactory(TextFieldTableCell.forTableColumn());
        estado.setCellFactory(TextFieldTableCell.forTableColumn());
        tProformaRepuesto.setItems(repuestosFiltrados);
    }

    public void actualizarEstado(int id_proforma){
        Proforma proforma = gestorComposite.obtenerProformas().get(id_proforma);
        textProformaEstado.setText(proforma.getEstado());
    }

    public void guardarProforma(ActionEvent actionEvent) {
        if(usuariosCB.getValue() != null) {
            UsuarioProxy usuarioSesion = new UsuarioProxy();
            usuarioSesion.setUsuario(usuariosCB.getValue());
            if(!usuarioSesion.analizarRol()) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No tiene permisos para realizar esta acción.");
            } else {
                mostrarAlerta(Alert.AlertType.INFORMATION, "Operación exitosa", "Se ha guardado la proforma con éxito");
            }
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe seleccionar un usuario.");
        }
    }

    public void actualizarListas(ActionEvent actionEvent) {
        proformasCB.getItems().clear();
        usuariosCB.getItems().clear();
        tProformaRepuesto.getItems().clear();
        cargarComboBoxes();
    }

    private void mostrarAlerta(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
