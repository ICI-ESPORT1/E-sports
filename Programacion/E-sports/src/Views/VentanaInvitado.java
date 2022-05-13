package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInvitado {
    private JPanel VentanaInvitado;
    private JMenuBar MenuLogin;
    private JMenu Menu3_3;
    private JButton Logo;
    private JMenuBar MenuCalendario;
    private JMenu Menu5_5;
    private JMenuItem jornadas;
    private JMenuItem clasificacion;

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaInvitado");
        frame.setContentPane(new VentanaInvitado().VentanaInvitado);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public JPanel getVentanaInvitado() {return VentanaInvitado;}
}
