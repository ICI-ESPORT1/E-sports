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

    private static ArrayList<Jugador> listaJugadores;

    private static Asistente asistente ;
    private static Entrenador entrenador;
    private static Dueno dueno ;
    private static Equipo equipo;
    private static Jornada jornada;
    private static Jugador jugador = new Jugador();
    private static Resultado resultado;
    private static Rol rol ;
    private static  String escudoEquipo;
    private static Frame Form;
    private static ArrayList<Equipo>listaEquipos;

    public static void main(String[] args) {

        bd = new BaseDatos();
        bd.abrirConexion();

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


    //funcion cerrar ventana con frame
    public static void cerrarVentana(){
        frame.dispose();
    }

    //funcion cerrar ventana con dialog
    public static void CerrarVentana(){
        dialog.dispose();
    }

    public static void VentanaInvitado(){
        frame = new JFrame("VentanaInvitado");
        frame.setContentPane(new VentanaInvitado().getVentanaInvitado());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    /**
     * Este método contiene el Main de la ventana VisualizarEquipos
     * @throws Exception
     */
        public static void visualizarEquipo()throws Exception{
        dialog = new VisualizarEquipos();
        dialog.pack();
        dialog.setVisible(true);
    }


    /**
     * Este método contiene el Main de la ventana ElegirEscudos
     * @throws Exception
     */
    public static void abrirVentanaEscudos()throws Exception{
        dialog = new VentanaEscudos();
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

    /**
     * Este método contiene el Main de la ventana Invitado para poder abrirla
     */
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
    /**
     * Este método contiene el Main de la ventana para inscribir jugadores
     */
    public static ArrayList<Jugador>crearListaJugadores(){
        return null;
        /*Recibe los datos de un jugador y los mete en un arrayList*/
    }

    /**
     * Este método contiene el Main de la ventana Formulario Incripcion para poder abrirla
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

    /**
     * Este método contiene el Main de la ventana clasificacion para poder abrirla
     */
    public static void abrirClasificacion(){
        frame = new JFrame("Clasificacion");
        frame.setContentPane(new Clasificacion().getpClasificacion());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void abrirBajasPersonas(){
        frame = new JFrame("VentanaBajas");
        frame.setContentPane(new BajasPersonas().getBajas());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void abrirAltasPersonas(){
        frame = new JFrame("VentanaAltas");
        frame.setContentPane(new AltaPersonas().getAltas());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



    ////////////////////////////////////// Metodos para la tabla asistente ////////////////////////////////////
    public static void tenDatosAsistente(String dni, String n, String l ,String t, Float s, String m){
        asistente = new Asistente(dni,n,l,t,m, equipo,s);
        equipo.setAsistente(asistente);
    }
    /**
     * Metodo que llama a altaAsistente para hacer un insert en la base de datos
     * @param asistente
     * @param e
     * @throws Exception
     */

    public static void altaAsistente(Asistente asistente, Equipo e)throws Exception{
        asistente.setEquipo(e);
        AsistenteDAO.altaAsistente(asistente);
    }

    /**
     * Metodo que llama a bajaAsistente para hacer un delete en la base de datos
     * @param dni
     * @param n
     * @param l
     * @param e
     * @param t
     * @param s
     * @throws Exception
     */
    public static void bajaAsistente(String dni, String n, String l, Equipo e,String t, Float s, String m)throws Exception{
        asistente = new Asistente(dni,n,l,t,m, equipo,s);
        listaEquipos.add(equipo);
        AsistenteDAO.bajaAsistente(asistente);

    }



    /**
     * Metodo que llama a cambioEquipoAsistente para hacer un update en la base de datos
     * @param dni
     * @param n
     * @param l
     * @param e
     * @param t
     * @param s
     * @param idNuevoEquipo
     * @throws Exception
     */
    public static void cambioEquipoAsistente(String dni, String n, String l, Equipo e,String t, Float s, int idNuevoEquipo, String m)throws Exception{
        asistente = new Asistente(dni,n,l,t,m, equipo,s);
        listaEquipos.add(equipo);

        AsistenteDAO.cambioEquipoAsistente(asistente,idNuevoEquipo);

    }

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
    public static void tenDatosEntrenador(String dni,String n,String l,String t, Float s, String m){
        entrenador = new Entrenador(dni,n,t,m,l, equipo,s);
        equipo.setEntrenador(entrenador);

    }
    /**
     * Metodo que llama a altaEntrenador para hacer un insert en la base de datos
     * @param entrenador
     * @param e
     * @throws Exception
     */
    public static void altaEntrenador(Entrenador entrenador,Equipo e)throws Exception{

        entrenador.setEquipo(e);
        EntrenadorDAO.altaEntrenador(entrenador);

    }

    /**
     * Metodo que llama a bajaEntrenador para hacer un delete en la base de datos
     * @param dni
     * @param n
     * @param l
     * @param e
     * @param t
     * @param s
     * @throws Exception
     */
    public static void bajaEntrenador(String dni, String n, String l, Equipo e,String t, Float s, String m)throws Exception{
        entrenador = new Entrenador(dni,n,t,m,l, equipo,s);
        listaEquipos.add(equipo);

        EntrenadorDAO.bajaEntrenador(entrenador);

    }

    /**
     * Metodo que llama a cambioEquipoEntrenador para hacer un update en la base de datos
     * @param dni
     * @param n
     * @param l
     * @param e
     * @param t
     * @param s
     * @param idNuevoEquipo
     * @throws Exception
     */
    public static void cambioEquipoEntrenador(String dni, String n, String l, Equipo e,String t, Float s, int idNuevoEquipo, String m)throws Exception{
        entrenador = new Entrenador(dni,n,t,m,l, equipo,s);
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
    public static void tenDatosDueno(String dni, String n, String l,String t,String m){
        dueno = new Dueno(dni,n,t,m,l, equipo);
        equipo.setDueno(dueno);
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
     * @param l
     * @param e
     * @param t
     * @throws Exception
     */
    public static void bajaDueno(String dni, String n, String l, Equipo e,String t,String m)throws Exception{
        dueno = new Dueno(dni,n,t,m,l, equipo);
        listaEquipos.add(equipo);

        DuenoDAO.bajaDueno(dueno);

    }

    /**
     * Metodo que llama a cambioEquipoDueno para hacer un cambio de equipo
     * @param dni
     * @param n
     * @param l
     * @param e
     * @param t
     * @param idEquipoNuevo
     * @throws Exception
     */
    public static void cambioEquipoDueno(String dni, String n, String l, Equipo e,String t, int idEquipoNuevo)throws Exception{
        dueno.setDni(dni);
        dueno.setNombre(n);
        dueno.setLocalidad(l);
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
    public static void tenDatosEquipo(String n, String na, LocalDate f, String t, String m){
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
    }

    /**
     * Metodo que llama a altaEquipo para hacer un insert en la base de datos
     * @param e
     * @param a
     * @throws Exception
     */

    public static void altaEquipo(Equipo e, Asistente a)throws Exception{

        equipo.setAsistente(a);

        EquipoDAO.altaEquipo(equipo);

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
        rol.setNombre(sRol);
    }

    /**
     * Este método recibe ls datos de un jugador y crea el objeto jugador.
     * Utiliza el objeto rol y el objeto equipo que son globales y ya están creados
     * @param dni
     * @param nombre
     * @param telefono
     * @param mail
     * @param localidad
     * @param nick
     * @param su
     * @throws Exception
     */
    public static void tenDatosJugador (String dni, String nombre, String telefono,String mail, String localidad, String nick,String su)throws Exception{
        float sueldo = Float.parseFloat(su);
        jugador = new Jugador(dni,nombre,telefono,mail,localidad,nick,sueldo,rol,equipo);
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


}