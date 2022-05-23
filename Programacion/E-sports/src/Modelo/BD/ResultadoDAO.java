package Modelo.BD;

import Modelo.UML.Resultado;

import javax.swing.*;
import java.sql.*;

public class ResultadoDAO {
    /* Clase que contiene los metodos necesarios para trabajar con la tabla resultado*/

    private static Resultado res;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static Resultado obtenerClasificacion() {
        //Metodo para mostrar la clasificacion actual
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

    public static Resultado obtenerPartidosJornadas() {
        //Metodo para mostrar todos los partidos de las jornadas
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

    public static Resultado obtenerPartidos() {
        //Metodo para mostrar todos los partidos que se han jugado
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

}
