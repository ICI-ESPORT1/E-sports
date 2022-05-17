package Views;

import Modelo.UML.Resultado;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jornadas {
    private JButton bVolver;
    private JPanel jpJornadas;
    private JTextField tfJornadas;

    private static Resultado resultado;

    public Jornadas() {
        bVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirVentanaPrincipal();
            }
        });
    }


    public void llenarTexto() {
        try{
            resultado=Main.obtenerPartidosJornadas();
            tfJornadas.setText(String.valueOf(resultado.getEquipo()));
        }
        catch (Exception e){
            System.out.println(e.getClass());
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jornadas");
        frame.setContentPane(new Jornadas().getJpJornadas());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getJpJornadas() {
        return jpJornadas;
    }
}
