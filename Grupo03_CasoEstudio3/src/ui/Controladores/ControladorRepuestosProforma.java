package ui.Controladores;

import bl.entities.builder.gestor.GestorBuilder;
import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Usuario;
import bl.entities.builder.objects.Vendedor;
import bl.entities.composite.components.Detalle;
import bl.entities.composite.components.Proforma;
import bl.entities.composite.gestor.CompositeGestor;
import bl.entities.factory.gestor.GestorFactory;
import bl.entities.factory.product.Repuesto;
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
    TableView<Repuesto> listaRepuestos;
    @FXML
    TableColumn<Repuesto,String> tIdRepuesto;
    @
            FXML
    TableColumn<Repuesto,String> tNombreRepuesto;
    @FXML
    TableColumn<Repuesto,String> tDescRepuesto;
    @FXML
    TableColumn<Repuesto,String> tCatRepuesto;
    @FXML
    TableColumn<Repuesto,String> tMarcaRepuesto;
    @FXML
    TableColumn<Repuesto,String> tPrecioRepuesto;
    @FXML
    public ObservableList<Repuesto> observableRepuestos;
    @FXML
    TableView<Detalle> listaDetalles;
    @FXML
    TableColumn<Detalle,String> tIdDetalle;
    @FXML
    TableColumn<Detalle,String> tNombreRepDetalle;
    @FXML
    TableColumn<Detalle,String> tDescRepuestoDetalle;
    @FXML
    TableColumn<Detalle,String> tEstado;
    @FXML
    public ObservableList<Detalle> observableDetalles;
    public ComboBox<Proforma> proformaCB;
    @FXML
    public ObservableList<Proforma> observableProformas;
    private CompositeGestor gestorComposite = new CompositeGestor();
    private GestorFactory gestorFactory = new GestorFactory();

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
                                setText("[ID: " + item.getId() + "] " + "Cliente: " +item.getCliente().getNombre() + " " + item.getCliente().getApellido1() + " | Vendedor: " + item.getVendedor().getNombre() + " " + item.getVendedor().getApellido1() + " | Nave Código: " + item.getNave().getCodigoIdentificacion());
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
        proformaCB.getItems().clear();
        listaRepuestos.getItems().clear();
        listaDetalles.getItems().clear();
        cargarComboBoxes();
    }

    /**
     * Metodo para actualizar el TableView de las repuestos
     */
    public void cargarListaRepuestos(Proforma proforma) {
        try {
            listaRepuestos.getItems().clear();
            int idMarcaModeloNave = proforma.getNave().getMarcaModeloNave().getIdMarcaModeloNave();
            observableRepuestos = FXCollections.observableArrayList(gestorFactory.listarRepuestosCompatibles(idMarcaModeloNave));
            gestorFactory.listarRepuestosCompatibles(idMarcaModeloNave).forEach(repuesto -> observableRepuestos.addAll(repuesto));
            observableRepuestos = FXCollections.observableArrayList(gestorFactory.listarRepuestosCompatibles(idMarcaModeloNave));
            tIdRepuesto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId_Repuesto() + ""));
            tNombreRepuesto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
            tDescRepuesto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
            tCatRepuesto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
            tMarcaRepuesto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarcaRepuesto().getMarca()));
            tPrecioRepuesto.setCellValueFactory(cellData -> new SimpleStringProperty("$" + cellData.getValue().getPrecio()));
            listaRepuestos.setItems(observableRepuestos);
            cargarComboBoxes();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void seleccionarProforma(ActionEvent actionEvent) {
        if(proformaCB.getValue() != null) {
            listaRepuestos.getItems().clear();
            cargarListaRepuestos(proformaCB.getValue());
            listaDetalles.getItems().clear();
            cargarListaDetalles(proformaCB.getValue());
        }
    }

    /**
     * Metodo para anadir un repuesto a una proforma
     * @param actionEvent es de tipo ActionEvent representa algun tipo de accion realizada
     */
    public void anadirRepuestoAProforma(ActionEvent actionEvent) {
        try {
            Repuesto repuesto = listaRepuestos.getSelectionModel().getSelectedItem();
            if (repuesto == null) {
                mostrarAlerta(Alert.AlertType.ERROR, "No ha seleccionado un repuesto", "No ha seleccionado un repuesto.\nPor favor seleccione uno e inténtelo de nuevo.");
            } else {
                int resultado = gestorComposite.nuevoDetalle(proformaCB.getValue().getId(), repuesto, "Pendiente");
                if(resultado == 0) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Adición del repuesto exitosa", "Se ha añadido exitosamente el repuesto a la proforma.");
                    cargarListaDetalles(proformaCB.getValue());
                }
                else {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error en la adición de repuesto ", "Ha ocurrido un error la adición de repuesto,\npor favor inténtelo de nuevo.");
                }
            }
        } catch (Exception e){
            mostrarAlerta(Alert.AlertType.ERROR,"Error.","Ha ocurrido un error, por favor inténtelo de nuevo.");
        }
    }

    /**
     * Metodo para actualizar el TableView de los detalles
     */
    public void cargarListaDetalles(Proforma proforma) {
        try {
            listaDetalles.getItems().clear();
            int idProforma = proforma.getId();
            observableDetalles = FXCollections.observableArrayList(gestorComposite.obtenerDetalles(idProforma));
            gestorComposite.obtenerDetalles(idProforma).forEach(detalle -> observableDetalles.addAll(detalle));
            observableDetalles = FXCollections.observableArrayList(gestorComposite.obtenerDetalles(idProforma));
            tIdDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId() + ""));
            tNombreRepDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRepuesto().getNombre()));
            tDescRepuestoDetalle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRepuesto().getDescripcion()));
            tEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado()));
            listaDetalles.setItems(observableDetalles);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
