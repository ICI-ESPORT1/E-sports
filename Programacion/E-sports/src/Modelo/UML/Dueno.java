package Modelo.UML;

import java.util.ArrayList;

public class Dueno extends Persona {
    /**
     @author Inigo Bruk
     */
    private String nombreUsu;
    private String password;
    private Equipo equipo;

     /**
     *
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     * @param equipo
     * @param nombreUsu
     * @param password
     */
    public Dueno( String dni, String nombre, String telefono, String mail, String localidad, Equipo equipo, String nombreUsu, String password) {
        super( dni, nombre, telefono, mail, localidad);
        this.equipo = equipo;
        this.nombreUsu = nombreUsu;
        this.password = password;

    }
    
    /**
     *
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     * @param equipo
     */
    public Dueno( String dni, String nombre, String telefono, String mail, String localidad, Equipo equipo) {
        super( dni, nombre, telefono, mail, localidad);
        this.equipo = equipo;

    }

    public Dueno() {
    }
    /**
     *
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     * @param nombreUsu
     * @param password
     */
    public Dueno( String dni, String nombre, String telefono, String mail, String localidad, String nombreUsu, String password) {
        super( dni, nombre, telefono, mail, localidad);
        this.nombreUsu = nombreUsu;
        this.password = password;

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
    
     /**
     * @retun nombreUsu
     */
    public String getNombreUsu() {
        return nombreUsu;
        
    }
    /**
     * @param nombreUsu
     */
    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }
    
     /**
     * @retun password
     */
    public String getPassword() {
        return password;
        
    }
    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public ArrayList<Jugador> consultarJugador(){
    return null;
    }
    
    public void FicharJugador(Jugador jugador) {}
    
    public void GestionarSueldos(){}
    
    public void GestionarGastos(){}
}
