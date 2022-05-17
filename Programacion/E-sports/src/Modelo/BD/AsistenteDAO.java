package Modelo.BD;

import Modelo.UML.*;

import java.sql.*;

public class AsistenteDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla asistente*/

    private static Asistente asistente = new Asistente();

    private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;
    private static CallableStatement calla;

    public static void altaAsistente(Asistente a) {
        //Metodo para insertar un nuevo asistente en la tabla asistente
        //  BaseDatos.abrirConexion();
        try {
            calla = BaseDatos.getConexion().prepareCall("{call gestionarAsistente.nuevo_asistente(?,?,?,?,?)}");


            calla.setString(1, a.getDni());
            System.out.println(a.getDni());
            calla.setString(2, a.getNombre());
            System.out.println(a.getNombre());
            calla.setString(3, a.getTelefono());
            System.out.println(a.getTelefono());
            calla.setString(4,a.getDireccion());
            calla.setFloat(5, a.getSueldo());
            System.out.println(a.getSueldo());
            calla.execute();
            calla.close();
            //  BaseDatos.cerrarConexion();

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

    }


    public static void bajaAsistente(Asistente a) throws Exception {
        //metodo para borrar un asistente de la tabla asistente por id_asistente
        // BaseDatos.abrirConexion();

        calla = BaseDatos.getConexion().prepareCall("{call borrar_asistente(?)}");

        calla.setInt(1, a.getCodPersona());

        calla.execute();

        calla.close();

        //  BaseDatos.cerrarConexion();
    }
/*
    public static void cambioEquipoAsistente(Asistente a, int idEquipoNuevo)throws Exception{
        //metodo para cambiar a un asistente de equipo
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call cambio_equipo(?,?)}");

        c.setInt(1,a.getCodPersona());
        c.setInt(2,idEquipoNuevo);

        c.execute();

        c.close();

        BaseDatos.cerrarConexion();

    }*/ //Esto esta comentado porque no tiene email

    public static Asistente consultarAsistente(String dni) throws Exception {
        //Metodo para consultar un asistente por dni a la base de datos
        //  BaseDatos.abrirConexion();

        plantilla = "select * from asistente where dni = ?";

        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setString(1, dni);

        resultado = sentenciaPre.executeQuery();
        if (resultado.next()) {
            crearObjeto();
        }

        //  BaseDatos.cerrarConexion();
        return asistente;

    }

    public static void crearObjeto() throws Exception {

        asistente.setCodPersona(resultado.getInt("id_asistente"));
        System.out.println(asistente.getCodPersona());
        asistente.setDni(resultado.getString("dni"));
        asistente.setNombre(resultado.getString("nombre"));
        asistente.setTelefono(resultado.getString("telefono"));
        asistente.setLocalidad(resultado.getString("direccion"));
        asistente.setSueldo(resultado.getFloat("sueldo"));

    }
}