package bl.entities.builder.gestor;

import bl.DAO.*;
import bl.entities.builder.builders.UsuarioBuilder;
import bl.entities.builder.directores.Director;
import bl.entities.builder.objects.*;
import bl.entities.factory.objects.MarcaRepuesto;

import java.util.ArrayList;

public class GestorBuilder {
    //Atributos
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Nave> naves = new ArrayList<>();
    private Director director = new Director();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private MarcaNaveDAO marcaNaveDAO = new MarcaNaveDAO();
    private MarcaRepuestoDAO marcaRepuestoDAO = new MarcaRepuestoDAO();
    private ModeloNaveDAO modeloNaveDAO = new ModeloNaveDAO();
    private MarcaModeloNaveDAO marcaModeloNaveDAO = new MarcaModeloNaveDAO();
    private CategoriaNaveDAO categoriaNaveDAO = new CategoriaNaveDAO();
    private NaveDAO naveDAO = new NaveDAO();

    //Getters y Setters
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int construccionUsuarios(String rol, String nombre, String apellido1, String apellido2, String numeroTelefonico) {
        try {
            director.construirUsuario(rol, nombre, apellido1, apellido2, numeroTelefonico);
            Usuario usuario = director.getUsuarioBuilder().getUsuario();
            anadirUsuario(usuario);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

    private void anadirUsuario(Usuario usuario) {
        usuarioDAO.registrarUsuario(usuario);
    }

    public Cliente obtenerCliente(int id) {
        for(Usuario usuario : usuarios) {
            if(usuario.getId() == id && usuario.getRol().equals("Cliente")) {
                Cliente cliente = (Cliente) usuario;
                return cliente;
            }
        }
        return null;
    }

    public Vendedor obtenerVendedor(int id) {
        for(Usuario usuario : usuarios) {
            if(usuario.getId() == id && usuario.getRol().equals("Vendedor")) {
                Vendedor vendedor = (Vendedor) usuario;
                return vendedor;
            }
        }
        return null;
    }

    public ArrayList<Usuario> listarUsuarios() {
        usuarios = usuarioDAO.listarUsuarios();
        return usuarios;
    }

    public ArrayList<Usuario> listarUsuarios(int tipo) {
        usuarios = usuarioDAO.listarUsuarios(tipo);
        return usuarios;
    }


    //Naves
    public int registrarMarcaNave(String nombreMarca) {
        if(!existeMarca(nombreMarca)) {
            MarcaNave marcaNave = new MarcaNave(nombreMarca);
            marcaNaveDAO.insertarMarcaNave(marcaNave);
            MarcaRepuesto marcaRepuesto = new MarcaRepuesto(nombreMarca);
            marcaRepuestoDAO.insertarMarcaRepuesto(marcaRepuesto);
            return 0;
        } else {
            return 1;
        }
    }

    public Boolean existeMarca(String nombreMarca) {
        ArrayList<MarcaNave> marcasNave = marcaNaveDAO.listarMarcas();

        for(MarcaNave marcaNave : marcasNave) {
            if(marcaNave.getNombreMarca().equalsIgnoreCase(nombreMarca)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<MarcaNave> listarMarcas() {
        ArrayList<MarcaNave> marcasNave = marcaNaveDAO.listarMarcas();
        return marcasNave;
    }

    public int registrarModeloNave(String nombreModelo) {
        if(!existeModelo(nombreModelo)) {
            ModeloNave modeloNave = new ModeloNave(nombreModelo);
            modeloNaveDAO.insertarModeloNave(modeloNave);
            return 0;
        } else {
            return 1;
        }
    }

    public Boolean existeModelo(String nombreModelo) {
        ArrayList<ModeloNave> modelosNave = modeloNaveDAO.listarModelos();

        for(ModeloNave modeloNave : modelosNave) {
            if(modeloNave.getNombreModelo().equalsIgnoreCase(nombreModelo)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<ModeloNave> listarModelos() {
        ArrayList<ModeloNave> modelosNave = modeloNaveDAO.listarModelos();
        return modelosNave;
    }

    public int registrarCategoriaNave(String nombreCategoria) {
        if(!existeCategoria(nombreCategoria)) {
            CategoriaNave categoriaNave = new CategoriaNave(nombreCategoria);
            categoriaNaveDAO.insertarCategoriaNave(categoriaNave);
            return 0;
        } else {
            return 1;
        }
    }

    public Boolean existeCategoria(String nombreCategoria) {
        ArrayList<CategoriaNave> categoriasNave = categoriaNaveDAO.listarCategorias();

        for(CategoriaNave categoriaNave : categoriasNave) {
            if(categoriaNave.getNombreCategoria().equalsIgnoreCase(nombreCategoria)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<CategoriaNave> listarCategorias() {
        ArrayList<CategoriaNave> categoriasNave = categoriaNaveDAO.listarCategorias();
        return categoriasNave;
    }

    public int construccionNaves(Usuario usuario, CategoriaNave categoriaNave, MarcaNave marcaNave, ModeloNave modeloNave, int anio, String codigoIdentificacion, String color) {
        try {
            MarcaModeloNave marcaModeloNave = new MarcaModeloNave(marcaNave, modeloNave, anio);
            if(existeMarcaModelo(marcaModeloNave)) {
                System.out.println("Existe");
                marcaModeloNave = obtenerMarcaModelo(marcaNave, modeloNave, anio);
                System.out.println(marcaModeloNave.getIdMarcaModeloNave());
            } else {
                registrarMarcaModelo(marcaNave, modeloNave, anio);
                marcaModeloNave = obtenerMarcaModelo(marcaNave, modeloNave, anio);
                System.out.println(marcaModeloNave.getIdMarcaModeloNave());
            }
            director.construirNave(usuario, categoriaNave, marcaModeloNave, codigoIdentificacion, color);
            Nave nave = director.getNaveBuilder().getNave();
            anadirNave(nave);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    private void anadirNave(Nave nave) {
        naveDAO.insertarNave(nave);
    }

    public ArrayList<Nave> listarNaves() {
        naves = naveDAO.listarNaves();
        return naves;
    }

    public ArrayList<Nave> listarNaves(int idCliente) {
        naves = naveDAO.listarNaves(idCliente);
        return naves;
    }

    public MarcaModeloNave obtenerMarcaModelo (MarcaNave marcaNave, ModeloNave modeloNave, int anio) {
        ArrayList<MarcaModeloNave> marcaModelosNave = marcaModeloNaveDAO.listarMarcaModelos();
        MarcaModeloNave marcaModeloNave = new MarcaModeloNave();

        for(MarcaModeloNave tmpMarcaModeloNave : marcaModelosNave) {
            if(tmpMarcaModeloNave.getMarca().getIdMarca() == marcaNave.getIdMarca() && tmpMarcaModeloNave.getModelo().getIdModelo() == modeloNave.getIdModelo() && tmpMarcaModeloNave.getAnio() == anio) {
                marcaModeloNave.setIdMarcaModeloNave(tmpMarcaModeloNave.getIdMarcaModeloNave());
                marcaModeloNave.setMarca(tmpMarcaModeloNave.getMarca());
                marcaModeloNave.setModelo(tmpMarcaModeloNave.getModelo());
                marcaModeloNave.setAnio(tmpMarcaModeloNave.getAnio());
            }
        }
        return marcaModeloNave;
    }

    public Boolean existeMarcaModelo (MarcaModeloNave marcaModeloNave) {
        MarcaModeloNave tmpMarcaModeloNave = obtenerMarcaModelo(marcaModeloNave.getMarca(), marcaModeloNave.getModelo(), marcaModeloNave.getAnio());
        if(tmpMarcaModeloNave.getIdMarcaModeloNave() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int registrarMarcaModelo (MarcaNave marcaNave, ModeloNave modeloNave, int anio) {
        try {
            MarcaModeloNave marcaModeloNave = new MarcaModeloNave(marcaNave, modeloNave, anio);
            marcaModeloNaveDAO.insertarMarcaModeloNave(marcaModeloNave);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
}