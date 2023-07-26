package bl.entities.builder.objects;

public class ModeloNave {
    private int idModelo;
    private String nombreModelo;

    /**
     * Constructor por defecto
     */
    public ModeloNave() {
    }

    /**
     * Constructor con todos los atributos
     * @param idModelo es de tipo int y corresponde al id de la marca
     * @param nombreModelo es de tipo String y corresponde al nombre de la marca
     */
    public ModeloNave(int idModelo, String nombreModelo) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
    }

    /**
     * Constructor con solamente el nombre de la marca
     * @param nombreModelo es de tipo String y corresponde al nombre de la marca
     */
    public ModeloNave(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    //Getters y Setters
    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    //Metodos

    @Override
    public String toString() {
        return "ModeloNave{" +
                "idModelo=" + idModelo +
                ", nombreModelo='" + nombreModelo + '\'' +
                '}';
    }
}
