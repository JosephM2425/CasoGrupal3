package bl.entities.builder.gestor;

import bl.DAO.UsuarioDAO;
import bl.entities.builder.builders.UsuarioBuilder;
import bl.entities.builder.directores.Director;
import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Usuario;
import bl.entities.builder.objects.Vendedor;

import java.util.ArrayList;

public class GestorBuilder {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Director director = new Director();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public GestorBuilder() {
        this.usuarios = usuarioDAO.listarUsuarios();
    }

    public void construccionUsuarios(String rol, String nombre, String apellido1, String apellido2, String numeroTelefonico) {
        director.setBuilder(new UsuarioBuilder());
        nuevoUsuario(rol, nombre, apellido1, apellido2, numeroTelefonico);
    }

    private void nuevoUsuario(String rol, String nombre, String apellido1, String apellido2, String numeroTelefonico) {
        director.construirUsuario(rol, nombre, apellido1, apellido2, numeroTelefonico);
        anadirUsuario(director.getBuilder().getUsuario());
    }

    private void anadirUsuario(Usuario usuario) {
        int resultado = usuarioDAO.registrarUsuario(usuario);
    }

    public Cliente obtenerCliente(int id) {
        for(Usuario usuario : usuarios) {
            if(usuario.getId() == id && usuario.getRol().equals("Cliente")) {
                Cliente cliente = (Cliente) usuario;
                return cliente;
            }
        }
        return null;
    }

    public Vendedor obtenerVendedor(int id) {
        for(Usuario usuario : usuarios) {
            if(usuario.getId() == id && usuario.getRol().equals("Vendedor")) {
                Vendedor vendedor = (Vendedor) usuario;
                return vendedor;
            }
        }
        return null;
    }

    public ArrayList<Usuario> listarUsuarios(int tipo) {
        usuarios = usuarioDAO.listarUsuarios(tipo);
        return usuarios;
    }

    public String mostrarUsuarios() {
        usuarios = usuarioDAO.listarUsuarios(1);

        String Usuarios = "Usuarios: \n";

        for(Usuario usuario : usuarios) {
            Usuarios += "ID: " + usuario.getId() + "\n"
                    + "Nombre: " + usuario.getNombre() + "\n"
                    + "Apellido 1: " + usuario.getApellido1() + "\n"
                    + "Apellido 2: " + usuario.getApellido2() + "\n"
                    + "Numero Telefonico: " + usuario.getNumeroTelefonico() + "\n"
                    + "Rol: " + usuario.getRol() + "\n";
        }
        return Usuarios;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}