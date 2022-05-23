package Modelo.UML;

import java.util.ArrayList;

/**
 * @Author Celia Garcia
 * @Version 1.0
 */
public class Calendario {
    private int idCalendario;
    private char cerrado;
    private String temporada;
    private ArrayList<Jornada> listaJornada;

    /**
     * Constructor completo de Calendario
     * @param idCalendario
     * @param cerrado
     * @param temporada
     * @param listaJornada
     */
    public Calendario(int idCalendario, char cerrado, String temporada, ArrayList<Jornada> listaJornada) {
        this.idCalendario = idCalendario;
        this.cerrado = cerrado;
        this.temporada = temporada;
        this.listaJornada = listaJornada;
    }

    /**
     * Constructor vacio de Calendario
     */
    public Calendario() {
    }

    /**
     * Constructor sin el arraylist de Jornada
     * @param idCalendario
     * @param cerrado
     * @param temporada
     */
    public Calendario(int idCalendario, char cerrado, String temporada) {
        this.idCalendario = idCalendario;
        this.cerrado = cerrado;
        this.temporada = temporada;
    }

    /**
     *
     * @return idCalendario
     */
    public int getIdCalendario() {
        return idCalendario;
    }

    /**
     *
     * @param idCalendario
     */
    public void setIdCalendario(int idCalendario) {
        this.idCalendario = idCalendario;
    }

    /**
     *
     * @return cerrado
     */
    public char getCerrado() {
        return cerrado;
    }

    /**
     *
     * @param cerrado
     */
    public void setCerrado(char cerrado) {
        this.cerrado = cerrado;
    }

    /**
     *
     * @return temporada
     */
    public String getTemporada() {
        return temporada;
    }

    /**
     *
     * @param temporada
     */
    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    /**
     *
     * @return listaJornada
     */
    public ArrayList<Jornada> getListaJornada() {
        return listaJornada;
    }

    /**
     *
     * @param listaJornada
     */
    public void setListaJornada(ArrayList<Jornada> listaJornada) {
        this.listaJornada = listaJornada;
    }

    /**
     *
     * @return string de Calendario
     */
    @Override
    public String toString() {
        return "Calendario{" +
                "idCalendario=" + idCalendario +
                ", cerrado=" + cerrado +
                ", temporada='" + temporada + '\'' +
                ", listaJornada=" + listaJornada +
                '}';
    }
}
