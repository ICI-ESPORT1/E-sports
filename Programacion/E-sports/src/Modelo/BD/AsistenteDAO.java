package Modelo.BD;

import Modelo.UML.*;

import javax.swing.*;
import java.sql.*;
/**

 * Clase que contiene los metodos necesarios para trabajar con la tabla asistente
 */
public class AsistenteDAO {


    private static Asistente asistente = new Asistente();

    private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;
    private static CallableStatement calla;

    /**
     *
     * @param a
     * Metodo para insertar un nuevo asistente en la tabla asistente
     */
    public static void altaAsistente(Asistente a) {
        //Metodo para insertar un nuevo asistente en la tabla asistente
         BaseDatos.abrirConexion();
        try {
            // BaseDatos.abrirConexion();
            calla = BaseDatos.getConexion().prepareCall("{call gestionarAsistente.nuevo_asistente(?,?,?,?,?)}");


            calla.setString(1, a.getDni());
            System.out.println(a.getDni());
            calla.setString(2, a.getNombre());
            System.out.println(a.getNombre());
            calla.setString(3, a.getTelefono());
            System.out.println(a.getTelefono());
            calla.setString(4,a.getDireccion());
            calla.setFloat(5, a.getSueldo());
            System.out.println(a.getSueldo());
            calla.execute();
            calla.close();
             BaseDatos.cerrarConexion();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);
            System.out.println(sqle.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    /**
     *
     * @param dni
     * Metodo para borrar un asistente de la tabla asistente por id_asistente
     */
    public static void bajaAsistente(String dni) {
     
         BaseDatos.abrirConexion();

        try {
            // BaseDatos.abrirConexion();
        calla = BaseDatos.getConexion().prepareCall("{call gestionarAsistente.borrar_asistente(?)}");

        calla.setString(1, dni);

            calla.execute();

            calla.close();

              BaseDatos.cerrarConexion();
        }
        catch (SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
          BaseDatos.cerrarConexion();
    }

    /**
     *
     * @param dni
     * @return
     * Metodo para consultar un asistente por dni a la base de datos
     */
    public static Asistente consultarAsistente(String dni) {
        //Metodo para consultar un asistente por dni a la base de datos
        try {
            BaseDatos.abrirConexion();

            plantilla = "select * from asistente where dni = ?";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1, dni);

            resultado = sentenciaPre.executeQuery();
            if (resultado.next()) {
                crearObjeto();
            }

            BaseDatos.cerrarConexion();
            return asistente;

        }
        catch (SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);
            return asistente;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return asistente;
        }
    }

    /**
     *
     * @param nombreN
     * @param dni
     * @return
     * Metodo para Cambiar nombre al asistente desde la base de datos
     *
     */
    public static boolean cambiarNombreAsistente(String nombreN,String dni){
        boolean cambiado=false;
        int ok =0;
        try{
            BaseDatos.abrirConexion();
            plantilla="update asistente set nombre= ? where dni= ?" ;

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1,nombreN);
            sentenciaPre.setString(2, dni);
            ok = sentenciaPre.executeUpdate();

            if(ok ==1){
                cambiado = true;
            }

            BaseDatos.cerrarConexion();
        }
        catch (SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);
           return cambiado;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
           return cambiado;
        }
        return cambiado;
    }

    /**
     *
     * @param telefN
     * @param dni
     * @return
     * Metodo para cambiar telefono al asistente desde la base de datos
     */
    public static boolean cambiarTelefonoAsistente(String telefN,String dni){
        boolean cambiado=false;
        int ok =0;
        try{
            BaseDatos.abrirConexion();
            plantilla="update asistente set telefono= ? where dni= ?" ;

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1,telefN);
            sentenciaPre.setString(2, dni);
            ok = sentenciaPre.executeUpdate();

            if(ok ==1){
                cambiado = true;
            }

            BaseDatos.cerrarConexion();
        }
        catch (SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);
            return cambiado;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return cambiado;
        }
        return cambiado;
    }

    /**
     *
     * @param fsalario
     * @param dni
     * @return
     * Metodo para cambiar el salario del asistente desde la base de datos
     */
    public static boolean cambiarSalarioAsistente(Float fsalario,String dni){
        boolean cambiado=false;
        int ok =0;

        try{
            BaseDatos.abrirConexion();
            plantilla="update asistente set sueldo= ? where dni= ?" ;

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setFloat(1,fsalario);
            sentenciaPre.setString(2, dni);
            ok = sentenciaPre.executeUpdate();

            if(ok ==1){
                cambiado = true;
            }
            BaseDatos.cerrarConexion();
        }
        catch (SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);
            return cambiado;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return cambiado;
        }
        return cambiado;
    }

    /**
     *
     * @throws Exception
     * Funcion donde se crea el objeto
     */
    public static void crearObjeto() throws Exception {

        asistente.setCodPersona(resultado.getInt("id_asistente"));
        System.out.println(asistente.getCodPersona());
        asistente.setDni(resultado.getString("dni"));
        asistente.setNombre(resultado.getString("nombre"));
        asistente.setTelefono(resultado.getString("telefono"));
        asistente.setLocalidad(resultado.getString("direccion"));
        asistente.setSueldo(resultado.getFloat("sueldo"));

    }
}
