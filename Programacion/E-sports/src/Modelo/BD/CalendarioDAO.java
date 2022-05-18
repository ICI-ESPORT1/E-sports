package Modelo.BD;

import Modelo.UML.Calendario;
import Modelo.UML.Jornada;

import java.sql.*;

public class CalendarioDAO {
    /* Clase que contiene los metodos necesarios para trabajar con la tabla calendario*/

    private static Calendario calendario;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static void altaCalendario(Calendario c)throws Exception{
        //Metodo para insertar un nuevo calendario en la tabla calendario
        BaseDatos.abrirConexion();

        plantilla="insert into calendario values (?,?)";

        sentenciaPre=BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setString(1, String.valueOf(c.getCerrado()));
        sentenciaPre.setString(2,c.getTemporada());

        sentenciaPre.execute();

        sentenciaPre.close();

        BaseDatos.cerrarConexion();
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
