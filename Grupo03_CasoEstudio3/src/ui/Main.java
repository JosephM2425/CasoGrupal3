package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/paginaPrincipal.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 600);
        Image icon = new Image("ui/rocket_icon.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setTitle("Cenfomazon");
        stage.show();
    }
}