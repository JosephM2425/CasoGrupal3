package bl.DAO;

import bl.config.Conexion;
import bl.config.Configuracion;
import bl.entities.factory.objects.TipoRepuesto;

import java.sql.*;
import java.util.ArrayList;
public class TipoRepuestoDAO {
    public void insertarTipoRepuesto(TipoRepuesto tmpTipoRepuesto){
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "INSERT INTO HnI_TipoRepuesto (Tipo) VALUES (?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tmpTipoRepuesto.getTipoRepuesto());
            stmt.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TipoRepuesto> listarTipos(){
        ArrayList<TipoRepuesto> tiposRepuesto = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_TipoRepuesto";
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                TipoRepuesto tmpTipoRepuesto = new TipoRepuesto();
                tmpTipoRepuesto.setIdTipoRepuesto(rs.getInt("idTipoRepuesto"));
                tmpTipoRepuesto.setTipoRepuesto(rs.getString("Tipo"));
                tiposRepuesto.add(tmpTipoRepuesto);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tiposRepuesto;
    }

    public void actualizarTipoRepuesto(TipoRepuesto tmpTipoRepuesto){
        Configuracion configuracion = new Configuracion();
        try {
            Conexion con = new Conexion();
            String query = "UPDATE HnI_TipoRepuesto SET Tipo=? WHERE idTipoRepuesto=?";
            PreparedStatement stmt;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tmpTipoRepuesto.getTipoRepuesto());
            stmt.setInt(2, tmpTipoRepuesto.getIdTipoRepuesto());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarTipoRepuesto(TipoRepuesto tmpTipoRepuesto){
        try {
            Conexion con = new Conexion();
            String query = "DELETE FROM HnI_TipoRepuesto WHERE idTipoRepuesto=?";
            PreparedStatement stmt;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, tmpTipoRepuesto.getIdTipoRepuesto());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public TipoRepuesto obtenerTipoRepuesto(int idTipoRepuesto){
        TipoRepuesto tmpTipoRepuesto = new TipoRepuesto();
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            String query = "SELECT * FROM HnI_TipoRepuesto WHERE idTipoRepuesto=?";
            PreparedStatement stmt;
            ResultSet rs;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idTipoRepuesto);
            rs = stmt.executeQuery();
            while (rs.next()) {
                tmpTipoRepuesto.setIdTipoRepuesto(rs.getInt("idTipoRepuesto"));
                tmpTipoRepuesto.setTipoRepuesto(rs.getString("Tipo"));
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tmpTipoRepuesto;
    }
}
