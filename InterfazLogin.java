package ProyectoIntegrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazLogin extends JFrame {
    private JTextField tfNickname;
    private JPasswordField pfPassword;
    private JButton btnLogin;

    private ActionListener loginListener;

    public InterfazLogin() {
        setTitle("Inicio de Sesion");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        //Panel principal con un borde en el layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(64, 128, 128));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Panel para los campos de inicio de sesion
        JPanel loginPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        loginPanel.setBackground(new Color(64, 128, 128));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Etiqueta y campo de texto para el nickname
        JLabel lblNickname = new JLabel("Nickname:");
        lblNickname.setForeground(new Color(255, 255, 255));
        lblNickname.setFont(new Font("Tahoma", Font.BOLD, 15));
        tfNickname = new JTextField();
        tfNickname.setPreferredSize(new Dimension(150, 30));
        loginPanel.add(lblNickname);
        loginPanel.add(tfNickname);

        //Etiqueta y campo de contraseña para la contraseña
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        pfPassword = new JPasswordField();
        pfPassword.setPreferredSize(new Dimension(150, 30));
        loginPanel.add(lblPassword);
        loginPanel.add(pfPassword);

        //Botón de inicio de sesión
        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setPreferredSize(new Dimension(150, 40));
        btnLogin.setBackground(new Color(0, 0, 0));
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));

        //Escucha de eventos para el botón de inicio de sesión
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (loginListener != null) {
                    loginListener.actionPerformed(e);
                }
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(64, 128, 128));
        buttonPanel.add(btnLogin);

        mainPanel.add(loginPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        setVisible(true);
    }

    //Metodos para obtener el nickname y la contraseña ingresados por el usuario
    public String getNickname() {
        return tfNickname.getText();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    // Metodo para mostrar un mensaje en la interfaz gráfica
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Metodo para configurar el ActionListener para el botón de inicio de sesion
    public void setLoginListener(ActionListener listener) {
        this.loginListener = listener;
    }
}