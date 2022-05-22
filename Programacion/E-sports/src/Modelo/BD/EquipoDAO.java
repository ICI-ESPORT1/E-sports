package Modelo.BD;

import Modelo.UML.Asistente;
import Modelo.UML.Equipo;

import javax.swing.*;
import java.net.PortUnreachableException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class EquipoDAO {

    /* Clase que contiene los metodos necesarios para trabajar con la tabla equipo*/

    private static Equipo equipo = new Equipo();
    private static ArrayList<Equipo> listaEquipos = new ArrayList<>();

    private  static PreparedStatement sentenciaPre;
    private  static String plantilla;
    private  static Statement sentencia;
    private  static ResultSet resultado;
    private static CallableStatement c;

    public static void altaEquipo(Equipo e, Asistente a)throws Exception{
        //Metodo para insertar un nuevo equipo en la tabla equipo
       // BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call gestionarEquipos.nuevo_equipo(?,?,?,?,?,?,?)}");

        c.setString(1,e.getNombre());
        c.setString(2,e.getNacionalidad());
        c.setDate(3, Date.valueOf(e.getFechaCreacion()));
        c.setString(4,e.getTelefono());
        c.setString(5, e.getMail());
        c.setString(6, e.getEscudo());
        c.setInt(7,a.getCodPersona());
        /*Antes de añadir el asistente necesitamos el id del asistente que acabamos de insertar*/

        c.setInt(7, e.getAsistente().getCodPersona());

        c.execute();

        c.close();

      //  BaseDatos.cerrarConexion();
    }


    public static boolean bajaEquipo(Equipo e)throws Exception{
        boolean borrado= false;
        //metodo para borrar un equipo de la tabla equipo por nombre
        BaseDatos.abrirConexion();

        c=BaseDatos.getConexion().prepareCall("{call borrar_equipo(?)}");

        c.setString(1,e.getNombre());

       borrado = c.execute();

        c.close();

        BaseDatos.cerrarConexion();

        return borrado;
    }

    public static boolean cambiarNombreEquipo(String nombreNuevo, String nombreViejo){
        boolean nombreCambiado = false;
        try{

            //metodo para cambiar el nombre de un equipo
            BaseDatos.abrirConexion();

            c=BaseDatos.getConexion().prepareCall("{call gestionarEquipos.cambiar_nombre_equipo(?,?)}");

            c.setString(1,nombreViejo);
            c.setString(2,nombreNuevo );

            nombreCambiado = c.execute();

            c.close();

            BaseDatos.cerrarConexion();

        }catch (SQLException sqle){System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null, sqle.getErrorCode() +sqle.getMessage() + " Consulte el error");}


       return nombreCambiado;
    }

    public static boolean cambiarNacionalidadEquipo(String naNuevo,String nombre){
        boolean cambiado=false;
        int ok =0;
        try{
            BaseDatos.abrirConexion();
            plantilla="update equipo set nacionalidad= ? where upper(nombre)= ?" ;
            naNuevo = naNuevo.toUpperCase();
            nombre = nombre.toUpperCase();
            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1,naNuevo);
            sentenciaPre.setString(2, nombre);
            ok = sentenciaPre.executeUpdate();

            sentenciaPre.close();

            if(ok == 1){
                cambiado = true;
            }
            BaseDatos.cerrarConexion();
        }catch (SQLException sqle){System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null, sqle.getErrorCode()+ "Consulte el error");}
        return cambiado;
    }
    public static boolean cambiarTelefonoEquipo(String telNuevo,String telViejo){
        boolean cambiado=false;
        int ok =0;
        try{
            BaseDatos.abrirConexion();
            plantilla="update equipo set telefono = ? where telefono = ?" ;

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1, telNuevo);
            sentenciaPre.setString(2, telViejo);
            ok = sentenciaPre.executeUpdate();

            if(ok ==1){
                cambiado = true;
            }

            BaseDatos.cerrarConexion();
        }catch (SQLException sqle){System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null, sqle.getErrorCode()+ "Consulte el error");}
        return cambiado;
    }
    public static boolean cambiarFechaEquipo(LocalDate ldNuevo, LocalDate ldViejo)throws Exception{
        boolean cambiado=false;
        int ok =0;
        try{
            BaseDatos.abrirConexion();
            plantilla="update equipo set fecha_creacion= ? where fecha_creacion= ?" ;

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setDate(1,Date.valueOf(ldNuevo));
            sentenciaPre.setDate(2, Date.valueOf(ldViejo));
            ok = sentenciaPre.executeUpdate();

            if(ok ==1){
                cambiado = true;
            }

            BaseDatos.cerrarConexion();
        }catch (SQLException sqle){System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null, sqle.getMessage());}
        return cambiado;
    }
    public static boolean cambiarMailEquipo(String mailNuevo,String mailViejo){
        boolean cambiado=false;
        int ok =0;
        try{
            BaseDatos.abrirConexion();
            plantilla="update equipo set mail = ? where mail = ?" ;

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setString(1, mailNuevo);
            sentenciaPre.setString(2, mailViejo);
            ok = sentenciaPre.executeUpdate();

            if(ok ==1){
                cambiado = true;
            }

            BaseDatos.cerrarConexion();
        }catch (SQLException sqle){System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null, sqle.getErrorCode()+ "Consulte el error");
        }
        return cambiado;
    }

    public static Equipo consultarEquipo(String n)throws Exception{
        //Metodo para consultar un Equipo por nombre a la base de datos
        //  BaseDatos.abrirConexion();
        String nombreMayus = n.toUpperCase();
        plantilla="select * from equipo where upper(nombre) = ?";

        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setString(1,nombreMayus);

        resultado = sentenciaPre.executeQuery();
    while(resultado.next()){
        crearObjeto();
    }


        return equipo;

    }

    public static Equipo consultarEquipoID(String n)throws Exception{
        //Metodo para consultar un Equipo por nombre a la base de datos
        BaseDatos.abrirConexion();

        plantilla="select * from equipo where cod_equipo = ?";

        sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
        sentenciaPre.setInt(1,Integer.parseInt(n));

        resultado = sentenciaPre.executeQuery();
        while (resultado.next()){
            crearObjeto();
        }

        BaseDatos.cerrarConexion();
        return equipo;

    }
 public static Equipo consultarEquipoPorId(int idEq){
        try{
            BaseDatos.abrirConexion();

            plantilla="select * from equipo where cod_equipo = ?";

            sentenciaPre = BaseDatos.getConexion().prepareStatement(plantilla);
            sentenciaPre.setInt(1,idEq);

            resultado = sentenciaPre.executeQuery();
            while (resultado.next()){
                crearObjeto();
            }

            BaseDatos.cerrarConexion();
            return equipo;
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage()); }
        return equipo;
 }

    public static ArrayList<Equipo> selectTodosLosEquipos(){
     //   BaseDatos.abrirConexion();
        try{
            listaEquipos = new ArrayList<>();
            plantilla= "select * from equipo ";
            sentenciaPre= BaseDatos.getConexion().prepareStatement(plantilla);

            resultado = sentenciaPre.executeQuery();

            if(!resultado.next()){
                System.out.println("No se ha recuperado ningun equipo");
            }else {


                do {
                    System.out.println("CREANDO OBJETO*******");
                    System.out.println(resultado.toString());
                    System.out.println(resultado.getInt("cod_equipo"));
                    crearObjeto();
                    listaEquipos.add(equipo);
                } while (resultado.next());
            }


        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }catch (Exception e){System.out.println(e.getMessage());}

        return listaEquipos;
    }

    public static void crearObjeto(){
    try{
        equipo = new Equipo(); //Hay que iniciar aqui el objeto para que no se sobre escriba
        equipo.setId_equipo(resultado.getInt("cod_equipo"));
        System.out.println(equipo.getId_equipo());

        equipo.setNombre(resultado.getString("nombre"));
        System.out.println(equipo.getNombre());

        equipo.setNacionalidad(resultado.getString("nacionalidad"));
        System.out.println(equipo.getNacionalidad());

       Date dFecha = resultado.getDate("fecha_creacion");
        LocalDate ld = dFecha.toLocalDate();
        equipo.setFechaCreacion(ld);

        equipo.setTelefono(resultado.getString("telefono"));
        System.out.println(equipo.getTelefono());

        equipo.setMail(resultado.getString("mail"));
        System.out.println(equipo.getMail());

        // equipo.setFechaCreacion(resultado.getDate("fecha_creacion"));
        equipo.setEscudo(resultado.getString("escudo"));




    }catch (Exception e){
        System.out.println(e.getMessage());
    }



    }
}
