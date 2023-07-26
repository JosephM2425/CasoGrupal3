package bl.entities.factory.creator;
import bl.entities.factory.objects.*;
import bl.entities.factory.product.Repuesto;
public interface Metodo_Fabrica_Abstracta {
    Repuesto crearRepuesto(int idRepuesto, TipoRepuesto tipoRepuesto, String nombre, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto);

    Repuesto crearRepuesto(TipoRepuesto tipoRepuesto, String nombre, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto);

    Repuesto crearRepuesto();
}
