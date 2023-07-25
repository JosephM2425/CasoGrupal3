package ui;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class ListaProformas {

    public TextField txtIdProforma;


    public void accederProforma(ActionEvent actionEvent) {
        String idProforma = txtIdProforma.getText();
    }
}
