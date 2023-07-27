package bl.entities.composite.components;

import bl.entities.composite.base.iComponente;
import bl.entities.factory.product.Repuesto;

import java.util.Objects;

public class Detalle extends iComponente{
    //Atributos
    private int idProforma;
    private Repuesto repuesto;
    private int idRazonRechazo;
    private String estado;

    //Constructores
    /**
     * Constructor por defecto
     */
    public Detalle() {
    }

    /**
     * Constructor con todos los atributos
     * @param id es de tipo int y corresponde al id del detalle de la proforma
     * @param idProforma es de tipo int y corresponde al id de la proforma
     * @param repuesto es de tipo Repuesto y corresponde al repuesto
     * @param idRazonRechazo es de tipo int y corresponde al id de la razon de rechazo
     * @param estado es de tipo String y corresponde al estado del detalle de la proforma
     */
    public Detalle(int id, int idProforma, Repuesto repuesto, int idRazonRechazo, String estado) {
        super(id);
        this.idProforma = idProforma;
        this.repuesto = repuesto;
        this.idRazonRechazo = idRazonRechazo;
        this.estado = estado;
    }

    /**
     * Constructor con todos los atributos excepto el id de la razon de rechazo
     * @param id es de tipo int y corresponde al id del detalle de la proforma
     * @param idProforma es de tipo int y corresponde al id de la proforma
     * @param repuesto es de tipo Repuesto y corresponde al repuesto
     * @param estado es de tipo String y corresponde al estado del detalle de la proforma
     */
    public Detalle(int id, int idProforma, Repuesto repuesto, String estado) {
        super(id);
        this.idProforma = idProforma;
        this.repuesto = repuesto;
        this.estado = estado;
    }

    /**
     * Constructor con todos los atributos excepto el id del detalle de la proforma y el id de la razon de rechazo
     * @param idProforma es de tipo int y corresponde al id de la proforma
     * @param repuesto es de tipo Repuesto y corresponde al repuesto
     * @param estado es de tipo String y corresponde al estado del detalle de la proforma
     */
    public Detalle(int idProforma, Repuesto repuesto, String estado) {
        this.idProforma = idProforma;
        this.repuesto = repuesto;
        this.estado = estado;
    }

    //Getters y Setters
    public int getId_proforma() { return idProforma; }

    public void setId_proforma(int idProforma) { this.idProforma = idProforma; }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }

    public int getId_razonRechazo() { return idRazonRechazo; }

    public void setId_razonRechazo(int idRazonRechazo) { this.idRazonRechazo = idRazonRechazo; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    //Implementacion de metodos
    @Override
    public void agregarComponente(iComponente composicion) {
        System.out.println("Esta es una excepcion, función no implementada en Detalle");
    }

    @Override
    public String mostrarDatos() {
        return "Detalle #" + id +
                ". Proforma #" + idProforma +
                ". Repuesto #" + repuesto +
                ". Razón de rechazo: " + idRazonRechazo +
                ". Estado: " + estado + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Detalle detalle)) return false;
        return id == detalle.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
