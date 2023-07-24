package bl.entities.composite.gestor;

import bl.DAO.DetalleDAO;
import bl.DAO.ProformaDAO;
import bl.entities.builder.gestor.GestorBuilder;
import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Vendedor;
import bl.entities.composite.base.iComponente;
import bl.entities.composite.components.Detalle;
import bl.entities.composite.components.Proforma;

import java.util.ArrayList;

public class CompositeGestor {
    //Atributos
    private ProformaDAO _ProformaDAO;
    private DetalleDAO _DetalleDAO;
    private GestorBuilder _GestorBuilder = new GestorBuilder();

    //Constructor
    public CompositeGestor() {
        _ProformaDAO = new ProformaDAO();
        _DetalleDAO = new DetalleDAO();
    }

    //Metodos

    public int nuevaProforma(Cliente cliente, Vendedor vendedor, String estado) {
        try {
            iComponente temp = null;
            temp = new Proforma(cliente, vendedor, estado);
            _ProformaDAO.registrarProforma((Proforma) temp);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public void nuevoDetalle(int idProforma, int idRepuesto, String estado) {
        iComponente temp = null;
        temp = new Detalle(idProforma, idRepuesto, estado);
        agregarDetalleProforma(temp.getId(), idProforma);
        _DetalleDAO.registrarDetalle((Detalle)temp);
    }

    public void agregarDetalleProforma(int idDetalle, int idProforma) {
        iComponente proforma = encontrarComponente(1, idProforma);
        iComponente detalle = encontrarComponente(2, idDetalle);

        if(proforma != null && detalle != null)
            proforma.agregarComponente(detalle);
    }

    private iComponente encontrarComponente(int tipo, int id) {
        ArrayList<iComponente> tempArr = null;

        switch(tipo) {
            case 1:
                tempArr = obtenerComponentes(1);
                break;
            case 2:
                tempArr = obtenerComponentes(2);
                break;
        }

        for (iComponente componente : tempArr) {
            if (componente.getId() == id) {
                return componente;
            }
        }
        return null;
    }

    public ArrayList<iComponente> obtenerComponentes(int tipo) {
        switch(tipo) {
            case 1:
                return _ProformaDAO.listarProformas();
            case 2:
                return _DetalleDAO.listarDetalles();
        }
        return null;
    }

    public ArrayList<Proforma> obtenerProformas() {
        ArrayList<Proforma> tempArr = new ArrayList<Proforma>();
        ArrayList<iComponente> tempArr2 = obtenerComponentes(1);

        for (iComponente item : tempArr2) {
            tempArr.add((Proforma) item);
        }
        return tempArr;
    }

    public String obtenerLista(int tipo) {
        String Mensaje = "";
        ArrayList<iComponente> tempArr = obtenerComponentes(tipo);

        if(tempArr != null) {
            for (iComponente item : tempArr)
                Mensaje += item.mostrarDatos() + "\n";
        }
        return Mensaje;
    }
}