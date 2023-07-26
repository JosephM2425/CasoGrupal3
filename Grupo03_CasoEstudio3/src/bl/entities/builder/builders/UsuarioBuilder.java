package bl.entities.builder.builders;

import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Vendedor;

public class UsuarioBuilder extends UsuarioAbstractBuilder{
    @Override
    public void crearNuevoUsuario(String rol) {
        switch (rol) {
            case "Cliente":
                this.usuario = new Cliente();
                break;
            case "Vendedor":
                this.usuario = new Vendedor();
                break;
            default:
                System.out.println("Rol no válido");
                break;
        }
    }

    @Override
    public void agregarId(int id) {
        this.usuario.setId(id);
    }

    @Override
    public void agregarNombre(String nombre) {
        this.usuario.setNombre(nombre);
    }

    @Override
    public void agregarApellido1(String apellido1) {
        this.usuario.setApellido1(apellido1);
    }

    @Override
    public void agregarApellido2(String apellido2) {
        this.usuario.setApellido2(apellido2);
    }

    @Override
    public void agregarNumeroTelefonico(String numeroTelefonico) {
        this.usuario.setNumeroTelefonico(numeroTelefonico);
    }

}
