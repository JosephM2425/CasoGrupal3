package bl.entities.factory.product;
import bl.entities.factory.objects.*;

public abstract class Repuesto {
    private int id_Repuesto;
    private TipoRepuesto TipoRepuesto;
    private String nombre;
    private String descripcion;
    private String categoria;
    private float precio;
    private MarcaRepuesto MarcaRepuesto;
    /**Constructores**/
    public Repuesto(int id_Repuesto,TipoRepuesto tipoRepuesto, String nombre, String descripcion, String categoria, float precio, MarcaRepuesto marcaRepuesto) {
        setId_Repuesto(id_Repuesto);
        setTipoRepuesto(tipoRepuesto);
        setNombre(nombre);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }

    public Repuesto() {
        setId_Repuesto(0);
        setTipoRepuesto(null);
        setNombre("Repuesto");
        setDescripcion("");
        setCategoria("");
        setPrecio(0);
        setMarcaRepuesto(null);
    }

    /**Getters**/
    public int getId_Repuesto() {
        return id_Repuesto;
    }
    public TipoRepuesto getTipoRepuesto() {
        return TipoRepuesto;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getCategoria() {
        return categoria;
    }
    public float getPrecio() {
        return precio;
    }
    public MarcaRepuesto getMarcaRepuesto() {
        return MarcaRepuesto;
    }

    /**Setters**/
    public void setId_Repuesto(int id_Repuesto) {
        this.id_Repuesto = id_Repuesto;
    }
    public void setTipoRepuesto(TipoRepuesto tipoRepuesto) {
        this.TipoRepuesto = tipoRepuesto;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public void setMarcaRepuesto(MarcaRepuesto marcaRepuesto) {
        this.MarcaRepuesto = marcaRepuesto;
    }

}
