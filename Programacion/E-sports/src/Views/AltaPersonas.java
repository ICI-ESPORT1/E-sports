package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.company.Main;

public class AltaPersonas {
    private JPanel altas;
    private JLabel titulo;
    private JButton bCancelar;
    private JButton bDarAlta;
    private JComboBox menuDesplegable;
    private JTextField dni;
    private JLabel name;
    private JTextField Nombre;
    private JTextField Direccion;
    private JTextField Telefono;
    private JTextField Localidad;
    private JTextField Salario;
    private JComboBox comboRol;
    private JTextField NickName;



    public AltaPersonas() {
        menuDesplegable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(menuDesplegable.getSelectedIndex() == 1) {
                    NickName.setEnabled(false);
                    comboRol.setEnabled(false);
                }
                if(menuDesplegable.getSelectedIndex() != 1) {
                    NickName.setEnabled(true);
                    comboRol.setEnabled(true);
                    Salario.setEnabled(true);
                }

                if (menuDesplegable.getSelectedIndex() == 2){
                    NickName.setEnabled(false);
                    comboRol.setEnabled(false);
                    Salario.setEnabled(true);
                }

                if (menuDesplegable.getSelectedIndex() == 3){
                    NickName.setEnabled(false);
                    comboRol.setEnabled(false);
                    Salario.setEnabled(false);
                }

            }
        });

        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cerrarVentana();
            }
        });

        bDarAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaBajas");
        frame.setContentPane(new AltaPersonas().altas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getAltas() {return altas;}


}
