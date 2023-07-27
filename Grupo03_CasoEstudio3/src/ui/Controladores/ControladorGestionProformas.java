package ui.Controladores;

import bl.entities.composite.base.iComponente;
import bl.entities.composite.components.Proforma;
import bl.entities.factory.gestor.GestorFactory;
import bl.entities.factory.product.Repuesto;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import bl.entities.composite.components.Detalle;
import bl.entities.composite.gestor.CompositeGestor;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
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
    private CompositeGestor gestorComposite = new CompositeGestor();
    @FXML
    public ObservableList<Repuesto> observableRepuestos;
    private GestorFactory gestorFactory = new GestorFactory();

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
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void seleccionarProforma(ActionEvent actionEvent) {
        int id_proforma = proformasCB.getValue().getId();
        cargarTablaDetalleProforma(id_proforma);
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
}
