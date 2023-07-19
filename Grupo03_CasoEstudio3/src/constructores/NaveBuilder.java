package constructores;

import objetos.*;

public class NaveBuilder extends NaveAbstractBuilder{

    public void agregarCategoria() {
        this.nave.setCategoria("n/a");
    }

    public void agregarMarca() {
        this.nave.setMarca("n/a");
    }

    public void agregarModelo() {
        this.nave.setModelo("n/a");
    }

    public void agregarAnio() {
        this.nave.setAnio(2023);
    }

    public void agregarCodigoIdentificacion() {
        this.nave.setCodigoIdentificacion("n/a");
    }

    public void agregarColor() {
        this.nave.setColor("n/a");
    }
}
