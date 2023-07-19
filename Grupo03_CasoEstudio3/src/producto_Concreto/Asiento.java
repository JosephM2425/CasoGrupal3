package producto_Concreto;
import Enum.*;
import producto.Repuesto;

public class Asiento extends Repuesto{
    public Asiento(TipoRepuestoEnum tipoRepuesto, String descripcion, String categoria, float precio, MarcaEnum marcaRepuesto) {
        setTipoRepuesto(tipoRepuesto);
        setNombre("Asiento "+ marcaRepuesto);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }
}
