package Modelo.BD;

import Modelo.UML.Calendario;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
/**
 * Clase que contiene los metodos necesarios para trabajar con la tabla fichero
 */
public class FicheroDAO {

    private static Calendario calendario = new Calendario();
    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    /**
     * Metodo para comprobar la fecha del fichero xml
     */
    public static void FechaJornadas(){
        try {

            plantilla = "select fecha from fichero where nombre = JORNADAS ";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);

            resultado= sentenciaPre.executeQuery();

            if (resultado.getDate("fecha").before(Date.valueOf(LocalDate.now())))
                plantilla="{call generarXmlPartidos}";

            sentenciaPre.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Metodo para comprobar la fecha del fichero xml
     */
    public static void FechaUltimaJornada(){

        try {
            BaseDatos.abrirConexion();

            plantilla = "select fecha from fichero where nombre = ULTIMAJORN ";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);

            resultado= sentenciaPre.executeQuery();

            if (resultado.getDate("fecha").before(Date.valueOf(LocalDate.now())))
                plantilla="{call generarUltimaJorn}";

            sentenciaPre.close();


        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
