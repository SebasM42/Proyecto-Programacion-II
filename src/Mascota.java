public class Mascota {
    private String nombre;
    private String tipo;
    private String raza;
    private String color;
    private String tamanio;

    public Mascota(String nombre, String tipo, String raza, String color, String tamanio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.color = color;
        this.tamanio = tamanio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getRaza() {
        return raza;
    }

    public String getColor() {
        return color;
    }

    public String getTamanio() {
        return tamanio;
    }

    public String getDescripcion() {
        return nombre + " - " + tipo + " - " + raza + " - " + color + " - " + tamanio;
    }
}
