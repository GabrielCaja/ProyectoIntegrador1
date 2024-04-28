package ProyectoIntegrador;

import java.util.*;

public class Registro {

	public ArrayList<Registro> listaClientes = new ArrayList<>();

	Scanner sc = new Scanner(System.in);
	boolean superEmpresa = false;
	boolean administrador = false;
	private int id = 0;
	private String nickname, nombre, contrasena, contrasena2, ubicacion, preguntaSeguridad, respuestaSeguridad,
			superPoder, confirmacion;

	public Registro() {
	}

	// Registrar un superheroe
	public Registro(int id, String nickname, String nombre, String superPoder, String contrasena, String contrasena2,
			String ubicacion, String preguntaSeguridad, String respuestaSeguridad, ArrayList<Registro> listaClientes,
			boolean administrador) {
		this.id = id;
		this.nickname = nickname;
		this.nombre = nombre;
		this.superPoder = superPoder;
		this.contrasena = contrasena;
		this.contrasena2 = contrasena2;
		this.ubicacion = ubicacion;
		this.preguntaSeguridad = preguntaSeguridad;
		this.respuestaSeguridad = respuestaSeguridad;
		this.administrador = administrador;
	}

	// Registrar una superEmpresa
	public Registro(int id, String nickname, String nombre, String superPoder, String contrasena, String contrasena2,
			String ubicacion, String preguntaSeguridad, String respuestaSeguridad, ArrayList<Registro> listaClientes,
			String confirmacion) {
		this.id = id;
		this.nickname = nickname;
		this.nombre = nombre;
		this.superPoder = superPoder;
		this.contrasena = contrasena;
		this.contrasena2 = contrasena2;
		this.ubicacion = ubicacion;
		this.preguntaSeguridad = preguntaSeguridad;
		this.respuestaSeguridad = respuestaSeguridad;
		this.confirmacion = confirmacion;
	}

	public ArrayList<Registro> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Registro> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContrasena2() {
		return contrasena2;
	}

	public void setContrasena2(String contrasena2) {
		this.contrasena2 = contrasena2;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getSuperPoder() {
		return superPoder;
	}

	public void setSuperPoder(String superPoder) {
		this.superPoder = superPoder;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPreguntaSeguridad() {
		return preguntaSeguridad;
	}

	public void setPreguntaSeguridad(String preguntaSeguridad) {
		this.preguntaSeguridad = preguntaSeguridad;
	}

	public String getRespuestaSeguridad() {
		return respuestaSeguridad;
	}

	public void setRespuestaSeguridad(String respuestaSeguridad) {
		this.respuestaSeguridad = respuestaSeguridad;
	}

	public String getNickname() {
		return nickname;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setContrasena(String contrasenaCambiada) {
		this.contrasena = contrasenaCambiada;
	}

	public void setContrasena1(String contrasenaCambiada2) {
		this.contrasena2 = contrasenaCambiada2;

	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public boolean getAdministrador(Registro re) {
		return re.administrador;
	}

	// Registro principal para los clientes de la plataforma
	public void registrarCliente() {

		id++;
		System.out.println("Introduce el nickname:");
		String nickname = sc.next();
		asignarNickname(nickname);

		System.out.println("Introduce tu nombre:");
		String nombre = sc.next();

		System.out.println("Introduce tu superpoder:");
		String superPoder = sc.next();

		System.out.println("Introduce la contraseña:");
		String contrasena = sc.next();

		System.out.println("Introduce la contraseña nuevamente:");
		String contrasena2 = sc.next();
		comprobarContraseña(contrasena, contrasena2);

		System.out.println("Introduce la ubicación:");
		String ubicacion = sc.next();

		System.out.println("Pregunta de seguridad: Donde naciste?:");
		String preguntaSeguridad = "Donde naciste";

		System.out.println("Introduce la respuesta de seguridad:");
		String respuestaSeguridad = sc.next();

		System.out.println("Eres superempresa?");
		String superEmpresaC = sc.next();
		// En el caso de ser superempresa
		if (superEmpresaC.equals("si")) {
			superEmpresa = true;
			System.out.println("¿Tu empresa ha estado luchando contra el crimen durante más de 14 años? (Sí/No):");
			String confirmacionCrimen = sc.nextLine().toLowerCase();

			System.out.println("¿Aceptas los términos y condiciones? (Sí/No):");
			String aceptacionTerminos = sc.nextLine().toLowerCase();

			Registro superEmpresa = new Registro();
			if (confirmacionCrimen.equals("sí") && aceptacionTerminos.equals("sí")) {
				String confirmacion = "Acepto terminos";
				superEmpresa = new Registro(id, nickname, nombre, superPoder, contrasena, contrasena2, ubicacion,
						preguntaSeguridad, respuestaSeguridad, listaClientes, true);
				// Registro de una superempresa
				listaClientes.add(superEmpresa);

			}

		}

		// Registro de un superheroe
		Registro registro = new Registro(id, nickname, nombre, superPoder, contrasena, contrasena2, ubicacion,
				preguntaSeguridad, respuestaSeguridad, listaClientes, administrador);
		System.out.println("Registro completo!, bienvenido a la plataforma " + nombre);
		listaClientes.add(registro);

	}

	private void asignarNickname(String nickname) {
		while (!validarNickname(nickname) || listaClientes.contains(nickname)) {
			System.out.println("El nickname no es válido o ya está en uso. Inténtalo de nuevo:");
			nickname = sc.next();

		}
		this.nickname = nickname;
	}

	private boolean validarNickname(String nickname) {
		// Verificar si el nickname cumple con los requisitos de estar compuesto por
		// caracteres anglosajones y números
		return nickname.matches("^[a-zA-Z0-9]+$");
	}

	// Se comprobara la contraseña para ver que cumple las medidas de seguridad y
	// requisitos
	public void comprobarContraseña(String contrasena, String contrasena2) {
		while (!contrasena.equals(contrasena2) || !validarContraseña(contrasena)) {
			System.out.println("Las contraseñas no son iguales o no cumplen con los requisitos mínimos.");
			System.out.println("Introduce la contraseña:");
			contrasena = sc.next();

			System.out.println("Introduce la contraseña nuevamente:");
			contrasena2 = sc.next();
		}
	}

	// Se comprobara la contraseña para ver que cumple las medidas de seguridad y
	// requisitos
	private boolean validarContraseña(String password) {
		return password.length() >= 6 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")
				&& password.matches(".*\\d.*");
	}

	// Metodo para cambiar la contraseña a partir de comprobar la pregunta y
	// respuesta de seguridad y con un numero de intentos preestablecido(3)
	public void restablecerContraseña(Scanner sc) {
		int intentos = 3;
		do {
			System.out.println("¿Cuál es tu nickname en la plataforma?");
			String nickname = sc.next();

			Registro registro = buscarRegistroPorNickname(nickname);
			if (registro != null) {
				System.out.println("Indica la respuesta a tu pregunta de seguridad:");
				System.out.println(registro.getPreguntaSeguridad());
				String respuesta = sc.next();

				if (registro.getRespuestaSeguridad().equals(respuesta)) {
					System.out.println("Introduce tu nueva contraseña:");
					String nuevaContraseña = sc.next();

					System.out.println("Introduce la nueva contraseña nuevamente:");
					String nuevaContraseñaConfirmacion = sc.next();

					registro.comprobarContraseña(nuevaContraseña, nuevaContraseñaConfirmacion);
					registro.setContrasena(nuevaContraseña);
					registro.setContrasena1(nuevaContraseñaConfirmacion);

					System.out.println("Contraseña cambiada con éxito.");
					// Salir del método una vez que la contraseña se haya cambiado con éxito
					return;
				} else {
					System.out.println("Respuesta incorrecta. Intenta de nuevo ." + intentos + " intentos");
					intentos--;
				}
			} else {
				System.out.println(
						"No se encontró el usuario con el nickname proporcionado, te quedan " + intentos + " intentos");
				intentos--;
			}
		} while (intentos > 0);

		System.out.println("Se ha excedido el número máximo de intentos.");
	}

	// Comprobar que el usuario esta registrado en la plataforma
	private Registro buscarRegistroPorNickname(String nickname) {
		for (Registro registro : listaClientes) {
			if (registro.getNickname().equals(nickname)) {
				return registro;
			}
		}
		return null;
	}

	// Metodo para iniciar sesion verificando si el usuario existe registrado en la
	// plataforma
	public void iniciarSesion(Scanner sc) {
		System.out.println("Introduzce tu nickname de usuario:");
		String nickname = sc.next();
		System.out.println("Introduzce tu contraseña:");
		String contrasena = sc.next();

		boolean usuarioEncontrado = false;
		for (Registro registro : listaClientes) {
			if (registro.getNickname().equals(nickname) && registro.getContrasena().equals(contrasena)) {
				System.out.println("Bienvenido de nuevo: " + registro.getNombre());
				usuarioEncontrado = true;
				Main main = new Main();
				break;
			}

		}
		// En caso de no encontrar al usuario
		if (!usuarioEncontrado) {
			System.out.println("Credenciales incorrectas. Por favor, inténtalo de nuevo.");
		}

	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", nickname=" + nickname + ", nombre=" + nombre + ", contrasena=" + contrasena
				+ ", contrasena2=" + contrasena2 + ", ubicacion=" + ubicacion + ", preguntaSeguridad="
				+ preguntaSeguridad + ", respuestaSeguridad=" + respuestaSeguridad + ", superPoder=" + superPoder + "]";
	}

	public void registrarse() {
		// TODO Auto-generated method stub

	}

}
