package bl.entities.builder.objects;

import java.util.Objects;

public abstract class Usuario {
    //Atributos
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String numeroTelefonico;
    private String rol;

    //Constructores
    /**
     * Constructor por defecto
     */
    public Usuario() {

    }

    /**
     * Constructor con todos los atributos
     * @param id es de tipo int y corresponde al id del usuario
     * @param nombre es de tipo String y corresponde al nombre del usuario
     * @param apellido1 es de tipo String y corresponde al primer apellido del usuario
     * @param apellido2 es de tipo String y corresponde al segundo apellido del usuario
     * @param numeroTelefonico es de tipo String y corresponde al numero telefonico del usuario
     * @param rol es de tipo String y corresponde al rol del usuario
     */
    public Usuario(int id, String nombre, String apellido1, String apellido2, String numeroTelefonico, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.numeroTelefonico = numeroTelefonico;
        this.rol = rol;
    }

    /**
     * Constructor con todos los atributos excepto el id
     * @param nombre es de tipo String y corresponde al nombre del usuario
     * @param apellido1 es de tipo String y corresponde al primer apellido del usuario
     * @param apellido2 es de tipo String y corresponde al segundo apellido del usuario
     * @param numeroTelefonico es de tipo String y corresponde al numero telefonico del usuario
     * @param rol es de tipo String y corresponde al rol del usuario
     */
    public Usuario(String nombre, String apellido1, String apellido2, String numeroTelefonico, String rol) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.numeroTelefonico = numeroTelefonico;
        this.rol = rol;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
