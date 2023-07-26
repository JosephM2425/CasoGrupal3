import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


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
    /*****************************************************************
     * Funcion:		QueryPrueba
     * Descripcion: Construye una consulta SQL de prueba basada en
     * 				un código de grupo.
     *
     * @param CodigoGrupo el código de grupo a buscar en la consulta
     * @return la consulta SQL generada
     ******************************************************************/
}