package principal;
import Enum.*;

public class Main_Metodo_Fabrica {

	private static Gestor gGestor= new Gestor();
	
	public static void main(String[] args) {
		gGestor.nuevoRepuesto(TipoRepuestoEnum.MOTOR, "Potente Motor NX5", "Repuesto Simple", 1000, MarcaEnum.ESCAPE);
		gGestor.nuevoRepuesto(TipoRepuestoEnum.VOLANTE, "Util volante", "Repuesto Simple", 500, MarcaEnum.EXPLORE);
		gGestor.nuevoRepuesto(TipoRepuestoEnum.PUERTA, "Lujosa puerta", "Repuesto a medida", 500, MarcaEnum.LAUNCH);
		gGestor.nuevoRepuesto(TipoRepuestoEnum.ASIENTO, "Comodo asiento", "Repuesto Simple", 500, MarcaEnum.ROCKET);
		gGestor.nuevoRepuesto(TipoRepuestoEnum.PARABRISAS, "Gorilla Glass 5", "Repuesto a medida", 500, MarcaEnum.SPACECRAFT);
		imprimir();
	}


	private static void imprimir() {
		System.out.println(gGestor.obtenerDatos());
	}

	
	
	
}



