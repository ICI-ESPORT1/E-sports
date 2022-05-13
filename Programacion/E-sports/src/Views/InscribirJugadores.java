package Views;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InscribirJugadores {

    private JPanel jpJugador;
    private JLabel lNombreAsis;
    private JLabel lDniAsis;
    private JLabel lTelfAsis;
    private JLabel lEmailAsis;
    private JLabel lLocAsis;
    private JLabel lSueldoAsis;
    private JTextField tfNombreAsis;
    private JTextField tfDniAsis;
    private JTextField tfTelfAsis;
    private JTextField tfEmailAsis;
    private JTextField tfLocAsis;
    private JTextField tfSueldoAsis;
    private JPanel jpPrincipal;
    private JLabel lNick;
    private JTextField tfNick;
    private JLabel lRol;
    private JTextField tfRol;
    private JButton bOtro;
    private JButton bTerminar;


    public InscribirJugadores() {
        bOtro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean datosValidos =false;
                /*Pasarle los datos al main para que cree un objeto jugador*/
                datosValidos = validarDatosJugador();
                if(datosValidos){
                    Main.crearListaJugadores();/*Hay que pasarle los datos del jugador ya validados*/
                }

            }
        });
    }

    public JPanel getJpJugador() {
        return jpJugador;
    }
    public static boolean validarDatosJugador(){
        return false;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("InscribirJugadores");
        frame.setContentPane(new InscribirJugadores().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

