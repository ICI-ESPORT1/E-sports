package Modelo.UML;

public class Entrenador extends Persona {

    /**
     @author Inigo Bruk
     */
    private Equipo equipo;
    private float sueldo;
    /**
     *
     * @param codPersona
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     * @param sueldo
     */
    public Entrenador(Integer codPersona, String dni, String nombre, String telefono, String mail, String localidad, float sueldo) {
        super(codPersona, dni, nombre, telefono, mail, localidad);
        this.sueldo = sueldo;

    }
    /**
     *
     */


    public Entrenador(String dni, String n, String l, String t, Float s) {
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
