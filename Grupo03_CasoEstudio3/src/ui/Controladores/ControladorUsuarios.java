package ui.Controladores;

import bl.entities.builder.gestor.GestorBuilder;
import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Usuario;
import bl.entities.builder.objects.Vendedor;
import bl.entities.composite.gestor.CompositeGestor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 23/07/2023
 *
 * Esta clase se encarga de gestionar el formulario FXML de Usuarios
 */
public class ControladorUsuarios {
    @FXML
    TableView<Usuario> listaUsuarios;
    @FXML
    TableColumn<Usuario,String> tNombre;
    @FXML
    TableColumn<Usuario,String> tApellidos;
    @FXML
    TableColumn<Usuario,String> tTelefono;
    @FXML
    TableColumn<Usuario,String> tTipoUsuario;

    public TextField nombreTF;
    public TextField apellido1TF;
    public TextField apellido2TF;
    public TextField telefonoTF;
    @FXML
    public RadioButton clienteRB;
    @FXML
    public RadioButton vendedorRB;
    @FXML
    public ObservableList<Usuario> observableUsuarios;
    @FXML
    public ObservableList<Usuario> observableClientes;
    @FXML
    public ObservableList<Usuario> observableVendedores;
    private GestorBuilder gestorBuilder = new GestorBuilder();

    /**
     * Metodo para inicializar el ObservableList y el TableView
     */
    @FXML
    public void initialize() {
        try {
            cargarListaUsuarios();
        } catch (Exception e) {
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
     * Metodo para resetear los valores dem los TextField
     */
    public void resetearValores() {
        nombreTF.setText("");
        apellido1TF.setText("");
        apellido2TF.setText("");
        telefonoTF.setText("");
        clienteRB.setSelected(false);
        vendedorRB.setSelected(false);
    }

    /**
     * Metodo para registrar una usuario
     * @param actionEvent es de tipo ActionEvent representa algun tipo de accion realizada
     */
    public void registrarUsuario(ActionEvent actionEvent) {
        try {
            if (nombreTF.getText().isEmpty() || apellido1TF.getText().isEmpty() || apellido2TF.getText().isEmpty() || telefonoTF.getText().isEmpty() || (!clienteRB.isSelected() && !vendedorRB.isSelected())) {
                mostrarAlerta(Alert.AlertType.ERROR, "Hay campos obligatorios sin llenar", "Hay campos obligatorios sin llenar.\nPor favor llene todos los campos obligatorios.");
            } else {
                int resultado = gestorBuilder.construccionUsuarios(clienteRB.isSelected() ? "Cliente" : "Vendedor", nombreTF.getText(), apellido1TF.getText(), apellido2TF.getText(), telefonoTF.getText());
                if(resultado == 0) {
                    mostrarAlerta(Alert.AlertType.INFORMATION, "Registro de usuario exitoso", "El usuario se ha registrado correctamente.");
                    resetearValores();
                    cargarListaUsuarios();
                }
                else {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error en el registro de usuario", "Ha ocurrido un error en el registro del usuario,\npor favor inténtelo de nuevo.");
                }
            }
        } catch (Exception e){
            mostrarAlerta(Alert.AlertType.ERROR,"Error.","Ha ocurrido un error, por favor inténtelo de nuevo.");
        }
    }

    /**
     * Metodo para actualizar el TableView de las usuarios
     */
    public void cargarListaUsuarios() {
        try {
            listaUsuarios.getItems().clear();
            observableUsuarios = FXCollections.observableArrayList();
            gestorBuilder.listarUsuarios().forEach(usuario -> observableUsuarios.addAll(usuario));
            observableUsuarios = FXCollections.observableArrayList(gestorBuilder.listarUsuarios());
            tNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre() + ""));
            tApellidos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido1() + " " + cellData.getValue().getApellido2()));
            tTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroTelefonico() + ""));
            tTipoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRol() + ""));
            listaUsuarios.setItems(observableUsuarios);
        } catch (Exception e){
            e.printStackTrace();
            //mostrarAlerta(Alert.AlertType.ERROR,"Error.","Ha ocurrido un error, por favor inténtelo de nuevo.");
        }
    }
}
