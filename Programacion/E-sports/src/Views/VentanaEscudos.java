package Views;

import com.company.Main;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.File;
import java.util.Locale;

/**
 * @author Celia
 * Clase que muestra un formulario para inscribir equipos
 */
public class VentanaEscudos extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel jpEscudos;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton bSubir;
    private String ruta = "";
    private ImageIcon icono1 = new ImageIcon("./src/Views/Imagenes/escudos/escudoUno.png");
    private ImageIcon icono2 = new ImageIcon("./src/Views/Imagenes/escudos/escudoDos.png");
    private ImageIcon icono3 = new ImageIcon("./src/Views/Imagenes/escudos/escudoTres.png");
    private ImageIcon icono4 = new ImageIcon("./src/Views/Imagenes/escudos/escudoCuatro.png");
    private ImageIcon icono5 = new ImageIcon("./src/Views/Imagenes/escudos/escudoCinco.png");
    private ImageIcon icono6 = new ImageIcon("./src/Views/Imagenes/escudos/escudoSeis.png");
    private ImageIcon icono7 = new ImageIcon("./src/Views/Imagenes/escudos/escudoSiete.png");
    private ImageIcon icono8 = new ImageIcon("./src/Views/Imagenes/escudos/escudoOcho.png");
    private ImageIcon icono9 = new ImageIcon("./src/Views/Imagenes/escudos/escudoNueve.png");
    private ImageIcon icono10 = new ImageIcon("./src/Views/Imagenes/escudos/escudoDiez.png");
    private ImageIcon icono11 = new ImageIcon("./src/Views/Imagenes/escudos/escudoOnce.png");
    private ImageIcon icono12 = new ImageIcon("./src/Views/Imagenes/escudos/escudoDoce.png");


    public VentanaEscudos() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        llenarBotones();


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

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button1.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button2.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button3.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button4.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button5.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button6.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button7.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button8.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button9.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button10.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button11.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ruta = button12.getIcon().toString();
                System.out.println(ruta);
                Main.tenEscudo(ruta);
                dispose();
            }
        });
/*
        bSubir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JFileChooser fc = new JFileChooser();
               FileFilter filtro = new FileNameExtensionFilter("Imagen PNG", "png");
               fc.setFileFilter(filtro);
                fc.showOpenDialog(jpEscudos);
                File archivo = fc.getSelectedFile();
                System.out.println(archivo.toString());
                String archivoimagen = archivo.getName().toString();
                ruta = "./src/Views/Imagenes/escudos/"+archivoimagen;
                Main.tenEscudo(ruta);
                System.out.println(ruta);

            }
        });/*Preparado para un boton de subir imagen*/
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VentanaEscudos dialog = new VentanaEscudos();
        dialog.pack();
        dialog.setVisible(true);

    }
    public void llenarBotones(){
        try{
            button1.setIcon(icono1);
            button2.setIcon(icono2);
            button3.setIcon(icono3);
            button4.setIcon(icono4);
            button5.setIcon(icono5);
            button6.setIcon(icono6);
            button7.setIcon(icono7);
            button8.setIcon(icono8);
            button9.setIcon(icono9);
            button10.setIcon(icono10);
            button11.setIcon(icono11);
            button12.setIcon(icono12);
        }catch (Exception e){System.out.println(e.getClass());}
    }
}
