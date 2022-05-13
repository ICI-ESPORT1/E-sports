package MODELO.UML;

public class GrupoUsuario {
    private int idRol;
    private String descripcion;
    private Administrador admin;

    public GrupoUsuario() {
    }

    public GrupoUsuario(int idRol, String descripcion, Administrador admin) {
        this.idRol = idRol;
        this.descripcion = descripcion;
        this.admin = admin;
    }

    public GrupoUsuario(int idRol, String descripcion) {
        this.idRol = idRol;
        this.descripcion = descripcion;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "GrupoUsuario{" +
                "idRol=" + idRol +
                ", descripcion='" + descripcion + '\'' +
                ", admin=" + admin +
                '}';
    }


}
