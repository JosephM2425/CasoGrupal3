package bl.DAO;

import bl.config.Conexion;
import bl.entities.builder.objects.MarcaNave;
import bl.entities.builder.objects.ModeloNave;

import java.sql.*;
import java.util.ArrayList;

public class ModeloNaveDAO {
    public void insertarModeloNave(ModeloNave modeloNave) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "INSERT INTO HnI_Modelo (Modelo) VALUES(?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, modeloNave.getNombreModelo());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<ModeloNave> listarModelos(){
        ArrayList<ModeloNave> modelosNave = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_Modelo";
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                ModeloNave tmpModeloNave = new ModeloNave();
                tmpModeloNave.setIdModelo(rs.getInt("idModelo"));
                tmpModeloNave.setNombreModelo(rs.getString("Modelo"));
                modelosNave.add(tmpModeloNave);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelosNave;
    }

    public ModeloNave buscarModeloNave(int idModelo){
        ModeloNave modeloNave = new ModeloNave();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_Modelo WHERE idModelo = " + idModelo;
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                modeloNave.setIdModelo(rs.getInt("idModelo"));
                modeloNave.setNombreModelo(rs.getString("Modelo"));
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modeloNave;
    }
}
