package com.company;

import Modelo.BD.BaseDatos;
import Views.*;
import Modelo.UML.Jugador;
import Modelo.BD.*;
import Modelo.UML.*;
import Views.Clasificacion;
import Views.FormularioInscripcion;
import Views.VentanaEscudos;
import Views.VentanaAdmin;
import Views.VisualizarEquipos;

import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.time.LocalDate;

public class Main {
    static JFrame frame;
    static JDialog dialog;
    private static BaseDatos bd;

    private static ArrayList<Jugador> listaJugadores= new ArrayList<>();

    private static Asistente asistente ;
    private static Entrenador entrenador;
    private static Dueno dueno ;
    private static Equipo equipo;
    private static Jornada jornada;
    private static Jugador jugador = new Jugador();
    private static Resultado resultado;
    private static Rol rol =new Rol();
    private static  String escudoEquipo;
    private static Frame Form;
    private static ArrayList<Equipo>listaEquipos;
    private static Equipo equipoConId=new Equipo();

    public static void main(String[] args) {

        bd = new BaseDatos();


        ventanaLogin();
        //abrirVentanaPrincipal();
        //abrirFormularioEquipo();
        //mostrarVentanaInvitado();
        listaEquipos = new ArrayList<>();
        //abrirVentanaPrincipal();


    }
    public static void ventanaLogin(){
        dialog = new Login();
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void CerrarVentana(){
        dialog.dispose();
    }
    public static void OcultarVentana(){
        dialog.setVisible(false);
    }

    /**
     * Este método contiene el Main de la ventana VisualizarEquipos
     * @throws Exception
     */
    public static void abrirVentanaVisualizarEquipos()throws Exception{
        VisualizarEquipos dialog = new VisualizarEquipos();
        dialog.pack();
        dialog.setVisible(true);
    }
    /**
     * Este método contiene el Main de la ventana ElegirEscudos
     * @throws Exception
     */
    public static void abrirVentanaEscudos()throws Exception{
        VentanaEscudos dialog = new VentanaEscudos();
        dialog.pack();
        dialog.setVisible(true);
    }
    /**
     * Este método contiene el Main de la ventana Principal para poder abrirla
     */
    public static void abrirVentanaPrincipal() {
        frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaAdmin().getVentana1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public static void mostrarVentanaInvitado()
    {
        frame = new JFrame("VentanaInvitado");
        frame.setContentPane(new VentanaInvitado().getVentanaInvitado());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(false);
        CerrarVentana();

    }



    public static ArrayList<Jugador>crearListaJugadores(){
        return null;
        /*Recibe los datos de un jugador y los mete en un arrayList*/
    }

    /**
     * Este método contiene el Main de la ventana para inscribir jugadores
     */
    public static void abrirFormularioEquipo() {
        frame = new JFrame("FormularioInscripcion");
        frame.setContentPane(new FormularioInscripcion().getJpPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Este metodo recibe el nombre del equipo para buscar en la base de datos si el nombre del
     * equipo ya existe.
     * @param nombreEquipo String
     * @return nombreEncontrado boolean
     */
    public static boolean buscarNombreEquipo(String nombreEquipo) {
        boolean nombreEncontrado = false;
        try {
            EquipoDAO.consultarEquipo(nombreEquipo);
            nombreEncontrado=true;

        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return nombreEncontrado;
    }

    public static void abrirClasificacion(){
        JFrame frame = new JFrame("Clasificacion");
        frame.setContentPane(new Clasificacion().getpClasificacion());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void abrirJornada(){
        JFrame frame = new JFrame("Jornadas");
        frame.setContentPane(new Jornadas().getJpJornadas());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



    ////////////////////////////////////// Metodos para la tabla asistente ////////////////////////////////////
    public static void tenDatosAsistente (String dni, String n, String d ,String t, Float s)throws Exception{
        asistente = new Asistente(dni,n,d,t,s);
        System.out.println(asistente.getNombre());
        altaAsistente(asistente);
      //  equipo.setAsistente(asistente);
    }
    /**
     * Metodo que llama a altaAsistente para hacer un insert en la base de datos
     * @param asistente
     * @param
     * @throws Exception
     */
    public static void altaAsistente(Asistente asistente)throws Exception{
       // asistente.setEquipo(e);

        AsistenteDAO.altaAsistente(asistente);
    }

    /**
     * Metodo que llama a bajaAsistente para hacer un delete en la base de datos
     * @param dni
     * @param n
     * @param e
     * @param t
     * @param s
     * @throws Exception
     */
    public static void bajaAsistente(String dni, String n, Equipo e,String t,String d, Float s)throws Exception{
        asistente = new Asistente(dni,n,t,d,s);
        listaEquipos.add(equipo);

        AsistenteDAO.bajaAsistente(asistente);

    }


  /*  public static void cambioEquipoAsistente(String dni, String n, String l, Equipo e,String t, Float s, int idNuevoEquipo, String m)throws Exception{
        asistente = new Asistente(dni,n,l,t,m, equipo,s);
        listaEquipos.add(equipo);}

  /*  public static void cambioEquipoAsistente(String dni, String n, String l, Equipo e,String t, Float s, int idNuevoEquipo, String m)throws Exception{
        asistente = new Asistente(dni,n,l,t,m, equipo,s);
        listaEquipos.add(equipo);

        AsistenteDAO.cambioEquipoAsistente(asistente,idNuevoEquipo);

    }*//*ESTO ESTA COMENTADO PORQUE EL ASISTENTE NO TIENE ID EQUIPO*/

    /**
     * Metodo que llama a consultarAsistente para hacer una select en la base de datos
     * @param dni
     * @return
     * @throws Exception
     */
    public static Asistente consultarAsistente(String dni)throws Exception{

      return asistente=  AsistenteDAO.consultarAsistente(dni);

    }

    ////////////////////////////////////// Metodos para la tabla Entrenador ////////////////////////////////////
    public static void tenDatosEntrenador(String dni,String n,String t,String d, Float s)throws Exception{
        equipoConId = EquipoDAO.consultarEquipo(equipo.getNombre());
        equipo.setId_equipo(equipoConId.getId_equipo());
        entrenador = new Entrenador(dni,n,t,d,equipo,s);
        altaEntrenador(entrenador);

    }
    /**
     * Metodo que llama a altaEntrenador para hacer un insert en la base de datos
     * @param entrenador
     * @throws Exception
     */
    public static void altaEntrenador(Entrenador entrenador)throws Exception{

        EntrenadorDAO.altaEntrenador(entrenador);

    }

    /**
     * Metodo que llama a bajaEntrenador para hacer un delete en la base de datos
     * @param dni
     * @param n
     * @param d
     * @param e
     * @param t
     * @param s
     * @throws Exception
     */
    public static void bajaEntrenador(String dni, String n, String d, Equipo e,String t, Float s)throws Exception{
        entrenador = new Entrenador(dni,n,t,d,equipo,s);
        listaEquipos.add(equipo);

        EntrenadorDAO.bajaEntrenador(entrenador);

    }

    /**
     * Metodo que llama a cambioEquipoEntrenador para hacer un update en la base de datos
     * @param dni
     * @param n
     * @param d
     * @param e
     * @param t
     * @param s
     * @param idNuevoEquipo
     * @throws Exception
     */
    public static void cambioEquipoEntrenador(String dni, String n, String d, Equipo e,String t, Float s, int idNuevoEquipo)throws Exception{
        entrenador = new Entrenador(dni,n,t,d,equipo,s);
        listaEquipos.add(equipo);

        EntrenadorDAO.cambioEquipoEntrenador(entrenador,idNuevoEquipo);

    }

    /**
     * Metodo que llama a consultarEntrenador para hacer una select en la base de datos
     * @param dni
     * @return
     * @throws Exception
     */
    public static Entrenador consultarEntrenador(String dni)throws Exception{


      return entrenador=  EntrenadorDAO.consultarEntrenador(dni);

    }

    ////////////////////////////////////// Metodos para la tabla Dueno ////////////////////////////////////
    public static void tenDatosDueno(String dni, String n, String d, String t)throws Exception{
        dueno = new Dueno(dni,n,t,d,equipo);
        altaDueno();
    }
    /**
     * Metodo que llama a altaDueno para hacer un insert en la base de datos
     * @throws Exception
     */
    public static void altaDueno()throws Exception{

        DuenoDAO.altaDueno(dueno);

    }

    /**
     * Metodo que llama a bajaDueno para hacer un delete en la base de datos
     * @param dni
     * @param n
     * @param d
     * @param e
     * @param t
     * @throws Exception
     */
    public static void bajaDueno(String dni, String n, String d, Equipo e,String t)throws Exception{
        dueno = new Dueno(dni,n,t,d,equipo);
        listaEquipos.add(equipo);

        DuenoDAO.bajaDueno(dueno);

    }

    /**
     * Metodo que llama a cambioEquipoDueno para hacer un cambio de equipo
     * @param dni
     * @param n
     * @param d
     * @param e
     * @param t
     * @param idEquipoNuevo
     * @throws Exception
     */
    public static void cambioEquipoDueno(String dni, String n, String d, Equipo e,String t, int idEquipoNuevo)throws Exception{
        dueno.setDni(dni);
        dueno.setNombre(n);
        dueno.setLocalidad(d);
        dueno.setEquipo(e);
        dueno.setTelefono(t);

        DuenoDAO.cambioEquipoDueno(dueno,idEquipoNuevo);

    }

    /**
     * Metodo que llama a consultarDueno para hacer una select en la base de datos
     * @param dni
     * @return
     * @throws Exception
     */
    public static Dueno consultarDueno(String dni)throws Exception{


       return dueno= DuenoDAO.consultarDueno(dni);

    }

    ////////////////////////////////////// Metodos para la tabla Equipo ////////////////////////////////////
    public static void tenEscudo(String escudo){
        escudoEquipo = escudo;
    }
    public static String dameEscudo(){
        return escudoEquipo;
    }
    public static void tenDatosEquipo(String n, String na, LocalDate f, String t,String m)throws Exception{
        /*Hay que crear un objeto equipo */
        escudoEquipo=dameEscudo();
        equipo = new Equipo(n,na, f, t, m, escudoEquipo);
        listaEquipos.add(equipo);

        /*equipo.setNombre(n);
        equipo.setNacionalidad(na);
        equipo.setFechaCreacion(f);
        equipo.setTelefono(t);
        equipo.setMail(m);
        equipo.setEscudo(e);*/
        altaEquipo(equipo,asistente);

    }

    /**
     * Metodo que llama a altaEquipo para hacer un insert en la base de datos
     * @param e
     * @param a
     * @throws Exception
     */

    public static void altaEquipo(Equipo e, Asistente a)throws Exception{

        Asistente asisConId;

        asisConId = AsistenteDAO.consultarAsistente(asistente.getDni());
        equipo.setAsistente(asisConId);
        EquipoDAO.altaEquipo(equipo);
        System.out.println(equipo.getNombre().toString());
        /* ESTA CONSULTA YA NO HACE FALTA PORQUE HE BORRADO EL OBJETO EQUIPO DE ASISTENTE
        equipoConId = EquipoDAO.consultarEquipo(equipo.getNombre());
        equipo.setId_equipo(equipoConId.getId_equipo());*/

    }

    /**
     * Metodo que llama a bajaEquipo para hacer un delete en la base de datos
     * @param n
     * @param na
     * @param f
     * @param t
     * @param m
     * @param e
     * @param a
     * @throws Exception
     */
    public static void bajaEquipo(String n, String na, LocalDate f, String t, String m, String e, Asistente a)throws Exception{
        equipo.setNombre(n);
        equipo.setNacionalidad(na);
        equipo.setFechaCreacion(f);
        equipo.setTelefono(t);
        equipo.setMail(m);
        equipo.setEscudo(e);
        equipo.setAsistente(a);

        EquipoDAO.bajaEquipo(equipo);

    }

    /**
     * Metodo que llama a cambiarNombreEquipo para hacer un cambio del nombre de equipo
     * @param n
     * @param na
     * @param f
     * @param t
     * @param m
     * @param e
     * @param a
     * @param nombreNuevo
     * @throws Exception
     */
    public static void cambiarNombreEquipo(String n, String na, LocalDate f, String t, String m, String e, Asistente a, String nombreNuevo)throws Exception{
        equipo.setNombre(n);
        equipo.setNacionalidad(na);
        equipo.setFechaCreacion(f);
        equipo.setTelefono(t);
        equipo.setMail(m);
        equipo.setEscudo(e);
        equipo.setAsistente(a);

        EquipoDAO.cambiarNombreEquipo(equipo,nombreNuevo);
    }

    /**
     * Metodo que llama a consultarEquipo para hacer una select en la base de datos
     * @param n
     * @return equipo
     * @throws Exception
     */
    public static Equipo consultarEquipo(String n)throws Exception{

     return equipo=EquipoDAO.consultarEquipo(n);

    }

    ////////////////////////////////////// Metodos para la tabla Jornada ////////////////////////////////////

    /**
     * Metodo que llama a altaJornada para hacer un insert en la base de datos
     * @param f
     * @param n
     * @param c
     * @throws Exception
     */
    public static void altaJornada(LocalDate f, int n, Calendario c)throws Exception{
        jornada.setFecha(f);
        jornada.setNumJornada(n);
        jornada.setCalendario(c);

        JornadaDAO.altaJornada(jornada);


    }

    /**
     * Metodo que llama a bajaJornada para hacer un delete en la base de datos
     * @param f
     * @param n
     * @param c
     * @throws Exception
     */
    public static void bajaJornada(LocalDate f, int n, Calendario c)throws Exception{
        jornada.setFecha(f);
        jornada.setNumJornada(n);
        jornada.setCalendario(c);


        JornadaDAO.bajaJornada(jornada);

    }

    ////////////////////////////////////// Metodos para la tabla Jugador ////////////////////////////////////

    /**
     * Recibe el nombre del rol del jugador y lo añade al objeto global rol
     * @param sRol
     * @throws Exception
     */
    public static void tenDatosRol(String sRol) throws Exception{
       rol= RolDAO.obtenerRol(sRol);

    }

    /**
     * Este método recibe ls datos de un jugador y crea el objeto jugador.
     * Utiliza el objeto rol y el objeto equipo que son globales y ya están creados
     *
     *
     * @throws Exception
     */
  /*  public static void tenDatosJugador()throws Exception{
        float sueldo = Float.parseFloat(su);
        jugador = new Jugador(dni,nombre,telefono,localidad,nick,rol,sueldo,equipo);
        listaJugadores.add(jugador);
        altaJugador(jugador);

    }*/
    public static void tenDatosJugador(String d, String n, String t, String di,String z,String su)throws Exception{

        float sueldo = Float.parseFloat(su);
        jugador = new Jugador(d,n,t,di,z,rol,sueldo,equipo);
        listaJugadores.add(jugador);
        altaJugador(jugador);
    }
    /**
     * Metodo que llama a altaJugador para hacer un insert en la base de datos
     * @throws Exception
     */
    public static void altaJugador(Jugador jugador)throws Exception{

       /* jugador.setDni(d);
        jugador.setNombre(n);
        jugador.setTelefono(t);
        jugador.setLocalidad(l);
        jugador.setEquipo(e);
        jugador.setNickname(ni);
        jugador.setSalario(s);
        jugador.setRol(r); */


        JugadorDAO.altaJugador(jugador);

    }

    /**
     * Metodo que llama a bajaJugador para hacer un delete en la base de datos
     * @param d
     * @param n
     * @param t
     * @param l
     * @param e
     * @param ni
     * @param s
     * @param r
     * @throws Exception
     */
    public static void bajaJugador(String d,String n,String t, String l, Equipo e, String ni, Float s, Rol r)throws Exception{
        jugador.setDni(d);
        jugador.setNombre(n);
        jugador.setTelefono(t);
        jugador.setLocalidad(l);
        jugador.setEquipo(e);
        jugador.setNickname(ni);
        jugador.setSalario(s);
        jugador.setRol(r);


        JugadorDAO.bajaJugador(jugador);

    }

    /**
     * Metodo que llama a cambiarEquipoJugador para hacer un update en la base de datos
     * @param d
     * @param n
     * @param t
     * @param l
     * @param e
     * @param ni
     * @param s
     * @param r
     * @param idEquipoNuevo
     * @throws Exception
     */
    public static void cambiarEquipoJugador(String d,String n,String t, String l, Equipo e, String ni, Float s, Rol r,int idEquipoNuevo)throws Exception{
        jugador.setDni(d);
        jugador.setNombre(n);
        jugador.setTelefono(t);
        jugador.setLocalidad(l);
        jugador.setEquipo(e);
        jugador.setNickname(ni);
        jugador.setSalario(s);
        jugador.setRol(r);


        JugadorDAO.cambiarEquipoJugador(jugador,idEquipoNuevo);

    }

    /**
     * Metodo que llama a consultarJugadoresEquipo para hacer una select en la base de datos
     * @param idE
     * @return listaJugadores
     * @throws Exception
     */
    public static ArrayList<Jugador> consultarJugadoresEquipo(int idE)throws Exception{
        listaJugadores=new ArrayList<>();

        return listaJugadores=JugadorDAO.consultarJugadoresEquipo(idE);

    }

    /**
     * Metodo que llama a consultarJugador para hacer una select en la base de datos
     * @param id
     * @return jugador
     * @throws Exception
     */
    public static Jugador consultarJugador(int id)throws Exception{

        return jugador=JugadorDAO.consultarJugador(id);

    }

    ////////////////////////////////////// Metodos para la tabla Resultado ////////////////////////////////////

    /**
     * Metodo que llama a obtenerClasificacion para que nos devuelva la clasificacion actual
     * @return resultado
     * @throws Exception
     */
    public static Resultado obtenerClasificacion()throws Exception{

        return resultado=ResultadoDAO.obtenerClasificacion();

    }

    /**
     * Metodo que llama a obtenerPartidosJornadas para que nos los partidos y sus resultados
     * @return resultado
     * @throws Exception
     */
    public static Resultado obtenerPartidosJornadas()throws Exception{

        return resultado=ResultadoDAO.obtenerPartidosJornadas();

    }

    public static Resultado obtenerPartidos()throws Exception{
        return resultado=ResultadoDAO.obtenerPartidos();
    }


}