package Modelo.BD;

import Modelo.UML.Dueno;

import javax.swing.*;
import java.sql.*;
/**
 * Clase que contiene los metodos necesarios para trabajar con la tabla dueño
 */
public class DuenoDAO {

    private static Dueno dueno= new Dueno();
    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;


    /**
     * Metodo para insertar un nuevo dueno en la tabla dueno
     * @param d
     */
    public static void altaDueno(Dueno d){

        try{
            BaseDatos.abrirConexion();
            c=BaseDatos.getConexion().prepareCall("{call gestionarDueno.nuevo_dueno(?,?,?,?,?)}");

            c.setString(1,d.getDni());
            c.setString(2,d.getNombre());
            c.setString(3,d.getTelefono());
            c.setString(4,d.getDireccion());
            c.setInt(5, d.getEquipo().getId_equipo());

            c.execute();

            c.close();

        }
        catch (SQLException sqle){
            JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);

        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }

     //   BaseDatos.cerrarConexion();
    }


    /**
     * metodo para borrar un dueno de la tabla dueno por id_dueno
     * @param dni
     */
    public static void bajaDueno(String dni){
        try {
            //   BaseDatos.abrirConexion();

            c = BaseDatos.getConexion().prepareCall("{call gestionarDueno.borrar_dueno(?)}");

        c.setString(1,dni);

            c.execute();

            c.close();

            //  BaseDatos.cerrarConexion();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    /**
     * metodo para cambiar a un dueño de equipo
     * @param d
     * @param idEquipoNuevo
     */
    public static void cambioEquipoDueno(Dueno d, int idEquipoNuevo){
        try {
            //  BaseDatos.abrirConexion();

            c = BaseDatos.getConexion().prepareCall("{call cambio_equipo_dueno(?,?)}");

            c.setInt(1, d.getCodPersona());
            c.setInt(2, idEquipoNuevo);

            c.execute();

            c.close();

            // BaseDatos.cerrarConexion();

        }

        catch (SQLException sqle){
        JOptionPane.showMessageDialog(null,sqle.getMessage()+" ,"+sqle.getErrorCode(),"Error Oracle",JOptionPane.ERROR_MESSAGE);

    }
        catch (Exception e){
        System.out.println(e.getMessage());

    }
    }

    /**
     * Metodo para consultar un Dueno por dni a la base de datos
     * @param d
     * @return
     */
    public static Dueno consultarDueno(String d){

        try {
            //  BaseDatos.abrirConexion();

            plantilla = "select * from dueno where dni = ?";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1, d);

            resultado = sentenciaPre.executeQuery();
            while (resultado.next()) {
                crearObjeto();
            }
            //  BaseDatos.cerrarConexion();
            return dueno;

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);
            return dueno;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return dueno;
        }
    }

    /**
     * Funcion que crea el objeto de dueno.
     * @throws Exception
     */
    public static void crearObjeto()throws Exception{
        System.out.println(resultado.getInt(1));
        dueno.setCodPersona(resultado.getInt("id_dueno"));
        dueno.setDni(resultado.getString("dni"));
        dueno.setNombre(resultado.getString("nombre"));
        dueno.setTelefono(resultado.getString("telefono"));
        dueno.setLocalidad(resultado.getString("direccion"));

    }
}
