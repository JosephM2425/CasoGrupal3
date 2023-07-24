package bl.entities.builder.objects;

import java.util.ArrayList;

public class Cliente extends Usuario{
    //Atributos
    private ArrayList<Nave> listaNaves;

    //Constructores
    /**
     * Constructor por defecto
     */
    public Cliente() {
        super();
        this.setRol("Cliente");
        this.listaNaves = new ArrayList<>();
    }

    /**
     * Constructor con todos los atributos
     * @param id es de tipo String y corresponde al id del usuario
     * @param nombre es de tipo String y corresponde al nombre del usuario
     * @param apellido1 es de tipo String y corresponde al primer apellido del usuario
     * @param apellido2 es de tipo String y corresponde al segundo apellido del usuario
     * @param numeroTelefonico es de tipo String y corresponde al numero telefonico del usuario
     */
    public Cliente(int id, String nombre, String apellido1, String apellido2, String numeroTelefonico) {
        super(id, nombre, apellido1, apellido2, numeroTelefonico, "Cliente");
        this.listaNaves = new ArrayList<>();
    }

    /**
     * Constructor con todos los atributos excepto el id
     * @param nombre es de tipo String y corresponde al nombre del usuario
     * @param apellido1 es de tipo String y corresponde al primer apellido del usuario
     * @param apellido2 es de tipo String y corresponde al segundo apellido del usuario
     * @param numeroTelefonico es de tipo String y corresponde al numero telefonico del usuario
     */
    public Cliente(String nombre, String apellido1, String apellido2, String numeroTelefonico) {
        super(nombre, apellido1, apellido2, numeroTelefonico, "Cliente");
        this.listaNaves = new ArrayList<>();
    }
}
