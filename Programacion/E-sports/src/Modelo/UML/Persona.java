package Modelo.UML;

public class Persona {
    /**
     * @Author Inigo Bruk
     * @Version 1.0
     */
    private Integer codPersona;
    private String dni;
    private String nombre;
    private String telefono;
    private String direccion;


    public Persona(Integer codPersona, String dni, String nombre, String telefono, String direccion) {
        this.codPersona = codPersona;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    /**
     *
     * @param dni
     * @param nombre
     * @param telefono
     * @param direccion
     */


    public Persona( String dni, String nombre, String telefono, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
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

    /**
     * @retun nombre
     */
    public String getNombre() {
        return nombre;

    }
    /**
     * @param nombre
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



    public String getDireccion() {
        return direccion;
        /**
         * @retun localidad
         */
    }
    /**
     * @param localidad
     */
    public void setLocalidad(String localidad) {
        this.direccion = direccion;
    }
}
