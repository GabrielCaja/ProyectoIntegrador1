package ProyectoIntegrador;

public class ModeloLogin {
    public void autenticar(String nickname, String password) throws AutenticacionException {
        //Logica de autenticacion
        if (!nickname.equals("usuario") || !password.equals("pass")) {
            throw new AutenticacionException("Credenciales incorrectas");     
        }
    }
}
