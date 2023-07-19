package directores;

import constructores.NaveAbstractBuilder;

public class DirectorNave {

    private NaveAbstractBuilder builder;

    public DirectorNave(){}

    public void construirNave(){
        builder.crearNuevaNave();
        builder.agregarAnio();
        builder.agregarCategoria();
        builder.agregarColor();
        builder.agregarMarca();
        builder.agregarModelo();
        builder.agregarCodigoIdentificacion();
    }

    public void setBuilder( NaveAbstractBuilder builder){this.builder = builder;}

    public NaveAbstractBuilder getBuilder(){return builder;}

    
}
