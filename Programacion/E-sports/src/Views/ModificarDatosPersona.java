package Views;

import Modelo.BD.BaseDatos;
import Modelo.Excepciones.CampoIncorrecto;
import Modelo.Excepciones.CampoVacio;
import Modelo.UML.Jugador;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModificarDatosPersona {
    private JLabel lTitulo;
    private JComboBox cbRol;
    private JTextField tfDNI;
    private JLabel lNombre;
    private JTextField tfNombre;
    private JLabel lTelefono;
    private JTextField tfTelefono;
    private JTextField tfDireccion;
    private JTextField tfNickname;
    private JTextField tfRol;
    private JTextField tfEquipo;
    private JButton bCancelar;
    private JButton bInsertar;
    private JPanel jpModificarDatosPersona;
    private JPanel jpPersona;
    private JPanel jpJugador;
    private JPanel jpEntrAsis;
    private JLabel lSalario;
    private JTextField tfSalario;
    private JComboBox cbEquipos;
    private JTextField tfDni;

    private float sueldo = 0;
    private Jugador jugador;
    private ArrayList<String>listaNombresEquipo;
    private String nombreViejo;
    private String telfViejo;
    private Float salarioViejo;
    private boolean bdni=false;

    public ModificarDatosPersona() {
        llenarComboBox(); //Llena el combo de Equipos

        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
            /*AL PEDER EL FOCO EN EL TF DNI*/
        });
        tfDni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                boolean bdni = validarDni(tfDni.getText());
                if(bdni){
                    llenarFormulario();
                }

            }
        });
        /*DEJAMOS QUE EL USUARIO HAGA LOS CAMBIOS QUE QUIERA*/
        bInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(cbRol.getSelectedIndex()==0){ //ES JUGADOR. YA SE HAN CARGADO LOS DATOS
                        if(!tfNombre.getText().equalsIgnoreCase(nombreViejo)){
                                boolean bNombre = validarNombre(tfNombre.getText(),"tipo"); //Si se ha cambiado el nombre lo valido
                                if(bNombre){
                                   boolean cambiado = Main.cambiarNombreJugador(tfNombre.getText(),nombreViejo,tfDni.getText(),cbEquipos.getSelectedIndex());
                                   if(cambiado){
                                       limpiarFormulario();
                                   }
                                }
                        }
                /* ****************************************Cambiar telefono*********************************************/
                        if(!tfTelefono.getText().equalsIgnoreCase(telfViejo)){
                            boolean bTelefono = validarTelefono(tfTelefono.getText());
                            String pruebaDni =tfDni.getText();
                            if(bTelefono){
                              boolean cambiado =  Main.cambiarTelefonoJugador(tfTelefono.getText(),pruebaDni,cbEquipos.getSelectedIndex());
                              if(cambiado){
                                  limpiarFormulario();
                              }
                            }
                        }
                        /* *****************************************Cambiar SALARIO *****************************/
                        String sSalario = String.valueOf(salarioViejo);
                        if(!tfSalario.getText().equalsIgnoreCase(sSalario)){
                            boolean bSueldo = validarSueldo(tfSalario.getText());
                            String dni = tfDni.getText();
                            if(bSueldo){
                              boolean cambiado = Main.cambiarSalarioJug(tfSalario.getText(),dni ,cbEquipos.getSelectedIndex());
                              if(cambiado){
                                  limpiarFormulario();
                              }
                            }
                        }
                    }
/* ******************************************HASTA AQUI FUNCIONA*******************************************************/
                    if(cbRol.getSelectedIndex()==1){
                        Main.dameListaEntrenadores();
                        if(!tfNombre.getText().equalsIgnoreCase(nombreViejo)){
                            boolean bdni = validarDni(tfDni.getText());
                            if(bdni){
                                boolean bNombre = validarNombre(tfNombre.getText(),"tipo");
                                if(bNombre){
                                    Main.cambiarNombreEntrenador(tfNombre.getText(),tfDNI.getText());
                                }
                            }
                        }
                        if(!tfTelefono.getText().equalsIgnoreCase(telfViejo)){
                            boolean bTelefono = validarTelefono(tfTelefono.getText());
                            if(bTelefono){
                                Main.cambiarTelefonoEntrenador(tfTelefono.getText(),tfDNI.getText());
                            }
                        }
                        if(!tfSalario.getText().equalsIgnoreCase(String.valueOf(salarioViejo))){
                            boolean bSueldo = validarSueldo(tfSalario.getText());
                            if(bSueldo){
                               // Main.cambiarSalarioEntrenador(tfSalario.getText(),tfDNI.getText() ,nombreViejo,cbEquipos.getSelectedIndex());
                            }
                        }
                    }
                }
                catch (Exception ex){
                    System.out.println(ex.getClass());
                }
            }
        });



    }
/* **********************FUNCIONES PARA VALIDAR DATOS************************************/
    public boolean validarDatosJugador(String tipo){
        boolean bJugador = false;
        boolean bNombreJ = false;
        boolean bDniJ =false;
        boolean bTelefonoJ = false;
        boolean bDireccionJ = false;
        boolean bSueldoJ = false;
        boolean bNickName = false;
        try{
           // bSueldoJ = validarSueldo();
            if(!bSueldoJ){
                tfSalario.setText("");
            }
            bNombreJ = validarNombre(tfNombre.getText(),"jugador");
            if(!bNombreJ){
                tfNombre.setText("");
            }
            bNickName = validarNombre(tfNickname.getText(),"especial");
            if(!bNombreJ){
                tfNickname.setText("");
            }
            bDniJ = validarDni(tfDNI.getText());
            if(!bDniJ){
                tfDNI.setText("");
            }

            bTelefonoJ = validarTelefono(tfTelefono.getText());
            if(!bTelefonoJ){
                tfTelefono.setText("");
            }

            bDireccionJ = validarDireccion(tfDireccion.getText());
            if(!bDireccionJ){
                tfDireccion.setText("");
            }
            if(bDniJ&&bDireccionJ&&bNombreJ&&bSueldoJ&&bTelefonoJ){
                bJugador = true;
            }

        }catch (Exception e){System.out.println(e.getClass());}
        return bJugador;
    }
    /**
     * Metodo para validar el sueldo
     * @return
     */
    public boolean validarSueldo(String salario){
        boolean bSueldo = false;
        try{
            if(tfSalario.getText().isEmpty()){
                throw new Exception("EL CAMPO ES OBLIGATORIO");
            }
            else{
                sueldo = Float.parseFloat(tfSalario.getText());
                if(sueldo < 1000){
                    throw new Exception("SE DEBE RESPETAR EL SALARIO MINIMO");
                }else{
                    bSueldo = true;
                }
            }
        }catch (NumberFormatException a){
            System.out.println("EL SUELDO ES UN VALOR NUMERICO");
        }
        catch (Exception e){
            System.out.println(e.getClass());
        }
        return bSueldo;
    }
    /**
     * Metodo para validar la localidad
     * @param loc
     * @return
     */
    public boolean validarDireccion(String loc){
        boolean bLoc=false;
        try {
            if (loc.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo es obligatorio");
                throw new Exception();
            } else {
                Pattern patron = Pattern.compile("^[A-Z][a-z]+$");
                Matcher mat = patron.matcher(loc);
                if (mat.matches()) {
                    System.out.println("El patron del nombre coincide");
                    bLoc = true;
                } else {
                    System.out.println("El patron del nombre no coincide");
                    throw new Exception("El nombre de la localidad debe empezar por mayusculas");
                }
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"El nombre debe empezar por mayusculas");
            System.out.println(e.getClass());
        }
        return bLoc;
    }
    /**
     * Metodo para validar el dni.
     * @param sdni
     * @return
     */
    public boolean validarDni(String sdni){
        boolean bDniValido = false;
        try{
            Pattern p = Pattern.compile("^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$");
            Matcher m = p.matcher(sdni);
            if (!m.matches()){
                throw new Exception("Formato de dni no correcto");
            }
            char letras[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
            int dni = Integer.parseInt(sdni.substring(0,8));
            int resto = dni%23;
            if (letras[resto] != sdni.charAt(8)){
                throw new Exception("Letra incorrecta");
            }else{
                bDniValido =true;
            }

        }catch (Exception e){System.out.println(e.getClass());}
        return bDniValido;
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
                System.out.println("EL CAMPO TELEFONO ESTA VACIO");
                throw new CampoVacio();
            }
            else {
                Pattern patron = Pattern.compile("^[6-9][0-9]{8}$");
                Matcher mat = patron.matcher(telefono);

                if(mat.matches()){
                    bTelefono = true;
                    System.out.println("EL PATRON DEL TELEFONO COINCIDE");
                }
                else{
                    System.out.println("EL PATRON DEL TELEFONO NO COINCIDE");
                    throw new Exception("El telefono no es valido");
                }
            }
        }catch (Exception e){
            tfTelefono.setText(" ");
            JOptionPane.showMessageDialog(null,"EL TELEFONO NO ES VALIDO");

            System.out.println(e.getClass());}
        return bTelefono;
    }


    /**
     * Funcion para validar semanticamente el nombre del Equipo.
     * En este método se llama a otro del Main para asegurar que el nombre de los equipos sean unicos
     * @return bNombre.
     */
    public boolean validarNombre(String snombre, String tipo) {
        boolean bNombre = false;
        Pattern patron = null;
        Matcher mat = null;
        try {
            if (snombre.isEmpty()) {
                throw new CampoVacio();
            } else {

                patron = Pattern.compile("^[A-Z][a-z0-9]+$");
                mat = patron.matcher(snombre);
                if (mat.matches()) {
                    System.out.println("El patron del nombre coincide");
                    bNombre = true;
                } else {

                    System.out.println("El patron del nombre no coincide");
                    throw new CampoIncorrecto();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "EL CAMPO NO ES CORRECTO");
            System.out.println(e.getClass());
        }
        return bNombre;

    }

    private void llenarComboBox(){
        System.out.println("LLENAR COMBOBOX EQUIPOS**********");
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
    private void llenarFormulario(){
        System.out.println("LLENAR LOS DATOS DEL FORMULARIO************");
        try{
            int posEquipoSel = cbEquipos.getSelectedIndex();
            String dniPersona = tfDni.getText();
            if(cbRol.getSelectedIndex() ==0){
                Main.sacaListaDeJugadores(posEquipoSel);

                tfNombre.setText(Main.dameNombreDelJugador(dniPersona));
                nombreViejo = tfNombre.getText();

                tfTelefono.setText(Main.dameTelefonoDelJugador(dniPersona));
                telfViejo = tfTelefono.getText();

                tfSalario.setText(Main.dameSalarioDelJugador(dniPersona));
                String sSalario = tfSalario.getText();
                Float fSalario = Float.parseFloat(sSalario);
                salarioViejo = fSalario;

                /*FALTA AÑADIR
                * ROL SEL=1
                * ROL = 2*/
            }

        }catch (Exception e ){System.out.println(e.getMessage());}
    }
    private void limpiarFormulario(){
        tfNombre.setText("");
        tfTelefono.setText("");
        tfSalario.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ModificarDatosPersona");
        frame.setContentPane(new ModificarDatosPersona().getJpModificarDatosPersona());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getJpModificarDatosPersona() {
        return jpModificarDatosPersona;
    }
}
