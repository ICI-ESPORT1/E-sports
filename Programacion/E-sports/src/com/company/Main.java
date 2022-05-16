package com.company;

import Modelo.BD.BaseDatos;
import Views.*;
import Modelo.UML.Jugador;
import Views.FormularioInscripcion;
import Views.InscribirJugadores;
import Views.Login;
import Views.VentanaPrincipal;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static JFrame frame;
    static JDialog dialog;
    private static BaseDatos bd;

    public static void main(String[] args) {

        bd = new BaseDatos();
        bd.abrirConexion();

        //abrirVentanaPrincipal();
        //abrirFormularioEquipo();
        //mostrarVentanaInvitado();

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

    public static void abrirVentanaPrincipal() {
        frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().getVentana1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);
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

        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return nombreEncontrado;
    }

    public static void abrirInscripcionJugadores(){
        frame = new JFrame("InscribirJugadores");
        frame.setContentPane(new InscribirJugadores().getJpJugador());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}


