package bl.DAO;

import bl.config.Conexion;
import bl.entities.factory.concrete_Creator.Fabrica_Repuestos;
import bl.entities.factory.objects.*;
import bl.entities.factory.creator.Metodo_Fabrica_Abstracta;
import bl.entities.factory.product.Repuesto;
import java.sql.*;
import java.util.ArrayList;
import bl.config.Configuracion;

public class RepuestoDAO {
    private Fabrica_Repuestos gFabrica = new Fabrica_Repuestos();
    public void insertarRepuesto(Repuesto tmpRepuesto) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "INSERT INTO HnI_Repuestos (id_TipoRepuesto,NOMBRE,DESCRIPCION,CATEGORIA,PRECIO,id_MarcaRespuesto) VALUES(?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, tmpRepuesto.getTipoRepuesto().getIdTipoRepuesto());
            stmt.setString(2, tmpRepuesto.getNombre());
            stmt.setString(3, tmpRepuesto.getDescripcion());
            stmt.setString(4, tmpRepuesto.getCategoria());
            stmt.setFloat(5, tmpRepuesto.getPrecio());
            stmt.setInt(6, tmpRepuesto.getMarcaRepuesto().getIdMarcaRepuesto());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Repuesto> listarRepuestos(){
        ArrayList<Repuesto> repuestos = new ArrayList<>();
        try {
            Conexion con = new Conexion();
            String query = "Select r.id_Repuesto, t.idTipoRepuesto, t.Tipo, r.nombre,r.descripcion,r.categoria,r.precio,m.idMarcaRespuesto,m.Marca from HnI_Repuestos AS r INNER JOIN HnI_MarcaRespuesto AS m ON R.id_MarcaRespuesto=M.idMarcaRespuesto INNER JOIN HnI_TipoRepuesto AS t ON R.id_TipoRepuesto=T.idTipoRepuesto";
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                repuestos.add(listaRepuestos(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return repuestos;
    }
    public void actualizarRepuesto(Repuesto tmpRepuesto){
        try {
            Conexion con = new Conexion();
            String query = "UPDATE HnI_Repuestos SET id_TipoRepuesto = ?, NOMBRE = ?, DESCRIPCION = ?, CATEGORIA=?, PRECIO = ?, id_MarcaRespuesto = ? WHERE id_Repuesto = ?";
            PreparedStatement stmt;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, tmpRepuesto.getTipoRepuesto().getIdTipoRepuesto());
            stmt.setString(2, tmpRepuesto.getNombre());
            stmt.setString(3, tmpRepuesto.getDescripcion());
            stmt.setString(4, tmpRepuesto.getCategoria());
            stmt.setFloat(5, tmpRepuesto.getPrecio());
            stmt.setInt(6, tmpRepuesto.getMarcaRepuesto().getIdMarcaRepuesto());
            stmt.setInt(7, tmpRepuesto.getId_Repuesto());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarRepuesto(Repuesto tmpRepuesto){
        try{
            Conexion con = new Conexion();
            String query = "DELETE FROM HnI_Repuestos WHERE id_Repuesto = ?";
            PreparedStatement stmt;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, tmpRepuesto.getId_Repuesto());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Repuesto buscarRepuesto(int tmpRepuesto){

        try {
            Conexion con = new Conexion();
            String query = "Select r.id_Repuesto, t.idTipoRepuesto, t.Tipo, r.nombre,r.descripcion,r.categoria,r.precio,m.idMarcaRespuesto,m.Marca from HnI_Repuestos AS r INNER JOIN HnI_MarcaRespuesto AS m ON R.id_MarcaRespuesto=M.idMarcaRespuesto INNER JOIN HnI_TipoRepuesto AS t ON R.id_TipoRepuesto=T.idTipoRepuesto\" WHERE r.id_Repuesto = ?";
            PreparedStatement stmt;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, tmpRepuesto);
            rs = stmt.executeQuery();
            return listaRepuestos(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Repuesto listaRepuestos( ResultSet rs) throws SQLException {
        TipoRepuesto tipoRepuesto = new TipoRepuesto();
        tipoRepuesto.setTipoRepuesto(rs.getString("Tipo"));
        tipoRepuesto.setIdTipoRepuesto(rs.getInt("idTipoRepuesto"));
        MarcaRepuesto marcaRepuesto = new MarcaRepuesto();
        marcaRepuesto.setMarca(rs.getString("Marca"));
        marcaRepuesto.setIdMarcaRepuesto(rs.getInt("idMarcaRespuesto"));
        Repuesto tmpRepuesto = gFabrica.crearRepuesto(tipoRepuesto, rs.getString("nombre"), rs.getString("descripcion"),rs.getString("categoria"),rs.getFloat("precio"),marcaRepuesto);
        return tmpRepuesto;
    }

}
