package ProyectoIntegrador;

import java.util.ArrayList;

public class SuperHeroe extends Registro{

	public SuperHeroe(int id, String nickname ,  String nombre, String superPoder, String contraseña, String ubicacion, String respuestaSeguridad, ArrayList<Registro> listaClientes, boolean administrador){
		super(id, nickname,nombre,superPoder,contraseña,ubicacion,respuestaSeguridad, respuestaSeguridad, respuestaSeguridad, listaClientes, administrador);
		
	}
}
