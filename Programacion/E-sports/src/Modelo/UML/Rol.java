package Modelo.UML;

import java.util.ArrayList;

public class Rol {
    /**

     */
    private Integer codRol;
    private String nombre;
    private String descripcion;

    ArrayList<Jugador> listaJugador;

    /**
     * Constructor sin listajugador
     * @param codRol
     * @param nombre
     * @param descripcion
     */

    public Rol(Integer codRol, String nombre, String descripcion) {
        this.codRol = codRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * Constructor con listajugador
     * @param codRol
     * @param nombre
     * @param descripcion
     * @param listaJugador
     */
    public Rol(Integer codRol, String nombre, String descripcion, ArrayList<Jugador> listaJugador) {
        this.codRol = codRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaJugador = listaJugador;
    }

    /**
     * constructor vacio de rol
     */
    public Rol() {
    }

    /**
     *
     * @param nombre
     */
    public Rol(String nombre) {

        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public Integer getCodRol() {
        return codRol;
    }

    /**
     *
     * @param codRol
     */
    public void setCodRol(Integer codRol) {
        this.codRol = codRol;
    }

    /**
     *
     * @return
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
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public ArrayList<Jugador> getListaJugador() {
        return listaJugador;
    }

    /**
     *
     * @param listaJugador
     */
    public void setListaJugador(ArrayList<Jugador> listaJugador) {
        this.listaJugador = listaJugador;
    }
}
