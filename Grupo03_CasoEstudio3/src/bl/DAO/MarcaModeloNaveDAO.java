package bl.DAO;

import bl.config.Conexion;
import bl.entities.builder.objects.MarcaModeloNave;
import bl.entities.builder.objects.MarcaNave;
import bl.entities.builder.objects.ModeloNave;

import java.sql.*;
import java.util.ArrayList;

public class MarcaModeloNaveDAO {
    private MarcaNaveDAO marcaNaveDAO = new MarcaNaveDAO();
    private ModeloNaveDAO modeloNaveDAO = new ModeloNaveDAO();

    public void insertarMarcaModeloNave(MarcaModeloNave marcaModeloNave) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "INSERT INTO HnI_MarcaModelo (id_Marca, id_Modelo, annno) VALUES(?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, marcaModeloNave.getMarca().getIdMarca());
            stmt.setInt(2, marcaModeloNave.getModelo().getIdModelo());
            stmt.setInt(3, marcaModeloNave.getAnio());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<MarcaModeloNave> listarMarcaModelos(){
        ArrayList<MarcaModeloNave> marcaModelosNave = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_MarcaModelo";
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                MarcaNave tmpMarcaNave = marcaNaveDAO.buscarMarcaNave(rs.getInt("id_Marca"));
                ModeloNave tmpModeloNave = modeloNaveDAO.buscarModeloNave(rs.getInt("id_Modelo"));
                MarcaModeloNave tmpMarcaModeloNave = new MarcaModeloNave();
                tmpMarcaModeloNave.setMarca(tmpMarcaNave);
                tmpMarcaModeloNave.setModelo(tmpModeloNave);
                tmpMarcaModeloNave.setIdMarcaModeloNave(rs.getInt("id_MarcaModelo"));
                tmpMarcaModeloNave.setAnio(rs.getInt("annno"));
                marcaModelosNave.add(tmpMarcaModeloNave);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marcaModelosNave;
    }

    public ArrayList<MarcaModeloNave> listarMarcaModelos(int idMarca) {
        ArrayList<MarcaModeloNave> marcaModelosNave = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_MarcaModelo WHERE id_Marca = " + idMarca;
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                MarcaNave tmpMarcaNave = marcaNaveDAO.buscarMarcaNave(rs.getInt("id_Marca"));
                ModeloNave tmpModeloNave = modeloNaveDAO.buscarModeloNave(rs.getInt("id_Modelo"));
                MarcaModeloNave tmpMarcaModeloNave = new MarcaModeloNave();
                tmpMarcaModeloNave.setMarca(tmpMarcaNave);
                tmpMarcaModeloNave.setModelo(tmpModeloNave);
                tmpMarcaModeloNave.setIdMarcaModeloNave(rs.getInt("id_MarcaModelo"));
                tmpMarcaModeloNave.setAnio(rs.getInt("annno"));
                marcaModelosNave.add(tmpMarcaModeloNave);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marcaModelosNave;
    }

    public MarcaModeloNave buscarMarcaModeloNave(int idMarcaModelo){
        MarcaModeloNave marcaModeloNave = new MarcaModeloNave();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_MarcaModelo WHERE id_MarcaModelo = " + idMarcaModelo;
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                MarcaNave tmpMarcaNave = marcaNaveDAO.buscarMarcaNave(rs.getInt("id_Marca"));
                ModeloNave tmpModeloNave = modeloNaveDAO.buscarModeloNave(rs.getInt("id_Modelo"));
                marcaModeloNave.setMarca(tmpMarcaNave);
                marcaModeloNave.setModelo(tmpModeloNave);
                marcaModeloNave.setIdMarcaModeloNave(rs.getInt("id_MarcaModelo"));
                marcaModeloNave.setAnio(rs.getInt("annno"));
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marcaModeloNave;
    }
}
