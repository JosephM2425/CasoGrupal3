package ui.Controladores;

import bl.entities.builder.gestor.GestorBuilder;
import bl.entities.builder.objects.CategoriaNave;
import bl.entities.builder.objects.MarcaNave;
import bl.entities.builder.objects.ModeloNave;
import bl.entities.factory.gestor.GestorFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

public class ControladorMMC {
    @FXML
    TableView<MarcaNave> listaMarcas;
    @FXML
    TableColumn<MarcaNave,String> tNombreMarca;
    @FXML
    public ObservableList<MarcaNave> observableMarcas;
    public TextField marcaTF;
    @FXML
    TableView<ModeloNave> listaModelos;
    @FXML
    TableColumn<ModeloNave,String> tNombreModelo;
    @FXML
    public ObservableList<ModeloNave> observableModelos;
    public TextField modeloTF;
    @FXML
    TableView<CategoriaNave> listaCategorias;
    @FXML
    TableColumn<CategoriaNave,String> tNombreCategoria;
    @FXML
    public ObservableList<CategoriaNave> observableCategorias;
    public TextField categoriaTF;
    private GestorBuilder gestorBuilder = new GestorBuilder();

    public void registrarMarca(ActionEvent actionEvent) {
        try {
            if(marcaTF.getText().isEmpty()){
                mostrarAlerta(Alert.AlertType.ERROR, "Hay campos obligatorios sin llenar", "Hay campos obligatorios sin llenar.\nPor favor llene todos los campos obligatorios.");
            } else {
                int resultado = gestorBuilder.registrarMarcaNave(marcaTF.getText());
                if(resultado == 0) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Marca registrada con éxito", "La marca ha sido registrada exitosamente");
                    marcaTF.setText("");
                    cargarListaMarcas();
                } else {
                    mostrarAlerta(Alert.AlertType.ERROR, "Marca ya existe", "La marca no ha sido registrada porque ya existe una marca con ese nombre.");
                }
            }
        }
        catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error en el registro de la marca", "Ha ocurrido un error en el registro de la marca,\npor favor inténtelo de nuevo.");
        }
    }

    /**
     * Metodo para actualizar el TableView de las marcas
     */
    public void cargarListaMarcas() {
        try {
            listaMarcas.getItems().clear();
            observableMarcas = FXCollections.observableArrayList();
            gestorBuilder.listarMarcas().forEach(marca -> observableMarcas.addAll(marca));
            observableMarcas = FXCollections.observableArrayList(gestorBuilder.listarMarcas());
            tNombreMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreMarca() + ""));
            listaMarcas.setItems(observableMarcas);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void registrarModelo(ActionEvent actionEvent) {
        try {
            if(modeloTF.getText().isEmpty()){
                mostrarAlerta(Alert.AlertType.ERROR, "Hay campos obligatorios sin llenar", "Hay campos obligatorios sin llenar.\nPor favor llene todos los campos obligatorios.");
            } else {
                int resultado = gestorBuilder.registrarModeloNave(modeloTF.getText());
                if(resultado == 0) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Modelo registrado con éxito", "El modelo ha sido registrado exitosamente");
                    modeloTF.setText("");
                    cargarListaModelos();
                } else {
                    mostrarAlerta(Alert.AlertType.ERROR, "Modelo ya existe", "El modelo no ha sido registrado porque ya existe un modelo con ese nombre.");
                }
            }
        }
        catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error en el registro del modelo", "Ha ocurrido un error en el registro del modelo,\npor favor inténtelo de nuevo.");
        }
    }

    /**
     * Metodo para actualizar el TableView de los modelos
     */
    public void cargarListaModelos() {
        try {
            listaModelos.getItems().clear();
            observableModelos = FXCollections.observableArrayList();
            gestorBuilder.listarModelos().forEach(modelo -> observableModelos.addAll(modelo));
            observableModelos = FXCollections.observableArrayList(gestorBuilder.listarModelos());
            tNombreModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreModelo() + ""));
            listaModelos.setItems(observableModelos);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void registrarCategoria(ActionEvent actionEvent) {
        try {
            if(categoriaTF.getText().isEmpty()){
                mostrarAlerta(Alert.AlertType.ERROR, "Hay campos obligatorios sin llenar", "Hay campos obligatorios sin llenar.\nPor favor llene todos los campos obligatorios.");
            } else {
                int resultado = gestorBuilder.registrarCategoriaNave(categoriaTF.getText());
                if(resultado == 0) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Categoría registrada con éxito", "La categoría ha sido registrada exitosamente");
                    categoriaTF.setText("");
                    cargarListaCategorias();
                } else {
                    mostrarAlerta(Alert.AlertType.ERROR, "Categoría ya existe", "La categoría no ha sido registrada porque ya existe una categoría con ese nombre.");
                }
            }
        }
        catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error en el registro de la categoria", "Ha ocurrido un error en el registro de la categoría,\npor favor inténtelo de nuevo.");
        }
    }

    /**
     * Metodo para actualizar el TableView de las categorias
     */
    public void cargarListaCategorias() {
        try {
            listaCategorias.getItems().clear();
            observableCategorias = FXCollections.observableArrayList();
            gestorBuilder.listarCategorias().forEach(categoria -> observableCategorias.addAll(categoria));
            observableCategorias = FXCollections.observableArrayList(gestorBuilder.listarCategorias());
            tNombreCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCategoria() + ""));
            listaCategorias.setItems(observableCategorias);
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

    public void initialize() {
        cargarListaMarcas();
        cargarListaModelos();
        cargarListaCategorias();
    }

}
