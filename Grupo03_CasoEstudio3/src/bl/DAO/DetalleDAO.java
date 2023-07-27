package bl.DAO;

import java.sql.*;
import java.util.ArrayList;

import bl.config.Conexion;
import bl.entities.builder.objects.*;
import bl.entities.composite.base.iComponente;
import bl.entities.composite.components.Detalle;
import bl.entities.composite.components.Proforma;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 19/07/2023
 *
 * Esta clase se encarga de gestionar el acceso a datos de los objetos Detalle
 */
public class DetalleDAO {
    /**
     * Metodo para registrar un detalle
     * @param detalle es de tipo Detalle y corresponde al detalle por registrar
     * @return 0 si se registro correctamente ,1 si no se pudo registrar
     */
    public int registrarDetalle(Detalle detalle) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "INSERT INTO hni_detalleproforma (id_proforma, id_repuesto, estado) VALUES (?, ?, ?)";

            stmt = conn.prepareStatement(query);
            stmt.setInt(1,detalle.getId_proforma());
            stmt.setInt(2,detalle.getRepuesto().getId_Repuesto());
            stmt.setString(3,detalle.getEstado());
            stmt.execute();

            con.Desconectar();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    /**
     * Metodo para listar los detalles
     * @return un ArrayList con los detalles
     */
    public ArrayList<iComponente> listarDetalles()
    {
        ArrayList<iComponente> detalles = new ArrayList<iComponente>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM hni_detalleproforma";
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Detalle detalle = new Detalle();
                detalle.setId(rs.getInt("ID_DETALLE"));
                detalle.setId_proforma(rs.getInt("ID_PROFORMA"));
                detalle.setRepuesto(new RepuestoDAO().buscarRepuesto(rs.getInt("ID_REPUESTO")));
                detalle.setEstado(rs.getString("ESTADO"));
                detalles.add(detalle);

                con.Desconectar();
            }

        } catch (Exception e){
            return null;
        }
        return detalles;
    }

    /**
     * Metodo para listar los detalles
     * @return un ArrayList con los detalles
     */
    public ArrayList<iComponente> listarDetalles(int idProforma)
    {
        ArrayList<iComponente> detalles = new ArrayList<iComponente>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM hni_detalleproforma WHERE id_proforma = " + idProforma;
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Detalle detalle = new Detalle();
                detalle.setId(rs.getInt("ID_DETALLE"));
                detalle.setId_proforma(rs.getInt("ID_PROFORMA"));
                detalle.setRepuesto(new RepuestoDAO().buscarRepuesto(rs.getInt("ID_REPUESTO")));
                detalle.setEstado(rs.getString("ESTADO"));
                detalles.add(detalle);

                con.Desconectar();
            }

        } catch (Exception e){
            return null;
        }
        return detalles;
    }

    /**
     * Metodo para actualizar un detalle
     * @param detalle es de tipo Proforma y corresponde al detalle por actualizar
     * @return 0 si se actualizo correctamente ,1 si no se pudo registrar
     */
    public int actualizarDetalle(Detalle detalle) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "UPDATE hni_detalledetalle SET id_proforma = ?, id_repuesto = ?, id_razonRechazo = ?, estado= ?  WHERE id_detalle = ?";

            stmt = conn.prepareStatement(query);
            stmt.setInt(1, detalle.getId_proforma());
            stmt.setInt(2, detalle.getRepuesto().getId_Repuesto());
            stmt.setInt(3, detalle.getRazonRechazo().getId());
            stmt.setString(4, detalle.getEstado());
            stmt.setInt(5, detalle.getId());
            stmt.execute();

            con.Desconectar();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }
}

