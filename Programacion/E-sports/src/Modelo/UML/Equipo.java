package Modelo.UML;

import java.time.LocalDate;
import java.util.ArrayList;


/**
* @author Iker Gomez
 */
public class Equipo {

    private Integer idEquipo;
    private String nombre;
    private String nacionalidad;
    private LocalDate fechaCreacion;
    private String telefono;
    private String mail;
    private String escudo;

    //ATRIBUTO DE LA RELACION CON ENTRENADOR, ASISTENTE Y DUENO
    /*private Entrenador entrenador;*/
    private Asistente asistente;
  /*  private Dueno dueno;*/

    //ATRIBUTO DE LA RELACION CON JUGADOR Y PARTIDO
    private ArrayList<Jugador> listaJugadores;
    private ArrayList<Partido> listaPartidos;

    /**
     *
     * @param idEquipo
     * @param nombre
     * @param nacionalidad
     * @param fechaCreacion
     * @param telefono
     * @param mail
     * @param escudo
     * @param entrenador
     * @param asistente
     * @param dueno
     * @param listaJugadores
     * @param listaPartidos
     */
    public Equipo(Integer idEquipo, String nombre, String nacionalidad, LocalDate fechaCreacion, String telefono,
                  String mail, String escudo, Entrenador entrenador, Asistente asistente, Dueno dueno,
                  ArrayList<Jugador> listaJugadores, ArrayList<Partido> listaPartidos) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaCreacion = fechaCreacion;
        this.telefono = telefono;
        this.mail = mail;
        this.escudo = escudo;
        this.asistente = asistente;
        this.listaJugadores = listaJugadores;
        this.listaPartidos = listaPartidos;
    }

    /**
     *
     * @param nombre
     * @param nacionalidad
     * @param fechaCreacion
     * @param telefono
     * @param mail
     * @param escudo
     */
    public Equipo(String nombre, String nacionalidad, LocalDate fechaCreacion, String telefono, String mail, String escudo) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaCreacion = fechaCreacion;
        this.telefono = telefono;
        this.mail = mail;
        this.escudo = escudo;
    }

    /**
     * CONSTRUCTOR VACIO
     * @param n
     * @param na
     * @param f
     * @param t
     * @param m

     */



    public Equipo(String n, String na, LocalDate f, String t, String m, String escudoEquipo, Asistente asistente) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaCreacion = fechaCreacion;
        this.telefono = telefono;
        this.mail = mail;
        this.escudo = escudo;

        this.asistente=asistente;
    }

    /**
     *
     * @return idEquipo
     */
    public int getId_equipo() {
        return idEquipo;
    }

    /**
     *
     * @param idEquipo
     */
    public void setId_equipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     *
     * @param nacionalidad
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     *
     * @return fechaCeracion
     */
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     *
     * @param fechaCreacion
     */
    public void setFechaCreacion(LocalDate fechaCreacion) {
        //this.fechaCreacion = fechaCreacion;
    }

    /**
     *
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     *
     * @return escudo
     */
    public String getEscudo() {
        return escudo;
    }

    /**
     *
     * @param escudo
     */
    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }


    /**
     *
     * @return asistente
     */
    public Asistente getAsistente() {
        return asistente;
    }

    /**
     *
     * @param asistente
     */
    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }

    public Equipo() {
    }


    /**
     *
     * @return listaJugadores
     */
    public ArrayList<Jugador> getlistaJugadores() {
        return listaJugadores;
    }

    /**
     *
     * @param listaJugadores
     */
    public void setlistaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    /**
     *
     * @return listaPartidos
     */
    public ArrayList<Partido> getlistaPartidos() {
        return listaPartidos;
    }

    /**
     *
     * @param listaPartidos
     */
    public void setlistaPartidos(ArrayList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }
}