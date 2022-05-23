package Modelo.UML;

import java.time.LocalDate;

/**
 * @Author Iker Gomez
 * @Version 1.0
 */
public class Resultado {

    private Integer idPartido;
    private String resultado;
    private LocalDate fecha;
    private String jornada;
    private String numSemana;

    private Equipo equipo;

    /**
     *
     * @param idPartido
     * @param resultado
     * @param fecha
     * @param jornada
     * @param numSemana
     * @param equipo
     */
    public Resultado(Integer idPartido, String resultado, LocalDate fecha, String jornada, String numSemana, Equipo equipo) {
        this.idPartido = idPartido;
        this.resultado = resultado;
        this.fecha = fecha;
        this.jornada = jornada;
        this.numSemana = numSemana;
        this.equipo = equipo;
    }

    /**
     * CONSTRUCTOR VACIO
     */
    public Resultado() {
    }

    /**
     *
     * @param resultado
     * @param equipo
     */
    public Resultado(String resultado, Equipo equipo) {
        this.resultado = resultado;
        this.equipo = equipo;
    }

    /**
     *
     * @param resultado
     * @param fecha
     * @param equipo
     */
    public Resultado(String resultado, LocalDate fecha, Equipo equipo) {
        this.resultado = resultado;
        this.fecha = fecha;
        this.equipo = equipo;
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
     * @return resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     *
     * @param resultado
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
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
     * @return jornada
     */
    public String getJornada() {
        return jornada;
    }

    /**
     *
     * @param jornada
     */
    public void setJornada(String jornada) {
        this.jornada = jornada;
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
     * @return equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     *
     * @param equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /*METODOS DE LA CLASE RESULTADO*/

    /**
     * Metodo para obtener la clasificacion actual
     * @param equipo
     * @param resultado
     */
    public void obtenerClasificacion(Equipo equipo, String resultado){}

    /**
     * Metodo para ver el resultado del ultimo partido
     * @param equipo
     * @param idPartido
     * @param resultado
     */
    public void ultimoPartido(Equipo equipo, int idPartido, String resultado){}
}

