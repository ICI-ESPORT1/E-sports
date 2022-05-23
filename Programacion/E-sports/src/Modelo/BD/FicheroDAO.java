package Modelo.BD;

import Modelo.UML.Calendario;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
/**
 * @Author celia Garcia
 * @Version 1.0
 */
public class FicheroDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla fichero*/

    private static Calendario calendario = new Calendario();

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static void FechaJornadas(){
        //Metodo para comprobar la fecha del fichero xml
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



    public static void FechaUltimaJornada(){
        //Metodo para comprobar la fecha del fichero xml
        try {

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
