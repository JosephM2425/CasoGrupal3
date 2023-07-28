package bl.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //Atributos
    private static Connection conn;
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "CenfoAjss0497";
    private static final String url = "jdbc:mysql://localhost:3306/bisoft12?serverTimezone=UTC";

    //Constructores
    public Conexion() {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                //System.out.println("Conexión establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar" + e);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void Desconectar() {
        conn = null;
        if (conn == null) {
            //System.out.println("Conexión terminada");
        }
    }
}