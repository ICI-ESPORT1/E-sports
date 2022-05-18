package Modelo.BD;

import Modelo.UML.Jornada;

import java.sql.*;

public class JornadaDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla jornada*/

    private static Jornada jornada;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static void altaJornada(Jornada j)throws Exception{
        //Metodo para insertar una nueva jornada en la tabla jornada
     //   BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call nuevo_jornada(?,?,?)}");

        c.setDate(1, Date.valueOf(j.getFecha()));
        c.setString(2,j.getNumSemana());
        c.setInt(3,j.getCalendario().getIdCalendario());

        c.execute();

        c.close();

      //  BaseDatos.cerrarConexion();
    }


    public static void bajaJornada(Jornada j)throws Exception{
        //metodo para borrar una jornada de la tabla jornada por num_jornada
      //  BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call borrar_jornada(?)}");

        c.setInt(1,j.getNumJornada());

        c.execute();

        c.close();

    //    BaseDatos.cerrarConexion();
    }

}
