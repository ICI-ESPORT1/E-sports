package Views;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    private JMenuBar MenuOpcion;
    private JMenu Menu1_1;
    private JMenuBar Menu_Incripcion;
    private JMenu Menu2_2;
    private JMenuBar MenuLogin;
    private JMenu Menu3_3;
    private JButton Logo;
    private JMenuBar MenuEquipo;
    private JMenu Menu4_4;
    private JMenuBar MenuCalendario;
    private JMenu Menu5_5;
    private JPanel Ventana1;
    private JMenuItem Ins;
    private JButton bInscripcion;


    public VentanaPrincipal() {
        Menu3_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        bInscripcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirFormularioEquipo();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().Ventana1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getVentana1() {
        return Ventana1;
    }
}
