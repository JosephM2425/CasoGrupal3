package directores;

import constructores.ClienteAbstractBuilder;

public class DirectorCliente {

    private ClienteAbstractBuilder builder;

    public DirectorCliente(){}

    public void construirCliente(){
        builder.crearNuevoCliente();
        builder.agregarApellido1();
        builder.agregarApellido2();
        builder.agregarNombre();
        builder.agregarNumeroTelefonico();
        builder.agregarListaNaves();
    }

    public void setBuilder (ClienteAbstractBuilder builder){this.builder = builder;}


    public ClienteAbstractBuilder getBuilder(){return builder;}

}
