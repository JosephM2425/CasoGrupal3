package bl.entities.builder.directores;

import bl.DAO.UsuarioDAO;
import bl.entities.builder.builders.NaveAbstractBuilder;
import bl.entities.builder.builders.NaveBuilder;
import bl.entities.builder.builders.UsuarioAbstractBuilder;
import bl.entities.builder.builders.UsuarioBuilder;
import bl.entities.builder.objects.CategoriaNave;
import bl.entities.builder.objects.MarcaModeloNave;
import bl.entities.builder.objects.MarcaNave;
import bl.entities.builder.objects.Usuario;

import java.util.ArrayList;

public class Director {
    //Atributos
    private UsuarioAbstractBuilder builderUsuario;
    private NaveAbstractBuilder builderNave;

    //Constructor
    public Director() {
        this.builderUsuario = new UsuarioBuilder();
        this.builderNave = new NaveBuilder();
    }

    //Getters y Setters
    public void setUsuarioBuilder(UsuarioAbstractBuilder builder) {
        this.builderUsuario = builderUsuario;
    }

    public void setNaveBuilder(NaveAbstractBuilder builderNave) {
        this.builderNave = builderNave;
    }

    public UsuarioAbstractBuilder getUsuarioBuilder() {
        return builderUsuario;
    }

    public NaveAbstractBuilder getNaveBuilder() {
        return builderNave;
    }

    //Metodos
    public Usuario construirUsuario(int id, String rol, String nombre, String apellido1, String apellido2, String numeroTelefonico) {
        builderUsuario.crearNuevoUsuario(rol);
        builderUsuario.agregarId(id);
        builderUsuario.agregarNombre(nombre);
        builderUsuario.agregarApellido1(apellido1);
        builderUsuario.agregarApellido2(apellido2);
        builderUsuario.agregarNumeroTelefonico(numeroTelefonico);
        Usuario usuario = builderUsuario.getUsuario();
        return usuario;
    }

    public void construirUsuario(String rol, String nombre, String apellido1, String apellido2, String numeroTelefonico) {
        builderUsuario.crearNuevoUsuario(rol);
        builderUsuario.agregarNombre(nombre);
        builderUsuario.agregarApellido1(apellido1);
        builderUsuario.agregarApellido2(apellido2);
        builderUsuario.agregarNumeroTelefonico(numeroTelefonico);
    }

    public void construirNave(int id, Usuario usuario, CategoriaNave categoriaNave, MarcaModeloNave marcaModeloNave, String codigoIdentificacion, String color) {
        builderNave.crearNuevaNave();
        builderNave.agregarId(id);
        builderNave.agregarUsuario(usuario);
        builderNave.agregarCategoria(categoriaNave);
        builderNave.agregarMarcaModelo(marcaModeloNave);
        builderNave.agregarCodigoIdentificacion(codigoIdentificacion);
        builderNave.agregarColor(color);
    }

    public void construirNave(Usuario usuario, CategoriaNave categoriaNave, MarcaModeloNave marcaModeloNave, String codigoIdentificacion, String color) {
        builderNave.crearNuevaNave();
        builderNave.agregarUsuario(usuario);
        builderNave.agregarCategoria(categoriaNave);
        builderNave.agregarMarcaModelo(marcaModeloNave);
        builderNave.agregarCodigoIdentificacion(codigoIdentificacion);
        builderNave.agregarColor(color);
    }
}
