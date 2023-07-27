package bl.entities.composite.gestor;

import bl.DAO.DetalleDAO;
import bl.DAO.ProformaDAO;
import bl.entities.builder.gestor.GestorBuilder;
import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Nave;
import bl.entities.builder.objects.Vendedor;
import bl.entities.composite.base.iComponente;
import bl.entities.composite.components.Detalle;
import bl.entities.composite.components.Proforma;
import bl.entities.factory.product.Repuesto;

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

    public int nuevaProforma(Cliente cliente, Vendedor vendedor, Nave nave, String estado) {
        try {
            iComponente temp = null;
            temp = new Proforma(cliente, vendedor, nave, estado);
            _ProformaDAO.registrarProforma((Proforma) temp);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public int nuevoDetalle(int idProforma, Repuesto repuesto, String estado) {
        try {
            iComponente temp = null;
            temp = new Detalle(idProforma, repuesto, estado);
            agregarDetalleProforma(temp.getId(), idProforma);
            _DetalleDAO.registrarDetalle((Detalle) temp);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public void agregarDetalleProforma(int idDetalle, int idProforma) {
        iComponente proforma = encontrarComponente(1, idProforma);
        iComponente detalle = encontrarComponente(2, idDetalle);

        if (proforma != null && detalle != null)
            proforma.agregarComponente(detalle);
    }

    public int actualizarProforma(Proforma proforma) {
        try {
            iComponente temp = proforma;
            _ProformaDAO.actualizarProforma((Proforma) temp);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    public int actualizarDetalle(Detalle detalle) {
        try {
            iComponente temp = detalle;
            _DetalleDAO.actualizarDetalle((Detalle) temp);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    private iComponente encontrarComponente(int tipo, int id) {
        ArrayList<iComponente> tempArr = null;

        switch (tipo) {
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
        switch (tipo) {
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

    public ArrayList<Detalle> obtenerDetalles() {
        ArrayList<Detalle> tempArr = new ArrayList<Detalle>();
        ArrayList<iComponente> tempArr2 = obtenerComponentes(2);
        for (iComponente item : tempArr2) {
            tempArr.add((Detalle) item);
        }
        return tempArr;
    }

    public ArrayList<Detalle> obtenerDetalles(int idProforma) {
        ArrayList<Detalle> tempArr = new ArrayList<Detalle>();
        ArrayList<iComponente> tempArr2 = _DetalleDAO.listarDetalles(idProforma);
        for (iComponente item : tempArr2) {
            tempArr.add((Detalle) item);
        }
        return tempArr;
    }
}
