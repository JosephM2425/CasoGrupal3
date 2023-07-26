package bl.entities.builder.objects;

public class Nave {

        private int idNave;
        private Usuario usuario;
        private CategoriaNave categoriaNave;
        private MarcaModeloNave marcaModeloNave;
        private String codigoIdentificacion;
        private String color;

        /**
         * Constructor por defecto
         */
        public Nave() {

        }

        /**
         * Constructor con todos los atributos
         * @param idNave es de tipo int y corresponde al id de la nave
         * @param usuario es de tipo Usuario y corresponde al usuario de la nave
         * @param categoriaNave es de tipo CategoriaNave y corresponde a la categoria de la nave
         * @param marcaModeloNave es de tipo MarcaModeloNave y corresponde a la marca y modelo de la nave
         * @param codigoIdentificacion es de tipo String y corresponde al codigo de identificacion de la nave
         * @param color es de tipo String y corresponde al color de la nave
         */
    public Nave(int idNave, Usuario usuario, CategoriaNave categoriaNave, MarcaModeloNave marcaModeloNave, String codigoIdentificacion, String color) {
        this.idNave = idNave;
        this.usuario = usuario;
        this.categoriaNave = categoriaNave;
        this.marcaModeloNave = marcaModeloNave;
        this.codigoIdentificacion = codigoIdentificacion;
        this.color = color;
    }

    /**
     * Constructor con todos los atributos menos el id de la nave
     * @param usuario es de tipo Usuario y corresponde al usuario de la nave
     * @param categoriaNave es de tipo CategoriaNave y corresponde a la categoria de la nave
     * @param marcaModeloNave es de tipo MarcaModeloNave y corresponde a la marca y modelo de la nave
     * @param codigoIdentificacion es de tipo String y corresponde al codigo de identificacion de la nave
     * @param color es de tipo String y corresponde al color de la nave
     */
    public Nave(Usuario usuario, CategoriaNave categoriaNave, MarcaModeloNave marcaModeloNave, String codigoIdentificacion, String color) {
        this.usuario = usuario;
        this.categoriaNave = categoriaNave;
        this.marcaModeloNave = marcaModeloNave;
        this.codigoIdentificacion = codigoIdentificacion;
        this.color = color;
    }

    //Getters y Setters

    public int getIdNave() {
        return idNave;
    }

    public void setIdNave(int idNave) {
        this.idNave = idNave;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CategoriaNave getCategoriaNave() {
        return categoriaNave;
    }

    public void setCategoriaNave(CategoriaNave categoriaNave) {
        this.categoriaNave = categoriaNave;
    }

    public MarcaModeloNave getMarcaModeloNave() {
        return marcaModeloNave;
    }

    public void setMarcaModeloNave(MarcaModeloNave marcaModeloNave) {
        this.marcaModeloNave = marcaModeloNave;
    }

    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public void setCodigoIdentificacion(String codigoIdentificacion) {
        this.codigoIdentificacion = codigoIdentificacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //Metodos

    @Override
    public String toString() {
        return "Nave{" +
                "idNave=" + idNave +
                ", usuario=" + usuario +
                ", categoriaNave=" + categoriaNave +
                ", marcaModeloNave=" + marcaModeloNave +
                ", codigoIdentificacion='" + codigoIdentificacion + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
