package Modelo.UML;

public class Entrenador extends Persona {

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
     * @param mail
     * @param localidad
     * @param sueldo
     */
    public Entrenador( String dni, String nombre, String telefono, String mail, String localidad, float sueldo) {
        super( dni, nombre, telefono, mail, localidad);
        this.sueldo = sueldo;

    }

    /**
     *
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     * @param equipo
     * @param sueldo
     */
    public Entrenador(String dni, String nombre, String telefono, String mail, String localidad, Equipo equipo, float sueldo) {
        super(dni, nombre, telefono, mail, localidad);
        this.equipo = equipo;
        this.sueldo = sueldo;
    }

    /**
     * @retun equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     *
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
     *
     * @param sueldo
     */
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
}
