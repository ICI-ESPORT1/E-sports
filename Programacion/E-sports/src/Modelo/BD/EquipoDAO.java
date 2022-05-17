package Modelo.BD;

import Modelo.UML.Asistente;
import Modelo.UML.Equipo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class EquipoDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla equipo*/

    private static Equipo equipo = new Equipo();
    private static ArrayList<Equipo> listaEquipos = new ArrayList<>();

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static void altaEquipo(Equipo e, Asistente a)throws Exception{
        //Metodo para insertar un nuevo equipo en la tabla equipo
       // BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call gestionarEquipos.nuevo_equipo(?,?,?,?,?,?,?)}");

        c.setString(1,e.getNombre());
        c.setString(2,e.getNacionalidad());
        c.setDate(3, Date.valueOf(e.getFechaCreacion()));
        c.setString(4,e.getTelefono());
        c.setString(5, e.getMail());
        c.setString(6, e.getEscudo());
        c.setInt(7,a.getCodPersona());
        /*Antes de añadir el asistente necesitamos el id del asistente que acabamos de insertar*/

        c.setInt(7, e.getAsistente().getCodPersona());

        c.execute();

        c.close();

      //  BaseDatos.cerrarConexion();
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

    public static void cambiarNombreEquipo(Equipo e, String nombreNuevo)throws Exception{
        //metodo para cambiar el nombre de un equipo
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call cambiar_nombre_equipo(?,?)}");

        c.setString(1,e.getNombre());
        c.setString(2,nombreNuevo);

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();

    }

    public static Equipo consultarEquipo(String n)throws Exception{
        //Metodo para consultar un Equipo por nombre a la base de datos
      //  BaseDatos.abrirConexion();
        String nombreMayus = n.toUpperCase();
        plantilla="select * from equipo where upper(nombre) = ?";

        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setString(1,nombreMayus);

        resultado = sentenciaPre.executeQuery();
    while(resultado.next()){
        crearObjeto();
    }


        return equipo;

    }

    public static Equipo consultarEquipoID(String n)throws Exception{
        //Metodo para consultar un Equipo por nombre a la base de datos
        BaseDatos.abrirConexion();

        plantilla="select * from equipo where cod_equipo = ?";

        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setInt(1,Integer.parseInt(n));

        resultado = sentenciaPre.executeQuery();
        while (resultado.next()){
            crearObjeto();
        }

        BaseDatos.cerrarConexion();
        return equipo;

    }

    public static ArrayList<Equipo> selectTodosLosEquipos()throws Exception{
     //   BaseDatos.abrirConexion();

        plantilla= "select * from equipo";
        sentenciaPre= BaseDatos.getConexion().prepareStatement(plantilla);

        resultado = sentenciaPre.executeQuery();
        while(resultado.next()){
            System.out.println("CREANDO OBJETO*******");
            System.out.println(resultado.getInt("cod_equipo"));
             crearObjeto();

        }

        return listaEquipos;
    }

    public static void crearObjeto()throws Exception{

        equipo.setId_equipo(resultado.getInt("cod_equipo"));
        equipo.setNombre(resultado.getString("nombre"));
        equipo.setNacionalidad(resultado.getString("nacionalidad"));
        String sFecha = String.valueOf(resultado.getDate("fecha_creacion"));
        LocalDate ldFecha= LocalDate.parse(sFecha);
        equipo.setFechaCreacion(ldFecha);
        equipo.setTelefono(resultado.getString("telefono"));
        equipo.setMail(resultado.getString("mail"));

       // equipo.setFechaCreacion(resultado.getDate("fecha_creacion"));
        equipo.setEscudo(resultado.getString("escudo"));

        listaEquipos.add(equipo);

    }
}
