package Modelo.BD;

import Modelo.UML.Rol;

import java.sql.*;
import java.util.ArrayList;

public class RolDAO {
    /*Clase que contiene los metodos necesarios para trabajar con la tabla rol*/

    private static Rol rol;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;


    public static Rol obtenerRol(String r)throws Exception{
        //Metodo para consultar un rol por nombre
        BaseDatos.abrirConexion();
        String rM=r.toUpperCase();
        plantilla="select * from rol where upper(nombre) = ?";

        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setString(1,r);

        resultado = sentenciaPre.executeQuery();

        while(resultado.next()) {
            crearObjeto();
        }

        BaseDatos.cerrarConexion();

        return rol;

    }

    public static void crearObjeto()throws Exception{
        rol.setCodRol(resultado.getInt("id_rol"));
        rol.setNombre(resultado.getString("nombre"));
        rol.setDescripcion(resultado.getString("descripcion"));

    }
}
