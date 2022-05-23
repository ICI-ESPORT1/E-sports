package Views;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @Author Iñigo
 * @Version 1.0
 */
public class ultimaJorn {
    private JButton bVolver;
    private JTextArea taPartidos;
    private JPanel jpPartidos;

    private static String resultado;

    public ultimaJorn() {
        Main.comprobarFechaUltimaJornada();
        llenarTexto();
        taPartidos.setText(resultado);
        bVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.abrirVentanaAdmin();
            }
        });
    }

    public static void llenarTexto(){
        try{
            resultado=Main.consultarUltimaJonr();

        }
        catch (Exception e){
            System.out.println(e.getClass());
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("partidosJugados");
        frame.setContentPane(new ultimaJorn().getJpPartidos());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getJpPartidos() {
        return jpPartidos;
    }
}