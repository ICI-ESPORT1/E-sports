package Modelo.BD;

import Modelo.UML.Usuario;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * @Author Iñigo Bruk
 * @Version 1.0
 */
public class UsuarioDAO {

    private static Usuario usuario = new Usuario();
    private  static String plantilla;
    private static PreparedStatement sentenciaPre;
    private static ResultSet resultado;

    /**
     *
     * @param u
     * @return
     * @throws Exception
     */
    public static Usuario tomaDatosUsuario(Usuario u)throws Exception{
        try {
            usuario = new Usuario();
            String usuMay = u.getUsername().toUpperCase();
            plantilla= "select * from usuario where username = ?";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1,usuMay);

            resultado = sentenciaPre.executeQuery();
            usuario =new Usuario();
            if (resultado.next()){
                crearObjeto();
                System.out.println(resultado.getString(2));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        BaseDatos.cerrarConexion();
        return usuario;
    }

    /**
     *
     * @throws Exception
     */
    public static void crearObjeto()throws Exception{
        usuario.setId_rol(resultado.getInt("id_rol"));
        usuario.setUsername(resultado.getString("username"));
        usuario.setPassword(resultado.getString("password"));
        usuario.setCodusuario(resultado.getString("codusuario"));
    }

}

