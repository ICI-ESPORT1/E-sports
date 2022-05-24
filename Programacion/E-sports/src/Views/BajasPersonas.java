package Views;

import Modelo.BD.BaseDatos;
import com.company.Main;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Celia Garcia
 * @version 1
 *
 */
public class BajasPersonas extends JFrame {
    private JButton bCancelar;
    private JButton bDarbaja;
    private JComboBox cbRol;
    private JTextField tfDni;
    private JPanel baja;
    private JLabel name;
    private JLabel titulo;

    public BajasPersonas() {
        cbRol.setSelectedIndex(-1);
        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cerrarVentana();
            }
        });
        bDarbaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Coger el rol*/
                BaseDatos.abrirConexion();
                try {
                    if (cbRol.getSelectedIndex() == 0) {
                        /*Es jugador*/
                        String dni = tfDni.getText();
                        boolean encontrado = Main.consultarJugador(dni);
                        if (encontrado) {
                            int confirmacion = Main.muestraDatosDelJugador();
                            if (confirmacion == 1) {
                                boolean borrado = Main.bajaJugador(dni);
                                if (!borrado) {
                                    JOptionPane.showMessageDialog(null, "El jugador se ha borrado");
                                }
                            }
                        }
                    }
                    if(cbRol.getSelectedIndex()==1){
                        String dni = tfDni.getText();
                        boolean encontrado = Main.consultarEntrenador(dni);
                        if (encontrado) {
                            int confirmacion = Main.muestraDatosDelEntrenador();
                            if (confirmacion == 1) {
                                boolean borrado = Main.bajaEntrenador(dni);
                                if (!borrado) {
                                    JOptionPane.showMessageDialog(null, "El entrenador se ha borrado");
                                }
                            }
                        }
                    }

                    if(cbRol.getSelectedIndex()==2){
                        String dni = tfDni.getText();
                        boolean encontrado = Main.consultarAsistente(dni);
                        if (encontrado) {

                            int confirmacion = Main.muestraDatosDelAsistente();
                            if (confirmacion == 1) {
                                boolean borrado = Main.bajaAsistente(dni);
                                if (!borrado) {
                                    JOptionPane.showMessageDialog(null, "El asistente se ha borrado");
                                }
                            }
                        }
                    }
                    if(cbRol.getSelectedIndex()==3){
                        String dni = tfDni.getText();
                        boolean encontrado = Main.consultarDueno(dni);
                        if (encontrado) {

                            int confirmacion = Main.muestraDatosDelDueno();
                            if (confirmacion == 1) {
                                boolean borrado = Main.bajaDueno(dni);
                                if (!borrado) {
                                    JOptionPane.showMessageDialog(null, "El dueño se ha borrado");
                                }
                            }
                        }
                    }
                    BaseDatos.cerrarConexion();
                } catch (Exception a) {
                    System.out.println(a.getMessage());
                }

                /*Comprobar que el dni Existe*/

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

    public JPanel getBajas() {
        return baja;
    }

}
