package com.company;

import Modelo.BD.BaseDatos;
import Views.FormularioInscripcion;
import Views.InscribirJugadores;
import Views.VentanaPrincipal;

import javax.swing.*;

public class Main {
    private static BaseDatos bd;

    public static void main(String[] args) {
        bd = new BaseDatos();
        bd.abrirConexion();

        abrirFormularioEquipo();


    }

    public static void abrirFormularioEquipo() {
        JFrame frame = new JFrame("FormularioInscripcion");
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
        JFrame frame = new JFrame("InscribirJugadores");
        frame.setContentPane(new InscribirJugadores().getJpJugador());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void abrirVentanaPrincipal(){
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().getVentana1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


