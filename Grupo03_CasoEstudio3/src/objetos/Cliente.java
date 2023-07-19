package objetos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String numeroTelefonico;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private List<Nave> listaNaves;

    public Cliente(String numeroTelefonico, String nombre, String apellido1, String apellido2, List<Nave> listaNaves) {
        this.numeroTelefonico = numeroTelefonico;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.listaNaves = listaNaves;
    }

    public Cliente(){}

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public List<Nave> getListaNaves() {
        return listaNaves;
    }

    public void setListaNaves(List<Nave> listaNaves) {
        this.listaNaves = listaNaves;
    }
}

