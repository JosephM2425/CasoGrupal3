import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 300);
        stage.setScene(scene);
        stage.setTitle("CasoGrupal3");
        stage.show();
    }
}