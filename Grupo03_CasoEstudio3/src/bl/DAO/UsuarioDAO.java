package bl.DAO;

import java.sql.*;
import java.util.ArrayList;

import bl.config.Conexion;
import bl.entities.builder.objects.*;
/**
 * @author Carolina Arias
 * @version 1.0
 * @since 19/07/2023
 *
 * Esta clase se encarga de gestionar el acceso a datos de los objetos Usuario
 */
public class UsuarioDAO {
    /**
     * Metodo para registrar un usuario
     * @param usuario es de tipo Usuario y corresponde al usuario por registrar
     * @return 0 si se registro correctamente, 1 si no se pudo registrar
     */
    public int registrarUsuario(Usuario usuario) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnection();
            PreparedStatement stmt = null;
            String query = "INSERT INTO hni_usuarios (id_rol, nombre, apellido1, apellido2, telefono) VALUES (?, ?, ?, ?,?)";

            stmt = conn.prepareStatement(query);
            stmt.setInt(1,usuario.getRol().equals("Cliente") ? 1 : 2);
            stmt.setString(2,usuario.getNombre());
            stmt.setString(3,usuario.getApellido1());
            stmt.setString(4,usuario.getApellido2());
            stmt.setString(5,usuario.getNumeroTelefonico());
            stmt.execute();
            
            con.Desconectar();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }

    /**
     * Metodo para listar los usuarios
     * @return un ArrayList con los usuarios
     */
    public ArrayList<Usuario> listarUsuarios()
    {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM hni_usuarios";
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int rol = rs.getInt("ID_ROL");

                Usuario usuario = null;
                switch (rol) {
                    case 1:
                        usuario = new Cliente();
                        break;
                    case 2:
                        usuario = new Vendedor();
                        break;
                }

                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setRol(rol == 1 ? "Cliente" : "Vendedor");
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setApellido1(rs.getString("APELLIDO1"));
                usuario.setApellido2(rs.getString("APELLIDO2"));
                usuario.setNumeroTelefonico(rs.getString("TELEFONO"));
                usuarios.add(usuario);

                con.Desconectar();
            }
            
        } catch (Exception e){
            return null;
        }
        return usuarios;
    }

    /**
     * Metodo para buscar un usuario por su id
     * @param idUsuario es de tipo int y corresponde al nombre de usuario del usuario por buscar
     * @return usuario es de tipo Usuario y corresponde al usuario por buscar
     */
    public Usuario buscarUsuario(int idUsuario)
    {
        Usuario usuario = null;
        try {
            Conexion con = new Conexion();
            String query = "SELECT * FROM hni_usuarios WHERE id_usuario = ?";
            PreparedStatement stmt = null;
            ResultSet rs = null;
            Connection conn = con.getConnection();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();
            if (rs.next()) {
                int rol = rs.getInt("ID_ROL");

                switch (rol) {
                    case 1:
                        usuario = new Cliente();
                        break;
                    case 2:
                        usuario = new Vendedor();
                        break;
                }

                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setRol(rol == 1 ? "Cliente" : "Vendedor");
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setApellido1(rs.getString("APELLIDO1"));
                usuario.setApellido2(rs.getString("APELLIDO2"));
                usuario.setNumeroTelefonico(rs.getString("TELEFONO"));
            }
            conn.close();
        } catch (Exception e){
            return null;
        }
        return usuario;
    }

}
