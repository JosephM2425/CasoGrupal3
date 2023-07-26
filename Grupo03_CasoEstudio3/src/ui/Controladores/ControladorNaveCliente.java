package ui.Controladores;

import bl.entities.builder.gestor.GestorBuilder;
import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Nave;
import bl.entities.builder.objects.Usuario;
import bl.entities.builder.objects.Vendedor;
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
public class ControladorNaveCliente {
    @FXML
    TableView<Nave> listaNaves;
    @FXML
    TableColumn<Nave,String> tCodigo;
    @FXML
    TableColumn<Nave,String> tMarca;
    @FXML
    TableColumn<Nave,String> tModelo;
    @FXML
    TableColumn<Nave,String> tAnio;
    @FXML
    TableColumn<Nave,String> tCategoria;
    @FXML
    TableColumn<Nave,String> tColor;
    @FXML
    public ObservableList<Nave> observableNaves;
    public ComboBox<Usuario> clienteCB;
    @FXML
    public ObservableList<Usuario> observableClientes;
    private GestorBuilder gestorBuilder = new GestorBuilder();

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
            observableClientes = FXCollections.observableArrayList(gestorBuilder.listarUsuarios(1));
            clienteCB.setItems(observableClientes);

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
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo para actualizar el TableView de las naves
     */
    public void cargarListaNaves(int idCliente) {
        try {
            listaNaves.getItems().clear();
            observableNaves = FXCollections.observableArrayList();
            gestorBuilder.listarNaves().forEach(nave -> observableNaves.addAll(nave));
            observableNaves = FXCollections.observableArrayList(gestorBuilder.listarNaves(idCliente));
            tCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoIdentificacion()));
            tMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarcaModeloNave().getMarca().getNombreMarca()));
            tModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarcaModeloNave().getModelo().getNombreModelo()));
            tAnio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarcaModeloNave().getAnio() + ""));
            tCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoriaNave().getNombreCategoria()));
            tColor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
            listaNaves.setItems(observableNaves);
            cargarComboBoxes();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void seleccionarCliente(ActionEvent actionEvent) {
        if(clienteCB.getValue() != null) {
            cargarListaNaves(clienteCB.getValue().getId());
        }
    }

    public void actualizarClientes(ActionEvent actionEvent) {
        clienteCB.setValue(null);
        listaNaves.getItems().clear();
        cargarComboBoxes();
    }
}
