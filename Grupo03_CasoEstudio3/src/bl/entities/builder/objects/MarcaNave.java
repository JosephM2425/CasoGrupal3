package bl.entities.builder.objects;

public class MarcaNave {
    private int idMarca;
    private String nombreMarca;

    /**
     * Constructor por defecto
     */
    public MarcaNave() {
    }

    /**
     * Constructor con todos los atributos
     * @param idMarca es de tipo int y corresponde al id de la marca
     * @param nombreMarca es de tipo String y corresponde al nombre de la marca
     */
    public MarcaNave(int idMarca, String nombreMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
    }

    /**
     * Constructor con solamente el nombre de la marca
     * @param nombreMarca es de tipo String y corresponde al nombre de la marca
     */
    public MarcaNave(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    //Getters y Setters
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    //Metodos

    @Override
    public String toString() {
        return "MarcaNave{" +
                "idMarca=" + idMarca +
                ", nombreMarca='" + nombreMarca + '\'' +
                '}';
    }
}
