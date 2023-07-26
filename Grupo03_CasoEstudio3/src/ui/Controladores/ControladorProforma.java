package ui.Controladores;

import bl.entities.builder.gestor.GestorBuilder;
import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Usuario;
import bl.entities.builder.objects.Vendedor;
import bl.entities.composite.base.iComponente;
import bl.entities.composite.components.Proforma;
import bl.entities.composite.gestor.CompositeGestor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.ArrayList;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 23/07/2023
 *
 * Esta clase se encarga de gestionar el formulario FXML de Proformas
 */
public class ControladorProforma {
    @FXML
    TableView<Proforma> listaProformas;
    @FXML
    TableColumn<Proforma,String> tNoProforma;
    @FXML
    TableColumn<Proforma,String> tCliente;
    @FXML
    TableColumn<Proforma,String> tVendedor;
    @FXML
    TableColumn<Proforma,String> tEstado;
    @FXML
    public ObservableList<Proforma> observableProformas;
    public ComboBox<Usuario> clienteCB;
    public ComboBox<Usuario> vendedorCB;
    @FXML
    public ObservableList<Usuario> observableClientes;
    @FXML
    public ObservableList<Usuario> observableVendedores;
    private GestorBuilder gestorBuilder = new GestorBuilder();
    private CompositeGestor gestorComposite = new CompositeGestor();

    /**
     * Metodo para inicializar el ObservableList y el TableView
     */
    @FXML
    public void initialize() {
        try {
            cargarComboBoxes();
            cargarListaProformas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para actualizar los ComboBoxes
     */
    public void cargarComboBoxes () {
        try {
            observableClientes = FXCollections.observableArrayList(gestorBuilder.listarUsuarios(1));
            clienteCB.setItems(observableClientes);
            observableVendedores = FXCollections.observableArrayList(gestorBuilder.listarUsuarios(2));
            vendedorCB.setItems(observableVendedores);

            Callback<ListView<Usuario>, ListCell<Usuario>> cellFactory = new Callback<>() {

                @Override
                public ListCell<Usuario> call(ListView<Usuario> l) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(Usuario item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item == null || empty) {
                                setGraphic(null);
                            } else {
                                setText(item.getNombre()+ " " + item.getApellido1() + " " + item.getApellido2());
                            }
                        }
                    };
                }
            };

            clienteCB.setButtonCell(cellFactory.call(null));
            clienteCB.setCellFactory(cellFactory);
            vendedorCB.setButtonCell(cellFactory.call(null));
            vendedorCB.setCellFactory(cellFactory);
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

    /**
     * Metodo para resetear los valores del formulario
     */
    public void resetearValores() {
        clienteCB.getSelectionModel().clearSelection();
        vendedorCB.getSelectionModel().clearSelection();
    }

    public void actualizarUsuarios(ActionEvent actionEvent) {
        resetearValores();
        cargarComboBoxes();
    }

    /**
     * Metodo para registrar una proforma
     * @param actionEvent es de tipo ActionEvent representa algun tipo de accion realizada
     */
    public void registrarProforma(ActionEvent actionEvent) {
        try {
            if (clienteCB.getValue() == null || vendedorCB.getValue() == null) {
                mostrarAlerta(Alert.AlertType.ERROR, "Hay campos obligatorios sin llenar", "Hay campos obligatorios sin llenar.\nPor favor llene todos los campos obligatorios.");
            } else {
                int resultado = gestorComposite.nuevaProforma((Cliente) clienteCB.getValue(), (Vendedor) vendedorCB.getValue(), "Pendiente");
                if(resultado == 0) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Registro de proforma exitoso", "La proforma se ha registrado correctamente.");
                    resetearValores();
                    cargarListaProformas();
                }
                else {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error en el registro de proforma", "Ha ocurrido un error en el registro de la proforma,\npor favor inténtelo de nuevo.");
                }
            }
        } catch (Exception e){
            mostrarAlerta(Alert.AlertType.ERROR,"Error.","Ha ocurrido un error, por favor inténtelo de nuevo.");
        }
    }

    /**
     * Metodo para actualizar el TableView de las proformas
     */
    public void cargarListaProformas() {
        try {
            listaProformas.getItems().clear();
            observableProformas = FXCollections.observableArrayList();
            gestorComposite.obtenerProformas().forEach(proforma -> observableProformas.addAll(proforma));
            observableProformas = FXCollections.observableArrayList(gestorComposite.obtenerProformas());
            tNoProforma.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId() + ""));
            tCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombre() + " " + cellData.getValue().getCliente().getApellido1() + " " + cellData.getValue().getCliente().getApellido2()));
            tVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVendedor().getNombre() + " " + cellData.getValue().getVendedor().getApellido1() + " " + cellData.getValue().getVendedor().getApellido2()));
            tEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado() + ""));
            listaProformas.setItems(observableProformas);
            cargarComboBoxes();
        } catch (Exception e){
            mostrarAlerta(Alert.AlertType.ERROR,"Error.","Ha ocurrido un error, por favor inténtelo de nuevo.");
        }
    }
}
