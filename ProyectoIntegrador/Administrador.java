package ProyectoIntegrador;

import java.util.ArrayList;

public class Administrador extends Registro{
	
	private boolean administrador ; 

	public Administrador(int id, String nickname ,  String nombre, String superPoder, String contraseña, String ubicacion, String respuestaSeguridad, boolean administrador, ArrayList<Registro> listaClientes){
		super(id, nickname,nombre,superPoder,contraseña,ubicacion,respuestaSeguridad, respuestaSeguridad, respuestaSeguridad, listaClientes, administrador);
		this.administrador = administrador;
	}
	
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
	public boolean getAdministrador() {
		return administrador;
	}

	@Override
	public void registrarse() {
		// TODO Auto-generated method stub
		
	}
	
	
}
