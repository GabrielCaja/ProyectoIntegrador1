package ProyectoIntegrador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuSuperRecursos extends JFrame {
    private JButton btnRegistrarse;
    private JButton btnLogin;
    private JButton btnInvitado;
    private JButton btnRecuperarContrasena;
    private JButton btnSalir;
    VistaInicial vista = new VistaInicial();
    
    public MenuSuperRecursos() {
        setTitle("Super Recursos");
        setSize(307, 441);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        getContentPane().add(panel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(64, 128, 128));
        panel_1.setBounds(0, 46, 297, 364);
        panel.add(panel_1);
        panel_1.setLayout(null);
        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBounds(61, 157, 176, 23);
        panel_1.add(btnRegistrarse);
        btnLogin = new JButton("Login");
        btnLogin.setBounds(61, 191, 176, 23);
        panel_1.add(btnLogin);
        btnInvitado = new JButton("Acceder como Invitado");
        btnInvitado.setBounds(61, 225, 176, 23);
        panel_1.add(btnInvitado);
        btnRecuperarContrasena = new JButton("Recuperar Contraseña");
        btnRecuperarContrasena.setBounds(61, 259, 176, 23);
        panel_1.add(btnRecuperarContrasena);
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(109, 314, 76, 23);
        panel_1.add(btnSalir);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(64, 128, 128));
        panel_2.setBounds(0, 0, 291, 46);
        panel.add(panel_2);
        
                //ActionListener para el boton "Salir"
                btnSalir.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int option = JOptionPane.showConfirmDialog(MenuSuperRecursos.this, "¿Estás seguro que quieres salir?", "Salir", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                    }
                });
        
                //ActionListener para el boton "Recuperar Contraseña"
                btnRecuperarContrasena.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(MenuSuperRecursos.this, "Opción: Recuperar Contraseña");
                    }
                });
        
                //ActionListener para el boton "Acceder como Invitado"
                btnInvitado.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        vista = new VistaInicial();
                        vista.frame.setVisible(true);

                    }
                });
                //ActionListener para el boton "Login"
                //Se puede iniciar sesion para comprobar que esta bien y funcionando de momento con un usuario de prueba
                //Usuario : usuario, Contraseña: pass
                btnLogin.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        InterfazLogin vistaLogin = new InterfazLogin();
                        ModeloLogin modeloLogin = new ModeloLogin();
                        ControladorLogin controladorLogin = new ControladorLogin(vistaLogin, modeloLogin);
                        vistaLogin.setVisible(true);

                    }
                });
        
                //ActionListener para el boton "Registrarse"
                btnRegistrarse.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(MenuSuperRecursos.this, "Opción: Registrarse");
                    }
                });
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuSuperRecursos();
            }
        });
    }
}
