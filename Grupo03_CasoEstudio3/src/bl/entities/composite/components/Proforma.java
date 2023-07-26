package bl.entities.composite.components;

import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Vendedor;
import bl.entities.composite.base.iComponente;
import bl.entities.state.State;

import java.util.ArrayList;
import java.util.Objects;

public class Proforma extends iComponente{
    private Cliente cliente;
    private Vendedor vendedor;
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
     * @param estado es de tipo String y corresponde al estado de la proforma
     */
    public Proforma(int id, Cliente cliente, Vendedor vendedor, String estado) {
        super(id);
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.estado = estado;
        this.listaDetalles = new ArrayList<iComponente>();
    }

    /**
     * Constructor con todos los atributos excepto el id de la proforma
     * @param cliente es de tipo Cliente y corresponde al cliente
     * @param vendedor es de tipo Vendedor y corresponde al vendedor
     * @param estado es de tipo String y corresponde al estado de la proforma
     */
    public Proforma(Cliente cliente, Vendedor vendedor, String estado) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.estado = estado;
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

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public ArrayList<iComponente> getListaComposicion() { return listaDetalles; }

    public void setListaComposicion(ArrayList<iComponente> listaDetalles) { this.listaDetalles = listaDetalles; }

    //Metodos

    /**
     * Agrega un detalle a la lista de detalles de la proforma
     * @param detalle es de tipo iComponente y corresponde al detalle de la proforma
     */
    @Override
    public void agregarComponente(iComponente detalle) {
        this.listaDetalles.add(detalle);
    }

    /**
     * Muestra los datos de la proforma
     * @return un String con los datos de la proforma
     */
    @Override
    public String mostrarDatos() {
        String mLin1="" , mLine2 = "";
        mLin1 = "Listando Proforma #" + this.getId() +
                ".\nCliente " + getCliente().getNombre() + " " + getCliente().getApellido1() + " " + getCliente().getApellido2() +
                ".\nVendedor " + getVendedor().getNombre() + " " + getVendedor().getApellido1() + " " + getVendedor().getApellido2() +
                ".\nEstado # " + getEstado() +
                ".\nDetalles:\n";
        if(listaDetalles == null || listaDetalles.isEmpty()){
            mLine2 = "No hay detalles en esta proforma.\n";
        } else {
            for (iComponente detalle : listaDetalles) {
                mLine2 += detalle.mostrarDatos() + "\n";
            }
        }

        return mLin1 + mLine2 +"\n";
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


    //Metodos del Patro State
    public void changeState(State state, String estado) {
        this.state = state;
        this.estado = estado;
    }
}
