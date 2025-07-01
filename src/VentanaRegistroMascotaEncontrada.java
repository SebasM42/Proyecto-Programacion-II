import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class VentanaRegistroMascotaEncontrada extends JFrame {
    private SistemaBusquedaMascotas sistema;
    private Usuario usuario;

    public VentanaRegistroMascotaEncontrada(SistemaBusquedaMascotas sistema, Usuario usuario) {
        this.sistema = sistema;
        this.usuario = usuario;

        setTitle("Registrar Mascota Encontrada");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 5, 5));

        JTextField nombreField = new JTextField();
        JTextField tipoField = new JTextField();
        JTextField razaField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField tamanioField = new JTextField();
        JTextField lugarField = new JTextField();

        add(new JLabel("Nombre:")); add(nombreField);
        add(new JLabel("Tipo:")); add(tipoField);
        add(new JLabel("Raza:")); add(razaField);
        add(new JLabel("Color:")); add(colorField);
        add(new JLabel("Tamaño:")); add(tamanioField);
        add(new JLabel("Lugar encontrado:")); add(lugarField);

        JButton registrarBtn = new JButton("Registrar");
        add(new JLabel());
        add(registrarBtn);

        registrarBtn.addActionListener(e -> {
            Mascota mascota = new Mascota(
                    nombreField.getText(),
                    tipoField.getText(),
                    razaField.getText(),
                    colorField.getText(),
                    tamanioField.getText()
            );
            sistema.registrarMascotaEncontrada(mascota, lugarField.getText(), new Date(), usuario);
            JOptionPane.showMessageDialog(this, "Mascota encontrada registrada exitosamente.");
            dispose();
        });

        setVisible(true);
    }
}
