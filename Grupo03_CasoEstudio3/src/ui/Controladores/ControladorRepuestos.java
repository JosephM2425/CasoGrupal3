package ui.Controladores;

import bl.entities.composite.components.Proforma;
import bl.entities.factory.concrete_Creator.Fabrica_Repuestos;
import bl.entities.factory.objects.MarcaRepuesto;
import bl.entities.factory.objects.TipoRepuesto;
import bl.entities.factory.product.Repuesto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import bl.entities.factory.gestor.GestorFactory;
import javafx.util.Callback;

public class ControladorRepuestos {
    @FXML
    TableView<Repuesto> listaRepuestos;
    @FXML
    TableColumn<Repuesto,String> tNombre;
    @FXML
    TableColumn<Repuesto,String> tTipo;
    @FXML
    TableColumn<Repuesto,String> tCategoria;
    @FXML
    TableColumn<Repuesto,String> tMarca;
    @FXML
    TableColumn<Repuesto,String> tPrecio;
    @FXML
    public ObservableList<Repuesto> observableRepuestos;
    public TextField nombreTF;
    public TextField descripcionTF;
    public TextField precioTF;
    public ComboBox<TipoRepuesto> tipoRepuestoCB;
    public ComboBox<MarcaRepuesto> marcaRepuestoCB;
    public ComboBox<String> categoriaCB;

    private final Fabrica_Repuestos fabric = new Fabrica_Repuestos();
    public ObservableList<TipoRepuesto> observableTiposRepuesto;
    public ObservableList<MarcaRepuesto> observableMarcasRepuesto;
    private GestorFactory gestorFactory = new GestorFactory();


    /**
     * Metodo para actualizar los ComboBoxes
     */
    public void cargarComboBoxes () {
        try {
            observableTiposRepuesto = FXCollections.observableArrayList(gestorFactory.listarTiposRepuesto());
            tipoRepuestoCB.setItems(observableTiposRepuesto);
            observableMarcasRepuesto = FXCollections.observableArrayList(gestorFactory.listarMarcasRepuesto());
            marcaRepuestoCB.setItems(observableMarcasRepuesto);

            Callback<ListView<MarcaRepuesto>, ListCell<MarcaRepuesto>> cellFactory = new Callback<>() {
                @Override
                public ListCell<MarcaRepuesto> call(ListView<MarcaRepuesto> l) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(MarcaRepuesto item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item == null || empty) {
                                setGraphic(null);
                            } else {
                                setText(item.getMarca());
                            }
                        }
                    };
                }
            };

            marcaRepuestoCB.setButtonCell(cellFactory.call(null));
            marcaRepuestoCB.setCellFactory(cellFactory);

            Callback<ListView<TipoRepuesto>, ListCell<TipoRepuesto>> cellFactory1 = new Callback<>() {
                @Override
                public ListCell<TipoRepuesto> call(ListView<TipoRepuesto> l) {
                    return new ListCell<>() {
                        @Override
                        protected void updateItem(TipoRepuesto item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item == null || empty) {
                                setGraphic(null);
                            } else {
                                setText(item.getTipoRepuesto());
                            }
                        }
                    };
                }
            };

            tipoRepuestoCB.setButtonCell(cellFactory1.call(null));
            tipoRepuestoCB.setCellFactory(cellFactory1);

            categoriaCB.getItems().removeAll(categoriaCB.getItems());
            categoriaCB.getItems().addAll("Gama baja", "Gama media", "Gama alta", "Gama de lujo");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void registrarRepuesto(ActionEvent actionEvent) {
        try {
            if(nombreTF.getText().isEmpty()|| descripcionTF.getText().isEmpty() || categoriaCB.getValue() == null || precioTF.getText().isEmpty() || tipoRepuestoCB.getValue() == null || marcaRepuestoCB.getValue() == null){
                mostrarAlerta(Alert.AlertType.ERROR, "Hay campos obligatorios sin llenar", "Hay campos obligatorios sin llenar.\nPor favor llene todos los campos obligatorios.");
            } else {
                GestorFactory gestorFactory = new GestorFactory();
                Repuesto repuesto = fabric.crearRepuesto(tipoRepuestoCB.getValue(), nombreTF.getText(), descripcionTF.getText(), categoriaCB.getValue(), Float.parseFloat(precioTF.getText()), marcaRepuestoCB.getValue());
                gestorFactory.insertarRepuesto(repuesto);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Repuesto creado!", "El repuesto ha sido creado exitosamente");
            }
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "El campo sólo acepta valores numéricos.", "El campo precio solo acepta valores numéricos.");
        }
        catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error en el registro de repuesto", "Ha ocurrido un error en el registro del repuesto,\npor favor inténtelo de nuevo.");
        }
    }

    /**
     * Metodo para actualizar el TableView de las repuestos
     */
    public void cargarListaRepuestos() {
        try {
            listaRepuestos.getItems().clear();
            observableRepuestos = FXCollections.observableArrayList();
            gestorFactory.listarRepuestos().forEach(repuesto -> observableRepuestos.addAll(repuesto));
            observableRepuestos = FXCollections.observableArrayList(gestorFactory.listarRepuestos());
            tNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre() + ""));
            tTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoRepuesto().getTipoRepuesto() + ""));
            tCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria() + ""));
            tMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarcaRepuesto().getMarca() + ""));
            tPrecio.setCellValueFactory(cellData -> new SimpleStringProperty("$" + cellData.getValue().getPrecio() + ""));
            listaRepuestos.setItems(observableRepuestos);
            cargarComboBoxes();
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
        cargarComboBoxes();
        cargarListaRepuestos();
    }

}
