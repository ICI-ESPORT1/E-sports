package MODELO.UML;

public class Jugador extends Persona {
    /**
     @author Inigo Bruk
     */
    private String nickname;
    private Rol rol;
    private float salario;
    private Equipo equipo;

    /**
     * @param codPersona
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     * @param nickname
     * @param rol
     * @param salario
     */
    public Jugador(Integer codPersona, String dni, String nombre, String telefono, String mail, String localidad, String nickname, Rol rol, float salario) {
        super(codPersona, dni, nombre, telefono, mail, localidad);
        this.nickname = nickname;
        this.rol = rol;
        this.salario = salario;
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
    public Jugador(Integer codPersona, String dni, String nombre, String telefono, String mail, String localidad) {
        super(codPersona, dni, nombre, telefono, mail, localidad);

    }
    /**
     * @param codPersona
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     * @param nickname
     * @param rol
     * @param salario
     * @param equipo
     */
    public Jugador(Integer codPersona, String dni, String nombre, String telefono, String mail, String localidad, String nickname, Rol rol, float salario, Equipo equipo) {
        super(codPersona, dni, nombre, telefono, mail, localidad);
        this.nickname = nickname;
        this.rol = rol;
        this.salario = salario;
        this.equipo = equipo;
    }

    public Jugador() {
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
     * @retun nickname
     */
    public String getNickname() {
        return nickname;

    }
    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    /**
     * @retun rol
     */
    public Rol getRol() {
        return rol;

    }
    /**
     * @param rol
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    /**
     * @retun salario
     */
    public float getSalario() {
        return salario;

    }
    /**
     * @param salario
     */
    public void setSalario(float salario) {
        this.salario = salario;

    }
}
