package bl.DAO;

import bl.config.Configuracion;
import bl.entities.factory.objects.MarcaRepuesto;
import java.sql.*;
import java.util.ArrayList;
public class MarcaRepuestoDAO {
    public void insertarMarcaRepuesto(MarcaRepuesto tmpMarcaRepuesto) {
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "INSERT INTO HnI_MarcaRespuesto (Marca) VALUES(?)";
            stmt = getPreparedStatement(tmpMarcaRepuesto, strConexion, query);
            stmt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<MarcaRepuesto> listarMarcas(){
        ArrayList<MarcaRepuesto> marcasRepuesto = new ArrayList<>();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            String query = "SELECT * FROM HnI_MarcaRespuesto";
            Statement stmt;
            ResultSet rs;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                MarcaRepuesto tmpMarcaRepuesto = new MarcaRepuesto();
                tmpMarcaRepuesto.setIdMarcaRepuesto(rs.getInt("idTipoRepuesto"));
                tmpMarcaRepuesto.setMarca(rs.getString("Marca"));
                marcasRepuesto.add(tmpMarcaRepuesto);
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return marcasRepuesto;
    }
    public void actualizarMarcaRepuesto(MarcaRepuesto tmpMarcaRepuesto){
        Configuracion configuracion = new Configuracion();
        try {
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE HnI_MarcaRespuesto SET Marca=? WHERE idTipoRepuesto=?";
            stmt = getPreparedStatement(tmpMarcaRepuesto, strConexion, query);
            stmt.setInt(2, tmpMarcaRepuesto.getIdMarcaRepuesto());
            stmt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void eliminarMarcaRepuesto(MarcaRepuesto tmpMarcaRepuesto){
        Configuracion configuracion = new Configuracion();
        try {
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM HnI_MarcaRespuesto WHERE idTipoRepuesto=?";
            stmt = getPreparedStatement(tmpMarcaRepuesto, strConexion, query);
            stmt.setInt(1, tmpMarcaRepuesto.getIdMarcaRepuesto());
            stmt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public MarcaRepuesto obtenerMarcaRepuesto(int id_MarcaRepuesto){
        MarcaRepuesto tmpMarcaRepuesto = new MarcaRepuesto();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            String query = "SELECT * FROM HnI_MarcaRespuesto WHERE idTipoRepuesto=?";
            Statement stmt;
            ResultSet rs;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                tmpMarcaRepuesto.setIdMarcaRepuesto(rs.getInt("idTipoRepuesto"));
                tmpMarcaRepuesto.setMarca(rs.getString("Marca"));
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tmpMarcaRepuesto;
    }


    private PreparedStatement getPreparedStatement(MarcaRepuesto tmpMarcaRepuesto, String strConexion, String query) throws SQLException {
        Connection conn;
        PreparedStatement stmt;
        conn = DriverManager.getConnection(strConexion);
        stmt = conn.prepareStatement(query);
        stmt.setString(1, tmpMarcaRepuesto.getMarca());
        return stmt;
    }
}
