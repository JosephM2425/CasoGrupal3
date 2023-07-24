package bl.DAO;

import bl.entities.factory.objects.*;
import bl.entities.factory.creator.Metodo_Fabrica_Abstracta;
import bl.entities.factory.product.Repuesto;
import java.sql.*;
import java.util.ArrayList;
import bl.config.Configuracion;

public class RepuestoDAO {
    private static Metodo_Fabrica_Abstracta gFabrica;
    public void insertarRepuesto(Repuesto tmpRepuesto) {
        try {
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "INSERT INTO HnI_Repuestos (id_TipoRepuesto,NOMBRE,DESCRIPCION,CATEGORIA,PRECIO,id_MarcaRespuesto) VALUES(?,?,?,?,?,?)";
            stmt = getPreparedStatement(tmpRepuesto, strConexion, query);
            stmt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Repuesto> listarRepuestos(){
        Configuracion configuracion = new Configuracion();
        ArrayList<Repuesto> repuestos = new ArrayList<>();
        try {
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            String query = "Select r.id_Repuesto, t.Tipo, r.nombre,r.descripcion,r.categoria,r.precio,m.Marca from HnI_Repuestos AS r INNER JOIN HnI_MarcaRespuesto AS m ON R.id_MarcaRespuesto=M.idMarcaRespuesto INNER JOIN HnI_TipoRepuesto AS t ON R.id_TipoRepuesto=T.idTipoRepuesto";
            Statement stmt;
            ResultSet rs;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                repuestos.add(listaRepuestos(rs));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return repuestos;
    }
    public void actualizarRepuesto(Repuesto tmpRepuesto){
        Configuracion configuracion = new Configuracion();
        try {
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "UPDATE HnI_Repuestos SET id_TipoRepuesto = ?, NOMBRE = ?, DESCRIPCION = ?,CATEGORIA=?, PRECIO = ?, id_MarcaRespuesto = ? WHERE id_Repuesto = ?";
            stmt = getPreparedStatement(tmpRepuesto, strConexion, query);
            stmt.setInt(7, tmpRepuesto.getId_Repuesto());
            stmt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement getPreparedStatement(Repuesto tmpRepuesto, String strConexion, String query) throws SQLException {
        Connection conn;
        PreparedStatement stmt;
        conn = DriverManager.getConnection(strConexion);
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, tmpRepuesto.getTipoRepuesto().getIdTipoRepuesto());
        stmt.setString(2, tmpRepuesto.getNombre());
        stmt.setString(3, tmpRepuesto.getDescripcion());
        stmt.setString(4, tmpRepuesto.getCategoria());
        stmt.setFloat(5, tmpRepuesto.getPrecio());
        stmt.setInt(6, tmpRepuesto.getMarcaRepuesto().getIdMarcaRepuesto());
        return stmt;
    }

    public void eliminarRepuesto(Repuesto tmpRepuesto){
        try{
            Configuracion configuracion = new Configuracion();
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            PreparedStatement stmt;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            String query = "DELETE FROM HnI_Repuestos WHERE id_Repuesto = ?";
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, tmpRepuesto.getId_Repuesto());
            stmt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Repuesto buscarRepuesto(int tmpRepuesto){
        Configuracion configuracion = new Configuracion();
        try {
            Class.forName(configuracion.getClaseJDBC());
            Connection conn;
            String query = "Select TOP 1 r.id_Repuesto, t.Tipo, r.nombre,r.descripcion,r.categoria,r.precio,m.Marca from HnI_Repuestos AS r INNER JOIN HnI_MarcaRespuesto AS m ON R.id_MarcaRespuesto=M.idMarcaRespuesto INNER JOIN HnI_TipoRepuesto AS t ON R.id_TipoRepuesto=T.idTipoRepuesto WHERE r.id_Repuesto = ?";
            PreparedStatement stmt;
            ResultSet rs = null;
            String strConexion = configuracion.getStringConexion();
            conn = DriverManager.getConnection(strConexion);
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, tmpRepuesto);
            rs = stmt.executeQuery();
            return listaRepuestos(rs);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Repuesto listaRepuestos( ResultSet rs) throws SQLException {
        TipoRepuesto tipoRepuesto = new TipoRepuesto();
        tipoRepuesto.setTipoRepuesto(rs.getString("Tipo"));
        MarcaRepuesto marcaRepuesto = new MarcaRepuesto();
        marcaRepuesto.setMarca(rs.getString("Marca"));
        Repuesto tmpRepuesto = gFabrica.crearRepuesto(rs.getInt("id_Repuesto"),tipoRepuesto,rs.getString("descripcion"),rs.getString("categoria"),rs.getFloat("precio"),marcaRepuesto);
        return tmpRepuesto;
    }

}
