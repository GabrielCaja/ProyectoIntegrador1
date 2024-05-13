package ProyectoIntegrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class ControladorLogin {
    private InterfazLogin vista;
    private ModeloLogin modelo;

    public ControladorLogin(InterfazLogin vista, ModeloLogin modelo) {
        this.vista = vista;
        this.modelo = modelo;

        //Configurar el ActionListener para el boton de inicio de sesion en la Vista
        vista.setLoginListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nickname = vista.getNickname();
                String password = vista.getPassword();
                try {
                    modelo.autenticar(nickname, password);
                    vista.mostrarMensaje("Inicio de sesión exitoso");
                } catch (AutenticacionException ex) {
                    vista.mostrarMensaje("Error de autenticación: " + ex.getMessage());
                }
            }
        });
    }
}