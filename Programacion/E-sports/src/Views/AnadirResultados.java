package Views;

import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
/**
 * @author Celia Garcia
 * @version 1
 *
 */
public class AnadirResultados extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField iRes1;
    private JTextField iRes2;
    private JTextField tfIdPartido;
    private JTextField tfIdPart;
    private JTextField iIdEq1;
    private JTextField iIdEq2;
    private JTextField tfIdEq2;
    private JTextField tfResultado1;
    private JTextField tfResultado2;

    public AnadirResultados() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int iIdPart = Integer.parseInt(tfIdPart.getText());
                int iIdEq1= Integer.parseInt(tfIdPart.getText());
                int iRes1= Integer.parseInt(tfResultado1.getText());

                int iIdEq2  = Integer.parseInt(tfIdEq2.getText());
                int iRes2= Integer.parseInt(tfResultado2.getText());
                Main.tomaResultado(iIdEq1,iRes1,iIdEq2,iRes2,iIdPart);

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
        AnadirResultados dialog = new AnadirResultados();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}