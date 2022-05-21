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

        System.out.println("bien");
        c=BaseDatos.getConexion().prepareCall("{call gestionResultados.obtenerClasificacion(?)}");

        c.registerOutParameter(1, (SQLType) res);


        c.execute();

        c.close();

        BaseDatos.cerrarConexion();

        return res;

    }

    public static Resultado obtenerPartidosJornadas()throws Exception{
        //Metodo para mostrar todos los partidos de las jornadas
      //  BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call gestionResultados.partidosJornada(?)}");

        c.registerOutParameter(1, (SQLType) res);

        c.execute();

        c.close();

      //  BaseDatos.cerrarConexion();

        return res;

    }

    public static Resultado obtenerPartidos()throws Exception{
        //Metodo para mostrar todos los partidos que se han jugado
      //  BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call gestionResultados.partidos(?)}");

        c.registerOutParameter(1,(SQLType) res);

        c.execute();

        c.close();

     //   BaseDatos.cerrarConexion();

        return res;
    }

    public static boolean insertResultado(int eq,int res,int part){
        BaseDatos.abrirConexion();
        boolean ok = false;
        try{
            plantilla="insert into resultado values ?,?,?";
            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setInt(1,part);
            sentenciaPre.setInt(2,eq);
            sentenciaPre.setInt(3,res);

            ok = sentenciaPre.execute();

            BaseDatos.cerrarConexion();
        }catch (Exception sqle){
            System.out.println(sqle.getMessage());
        }
        return ok;

    }

}
