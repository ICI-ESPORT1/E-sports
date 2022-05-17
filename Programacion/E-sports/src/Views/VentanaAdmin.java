package Views;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdmin {
    private JMenuBar MenuOpcion;
    private JMenu Menu1_1;
    private JMenuBar Menu_Incripcion;
    private JMenu Menu2_2;
    private JMenu Menu3_3;
    private JButton Logo;
    private JMenuBar MenuEquipo;
    private JMenu Menu4_4;
    private JMenuBar MenuCalendario;
    private JMenu Menu5_5;
    private JPanel Ventana1;
    private JMenuItem Ins;
    private JButton bInscripcion;
    private JMenuItem jmiClasificacion;
    private JMenuItem jornada;
    private JMenuItem PartidosJugados;
    private JMenuItem verEquipo;
    private JMenuItem DarBaja;
    private JMenuItem DarAlta;
    private JMenuItem jmiJornadas;
    private JMenuItem jmiModificarPersonas;

    private JButton equiposButton;


    public VentanaAdmin() {


        Ins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.abrirFormularioEquipo();
            }
        });

        jmiClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.abrirClasificacion();
            }
        });

        verEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.visualizarEquipo();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jmiModificarPersonas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirModificarDatosPersona();
            }
        });

        DarBaja.addActionListener(new ActionListener() {

/*
        bInscripcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirBajasPersonas();
            }
        });

        DarAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirAltasPersonas();
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaAdmin().Ventana1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getVentana1() {return Ventana1;}


}
