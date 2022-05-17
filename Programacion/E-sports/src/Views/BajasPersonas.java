package Views;

import com.company.Main;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BajasPersonas extends JFrame {
    private JButton bCancelar;
    private JButton bDarbaja;
    private JComboBox menuDesplegable;
    private JTextField textField1;
    private JPanel baja;
    private JLabel name;
    private JLabel titulo;

    public BajasPersonas() {
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cerrarVentana();
            }
        });
        bDarbaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaBajas");
        frame.setContentPane(new BajasPersonas().baja);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getBajas() {return baja;}

}
