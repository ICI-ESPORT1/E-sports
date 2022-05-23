package Modelo.BD;

import Modelo.UML.Calendario;

import javax.swing.*;
import java.sql.*;
/**
 * @Author celia Garcia
 * @Version 1.0
 */
public class CalendarioDAO {
    /* Clase que contiene los metodos necesarios para trabajar con la tabla calendario*/

    private static Calendario calendario = new Calendario();

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static void altaCalendario(Calendario c){
        //Metodo para insertar un nuevo calendario en la tabla calendario
        try {

            plantilla = "insert into calendario (cerrado,temporada) values (?,?)";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1, String.valueOf(calendario.getCerrado()));
            sentenciaPre.setString(2, c.getTemporada());

            sentenciaPre.executeUpdate();

            sentenciaPre.close();


        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public static Calendario buscarCalendario(){
        //metodo para consultar si ya existe un calendario
        try {


            plantilla = "select * from calendario";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);

            resultado = sentenciaPre.executeQuery();

            if (resultado.next()) {

                crearObjeto();

            }
            else {
                sentenciaPre.close();


                return null;
            }


            sentenciaPre.close();


            return calendario;
        }
        catch (SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static void crearObjeto() throws Exception{
        calendario.setIdCalendario(resultado.getInt("id_calendario"));
        calendario.setCerrado(resultado.getString("cerrado").charAt(0));
        calendario.setTemporada(resultado.getString("temporada"));
    }

    public static boolean buscarCalendarioBoolean(){
        //metodo para consultar si ya existe un calendario
        try {


            plantilla = "select * from calendario";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);

            resultado = sentenciaPre.executeQuery();

            if (resultado.next()) {
                sentenciaPre.close();

                BaseDatos.cerrarConexion();
                return true;

            }
            else {
                sentenciaPre.close();

                BaseDatos.cerrarConexion();
                return false;
            }


        }
        catch (SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
