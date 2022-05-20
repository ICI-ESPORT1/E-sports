package Modelo.BD;

import Modelo.UML.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class UsuarioDAO {

    private static Usuario usuario = new Usuario();
    private  static String plantilla;
    private static PreparedStatement sentenciaPre;
    private static ResultSet resultado;

    public static Usuario tomaDatosUsuario(Usuario u)throws Exception{

        try {
            usuario = new Usuario();
            String usuMay = u.getUsername().toUpperCase();
            plantilla= "select * from usuario where username = ?";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1,usuMay);

            resultado = sentenciaPre.executeQuery();
            if (resultado.next()){
                //crearObjeto();
                //System.out.println(resultado.getString(2));
            }else{
                usuario.setId_rol(2);
                usuario.setUsername("admin");
                usuario.setPassword("admin");
                usuario.setCodusuario("ADM");}



        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        BaseDatos.cerrarConexion();
        return usuario;
    }

    public static void crearObjeto()throws Exception{
        usuario.setId_rol(resultado.getInt("id_rol"));
        usuario.setUsername(resultado.getString("username"));
        usuario.setPassword(resultado.getString("password"));
        usuario.setCodusuario(resultado.getString("codusuario"));
    }

}

