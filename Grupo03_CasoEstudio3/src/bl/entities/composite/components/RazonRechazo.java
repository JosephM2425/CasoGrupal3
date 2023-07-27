package bl.entities.composite.components;

import bl.entities.composite.base.iComponente;
import bl.entities.factory.product.Repuesto;

import java.util.Objects;

public class RazonRechazo extends iComponente{
    //Atributos
    private String descripcion;

    //Constructores
    /**
     * Constructor por defecto
     */
    public RazonRechazo() {
    }

    /**
     * Constructor con todos los atributos
     * @param id es de tipo int y corresponde al id del detalle de la proforma
     * @param descripcion es de tipo String y corresponde a la descripcion de la razon de rechazo

     */
    public RazonRechazo(int id, String descripcion) {
        super(id);
        this.descripcion = descripcion;
    }

    /**
     * Constructor con todos los atributos excepto el id de la razon de rechazo
     * @param descripcion es de tipo String y corresponde a la descripcion de la razon de rechazo
     */
    public RazonRechazo(String descripcion) {
        this.descripcion = descripcion;
    }

    //Getters y Setters


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Implementacion de metodos
    @Override
    public void agregarComponente(iComponente composicion) {
        System.out.println("Esta es una excepcion, función no implementada en razón de rechazo");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RazonRechazo detalle)) return false;
        return id == detalle.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
