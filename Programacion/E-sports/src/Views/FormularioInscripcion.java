package Views;
/**
 * @author Celia Garcia
 * @version 1
 * Esta clase es una vista en la que se van a recoger y validar los datos de los equipos y sus integrantes.
 */

import Modelo.Excepciones.CampoIncorrecto;
import Modelo.Excepciones.CampoVacio;
import Modelo.Excepciones.EquipoRepetido;
import com.company.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormularioInscripcion {
    private JPanel jpPrincipal;
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
    private JPanel jpDatosComponentes;
    private JPanel jpDueno;
    private JLabel lNombreDueno;
    private JTextField tfNombreDueno;
    private JTextField tfDNId;
    private JTextField tfTelfd;
    private JTextField tfEmaild;
    private JTextField tfLocalidadD;
    private JPanel jpEntrenador;
    private JTextField tfNombreEntre;
    private JTextField tfDniEn;
    private JTextField tfTelfEnt;
    private JTextField tfEmailEnt;
    private JTextField tfLocEnt;
    private JTextField tfSueldo;
    private JPanel jpAsistente;
    private JTextField tfNombreAsis;
    private JTextField tfDniAsis;
    private JTextField tfTelfAsis;
    private JTextField tfEmailAsis;
    private JTextField tfLocAsis;
    private JTextField tfSueldoAsis;
    private JButton bAnadirJugador;
    private JTextField textField13;
    private JLabel tfUsuario;
    private JTextField tfpass;
    private JLabel lNombreEn;
    private JLabel lDniEnt;
    private JLabel lTelefono;
    private JLabel lEmailEnt;
    private JLabel lLocalidad;
    private JLabel lSueldo;
    private JLabel lNombreAsis;
    private JLabel lDniAsis;
    private JLabel lTelfAsis;
    private JLabel lEmailAsis;
    private JLabel lLocAsis;
    private JLabel lSueldoAsis;
    private JButton bSiguiente;
    /* Variables para la validacion de datos*/
    private String sNombreEquipo = "";
    private String sNacionalidad = "";
    private String sFecha = "";
    private String sTelefonoEquipo="";
    private  LocalDate ldFecha;
    private String sEmailEquipo="";

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioInscripcion");
        frame.setContentPane(new FormularioInscripcion().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public FormularioInscripcion() {

        bAnadirJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*ABRIR NUEVA VENTANA REGISTRAR JUGADORES*/
                Main.abrirInscripcionJugadores();
            }
        });
    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    /**
     * Este método llama a diferentes métodos para validar los diferentes datos que se introducen en el formulario
     * de equipos.
     */
    public void validarDatosEquipo(){
        boolean bNombre = false;
        boolean bNacionalidad = false;
        boolean bFecha = false;
        boolean bTelefono = false;
        boolean bEmail = false;
        try {
            /* **************nombreEquipo********/
            bNombre = validarNombreEquipo();

            /* * *********nacionalidad*************/
            bNacionalidad = validarNacionalidad();

            /* ***********fecha de creacion******/
            sFecha = tfFecha.getText();
            LocalDate fechaMin = LocalDate.of(2000, 01,01);
            ldFecha = convertirAlocalDate();

            if(ldFecha.isBefore(fechaMin) && ldFecha.isAfter(LocalDate.now()) ){
               throw new Exception("La fecha debe estar el 01/01/2000 y el dia de hoy");
            }else{
                bFecha = true;
            }
            /* ******************Telefono *********************/
            sTelefonoEquipo = tfTelefonoEquipo.getText();
            bTelefono = validarTelefono(sTelefonoEquipo);

            /* *****************Email ************************/
            sEmailEquipo = tfEmailEquipo.getText();
            bEmail = validarEmail(sEmailEquipo);

        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
    public boolean validarEmail(String email){
        boolean bEmail = false;
        try{
            if(email.isEmpty()){
                throw new CampoVacio();
            }
            else {
                Pattern patron = Pattern.compile("^[a-z](.+)@(.+)$");
                //Matcher mat = patron.matcher();
            }

        }catch (Exception e){System.out.println(e.getClass());}
        return bEmail;
    }
    /**
     * Este método me permite validar un teléfono, como se va a utilizar para validar
     * el telefono de los jugadores, le paso un parametro en lugar de usar la variable global
     * @param telefono  String para poder usar para validar el telefono de los miembros del equipo
     * @return
     */
    public boolean validarTelefono(String telefono){
        boolean bTelefono = false;
        try{
            if(telefono.isEmpty()){
                throw new CampoVacio();
            }
            else {
                Pattern patron = Pattern.compile("^[6-9][0-9]{8}$");
                Matcher mat = patron.matcher(telefono);

                if(mat.matches()){
                    bTelefono = true;
                }
                else{
                    throw new Exception("El telefono no es valido");
                }
            }
        }catch (Exception e){System.out.println(e.getClass());}
        return bTelefono;
    }

    /**
     * Metodo para convertir la fecha a LocalDate
     * @return La fecha convertida a LocalDate
     */
    public LocalDate convertirAlocalDate(){
        LocalDate ldFecha = null;
        try{
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ldFecha = LocalDate.parse(tfFecha.getText(),formato);

        }catch (Exception e){System.out.println(e.getClass());}
        return ldFecha;
    }
    /**
     * Funcion para validar semanticamente el nombre del Equipo.
     * En este método se llama a otro del Main para asegurar que el nombre de los equipos sean unicos
     * @return bNombre.
     */
    public boolean validarNombreEquipo(){
        boolean bNombre = false;
        try{
            if(tfNombreEquipo.getText().isEmpty()){
                throw new CampoVacio();
            }
            else{
                Pattern patron = Pattern.compile("^[A-Z][a-z0-9]+$");
                Matcher mat = patron.matcher(tfNombreEquipo.getText());
                if(mat.matches()){
                    /*FUNCION PARA COMPROBAR QUE EL NOMBRE DEL EQUIPO NO EXISTE EN LA BD*/
                    bNombre = Main.buscarNombreEquipo(tfNombreEquipo.getText());
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

    /**
     * Funcion para validar semanticamente la nacionalidad.
     * @return bNacionalidad
     */
    public boolean validarNacionalidad(){
    boolean bNacionalidad = false;
    try{
        if(tfNombreEquipo.getText().isEmpty()){
            throw new CampoVacio();
        }else{
            Pattern patron = Pattern.compile("^[A-Z][a-z]+$");
            Matcher mat = patron.matcher(tfNacionalidad.getText());
            if(mat.matches()){
                bNacionalidad = true;
            }else {
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
    return bNacionalidad;
    }

}
