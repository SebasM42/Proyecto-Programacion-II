import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
    private SistemaBusquedaMascotas sistema;
    private VentanaInicio ventanaInicio;

    private JTextField usuarioField;
    private JPasswordField contrasenaField;

    public VentanaLogin(SistemaBusquedaMascotas sistema, VentanaInicio ventanaInicio) {
        this.sistema = sistema;
        this.ventanaInicio = ventanaInicio;

        setTitle("Login");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Usuario:"));
        usuarioField = new JTextField();
        add(usuarioField);

        add(new JLabel("Contraseña:"));
        contrasenaField = new JPasswordField();
        add(contrasenaField);

        JButton btnLogin = new JButton("Login");
        add(new JLabel());
        add(btnLogin);

        btnLogin.addActionListener(e -> login());

        setVisible(true);
    }

    private void login() {
        String usuario = usuarioField.getText().trim();
        String contrasena = new String(contrasenaField.getPassword()).trim();

        Usuario u = sistema.login(usuario, contrasena);
        if (u != null) {
            ventanaInicio.loginExitoso(u);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

