package bl.entities.builder.objects;

public class MarcaModeloNave {
    //Atributos
    int idMarcaModeloNave;
    MarcaNave marca;
    ModeloNave modelo;
    int anio;

    /**
     * Constructor por defecto
     */
    public MarcaModeloNave() {
    }

    /**
     * Constructor con todos los atributos
     * @param idMarcaModeloNave es de tipo int y corresponde al id de la marca y modelo de la nave
     * @param marca es de tipo MarcaNave y corresponde a la marca de la nave
     * @param modelo es de tipo ModeloNave y corresponde al modelo de la nave
     * @param anio es de tipo int y corresponde al anio de la nave
     */
    public MarcaModeloNave(int idMarcaModeloNave, MarcaNave marca, ModeloNave modelo, int anio) {
        this.idMarcaModeloNave = idMarcaModeloNave;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    /**
     * Constructor con todos los atributos menos el id de la marcamodelo
     * @param marca es de tipo MarcaNave y corresponde a la marca de la nave
     * @param modelo es de tipo ModeloNave y corresponde al modelo de la nave
     * @param anio es de tipo int y corresponde al anio de la nave
     */
    public MarcaModeloNave(MarcaNave marca, ModeloNave modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    //Getters y Setters
    public int getIdMarcaModeloNave() {
        return idMarcaModeloNave;
    }

    public void setIdMarcaModeloNave(int idMarcaModeloNave) {
        this.idMarcaModeloNave = idMarcaModeloNave;
    }

    public MarcaNave getMarca() {
        return marca;
    }

    public void setMarca(MarcaNave marca) {
        this.marca = marca;
    }

    public ModeloNave getModelo() {
        return modelo;
    }

    public void setModelo(ModeloNave modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    //Metodos


    @Override
    public String toString() {
        return "MarcaModeloNave{" +
                "idMarcaModeloNave=" + idMarcaModeloNave +
                ", marca=" + marca +
                ", modelo=" + modelo +
                ", anio=" + anio +
                '}';
    }
}
