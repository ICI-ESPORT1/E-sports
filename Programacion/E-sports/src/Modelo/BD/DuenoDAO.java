package Modelo.BD;

import Modelo.UML.Dueno;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DuenoDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla dueño*/

    private static Dueno dueno;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static void altaDueno(Dueno d)throws Exception{
        //Metodo para insertar un nuevo dueno en la tabla dueno
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call nuevo_dueno(?,?,?,?,?)}");

        c.setString(1,d.getDni());
        c.setString(2,d.getNombre());
        c.setString(3,d.getTelefono());
        c.setString(4,d.getLocalidad());
        c.setInt(5, d.getEquipo().getId_equipo());

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();
    }


    public static void bajaDueno(Dueno d)throws Exception{
        //metodo para borrar un dueno de la tabla dueno por id_dueno
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call borrar_dueno(?)}");

        c.setInt(1,d.getCodPersona());

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();
    }

    public static void cambioEquipoDueno(Dueno d, int idEquipoNuevo)throws Exception{
        //metodo para cambiar a un dueño de equipo
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call cambio_equipo_dueno(?,?)}");

        c.setInt(1,d.getCodPersona());
        c.setInt(2,idEquipoNuevo);

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();

    }

    public static Dueno consultarDueno(String d)throws Exception{
        //Metodo para consultar un Dueno por dni a la base de datos
        BaseDatos.abrirConexion();

        plantilla="select * from dueno where dni = ?";

        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setString(1,d);

        resultado = sentenciaPre.executeQuery();

        crearObjeto();

        return dueno;

    }

    public static void crearObjeto()throws Exception{

        dueno.setCodPersona(resultado.getInt("id_dueno"));
        dueno.setDni(resultado.getString("dni"));
        dueno.setNombre(resultado.getString("nombre"));
        dueno.setTelefono(resultado.getString("telefono"));
        dueno.setMail(resultado.getString("mail"));
        dueno.setLocalidad(resultado.getString("localidad"));

    }
}