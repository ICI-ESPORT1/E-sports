package Views;

import Modelo.BD.BaseDatos;
import Modelo.Encriptar.encriptacion;
import Modelo.Excepciones.CampoIncorrecto;
import Modelo.Excepciones.CampoVacio;
import Modelo.Excepciones.EquipoRepetido;
import com.company.Main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends javax.swing.JDialog {
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton bAceptar;
    private javax.swing.JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JButton bInvitado;


    public Login() {
        paraProbar();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);


        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                onCancel();
            }

        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {

                onCancel();
            }
        });

        // call onCancel() on ESCAPE

        contentPane.registerKeyboardAction(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {

                onCancel();
            }

        }, javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0), javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        bInvitado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.VentanaInvitado();

            }
        });

        bAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BaseDatos.abrirConexion();
                    String username = textField1.getText();
                    String password = textField2.getText();
                    Main.tomaDatosUsuario(username,password);
                    encriptacion encr = new encriptacion();
                    String encriptado = encr.encriptar(textField2.getText());
                    //String desencr = encr.desencriptar(encriptado);
                    //Main.abrirVentanaAdmin();
                    // Main.abrirVentanaAdmin();
                    BaseDatos.cerrarConexion();

                }catch (Exception E){
                    System.out.println(E.getMessage());
                }

            }
        });

    }


    private void onOK() {

        dispose();
    }

    private void onCancel() {

        dispose();
    }
    public void paraProbar(){
        textField1.setText("admin");
        textField2.setText("admin");
    }

    public static void main(String[] args) {
        Login dialog = new Login();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
        dialog.setLocationRelativeTo(null);

    }


}
