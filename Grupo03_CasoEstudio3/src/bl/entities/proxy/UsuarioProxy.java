package bl.entities.proxy;

import bl.entities.builder.objects.Usuario;

public class UsuarioProxy extends Usuario {
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean analizarRol() {
        String rol = this.usuario.getRol();
        if(rol.equals("Vendedor")) {
            return true;
        } else {
            return false;
        }
    }
}
