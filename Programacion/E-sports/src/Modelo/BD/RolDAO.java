package Modelo.BD;

import Modelo.UML.Dueno;
import Modelo.UML.Rol;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RolDAO {
    private static Rol rol= new Rol();

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;


    public static Rol obtenerRol(String r)throws Exception{
        BaseDatos.abrirConexion();
        String rM = r.toUpperCase();
        plantilla = "select * from rol where upper(Nombre)= ?";
        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setString(1,rM);

        resultado = sentenciaPre.executeQuery();

        while(resultado.next()){
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
