package bl.entities.factory.concrete_Creator;

import bl.entities.factory.concrete_Product.*;
import bl.entities.factory.creator.Metodo_Fabrica_Abstracta;
import bl.entities.factory.objects.*;
import bl.entities.factory.product.Repuesto;

public class Fabrica_Repuestos implements Metodo_Fabrica_Abstracta {
    @Override
    public Repuesto crearRepuesto(int id_Repuesto, TipoRepuesto tipoRepuesto, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto) {
        String tipo = tipoRepuesto.getTipoRepuesto();
        return switch (tipo) {
            case "MOTOR" -> new Motor(id_Repuesto,tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case "VOLANTE" -> new Volante(id_Repuesto,tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case "PUERTA" -> new Puerta(id_Repuesto,tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case "ASIENTO" -> new Asiento(id_Repuesto,tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case "PARABRISAS" -> new Parabrisas(id_Repuesto,tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            default -> null;
        };
    }
    @Override
    public Repuesto crearRepuesto(TipoRepuesto tipoRepuesto, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto) {
        String tipo = tipoRepuesto.getTipoRepuesto();
        return switch (tipo) {
            case "MOTOR" -> new Motor(tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case "VOLANTE" -> new Volante(tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case "PUERTA" -> new Puerta(tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case "ASIENTO" -> new Asiento(tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            case "PARABRISAS" -> new Parabrisas(tipoRepuesto, descripcion, categoria, precio, marcaRepuesto);
            default -> null;
        };
    }

    @Override
    public Repuesto crearRepuesto() {
        return null;
    }

}
