package Modelo.BD;

import Modelo.UML.Entrenador;
import Modelo.UML.Equipo;


import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
/**
 * @Author celia Garcia
 * @Version 1.0
 */
public class EntrenadorDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla entrenador*/

    private static Entrenador entrenador;
    private static Entrenador coach = entrenador;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;
    private static ArrayList<Entrenador>listaEntrenadores = new ArrayList();


    public EntrenadorDAO() {
    }

    public static void altaEntrenador(Entrenador e) {
        try {
            int n = 0;
            plantilla = "INSERT INTO entrenador (dni,nombre,telefono,direccion,id_equipo,sueldo) VALUES (?,?,?,?,?,?)";
            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1, e.getDni());
            sentenciaPre.setString(2, e.getNombre());
            sentenciaPre.setString(3, e.getTelefono());
            sentenciaPre.setString(4, e.getDireccion());
            int idEquipo = e.getEquipo().getId_equipo();
            sentenciaPre.setInt(5, idEquipo);
            sentenciaPre.setFloat(6, e.getSueldo());
            n = sentenciaPre.executeUpdate();

            System.out.println("filas " + n);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        BaseDatos.cerrarConexion();
    }


    public static void bajaEntrenador(String dni){
        //metodo para borrar un entrenador de la tabla entrenador por id_entrenador
        BaseDatos.abrirConexion();
        try {

        c =BaseDatos.getConexion().prepareCall("{call gestionarEntrenadores.borrar_entrenador(?)}");

        c.setString(1,dni);

            c.execute();

            c.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
       BaseDatos.cerrarConexion();
    }

    public static void cambioEquipoEntrenador(Entrenador e, int idEquipoNuevo) {
        //metodo para cambiar a un entrenador de equipo
       BaseDatos.abrirConexion();
        try {
            // BaseDatos.abrirConexion();

            c = BaseDatos.getConexion().prepareCall("{call cambio_equipo_entrenador(?,?)}");

            c.setInt(1, e.getCodPersona());
            c.setInt(2, idEquipoNuevo);

            c.execute();

            c.close();

        BaseDatos.cerrarConexion();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }


    public static Entrenador consultarEntrenador(String dni) {
        //Metodo para consultar un entrenador por dni a la base de datos
        try {
            BaseDatos.abrirConexion();

            plantilla = "select * from entrenador where dni = ?";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1, dni.toUpperCase());

            resultado = sentenciaPre.executeQuery();

            if (resultado.next()) {
                crearObjeto();
            }
            Entrenador coach = entrenador;
            BaseDatos.cerrarConexion();
            return coach;

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);
            return coach;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return coach;
        }
    }
    public static ArrayList<Entrenador> selectTodos(){
        BaseDatos.abrirConexion();
        try{
            listaEntrenadores = new ArrayList<>();
                    //Metodo para consultar un entrenador por dni a la base de datos
            //  BaseDatos.abrirConexion();

            plantilla="select * from entrenador";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            resultado = sentenciaPre.executeQuery();
            while(resultado.next()){
                crearObjeto();
                listaEntrenadores.add(entrenador);
            }


        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
              BaseDatos.cerrarConexion();

        return listaEntrenadores;

    }
    public static boolean cambiarNombreEntrenador(String nNuevo,String dni){
        BaseDatos.abrirConexion();
        boolean cambiado=false;
        int ok =0;
        try{
            BaseDatos.abrirConexion();
            plantilla="update entrenador set nombre= ? where dni= ?" ;

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1,nNuevo);
            sentenciaPre.setString(2, dni);
            ok = sentenciaPre.executeUpdate();

            if(ok ==1){
                cambiado = true;
            }

            BaseDatos.cerrarConexion();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return cambiado;
    }
    public static boolean cambiarTelefonoEntrenador(String nTelf, String dni){
        BaseDatos.abrirConexion();
        boolean cambiado=false;
        int ok =0;
        try{
            BaseDatos.abrirConexion();
            plantilla="update entrenador set telefono= ? where dni= ?" ;

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1,nTelf);
            sentenciaPre.setString(2, dni);
            ok = sentenciaPre.executeUpdate();

            if(ok ==1){
                cambiado = true;
            }

            BaseDatos.cerrarConexion();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return cambiado;
    }
    public static boolean cambiarSalarioEntrenador(float sN,String dni){
        boolean cambiado=false;
        int ok =0;

        try{
            BaseDatos.abrirConexion();
            plantilla="update entrenador set sueldo= ? where dni= ?" ;

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setFloat(1,sN);
            sentenciaPre.setString(2, dni);
            ok = sentenciaPre.executeUpdate();

            if(ok ==1){
                cambiado = true;
            }
            BaseDatos.cerrarConexion();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle.getMessage() + " ," + sqle.getErrorCode(), "Error Oracle", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return cambiado;

    }

    public static void crearObjeto(){
      try{
        entrenador = new Entrenador();
        entrenador.setCodPersona(resultado.getInt("id_entrenador"));
          System.out.println(entrenador.getCodPersona());
        entrenador.setDni(resultado.getString("dni"));
          System.out.println(entrenador.getDni());
        entrenador.setNombre(resultado.getString("nombre"));
          System.out.println(entrenador.getNombre());
        entrenador.setTelefono(resultado.getString("telefono"));
          System.out.println(entrenador.getTelefono());
        entrenador.setLocalidad(resultado.getString("direccion"));
          System.out.println(entrenador.getDireccion());


          System.out.println(resultado.getInt("SUELDO"));
          entrenador.setSueldo(resultado.getInt("sueldo"));
          System.out.println(entrenador.getSueldo());

          /*Necesito el id del equipo del entrenador*/
          int idEquipo = resultado.getInt("id_equipo");
          Equipo equipo = new Equipo();
          equipo = EquipoDAO.consultarEquipoPorId(idEquipo);
          entrenador.setEquipo(equipo);
          System.out.println(entrenador.getEquipo().getId_equipo());
    }catch (Exception e){System.out.println(e.getMessage());}

    }
}
