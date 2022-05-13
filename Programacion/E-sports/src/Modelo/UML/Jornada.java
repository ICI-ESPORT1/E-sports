package Modelo.UML;

import java.time.LocalDate;
import java.util.ArrayList;

/**@author Celia Garcia
 * version 1
 * */
public class Jornada {
    private int numJornada;
    private LocalDate fecha;
    private String numSemana;

    private Calendario calendario;
    private ArrayList<Partido> listaPartidos;

    /**
     * Constructor completo
     * @param numJornada
     * @param fecha
     * @param numSemana
     * @param listaPartidos
     * @param calendario
     */
    public Jornada(int numJornada, LocalDate fecha, String numSemana, ArrayList<Partido> listaPartidos,Calendario calendario) {
        this.numJornada = numJornada;
        this.fecha = fecha;
        this.numSemana = numSemana;
        this.listaPartidos = listaPartidos;
        this.calendario = calendario;
    }

    /**
     * Constructor vacio
     */
    public Jornada() {
    }

    /**
     * Constructor sin el arrayList de Partidos
     * @param numJornada
     * @param fecha
     * @param numSemana
     */
    public Jornada(int numJornada, LocalDate fecha, String numSemana) {
        this.numJornada = numJornada;
        this.fecha = fecha;
        this.numSemana = numSemana;
    }

    /**
     *
     * @return numJornada
     */
    public int getNumJornada() {
        return numJornada;
    }

    /**
     *
     * @param numJornada
     */
    public void setNumJornada(int numJornada) {
        this.numJornada = numJornada;
    }

    /**
     *
     * @return fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return numSemana
     */
    public String getNumSemana() {
        return numSemana;
    }

    /**
     *
     * @param numSemana
     */
    public void setNumSemana(String numSemana) {
        this.numSemana = numSemana;
    }

    /**
     *
     * @return listaPartidos
     */
    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    /**
     *
     * @param listaPartidos
     */
    public void setListaPartidos(ArrayList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    /**
     *
     * @return String de la clase
     */
    @Override
    public String toString() {
        return "Jornada{" +
                "numJornada=" + numJornada +
                ", fecha=" + fecha +
                ", numSemana='" + numSemana + '\'' +
                ", listaPartidos=" + listaPartidos +
                '}';
    }
}
