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
        c.setInt(5, j.getEquipo().getId_equipo());
        c.setString(6, j.getNickname());
        c.setFloat(7, j.getSalario());
        c.setFloat(8, j.getRol().getCodRol());

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

        return listaJugadores;

    }

    public static ArrayList<Jugador> consultarJugador()throws Exception{
        //Metodo para consultar todos los jugadores
        BaseDatos.abrirConexion();

        plantilla="select * from jugador where nombre = ";

        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setString(1,"Celia");

        resultado = sentenciaPre.executeQuery();

        listaJugadores= new ArrayList<>();
        while(resultado.next()) {
            crearObjeto();
            listaJugadores.add(jugador);
        }

        return listaJugadores;
    }

    public static void cambiarDatosJugador(Jugador jugador)throws Exception{
        //Metodo para modificar los datos de un jugador
        BaseDatos.abrirConexion();

        plantilla="update jugador nombre = ?, telefono = ?, direccion = ?, id_equipo = ?, nickname = ?, sueldo = ?, id_rol = ? where dni = ?";

        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setString(1,jugador.getNombre());
        sentenciaPre.setString(2,jugador.getTelefono());
        sentenciaPre.setString(3,jugador.getDireccion());
        sentenciaPre.setInt(4,jugador.getEquipo().getId_equipo());
        sentenciaPre.setString(5,jugador.getNickname());
        sentenciaPre.setFloat(6,jugador.getSalario());
        sentenciaPre.setInt(7,jugador.getRol().getCodRol());
        sentenciaPre.setString(8,jugador.getDni());

        resultado = sentenciaPre.executeQuery();

        BaseDatos.cerrarConexion();
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
