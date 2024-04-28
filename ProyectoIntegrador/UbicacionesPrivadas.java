package ProyectoIntegrador;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class UbicacionesPrivadas {

	// Lista de ubicaciones privadas

	private ArrayList<String> listaUbicaciones = new ArrayList<>();
	String ubicacion;

	public UbicacionesPrivadas() {

	}

	public void setUbiucacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getUbiucacion() {
		return ubicacion;
	}

	public void añadirUbicacion(String ubi) {
		listaUbicaciones.add(ubi);
	}

	public void verUbicaciones() {
		System.out.println("***UBICACIONES PRIVADAS ****");
		for (int i = 0; i < listaUbicaciones.size(); i++) {
			System.out.println(listaUbicaciones.get(i));
		}

	}

}
