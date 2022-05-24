package Modelo.BD;

import Modelo.UML.Equipo;
import Modelo.UML.Resultado;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Clase que contiene los metodos necesarios para trabajar con la tabla resultado.
 */
public class ResultadoDAO {

    private static Resultado res;
    private static ArrayList<Equipo> listaEquipo = new ArrayList<>();

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;


    /**
     * Metodo para mostrar la clasificacion actual
     * @return
     */
    public static Resultado obtenerClasificacion() {
        try {

            System.out.println("bien");
            c = BaseDatos.getConexion().prepareCall("{call gestionResultados.obtenerClasificacion(?)}");
            c.registerOutParameter(1, (SQLType) res);
            c.execute();
            c.close();

            BaseDatos.cerrarConexion();
            return res;

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    /**
     * Metodo para mostrar todos los partidos de las jornadas
     * @return
     */
    public static Resultado obtenerPartidosJornadas() {
        try {
            //  BaseDatos.abrirConexion();

            c = BaseDatos.getConexion().prepareCall("{call gestionResultados.partidosJornada(?)}");

            c.registerOutParameter(1, (SQLType) res);

            c.execute();

            c.close();

            //  BaseDatos.cerrarConexion();

            return res;

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    /**
     * Metodo para mostrar todos los partidos que se han jugado
     * @return
     */
    public static Resultado obtenerPartidos() {
        try {
            //  BaseDatos.abrirConexion();

            c = BaseDatos.getConexion().prepareCall("{call gestionResultados.partidos(?)}");

            c.registerOutParameter(1, (SQLType) res);

            c.execute();

            c.close();

            //   BaseDatos.cerrarConexion();

            return res;
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    /**
     *
     * @param eq
     * @param res
     * @param part
     * Metodo para insertar el resultado
     * @return
     */
    public static boolean insertResultado(int eq,int res,int part){
        BaseDatos.abrirConexion();
        boolean ok = false;
        try{
            plantilla="insert into resultado values ?,?,?";
            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setInt(1,part);
            sentenciaPre.setInt(2,eq);
            sentenciaPre.setInt(3,res);

            ok = sentenciaPre.execute();

            BaseDatos.cerrarConexion();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ok;

    }

    public static boolean insertResultadoSinResultado(int eq,int part){
        BaseDatos.abrirConexion();
        boolean ok = false;
        try{

            plantilla="insert into resultado (id_equipo,id_partido) values ?,?";
            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setInt(1,eq);
            sentenciaPre.setInt(2,part);

            ok= sentenciaPre.execute();

            BaseDatos.cerrarConexion();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ok;

    }

}
