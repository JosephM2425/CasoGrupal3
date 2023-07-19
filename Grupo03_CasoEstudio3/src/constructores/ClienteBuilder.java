package constructores;

import objetos.Nave;

import java.util.List;

public class ClienteBuilder extends  ClienteAbstractBuilder{

    public void agregarNumeroTelefonico() {
        this.cliente.setNumeroTelefonico("n/a");
    }
    public void agregarNombre() {
        this.cliente.setNombre("n/a");
    }


    public void agregarApellido1() {
        this.cliente.setApellido1("n/a");
    }

    public void agregarApellido2() {
        this.cliente.setApellido2("n/a");
    }

    @Override
    public void agregarListaNaves() {

    }
    public void agregarNaves(List<Nave> listaNaves) {
        this.cliente.setListaNaves(listaNaves);
    }

}
