package ProyectoIntegrador;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);// Scanner
		// Objetos
		Recursos recursos = new Recursos(null, null, null, 0, false);
		Devolver devolver = new Devolver(null, null, null, 0, false, 0, null);
		Alquilar alquilar = new Alquilar(null, null, null, 0, false);

		// Recursos
		Recursos batmovil = new Recursos("Batmovil", "Gotam", "27/02/1924", 67425, false);
		Recursos batCinturon = new Recursos("Bat Cinturon", "Gotam", "27/02/1924", 67425, false);
		Recursos bastonAbuela = new Recursos("Baston de la abuela", "NYC", "19/04/1965", 38402, false);
		Recursos chancla = new Recursos("Chancla", "Bogota", "18/12/1999", 33202, false);
		Recursos capaSuperman = new Recursos("Capa de Superman", "LongVille", "12/02/1979", 49310, false);
		Recursos raton = new Recursos("Lab Rat (Eduardo)", "EEUU", "10/01/1889", 37921, false);
		// Añadir Recursos
		recursos.añadirDis(batmovil);
		recursos.añadirDis(batCinturon);
		recursos.añadirDis(bastonAbuela);
		recursos.añadirDis(chancla);
		recursos.añadirDis(capaSuperman);
		recursos.añadirDis(raton);

		// Voy a crear un administrador para comprobar las credenciales
		Administrador Carlos = new Administrador(0, "Carlos", null, null, null, null, null, true, null);
		Administrador Juan = new Administrador(1, null, null, null, null, null, null, false, null);

		// para alñadir y ver ubicacione sprivadas creo el objeto u1
		UbicacionesPrivadas u1 = new UbicacionesPrivadas();
		// añadimos las actuales ubicaciones de los objetos a la lista de ubicaciones
		// IMLORTANTE
		for (int i = 0; i < 6; i++) {
			u1.añadirUbicacion(recursos.getRecursoDisponible(i).getUbicacion());
		}
		Registro registro0 = new Registro();
		int opcion0;

		do {
			System.out.println("----------MENU----------");
			System.out.println("1. Registro");
			System.out.println("2. Iniciar sesion");
			System.out.println("3. Acceder como invitado (sin login)");
			System.out.println("4. Olvide la contraseña");
			System.out.println("5. Salir");
			System.out.println("Elije una opcion:");
			opcion0 = sc.nextInt();
			switch (opcion0) {
			// REGISTRO
			case 1:
				registro0.registrarCliente();
				System.out.println("Eres Administrador(s/n)?:");
				sc = new Scanner(System.in);
				String aceptacionAdministrador = sc.nextLine().toLowerCase();
				if (aceptacionAdministrador.equals("s")) {
					registro0.setAdministrador(true);
				}
				break;
			// LOGIN
			case 2:
				registro0.iniciarSesion(sc);
				// Menu si es administrador
				if (registro0.getAdministrador(registro0) == true) {

					// Variables
					int opcion = 0;
					int idProducto;

					// Bucle para poder salir solo cuando pulse salir
					do {

						System.out.println("****Menu****");
						System.out.println("1.Tomar Prestado");
						System.out.println("2.Devolver");
						System.out.println("3.Ver Recursos disponibles");
						System.out.println("4.Ver Recursos Prestados");
						System.out.println("5.Añadir ubicacion privada");
						System.out.println("6.Ver ubicaciones privadas");
						System.out.println("7.Añadir un recurso");
						System.out.println("8.Buscar recursos por ubicacion");
						System.out.println("9.Salir");
						System.out.println("----------");
						opcion = sc.nextInt();

						switch (opcion) {
						case 1:
							// Para alquilar cosas
							recursos.verProductosDisponibles();// Para ver disponibles
							System.out.println("Ingrese la opcion a elegir: ");
							idProducto = sc.nextInt();
							System.out.println("ingrese la fecha del prestamo(DD/M/AA): ");
							sc = new Scanner(System.in);
							String fecha = sc.nextLine();
							recursos.getRecursoDisponible(idProducto - 1).setFecha(fecha);
							recursos.cambiarDisponibilidad(recursos.getRecursoDisponible(idProducto - 1));
							recursos.añadirNo(recursos.getRecursoDisponible(idProducto - 1));
							alquilar.Alquilar(recursos.getRecursoDisponible(idProducto - 1));
							recursos.eliminarDis(recursos.getRecursoDisponible(idProducto - 1));
							break;
						case 2:
							// Para devolver cosas
							recursos.verProductosNoDisponibles();// Para ver NO disponibles
							System.out.println("Ingrese la opcion a elegir: ");
							idProducto = sc.nextInt();
							recursos.cambiarDisponibilidad(recursos.getRecursoNoDisponible(idProducto - 1));
							recursos.añadirDis(recursos.getRecursoNoDisponible(idProducto - 1));
							devolver.Devolver(recursos.getRecursoNoDisponible(idProducto - 1));
							recursos.eliminarNo(recursos.getRecursoNoDisponible(idProducto - 1));
							break;
						case 3:
							recursos.verProductosDisponibles();// Para ver disponibles

							break;
						case 4:
							recursos.verProductosNoDisponibles();// Para ver NO disponibles

							break;
						case 5:
							System.out.println("Nombre de la nueva ubicacion privada: ");
							sc = new Scanner(System.in);
							String ubi = sc.nextLine();
							u1.añadirUbicacion(ubi);
							break;
						case 6:
							u1.verUbicaciones();
							break;
						case 7:
							System.out.println("Ingrese el nombre del nuevo recurso: ");
							sc = new Scanner(System.in);
							String nombre = sc.nextLine();
							System.out.println("Ingrese la localizacion del  nuevo recurso: ");
							sc = new Scanner(System.in);
							String ubicacion = sc.nextLine();
							System.out.println("ingrese la fecha de alta(DD/MM/AA): ");
							sc = new Scanner(System.in);
							String date = sc.nextLine();
							System.out.println("Codigo postal : ");
							sc = new Scanner(System.in);
							int cod = sc.nextInt();
							Recursos newRecurso = new Recursos(nombre, ubicacion, date, cod, false);
							recursos.añadirDis(newRecurso);
							break;
						case 8:

							System.out.println("Ingrese el nombre de la ubicacion a buscar");
							sc = new Scanner(System.in);
							String n = sc.nextLine();
							recursos.burcarUbi(n);

							break;
						default:
							throw new IllegalArgumentException("Unexpected value: " + opcion);
						}

						// Fin bucle //Bucle para poder salir csolo cuando pulse salir

					} while (opcion != 9);

				} else if (registro0.getAdministrador(registro0) == false) {

					// Menu del ususario no administrador
					// Solo le permitira hacer cosas

					// Variables
					int opcion1 = 0;
					do {

						System.out.println("****Menu****");
						System.out.println("1.Ver Recursos disponibles");
						System.out.println("2.Ver Recursos Prestados");
						System.out.println("3.Salir");
						System.out.println("----------");
						System.out.println("Ingrese la opcion a elegir: ");
						opcion1 = sc.nextInt();

						switch (opcion1) {
						case 1:
							recursos.verProductosDisponibles();// Para ver disponibles

							break;

						case 2:
							recursos.verProductosNoDisponibles();// Para ver NO disponibles

							break;
						case 3:
							System.out.println("Saliendo... .");
							break;
						default:
							break;
						}
					} while (opcion1 != 3);

				}

				break;
			case 3:
				// Iniciar sesion como invitado

				break;
			// Recuperar contraseña
			case 4:
				registro0.restablecerContraseña(sc);
				break;
			case 5:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opcion no valida, introduce otra opcion:");
				break;
			}
		} while (opcion0 != 5);

		// Parte para ver las preguntas Frecuentes
		System.out.println("Desea ver las Preguntas Frecuentes?(s/n)");
		sc = new Scanner(System.in);
		String a = sc.nextLine();
		if (a.equals("s")) {
			PreguntasFrecuentes p1 = new PreguntasFrecuentes();
			p1.toString();
		}

	}

}
