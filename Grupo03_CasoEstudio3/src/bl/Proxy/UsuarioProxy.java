package bl.Proxy;

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
        String rol = usuario.getRol();
        if(rol == "Vendedor") {
            return true;
        } else {
            return false;
        }
    }


}
