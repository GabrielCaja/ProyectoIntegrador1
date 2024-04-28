package ProyectoIntegrador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.net.ssl.CertPathTrustManagerParameters;

public class Devolver extends Recursos {

	// Scanner
	Scanner sc = new Scanner(System.in);

	// lista de Valoraciones y comentario
	ArrayList<String> listaComentario = new ArrayList<>();
	ArrayList<Integer> listaValoracion = new ArrayList<>();

	/* Variable de devolver */
	private int valoracion;
	private String comentario;

	public Devolver(String nombre, String ubicacion, String fecha, int codigoPostal, boolean disponiblilidad,
			int valoracion, String comentario) {
		super(nombre, ubicacion, fecha, codigoPostal, disponiblilidad);
		this.valoracion = valoracion;
		this.comentario = comentario;
	}

	/* Getter y setter de Devolver */
	// Valoracion
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public int getValoracion() {
		return valoracion;
	}

	// Comentario
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public String toString() {
		return ("Valoracion: " + valoracion + "\n Comentario: " + comentario);
	}

	public void verValoracion() {
		for (int i = 0; i < listaComentario.size(); i++) {
			listaComentario.get(i).toString();
		}
	}

	@Override
	public void Devolver(Recursos recurso) {
		// TODO Auto-generated method stub

		String comentario;
		// Valoracion
		System.out.println("Valoracion del 1-5: ");
		int valoracion = sc.nextInt();
		// Comantario
		System.out.println("Desea hacer un comentario ? (s/n)");
		sc = new Scanner(System.in);
		String a = sc.nextLine();
		if (a.equals("s")) {
			System.out.println("Comentario: ");
			sc = new Scanner(System.in);
			comentario = sc.nextLine();
			listaValoracion.add(valoracion);
			listaComentario.add(comentario);
		} else if (a.equals("n")) {
			listaValoracion.add(valoracion);
			listaComentario.add("");
		}

		super.Devolver(recurso);
	}

}
