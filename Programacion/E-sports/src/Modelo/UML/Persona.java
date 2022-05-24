package Modelo.UML;

public class Persona {
    /**
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

    /**
     * constructor vacio de persona
     */
    public Persona() {
    }

    /**
     *
     * @return
     */
    public Integer getCodPersona() {
        return codPersona;
    }

    /**
     *
     * @param codPersona
     */
    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    /**
     *
     * @return
     */
    public String getDni() {
        return dni;

    }

    /**
     *
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @retun
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


    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * @param localidad
     */
    public void setLocalidad(String localidad) {
        this.direccion = direccion;
    }
}
