package bl.entities.builder.objects;

public class Vendedor extends Usuario{
    //Constructores
    /**
     * Constructor por defecto
     */
    public Vendedor() {
        super();
        this.setRol("Vendedor");
    }

    /**
     * Constructor con todos los atributos
     * @param id es de tipo String y corresponde al id del usuario
     * @param nombre es de tipo String y corresponde al nombre del usuario
     * @param apellido1 es de tipo String y corresponde al primer apellido del usuario
     * @param apellido2 es de tipo String y corresponde al segundo apellido del usuario
     * @param numeroTelefonico es de tipo String y corresponde al numero telefonico del usuario
     */
    public Vendedor(int id, String nombre, String apellido1, String apellido2, String numeroTelefonico) {
        super(id, nombre, apellido1, apellido2, numeroTelefonico, "Vendedor");
    }

    /**
     * Constructor con todos los atributos excepto el id
     * @param nombre es de tipo String y corresponde al nombre del usuario
     * @param apellido1 es de tipo String y corresponde al primer apellido del usuario
     * @param apellido2 es de tipo String y corresponde al segundo apellido del usuario
     * @param numeroTelefonico es de tipo String y corresponde al numero telefonico del usuario
     */
    public Vendedor(String nombre, String apellido1, String apellido2, String numeroTelefonico) {
        super(nombre, apellido1, apellido2, numeroTelefonico, "Vendedor");
    }
}
