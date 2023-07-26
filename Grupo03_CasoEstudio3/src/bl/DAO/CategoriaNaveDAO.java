package bl.DAO;

import bl.config.Conexion;
import bl.entities.builder.objects.CategoriaNave;

import java.sql.*;
import java.util.ArrayList;

public class CategoriaNaveDAO {
    public void insertarCategoriaNave(CategoriaNave categoriaNave) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "INSERT INTO HnI_Categoria (Categoria) VALUES(?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, categoriaNave.getNombreCategoria());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<CategoriaNave> listarCategorias(){
        ArrayList<CategoriaNave> categoriasNave = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_Categoria";
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoriaNave tmpCategoriaNave = new CategoriaNave();
                tmpCategoriaNave.setIdCategoria(rs.getInt("id_Categoria"));
                tmpCategoriaNave.setNombreCategoria(rs.getString("Categoria"));
                categoriasNave.add(tmpCategoriaNave);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoriasNave;
    }

    public CategoriaNave buscarCategoriaNave(int idCategoria){
        CategoriaNave categoriaNave = new CategoriaNave();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_Categoria WHERE id_Categoria = " + idCategoria;
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                categoriaNave.setIdCategoria(rs.getInt("id_Categoria"));
                categoriaNave.setNombreCategoria(rs.getString("Categoria"));
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoriaNave;
    }
}
