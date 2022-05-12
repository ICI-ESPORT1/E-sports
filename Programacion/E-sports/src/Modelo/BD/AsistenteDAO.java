package Modelo.BD;

import Modelo.UML.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AsistenteDAO {

 /* Clase que contiene los metodos necesarios para trabajar con la tabla asistente*/

    private static Asistente asistente;

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;

    public static void altaAsistente(Asistente a)throws Exception{
        //Metodo para insertar un nuevo asistente en la tabla asistente
        BaseDatos.abrirConexion();

        plantilla="insert into asistente values (?,?,?,?,?,?)";
        sentenciaPre=BaseDatos.getConexion().preparedStatement(plantilla);
        sentenciaPre=setString(1,a.getDni());
        sentenciaPre=setString(2,a.getNombre());
        sentenciaPre=setString(3,a.getTelefono());
        sentenciaPre=setString(4,a.getMail());
        sentenciaPre=setString(5,a.getLocalidad());
        sentenciaPre=setFloat(6,a.getSueldo());

        int n=sentenciaPre.executeUpdate();

        BaseDatos.cerrarConexion();

        if (n!=1)
            throw new Exception("Fallo al insertar un asistente");
    }


    public static void bajaAsistente(Asistente a)throws Exception{
        //metodo para borrar un asistente de la tabla asistente por id_asistente
        BaseDatos.abrirConexion();

        plantilla="delete from asistente where id_asistente = ?";
        sentenciaPre = BaseDatos.getConexion().preparedStatement(plantilla);
        sentenciaPre = setInteger(1,a.getCodPersona());

        int n = sentenciaPre.executeUpdate();
        if (n == 0)
            throw new Exception();

        System.out.println(n + " filas borradas");

        BaseDatos.cerrarConexion();
    }

    public static ArrayList<Asistente> consultarAsistente(String dni)throws Exception{
        //Metodo para consultar un asistente por id_asistente a la base de datos
        BaseDatos.abrirConexion();

        plantilla="select * from asistente where dni = ?";

        sentenciaPre = BaseDatos.getConexion().preparedStatement(plantilla);

        resultado = sentenciaPre.executeQuery();
        ArrayList<Asistente> listaAsistentes = new ArrayList<>();

        crearObjeto();
        listaAsistentes.add(asistente);


    }

    public static void crearObjeto()throws Exception{

        asistente.setCodPersona(resultado.getString("id_asistente"));

    }
}