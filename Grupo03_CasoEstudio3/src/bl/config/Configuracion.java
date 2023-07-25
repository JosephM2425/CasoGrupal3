package bl.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    private String claseJDBC;
    private String stringConexion;

    public Configuracion() {
        leerConfig();
    }

    public Configuracion(String claseJDBC, String stringConexion) {
        this.claseJDBC = claseJDBC;
        this.stringConexion = stringConexion;
    }

    public String getClaseJDBC() {
        return claseJDBC;
    }

    public void setClaseJDBC(String claseJDBC) {
        this.claseJDBC = claseJDBC;
    }

    public String getStringConexion() {
        return stringConexion;
    }

    public void setStringConexion(String stringConexion) {
        this.stringConexion = stringConexion;
    }

    public void leerConfig(){
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\ui\\ControladorRepuestos.java");
            properties.load(fileInputStream);
            this.setClaseJDBC(properties.getProperty("claseJDBC"));
            this.setStringConexion(properties.getProperty("stringConexion"));
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo de propiedades, reinicie");
        } catch (IOException e) {
            System.out.println("No se ha podido cargar la base de datos, por favor reinicie");
        }
    }
}
