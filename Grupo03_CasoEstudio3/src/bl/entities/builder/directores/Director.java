package bl.entities.builder.directores;

import bl.DAO.UsuarioDAO;
import bl.entities.builder.builders.UsuarioAbstractBuilder;
import bl.entities.builder.objects.Usuario;

import java.util.ArrayList;

public class Director {
    //Atributos
    private UsuarioAbstractBuilder builder;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();


    //Constructor
    public Director() {}

    //Getters y Setters
    public void setBuilder(UsuarioAbstractBuilder builder) {
        this.builder = builder;
    }

    public UsuarioAbstractBuilder getBuilder() {
        return builder;
    }

    //Metodos
    public void construirUsuario(String rol, String nombre, String apellido1, String apellido2, String numeroTelefonico) {
        builder.crearNuevoUsuario(rol);
        builder.agregarNombre(nombre);
        builder.agregarApellido1(apellido1);
        builder.agregarApellido2(apellido2);
        builder.agregarNumeroTelefonico(numeroTelefonico);
    }
}
