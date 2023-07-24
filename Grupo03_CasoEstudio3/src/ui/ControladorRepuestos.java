package ui;

import bl.entities.factory.concrete_Creator.Fabrica_Repuestos;
import bl.entities.factory.objects.MarcaRepuesto;
import bl.entities.factory.objects.TipoRepuesto;
import bl.entities.factory.product.Repuesto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import bl.entities.factory.gestor.GestorFactory;
public class ControladorRepuestos {
    public ComboBox<TipoRepuesto> tipoRepuesto;
    public TextField nombre;
    public TextField descripcion;
    public TextField categoria;
    public TextField precio;
    public ComboBox<MarcaRepuesto> marcaRepuesto;
    private final Fabrica_Repuestos fabric = new Fabrica_Repuestos();
    public ObservableList<TipoRepuesto> tiposRepuesto;
    public ObservableList<MarcaRepuesto> marcasRepuesto;

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void crearRepuesto(ActionEvent ignoredActionEvent) {
        if (tipoRepuesto.getValue()==null) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el tipo de repuesto");
            return;
        }
        if (descripcion.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese la descripción del repuesto");
            return;
        }
        if (categoria.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese la categoría del repuesto");
            return;
        }
        if (precio.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese el precio del repuesto");
            return;
        }
        if (marcaRepuesto.getValue()==null) {
            showAlert(Alert.AlertType.ERROR, "Error de Formulario!", "Por favor ingrese la marca del repuesto");
            return;
        }
        GestorFactory gestorFactory = new GestorFactory();
        Repuesto repuesto = fabric.crearRepuesto(tipoRepuesto.getValue(), descripcion.getText(), categoria.getText(), Float.parseFloat(precio.getText()), marcaRepuesto.getValue());
        gestorFactory.insertarRepuesto(repuesto);
        showAlert(Alert.AlertType.INFORMATION, "Repuesto creado!", "El repuesto ha sido creado exitosamente");

    }

    public void initialize() {
        GestorFactory gestorFactory = new GestorFactory();
        tiposRepuesto = FXCollections.observableArrayList(gestorFactory.listarTiposRepuesto());
        marcasRepuesto = FXCollections.observableArrayList(gestorFactory.listarMarcasRepuesto());
        tipoRepuesto.setItems(tiposRepuesto);
        marcaRepuesto.setItems(marcasRepuesto);
    }

}
