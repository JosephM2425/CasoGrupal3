package bl.entities.builder.objects;

public class CategoriaNave {
    private int idCategoria;
    private String nombreCategoria;

    /**
     * Constructor por defecto
     */
    public CategoriaNave() {
    }

    /**
     * Constructor con todos los atributos
     * @param idCategoria es de tipo int y corresponde al id de la marca
     * @param nombreCategoria es de tipo String y corresponde al nombre de la marca
     */
    public CategoriaNave(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    /**
     * Constructor con solamente el nombre de la marca
     * @param nombreCategoria es de tipo String y corresponde al nombre de la marca
     */
    public CategoriaNave(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    //Getters y Setters
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    //Metodos

    @Override
    public String toString() {
        return "CategoriaNave{" +
                "idCategoria=" + idCategoria +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                '}';
    }
}
