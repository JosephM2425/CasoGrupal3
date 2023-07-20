package bl.entities.composite.base;

public abstract class iComponente {
    //Atributos
    public static final int PROFORMA = 0;
    public static final int DETALLE = 1;
    protected int tipoNodo;
    protected int id;

    //Constructores
    /**
     * Constructor por defecto
     */
    public iComponente() {

    }

    /**
     * Constructor con el tipo de nodo y el id
     * @param tipoNodo es de tipo int y corresponde al tipo de nodo
     * @param id es de tipo int y corresponde al id del nodo
     */
    public iComponente(int tipoNodo, int id) {
        this.tipoNodo = tipoNodo;
        this.id = id;
    }

    /**
     * Constructor con el id
     * @param id es de tipo int y corresponde al id del nodo
     */
    public iComponente(int id) {
        this.id = id;
    }

    //Getters y Setters
    public int getTipoNodo() { return tipoNodo; }

    public void setTipoNodo(int tipoNodo) { this.tipoNodo = tipoNodo; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    //Metodos Abstractos
    public abstract String mostrarDatos();

    public abstract void agregarComponente(iComponente composicion);
}
