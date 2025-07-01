import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SistemaBusquedaMascotas sistema = new SistemaBusquedaMascotas();

        SwingUtilities.invokeLater(() -> new VentanaInicio(sistema));
    }
}
