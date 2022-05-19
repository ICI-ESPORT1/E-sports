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
import java.time.LocalDate;
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
    private JTextField tfSalarioJ;
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

    public ModificarDatosPersona() {
        llenarComboBox(); //Llena el combo de Equipos

        bCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(!tfNombre.getText().equalsIgnoreCase(nombreViejo)){
                        boolean bNombre = validarNombre(tfNombre.getText(),"tipo");
                        if(bNombre){
                            Main.cambiarNombreJugador(tfNombre.getText(),nombreViejo,tfDni.getText(),cbEquipos.getSelectedIndex());
                        }
                    }

                    if(!tfTelefono.getText().equalsIgnoreCase(telfViejo)){
                        boolean bTelefono = validarTelefono(tfTelefono.getText());
                        if(bTelefono){
                            Main.cambiarTelefonoJugador(tfTelefono.getText(),telfViejo,nombreViejo);
                        }
                    }
                    if(!tfSalario.getText().equalsIgnoreCase(String.valueOf(salarioViejo))){
                        boolean bSueldo = validarSueldo();
                        if(bSueldo){
                            Main.cambiarSalarioEquipo(tfSalario.getText(),String.valueOf(salarioViejo) ,nombreViejo);
                        }
                    }




                    if (validarDatosJugador("jugador"))
                    Main.cambiarDatosJugador(tfDNI.getText(), tfNombre.getText(), tfTelefono.getText(), tfDireccion.getText(),tfNickname.getText(),Float.parseFloat(tfSalarioJ.getText()), tfRol.getText(), tfEquipo.getText());
                    System.out.println("jugador modificado");
                }
                catch (Exception ex){
                    System.out.println(ex.getClass());
                }
            }
        });
        tfDNI.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    if (validarDni(tfDNI.getText())) {

                        String dni =tfDNI.getText();
                        jugador = Main.consultarJugador(dni);

                        tfDireccion.setText(jugador.getDireccion());
                        tfNombre.setText(jugador.getNombre());
                        tfTelefono.setText(jugador.getTelefono());
                        tfNickname.setText(jugador.getNickname());
                        tfRol.setText(jugador.getRol().getNombre());
                        tfEquipo.setText(jugador.getEquipo().getNombre());
                    }
                    else{
                        tfDNI.requestFocus(true);
                        tfDNI.setText("Pon un DNI existente");
                    }
                }
                catch (Exception ex){
                    System.out.println(ex.getClass());
                }
            }
        });
        /*
        cbRol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int selecionado = cbRol.getSelectedIndex();

               if(selecionado==0){
                   tfNickname.setEditable(true);
                   tfRol.setEditable(true);
                   tfSalario.setEditable(true);
               }

               if (selecionado==1||selecionado==2){
                   tfNickname.setEditable(false);
                   tfRol.setEditable(false);
                   tfSalario.setEditable(true);
               }

               if (selecionado==3){
                   tfNickname.setEditable(false);
                   tfRol.setEditable(false);
                   tfSalario.setEditable(false);
               }
            }
        });*/ // Se han quitado campos de las personas
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
            bSueldoJ = validarSueldo();
            if(!bSueldoJ){
                tfSalarioJ.setText("");
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
    public boolean validarSueldo(){
        boolean bSueldo = false;
        try{
            if(tfSalarioJ.getText().isEmpty()){
                throw new Exception("EL CAMPO ES OBLIGATORIO");
            }
            else{
                sueldo = Float.parseFloat(tfSalarioJ.getText());
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
            JOptionPane.showMessageDialog(null, "EL CAMPO " + tipo + " NO ES CORRECTO");
            System.out.println(e.getClass());
        }
        return bNombre;

    }
    private void llenarComboBox(){
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
        try{
            int posEquipoSel = cbEquipos.getSelectedIndex();
            String dniPersona = tfDni.getText();
            if(cbRol.getSelectedIndex() ==0){
                Main.sacaListaDeJugadores(posEquipoSel);

                nombreViejo = tfNombre.getText();
                tfNombre.setText(Main.dameNombreDelJugador(dniPersona));
                telfViejo = tfTelefono.getText();
                tfTelefono.setText(Main.dameTelefonoDelJugador(dniPersona));
                salarioViejo =Float.parseFloat(tfSalario.getText());
                tfSalario.setText(String.valueOf(Main.dameSalarioDelJugador(dniPersona)));
            }




        }catch (Exception e ){System.out.println(e.getMessage());}
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
