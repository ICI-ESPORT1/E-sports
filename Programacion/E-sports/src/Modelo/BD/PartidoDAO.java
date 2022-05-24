package Modelo.BD;

import Modelo.UML.Jornada;
import Modelo.UML.Partido;
//import com.sun.xml.internal.ws.wsdl.writer.document.Part;

import javax.swing.*;
import java.sql.*;
/**
 * Clase que contiene los metodos necesarios para trabajar con la tabla partido
 */
public class PartidoDAO {

    private static Partido partido;
    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    /**
     * Metodo para insertar un nuevo partido en la tabla partido
     * @param p
     *
     */
    public static void altaPartido(Partido p) {
        //
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

}
