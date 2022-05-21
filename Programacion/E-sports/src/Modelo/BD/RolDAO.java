package Modelo.BD;

import Modelo.UML.Dueno;
import Modelo.UML.Rol;

import java.sql.*;

public class RolDAO {
    private static Rol rol= new Rol();

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;


    public static Rol obtenerRol(String r){
        try{
            String rM = r.toUpperCase();
            plantilla = "select * from rol where upper(Nombre)= ?";
            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1,rM);

            resultado = sentenciaPre.executeQuery();

            while(resultado.next()){
                crearObjeto();
            }
        }
        catch (SQLException x){System.out.println(x.getMessage());}
      //  BaseDatos.abrirConexion();


      //  BaseDatos.cerrarConexion();

        return rol;

    }
    public static void crearObjeto(){
        try{
            rol.setCodRol(resultado.getInt("id_rol"));
            rol.setNombre(resultado.getString("nombre"));
            rol.setDescripcion(resultado.getString("descripcion"));
        }catch (Exception e){System.out.println(e.getMessage());}

    }
}
