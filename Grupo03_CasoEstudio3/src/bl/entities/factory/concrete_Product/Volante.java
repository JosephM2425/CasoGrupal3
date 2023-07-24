package bl.entities.factory.concrete_Product;
import bl.entities.factory.objects.*;
import bl.entities.factory.product.Repuesto;

public class Volante extends Repuesto{
    public Volante(int id_Repuesto, TipoRepuesto tipoRepuesto, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto) {
        setId_Repuesto(id_Repuesto);
        setTipoRepuesto(tipoRepuesto);
        setNombre("Volante "+ marcaRepuesto);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }
    public Volante(TipoRepuesto tipoRepuesto, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto) {
        setTipoRepuesto(tipoRepuesto);
        setNombre("Volante "+ marcaRepuesto);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }
}
