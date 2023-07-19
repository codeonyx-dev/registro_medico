package com.usd89.registro;

import javax.swing.*;

import javafx.scene.layout.Pane;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class NHM_part1 extends JFrame{
    public NHM_part1(){
        setSize(1290, 720);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 20));
        setLocationRelativeTo(null);

        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBounds(0, 0, 1290, 720);
        this.add(Panel);
        
        // Cerrar ventana
        final JLabel Cerrar = Elementos.cerrar(1270, 10, 20, 20);
        Panel.add(Cerrar);
        Cerrar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose(); // Cierra la ventana
            }

            public void mouseEntered(MouseEvent e) {
                Cerrar.setForeground(Color.RED);
            }

            public void mouseExited(MouseEvent e) {
                Cerrar.setForeground(Color.WHITE);
            }
        });

        // Minimizar
        final JLabel Minimizar = Elementos.minimizar(1250, 10, 20, 20);
        Panel.add(Minimizar);
        Minimizar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setExtendedState(1);
            }

            public void mouseEntered(MouseEvent e) {
                Minimizar.setForeground(Color.red);
            }

            public void mouseExited(MouseEvent e) {
                Minimizar.setForeground(Color.white);
            }
        });

        //PRIMERA FILA  
        final JLabel label_apellido_familiar = Elementos.crearJLabel(36, 65, 150, 20, "Apellido de tu familia:", false);
        Panel.add(label_apellido_familiar);
        final JTextField text_apellido_familiar = Elementos.crearJTextField(187, 65, 150, 20,"",true);
        Panel.add(text_apellido_familiar);

        final JLabel label_ci_jefe_familia = Elementos.crearJLabel(345, 65, 130, 20, "C.I Jefe de familia:", false);
        Panel.add(label_ci_jefe_familia);
        final JTextField text_ci_jefe_familia = Elementos.crearJTextField(475, 65, 150, 20,"",true);
        Panel.add(text_ci_jefe_familia);

        final JLabel Label_Numero_de_Historia = Elementos.crearJLabel(630, 65, 130, 20, "C.I Jefe de familia:", false);
        Panel.add(Label_Numero_de_Historia);
        final JTextField text_Numero_de_Historia = Elementos.crearJTextField(760, 65, 150, 20,"",true);
        Panel.add(text_Numero_de_Historia);

        //Segunda linea
        final JLabel Label_ci = Elementos.crearJLabel(36, 95, 20, 20, "CI", false);
        Panel.add(Label_ci);
        final JComboBox<String> ci_ComboBox = new JComboBox<String>(new String[]{"V","E"});
        ci_ComboBox.setBounds(61, 95, 40, 20);
        Panel.add(ci_ComboBox);

        final JTextField text_ci = Elementos.crearJTextField(105, 95,150, 20,"", true);
        Panel.add(text_ci);

        final JLabel label_apellido = Elementos.crearJLabel(270, 95, 70, 20, "Apellido:", false);
        Panel.add(label_apellido);

        final JTextField text_apellido = Elementos.crearJTextField(335, 95, 150, 20,"", true);
        Panel.add(text_apellido);

        final JLabel label_nombre = Elementos.crearJLabel(500, 95, 65, 20, "Nombre:", false);
        Panel.add(label_nombre);

        final JTextField text_nombre = Elementos.crearJTextField(565, 95, 130, 20,"", true);
        Panel.add(text_nombre);

        final JLabel label_estadoCivil= Elementos.crearJLabel(700, 95, 90, 20, "Estado civil:", false);
        Panel.add(label_estadoCivil);

        final JComboBox<String> ComboBox_estadoCivil = new JComboBox<String>(new String[]{"S","C","V","D","O"});
        ComboBox_estadoCivil.setBounds(790, 95, 50,20);
        Panel.add(ComboBox_estadoCivil);

        final JLabel label_Ocupacion = Elementos.crearJLabel(860, 95, 80, 20, "Ocupacion:", false);
        Panel.add(label_Ocupacion);

        final JTextField text_Ocupacion = Elementos.crearJTextField(943, 95, 100, 20,"", true);
        Panel.add(text_Ocupacion);

        //Tercera linea
        final JLabel label_Estudios = Elementos.crearJLabel(36, 125, 80, 20, "Estudios:", false);
        Panel.add(label_Estudios);

        final JComboBox<String> combo_estudio = new JComboBox<String>(new String[]{"P","S","U","O"});
        combo_estudio.setBounds(110, 125, 50, 20);
        Panel.add(combo_estudio);
        
        final JLabel label_anosAprovados = Elementos.crearJLabel(170, 125, 120, 20, "Años aprovados:", false);
        Panel.add(label_anosAprovados);

        final JTextField text_anosAprovados = Elementos.crearJTextField(295, 125, 80, 20, "", true);
        Panel.add(text_anosAprovados);

        final JLabel label_Analfabeta = Elementos.crearJLabel(380, 125, 80, 20, "Analfabeta:", false);
        Panel.add(label_Analfabeta);

        final JComboBox<String> combo_Analfabeta = new JComboBox<String>(new String[]{"Si","No"});
        combo_Analfabeta.setBounds(465, 125, 50, 20);
        Panel.add(combo_Analfabeta);

        final JLabel label_Sexo = Elementos.crearJLabel(525, 125, 50, 20, "Sexo:", false);
        Panel.add(label_Sexo);

        final JComboBox<String> combo_sexo = new JComboBox<String>(new String[]{"F","M"}); 
        combo_sexo.setBounds(575, 125, 50, 20);
        Panel.add(combo_sexo);

        //FECHA DE NACIMIENTO
        final JLabel label_fechaNacimiento = Elementos.crearJLabel(630,125,130,20,"Fecha nacimiento:",false);
        Panel.add(label_fechaNacimiento);
        
        final JTextField text_NDia = Elementos.crearJTextField(765, 125, 50, 20, "DD",true);
        final JTextField text_NMes = Elementos.crearJTextField(815, 125, 50, 20, "MM",true);
        final JTextField text_NaAno = Elementos.crearJTextField(865, 125, 50, 20, "AA",true);
        Panel.add(text_NDia);
        Panel.add(text_NMes);
        Panel.add(text_NaAno);

        final JLabel label_LugarNacimento = Elementos.crearJLabel(36, 175, 150, 20, "Lugar de nacimiento:",false);
        Panel.add(label_LugarNacimento);

        final JTextField text_LugarNacimento = Elementos.crearJTextField(190,175, 150, 20, "",true);
        Panel.add(text_LugarNacimento);

        final JLabel label_Estado = Elementos.crearJLabel(345, 175, 80, 20, "Estado:", false);
        Panel.add(label_Estado);

        final JTextField texto_Estado = Elementos.crearJTextField(400, 175, 100, 20, "", true);
        Panel.add(texto_Estado);

        


        //FONDO
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/NHM_part1-claro.png")));
        fondo.setBounds(0, 0,1290, 720);
        Panel.add(fondo);

    }
    public static void main(String[] args) {
        NHM_part1 hnm_part1 = new NHM_part1();
        hnm_part1.setVisible(true);
    }
}
