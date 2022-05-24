package Modelo.BD;

import Modelo.UML.Jornada;
import Modelo.UML.Partido;
//import com.sun.xml.internal.ws.wsdl.writer.document.Part;

import javax.swing.*;
import java.sql.*;
/**
 * Clase que contiene los metodos necesarios para trabajar con la tabla partido
 */
import java.time.LocalDate;
import java.util.ArrayList;

public class PartidoDAO {

    private static Partido partido;
    private static Jornada jornada;
    private static ArrayList<Partido> listaPartido = new ArrayList<>();

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

            plantilla = "insert into partido (turno,num_jornada) values (?,?)";

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


   /**
   *Metodo para obtener los partidos de una jornada
   */
    public static ArrayList<Partido> conseguirIDJorn(Jornada j){

        try {
            BaseDatos.abrirConexion();

            plantilla = "select * from partido where num_jornada = ? ";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setInt(1, j.getNumJornada());

         resultado=   sentenciaPre.executeQuery();
            resultado.next();
            do{
                crearObjeto();
                listaPartido.add(partido);
            }while(resultado.next());

            sentenciaPre.close();

            BaseDatos.cerrarConexion();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaPartido;
    }

    public static void crearObjeto(){
        try{
            partido = new Partido();
            partido.setIdPartido(resultado.getInt("id_partido"));
            partido.setTurno(resultado.getString("turno"));

        }catch (Exception e){System.out.println(e.getMessage());}


    }

}
