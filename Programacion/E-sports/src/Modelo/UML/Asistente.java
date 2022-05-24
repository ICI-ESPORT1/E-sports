package Modelo.UML;

public class Asistente extends Persona {
    /**
     * @Author Inigo Bruk
     * @Version 1.0
     */

    private float sueldo;

    /**
     * Constructor vacio de asistente
     */
    public Asistente() {
    }

    /**
     * constructor super de persona
     * @param dni
     * @param nombre
     * @param telefono
     * @param direccion
     */
    public Asistente(String dni, String nombre, String telefono, String direccion) {
        super(dni, nombre, telefono, direccion);
    }

    /**
     * constructor de sueldo y equipo
     * @param equipo
     * @param sueldo
     */
    public Asistente(Equipo equipo, float sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * constructor con el super y sueldo.
     * @param dni
     * @param nombre
     * @param telefono
     * @param direccion
     * @param sueldo
     */
    public Asistente(String dni, String nombre, String telefono, String direccion, float sueldo) {
        super(dni, nombre, telefono, direccion);
        this.sueldo = sueldo;
    }

    /**
     * constructor solo sueldo
     * @param sueldo
     */
    public Asistente(float sueldo) {

        this.sueldo = sueldo;
    }

    /**
     *
     * @param dni
     * @param n
     * @param d
     * @param t
     * @param m
     * @param equipo
     * @param s
     */
    public Asistente(String dni, String n, String d, String t, String m, Equipo equipo, Float s) {
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
