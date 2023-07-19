package creador_Concreto;

import creador.Metodo_Fabrica_Abstracta;
import Enum.*;
import producto.Repuesto;
import producto_Concreto.*;

public class Fabrica_Repuestos implements Metodo_Fabrica_Abstracta {
    @Override
    public Repuesto crearRepuesto(TipoRepuestoEnum tipoRepuesto, String descripcion, String categoria, float precio, MarcaEnum marcaRepuesto) {
        return switch (tipoRepuesto) {
            case MOTOR -> new Motor(tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case VOLANTE -> new Volante(tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case PUERTA -> new Puerta(tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case ASIENTO -> new Asiento(tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case PARABRISAS -> new Parabrisas(tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            default -> null;
        };
    }
}
