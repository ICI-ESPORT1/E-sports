package Modelo.BD;

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
        int n = 0;
        plantilla = "INSERT INTO entrenador (dni,nombre,telefono,direccion,id_equipo,sueldo) VALUES (?,?,?,?,?,?)";
        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setString(1, e.getDni());
        sentenciaPre.setString(2, e.getNombre());
        sentenciaPre.setString(3, e.getTelefono());
        sentenciaPre.setString(4,e.getDireccion());
        int idEquipo =e.getEquipo().getId_equipo();
        sentenciaPre.setInt(5,idEquipo );
        sentenciaPre.setFloat(6, e.getSueldo());
        n = sentenciaPre.executeUpdate();

        System.out.println("filas "+ n);
      //  BaseDatos.cerrarConexion();
    }


    public static void bajaEntrenador(Entrenador e)throws Exception{
        //metodo para borrar un entrenador de la tabla entrenador por id_entrenador
      //  BaseDatos.abrirConexion();

        c =BaseDatos.getConexion().prepareCall("{call borrar_entrenador(?)}");

        c.setInt(1,e.getCodPersona());

        c.execute();

        c.close();

      //  BaseDatos.cerrarConexion();
    }

    public static void cambioEquipoEntrenador(Entrenador e, int idEquipoNuevo)throws Exception{
        //metodo para cambiar a un entrenador de equipo
       // BaseDatos.abrirConexion();

        c =BaseDatos.getConexion().prepareCall("{call cambio_equipo_entrenador(?,?)}");

        c.setInt(1,e.getCodPersona());
        c.setInt(2,idEquipoNuevo);

        c.execute();

        c.close();

      //  BaseDatos.cerrarConexion();

    }

    public static Entrenador consultarEntrenador(String dni)throws Exception{
        //Metodo para consultar un entrenador por dni a la base de datos
      //  BaseDatos.abrirConexion();

        plantilla="select * from entrenador where dni = ?";

        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setString(1,dni);

        resultado = sentenciaPre.executeQuery();

        crearObjeto();
      //  BaseDatos.cerrarConexion();
        return entrenador;

    }

    public static void crearObjeto()throws Exception{

        entrenador.setCodPersona(resultado.getInt("id_entrenador"));
        entrenador.setDni(resultado.getString("dni"));
        entrenador.setNombre(resultado.getString("nombre"));
        entrenador.setTelefono(resultado.getString("telefono"));
        entrenador.setLocalidad(resultado.getString("direccion"));
        entrenador.setSueldo(resultado.getFloat("sueldo"));

    }
}
