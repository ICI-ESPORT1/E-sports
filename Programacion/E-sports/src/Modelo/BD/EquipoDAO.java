package Modelo.BD;

import Modelo.UML.Equipo;

import java.sql.*;

public class EquipoDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla equipo*/

    private static Equipo equipo;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static void altaEquipo(Equipo e)throws Exception{
        //Metodo para insertar un nuevo equipo en la tabla equipo
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call nuevo_equipo(?,?,?,?,?,?,?)}");

        c.setString(1,e.getNombre());
        c.setString(2,e.getNacionalidad());
        c.setDate(3, Date.valueOf(e.getFechaCreacion()));
        c.setString(4,e.getTelefono());
        c.setString(5, e.getMail());
        c.setString(6, e.getEscudo());
        c.setInt(7, e.getAsistente().getCodPersona());

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();
    }


    public static void bajaEquipo(Equipo e)throws Exception{
        //metodo para borrar un equipo de la tabla equipo por nombre
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call borrar_equipo(?)}");

        c.setString(1,e.getNombre());

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();
    }

    public static void cambiarNombreEquipo(String nombre, String nombreNuevo)throws Exception{
        //metodo para cambiar el nombre de un equipo
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call cambiar_nombre_equipo(?,?)}");

        c.setString(1,nombre);
        c.setString(2,nombreNuevo);

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();

    }

    public static Equipo consultarEquipo(String nombre)throws Exception{
        //Metodo para consultar un Equipo por nombre a la base de datos
        BaseDatos.abrirConexion();

        plantilla="select * from equipo where nombre = ?";


        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);

        resultado = sentenciaPre.executeQuery();

        crearObjeto();

        return equipo;

    }

    public static void crearObjeto()throws Exception{

        equipo.setId_equipo(resultado.getInt("cod_equipo"));
        equipo.setNombre(resultado.getString("nombre"));
        equipo.setNacionalidad(resultado.getString("nacionalidad"));
        equipo.setTelefono(resultado.getString("telefono"));
        equipo.setMail(resultado.getString("mail"));
        equipo.setFechaCreacion(resultado.getDate("fecha_creacion"));
        equipo.setEscudo(resultado.getString("escudo"));

    }
}
