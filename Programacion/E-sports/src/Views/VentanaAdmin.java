package Views;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @Author Iñigo
 * @Version 1.0
 */
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
    private JMenuItem jmiModificarEquipo;
    private JMenuItem jmiGenerarPartidos;
    private JMenuItem jmiAnadirResultado;
    private JMenuItem jmiBajaPersonas;
    private JMenuItem jmiBorrarEquipo;

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

        PartidosJugados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.abrirUltimaJOrn();
            }
        });


        jmiModificarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.VentanaModificarEquipo();

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
        jmiBajaPersonas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirBajasPersonas();
            }
        });
        jmiBorrarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.vBorrarEquipo();
            }
        });


        jornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                Main.abrirJornada();
            }
        });

        jmiGenerarPartidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                Main.generarJornadas();
            }
        });
        jmiAnadirResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                //Aqui la funcion anadir resultados
            }
        });
        verEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                try {
                    Main.visualizarEquipo();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        
}

public static void main(String[]args){
        JFrame frame=new JFrame("VentanaAdmin");
        frame.setContentPane(new VentanaAdmin().Ventana1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        }


public JPanel getVentana1(){return Ventana1;}
        }
