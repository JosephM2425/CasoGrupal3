package bl.entities.composite.components;

import bl.entities.composite.base.iComponente;
import bl.entities.factory.product.Repuesto;

import java.util.Objects;

public class Detalle extends iComponente{
    //Atributos
    private int idProforma;
    private Repuesto repuesto;
    private RazonRechazo razonRechazo;
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
     * @param razonRechazo es de tipo RazonRechazo y corresponde a la razon de rechazo
     * @param estado es de tipo String y corresponde al estado del detalle de la proforma
     */
    public Detalle(int id, int idProforma, Repuesto repuesto, RazonRechazo razonRechazo, String estado) {
        super(id);
        this.idProforma = idProforma;
        this.repuesto = repuesto;
        this.razonRechazo = razonRechazo;
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

    public RazonRechazo getRazonRechazo() {
        return razonRechazo;
    }

    public void setRazonRechazo(RazonRechazo razonRechazo) {
        this.razonRechazo = razonRechazo;
    }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    //Implementacion de metodos
    @Override
    public void agregarComponente(iComponente composicion) {
        this.razonRechazo = (RazonRechazo) composicion;
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
