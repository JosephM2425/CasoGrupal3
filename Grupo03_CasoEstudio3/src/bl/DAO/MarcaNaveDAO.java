package bl.DAO;

import bl.config.Conexion;
import bl.entities.builder.objects.MarcaNave;

import java.sql.*;
import java.util.ArrayList;

public class MarcaNaveDAO {
    public void insertarMarcaNave(MarcaNave marcaNave) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "INSERT INTO HnI_Marca (Marca) VALUES(?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, marcaNave.getNombreMarca());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<MarcaNave> listarMarcas(){
        ArrayList<MarcaNave> marcasNave = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_Marca";
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                MarcaNave tmpMarcaNave = new MarcaNave();
                tmpMarcaNave.setIdMarca(rs.getInt("idMarca"));
                tmpMarcaNave.setNombreMarca(rs.getString("Marca"));
                marcasNave.add(tmpMarcaNave);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marcasNave;
    }

    public MarcaNave buscarMarcaNave(int idMarca){
        MarcaNave marcaNave = new MarcaNave();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_Marca WHERE idMarca = " + idMarca;
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                marcaNave.setIdMarca(rs.getInt("idMarca"));
                marcaNave.setNombreMarca(rs.getString("Marca"));
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marcaNave;
    }

    public MarcaNave buscarMarcaNave(String nombreMarca){
        MarcaNave marcaNave = new MarcaNave();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_Marca WHERE Marca = " + nombreMarca;
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                marcaNave.setIdMarca(rs.getInt("idMarca"));
                marcaNave.setNombreMarca(rs.getString("Marca"));
            }
            conn.close();

        } catch (SQLException e) {
            return null;
        }
        return marcaNave;
    }
}
