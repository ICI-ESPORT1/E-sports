package Views;

import Modelo.Excepciones.CampoIncorrecto;
import Modelo.Excepciones.CampoVacio;
import Modelo.Excepciones.EquipoRepetido;
import com.company.Main;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormularioInscripcion {
    private JPanel jpPrincipal;
    private JPanel jpTitulo;
    private JPanel lNuevoEquipo;
    private JLabel lTitulo;
    private JPanel jpDatosEquipo;
    private JLabel lNombreEquipo;
    private JTextField tfNombreEquipo;
    private JLabel lNacionalidad;
    private JTextField tfNacionalidad;
    private JLabel lfecha;
    private JTextField tfFecha;
    private JLabel lTelefonoEquipo;
    private JTextField tfTelefonoEquipo;
    private JLabel lEmailEquipo;
    private JTextField tfEmailEquipo;
    private JLabel lEscudo;
    private JTextField tfEscudo;
    private JPanel jpMiembros;
    private JLabel lCargo;
    private JComboBox cbCargo;
    private JLabel lDni;
    private JTextField tfDni;
    private JLabel lNombre;
    private JTextField tfNombre;
    private JLabel lTelefono;
    private JTextField tfTelefono;
    private JLabel lMail;
    private JTextField tfEmail;
    private JLabel lLocalidad;
    private JLabel lSueldo;
    private JLabel lNickname;
    private JLabel lRol;
    private JLabel lSalario;
    private JTextField tfLocalidad;
    private JTextField tfSueldo;
    private JTextField tfNick;
    private JTextField tfRol;
    private JTextField tfSalario;
    private JPanel jpBotones;
    private JButton cancelarButton;
    private JButton bAnterior;
    private JButton bSiguiente;
    private JButton bAceptar;

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioInscripcion");
        frame.setContentPane(new FormularioInscripcion().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    /*Validar datos equipo*/
    public void validarDatosEquipo(){
        boolean bNombre = false;
        try {
            String nombreEquipo = "";
            nombreEquipo = tfNombreEquipo.getText();
            bNombre = validarNombreEquipo(nombreEquipo);

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public static boolean validarNombreEquipo(String nombreE){
        boolean bNombre = false;
        try{
            if(nombreE.isEmpty()){
                throw new CampoVacio();
            }
            else{
                Pattern patron = Pattern.compile("^[A-Z][a-z0-9]+$");
                Matcher mat = patron.matcher(nombreE);
                if(mat.matches()){
                    /*FUNCION PARA COMPROBAR QUE EL NOMBRE DEL EQUIPO NO EXISTE EN LA BD*/
                    bNombre = Main.buscarNombreEquipo(nombreE);
                    if(!bNombre){
                        throw new EquipoRepetido();
                    }
                }
                else{
                    throw new CampoIncorrecto();
                }
            }

        }catch (CampoIncorrecto a){
            System.out.println("El equipo ya existe");
        }
        catch (CampoVacio a){
            System.out.println("El campo es obligatorio");
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }
        return bNombre;
    }

}
