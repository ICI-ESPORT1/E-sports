package Modelo.BD;

import Modelo.UML.Entrenador;
import Modelo.UML.Jornada;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 *  Clase que contiene los metodos necesarios para trabajar con la tabla jornada
 */
public class JornadaDAO {

    private static Jornada jornada;
    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    private static ArrayList<Jornada>listaJornada = new ArrayList();

    /**
     * Metodo para insertar una nueva jornada en la tabla jornada
     * @param j
     */
    public static void altaJornada(Jornada j) {
        try {
            BaseDatos.abrirConexion();

            c = BaseDatos.getConexion().prepareCall("{call gestionarJornada.nuevo_jornada(?,?,?)}");

            c.setDate(1, Date.valueOf(j.getFecha()));
            c.setString(2, j.getNumSemana());
            c.setInt(3, j.getCalendario().getIdCalendario());

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
     * metodo para borrar una jornada de la tabla jornada por num_jornada
     * @param j
     */
    public static void bajaJornada(Jornada j) {
        //
        try {
            //  BaseDatos.abrirConexion();

            c = BaseDatos.getConexion().prepareCall("{call gestionarJornada.borrar_jornada(?)}");

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

    /**
     * Metodo para consultar todas las jornadas
     * @return
     */
    public static ArrayList<Jornada> selectTodos(){
        try{
            listaJornada = new ArrayList<>();
             BaseDatos.abrirConexion();

            plantilla="select * from jornada order by num_jornada";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            resultado = sentenciaPre.executeQuery();
            resultado.next();
            do{
                crearObjeto();
                listaJornada.add(jornada);
            }while(resultado.next());


            //  BaseDatos.cerrarConexion();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaJornada;

    }

    /**
     * Funcion para crear el objeto de rol
     */
    public static void crearObjeto(){
        try{
            jornada = new Jornada();
            jornada.setNumJornada(resultado.getInt("num_jornada"));
            jornada.setNumSemana(resultado.getString("num_semana"));
            Date dfecha;
            String fecha = new SimpleDateFormat("dd/MM/yyyy").format(resultado.getDate("fecha"));
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate ldFecha = LocalDate.parse(fecha,formato);
            jornada.setFecha(ldFecha);
        }catch (Exception e){System.out.println(e.getMessage());}


    }

}
