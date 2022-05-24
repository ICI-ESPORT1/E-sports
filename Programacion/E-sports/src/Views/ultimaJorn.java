package Views;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ultimaJorn {
    private JButton bVolver;
    private JTextArea taPartidos;
    private JPanel jpPartidos;

    private static JFrame frame=new JFrame();
    private static String resultado;

    public ultimaJorn() {
      //  Main.comprobarFechaUltimaJornada();
        llenarTexto();
        taPartidos.setText(resultado);
        bVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.cerrarVentanaUJ();
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
        frame = new JFrame("partidosJugados");
        frame.setContentPane(new ultimaJorn().getJpPartidos());
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getJpPartidos() {
        return jpPartidos;
    }
}