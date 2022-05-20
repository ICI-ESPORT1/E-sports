package Modelo.BD;

import Modelo.UML.Entrenador;
import Modelo.UML.Jornada;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class JornadaDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla jornada*/

    private static Jornada jornada;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    private static ArrayList<Jornada>listaJornada = new ArrayList();

    public static void altaJornada(Jornada j)throws Exception{
        //Metodo para insertar una nueva jornada en la tabla jornada
     //   BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call gestionarJornada.nuevo_jornada(?,?,?)}");

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

        c=BaseDatos.getConexion().prepareCall("{call gestionarJornada.borrar_jornada(?)}");

        c.setInt(1,j.getNumJornada());

        c.execute();

        c.close();

    //    BaseDatos.cerrarConexion();
    }


    public static ArrayList<Jornada> selectTodos(){
        try{
            listaJornada = new ArrayList<>();
            //Metodo para consultar todas las jornadas
             BaseDatos.abrirConexion();

            plantilla="select * from jornada order by num_jornada";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            resultado = sentenciaPre.executeQuery();
            while(resultado.next()){
                crearObjeto();
                listaJornada.add(jornada);
            }


            //  BaseDatos.cerrarConexion();
        }catch (SQLException sqle){System.out.println(sqle.getMessage());}

        return listaJornada;

    }

    public static void crearObjeto(){
        try{


            jornada.setNumJornada(resultado.getInt("num_jornada"));
            jornada.setNumSemana(resultado.getString("num_semana"));
            Date dfecha;
            jornada.setFecha(LocalDate.parse((CharSequence) (dfecha = resultado.getDate("fecha"))));


        }catch (Exception e){System.out.println(e.getMessage());}


    }

}
