package com.company;

import Modelo.BD.BaseDatos;
import Views.*;
import Modelo.UML.Jugador;
import Modelo.BD.*;
import Modelo.UML.*;
import Views.Clasificacion;
import Views.FormularioInscripcion;
import Views.VentanaEscudos;
import Views.VisualizarEquipos;
import com.sun.codemodel.internal.util.UnicodeEscapeWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;
import java.awt.*;
import java.time.LocalDate;

import static com.sun.tools.attach.VirtualMachine.list;

public class Main {
    static JFrame frame;
    static JDialog dialog;
    static JDialog dialogLogin;
    private static BaseDatos bd;

    private static ArrayList<Jugador> listaJugadores = new ArrayList<>();
    private static ArrayList<HashMap> listaEnfrentaminetos= new ArrayList<>();
    private static ArrayList<Equipo> enfrentamientos= new ArrayList<>();
    private static ArrayList<Jornada> listaJornadas= new ArrayList<>();

    private static Partido partido= new Partido();
    private static Calendario calendario= new Calendario();
    private static Asistente asistente;
    private static Entrenador entrenador;
    private static Dueno dueno;
    private static Equipo equipo = new Equipo();
    private static Jornada jornada = new Jornada();
    private static Jugador jugador = new Jugador();
    private static Resultado resultado;
    private static Rol rol = new Rol();
    private static String escudoEquipo;
    private static Frame Form;
    private static ArrayList<Equipo> listaEquipos = new ArrayList<>();
    private static Equipo equipoConId = new Equipo();
    private static ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();


    public static void main(String[] args) {
      /*  String sResultados = "";
        try {

            File file = new File("resultados.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            // GET DOCUMENT COGE AUTOMÁTICAMENTE EL nodo "ROOT" (RESUMEN RESULTADOS)
            System.out.println(document.getDocumentElement().getNodeName());
            sResultados = sResultados + (document.getDocumentElement().getNodeName() + "\n");
            // Primer nodo "JORNADAS"
            NodeList nListJornadas = document.getElementsByTagName("JORNADA");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nListJornadas.getLength(); temp++) {
                Node nJornada = nListJornadas.item(temp);
                Element eJornada = (Element) nJornada;
                System.out.println("Jornada : " + eJornada.getAttribute("num_jornada")); // Esto se pone porque tiene atributo
                sResultados = sResultados + "Jornada : " + (eJornada.getAttribute("num_jornada") + "\n");

                NodeList nListLista_Partidos = eJornada.getElementsByTagName("LISTA_PARTIDOS");
                for (int temp1 = 0; temp1 < nListLista_Partidos.getLength(); temp1++) {
                    Node nLista_Partidos = nListLista_Partidos.item(temp1);
                    Element eLista_Partidos = (Element) nLista_Partidos;

                    NodeList nListT_Partido = eLista_Partidos.getElementsByTagName("T_PARTIDO");
                    for (int temp2 = 0; temp2 < nListT_Partido.getLength(); temp2++) {
                        Node nT_Partido = nListT_Partido.item(temp2);
                        Element eT_Partido = (Element) nT_Partido;
                        System.out.println("Partido : " + eT_Partido.getAttribute("id_partido"));// Esto se pone porque tiene atributo
                        sResultados = sResultados + "Partido : " + (eT_Partido.getAttribute("id_partido") + "\n");

                        NodeList nListEquipos = eT_Partido.getElementsByTagName("EQUIPOS");
                        for (int temp3 = 0; temp3 < nListEquipos.getLength(); temp3++) {
                            Node nEquipos = nListEquipos.item(temp3);
                            Element eEquipos = (Element) nEquipos;

                            NodeList nListT_EQUIPO = eEquipos.getElementsByTagName("T_EQUIPO");
                            for(int temp4 = 0; temp4 < nListT_EQUIPO.getLength(); temp4++) {
                                Node nT_EQUIPO = nListT_EQUIPO.item(temp4);
                                Element eT_EQUIPO = (Element) nT_EQUIPO;
                                System.out.println("Equipo : " + eT_EQUIPO.getElementsByTagName("NOMBRE").item(0).getTextContent());// Esto se pone porque tiene atributo
                                sResultados = sResultados + (eT_EQUIPO.getElementsByTagName("NOMBRE").item(0).getTextContent() + "\n");
                                System.out.println("Resultado : " + eT_EQUIPO.getElementsByTagName("RESULTADO").item(0).getTextContent());// Esto se pone porque tiene atributo
                                sResultados = sResultados + (eT_EQUIPO.getElementsByTagName("RESULTADO").item(0).getTextContent() + "\n");
                            }
                        }
                    }
                }
                System.out.println("*****************************");
                sResultados = sResultados + ("*****************************\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

        bd = new BaseDatos();


        ventanaLogin();

        // BaseDatos.cerrarConexion();

    }

    public static void ventanaLogin() {
        dialogLogin = new Login();
        dialogLogin.pack();
        dialogLogin.setVisible(true);

    }

    //funcion cerrar ventana con frame
    public static void cerrarVentana() {
        frame.dispose();
    }

    //funcion cerrar ventana con dialog
    public static void CerrarVentana() {
        dialog.dispose();
    }

    public static void VentanaInvitado() {
        frame = new JFrame("VentanaInvitado");
        frame.setContentPane(new VentanaInvitado().getVentanaInvitado());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        dialogLogin.dispose();

    }


    /**
     * Este método contiene el Main de la ventana VisualizarEquipos
     *
     * @throws Exception
     */
    public static void visualizarEquipo() throws Exception {
        System.out.println("VISUALIZAR EQUIPO****");
        dialog = new VisualizarEquipos();
        dialog.pack();
        dialog.setVisible(true);
    }


    /**
     * Este método contiene el Main de la ventana ElegirEscudos
     *
     * @throws Exception
     */
    public static void abrirVentanaEscudos() throws Exception {
        dialog = new VentanaEscudos();
        dialog.pack();
        dialog.setVisible(true);
    }

    /**
     * Este método contiene el Main de la ventana Principal para poder abrirla
     */
    public static void abrirVentanaAdmin() {
        frame=new JFrame("VentanaAdmin");
        frame.setContentPane(new VentanaAdmin().getVentana1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Este método contiene el Main de la ventana Invitado para poder abrirla
     */
    public static void mostrarVentanaInvitado() {
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
    public static ArrayList<Jugador> crearListaJugadores() {
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
    public static void VentanaModificarEquipo(){
        VentanaModificarEquipo dialog = new VentanaModificarEquipo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    /**
     * Este metodo recibe el nombre del equipo para buscar en la base de datos si el nombre del
     * equipo ya existe.
     *
     * @param nombreEquipo String
     * @return nombreEncontrado boolean
     */
    public static boolean buscarNombreEquipo(String nombreEquipo) {
        boolean nombreEncontrado = false;
        try {
            EquipoDAO.consultarEquipo(nombreEquipo);
            nombreEncontrado = true;

        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return nombreEncontrado;
    }

    /**
     * Este método contiene el Main de la ventana clasificacion para poder abrirla
     */
    public static void abrirClasificacion() {
        frame = new JFrame("Clasificacion");
        frame.setContentPane(new Clasificacion().getpClasificacion());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void abrirJornada() {
        VentanaJornadas dialog = new VentanaJornadas();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public static void abrirUltimaJOrn() {
        JFrame frame = new JFrame("partidosJugados");
        frame.setContentPane(new ultimaJorn().getJpPartidos());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



    public static void abrirBajasPersonas() {
        frame = new JFrame("VentanaBajas");
        frame.setContentPane(new BajasPersonas().getBajas());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void abrirAltasPersonas() {
        frame = new JFrame("VentanaAltas");
        frame.setContentPane(new AltaPersonas().getAltas());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void abrirModificarDatosPersona() {
        JFrame frame = new JFrame("ModificarDatosPersona");
        frame.setContentPane(new ModificarDatosPersona().getJpModificarDatosPersona());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    ////////////////////////////////////// Metodos para la tabla asistente ////////////////////////////////////
    public static void tenDatosAsistente(String dni, String n, String t, String d, Float s) throws Exception {
        System.out.println("TEN DATOS ASISTENTE **********");
        asistente = new Asistente(dni, n, t, d, s);
        System.out.println(asistente.getNombre());
        altaAsistente(asistente);
        asistente = AsistenteDAO.consultarAsistente(dni); //Ya tengo el asistente con dni

        //equipo.setAsistente(asistente); el equipo es null porque todavia no hay equipo
    }

    /**
     * Metodo que llama a altaAsistente para hacer un insert en la base de datos
     *
     * @param asistente
     * @param
     * @throws Exception
     */
    public static void altaAsistente(Asistente asistente) throws Exception {
        System.out.println("ALTA ASISTENTE");
        // asistente.setEquipo(e);

        AsistenteDAO.altaAsistente(asistente);
    }

    /**
     * Metodo que llama a bajaAsistente para hacer un delete en la base de datos
     *
     * @param dni
     * @param n
     * @param e
     * @param t
     * @param s
     * @throws Exception
     */
    public static void bajaAsistente(String dni, String n, Equipo e, String t, String d, Float s) throws Exception {
        asistente = new Asistente(dni, n, t, d, s);
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
     *
     * @param dni
     * @return
     * @throws Exception
     */
    public static Asistente consultarAsistente(String dni) throws Exception {
        System.out.println("CONSULTAR ASISTENTE DNI");

        return asistente = AsistenteDAO.consultarAsistente(dni);

    }





    /////////////////////////////////Metodo Para la conexion con usuario y contraseña///////////////////////////
    public static void tomaDatosUsuario (String username, String password) throws Exception {
        username = username.toUpperCase();
        Usuario usuario = new Usuario(username,password);
        Usuario bd = new Usuario();
        bd = UsuarioDAO.tomaDatosUsuario(usuario);

        if (usuario.getPassword().equals(bd.getPassword())){
            Main.abrirVentanaAdmin();
            dialogLogin.dispose();
        }else {
            JOptionPane.showMessageDialog(null,"El Usuario o contraseña es incurrecto");
        }

    }


    ////////////////////////////////////// Metodos para la tabla Entrenador ////////////////////////////////////
    public static void tenDatosEntrenador(String dni, String n, String t, String d, Float s) throws Exception {
        System.out.println("TEN DATOS ENTRENADOR");
        ObtenerEquipoConId();
        equipo.setId_equipo(equipoConId.getId_equipo());
        entrenador = new Entrenador(dni, n, t, d, equipo, s);
        altaEntrenador(entrenador);

    }

    public static void ObtenerEquipoConId() throws Exception {
        System.out.println("OBTENER EQUIPO CON ID**********");
        equipoConId = EquipoDAO.consultarEquipo(equipo.getNombre());
    }

    /**
     * Metodo que llama a altaEntrenador para hacer un insert en la base de datos
     *
     * @param entrenador
     * @throws Exception
     */
    public static void altaEntrenador(Entrenador entrenador) throws Exception {
        System.out.println("ALTA ENTRENADOR**********");

        EntrenadorDAO.altaEntrenador(entrenador);

    }

    /**
     * Metodo que llama a bajaEntrenador para hacer un delete en la base de datos
     *
     * @param dni
     * @param n
     * @param d
     * @param e
     * @param t
     * @param s
     * @throws Exception
     */
    public static void bajaEntrenador(String dni, String n, String d, Equipo e, String t, Float s) throws Exception {
        entrenador = new Entrenador(dni, n, t, d, equipo, s);
        listaEquipos.add(equipo);

        EntrenadorDAO.bajaEntrenador(entrenador);

    }

    /**
     * Metodo que llama a cambioEquipoEntrenador para hacer un update en la base de datos
     *
     * @param dni
     * @param n
     * @param d
     * @param e
     * @param t
     * @param s
     * @param idNuevoEquipo
     * @throws Exception
     */
    public static void cambioEquipoEntrenador(String dni, String n, String d, Equipo e, String t, Float s, int idNuevoEquipo) throws Exception {
        entrenador = new Entrenador(dni, n, t, d, equipo, s);
        listaEquipos.add(equipo);

        EntrenadorDAO.cambioEquipoEntrenador(entrenador, idNuevoEquipo);

    }
    public static void dameListaEntrenadores(){
        listaEntrenadores = EntrenadorDAO.selectTodos();
    }
    public static void cambiarNombreEntrenador(String nNuevo,String dni){
        boolean nombreCambiado = false;
        int posicionentre =0;
        int i = 0;
        // Necesito un arraylist de entrenadores

        for(i=0; i<listaEntrenadores.size()&& !listaEntrenadores.get(i).getDni().equalsIgnoreCase(dni);i++){}
        posicionentre = i;
            if(i<listaEntrenadores.size()){
                //el entrenador existe
                nombreCambiado = EntrenadorDAO.cambiarNombreEntrenador(nNuevo,dni);
                if(nombreCambiado){
                    listaEntrenadores.get(posicionentre).setNombre(nNuevo);
                    JOptionPane.showMessageDialog(null, "El nombre del entrenador se ha cambiado por: "+ nNuevo );
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado el dni");
            }

    }
    public static void cambiarTelefonoEntrenador(String nTelf,String dni){

    }
    /**
     * Metodo que llama a consultarEntrenador para hacer una select en la base de datos
     *
     * @param dni
     * @return
     * @throws Exception
     */
    public static Entrenador consultarEntrenador(String dni) throws Exception {


        return entrenador = EntrenadorDAO.consultarEntrenador(dni);

    }

    ////////////////////////////////////// Metodos para la tabla Dueno ////////////////////////////////////
    public static void tenDatosDueno(String dni, String n, String d, String t) throws Exception {
        System.out.println("TEN DATOS DUENO*************");
        dueno = new Dueno(dni, n, t, d, equipo);
        altaDueno(dueno);
    }

    /**
     * Metodo que llama a altaDueno para hacer un insert en la base de datos
     *
     * @param dueno
     * @throws Exception
     * @param dueno
     */
    public static void altaDueno(Dueno dueno) throws Exception {
        System.out.println("ALTA DUENO **********");

        DuenoDAO.altaDueno(dueno);
        Main.dueno = DuenoDAO.consultarDueno(Main.dueno.getDni());
        Main.dueno.setEquipo(equipo);

    }

    /**
     * Metodo que llama a bajaDueno para hacer un delete en la base de datos
     *
     * @param dni
     * @param n
     * @param d
     * @param e
     * @param t
     * @throws Exception
     */
    public static void bajaDueno(String dni, String n, String d, Equipo e, String t) throws Exception {
        dueno = new Dueno(dni, n, t, d, equipo);
        listaEquipos.add(equipo);

        DuenoDAO.bajaDueno(dueno);

    }

    /**
     * Metodo que llama a cambioEquipoDueno para hacer un cambio de equipo
     *
     * @param dni
     * @param n
     * @param d
     * @param e
     * @param t
     * @param idEquipoNuevo
     * @throws Exception
     */
    public static void cambioEquipoDueno(String dni, String n, String d, Equipo e, String t, int idEquipoNuevo) throws Exception {
        dueno.setDni(dni);
        dueno.setNombre(n);
        dueno.setLocalidad(d);
        dueno.setEquipo(e);
        dueno.setTelefono(t);

        DuenoDAO.cambioEquipoDueno(dueno, idEquipoNuevo);

    }

    /**
     * Metodo que llama a consultarDueno para hacer una select en la base de datos
     *
     * @param dni
     * @return
     * @throws Exception
     */
    public static Dueno consultarDueno(String dni) throws Exception {
        System.out.println("CONSULTAR DUENO **********");

        return dueno = DuenoDAO.consultarDueno(dni);

    }

    ////////////////////////////////////// Metodos para la tabla Equipo ////////////////////////////////////
    public static void tenEscudo(String escudo) {
        System.out.println("TEN ESCUDO *******");
        escudoEquipo = escudo;
    }

    public static String dameEscudo() {
        System.out.println("DAME ESCUDO *************");

        return escudoEquipo;
    }

    public static void tenDatosEquipo(String n, String na, LocalDate f, String t, String m) throws Exception {
        System.out.println("TEN DATOS EQUIPO ***********");
        /*Hay que crear un objeto equipo */
        escudoEquipo = dameEscudo();
        equipo = new Equipo(n, na, f, t, m, escudoEquipo, asistente);


        /*equipo.setNombre(n);
        equipo.setNacionalidad(na);
        equipo.setFechaCreacion(f);
        equipo.setTelefono(t);
        equipo.setMail(m);
        equipo.setEscudo(e);*/
        altaEquipo(equipo, asistente);
        Equipo equipoConIDsinAsis = new Equipo();
        equipoConIDsinAsis = EquipoDAO.consultarEquipo(n);
        equipo.setId_equipo(equipoConIDsinAsis.getId_equipo());
        listaEquipos.add(equipo);
    }

    /**
     * Metodo que llama a altaEquipo para hacer un insert en la base de datos
     *
     * @param e
     * @param a
     * @throws Exception
     */

    public static void altaEquipo(Equipo e, Asistente a) throws Exception {
        System.out.println("ALTA EQUIPO ***********");
        Asistente asisConId;

        asisConId = AsistenteDAO.consultarAsistente(asistente.getDni());
        equipo.setAsistente(asisConId);
        EquipoDAO.altaEquipo(equipo, asisConId);
        System.out.println(equipo.getNombre().toString());
        /* ESTA CONSULTA YA NO HACE FALTA PORQUE HE BORRADO EL OBJETO EQUIPO DE ASISTENTE
        equipoConId = EquipoDAO.consultarEquipo(equipo.getNombre());
        equipo.setId_equipo(equipoConId.getId_equipo());*/

    }

    /**
     * Metodo que llama a bajaEquipo para hacer un delete en la base de datos
     *
     * @param n
     * @param na
     * @param f
     * @param t
     * @param m
     * @param e
     * @param a
     * @throws Exception
     */
    public static void bajaEquipo(String n, String na, LocalDate f, String t, String m, String e, Asistente a) throws Exception {
        equipo = new Equipo();
        equipo.setNombre(n);
        equipo.setNacionalidad(na);
        equipo.setFechaCreacion(f);
        equipo.setTelefono(t);
        equipo.setMail(m);
        equipo.setEscudo(e);
        equipo.setAsistente(a);

        boolean borrado = EquipoDAO.bajaEquipo(equipo);

    }

    /**
     * Metodo que llama a cambiarNombreEquipo para hacer un cambio del nombre de equipo
     *
     * @param nNuevo
     * @throws Exception
     */
    public static void cambiarNombreEquipo(String nNuevo, String nViejo) throws Exception {
        boolean nombreCambiado = false;
        int posicionNombreV =0;


        //busco el equipo en la posicion de la lista
        int i = 0;
        for(i = 0; i<listaEquipos.size()&& !listaEquipos.get(i).getNombre().equalsIgnoreCase(nNuevo); i++){}
            if(i< listaEquipos.size()){
                JOptionPane.showMessageDialog(null,"El nombre ya existe");
            }
            else{
               nombreCambiado = EquipoDAO.cambiarNombreEquipo(nNuevo,nViejo);
               if(nombreCambiado){

                   for(i = 0; i<listaEquipos.size()&& !listaEquipos.get(i).getNombre().equalsIgnoreCase(nViejo); i++){}
                     posicionNombreV = i;
                   listaEquipos.get(posicionNombreV).setNombre(nNuevo);
               }
                JOptionPane.showMessageDialog(null, "El nombre "+ nViejo + " se ha cambiado por: "+ nNuevo );
            }

    }
    public static void cambiarNacionalidadEquipo(String naNuevo,String naViejo,String nombreViejo)throws Exception{
        boolean nacCambiada =false;
        int posicionNacVieja =0;
        int i=0;
        nacCambiada = EquipoDAO.cambiarNacionalidadEquipo(naNuevo, naViejo);
        if(nacCambiada) {
            for (i = 0; i < listaEquipos.size() && !listaEquipos.get(i).getNombre().equalsIgnoreCase(nombreViejo); i++) {}
            posicionNacVieja = i;
            listaEquipos.get(posicionNacVieja).setNacionalidad(naNuevo);
            JOptionPane.showMessageDialog(null, "La nacionalidad "+ naViejo + " se ha cambiado por: "+ naNuevo );
        }


    }

    public static void cambiarFechaEquipo(LocalDate fechaNuevo,LocalDate fechaViejo,String nombreViejo)throws Exception{
        boolean fechaCambiada =false;
        int posicionNacVieja =0;
        int i=0;
        fechaCambiada = EquipoDAO.cambiarFechaEquipo(fechaNuevo, fechaViejo);
        if(fechaCambiada) {
            for (i = 0; i < listaEquipos.size() && !listaEquipos.get(i).getNombre().equalsIgnoreCase(nombreViejo); i++) {}
            posicionNacVieja = i;
            listaEquipos.get(posicionNacVieja).setFechaCreacion(fechaNuevo);
            JOptionPane.showMessageDialog(null, "La fecha de creacion se ha cambiado");
        }
    }
    public static void cambiarTelefonoEquipo(String telfNuevo,String telfViejo,String nombreViejo)throws Exception{
        boolean telfCambiada =false;
        int posicionNacVieja =0;
        int i=0;
        telfCambiada = EquipoDAO.cambiarTelefonoEquipo(telfNuevo, telfViejo);
        if(telfCambiada) {
            for (i = 0; i < listaEquipos.size() && !listaEquipos.get(i).getNombre().equalsIgnoreCase(nombreViejo); i++) {}
            posicionNacVieja = i;
            listaEquipos.get(posicionNacVieja).setTelefono(telfNuevo);
            JOptionPane.showMessageDialog(null, "El telefono "+ telfViejo + " se ha cambiado por: "+ telfNuevo);

        }
    }
    public static void cambiarMailEquipo(String mailNuevo, String mailViejo, String nombreViejo)throws Exception{
        boolean telfCambiada =false;
        int posicionNacVieja =0;
        int i=0;
        telfCambiada = EquipoDAO.cambiarMailEquipo(mailNuevo, mailViejo);
        if(telfCambiada) {
            for (i = 0; i < listaEquipos.size() && !listaEquipos.get(i).getNombre().equalsIgnoreCase(nombreViejo); i++) {}
            posicionNacVieja = i;
            listaEquipos.get(posicionNacVieja).setMail(mailNuevo);
            JOptionPane.showMessageDialog(null, "El telefono "+ mailViejo + " se ha cambiado por: "+ mailNuevo);
        }
    }

    /**
     * Metodo que llama a consultarEquipo para hacer una select en la base de datos
     *
     * @param n
     * @return equipo
     * @throws Exception
     */
    public static Equipo consultarEquipo(String n) throws Exception {

        return equipo = EquipoDAO.consultarEquipo(n);

    }

    public static void consultarEquipos() throws Exception {
        System.out.println("CONSULTAR EQUIPOS**********");
        listaEquipos = new ArrayList<>();
        listaEquipos = EquipoDAO.selectTodosLosEquipos();
    }
    public static ArrayList<String> dameNombresEquipos(){
        ArrayList<String> listaNombreEquipos = new ArrayList<>();
        try{
            for(int i=0;i<listaEquipos.size();i++){
                listaNombreEquipos.add(listaEquipos.get(i).getNombre());
            }

        }catch (Exception e){System.out.println(e.getMessage());}

        return listaNombreEquipos;
    }
    public static String dameNombreDelEquipo(int pos){
        String nombreEq ="";
        try{
            nombreEq = listaEquipos.get(pos).getNombre();

        }catch (Exception e){System.out.println(e.getMessage());}
        return nombreEq;
    }
    public static String dameNacionalidadDelEquipo(int pos){
        String nacionalidadEq ="";
        try{
            nacionalidadEq = listaEquipos.get(pos).getNacionalidad();

        }catch (Exception e){System.out.println(e.getMessage());}
        return nacionalidadEq;
    }
    public static LocalDate dameFechaDelEquipo(int pos){
        LocalDate fechaEq = null;
        try{
            fechaEq = listaEquipos.get(pos).getFechaCreacion();

        }catch (Exception e){System.out.println(e.getMessage());}
        return fechaEq;
    }
    public static String dameTelefonoDelEquipo(int pos){
        String telefonoEq ="";
        try{
            telefonoEq = listaEquipos.get(pos).getTelefono();

        }catch (Exception e){System.out.println(e.getMessage());}
        return telefonoEq;
    }
    public static String dameMailDelEquipo(int pos){
        String mailEq ="";
        try{
            mailEq = listaEquipos.get(pos).getMail();

        }catch (Exception e){System.out.println(e.getMessage());}
        return mailEq;
    }
    public static String dameStringEquipos() throws Exception {

        System.out.println("DAME STRING EQUIPOS***************");
        String infoEquipos = "";
        for (int i = 0; i < listaEquipos.size(); i++) {
            infoEquipos += listaEquipos.get(i).toString();
        }
        return infoEquipos;
    }

    ////////////////////////////////////// Metodos para la tabla Jornada ////////////////////////////////////
    public static String dameStringJornadas(){
        String Jornadas ="";

        return Jornadas;
    }
    /**
     * Metodo que llama a altaJornada para hacer un insert en la base de datos
     *
     * @param f
     * @param n
     * @param c
     * @throws Exception
     */
    public static void altaJornada(LocalDate f, int n, Calendario c) throws Exception {
        jornada.setFecha(f);
        jornada.setNumJornada(n);
        jornada.setCalendario(c);

        JornadaDAO.altaJornada(jornada);


    }

    /**
     * Metodo que llama a bajaJornada para hacer un delete en la base de datos
     *
     * @param f
     * @param n
     * @param c
     * @throws Exception
     */
    public static void bajaJornada(LocalDate f, int n, Calendario c) throws Exception {
        jornada.setFecha(f);
        jornada.setNumJornada(n);
        jornada.setCalendario(c);


        JornadaDAO.bajaJornada(jornada);

    }

    ////////////////////////////////////// Metodos para la tabla Jugador ////////////////////////////////////

    /**
     * Recibe el nombre del rol del jugador y lo añade al objeto global rol
     *
     * @param sRol
     * @throws Exception
     */
    public static void tenDatosRol(String sRol) throws Exception {
        System.out.println("TEN DATOS ROL");
        rol = RolDAO.obtenerRol(sRol);

    }

    /**
     * Este método recibe ls datos de un jugador y crea el objeto jugador.
     * Utiliza el objeto rol y el objeto equipo que son globales y ya están creados
     *
     * @throws Exception
     */
  /*  public static void tenDatosJugador()throws Exception{
        float sueldo = Float.parseFloat(su);
        jugador = new Jugador(dni,nombre,telefono,localidad,nick,rol,sueldo,equipo);
        listaJugadores.add(jugador);
        altaJugador(jugador);

    }*/
    public static void tenDatosJugador(String d, String n, String t, String di, String z, String su) throws Exception {
        System.out.println("TEN DATOS JUGADOR*************");
        float sueldo = Float.parseFloat(su);
        jugador = new Jugador(d, n, t, di, z, rol, sueldo, equipo);

        altaJugador(jugador);
        /*Necesito el id del jugador*/
        jugador = JugadorDAO.jugadorConId(jugador.getDni());
        listaJugadores.add(jugador);
        rol.setListaJugador(listaJugadores);
        equipo.setlistaJugadores(listaJugadores);
    }

    /**
     * Metodo que llama a altaJugador para hacer un insert en la base de datos
     *
     * @throws Exception
     */
    public static void altaJugador(Jugador jugador) throws Exception {
        System.out.println("ALTA JUGADOR************");
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
     *
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
    public static void bajaJugador(String d, String n, String t, String l, Equipo e, String ni, Float s, Rol r) throws Exception {
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
     *
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
    public static void cambiarEquipoJugador(String d, String n, String t, String l, Equipo e, String ni, Float s, Rol r, int idEquipoNuevo) throws Exception {
        jugador.setDni(d);
        jugador.setNombre(n);
        jugador.setTelefono(t);
        jugador.setLocalidad(l);
        jugador.setEquipo(e);
        jugador.setNickname(ni);
        jugador.setSalario(s);
        jugador.setRol(r);


        JugadorDAO.cambiarEquipoJugador(jugador, idEquipoNuevo);

    }

    /**
     * Metodo que llama a consultarJugadoresEquipo para hacer una select en la base de datos
     *
     * @param idE
     * @return listaJugadores
     * @throws Exception
     */
    public static ArrayList<Jugador> consultarJugadoresEquipo(int idE) throws Exception {
        System.out.println("CONSULTAR JUGADORES EQUIPO *****************");
        listaJugadores = new ArrayList<>();

        return listaJugadores = JugadorDAO.consultarJugadoresEquipo(idE);

    }

    /**
     * Metodo que llama a consultarJugador para hacer una select en la base de datos
     *
     * @param dni
     * @return jugador
     * @throws Exception
     */
    public static Jugador consultarJugador(String dni) throws Exception {
        System.out.println("CONSULTAR JUGADOR**************");
        boolean salir = false;
        int x;
        listaJugadores = JugadorDAO.consultarJugador();


        for (x = 0; x < listaJugadores.size() || salir; x++) {

            if (listaJugadores.get(x).getDni().equalsIgnoreCase(dni))
                salir = true;
        }

        return jugador = new Jugador(listaJugadores.get(x).getDni(), listaJugadores.get(x).getNombre(), listaJugadores.get(x).getTelefono(), listaJugadores.get(x).getDireccion(), listaJugadores.get(x).getNickname(), listaJugadores.get(x).getRol(), listaJugadores.get(x).getSalario(), listaJugadores.get(x).getEquipo());

    }

    public static void cambiarDatosJugador(String dni, String n, String t, String d, String nn, Float s, String r, String e) throws Exception {
        rol = RolDAO.obtenerRol(r);
        equipo = EquipoDAO.consultarEquipoID(e);
        jugador = new Jugador(dni, n, t, d, nn, rol, s, equipo);

        JugadorDAO.cambiarDatosJugador(jugador);
    }


    public static void cambiarNombreJugador(String nNuevo, String nViejo,String dni, int posEq){
        boolean nombreCambiado = false;
        int posicionNombreV =0;

        //busco al jugador en la posicion de la lista
        int i = 0;

            nombreCambiado = JugadorDAO.cambiarNombreJugador(nNuevo,nViejo);
            if(nombreCambiado){

                for(i = 0; i<listaJugadores.size()&& !listaJugadores.get(i).getNombre().equalsIgnoreCase(nViejo); i++){}
                posicionNombreV = i;
                listaJugadores.get(posicionNombreV).setNombre(nNuevo);
                listaEquipos.get(posEq).setlistaJugadores(listaJugadores);
            }
            JOptionPane.showMessageDialog(null, "El nombre "+ nViejo + " se ha cambiado por: "+ nNuevo );
        }

    public static void cambiarTelefonoJugador(String telfNuevo,String dni, int posEq){
        boolean nombreCambiado = false;
        int posicionNombreV = 0;


        //busco al jugador en la posicion de la lista
        int i = 0;

        nombreCambiado = JugadorDAO.cambiarTelefonoJugador(telfNuevo,dni);
        if(nombreCambiado){

            for(i = 0; i<listaJugadores.size()&& !listaJugadores.get(i).getDni().equalsIgnoreCase(dni); i++){}
            posicionNombreV = i;
            listaJugadores.get(posicionNombreV).setTelefono(telfNuevo);
            listaEquipos.get(posEq).setlistaJugadores(listaJugadores);
        }
        JOptionPane.showMessageDialog(null, "El telefono se ha cambiado por: " + telfNuevo );
    }
    public static void cambiarSalarioEquipo(String salarioNuevo,String dniJug ,String nombreViejo, int posEq){
        boolean salarioCambiado = false;
        int posicionNombreV =0;
        float fSalNuevo = Float.parseFloat(salarioNuevo);

        int i = 0;

        salarioCambiado = JugadorDAO.cambiarSalarioJugador(fSalNuevo,dniJug);
        if(salarioCambiado){
            //busco al jugador en la posicion de la lista
            for(i = 0; i<listaJugadores.size()&& !listaJugadores.get(i).getNombre().equalsIgnoreCase(nombreViejo); i++){}
            posicionNombreV = i;
            listaJugadores.get(posicionNombreV).setSalario(fSalNuevo);
            listaEquipos.get(posEq).setlistaJugadores(listaJugadores);
        }
        JOptionPane.showMessageDialog(null, "El salario es ahora de: "+ salarioNuevo);
    }


    public static void sacaListaDeJugadores(int pos){
        try{
            String nombreEquipo ="";
            listaJugadores = new ArrayList<>();
            nombreEquipo = listaEquipos.get(pos).getNombre();
            int idEq = listaEquipos.get(pos).getId_equipo();
            listaJugadores = JugadorDAO.consultarJugadoresEquipo(idEq);  //La lista de jugadores del equipo seleccionado

        }catch (Exception e){System.out.println(e.getMessage());}
    }
    public static String dameNombreDelJugador(String dniPersona){
        String nombreJugador="";
        int i=0;
        int pos=0;
        int idEq = listaEquipos.get(pos).getId_equipo();

        for (i=0; i<listaJugadores.size()&& !listaJugadores.get(i).getDni().equalsIgnoreCase(dniPersona);i++){}
        if(i<listaJugadores.size()){
            pos = i;
            nombreJugador = listaJugadores.get(pos).getNombre();
        }
        else{
            JOptionPane.showMessageDialog(null,"El dni no coincide con ningun jugador");
        }
        return nombreJugador;
    }
    public static String dameTelefonoDelJugador(String dniPersona){
        String telefono ="";
        int i=0;
        int pos=0;
        try{
            for (i=0; i<listaJugadores.size()&& !listaJugadores.get(i).getDni().equalsIgnoreCase(dniPersona);i++){}
            if(i<listaJugadores.size()){
                pos = i;
                telefono = listaJugadores.get(pos).getTelefono();
            }else{
                JOptionPane.showMessageDialog(null,"El dni no coincide con ningun jugador");
            }

        }catch (Exception e){System.out.println(e.getMessage());}
        return telefono;
    }
    public static String dameSalarioDelJugador(String dniPersona){
        String salario ="";
        int i=0;
        int pos=0;
        try{
            for (i=0; i<listaJugadores.size()&& !listaJugadores.get(i).getDni().equalsIgnoreCase(dniPersona);i++){}
            if(i<listaJugadores.size()){
                pos = i;
                salario = String.valueOf(listaJugadores.get(pos).getSalario());
            }else{
                JOptionPane.showMessageDialog(null,"El dni no coincide con ningun jugador");
            }
        }catch (Exception e){System.out.println(e.getMessage());}
        return salario;

    }


    ////////////////////////////////////// Metodos para la tabla Resultado ////////////////////////////////////

    public static String consultarJornadas(){

        String sResultados = "";
        try {

            File file = new File("resultados.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            // GET DOCUMENT COGE AUTOMÁTICAMENTE EL nodo "ROOT" (RESUMEN RESULTADOS)
            System.out.println(document.getDocumentElement().getNodeName());
            sResultados = sResultados + (document.getDocumentElement().getNodeName() + "\n");
            // Primer nodo "JORNADAS"
            NodeList nListJornadas = document.getElementsByTagName("JORNADA");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nListJornadas.getLength(); temp++) {
                Node nJornada = nListJornadas.item(temp);
                Element eJornada = (Element) nJornada;
                System.out.println("Jornada : " + eJornada.getAttribute("num_jornada")); // Esto se pone porque tiene atributo
                sResultados = sResultados + "Jornada : " + (eJornada.getAttribute("num_jornada") + "\n");

                NodeList nListLista_Partidos = eJornada.getElementsByTagName("LISTA_PARTIDOS");
                for (int temp1 = 0; temp1 < nListLista_Partidos.getLength(); temp1++) {
                    Node nLista_Partidos = nListLista_Partidos.item(temp1);
                    Element eLista_Partidos = (Element) nLista_Partidos;

                    NodeList nListT_Partido = eLista_Partidos.getElementsByTagName("T_PARTIDO");
                    for (int temp2 = 0; temp2 < nListT_Partido.getLength(); temp2++) {
                        Node nT_Partido = nListT_Partido.item(temp2);
                        Element eT_Partido = (Element) nT_Partido;
                        System.out.println("Partido : " + eT_Partido.getAttribute("id_partido"));// Esto se pone porque tiene atributo
                        sResultados = sResultados + "Partido : " + (eT_Partido.getAttribute("id_partido") + "\n");

                        NodeList nListEquipos = eT_Partido.getElementsByTagName("EQUIPOS");
                        for (int temp3 = 0; temp3 < nListEquipos.getLength(); temp3++) {
                            Node nEquipos = nListEquipos.item(temp3);
                            Element eEquipos = (Element) nEquipos;

                            NodeList nListT_EQUIPO = eEquipos.getElementsByTagName("T_EQUIPO");
                            for(int temp4 = 0; temp4 < nListT_EQUIPO.getLength(); temp4++) {
                                Node nT_EQUIPO = nListT_EQUIPO.item(temp4);
                                Element eT_EQUIPO = (Element) nT_EQUIPO;
                                System.out.println("Equipo : " + eT_EQUIPO.getElementsByTagName("NOMBRE").item(0).getTextContent());// Esto se pone porque tiene atributo
                                sResultados = sResultados + (eT_EQUIPO.getElementsByTagName("NOMBRE").item(0).getTextContent() + "\n");
                                System.out.println("Resultado : " + eT_EQUIPO.getElementsByTagName("RESULTADO").item(0).getTextContent());// Esto se pone porque tiene atributo
                                sResultados = sResultados + (eT_EQUIPO.getElementsByTagName("RESULTADO").item(0).getTextContent() + "\n");
                            }
                        }
                    }
                }
                System.out.println("*****************************");
                sResultados = sResultados + ("*****************************\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sResultados;
    }

    public static String consultarUltimaJonr(){

        String sUltimaJornada = "";
        try {

            File file = new File("ultimaJorn.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            // GET DOCUMENT COGE AUTOMÁTICAMENTE EL nodo "ROOT" (RESUMEN ULTIMAJORN)
            System.out.println(document.getDocumentElement().getNodeName());
            sUltimaJornada = sUltimaJornada + (document.getDocumentElement().getNodeName() + "\n");
            // Primer nodo "JORNADA"
            NodeList nListJornada = document.getElementsByTagName("JORNADA");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nListJornada.getLength(); temp++) {
                Node nJornada = nListJornada.item(temp);
                Element eJornada = (Element) nJornada;
                System.out.println("Jornada : " + eJornada.getAttribute("num_jornada")); // Esto se pone porque tiene atributo
                sUltimaJornada = sUltimaJornada + "Jornada : " + (eJornada.getAttribute("num_jornada") + "\n");

                NodeList nListPartidos = eJornada.getElementsByTagName("PARTIDOS");
                for (int temp1 = 0; temp1 < nListPartidos.getLength(); temp1++) {
                    Node nPartidos = nListPartidos.item(temp1);
                    Element ePartidos = (Element) nPartidos;

                    NodeList nListPartido_TI = ePartidos.getElementsByTagName("PARTIDO_TI");
                    for (int temp2 = 0; temp2 < nListPartido_TI.getLength(); temp2++) {
                        Node nPartido_TI = nListPartido_TI.item(temp2);
                        Element ePartido_TI = (Element) nPartido_TI;
                        System.out.println("Partido : " + ePartido_TI.getAttribute("id_partido") + "   Turno : " + ePartido_TI.getAttribute("turno"));// Esto se pone porque tiene atributo
                        sUltimaJornada = sUltimaJornada + "Partido : " + ePartido_TI.getAttribute("id_partido") + "   Turno : " + (ePartido_TI.getAttribute("turno") + "\n");

                        NodeList nListEquipos = ePartido_TI.getElementsByTagName("EQUIPOS");
                        for (int temp3 = 0; temp3 < nListEquipos.getLength(); temp3++) {
                            Node nEquipos = nListEquipos.item(temp3);
                            Element eEquipos = (Element) nEquipos;

                            NodeList nListEQUIPO_TIP = eEquipos.getElementsByTagName("EQUIPO_TIP");
                            for(int temp4 = 0; temp4 < nListEQUIPO_TIP.getLength(); temp4++) {
                                Node nEQUIPO_TIP = nListEQUIPO_TIP.item(temp4);
                                Element eEQUIPO_TIP = (Element) nEQUIPO_TIP;
                                System.out.println("\nCod_Equipo : " + eEQUIPO_TIP.getAttribute("cod_Equipo"));// Esto se pone porque tiene atributo
                                sUltimaJornada = sUltimaJornada + "EQUIPO : " + (eEQUIPO_TIP.getAttribute("id_partido") + "\n");
                                System.out.println("Equipo : " + eEQUIPO_TIP.getElementsByTagName("NOMBRE").item(0).getTextContent());// Esto se pone porque tiene atributo
                                sUltimaJornada = sUltimaJornada + (eEQUIPO_TIP.getElementsByTagName("NOMBRE").item(0).getTextContent() + "\n");
                                System.out.println("Resultado : " + eEQUIPO_TIP.getElementsByTagName("RESULTADO").item(0).getTextContent());// Esto se pone porque tiene atributo
                                sUltimaJornada = sUltimaJornada + (eEQUIPO_TIP.getElementsByTagName("RESULTADO").item(0).getTextContent() + "\n");
                            }
                        }
                    }
                }
                System.out.println("*****************************");
                sUltimaJornada = sUltimaJornada + ("*****************************\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return  sUltimaJornada;

    }

    /**
     * Metodo que llama a obtenerClasificacion para que nos devuelva la clasificacion actual
     *
     * @return resultado
     * @throws Exception
     */
    public static Resultado obtenerClasificacion() throws Exception {

        return resultado = ResultadoDAO.obtenerClasificacion();

    }

    /**
     * Metodo que llama a obtenerPartidosJornadas para que nos los partidos y sus resultados
     *
     * @return resultado
     * @throws Exception
     */
    public static Resultado obtenerPartidosJornadas() throws Exception {

        return resultado = ResultadoDAO.obtenerPartidosJornadas();

    }

    public static Resultado obtenerPartidos() throws Exception {
        return resultado = ResultadoDAO.obtenerPartidos();
    }
/////////////////////////////////RESULTADOS/////////////////////////////////////////////////////
    public static void tomaResultado(int idEq1,int res1,int idEq2,int res2){

     ResultadoDAO.insertResultado(idEq1,res1);
     ResultadoDAO.insertResultado(idEq2,res2);
    }

    public static boolean generarJornadas(){
        Integer semana=1;
        BaseDatos.abrirConexion();
        listaEquipos=EquipoDAO.selectTodosLosEquipos();
        calendario=CalendarioDAO.buscarCalendario();
        try {
            if (!CalendarioDAO.buscarCalendarioBoolean()){
                System.out.println("no existe el calendario");
            }
            LocalDate ldFecha = LocalDate.now().plusDays(7);
            for (int i = 0; i < listaEquipos.size()-1 ; i++) {
                jornada = new Jornada();
                jornada.setFecha(ldFecha);
                jornada.setCalendario(calendario);
                jornada.setNumSemana(semana.toString());
                JornadaDAO.altaJornada(jornada);
                ldFecha = ldFecha.plusDays(7);
                System.out.println("+1");
                listaJornadas.add(jornada);
                semana=semana+1;
            }
            listaJornadas=new ArrayList<>();

            listaJornadas=JornadaDAO.selectTodos();

            for (int j = 1; j < listaJornadas.size(); j++) {
                jornada=listaJornadas.get(j);
                for (int p = 0; p < listaEquipos.size()/2 ; p++) {

                    Random randNum = new Random();
                    int turno = randNum.nextInt(2) + 1;
                    if (turno == 1)
                        partido.setTurno("Mañana");
                    if (turno == 2)
                        partido.setTurno("Tarde");
                    partido.setJornada(jornada);
                    generarEnfrentamientos();
                    partido.setListaEquipos(enfrentamientos);
                    System.out.println(partido.getListaEquipos());
                    PartidoDAO.altaPartido(partido);
                }
            }


            BaseDatos.cerrarConexion();
        }
        catch (Exception e){
            System.out.println(e.getClass());
        }

        return true;

    }

    public static void generarEnfrentamientos() {
        try {
            listaEquipos = EquipoDAO.selectTodosLosEquipos();
            int nPartidos = listaEquipos.size() / 2;

            for (int i = 0; i < listaEquipos.size()-1; i++) {
                HashMap<Integer, Integer> retorno =   generarPartidos(listaEquipos.size());
                System.out.println(retorno.toString().indexOf(1));
                System.out.println("");
            }


            //     ResultadoDAO.altaResultado(equipo1, numPartido);

        } catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    public static HashMap<Integer, Integer> generarPartidos (int cantPartidos) {
        HashMap<Integer, Integer> retorno = new HashMap<Integer, Integer>();
        Random randNum = new Random();
        int eq1 = 0;



        Set<Integer> set = new LinkedHashSet<Integer>();
        Set<Integer> set1 = new LinkedHashSet<Integer>();
        while (set.size() <= cantPartidos / 2 - 1) {
            set.add(randNum.nextInt(cantPartidos) + 1);
        }
        while (set1.size() <= cantPartidos / 2 - 1) {
            eq1 = randNum.nextInt(cantPartidos) + 1;
            if (!set1.contains(eq1) && !set.contains(eq1)) set1.add(eq1);
        }
        Iterator<Integer> it = set.iterator();
        Iterator<Integer> it1 = set1.iterator();

        for (int i = 0; i < cantPartidos / 2; i++) {
            retorno.put(it.next(), it1.next());
        }
        System.out.println(retorno.toString());


        return retorno;
    }


}