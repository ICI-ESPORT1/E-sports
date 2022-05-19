package Views;

import com.company.Main;
import Modelo.UML.Resultado;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Clasificacion extends JFrame {
    private JLabel lTitulo;
    private JTextArea taClasificacion;
    private JButton bCancelar;
    private JPanel pClasificacion;
    private static Resultado resultado;

    public void llenarTextArea(){
        try {
            resultado= Main.obtenerClasificacion();
            taClasificacion.setText(String.valueOf(resultado));
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }
    }



    public Clasificacion() {
        llenarTexto();

        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               Main.cerrarVentana();
            }
        });
    }

    public void main(String[] args) {
        JFrame frame = new JFrame("Clasificacion");
        frame.setContentPane(new Clasificacion().pClasificacion);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        llenarTexto();
    }

    public void llenarTexto(){
        try {
            resultado= Main.obtenerClasificacion();
            System.out.println(resultado);
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }
    }

    public JPanel getpClasificacion() {

        return pClasificacion;
    }

}