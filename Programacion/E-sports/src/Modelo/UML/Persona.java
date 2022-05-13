package Modelo.UML;

public class Persona {
    /**
    @author Inigo Bruk
    */
    private Integer codPersona;
    private String dni;
    private String nombre;
    private String telefono;
    private String mail;
    private String localidad;

    /**
     *
     * @param codPersona
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     */

    public Persona(Integer codPersona, String dni, String nombre, String telefono, String mail, String localidad) {
        this.codPersona = codPersona;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.localidad = localidad;
    }

    public Persona() {
    }

    public Integer getCodPersona() {
        return codPersona;
        /**
         * @retun codPersona
         */
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public String getDni() {
        return dni;
        /**
         * @retun dni
         */
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
        /**
         * @retun nombre
         */
    }
    /**
     * @param telefono
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @retun telefono
     */
    public String getTelefono() {
        return telefono;

    }
    /**
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @retun mail
     */
    public String getMail() {
        return mail;

    }
    /**
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLocalidad() {
        return localidad;
        /**
         * @retun localidad
         */
    }
    /**
     * @param localidad
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
