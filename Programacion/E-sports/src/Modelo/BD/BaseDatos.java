package Modelo.BD;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author Celia Garcia
 * @version 1
 */
public class BaseDatos {

    private static String usuario = "eqdaw02";
    private static String pass = "eqdaw02";
    private static String url = "jdbc:oracle:thin:@172.20.225.114:1521:orcl";
    private static Connection conexion;
    private static boolean casa = true;

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
     *
     */
    public static void abrirConexion(){
        try{
            if(conexion!=null){
                conexion.close();
            }
            if(!casa){
                Class.forName("oracle.jdbc.OracleDriver");
                conexion = DriverManager.getConnection(url,usuario, pass);
            }
            else{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conexion = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.192:1521/orcl","system", "oracle");
            }
            if(conexion == null){
                throw new Exception("Problemas con la conexion");
            }else{System.out.println("He establecido la conexion");}
        }catch (Exception e){System.out.println(e.getClass());}
    }

    /**
     * Metodo para cerrar la conexion con la base de datos
     */
    public static void cerrarConexion(){
        try{
            conexion.close();
            if(conexion == null){
                throw new Exception("No se ha cerrado la conexion");
            }else{ System.out.println("Cierro la conexion");}
        }catch (Exception e){System.out.println(e.getMessage()+ "Error al cerrar la conexion");}
    }
}
