package Modelo.BD;

import Modelo.UML.Jornada;
import Modelo.UML.Partido;
//import com.sun.xml.internal.ws.wsdl.writer.document.Part;

import javax.swing.*;
import java.sql.*;

public class PartidoDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla partido*/

    private static Partido partido;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static void altaPartido(Partido p) {
        //Metodo para insertar un nuevo partido en la tabla partido
        try {
            BaseDatos.abrirConexion();

            plantilla = "insert into partido values (?,?)";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1, String.valueOf(p.getTurno()));
            sentenciaPre.setInt(2, p.getJornada().getNumJornada());

            sentenciaPre.execute();

            sentenciaPre.close();

            BaseDatos.cerrarConexion();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void bajaJornada(Jornada j) {
        //metodo para borrar una jornada de la tabla jornada por num_jornada
        try {
            //  BaseDatos.abrirConexion();

            c = BaseDatos.getConexion().prepareCall("{call borrar_jornada(?)}");

            c.setInt(1, j.getNumJornada());

            c.execute();

            c.close();

            //    BaseDatos.cerrarConexion();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
