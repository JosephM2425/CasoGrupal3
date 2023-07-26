package bl.entities.factory.concrete_Product;
import bl.entities.factory.objects.*;
import bl.entities.factory.product.Repuesto;

public class Parabrisas extends Repuesto{
    public Parabrisas(int id_Repuesto, TipoRepuesto tipoRepuesto,  String nombre, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto) {
        setId_Repuesto(id_Repuesto);
        setTipoRepuesto(tipoRepuesto);
        setNombre("Parabrisas "+ marcaRepuesto + marcaRepuesto.getMarca() + " " + nombre);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }
    public Parabrisas(TipoRepuesto tipoRepuesto,  String nombre, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto) {
        setTipoRepuesto(tipoRepuesto);
        setNombre("Parabrisas " + marcaRepuesto.getMarca() + " " + nombre);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }
}
