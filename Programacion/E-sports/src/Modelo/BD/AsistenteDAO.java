package Modelo.BD;

import Modelo.UML.*;

import javax.swing.*;
import java.sql.*;

public class AsistenteDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla asistente*/

    private static Asistente asistente = new Asistente();

    private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;
    private static CallableStatement calla;

    public static void altaAsistente(Asistente a) {
        //Metodo para insertar un nuevo asistente en la tabla asistente

        try {
            //  BaseDatos.abrirConexion();
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
            //  BaseDatos.cerrarConexion();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);
            System.out.println(sqle.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    public static void bajaAsistente(Asistente a) {
        //metodo para borrar un asistente de la tabla asistente por id_asistente

        try {
            // BaseDatos.abrirConexion();
            calla = BaseDatos.getConexion().prepareCall("{call borrar_asistente(?)}");

            calla.setInt(1, a.getCodPersona());

            calla.execute();

            calla.close();

            //  BaseDatos.cerrarConexion();
        }
        catch (SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


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
    public static boolean cambiarSalarioEntrenador(Float fsalario,String dni){
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