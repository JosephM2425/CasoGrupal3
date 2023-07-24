package bl.entities.factory.gestor;

import bl.DAO.*;
import bl.entities.factory.objects.MarcaRepuesto;
import bl.entities.factory.objects.TipoRepuesto;
import bl.entities.factory.product.Repuesto;

import java.util.ArrayList;


public class GestorFactory {
    private MarcaRepuestoDAO marcaRepuestoDAO;
    private TipoRepuestoDAO tipoRepuestoDAO;
    private RepuestoDAO repuestoDAO;

    public GestorFactory(){
        marcaRepuestoDAO = new MarcaRepuestoDAO();
        tipoRepuestoDAO = new TipoRepuestoDAO();
        repuestoDAO = new RepuestoDAO();
    }

    public void insertarMarcaRepuesto(MarcaRepuesto marcaRepuesto){
        marcaRepuestoDAO.insertarMarcaRepuesto(marcaRepuesto);
    }
    public void insertarTipoRepuesto(TipoRepuesto tipoRepuesto){
        tipoRepuestoDAO.insertarTipoRepuesto(tipoRepuesto);
    }
    public void insertarRepuesto(Repuesto repuesto){
        repuestoDAO.insertarRepuesto(repuesto);
    }


    public ArrayList<MarcaRepuesto>listarMarcasRepuesto(){
        return marcaRepuestoDAO.listarMarcas();
    }
    public ArrayList<TipoRepuesto>listarTiposRepuesto(){
        return tipoRepuestoDAO.listarTipos();
    }
    public ArrayList<Repuesto>listarRepuestos(){
        return repuestoDAO.listarRepuestos();
    }

    public void actualizarMarcaRepuesto(MarcaRepuesto marcaRepuesto){
        marcaRepuestoDAO.actualizarMarcaRepuesto(marcaRepuesto);
    }
    public void actualizarTipoRepuesto(TipoRepuesto tipoRepuesto){
        tipoRepuestoDAO.actualizarTipoRepuesto(tipoRepuesto);
    }
    public void actualizarRepuesto(Repuesto repuesto){
        repuestoDAO.actualizarRepuesto(repuesto);
    }


    public void eliminarMarcaRepuesto(MarcaRepuesto marcaRepuesto){
        marcaRepuestoDAO.eliminarMarcaRepuesto(marcaRepuesto);
    }
    public void eliminarTipoRepuesto(TipoRepuesto tipoRepuesto){
        tipoRepuestoDAO.eliminarTipoRepuesto(tipoRepuesto);
    }
    public void eliminarRepuesto(Repuesto repuesto){
        repuestoDAO.eliminarRepuesto(repuesto);
    }


    public void buscarMarcaRepuesto(int id_MarcaRepuesto){
        marcaRepuestoDAO.obtenerMarcaRepuesto(id_MarcaRepuesto);
    }
    public void buscarTipoRepuesto(int id_TipoRepuesto){
        tipoRepuestoDAO.obtenerTipoRepuesto(id_TipoRepuesto);
    }
    public void buscarRepuesto(int id_repuesto){
        repuestoDAO.buscarRepuesto(id_repuesto);
    }

}

