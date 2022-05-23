package Modelo.UML;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Iker Gomez
 * @version 1.0
 *
 */
public class Partido {

    private Integer idPartido;
    private String turno;
    private Jornada jornada;

    //ATRIBUTO DE LA RELACION EQUIPO
    private ArrayList<Equipo> listaEquipos;

    /**
     *
     * @param turno
     * @param listaEquipos
     */
    public Partido(String turno, ArrayList<Equipo> listaEquipos) {
        this.turno = turno;
        this.listaEquipos = listaEquipos;
    }

    public Partido(String turno, Jornada jornada) {
        this.turno = turno;
        this.jornada = jornada;
    }

    /**
     * CONSTRUCTOR VACIO
     */
    public Partido() {
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
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
     * @return turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     *
     * @param turno
     */
    public void setTurno(String turno) {
        this.turno = turno;
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
