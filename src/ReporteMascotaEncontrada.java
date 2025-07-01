import java.util.Date;

public class ReporteMascotaEncontrada extends ReporteMascota {
    private Usuario rescatista;

    public ReporteMascotaEncontrada(Mascota mascota, String lugar, Date fecha, Usuario rescatista) {
        super(mascota, lugar, fecha);
        this.rescatista = rescatista;
    }

    public Usuario getRescatista() {
        return rescatista;
    }

    @Override
    public Usuario getReportante() {
        return rescatista;
    }
}
