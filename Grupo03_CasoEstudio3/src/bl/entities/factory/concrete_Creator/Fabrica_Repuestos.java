package bl.entities.factory.concrete_Creator;

import bl.entities.factory.concrete_Product.*;
import bl.entities.factory.creator.Metodo_Fabrica_Abstracta;
import bl.entities.factory.objects.*;
import bl.entities.factory.product.Repuesto;

public class Fabrica_Repuestos implements Metodo_Fabrica_Abstracta {
    @Override
    public Repuesto crearRepuesto(int id_Repuesto, TipoRepuesto tipoRepuesto, String nombre, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto) {
        String tipo = tipoRepuesto.getTipoRepuesto();
        return switch (tipo) {
            case "Motor" -> new Motor(id_Repuesto,tipoRepuesto, nombre, descripcion, categoria, precio, marcaRepuesto);
            case "Volante" -> new Volante(id_Repuesto,tipoRepuesto, nombre, descripcion, categoria, precio, marcaRepuesto);
            case "Puerta" -> new Puerta(id_Repuesto,tipoRepuesto, nombre, descripcion, categoria, precio, marcaRepuesto);
            case "Asiento" -> new Asiento(id_Repuesto,tipoRepuesto, nombre, descripcion, categoria, precio, marcaRepuesto);
            case "Parabrisas" -> new Parabrisas(id_Repuesto,tipoRepuesto, nombre, descripcion, categoria, precio, marcaRepuesto);
            default -> null;
        };
    }

    @Override
    public Repuesto crearRepuesto(TipoRepuesto tipoRepuesto, String nombre, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto) {
        String tipo = tipoRepuesto.getTipoRepuesto();
        return switch (tipo) {
            case "Motor" -> new Motor(tipoRepuesto, nombre, descripcion, categoria, precio, marcaRepuesto);
            case "Volante" -> new Volante(tipoRepuesto, nombre, descripcion, categoria, precio, marcaRepuesto);
            case "Puerta" -> new Puerta(tipoRepuesto, nombre, descripcion, categoria, precio, marcaRepuesto);
            case "Asiento" -> new Asiento(tipoRepuesto, nombre, descripcion, categoria, precio, marcaRepuesto);
            case "Parabrisas" -> new Parabrisas(tipoRepuesto, nombre, descripcion, categoria, precio, marcaRepuesto);
            default -> null;
        };
    }

    @Override
    public Repuesto crearRepuesto() {
        return null;
    }

}
