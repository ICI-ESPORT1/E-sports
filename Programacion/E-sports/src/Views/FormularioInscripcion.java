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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
    private JTextField tfSueldoE;
    private JPanel jpAsistente;
    private JTextField tfNombreAsis;
    private JTextField tfDniAsis;
    private JTextField tfTelfAsis;
    private JTextField tfEmailAsis;
    private JTextField tfLocAsis;
    private JTextField tfSueldoAsis;
    private JButton bAnadirJugador;
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
    private JLabel lTituloPrincipal;
    private JPanel jpJugadores;
    private JLabel lNombreJug;
    private JTextField tfNombreJ;
    private JLabel lDniJug;
    private JTextField tfDniJ;
    private JTextField tfTelfJug;
    private JTextField tfEmailJug;
    private JTextField tfLocJug;
    private JTextField tfSueldoJ;
    private JComboBox cbRol;
    private JTextField tfNick;
    private JProgressBar pgCantJugadores;
    private JButton añadirJug;
    private JLabel lContador;
    private JButton bEscudo;
    private JButton button1;
    private JButton bSiguiente;
    /* Variables para la validacion de datos*/
    private String sNombreEquipo = "";
    private String sNacionalidad = "";
    private String sFecha = "";
    private String sTelefonoEquipo="";
    private  LocalDate ldFecha;
    private String rolJug ="";
    private String sEmailEquipo="";
    private boolean bEquipoValido = false;
    private boolean bDuenoValido = false;
    private boolean bAsisValido = false;
    private boolean bJugadorValido = false;
    private boolean bEntrenadorValido =false;
    private float sueldo = 0;
    private List<String[]> listaJugadores = new ArrayList<String[]>();
    private ArrayList<String>listaDeRoles = new ArrayList<>();




    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioInscripcion");
        frame.setContentPane(new FormularioInscripcion().jpPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public FormularioInscripcion() {
        lContador.setText("Jugador 1");
        for(int i=0; i<cbRol.getItemCount() ; i++){
            listaDeRoles.add(cbRol.getItemAt(i).toString());
            System.out.println(listaDeRoles.get(i).toString());
        }

        llenarFormulario();

        bAnadirJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    bEquipoValido = validarDatosEquipo("especial");
                    if(bEquipoValido){
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        Date dfecha = formato.parse(tfFecha.getText());
                        java.sql.Date sqlFecha  = new java.sql.Date(dfecha.getTime());

                        Main.tenDatosEquipo(tfNombreEquipo.getText(),tfNacionalidad.getText(),ldFecha,tfTelefonoEquipo.getText(),tfEmailEquipo.getText());
                    }

                    bDuenoValido = validarDatosDueno("dueno");
                    if(bDuenoValido){
                        Main.tenDatosDueno(tfDNId.getText(),tfNombreDueno.getText(),tfLocalidadD.getText(),tfTelfd.getText(), tfEmaild.getText());
                    }
                    bEntrenadorValido = validarDatosEntrenador();
                    if(bEntrenadorValido){
                        Main.tenDatosEntrenador(tfDniEn.getText(),tfNombreEntre.getText(),tfLocEnt.getText(),tfTelfEnt.getText(),sueldo,tfEmailEnt.getText());
                    }
                    bAsisValido = validarDatosAsistente();
                    if(bAsisValido){
                        Main.tenDatosAsistente(tfDniEn.getText(),tfNombreEntre.getText(),tfLocEnt.getText(),tfTelfEnt.getText(),sueldo,tfEmailAsis.getText());
                    }


                    for(String[] row : listaJugadores){
                        String [] fila = new String[6];
                        fila = row;
                        Main.tenDatosJugador(fila[0],fila[1],fila[2],fila[3],fila[4],fila[5],fila[6]);
                        System.out.println(row);
                    }


                }
                catch (Exception z){System.out.println(e.getClass());}

            }
        });
        añadirJug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarListaJugadores();
                if(lContador.getText().equalsIgnoreCase("Jugador 7")){
                    lContador.setText("Maximo alcanzado");

                    tfDniJ.setEditable(false);
                    tfNombreJ.setEditable(false);
                    tfLocJug.setEditable(false);
                    tfTelfJug.setEditable(false);
                    tfSueldoJ.setEditable(false);
                    tfEmailJug.setEditable(false);
                    tfNick.setEditable(false);
                }
            }
        });
        bEscudo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Main.abrirVentanaEscudos();
                    String rutaImagenPropia = Main.dameEscudo();
                    System.out.println(rutaImagenPropia.toString());
                    ImageIcon imagenPropia = new ImageIcon(rutaImagenPropia);
                    button1.setIcon(imagenPropia);
                }catch (Exception o){
                    System.out.println(e.getClass());
                }
            }
        });




    }

    public JPanel getJpPrincipal() {
        return jpPrincipal;
    }

    public void llenarFormulario(){
        tfNombreJ.setText("Celia");
        tfNombreAsis.setText("Ana");
        tfNombreEntre.setText("Fran");
        tfNombreDueno.setText("Ivan");
        tfNombreEquipo.setText("Equipo");
        tfDniAsis.setText("72738006T");
        tfDniEn.setText("72738006T");
        tfDniJ.setText("72738006T");
        tfDNId.setText("72738006T");
        tfLocJug.setText("Vitoria");
        tfLocAsis.setText("Vitoria");
        tfLocEnt.setText("Vitoria");
        tfLocalidadD.setText("Vitoria");
        tfSueldoJ.setText("1439");
        tfSueldoAsis.setText("1673");
        tfSueldoE.setText("1876");
        tfEmailJug.setText("ewe@fdas");
        tfEmailAsis.setText("ewe@fdas");
        tfEmaild.setText("ewe@fdas");
        tfEmailEnt.setText("ewe@fdas");
        tfEmailEquipo.setText("ewe@fdas");
        tfTelfJug.setText("987987987");
        tfTelfd.setText("987987987");
        tfTelfAsis.setText("987987987");
        tfTelfEnt.setText("987987987");
        tfTelefonoEquipo.setText("987987987");
        tfNacionalidad.setText("Francesa");
        tfFecha.setText("12/07/2005");
        tfNick.setText("Ivantxo");
    }

    /**
     * Metodo que crea una lista con los datos de todos los jugadores de un equipo para pasarle al Main
     */
    public void llenarListaJugadores(){
        String dni ="";
        String nombre ="";
        String loc ="";
        String telf ="";
        String sueldo="";
        String nick="";
        String rol="";
        String mail ="";
        int tamanoLista = 0;

        try{

          if(validarDatosJugador("jugador") ) {
              dni = tfDniJ.getText();
              nombre =tfNombreJ.getText();
              loc =tfLocJug.getText();
              telf=tfTelfJug.getText();
              sueldo=tfSueldoJ.getText();
              mail =tfEmailJug.getText();
              nick=tfNick.getText();
              rol = "";

              listaJugadores.add(new String[]{dni,nombre,telf,mail,loc,nick,sueldo});
              for(String[] row : listaJugadores){
                  String [] fila = new String[6];
                  fila = row;
                  System.out.println(Arrays.toString(row));
              }
              tamanoLista = listaJugadores.size()+1;

              //limpiarCamposJugador();
                int posicionRol = cbRol.getSelectedIndex();
                rol = listaDeRoles.get(posicionRol);
              lContador.setText("jugador " + String.valueOf(tamanoLista));
              System.out.println(tamanoLista);
              System.out.println(rol);
          }

        }catch (Exception e){System.out.println(e.getClass());}
    }

    /**
     * Metodo que limpia los campos de datos de los jugadores
     */
    public void limpiarCamposJugador(){
        tfDniJ.setText("");
        tfNombreJ.setText("");
        tfLocJug.setText("");
        tfTelfJug.setText("");
        tfSueldoJ.setText("");
        tfEmailJug.setText("");
        tfNick.setText("");

    }
    /**
     * Este método llama a diferentes métodos para validar los diferentes datos que se introducen en el formulario
     * de equipos.
     */
    public boolean validarDatosEquipo(String tipo){
        boolean bequipoValido = false;
        boolean bNombre = false;
        boolean bNacionalidad = false;
        boolean bFecha = false;
        boolean bTelefono = false;
        boolean bEmail = false;
        try {
            /* **************nombreEquipo********/
            bNombre = validarNombre(tfNombreEquipo.getText(),"especial");
            /* * *********nacionalidad*************/
            bNacionalidad = validarNombre(tfNacionalidad.getText(),"nacionalidad");

            /* ***********fecha de creacion******/
            LocalDate fechaMin = LocalDate.of(2000, 01,01);
            ldFecha = convertirAlocalDate();
            if(ldFecha.isBefore(fechaMin) && ldFecha.isAfter(LocalDate.now()) ){
                tfFecha.setText(" ");
               throw new Exception("La fecha debe estar el 01/01/2000 y el dia de hoy");

            }else{
                bFecha = true;
            }
            /* ******************Telefono *********************/
            bTelefono = validarTelefono(tfTelefonoEquipo.getText());

            /* *****************Email ************************/
            bEmail = validarEmail(tfEmailEquipo.getText());
            /* ***************COMPROBAR QUE TODOS SON VALIDOS ****/
            if(bNombre&&bEmail&&bFecha&&bNacionalidad&&bTelefono){
                bequipoValido = true;
            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }
        return bequipoValido;
    }/*VALIDA BIEN*/

    /**
     * Metodo para validar los datos de los dueños
     * @param tipo Pasamo un tipo para poder usar el método validar nombre con equipo y persona
     * @return
     */
    public boolean validarDatosDueno(String tipo){
        boolean bnombreP =false;
        boolean bdni = false;
        boolean btelefono =false;
        boolean bemail = false;
        boolean blocalidad =false;
        try{

            bnombreP = validarNombre(tfNombreDueno.getText(),"dueno");
            if(!bnombreP){
                tfNombreDueno.setText("");
            }
            bdni = validarDni(tfDNId.getText());
            if(!bdni){
                tfDNId.setText("");
            }

            btelefono = validarTelefono(tfTelfd.getText());
            if(!btelefono){
                tfTelfd.setText("");
            }
            bemail = validarEmail(tfEmaild.getText());
            if(!bemail){
                tfEmaild.setText("");
            }
            blocalidad = validarLocalidad(tfLocalidadD.getText());
            if(!blocalidad){
                tfLocalidadD.setText("");
            }
            if(bnombreP&&bemail&&blocalidad&&bdni&&btelefono){
                bDuenoValido = true;
            }


        }catch (Exception e){System.out.println(e.getClass());}

        return bDuenoValido;
    }

    /**
     * Método para validar los datos del entrenador
     * @return
     */
    public boolean validarDatosEntrenador(){
        boolean bEntrenador=false;
        boolean bnombreE = false;
        boolean bdniE =false;
        boolean btelefonoE = false;
        boolean bemailE =false;
        boolean blocalidad = false;
        boolean bSueldo = false;
        try{
            bSueldo = validarSueldo();
            if(!bSueldo){
                tfSueldoE.setText("");
            }

            bnombreE = validarNombre(tfNombreEntre.getText(),"entrenador");
            if(!bnombreE){
                tfNombreEntre.setText("");
            }
            bdniE = validarDni(tfDNId.getText());
            if(!bdniE){
                tfDniEn.setText("");
            }

            btelefonoE = validarTelefono(tfTelfd.getText());
            if(!btelefonoE){
                tfTelfEnt.setText("");
            }
            bemailE = validarEmail(tfEmaild.getText());
            if(!bemailE){
                tfEmailEnt.setText("");
            }
            blocalidad = validarLocalidad(tfLocalidadD.getText());
            if(!blocalidad){
                tfLocEnt.setText("");
            }
            if(bdniE&&blocalidad&&bemailE&&bnombreE&&bSueldo&&btelefonoE){
                bEntrenador = true;
            }

        }catch (Exception e){
            System.out.println(e.getClass());
        }

        return bEntrenador;
    }

    /**
     * Metodo para validar los datos del asistente. Si el equipo no tiene asistente, al no introducir el dni, el campo
     * de datos de asistente se deshabilita.
     * @return
     */
    public boolean validarDatosAsistente(){
        boolean bAsistente=false;
        boolean bNombreA = false;
        boolean bDniA =false;
        boolean bTelefonoA = false;
        boolean bEmailA =false;
        boolean blocalidad = false;
        boolean bSueldo = false;
        try{
            if(tfDniAsis.getText().isEmpty()){
                jpAsistente.setEnabled(false);
            } else{
                bSueldo = validarSueldo();
                if(!bSueldo){
                    tfSueldoAsis.setText("");
                }

                bNombreA = validarNombre(tfNombreAsis.getText(),"asistente");
                if(!bNombreA){
                    tfNombreAsis.setText("");
                }
                bDniA = validarDni(tfDniAsis.getText());
                if(!bDniA){
                    tfDniAsis.setText("");
                }

                bTelefonoA = validarTelefono(tfTelfAsis.getText());
                if(!bTelefonoA){
                    tfTelfAsis.setText("");
                }
                bEmailA = validarEmail(tfEmailAsis.getText());
                if(!bEmailA){
                    tfEmailAsis.setText("");
                }
                blocalidad = validarLocalidad(tfLocAsis.getText());
                if(!blocalidad){
                    tfLocAsis.setText("");
                }
                if(bDniA&&blocalidad&&bEmailA&&bNombreA&&bSueldo&&bTelefonoA){
                    bAsistente = true;
                }

            }


        }catch (Exception e){
            System.out.println(e.getClass());
        }

        return bAsistente;
    }

    /**
     * Método para validar los datos de los jugadores
     * @param tipo
     * @return
     */
    public boolean validarDatosJugador(String tipo){
        boolean bJugador = false;
        boolean bNombreJ = false;
        boolean bDniJ =false;
        boolean bTelefonoJ = false;
        boolean bEmailJ =false;
        boolean blocalidadJ = false;
        boolean bSueldoJ = false;
        boolean bNickName = false;
        try{
            bSueldoJ = validarSueldo();
            if(!bSueldoJ){
                tfSueldoJ.setText("");
            }
            bNombreJ = validarNombre(tfNombreJ.getText(),"jugador");
            if(!bNombreJ){
                tfNombreJ.setText("");
            }
            bNickName = validarNombre(tfNick.getText(),"especial");
            if(!bNombreJ){
                tfNick.setText("");
            }
            bDniJ = validarDni(tfDniJ.getText());
            if(!bDniJ){
                tfDniJ.setText("");
            }

            bTelefonoJ = validarTelefono(tfTelfJug.getText());
            if(!bTelefonoJ){
                tfTelfJug.setText("");
            }
            bEmailJ = validarEmail(tfEmailJug.getText());
            if(!bEmailJ){
                tfEmailJug.setText("");
            }
            blocalidadJ = validarLocalidad(tfLocJug.getText());
            if(!blocalidadJ){
                tfLocJug.setText("");
            }
            if(bDniJ&&blocalidadJ&&bEmailJ&&bNombreJ&&bSueldoJ&&bTelefonoJ){
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
            if(tfSueldoE.getText().isEmpty()){
                throw new Exception("EL CAMPO ES OBLIGATORIO");
            }
            else{
                sueldo = Float.parseFloat(tfSueldoE.getText());
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
    public boolean validarLocalidad(String loc){
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
     * Metodo para validar el email
     * @param email
     * @return
     */
    public boolean validarEmail(String email){
        boolean bEmail = false;
        try{
            if(email.isEmpty()){
                throw new CampoVacio();
            }
            else {
                Pattern patron = Pattern.compile("^[a-z](.+)@(.+)$");
                Matcher mat = patron.matcher(tfEmailEquipo.getText());

                if(mat.matches()){
                    System.out.println("EL PATRON DEL EMAIL COINCIDE");
                    bEmail = true;
                }
                else{
                    System.out.println("EL PATRON DEL EMAIL NO COINCIDE");
                    throw new CampoIncorrecto();
                }
            }

        }catch (CampoIncorrecto e){
            JOptionPane.showMessageDialog(null,"EL EMAIL NO ES CORRECTO");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"EL EMAIL NO ES VALIDO");
            System.out.println(e.getClass());}
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
            tfTelefonoEquipo.setText(" ");
            JOptionPane.showMessageDialog(null,"EL TELEFONO NO ES VALIDO");

            System.out.println(e.getClass());}
        return bTelefono;
    }
    /**
    * Metodo para convertir el string de la fecha en tipo LocalDate
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
                    if(tipo.equalsIgnoreCase("equipo")){
                        /*FUNCION PARA COMPROBAR QUE EL NOMBRE DEL EQUIPO NO EXISTE EN LA BD*/
                        bNombre = Main.buscarNombreEquipo(tfNombreEquipo.getText());
                        if(bNombre){
                            tfNombreEquipo.setText("");
                            System.out.println("Se ha encontrado el nombre en la base de datos");
                            throw new EquipoRepetido();
                        }
                    }
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
    } /*VALIDA*/

    /**
     * Funcion para validar semanticamente la nacionalidad.
     * @return bNacionalidad
     */


}
