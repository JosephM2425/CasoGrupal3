package bl.DAO;

import bl.config.Conexion;
import bl.entities.builder.objects.MarcaNave;
import bl.entities.builder.objects.Nave;
import bl.entities.builder.objects.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class NaveDAO {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private CategoriaNaveDAO categoriaNaveDAO = new CategoriaNaveDAO();
    private MarcaModeloNaveDAO marcaModeloNaveDAO = new MarcaModeloNaveDAO();

    public void insertarNave(Nave nave) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "INSERT INTO HnI_naves (id_usuario, id_Categoria, id_MarcaModelo, codigo_identificacion, color) VALUES(?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, nave.getUsuario().getId());
            stmt.setInt(2, nave.getCategoriaNave().getIdCategoria());
            stmt.setInt(3, nave.getMarcaModeloNave().getIdMarcaModeloNave());
            stmt.setString(4, nave.getCodigoIdentificacion());
            stmt.setString(5, nave.getColor());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Nave> listarNaves(){
        ArrayList<Nave> naves = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_naves";
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Nave tmpNave = new Nave();
                tmpNave.setIdNave(rs.getInt("id_nave"));
                tmpNave.setUsuario(usuarioDAO.buscarUsuario(rs.getInt("id_usuario")));
                tmpNave.setCategoriaNave(categoriaNaveDAO.buscarCategoriaNave(rs.getInt("id_Categoria")));
                tmpNave.setMarcaModeloNave(marcaModeloNaveDAO.buscarMarcaModeloNave(rs.getInt("id_MarcaModelo")));
                tmpNave.setCodigoIdentificacion(rs.getString("codigo_identificacion"));
                tmpNave.setColor(rs.getString("color"));
                naves.add(tmpNave);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return naves;
    }

    public ArrayList<Nave> listarNaves(int idCliente){
        ArrayList<Nave> naves = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_naves WHERE id_usuario = " + idCliente;
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Nave tmpNave = new Nave();
                tmpNave.setIdNave(rs.getInt("id_nave"));
                tmpNave.setUsuario(usuarioDAO.buscarUsuario(rs.getInt("id_usuario")));
                tmpNave.setCategoriaNave(categoriaNaveDAO.buscarCategoriaNave(rs.getInt("id_Categoria")));
                tmpNave.setMarcaModeloNave(marcaModeloNaveDAO.buscarMarcaModeloNave(rs.getInt("id_MarcaModelo")));
                tmpNave.setCodigoIdentificacion(rs.getString("codigo_identificacion"));
                tmpNave.setColor(rs.getString("color"));
                naves.add(tmpNave);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return naves;
    }

    public Nave buscarNave(int idNave){
        Nave nave = new Nave();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM HnI_naves WHERE id_nave = " + idNave;
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                nave.setUsuario(usuarioDAO.buscarUsuario(rs.getInt("id_usuario")));
                nave.setCategoriaNave(categoriaNaveDAO.buscarCategoriaNave(rs.getInt("id_Categoria")));
                nave.setMarcaModeloNave(marcaModeloNaveDAO.buscarMarcaModeloNave(rs.getInt("id_MarcaModelo")));
                nave.setCodigoIdentificacion(rs.getString("codigo_identificacion"));
                nave.setColor(rs.getString("color"));
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nave;
    }

}
