package creador;
import Enum.*;
import producto.Repuesto;
public interface Metodo_Fabrica_Abstracta {
    public Repuesto crearRepuesto(TipoRepuestoEnum tipoRepuesto, String descripcion, String categoria, float precio, MarcaEnum marcaRepuesto);
}
