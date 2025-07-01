import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaBusquedaMascotas {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<ReporteMascotaPerdida> perdidas = new ArrayList<>();
    private List<ReporteMascotaEncontrada> encontradas = new ArrayList<>();
    private int contadorId = 1;

    // ============================
    // Registro de Usuarios
    // ============================
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario login(String usuario, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.autenticar(usuario, contrasena)) {
                return u;
            }
        }
        return null;
    }

    // ============================
    // Registro de Mascotas Perdidas
    // ============================
    public void registrarMascotaPerdida(Mascota mascota, String lugar, Date fecha, Usuario usuario) {
        ReporteMascotaPerdida reporte = new ReporteMascotaPerdida(contadorId++, mascota, lugar, fecha, usuario);
        perdidas.add(reporte);
    }

    // ============================
    // Registro de Mascotas Encontradas
    // ============================
    public void registrarMascotaEncontrada(Mascota mascota, String lugar, Date fecha, Usuario usuario) {
        ReporteMascotaEncontrada reporte = new ReporteMascotaEncontrada(mascota, lugar, fecha, usuario);
        encontradas.add(reporte);
        buscarCoincidencias(reporte);
    }

    // ============================
    // Buscar Coincidencias Automáticas
    // ============================
    public void buscarCoincidencias(ReporteMascotaEncontrada encontrada) {
        for (ReporteMascotaPerdida perdida : perdidas) {
            if (MatchingService.esCoincidencia(perdida, encontrada)) {
                System.out.println("¡Coincidencia encontrada!");
                System.out.println("Dueño: " + perdida.getDueño().getNombre());
                System.out.println("Rescatista: " + encontrada.getRescatista().getNombre());
            }
        }
    }

    // ============================
    // Búsqueda Manual (Para VentanaBuscarMascotas)
    // ============================
    public List<ReporteMascotaEncontrada> getEncontradas() {
        return encontradas;
    }

    public List<ReporteMascotaPerdida> getPerdidas() {
        return perdidas;
    }

    public void buscarMascotas(String tipo, String raza, String color, String zona) {
        for (ReporteMascotaEncontrada encontrada : encontradas) {
            Mascota m = encontrada.getMascota();
            if (m.getTipo().equalsIgnoreCase(tipo) &&
                    m.getRaza().equalsIgnoreCase(raza) &&
                    m.getColor().equalsIgnoreCase(color) &&
                    encontrada.getLugar().equalsIgnoreCase(zona)) {
                System.out.println(m.getDescripcion());
            }
        }
    }
}

