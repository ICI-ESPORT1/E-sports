package Modelo.UML;

public class Entrenador extends Persona {

    /**
     * @Author Inigo Bruk
     * @Version 1.0
     */
    private Equipo equipo;
    private float sueldo;
    /**
     *
     * @param dni dni entrenador
     * @param nombre nombre entrenador
     * @param telefono telefono entrenador
     * @param sueldo sueldo entrenador
     */
    public Entrenador(String dni, String nombre, String telefono, String direccion, float sueldo) {
        super(dni, nombre, telefono, direccion);
        this.sueldo = sueldo;
    }

    public Entrenador(float sueldo) {
        this.sueldo = sueldo;
    }

    /**
     *
     * @param dni dni entrenador
     * @param nombre nombre entrenador
     * @param telefono telefono entrenador
     * @param equipo equipo entrenador
     * @param sueldo sueldo entrenador
     */
    public Entrenador(String dni, String nombre, String telefono, String direccion, Equipo equipo, float sueldo) {
        super(dni, nombre, telefono, direccion);
        this.equipo = equipo;
        this.sueldo = sueldo;
    }

    /**
     *
     * @param equipo equipo entrenador
     * @param sueldo sueldo entrenador
     */
    public Entrenador(Equipo equipo, float sueldo) {
        this.equipo = equipo;
        this.sueldo = sueldo;
    }

    public Entrenador() {
    }

    /**
     * @retun equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     *
     * @param equipo setEquipo
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
     * @param sueldo setSueldo
     */
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

}
