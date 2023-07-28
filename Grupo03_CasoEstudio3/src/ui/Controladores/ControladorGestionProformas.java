package ui.Controladores;

import bl.entities.builder.gestor.GestorBuilder;
import bl.entities.builder.objects.Usuario;
import bl.entities.composite.components.Proforma;
import bl.entities.factory.gestor.GestorFactory;
import bl.entities.factory.product.Repuesto;
import bl.entities.proxy.UsuarioProxy;
import bl.entities.state.concreto.InProgressState;
import bl.entities.state.abstracto.State;
import bl.entities.state.gestor.GestorState;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.Callback;
import bl.entities.composite.components.Detalle;
import bl.entities.composite.gestor.CompositeGestor;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;


public class ControladorGestionProformas {
    @FXML
    public ObservableList<Detalle> observableDetalles;
    public ComboBox<Proforma> proformasCB = new ComboBox<>();
    @FXML
    public ObservableList<Proforma> observableProformas;
    public TableView<Detalle> tProformaRepuesto;
    public TableColumn<Detalle, String> nombre;
    public TableColumn<Detalle, String> descripcion;
    public TableColumn<Detalle, String> precio;
    public TableColumn<Detalle, String> razon;
    public TableColumn<Detalle, String> estado;
    public ComboBox<Usuario> usuariosCB;
    @FXML
    public ObservableList<Usuario> observableUsuarios;
    private CompositeGestor gestorComposite = new CompositeGestor();
    @FXML
    public ObservableList<Repuesto> observableRepuestos;
    private GestorFactory gestorFactory = new GestorFactory();
    private GestorState gestorState = new GestorState();
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
        try {
            tProformaRepuesto.getItems().clear();
            tProformaRepuesto.setEditable(true);
            observableDetalles = FXCollections.observableArrayList(gestorComposite.obtenerDetalles(id_proforma));
            gestorComposite.obtenerDetalles(id_proforma).forEach(detalle -> observableDetalles.addAll(detalle));
            observableDetalles = FXCollections.observableArrayList(gestorComposite.obtenerDetalles(id_proforma));
            nombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRepuesto().getNombre()));
            descripcion .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRepuesto().getDescripcion()));
            precio.setCellValueFactory(cellData -> new SimpleStringProperty("$" + cellData.getValue().getRepuesto().getPrecio() + ""));
            razon.setCellFactory(TextFieldTableCell.forTableColumn());
            estado.setCellFactory(TextFieldTableCell.forTableColumn());
            tProformaRepuesto.setItems(observableDetalles);
        } catch (Exception e){
            e.printStackTrace();
        }
        ;
    }

    public void actualizarEstado(int id_proforma){
        Proforma proforma = gestorComposite.obtenerProformas().get(id_proforma);
        textProformaEstado.setText(proforma.getEstado());
    }

    public void guardarProforma(ActionEvent actionEvent) {
        int id_proforma = proformasCB.getValue().getId();
        Proforma proforma = obtenerProforma(id_proforma);
        if(usuariosCB.getValue() != null) {
            UsuarioProxy usuarioSesion = new UsuarioProxy();
            usuarioSesion.setUsuario(usuariosCB.getValue());
            if(!usuarioSesion.analizarRol()) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No tiene permisos para realizar esta acción.");
            } else {
                ObservableList<Detalle> detallesObservable = tProformaRepuesto.getItems();
                ArrayList<Detalle> detalles = new ArrayList<>(detallesObservable);
                for (Detalle detalle : detalles) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Prueba.", detalle.getEstado());
                }
                mostrarAlerta(Alert.AlertType.INFORMATION, "Operación exitosa", "Se ha guardado la proforma con éxito");
                proforma = gestorState.cambiarEstado(proforma, 3);
                System.out.println("Estado de Actualizacon de Proforma: " + gestorComposite.actualizarProforma(proforma));
                System.out.println(
                        "ID:" + proforma.getId() + "\n" +
                        "Estado Proforma:" + proforma.getEstado() + "\n" +
                        "Cliente:" + proforma.getCliente().getNombre() + "\n" +
                        "Vendedor: " + proforma.getVendedor().getNombre()
                );
                actualizarEstado(id_proforma);
            }


        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Debe seleccionar un usuario.");
        }
    }

    public Proforma obtenerProforma(int id){
        ArrayList<Proforma> listaProformas = gestorComposite.obtenerProformas();
        for (Proforma tempProforma:
             listaProformas) {
            if (tempProforma.getId() == id) {
                return tempProforma;
            }
        }
        return null;
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
