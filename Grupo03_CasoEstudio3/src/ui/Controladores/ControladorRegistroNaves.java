package ui.Controladores;

import bl.entities.builder.gestor.GestorBuilder;
import bl.entities.builder.objects.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

public class ControladorRegistroNaves {
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
    TableColumn<Nave,String> tCliente;
    @FXML
    public ObservableList<Nave> observableNaves;
    public ComboBox<Usuario> clientesCB;
    public ObservableList<Usuario> observableClientes;
    public ComboBox<CategoriaNave> categoriasCB;
    public ObservableList<CategoriaNave> observableCategorias;
    public ComboBox<MarcaNave> marcasCB;
    public ObservableList<MarcaNave> observableMarcas;
    public ComboBox<ModeloNave> modelosCB;
    public ObservableList<ModeloNave> observableModelos;
    public TextField anioTF;
    public TextField codigoIdTF;
    public TextField colorTF;
    private GestorBuilder gestorBuilder = new GestorBuilder();


    /**
     * Metodo para actualizar los ComboBoxes
     */
    public void cargarComboBoxes () {
        try {
            observableClientes = FXCollections.observableArrayList(gestorBuilder.listarUsuarios(1));
            clientesCB.setItems(observableClientes);
            observableCategorias = FXCollections.observableArrayList(gestorBuilder.listarCategorias());
            categoriasCB.setItems(observableCategorias);
            observableMarcas = FXCollections.observableArrayList(gestorBuilder.listarMarcas());
            marcasCB.setItems(observableMarcas);
            observableModelos = FXCollections.observableArrayList(gestorBuilder.listarModelos());
            modelosCB.setItems(observableModelos);

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

            clientesCB.setButtonCell(cellFactory.call(null));
            clientesCB.setCellFactory(cellFactory);

            Callback<ListView<CategoriaNave>, ListCell<CategoriaNave>> cellFactory1 = new Callback<>() {
                @Override
                public ListCell<CategoriaNave> call(ListView<CategoriaNave> l) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(CategoriaNave item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item == null || empty) {
                                setGraphic(null);
                            } else {
                                setText(item.getNombreCategoria());
                            }
                        }
                    };
                }
            };

            categoriasCB.setButtonCell(cellFactory1.call(null));
            categoriasCB.setCellFactory(cellFactory1);

            Callback<ListView<MarcaNave>, ListCell<MarcaNave>> cellFactory2 = new Callback<>() {
                @Override
                public ListCell<MarcaNave> call(ListView<MarcaNave> l) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(MarcaNave item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item == null || empty) {
                                setGraphic(null);
                            } else {
                                setText(item.getNombreMarca());
                            }
                        }
                    };
                }
            };

            marcasCB.setButtonCell(cellFactory2.call(null));
            marcasCB.setCellFactory(cellFactory2);

            Callback<ListView<ModeloNave>, ListCell<ModeloNave>> cellFactory3 = new Callback<>() {
                @Override
                public ListCell<ModeloNave> call(ListView<ModeloNave> l) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(ModeloNave item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item == null || empty) {
                                setGraphic(null);
                            } else {
                                setText(item.getNombreModelo());
                            }
                        }
                    };
                }
            };

            modelosCB.setButtonCell(cellFactory3.call(null));
            modelosCB.setCellFactory(cellFactory3);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void registrarNave(ActionEvent actionEvent) {
        try {
            if(clientesCB.getValue() == null || categoriasCB.getValue() == null || marcasCB.getValue() == null || modelosCB.getValue() == null || anioTF.getText().isEmpty() || codigoIdTF.getText().isEmpty() || colorTF.getText().isEmpty()){
                mostrarAlerta(Alert.AlertType.ERROR, "Hay campos obligatorios sin llenar", "Hay campos obligatorios sin llenar.\nPor favor llene todos los campos obligatorios.");
            } else {
                int resultado = gestorBuilder.construccionNaves(clientesCB.getValue(), categoriasCB.getValue(), marcasCB.getValue(), modelosCB.getValue(), Integer.parseInt(anioTF.getText()), codigoIdTF.getText(), colorTF.getText());
                if(resultado == 0) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Registro exitoso", "La nave se ha registrado exitosamente.");
                    resetearValores();
                    cargarListaNaves();
                } else if(resultado == 1) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error en el registro de la nave", "Ha ocurrido un error en el registro de la nave,\npor favor inténtelo de nuevo.");
                }
            }
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "El campo sólo acepta valores numéricos.", "El campo precio solo acepta valores numéricos.");
        }
        catch (Exception e) {
            e.printStackTrace();
            //mostrarAlerta(Alert.AlertType.ERROR, "Error en el registro de repuesto", "Ha ocurrido un error en el registro del repuesto,\npor favor inténtelo de nuevo.");
        }
    }

    /**
     * Metodo para actualizar el TableView de las naves
     */
    public void cargarListaNaves() {
        try {
            listaNaves.getItems().clear();
            observableNaves = FXCollections.observableArrayList();
            gestorBuilder.listarNaves().forEach(nave -> observableNaves.addAll(nave));
            observableNaves = FXCollections.observableArrayList(gestorBuilder.listarNaves());
            tCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigoIdentificacion()));
            tMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarcaModeloNave().getMarca().getNombreMarca()));
            tModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarcaModeloNave().getModelo().getNombreModelo()));
            tAnio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarcaModeloNave().getAnio() + ""));
            tCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoriaNave().getNombreCategoria()));
            tColor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
            tCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario().getNombre() + " " + cellData.getValue().getUsuario().getApellido1() + " " + cellData.getValue().getUsuario().getApellido2()));
            listaNaves.setItems(observableNaves);
            cargarComboBoxes();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void resetearValores() {
        clientesCB.getSelectionModel().clearSelection();
        categoriasCB.getSelectionModel().clearSelection();
        marcasCB.getSelectionModel().clearSelection();
        modelosCB.getSelectionModel().clearSelection();
        anioTF.setText("");
        codigoIdTF.setText("");
        colorTF.setText("");
    }

    private void mostrarAlerta(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public void actualizarListas(ActionEvent actionEvent) {
        cargarComboBoxes();
    }

    public void initialize() {
        cargarComboBoxes();
        cargarListaNaves();
    }

}
