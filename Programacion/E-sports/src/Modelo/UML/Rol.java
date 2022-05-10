package Modelo.UML;

import Modelo.UML.Jugador;

import java.util.ArrayList;

public class Rol {
    /**
     @author Inigo Bruk
     */
    private Integer codRol;
    private String nombre;
    private String descripcion;

    ArrayList<Jugador> listaJugador;

    public Rol(Integer codRol, String nombre, String descripcion) {
        this.codRol = codRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Rol(Integer codRol, String nombre, String descripcion, ArrayList<Jugador> listaJugador) {
        this.codRol = codRol;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaJugador = listaJugador;
    }


    public Rol() {
    }

    public Integer getCodRol() {
        return codRol;
    }

    public void setCodRol(Integer codRol) {
        this.codRol = codRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Jugador> getListaJugador() {
        return listaJugador;
    }

    public void setListaJugador(ArrayList<Jugador> listaJugador) {
        this.listaJugador = listaJugador;
    }
}
