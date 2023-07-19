package constructores;

import objetos.Cliente;
import objetos.Nave;

import java.util.List;

public abstract class ClienteAbstractBuilder {

    protected Cliente cliente;

    public Cliente getCliente(){
        return this.cliente;
    }

    public void crearNuevoCliente(){
        this.cliente = new Cliente();}


    // Métodos que deberán ser construídos por las clases que hereden de ésta
    public abstract void agregarNumeroTelefonico();
    public abstract void agregarNombre();
    public abstract void agregarApellido1();
    public abstract void agregarApellido2();
    public abstract void agregarListaNaves();

}
