package producto_Concreto;
import Enum.*;
import producto.Repuesto;

public class Puerta extends Repuesto{
    public Puerta(TipoRepuestoEnum tipoRepuesto, String descripcion, String categoria, float precio, MarcaEnum marcaRepuesto) {
        setTipoRepuesto(tipoRepuesto);
        setNombre("Puerta "+ marcaRepuesto);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }
}
