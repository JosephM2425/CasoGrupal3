package bl.entities.factory.concrete_Product;
import bl.entities.factory.objects.*;
import bl.entities.factory.product.Repuesto;

public class Asiento extends Repuesto{
    public Asiento(int id_Repuesto, TipoRepuesto tipoRepuesto,  String nombre, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto) {
        setId_Repuesto(id_Repuesto);
        setTipoRepuesto(tipoRepuesto);
        setNombre(nombre);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }
    public Asiento(TipoRepuesto tipoRepuesto, String nombre, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto) {
        setTipoRepuesto(tipoRepuesto);
        setNombre("Asiento " + marcaRepuesto.getMarca() + " " + nombre);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }
}
