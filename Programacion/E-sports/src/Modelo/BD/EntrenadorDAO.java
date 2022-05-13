package Modelo.BD;

import Modelo.UML.Asistente;
import Modelo.UML.Entrenador;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EntrenadorDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla entrenador*/

    private static Entrenador entrenador;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static void altaEntrenador(Entrenador e)throws Exception{
        //Metodo para insertar un nuevo entrenador en la tabla entrenador
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call nuevo_entrenador(?,?,?,?,?,?)}");

        c.setString(1,e.getDni());
        c.setString(2,e.getNombre());
        c.setString(3,e.getTelefono());
        c.setString(4,e.getLocalidad());
        c.setInt(5, e.getEquipo().getId_equipo());
        c.setFloat(6, e.getSueldo());

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();
    }


    public static void bajaEntrenador(Entrenador e)throws Exception{
        //metodo para borrar un entrenador de la tabla entrenador por id_entrenador
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call borrar_entrenador(?)}");

        c.setInt(1,e.getCodPersona());

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();
    }

    public static void cambioEquipoEntrenador(int idEntrenadorNUevo, int idEquipoNuevo)throws Exception{
        //metodo para cambiar a un entrenador de equipo
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call cambio_equipo_entrenador(?,?)}");

        c.setInt(1,idEntrenadorNUevo);
        c.setInt(2,idEquipoNuevo);

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();

    }

    public static Entrenador consultarEntrenador(String dni)throws Exception{
        //Metodo para consultar un entrenador por id_entrenador a la base de datos
        BaseDatos.abrirConexion();

        plantilla="select * from entrenador where dni = ?";


        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);

        resultado = sentenciaPre.executeQuery();

        crearObjeto();

        return entrenador;

    }

    public static void crearObjeto()throws Exception{

        entrenador.setCodPersona(resultado.getInt("id_asistente"));
        entrenador.setDni(resultado.getString("dni"));
        entrenador.setNombre(resultado.getString("nombre"));
        entrenador.setTelefono(resultado.getString("telefono"));
        entrenador.setMail(resultado.getString("mail"));
        entrenador.setLocalidad(resultado.getString("localidad"));
        entrenador.setSueldo(resultado.getFloat("suledo"));

    }
}
