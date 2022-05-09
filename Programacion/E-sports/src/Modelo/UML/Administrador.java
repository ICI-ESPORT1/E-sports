package Modelo.UML;

public class Administrador {
    private int idAdministrador;
    private String nombre;
    private String apellido;
    private String password;
    private GrupoUsuario tipoUsuario;

    public Administrador(int idAdministrador, String nombre, String apellido, String password, GrupoUsuario tipoUsuario) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public Administrador() {
    }

    public Administrador(int idAdministrador, String nombre, String apellido, String password) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GrupoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(GrupoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdministrador=" + idAdministrador +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", password='" + password + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
