package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class RegistroNavesController {

    @FXML
    TextField txtCategoria;
    @FXML
    TextField txtMarca;
    @FXML
    TextField txtModelo;
    @FXML
    TextField txtColor;
    @FXML
    TextField txtAno;
    @FXML
    TextField txtCodigoIdentificacion;
    @FXML
    Button btnCrearNave;

    public void crearNave(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

    }
}