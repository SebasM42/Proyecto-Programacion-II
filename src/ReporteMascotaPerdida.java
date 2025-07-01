import java.util.Date;

public class ReporteMascotaPerdida extends ReporteMascota {
    private int id;
    private Usuario duenio;

    public ReporteMascotaPerdida(int id, Mascota mascota, String lugar, Date fecha, Usuario duenio) {
        super(mascota, lugar, fecha);
        this.id = id;
        this.duenio = duenio;
    }

    public int getId() {
        return id;
    }

    public Usuario getDueño() {
        return duenio;
    }

    @Override
    public Usuario getReportante() {
        return duenio;
    }
}
