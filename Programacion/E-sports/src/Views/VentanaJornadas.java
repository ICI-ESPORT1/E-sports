package Views;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
/**
 * @Author Iñigo
 * @Version 1.0
 * Ventana que contiene el formulario de la Inscripcion.
 */
public class VentanaJornadas extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpTitulo;
    private JLabel lTitulo;
    private JTextArea taJornadas;

    public VentanaJornadas() {

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        Main.comprobarFechaJornadas();
        String jornadas = Main.consultarJornadas();
        taJornadas.setText(jornadas);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VentanaJornadas dialog = new VentanaJornadas();
        dialog.pack();
        dialog.setVisible(true);

    }
}
