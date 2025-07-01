import java.util.Date;

public abstract class ReporteMascota {
    protected Mascota mascota;
    protected String lugar;
    protected Date fecha;

    public ReporteMascota(Mascota mascota, String lugar, Date fecha) {
        this.mascota = mascota;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public String getLugar() {
        return lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public abstract Usuario getReportante();
}
