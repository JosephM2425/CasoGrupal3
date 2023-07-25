package bl.DAO;

import java.sql.*;
import java.util.ArrayList;
import bl.config.Conexion;
import bl.entities.builder.objects.*;
import bl.entities.composite.base.iComponente;
import bl.entities.composite.components.Proforma;

/**
 * @author Carolina Arias
 * @version 1.0
 * @since 19/07/2023
 *
 * Esta clase se encarga de gestionar el acceso a datos de los objetos Proforma
 */
public class ProformaDAO {
    private UsuarioDAO _usuarioDAO = new UsuarioDAO();
    private DetalleDAO _detalleDAO = new DetalleDAO();
    /**
     * Metodo para registrar un proforma
     * @param proforma es de tipo Proforma y corresponde al proforma por registrar
     * @return 0 si se registro correctamente ,1 si no se pudo registrar
     */
    public int registrarProforma(Proforma proforma) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "INSERT INTO hni_proformas (id_Cliente, id_Vendedor, estado) VALUES (?, ?, ?)";

            stmt = conn.prepareStatement(query);
            stmt.setInt(1,proforma.getCliente().getId());
            stmt.setInt(2,proforma.getVendedor().getId());
            stmt.setString(3,proforma.getEstado());
            stmt.execute();

            con.Desconectar();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    /**
     * Metodo para listar los proformas
     * @return un ArrayList con los proformas
     */
    public ArrayList<iComponente> listarProformas()
    {
        ArrayList<iComponente> proformas = new ArrayList<iComponente>();
        ArrayList<iComponente> detalles = new ArrayList<iComponente>();

        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM hni_proformas";
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Proforma proforma = new Proforma();
                proforma.setId(rs.getInt("ID_PROFORMA"));
                int idCliente = rs.getInt("ID_CLIENTE");
                Usuario usuarioCliente = _usuarioDAO.buscarUsuario(idCliente);
                Cliente cliente = (Cliente) usuarioCliente;
                proforma.setCliente(cliente);

                int idVendedor = rs.getInt("ID_VENDEDOR");
                Usuario usuarioVendedor = _usuarioDAO.buscarUsuario(idVendedor);
                Vendedor vendedor = (Vendedor) usuarioVendedor;
                proforma.setVendedor(vendedor);

                proforma.setEstado(rs.getString("ESTADO"));

                detalles = _detalleDAO.listarDetalles(proforma.getId());

                if(detalles != null) {
                    for (iComponente detalle : detalles) {
                        proforma.agregarComponente(detalle);
                    }
                }
                proformas.add(proforma);

                con.Desconectar();
            }

        } catch (Exception e){
            return null;
        }
        return proformas;
    }

}
