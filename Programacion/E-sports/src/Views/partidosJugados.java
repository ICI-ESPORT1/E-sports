package Views;

import Modelo.UML.Resultado;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class partidosJugados {
    private JButton bVolver;
    private JTextArea textArea1;
    private JPanel jpPartidos;

    private static Resultado resultado;

    public partidosJugados() {
        bVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirVentanaPrincipal();
            }
        });
    }

    public static void llenarTexto(){
        try{
            resultado=Main.obtenerPartidos();

        }
        catch (Exception e){
            System.out.println(e.getClass());
        }

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("partidosJugados");
        frame.setContentPane(new partidosJugados().getJpPartidos());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getJpPartidos() {
        return jpPartidos;
    }
}
