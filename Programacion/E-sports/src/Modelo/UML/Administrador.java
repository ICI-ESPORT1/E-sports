package MODELO.UML;

import java.time.LocalDate;
import java.util.ArrayList;

public class Administrador {
    private int idAdministrador;
    private String nombre;
    private String apellido;
    private String password;
    private GrupoUsuario tipoUsuario;

    public Administrador(int idAdministrador, String nombre, String apellido, String password, GrupoUsuario tipoUsuario) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public Administrador() {
    }

    public Administrador(int idAdministrador, String nombre, String apellido, String password) {
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GrupoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(GrupoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdministrador=" + idAdministrador +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", password='" + password + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }

    /*METODOS DE LA CLASE ADMINISTRADOR*/
/* *****************************METODOS QUE AFECTAN A LA CLASE EQUIPO**********************************/
    /**
     * Metodo para añadir nuevos equipos
     * @param idEquipo
     * @param nombre
     * @param telefono
     * @param mail
     */
    public void altaEquipo(int idEquipo, String nombre, String nacionalidad,LocalDate fechaCreacion,
                           String telefono, String mail,String escudo){}

    /**
     * Metodo para borrar equipos pasandole la clave primaria
     * @param id
     */
    public void bajaEquipo(int id){}

    /**
     * Metodo sobreEscrito para borrar equipos pasandole como parametro el nombre del equipo
     * @param nombre
     */
    public void bajaEquipo(String nombre){}

    /**
     * Metodo para cambiar solo el nombre al equipo
     */
    public void modificarEquipo(String nombre){}

    /**
     * Metodo para cambiar datos del equipo
     * @param idEquipo
     * @param nombre
     * @param nacionalidad
     * @param FechaCreacion
     * @param telefono
     * @param mail
     * @param escudo
     */
    public void modificarEquipo(int idEquipo, String nombre, String nacionalidad, LocalDate FechaCreacion, String telefono, String mail, String escudo){}

    /**
     * Metodo que devuelve los datos del equipo
     * @param idEquipo PrimaryKey de persona
     * @return Equipo
     */
    public Equipo visualizarDatosEquipo(int idEquipo){
        Equipo equipo = null;
        return equipo;
    }

    /* *****************METODOS QUE AFECTAN A LA CLASE JUGADOR ********************************************/

    /**
     * Metodo para anadir nuevos jugadores
      * @param nickname mote del jugador
     * @param sueldo salario del jugador
     * @param rol Objeto tipo ROL
     */
    public void altaJugador(int idPersona,String dni, String nombre, String telefono, String mail,
                            String localidad, String nickname, float sueldo, Rol rol, int idEquipo ){}

    /**
     * Metodo para borrar jugador por su idPersona
     * @param idPersona primaryKey de persona
     */
    public void bajaJugador(int idPersona){}

    /**
     * Metodo para borrar jugador por su dni
     * @param dni dni (unique) del jugador
     */
    public void bajaJugador(String dni){}

    /**
     * Metodo para modificar datos un jugador
     * @param idPersona
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     * @param nickname
     * @param sueldo
     * @param rol
     * @param idEquipo
     */
    public void modificarJugador(int idPersona,String dni, String nombre, String telefono, String mail,
                                 String localidad, String nickname, float sueldo, Rol rol, int idEquipo){}

    /**
     * Metodo que devuelve los datos de un jugador
     * @param idPersona primaryKey de persona
     * @return objeto Jugador
     */
    public Jugador visualizarDatosJugador(int idPersona){
        Jugador jugador = null;
        return jugador;
    }

    /**
     * Metodo sobreescrito que devuelve los datos del jugador
     * @param dni (unique)
     * @return
     */
     public Jugador visualizarDatosJugador(String dni){
         Jugador jugador = null;
         return jugador;
     }

    /* ***************************METODOS QUE AFECTAN A LA CLASE JORNADA **********************************/

    /**
     * Metodo para generar jornadas sin partidos
     * @param numJornada primaryKey de jornada
     * @param fecha de tipo LocalDate
     * @param numSemana numero de la semana de anyo
     */
    public void generarJornadas(int numJornada, LocalDate fecha, String numSemana,ArrayList<Partido>listaPartidos){}

    /**
     * Metodo para generar los partidos
     * @param idPartido primaryKey
     * @param fecha Localdate
     * @param listaEquipos arrayList
     * @return listaPartidos arrayList
     */

    public ArrayList<Partido> generarPartidos(int idPartido,LocalDate fecha, ArrayList<Equipo>listaEquipos){
        return null;
    }

    /**
     * Metodo para borrar jornada
     * @param numJornada primaryKey de jornada
     */
    public void borrarJornada(int numJornada){}

    /**
     * Metodo para modificar datos de la jornada
     * @param numJornada primaryKey de jornada
     * @param fecha Cuando se celebra la jornada
     * @param numSemana numero de la semana de anyo
     */
    public void modificarJornada(int numJornada, LocalDate fecha, String numSemana){}

    /**
     * Metodo para visualizar los datos de la jornada
     * @param numJornada primaryKey de jornada
     * @return jornada
     */
    public Jornada visualizarJornada(int numJornada){
        Jornada jornada = null;
        return jornada;
    }
/* ********************************METODOS QUE AFECTAN A LA CLASE RESULTADO ***********************************/
    public void introducirResultado(int idPartido, String resultado, int idEquipo){}

    public Resultado visualizarClasificacion(){
        return null;
    }
    public Resultado visualizarResultados(){
        return null;
    }
    public Resultado visualizarResultados(int idEquipo){
        return null;
    }
    public Resultado visualizarResultados(String nombre){
        return null;
    }
    /* ****************************METODOS QUE AFECTAN A LA CLASE DUENO**********************************/

    /**
     * Metodo para añadir dueño
     * @param idPersona primaryKey de persona
     * @param dni unique
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     */
    public void altaDueno(int idPersona, String dni, String nombre, String telefono, String mail, String localidad,
                            Equipo equipo){}

    /**
     * Metodo para modificar datos del dueno
     * @param idPersona primaryKey de persona
     * @param dni unique
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     * @param equipo
     */
    public void modificarDueno(int idPersona, String dni, String nombre, String telefono, String mail, String localidad,
                               Equipo equipo){}

    /**
     * Metodo para borrar dueño con su idPersona
     * @param idPersona primaryKey de persona
     */
    public void borrarDueno(int idPersona){}

    /**
     * Método sobreescrito para borrar dueno con su dni
     * @param dni unique
     */
    public void borrarDueno(String dni){}

    /**
     * Metodo para obtener los datos del dueno pasandole el idPersona
     * @param idPersona primaryKey de persona
     */
    public void obtenerDatosDueno(int idPersona){}

    /**
     * Método sobreescrito para obtener los datos del dueno pasandole el dni
     * @param dni unique
     */
    public void obtenerDatosDueno(String dni){}

    /* ******************************METODOS PARA GESTIONAR USUARIOS****************************************/

    /**
     * Metodo para cambiar el pass del administrador
     * @param password Hay que codificarla antes de guardarla
     */
    public void cambiarPassword(String password){}

    /**
     * Metodo para cambiar el nombre de usuario del administrador
     * @param nombreUsu
     */
    public void cambiarNombreUsuario(String nombreUsu){}

    /**
     * Metodo para anadir otro administrador
     * @param idAdministrador primaryKey
     * @param nombre
     * @param apellido
     * @param NombreUsu
     * @param passw Hace falta codificarlo
     */
    public void anadirAdministrador(int idAdministrador, String nombre,String apellido,
                                    String NombreUsu,String passw){}

    /**
     * Metodo para codificar el password
     * @param password
     */
    public void codificarPass(String password){}

}
