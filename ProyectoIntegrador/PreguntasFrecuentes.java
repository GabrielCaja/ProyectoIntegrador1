package ProyectoIntegrador;

import java.util.*;

public class PreguntasFrecuentes {

	ArrayList<String> listaPreguntas= new ArrayList<>();
	ArrayList<String> listaRespuestas= new ArrayList<>();
	
	//Constructor de preguntas 
	public PreguntasFrecuentes() {
		this.listaPreguntas.add("Para sire el  bat cinturon?");
		this.listaPreguntas.add("Para sire el  bat coche?");
		this.listaPreguntas.add("Para sire el  que utensilios tienen los gatgets del cinturon?");
		this.listaPreguntas.add("Para sire el  Raton?");
		this.listaPreguntas.add("Para sire el  Baston?");
		this.listaPreguntas.add("Para sire la Abuela");
		
		this.listaRespuestas.add("Para guardar todos los gatgets de l batman");
		this.listaRespuestas.add("Tiene muchos utensilios utiles para la movilidad por gotam");
		this.listaRespuestas.add("Sobre todo contiene ganchos de escalada ");
		this.listaRespuestas.add("Para usarlo como mascotao adiestrarlo para alcanzar cosas donde no llegas");
		this.listaRespuestas.add("Para Andar");
		this.listaRespuestas.add("La Abuela o viene incluida");
	}

	
	//Getter y setter de las listas por si ubiera que cambiar algo 
	public ArrayList<String> getListaPreguntas() {
		return listaPreguntas;
	}
	public void setListaPreguntas(ArrayList<String> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}
	
	public ArrayList<String> getListaRespuestas() {
		return listaRespuestas;
	}
	public void setListaRespuestas(ArrayList<String> listaRespuestas) {
		this.listaRespuestas = listaRespuestas;
	}
	//Realmente en esta clase no haria falta el getter y setter 
	
	@Override
	public String toString() {
		
		for (int i = 0; i < listaPreguntas.size(); i++) {
			System.out.println("Pregunta"+(i+1));
			System.out.println(listaPreguntas.get(i));
			System.out.println(listaRespuestas.get(i));
			System.out.println("");

		}
		return super.toString();
	}
	
	
}
