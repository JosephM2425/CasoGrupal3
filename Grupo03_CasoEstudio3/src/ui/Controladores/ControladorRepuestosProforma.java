package ui.Controladores;

import bl.entities.builder.gestor.GestorBuilder;
import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Usuario;
import bl.entities.builder.objects.Vendedor;
import bl.entities.composite.components.Detalle;
import bl.entities.composite.components.Proforma;
import bl.entities.composite.gestor.CompositeGestor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 23/07/2023
 *
 * Esta clase se encarga de gestionar el formulario FXML de Proformas
 */
public class ControladorRepuestosProforma {
    @FXML
    TableView<Detalle> listaDetalles;
    @FXML
    TableColumn<Detalle,String> tIdDetalle;
    @FXML
    TableColumn<Detalle,String> tNombreRepDetalle;
    @FXML
    TableColumn<Detalle,String> tEstado;
    @FXML
    TableColumn<Detalle,String> tRazonRechazo;
    @FXML
    public ObservableList<Detalle> observableDetalles;
    public ComboBox<Proforma> proformaCB = new ComboBox<>();
    @FXML
    public ObservableList<Proforma> observableProformas;
    private CompositeGestor gestorComposite = new CompositeGestor();

    /**
     * Metodo para inicializar el ObservableList y el TableView
     */
    @FXML
    public void initialize() {
        try {
            cargarComboBoxes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para actualizar los ComboBoxes
     */
    public void cargarComboBoxes () {
        try {
            observableProformas = FXCollections.observableArrayList(gestorComposite.obtenerProformas());
            proformaCB.setItems(observableProformas);

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

            proformaCB.setButtonCell(cellFactory.call(null));
            proformaCB.setCellFactory(cellFactory);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public void actualizarProformas (ActionEvent actionEvent) {
        cargarComboBoxes();
    }

//    /**
//     * Metodo para actualizar el TableView de las proformas
//     */
//    public void cargarListaProformas() {
//        try {
//            listaProformas.getItems().clear();
//            observableProformas = FXCollections.observableArrayList();
//            gestorComposite.obtenerProformas().forEach(proforma -> observableProformas.addAll(proforma));
//            observableProformas = FXCollections.observableArrayList(gestorComposite.obtenerProformas());
//            tNoProforma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId() + ""));
//            tCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre() + " " + cellData.getValue().getCliente().getApellido1() + " " + cellData.getValue().getCliente().getApellido2()));
//            tVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVendedor().getNombre() + " " + cellData.getValue().getVendedor().getApellido1() + " " + cellData.getValue().getVendedor().getApellido2()));
//            tEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado() + ""));
//            listaProformas.setItems(observableProformas);
//            cargarComboBoxes();
//        } catch (Exception e){
//            mostrarAlerta(Alert.AlertType.ERROR,"Error.","Ha ocurrido un error, por favor inténtelo de nuevo.");
//        }
//    }
}
