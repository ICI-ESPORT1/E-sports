package MODELO.BD;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Celia Garcia
 * @version 1
 */
public class BaseDatos {
    private String usuario = "eqdaw02";
    private String pass = "eqdaw02";
    private String url = "jdbc:oracle:thin:@172.20.225.114:1521:orcl";

    private static Connection conexion;


    public BaseDatos() {
    }

    public static Connection getConexion() {
        return conexion;
    }

    public static void setConexion(Connection conexion) {
        BaseDatos.conexion = conexion;
    }

    /**
     * Metodo para establecer la conexion con la base de datos
     */
    public void abrirConexion(){
        try{
            System.out.println("He establecido la conexion");
            Class.forName("oracle.jdbc.OracleDriver");
            conexion = DriverManager.getConnection(url,usuario, pass);

            if(conexion == null){
                throw new Exception("Problemas con la conexion");
            }
        }catch (Exception e){System.out.println(e.getClass());}
    }

    /**
     * Metodo para cerrar la conexion con la base de datos
     */
    public void cerrarConexion(){
        try{
            conexion.close();
            System.out.println("Cierro la conexion");
        }catch (Exception e){

        }
    }
}
