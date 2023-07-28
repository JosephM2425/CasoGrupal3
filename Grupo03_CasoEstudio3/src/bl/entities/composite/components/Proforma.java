package bl.entities.composite.components;

import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Nave;
import bl.entities.builder.objects.Vendedor;
import bl.entities.composite.base.iComponente;
import bl.entities.state.concreto.InProgressState;
import bl.entities.state.abstracto.State;
import bl.entities.state.concreto.PendingState;

import java.util.ArrayList;
import java.util.Objects;

public class Proforma extends iComponente{
    private Cliente cliente;
    private Vendedor vendedor;
    private Nave nave;
    private String estado;
    private State state;

    private ArrayList<iComponente> listaDetalles; //Contiene detalles de la proforma

    //Constructores
    /**
     * Constructor por defecto
     */
    public Proforma() {
        this.listaDetalles = new ArrayList<iComponente>();
    }

    /**
     * Constructor con todos los atributos
     * @param id es de tipo int y corresponde al id de la proforma
     * @param cliente es de tipo Cliente y corresponde al cliente
     * @param vendedor es de tipo Vendedor y corresponde al vendedor
     * @param nave es de tipo Nave y corresponde a la nave
     */
    public Proforma(int id, Cliente cliente, Vendedor vendedor, Nave nave) {
        super(id);
        setState(new InProgressState());
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.nave = nave;
        this.estado = state.obtenerEstado();
        this.listaDetalles = new ArrayList<iComponente>();
    }

    /**
     * Constructor con todos los atributos excepto el id de la proforma
     * @param cliente es de tipo Cliente y corresponde al cliente
     * @param vendedor es de tipo Vendedor y corresponde al vendedor
     * @param nave es de tipo Nave y corresponde a la nave
     */
    public Proforma(Cliente cliente, Vendedor vendedor, Nave nave) {
        setState(new PendingState());
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.nave = nave;
        this.estado = state.obtenerEstado();
        this.listaDetalles = new ArrayList<iComponente>();
    }

    //Getters y Setters


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public Nave getNave() {
        return nave;
    }
    public void setNave(Nave nave) {
        this.nave = nave;
    }
    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public ArrayList<iComponente> getListaComposicion() { return listaDetalles; }

    public void setListaComposicion(ArrayList<iComponente> listaDetalles) { this.listaDetalles = listaDetalles; }
    public void setState (State state){
        this.state = state;
    }
    public String getState() {
        return this.state.obtenerEstado();
    }
    //Metodos


    /**
     * Agrega un detalle a la lista de detalles de la proforma
     * @param detalle es de tipo iComponente y corresponde al detalle de la proforma
     */
    @Override
    public void agregarComponente(iComponente detalle) {
        this.listaDetalles.add(detalle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proforma proforma)) return false;
        return id == proforma.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



}
