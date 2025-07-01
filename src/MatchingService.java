public class MatchingService {
    public static boolean esCoincidencia(ReporteMascotaPerdida perdida, ReporteMascotaEncontrada encontrada) {
        Mascota m1 = perdida.getMascota();
        Mascota m2 = encontrada.getMascota();

        return m1.getTipo().equalsIgnoreCase(m2.getTipo()) &&
                m1.getRaza().equalsIgnoreCase(m2.getRaza()) &&
                m1.getColor().equalsIgnoreCase(m2.getColor()) &&
                m1.getTamanio().equalsIgnoreCase(m2.getTamanio());
    }
}
