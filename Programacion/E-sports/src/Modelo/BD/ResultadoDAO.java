package Modelo.BD;

import Modelo.UML.Resultado;

import java.sql.*;

public class ResultadoDAO {
    /* Clase que contiene los metodos necesarios para trabajar con la tabla resultado*/

    private static Resultado res;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static Resultado obtenerClasificacion()throws Exception{
        //Metodo para mostrar la clasificacion actual
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call obtenerClasificacion(?)}");

        c.registerOutParameter(1, (SQLType) res);

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();

        return res;

    }

    public static Resultado obtenerPartidosJornadas()throws Exception{
        //Metodo para mostrar todos los partidos de las jornadas
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call partidosJornada(?)}");

        c.registerOutParameter(1, (SQLType) res);

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();

        return res;

    }



}
