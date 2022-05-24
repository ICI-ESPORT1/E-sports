package Modelo.UML;

import java.util.ArrayList;

public class Dueno extends Persona {
    /**
     * @Author Inigo Bruk
     * @Version 1.0
     */
    private Equipo equipo;

    /**
     *
     * @param dni dni
     * @param nombre nombre
     * @param telefono telefono
     * @param direccion direccion
     * @param equipo equipo
     */
    public Dueno(String dni, String nombre, String telefono, String direccion, Equipo equipo) {
        super(dni, nombre, telefono, direccion);
        this.equipo = equipo;
    }

    /**
     *
     * @param equipo equipo
     */
    public Dueno(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     *
     * @param dni dni
     * @param nombre nombre
     * @param telefono telefono
     * @param direccion direccion
     */
    public Dueno(String dni, String nombre, String telefono, String direccion) {
        super(dni, nombre, telefono, direccion);
    }

    /**
     * Constructor vacio de dueno
     */
    public Dueno() {
    }


    /**
     * @retun equipo
     */
    public Equipo getEquipo() {
        return equipo;
        
    }
    /**
     * @param equipo equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     *
     * @return
     */
    public ArrayList<Jugador> consultarJugador(){
    return null;
    }
    
    public void FicharJugador(Jugador jugador) {}
    
    public void GestionarSueldos(){}
    
    public void GestionarGastos(){}
}
