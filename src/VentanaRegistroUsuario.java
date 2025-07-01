import javax.swing.*;
import java.awt.*;

public class VentanaRegistroUsuario extends JFrame {
    private SistemaBusquedaMascotas sistema;

    private JTextField nombreField;
    private JTextField usuarioField;
    private JPasswordField contrasenaField;
    private JTextField telefonoField;
    private JTextField correoField;

    public VentanaRegistroUsuario(SistemaBusquedaMascotas sistema) {
        this.sistema = sistema;

        setTitle("Registro de Usuario");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(6, 2, 5, 5));

        nombreField = new JTextField();
        usuarioField = new JTextField();
        contrasenaField = new JPasswordField();
        telefonoField = new JTextField();
        correoField = new JTextField();

        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Usuario:"));
        add(usuarioField);
        add(new JLabel("Contraseña:"));
        add(contrasenaField);
        add(new JLabel("Teléfono:"));
        add(telefonoField);
        add(new JLabel("Correo:"));
        add(correoField);

        JButton botonRegistrar = new JButton("Registrar");
        add(botonRegistrar);

        botonRegistrar.addActionListener(e -> registrarUsuario());

        setVisible(true);
    }

    private void registrarUsuario() {
        String nombre = nombreField.getText().trim();
        String usuario = usuarioField.getText().trim();
        String contrasena = new String(contrasenaField.getPassword()).trim();
        String telefono = telefonoField.getText().trim();
        String correo = correoField.getText().trim();

        if (nombre.isEmpty() || usuario.isEmpty() || contrasena.isEmpty() || telefono.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario nuevo = new Usuario(nombre, usuario, contrasena, telefono, correo);
        sistema.registrarUsuario(nuevo);

        JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}
