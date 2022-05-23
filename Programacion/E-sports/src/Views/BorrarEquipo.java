package Views;

import Modelo.BD.BaseDatos;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * @author Celia Garcia
 * @version 1
 *
 */
public class BorrarEquipo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox cbEquipos;
    private JTextArea taInfEquipo;
    private ArrayList<String>listaNombresEquipo;

    public BorrarEquipo() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        llenarComboBox();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Main.cerrarVentana();
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
        cbEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos= cbEquipos.getSelectedIndex();
                String infor= Main.dameDatosDelEquipo(pos);
                taInfEquipo.setText(infor);

            }
        });
    }

    private void onOK() throws Exception {
        int pos= cbEquipos.getSelectedIndex();

        Main.bajaEquipo(pos);
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    private void llenarComboBox(){
        try{
            BaseDatos.abrirConexion();
            Main.consultarEquipos();
            listaNombresEquipo = new ArrayList<>();
            listaNombresEquipo = Main.dameNombresEquipos();
            for(int i=0;i<listaNombresEquipo.size();i++){
                cbEquipos.addItem(listaNombresEquipo.get(i));
            }
            BaseDatos.cerrarConexion();
            cbEquipos.setSelectedIndex(-1);
        }catch (Exception e){System.out.println(e.getMessage());}
    }

    public static void main(String[] args) {
        BorrarEquipo dialog = new BorrarEquipo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
