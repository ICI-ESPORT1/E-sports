package Modelo.UML;

import java.util.ArrayList;

public class Dueno extends Persona {
    /**
     @author Inigo Bruk
     */
    private Equipo equipo;

    public Dueno(String dni, String nombre, String telefono, String direccion, Equipo equipo) {
        super(dni, nombre, telefono, direccion);
        this.equipo = equipo;
    }

    public Dueno(Equipo equipo) {
        this.equipo = equipo;
    }

    public Dueno(String dni, String nombre, String telefono, String direccion) {
        super(dni, nombre, telefono, direccion);
    }

    public Dueno() {
    }


    /**
     * @retun equipo
     */
    public Equipo getEquipo() {
        return equipo;
        
    }
    /**
     * @param equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ArrayList<Jugador> consultarJugador(){
    return null;
    }
    
    public void FicharJugador(Jugador jugador) {}
    
    public void GestionarSueldos(){}
    
    public void GestionarGastos(){}
}
