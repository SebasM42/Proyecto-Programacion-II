import javax.swing.*;
import java.awt.*;

public class VentanaBuscarMascotas extends JFrame {
    private SistemaBusquedaMascotas sistema;

    public VentanaBuscarMascotas(SistemaBusquedaMascotas sistema) {
        this.sistema = sistema;

        setTitle("Buscar Mascotas");
        setSize(350, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        JTextField tipoField = new JTextField();
        JTextField razaField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField zonaField = new JTextField();

        inputPanel.add(new JLabel("Tipo:"));  inputPanel.add(tipoField);
        inputPanel.add(new JLabel("Raza:"));  inputPanel.add(razaField);
        inputPanel.add(new JLabel("Color:")); inputPanel.add(colorField);
        inputPanel.add(new JLabel("Zona:"));  inputPanel.add(zonaField);

        JButton buscarBtn = new JButton("Buscar");
        JTextArea resultadosArea = new JTextArea();
        resultadosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadosArea);

        add(inputPanel, BorderLayout.NORTH);
        add(buscarBtn, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        buscarBtn.addActionListener(e -> {
            String tipo = tipoField.getText().trim();
            String raza = razaField.getText().trim();
            String color = colorField.getText().trim();
            String zona = zonaField.getText().trim();

            resultadosArea.setText("");  // limpiar antes de mostrar resultados

            for (ReporteMascotaEncontrada encontrada : sistema.getEncontradas()) {
                Mascota m = encontrada.getMascota();
                if (m.getTipo().equalsIgnoreCase(tipo) &&
                        m.getRaza().equalsIgnoreCase(raza) &&
                        m.getColor().equalsIgnoreCase(color) &&
                        encontrada.getLugar().equalsIgnoreCase(zona)) {

                    resultadosArea.append(
                            "Mascota Encontrada:\n" +
                                    m.getDescripcion() + "\n" +
                                    "Lugar: " + encontrada.getLugar() + "\n" +
                                    "Fecha: " + encontrada.getFecha() + "\n\n"
                    );
                }
            }

            if (resultadosArea.getText().isEmpty()) {
                resultadosArea.setText("No se encontraron coincidencias.");
            }
        });

        setVisible(true);
    }
}
