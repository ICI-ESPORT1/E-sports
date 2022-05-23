package Modelo.UML;

public class Asistente extends Persona {
    /**
     * @Author Inigo Bruk
     * @Version 1.0
     */

    private float sueldo;

    public Asistente() {
    }

    public Asistente(String dni, String nombre, String telefono, String direccion) {
        super(dni, nombre, telefono, direccion);
    }

    public Asistente(Equipo equipo, float sueldo) {

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
