package Views;

import com.company.Main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @Author Iñigo
 * @Version 1.0
 */
public class VentanaInvitado extends JFrame {
    private JPanel VentanaInvitado;
    private JButton Logo;
    private JMenuBar MenuCalendario;
    private JMenu Menu5_5;
    private JMenuItem jornadas;
    private JMenuItem clasificacion;
    private JButton bLogin;

    public VentanaInvitado() {
        bLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cerrarVentana();
                Main.ventanaLogin();
            }
        });

        clasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.abrirClasificacion();
            }
        });

        jornadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaInvitado");
        frame.setContentPane(new VentanaInvitado().VentanaInvitado);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public JPanel getVentanaInvitado() {return VentanaInvitado;}



}
