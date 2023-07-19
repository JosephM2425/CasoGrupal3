package principal;

import java.util.ArrayList;
import Enum.*;
import creador.Metodo_Fabrica_Abstracta;
import creador_Concreto.Fabrica_Repuestos;
import producto.Repuesto;


public class Gestor {
	private static ArrayList <Repuesto> arrRepuestos = new ArrayList<Repuesto>();
	private static Metodo_Fabrica_Abstracta gFabrica;

	public Gestor() {
		gFabrica = new Fabrica_Repuestos();
	}

	public void nuevoRepuesto(TipoRepuestoEnum tipoRepuesto, String descripcion, String categoria, float precio, MarcaEnum marcaRepuesto) {
		add_objeto_array(gFabrica.crearRepuesto(tipoRepuesto, descripcion, categoria, precio, marcaRepuesto));
	}


	private static void add_objeto_array(Repuesto pObj) {
		arrRepuestos.add(pObj);
	}

	public String obtenerDatos(){
		String mResult = "";
		for(Repuesto mRp : arrRepuestos){
			mResult=mResult+"Tipo de repuesto: "+mRp.getTipoRepuesto()+"\n"
					+"Nombre: "+mRp.getNombre()+"\n"
					+"Descripción: "+mRp.getDescripcion()+"\n"
					+"Categoría: "+mRp.getCategoria()+"\n"
					+"Precio: "+mRp.getPrecio()+"\n"
					+"Marca: "+mRp.getMarcaRepuesto()+"\n\n";

		}
		return mResult;
	}

	public String obtenerDatos(int idArray){
		String mResult = "";
		Repuesto mRp = arrRepuestos.get(idArray);
		mResult=mResult+"Tipo de repuesto: "+mRp.getTipoRepuesto()+"\n"
				+"Nombre: "+mRp.getNombre()+"\n"
				+"Descripción: "+mRp.getDescripcion()+"\n"
				+"Categoría: "+mRp.getCategoria()+"\n"
				+"Precio: "+mRp.getPrecio()+"\n"
				+"Marca: "+mRp.getMarcaRepuesto()+"\n\n";
		return mResult;
	}


}
