public class Usuario {
    private String nombre;
    private String telefono;
    private String correo;
    private String usuario;
    private String contrasena;

    public Usuario(String nombre, String usuario, String contrasena, String telefono, String correo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.correo = correo;
    }

    public boolean autenticar(String usuario, String contrasena) {
        return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
}
