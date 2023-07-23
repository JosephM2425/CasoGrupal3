package bl.entities.builder.builders;

import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Usuario;
import bl.entities.builder.objects.Vendedor;

public abstract class UsuarioAbstractBuilder {
    protected Usuario usuario;
    public Usuario getUsuario() {
        return this.usuario;	}

    //Metodos
    public abstract void crearNuevoUsuario(String rol);
    public abstract void agregarId(int id);
    public abstract void agregarNombre(String nombre);
    public abstract void agregarApellido1(String apellido1);
    public abstract void agregarApellido2(String apellido2);
    public abstract void agregarNumeroTelefonico(String numeroTelefonico);
}
