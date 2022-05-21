package Views;

import Modelo.BD.BaseDatos;
import Modelo.Excepciones.CampoIncorrecto;
import Modelo.Excepciones.CampoVacio;
import Modelo.Excepciones.EquipoRepetido;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaModificarEquipo extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpBotones;
    private JPanel jpFormulario;
    private JLabel lTitulo;
    private JPanel jpForm;
    private JComboBox cbEquipos;
    private JLabel lCombo;
    private JPanel tfRellenar;
    private JLabel lNombre;
    private JTextField tfNombre;
    private JLabel lNacionalidad;
    private JTextField tfNacionalidad;
    private JLabel lFecha;
    private JTextField tfFecha;
    private JLabel lTelf;
    private JTextField tfTelf;
    private JLabel lMail;
    private JTextField tfEmail;

    private ArrayList<String>listaNombresEquipo;
    private String nombreViejo ="";
    private String nacionalidadVieja ="";
    private String fechaVieja ="";
    private String telfViejo ="";
    private String mailViejo="";

    public VentanaModificarEquipo() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        llenarComboBox();

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        cbEquipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Buscar los datos en el array de equipos del main*/
                llenarFormulario();
            }
        });
    }

    /**
     * Este metodo llena el combobox de la ventana. Realiza una consulta a la base de datos para obtener los nombres
     * de los equipos y los muestra.
     */
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

    /**
     * Este método llena el formulario con los datos del equipo seleccionado en la combobox y guarda en variables
     * los datos originales de equipo
     */
    private void llenarFormulario(){
        try{
            int posEquipoSel = cbEquipos.getSelectedIndex();

            tfNombre.setText(Main.dameNombreDelEquipo(posEquipoSel));
            nombreViejo = tfNombre.getText();
            tfNacionalidad.setText(Main.dameNacionalidadDelEquipo(posEquipoSel));
            nacionalidadVieja = tfNacionalidad.getText();
            tfFecha.setText(Main.dameFechaDelEquipo(posEquipoSel));
            fechaVieja = tfFecha.getText();
            tfTelf.setText(Main.dameTelefonoDelEquipo(posEquipoSel));
            telfViejo = tfTelf.getText();
            tfEmail.setText(Main.dameMailDelEquipo(posEquipoSel));
            mailViejo = tfEmail.getText();
        }catch (Exception e ){System.out.println(e.getMessage());}
    }

    /**
     * Una vez que se ha confirmado el cambio de un dato limpia los campos
     */
    private void limpiarFormulario(){
        tfNombre.setText("");
        nombreViejo = "";
        tfNacionalidad.setText("");
        nacionalidadVieja = "";
        tfFecha.setText("");
        fechaVieja = "";
        tfTelf.setText("");
        telfViejo = "";
        tfEmail.setText("");
        mailViejo = "";
    }

    /**
     * Al pulsar el boton Ok se comparan los campos originales con los datos que hay en el momento de pulsar el boton
     * de manera que solo actualiza aquellos que son distintos.
     */
    private void onOK() {
        // Una vez modificados los datos. Le doy los datos al Main
            try{
                if(!tfNombre.getText().equalsIgnoreCase(nombreViejo)){
                    boolean bNombre = validarNombre(tfNombre.getText(),"tipo");
                    if(bNombre){
                       boolean cambiado = Main.cambiarNombreEquipo(tfNombre.getText(),nombreViejo);
                       if(cambiado) {
                           limpiarFormulario();
                       }
                    }
                }
                if(!tfNacionalidad.getText().equalsIgnoreCase(nacionalidadVieja)){
                    boolean bNacionalidad = validarNombre(tfNacionalidad.getText(),"nacionalidad");//valida el nombre de la nacionalidad
                    if(bNacionalidad){
                       boolean cambiado = Main.cambiarNacionalidadEquipo(tfNacionalidad.getText(),nacionalidadVieja,nombreViejo);
                       if(cambiado){
                           limpiarFormulario();
                       }
                    }
                }
                if(!tfFecha.getText().equalsIgnoreCase(fechaVieja)){
                    LocalDate ldFechaNueva = convertirAlocalDate(tfFecha.getText());
                    LocalDate ldFechaVieja = convertirAlocalDate(fechaVieja);
                    if (ldFechaNueva.isBefore(LocalDate.now())){
                        Main.cambiarFechaEquipo(ldFechaNueva,ldFechaVieja,nombreViejo);
                    }
                }
                if(!tfTelf.getText().equalsIgnoreCase(telfViejo)){
                    boolean bTelefono = validarTelefono();
                    if(bTelefono){
                        Main.cambiarTelefonoEquipo(tfTelf.getText(),telfViejo,nombreViejo);
                    }
                }
                if(!tfEmail.getText().equalsIgnoreCase(mailViejo)){
                    boolean bEmail = validarEmail();
                    if(bEmail){
                        Main.cambiarMailEquipo(tfEmail.getText(),mailViejo,nombreViejo);
                    }
                }


            }catch (Exception e){System.out.println(e.getMessage());}
            /*Se va a cambiar el nombre*/

        dispose();
    }
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    public static void main(String[] args) {
        VentanaModificarEquipo dialog = new VentanaModificarEquipo();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    /**
     * Metodo para validar el nombre del equipo
     * @param snombre String
     * @param tipo valida nombre de equipo o nacionalidad dependiendo del tipo que se le pase
     * @return true o false
     */
    public boolean validarNombre(String snombre, String tipo){
        boolean bNombre = false;
        Pattern patron = null;
        Matcher mat = null;
        try{
            if(snombre.isEmpty()){
                throw new CampoVacio();
            }
            else{
                if(tipo.equalsIgnoreCase("equipo")){
                    patron = Pattern.compile("^[A-Z][a-z0-9]+$");
                }else {
                    patron = Pattern.compile("^[A-Z][a-z]+$");
                }
                mat = patron.matcher(snombre);
                if(mat.matches()){
                    System.out.println("El patron del nombre coincide");
                    bNombre = true;
                }
                else{

                    System.out.println("El patron del nombre no coincide");
                    throw new CampoIncorrecto();
                }
            }

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"EL CAMPO " + tipo+ " NO ES CORRECTO");
            System.out.println(e.getClass());}
        return bNombre;
    }

    /**
     * Metodo para convertir un String a LocalDate
     * @param fecha String
     * @return LocalDate
     */
    public LocalDate convertirAlocalDate(String fecha){
        LocalDate ldFecha = null;
        try{
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ldFecha = LocalDate.parse(fecha,formato);

        }catch (Exception e){System.out.println(e.getClass());}
        return ldFecha;
    }

    /***
     * Valida el nuevo telefono
     * @return true o false
     */
    public boolean validarTelefono(){
        boolean bTelefono = false;
        try{
            if(tfTelf.getText().isEmpty()){
                System.out.println("EL CAMPO TELEFONO ESTA VACIO");
                throw new CampoVacio();
            }
            else {
                Pattern patron = Pattern.compile("^[6-9][0-9]{8}$");
                Matcher mat = patron.matcher(tfTelf.getText());

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
            tfTelf.setText(" ");
            JOptionPane.showMessageDialog(null,"EL TELEFONO NO ES VALIDO");

            System.out.println(e.getClass());}
        return bTelefono;
    }
    /***
     * Valida el nuevo mail
     * @return true o false
     */
    public boolean validarEmail(){
        boolean mailValido=false;
        try{
            boolean bMail = false;
            try{
                if(tfEmail.getText().isEmpty()){
                    System.out.println("EL CAMPO TELEFONO ESTA VACIO");
                    throw new CampoVacio();
                }
                else {
                    bMail =true;
                   // Pattern patron = Pattern.compile("");
                   // Matcher mat = patron.matcher(tfEmail.getText());

                   // if(mat.matches()){
                     //   bMail = true;
                       // System.out.println("EL PATRON DEL MAIL  COINCIDE");
                    }
                 //   else{
                      //  System.out.println("EL PATRON DEL Mail NO COINCIDE");
                       // throw new Exception("El telefono no es valido");
                   // }
               // }
            }catch (Exception e){
                tfEmail.setText(mailViejo);
                JOptionPane.showMessageDialog(null,"EL MAIL NO ES VALIDO");

                System.out.println(e.getClass());}
            return bMail;
        }catch (Exception e){System.out.println(e.getMessage());}
        return mailValido;
    }
}
