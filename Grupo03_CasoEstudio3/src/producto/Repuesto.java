package producto;
import Enum.*;

public abstract class Repuesto {
    private TipoRepuestoEnum tipoRepuesto;
    private String nombre;
    private String descripcion;
    private String categoria;
    private float precio;
    private MarcaEnum marcaRepuesto;
    /**Constructores**/
    public Repuesto(TipoRepuestoEnum tipoRepuesto, String nombre, String descripcion, String categoria, float precio, MarcaEnum marcaRepuesto) {
        setTipoRepuesto(tipoRepuesto);
        setNombre(nombre);
        setDescripcion(descripcion);
        setCategoria(categoria);
        setPrecio(precio);
        setMarcaRepuesto(marcaRepuesto);
    }

    public Repuesto() {
        setTipoRepuesto(TipoRepuestoEnum.REPUESTO);
        setNombre("Repuesto");
        setDescripcion("");
        setCategoria("");
        setPrecio(0);
        setMarcaRepuesto(MarcaEnum.MARCA);
    }

    /**Getters**/
    public TipoRepuestoEnum getTipoRepuesto() {
        return tipoRepuesto;
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
    public MarcaEnum getMarcaRepuesto() {
        return marcaRepuesto;
    }

    /**Setters**/
    public void setTipoRepuesto(TipoRepuestoEnum tipoRepuesto) {
        this.tipoRepuesto = tipoRepuesto;
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
    public void setMarcaRepuesto(MarcaEnum marcaRepuesto) {
        this.marcaRepuesto = marcaRepuesto;
    }

}
