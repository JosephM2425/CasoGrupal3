package producto_Concreto;
import Enum.*;
import producto.Repuesto;
public class Motor extends Repuesto{
    public Motor(TipoRepuestoEnum tipoRepuesto, String descripcion, String categoria, float precio, MarcaEnum marcaRepuesto) {
        setTipoRepuesto(tipoRepuesto);
        setNombre("Motor "+ marcaRepuesto);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }
}
