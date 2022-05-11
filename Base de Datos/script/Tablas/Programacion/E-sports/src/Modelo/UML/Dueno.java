package Modelo.UML;

public class Dueno extends Persona {
    /**
     @author Inigo Bruk
     */
    private Equipo equipo;

    /**
     *
     * @param codPersona
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     * @param equipo
     */
    public Dueno(Integer codPersona, String dni, String nombre, String telefono, String mail, String localidad, Equipo equipo) {
        super(codPersona, dni, nombre, telefono, mail, localidad);
        this.equipo = equipo;

    }

    public Dueno() {
    }
    /**
     *
     * @param codPersona
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     */
    public Dueno(Integer codPersona, String dni, String nombre, String telefono, String mail, String localidad) {
        super(codPersona, dni, nombre, telefono, mail, localidad);

    }

    public Equipo getEquipo() {
        return equipo;
        /**
         * @retun equipo
         */
    }
    /**
     * @param equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
