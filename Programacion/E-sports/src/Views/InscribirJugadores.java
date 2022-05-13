package Views;

import javax.swing.*;

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
    }

    public JPanel getJpJugador() {
        return jpJugador;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InscribirJugadores");
        frame.setContentPane(new InscribirJugadores().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

