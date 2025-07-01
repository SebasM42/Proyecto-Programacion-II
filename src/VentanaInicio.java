import javax.swing.*;
import java.awt.*;

public class VentanaInicio extends JFrame {
    private SistemaBusquedaMascotas sistema;

    public VentanaInicio(SistemaBusquedaMascotas sistema) {
        this.sistema = sistema;

        setTitle("Bienvenido al Sistema de Mascotas");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnRegistrarUsuario = new JButton("Registrar Usuario");
        JButton btnLogin = new JButton("Login");
        JButton btnSalir = new JButton("Salir");

        add(btnRegistrarUsuario);
        add(btnLogin);
        add(btnSalir);

        btnRegistrarUsuario.addActionListener(e -> new VentanaRegistroUsuario(sistema));
        btnLogin.addActionListener(e -> new VentanaLogin(sistema, this));
        btnSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    // Método llamado DESPUÉS de login exitoso
    public void loginExitoso(Usuario usuario) {
        JOptionPane.showMessageDialog(this, "Bienvenido " + usuario.getNombre() + "!");
        this.dispose();
        new VentanaMenuPrincipal(sistema, usuario);
    }
}
