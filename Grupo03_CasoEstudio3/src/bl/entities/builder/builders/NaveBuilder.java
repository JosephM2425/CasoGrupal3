package bl.entities.builder.builders;

import bl.entities.builder.objects.*;

public class NaveBuilder extends NaveAbstractBuilder{
    @Override
    public void crearNuevaNave() {
        this.nave = new Nave();
    }

    @Override
    public void agregarId(int id) {
        this.nave.setIdNave(id);
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        this.nave.setUsuario(usuario);
    }

    @Override
    public void agregarCategoria(CategoriaNave categoriaNave) {
        this.nave.setCategoriaNave(categoriaNave);
    }

    @Override
    public void agregarMarcaModelo(MarcaModeloNave marcaModeloNave) {
        this.nave.setMarcaModeloNave(marcaModeloNave);
    }

    @Override
    public void agregarCodigoIdentificacion(String codigoIdentificacion) {
        this.nave.setCodigoIdentificacion(codigoIdentificacion);
    }

    @Override
    public void agregarColor(String color) {
        this.nave.setColor(color);
    }
}
