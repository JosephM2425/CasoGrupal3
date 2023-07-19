package producto_Concreto;
import Enum.*;
import producto.Repuesto;

public class Volante extends Repuesto{
    public Volante(TipoRepuestoEnum tipoRepuesto, String descripcion, String categoria, float precio, MarcaEnum marcaRepuesto) {
        setTipoRepuesto(tipoRepuesto);
        setNombre("Volante "+ marcaRepuesto);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }
}
