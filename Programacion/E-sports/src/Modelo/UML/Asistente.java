package Modelo.UML;

public class Asistente extends Persona {
    /**
     @author Inigo Bruk
     */
    private Equipo equipo;
    private float sueldo;

    /**
     *
     * @param dni
     * @param nombre
     * @param telefono
     * @parm direccion
     * @param equipo
     * @param sueldo
     */
    public Asistente( String dni, String nombre, String telefono, String direccion, Equipo equipo, float sueldo) {
        super( dni, nombre, telefono, direccion);
        this.equipo = equipo;
        this.sueldo = sueldo;
    }

    public Asistente(Equipo equipo, float sueldo) {
        this.equipo = equipo;
        this.sueldo = sueldo;
    }

    public Asistente(String dni, String nombre, String telefono, String direccion, float sueldo) {
        super(dni, nombre, telefono, direccion);
        this.sueldo = sueldo;
    }

    public Asistente(float sueldo) {
        this.sueldo = sueldo;
    }

    public Asistente(String dni, String n, String d, String t, String m, Equipo equipo, Float s) {
    }
    /**
     * @retun equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }
    /**
     * @param equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    /**
     * @retun sueldo
     */
    public float getSueldo() {
        return sueldo;
    }
    /**
     * @param sueldo
     */
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
}
