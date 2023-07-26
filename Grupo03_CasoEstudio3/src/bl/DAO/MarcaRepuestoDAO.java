package bl.DAO;

import bl.config.Conexion;
import bl.entities.factory.objects.MarcaRepuesto;
import java.sql.*;
import java.util.ArrayList;

public class MarcaRepuestoDAO {
    public void insertarMarcaRepuesto(MarcaRepuesto marcaRepuesto) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "INSERT INTO HnI_MarcaRespuesto (Marca) VALUES(?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, marcaRepuesto.getMarca());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<MarcaRepuesto> listarMarcas(){
        ArrayList<MarcaRepuesto> marcasRepuesto = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_MarcaRespuesto";
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                MarcaRepuesto tmpMarcaRepuesto = new MarcaRepuesto();
                tmpMarcaRepuesto.setIdMarcaRepuesto(rs.getInt("idMarcaRespuesto"));
                tmpMarcaRepuesto.setMarca(rs.getString("Marca"));
                marcasRepuesto.add(tmpMarcaRepuesto);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marcasRepuesto;
    }
    public void actualizarMarcaRepuesto(MarcaRepuesto tmpMarcaRepuesto){
        try {
            Conexion con = new Conexion();
            String query = "UPDATE HnI_MarcaRespuesto SET Marca=? WHERE idMarcaRepuesto=?";
            PreparedStatement stmt;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setString(1, tmpMarcaRepuesto.getMarca());
            stmt.setInt(2, tmpMarcaRepuesto.getIdMarcaRepuesto());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void eliminarMarcaRepuesto(MarcaRepuesto tmpMarcaRepuesto){
        try {
            Conexion con = new Conexion();
            String query = "DELETE FROM HnI_MarcaRespuesto WHERE idMarcaRepuesto=?";
            PreparedStatement stmt;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, tmpMarcaRepuesto.getIdMarcaRepuesto());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
