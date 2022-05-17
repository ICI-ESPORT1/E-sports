package Modelo.BD;

import Modelo.UML.Jugador;

import java.sql.*;
import java.util.ArrayList;

public class JugadorDAO {
    /* Clase que contiene los metodos necesarios para trabajar con la tabla jugador*/

    private static Jugador jugador;
    private static ArrayList<Jugador> listaJugadores;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static void altaJugador(Jugador j)throws Exception{
        //Metodo para insertar un nuevo jugador en la tabla jugador
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call nuevo_jugador(?,?,?,?,?,?,?,?)}");

        c.setString(1,j.getDni());
        c.setString(2,j.getNombre());
        c.setString(3, j.getTelefono());
        c.setString(4,j.getDireccion());
        int idE = j.getEquipo().getId_equipo();
        c.setInt(5,idE);
        c.setString(6, j.getNickname());
        c.setFloat(7, j.getSalario());
        int idR =j.getRol().getCodRol();
        c.setInt(8, idR);

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();
    }


    public static void bajaJugador(Jugador j)throws Exception{
        //metodo para borrar un jugador de la tabla jugador por id_jugador
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call borrar_jugador(?)}");

        c.setInt(1,j.getCodPersona());

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();
    }

    public static void cambiarEquipoJugador(Jugador j, int idEquipoNuevo)throws Exception{
        //metodo para cambiar un jugador de equipo
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call cambio_equipo_jugador(?,?)}");

        c.setInt(1,j.getCodPersona());
        c.setInt(2,idEquipoNuevo);

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();

    }

    public static ArrayList<Jugador> consultarJugadoresEquipo(int idEquipo)throws Exception{
        //Metodo para consultar todos los jugadores de un equipo
        BaseDatos.abrirConexion();

        plantilla="select * from jugador where id_equipo = ?";

        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setInt(1,idEquipo);

        resultado = sentenciaPre.executeQuery();

        listaJugadores= new ArrayList<>();
        while(resultado.next()) {
            crearObjeto();
            listaJugadores.add(jugador);
        }
        BaseDatos.cerrarConexion();
        return listaJugadores;

    }

    public static Jugador consultarJugador(int idJugador)throws Exception{
        //Metodo para consultar un jugador por dni
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call cambio_equipo_jugador(?,?)}");

        c.setInt(1,idJugador);
        c.registerOutParameter(2, (SQLType) jugador);

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();

        return jugador;
    }

    public static void crearObjeto()throws Exception{

        jugador.setCodPersona(resultado.getInt("id_jugador"));
        jugador.setNombre(resultado.getString("nombre"));
        jugador.setTelefono(resultado.getString("telefono"));
        jugador.setLocalidad(resultado.getString("direccion"));
        jugador.setNickname(resultado.getString("nickname"));
        jugador.setDni(resultado.getString("dni"));
        jugador.setSalario(resultado.getFloat("sueldo"));

    }
}
