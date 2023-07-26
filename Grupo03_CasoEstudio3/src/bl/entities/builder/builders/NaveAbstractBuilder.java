package bl.entities.builder.builders;

import bl.entities.builder.objects.CategoriaNave;
import bl.entities.builder.objects.MarcaModeloNave;
import bl.entities.builder.objects.Nave;
import bl.entities.builder.objects.Usuario;

public abstract class NaveAbstractBuilder {
    //Atributos
    protected Nave nave;
    public Nave getNave() {
        return this.nave;	}

    //Metodos
    public abstract void crearNuevaNave();
    public abstract void agregarId(int id);
    public abstract void agregarUsuario(Usuario usuario);
    public abstract void agregarCategoria(CategoriaNave categoriaNave);
    public abstract void agregarMarcaModelo(MarcaModeloNave marcaModeloNave);
    public abstract void agregarCodigoIdentificacion(String codigoIdentificacion);
    public abstract void agregarColor(String color);

}
