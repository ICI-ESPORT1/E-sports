package Modelo.UML;

public class Jugador extends Persona {
    /**
     * @author Inigo Bruk
     * @Version 1.0
     */
    private String nickname;
    private Rol rol;
    private float salario;

    private Equipo equipo;

    /**
     *
     * @param dni
     * @param nombre
     * @param telefono
     * @param direccion
     * @param nickname
     * @param rol
     * @param salario
     * @param equipo
     */
    public Jugador(String dni, String nombre, String telefono, String direccion, String nickname, Rol rol, float salario, Equipo equipo) {
        super(dni, nombre, telefono, direccion);
        this.nickname = nickname;
        this.rol = rol;
        this.salario = salario;
        this.equipo = equipo;
    }

    public Jugador(String nickname, Rol rol, float salario, Equipo equipo) {
        this.nickname = nickname;
        this.rol = rol;
        this.salario = salario;
        this.equipo = equipo;
    }

    /**
     *
     * @param dni
     * @param nombre
     * @param telefono
     * @param direccion
     * @param nickname
     */
    public Jugador(String dni, String nombre, String telefono, String direccion, String nickname) {
        super(dni, nombre, telefono, direccion);
        this.nickname = nickname;
    }

    /**
     *
     * @param dni
     * @param nombre
     * @param telefono
     * @param direccion
     * @param nickname
     * @param salario
     */
    public Jugador(String dni, String nombre, String telefono, String direccion, String nickname, float salario) {
        super(dni, nombre, telefono, direccion);
        this.nickname = nickname;
        this.salario = salario;
    }

    /**
     *
     * @param nickname
     * @param salario
     */
    public Jugador(String nickname, float salario) {
        this.nickname = nickname;
        this.salario = salario;
    }

    public Jugador() {
    }

    public Jugador(String dni, String nombre, String telefono, String mail, String localidad, String nick, float sueldo, Rol rol,Equipo equipo) {

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

    @Override
    public String toString() {
        return "Jugador{" +
                "nickname='" + nickname + '\'' +
                '}';
    }

}
