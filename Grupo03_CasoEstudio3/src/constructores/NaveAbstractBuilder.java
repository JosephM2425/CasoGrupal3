package constructores;

import objetos.Nave;

public abstract class NaveAbstractBuilder {

    protected Nave nave;

    public Nave getNave(){ return this.nave;}

    public void crearNuevaNave(){
        this.nave = new Nave();}


    // Métodos que deberán ser construídos por las clases que hereden de ésta
    public abstract void agregarCategoria();
    public abstract void agregarMarca();
    public abstract void agregarModelo();
    public abstract void agregarAnio();
    public abstract void agregarCodigoIdentificacion();
    public abstract void agregarColor();



}
