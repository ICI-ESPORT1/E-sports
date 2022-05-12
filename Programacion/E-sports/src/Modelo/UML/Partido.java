package Modelo.UML;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Iker Gomez
 */
public class Partido {

    private Integer idPartido;
    private LocalDate fecha;

    //ATRIBUTO DE LA RELACION EQUIPO
    private ArrayList<Equipo> listaEquipos;

    /**
     *
     * @param idPartido
     * @param fecha
     * @param listaEquipos
     */
    public Partido(Integer idPartido, LocalDate fecha, ArrayList<Equipo> listaEquipos) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.listaEquipos = listaEquipos;
    }

    /**
     * CONSTRUCTOR VACIO
     */
    public Partido() {
    }

    /**
     *
     * @param idPartido
     * @param fecha
     */
    public Partido(Integer idPartido, LocalDate fecha) {
        this.idPartido = idPartido;
        this.fecha = fecha;
    }

    /**
     *
     * @return idPartido
     */
    public Integer getIdPartido() {
        return idPartido;
    }

    /**
     *
     * @param idPartido
     */
    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
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
     * @return listaEquipos
     */
    public ArrayList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    /**
     *
     * @param listaEquipos
     */
    public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }
}
