package Views;

import Modelo.BD.BaseDatos;
import com.company.Main;
import javax.swing.*;
import java.awt.event.*;

/**
 * @Author Iñigo
 * @Version 1.0
 */
public class VisualizarEquipos extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lTitutlo;
    private JPanel jpTitulo;
    private JPanel jpEquipos;
    private JTextArea taInforEqui;

    /**
     *
     * @throws Exception
     */
    public VisualizarEquipos() throws Exception {

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        /*Pedir los datos de los equipos*/
        BaseDatos.abrirConexion();

        Main.consultarEquipos();
        String equipos = Main.dameStringEquipos();
        BaseDatos.cerrarConexion();
        taInforEqui.setText(equipos);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                taInforEqui.remove(taInforEqui);
                onOK();

            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    private void onOK() {dispose();}

    private void onCancel() {dispose();}

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        VisualizarEquipos dialog = new VisualizarEquipos();
        dialog.pack();
        dialog.setVisible(true);

    }
}
