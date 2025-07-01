import javax.swing.*;
import java.awt.*;

public class VentanaMenuPrincipal extends JFrame {
    private SistemaBusquedaMascotas sistema;
    private Usuario usuarioActual;

    public VentanaMenuPrincipal(SistemaBusquedaMascotas sistema, Usuario usuario) {
        this.sistema = sistema;
        this.usuarioActual = usuario;

        setTitle("Menú Principal - Bienvenido " + usuarioActual.getNombre());
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnRegistrarPerdida = new JButton("Registrar Mascota Perdida");
        JButton btnRegistrarEncontrada = new JButton("Registrar Mascota Encontrada");
        JButton btnBuscarMascotas = new JButton("Buscar Mascotas");
        JButton btnLogout = new JButton("Cerrar Sesión");
        JButton btnSalir = new JButton("Salir");

        add(btnRegistrarPerdida);
        add(btnRegistrarEncontrada);
        add(btnBuscarMascotas);
        add(btnLogout);
        add(btnSalir);

        btnRegistrarPerdida.addActionListener(e -> new VentanaRegistroMascotaPerdida(sistema, usuarioActual));
        btnRegistrarEncontrada.addActionListener(e -> new VentanaRegistroMascotaEncontrada(sistema, usuarioActual));
        btnBuscarMascotas.addActionListener(e -> new VentanaBuscarMascotas(sistema));
        btnLogout.addActionListener(e -> {
            this.dispose();
            new VentanaInicio(sistema);
        });
        btnSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}

