package com.usd89.registro;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class NHM_part1 extends JFrame {
    public NHM_part1() {
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

        // PRIMERA FILA
        int fila_x = 36;
        final JLabel label_apellido_familiar = Elementos.crearJLabel(fila_x, 65, 150, 20, "Apellido de tu familia:",
                false);
        fila_x += label_apellido_familiar.getWidth();
        Panel.add(label_apellido_familiar);

        final JTextField text_apellido_familiar = Elementos.crearJTextField(fila_x + 5, 65, 150, 20, "", true);
        fila_x += text_apellido_familiar.getWidth();
        Panel.add(text_apellido_familiar);

        final JLabel label_ci_jefe_familia = Elementos.crearJLabel(fila_x + 15, 65, 130, 20, "C.I Jefe de familia:",
                false);
        fila_x += label_ci_jefe_familia.getWidth();
        Panel.add(label_ci_jefe_familia);

        final JTextField text_ci_jefe_familia = Elementos.crearJTextField(fila_x + 15, 65, 150, 20, "", true);
        fila_x += text_ci_jefe_familia.getWidth();
        Panel.add(text_ci_jefe_familia);

        final JLabel Label_Numero_de_Historia = Elementos.crearJLabel(fila_x + 25, 65, 130, 20, "C.I Jefe de familia:",
                false);
        fila_x += Label_Numero_de_Historia.getWidth();
        Panel.add(Label_Numero_de_Historia);

        final JTextField text_Numero_de_Historia = Elementos.crearJTextField(fila_x + 25, 65, 150, 20, "", true);
        fila_x += text_Numero_de_Historia.getWidth();
        Panel.add(text_Numero_de_Historia);

        // Segunda linea
        final JLabel Label_ci = Elementos.crearJLabel(36, 95, 20, 20, "CI", false);
        Panel.add(Label_ci);
        final JComboBox<String> ci_ComboBox = new JComboBox<String>(new String[] { "V", "E" });
        ci_ComboBox.setBounds(61, 95, 40, 20);
        Panel.add(ci_ComboBox);

        final JTextField text_ci = Elementos.crearJTextField(105, 95, 150, 20, "", true);
        Panel.add(text_ci);

        final JLabel label_apellido = Elementos.crearJLabel(270, 95, 70, 20, "Apellido:", false);
        Panel.add(label_apellido);

        final JTextField text_apellido = Elementos.crearJTextField(335, 95, 150, 20, "", true);
        Panel.add(text_apellido);

        final JLabel label_nombre = Elementos.crearJLabel(500, 95, 65, 20, "Nombre:", false);
        Panel.add(label_nombre);

        final JTextField text_nombre = Elementos.crearJTextField(565, 95, 130, 20, "", true);
        Panel.add(text_nombre);

        final JLabel label_estadoCivil = Elementos.crearJLabel(700, 95, 90, 20, "Estado civil:", false);
        Panel.add(label_estadoCivil);

        final JComboBox<String> ComboBox_estadoCivil = new JComboBox<String>(new String[] { "S", "C", "V", "D", "O" });
        ComboBox_estadoCivil.setBounds(790, 95, 50, 20);
        Panel.add(ComboBox_estadoCivil);

        final JLabel label_Ocupacion = Elementos.crearJLabel(860, 95, 80, 20, "Ocupacion:", false);
        Panel.add(label_Ocupacion);

        final JTextField text_Ocupacion = Elementos.crearJTextField(943, 95, 100, 20, "", true);
        Panel.add(text_Ocupacion);

        // Tercera linea
        final JLabel label_Estudios = Elementos.crearJLabel(36, 125, 80, 20, "Estudios:", false);
        Panel.add(label_Estudios);

        final JComboBox<String> combo_estudio = new JComboBox<String>(new String[] { "P", "S", "U", "O" });
        combo_estudio.setBounds(110, 125, 50, 20);
        Panel.add(combo_estudio);

        final JLabel label_anosAprovados = Elementos.crearJLabel(170, 125, 120, 20, "Años aprovados:", false);
        Panel.add(label_anosAprovados);

        final JTextField text_anosAprovados = Elementos.crearJTextField(295, 125, 80, 20, "", true);
        Panel.add(text_anosAprovados);

        final JLabel label_Analfabeta = Elementos.crearJLabel(380, 125, 80, 20, "Analfabeta:", false);
        Panel.add(label_Analfabeta);

        final JComboBox<String> combo_Analfabeta = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Analfabeta.setBounds(465, 125, 50, 20);
        Panel.add(combo_Analfabeta);

        final JLabel label_Sexo = Elementos.crearJLabel(525, 125, 50, 20, "Sexo:", false);
        Panel.add(label_Sexo);

        final JComboBox<String> combo_sexo = new JComboBox<String>(new String[] { "F", "M" });
        combo_sexo.setBounds(575, 125, 50, 20);
        Panel.add(combo_sexo);

        // FECHA DE NACIMIENTO
        final JLabel label_fechaNacimiento = Elementos.crearJLabel(630, 125, 130, 20, "Fecha nacimiento:", false);
        Panel.add(label_fechaNacimiento);

        final JTextField text_NDia = Elementos.crearJTextField(765, 125, 50, 20, "DD", true);
        final JTextField text_NMes = Elementos.crearJTextField(815, 125, 50, 20, "MM", true);
        final JTextField text_NaAno = Elementos.crearJTextField(865, 125, 50, 20, "AA", true);
        Panel.add(text_NDia);
        Panel.add(text_NMes);
        Panel.add(text_NaAno);

        final JLabel label_LugarNacimento = Elementos.crearJLabel(36, 175, 150, 20, "Lugar de nacimiento:", false);
        Panel.add(label_LugarNacimento);

        final JTextField text_LugarNacimento = Elementos.crearJTextField(190, 175, 150, 20, "", true);
        Panel.add(text_LugarNacimento);

        final JLabel label_Estado = Elementos.crearJLabel(345, 175, 80, 20, "Estado:", false);
        Panel.add(label_Estado);

        final JTextField texto_Estado = Elementos.crearJTextField(400, 175, 100, 20, "", true);
        Panel.add(texto_Estado);

        final JLabel label_Pais = Elementos.crearJLabel(505, 175, 40, 20, "Pais:", false);
        Panel.add(label_Pais);

        final JTextField texto_Pais = Elementos.crearJTextField(545, 175, 100, 20, "", true);
        Panel.add(texto_Pais);

        final JLabel label_Dirrecion = Elementos.crearJLabel(650, 175, 80, 20, "Dirrecion:", false);
        Panel.add(label_Dirrecion);

        final JTextField texto_Dirrecion = Elementos.crearJTextField(725, 175, 325, 20, "", true);
        Panel.add(texto_Dirrecion);

        // Cuarta linea
        fila_x = 36;
        final JLabel label_Telefono = Elementos.crearJLabel(fila_x, 205, 70, 20, "Telefono:", false);
        fila_x += label_Telefono.getWidth();
        Panel.add(label_Telefono);

        final JTextField texto_Telefono = Elementos.crearJTextField(fila_x + 5, 205, 100, 20, "", true);
        fila_x += texto_Telefono.getWidth();
        Panel.add(texto_Telefono);

        final JLabel label_Religion = Elementos.crearJLabel(fila_x + 15, 205, 70, 20, "Religion:", false);
        fila_x += label_Religion.getWidth();
        Panel.add(label_Religion);

        final JTextField texto_Religion = Elementos.crearJTextField(fila_x + 15, 205, 100, 20, "", true);
        fila_x += texto_Religion.getWidth();
        Panel.add(texto_Religion);

        final JLabel label_Establecimiento = Elementos.crearJLabel(fila_x + 25, 205, 120, 20, "Establecimiento:",
                false);
        fila_x += label_Establecimiento.getWidth();
        Panel.add(label_Establecimiento);

        final JTextField texto_Establecimiento = Elementos.crearJTextField(fila_x + 25, 205, 110, 20, "", true);
        fila_x += texto_Establecimiento.getWidth();
        Panel.add(texto_Establecimiento);

        final JLabel label_Municipio = Elementos.crearJLabel(fila_x + 35, 205, 80, 20, "Municipio:", false);
        fila_x += label_Municipio.getWidth();
        Panel.add(label_Municipio);

        final JTextField texto_Municipio = Elementos.crearJTextField(fila_x + 35, 205, 120, 20, "", true);
        fila_x += texto_Municipio.getWidth();
        Panel.add(texto_Municipio);

        final JLabel label_Parroquia = Elementos.crearJLabel(fila_x + 45, 205, 80, 20, "Parroquia:", false);
        fila_x += label_Parroquia.getWidth();
        Panel.add(label_Parroquia);

        final JTextField texto_Parroquia = Elementos.crearJTextField(fila_x + 45, 205, 120, 20, "", true);
        fila_x += texto_Parroquia.getWidth();
        Panel.add(texto_Parroquia);

        // Quinta linea
        fila_x = 36;
        final JLabel label_Comunidad = Elementos.crearJLabel(fila_x, 235, 85, 20, "Comunidad:", false);
        fila_x += label_Comunidad.getWidth();
        Panel.add(label_Comunidad);

        final JTextField texto_Comunidad = Elementos.crearJTextField(fila_x + 5, 235, 120, 20, "", true);
        fila_x += texto_Comunidad.getWidth();
        Panel.add(texto_Comunidad);

        // Sextima linea
        fila_x = 36;
        final JLabel label_Madre_N_A = Elementos.crearJLabel(fila_x, 310, 220, 20, "Nombre y apellido de la madre:",
                false);
        fila_x += label_Madre_N_A.getWidth();
        Panel.add(label_Madre_N_A);

        final JTextField texto_Madre_N_A = Elementos.crearJTextField(fila_x + 5, 310, 200, 20, "", true);
        fila_x += texto_Madre_N_A.getWidth();
        Panel.add(texto_Madre_N_A);

        final JLabel label_Madre_Ocupacion = Elementos.crearJLabel(fila_x + 15, 310, 85, 20, "Ocupacion:", false);
        fila_x += label_Madre_Ocupacion.getWidth();
        Panel.add(label_Madre_Ocupacion);

        final JTextField texto_Madre_Ocupacion = Elementos.crearJTextField(fila_x + 15, 310, 100, 20, "", true);
        fila_x += texto_Madre_Ocupacion.getWidth();
        Panel.add(texto_Madre_Ocupacion);

        // Octaba linea
        fila_x = 36;
        final JLabel label_Padre_N_A = Elementos.crearJLabel(fila_x, 335, 220, 20, "Nombre y apellido de la padre:",
                false);
        fila_x += label_Padre_N_A.getWidth();
        Panel.add(label_Padre_N_A);

        final JTextField texto_Padre_N_A = Elementos.crearJTextField(fila_x + 5, 335, 200, 20, "", true);
        fila_x += texto_Padre_N_A.getWidth();
        Panel.add(texto_Padre_N_A);

        final JLabel label_Padre_Ocupacion = Elementos.crearJLabel(fila_x + 15, 335, 85, 20, "Ocupacion:", false);
        fila_x += label_Padre_Ocupacion.getWidth();
        Panel.add(label_Padre_Ocupacion);

        final JTextField texto_Padre_Ocupacion = Elementos.crearJTextField(fila_x + 15, 335, 100, 20, "", true);
        fila_x += texto_Padre_Ocupacion.getWidth();
        Panel.add(texto_Padre_Ocupacion);

        // Nobena linea
        fila_x = 36;
        final JLabel label_Representante = Elementos.crearJLabel(fila_x, 360, 110, 20, "Representante:", false);
        fila_x += label_Representante.getWidth();
        Panel.add(label_Representante);

        final JComboBox<String> combo_Representante = new JComboBox<String>(new String[] { "Padre", "Madre", "Otros" });
        combo_Representante.setBounds(fila_x + 5, 360, 80, 20);
        fila_x += combo_Representante.getWidth();
        Panel.add(combo_Representante);

        final JLabel label_Representante_N = Elementos.crearJLabel(fila_x + 15, 360, 70, 20, "Nombre:", false);
        fila_x += label_Representante_N.getWidth();
        Panel.add(label_Representante_N);

        final JTextField texto_Representante_N = Elementos.crearJTextField(fila_x + 10, 360, 100, 20, "", true);
        fila_x += texto_Representante_N.getWidth();
        Panel.add(texto_Representante_N);

        final JLabel label_Representante_ci = Elementos.crearJLabel(fila_x + 20, 360, 60, 20, "Cedula:", false);
        fila_x += label_Representante_ci.getWidth();
        Panel.add(label_Representante_ci);

        final JComboBox<String> combo__Representante_ci = new JComboBox<String>(new String[] { "V", "E" });
        combo__Representante_ci.setBounds(fila_x + 25, 360, 40, 20);
        fila_x += combo__Representante_ci.getWidth();
        Panel.add(combo__Representante_ci);

        final JTextField texto_Representante_ci = Elementos.crearJTextField(fila_x + 25, 360, 100, 20, "", true);
        fila_x += texto_Representante_ci.getWidth();
        Panel.add(texto_Representante_ci);

        final JLabel label_Representante_Telefono = Elementos.crearJLabel(fila_x + 35, 360, 70, 20, "Telefono:", false);
        fila_x += label_Representante_Telefono.getWidth();
        Panel.add(label_Representante_Telefono);

        final JTextField texto_Representante_Telefono = Elementos.crearJTextField(fila_x + 35, 360, 100, 20, "", true);
        fila_x += texto_Representante_Telefono.getWidth();
        Panel.add(texto_Representante_Telefono);

        //  Antecedentes perinatales en menores de 12 años
        fila_x=36;
        final JLabel label_CarnetPrenatal = Elementos.crearJLabel(fila_x , 470, 180, 20, "Carnet prenatal:", false);
        fila_x += label_CarnetPrenatal.getWidth();
        Panel.add(label_CarnetPrenatal);
        
        final JComboBox<String> combo_Carnet_prenatal = new JComboBox<String>(new String[] {"Si","No"});
        combo_Carnet_prenatal.setBounds(fila_x + 5, 470, 40, 20);
        fila_x += combo_Carnet_prenatal.getWidth();
        Panel.add(combo_Carnet_prenatal);

        fila_x=36;
        final JLabel label_patologiaEmbarazo = Elementos.crearJLabel(fila_x , 500, 180, 20, "Patologia embarazo:", false);
        fila_x += label_patologiaEmbarazo.getWidth();
        Panel.add(label_patologiaEmbarazo);
        
        final JComboBox<String>  combo_patologiaEmbarazo = new JComboBox<String>(new String[] {"Si","No"});
        combo_patologiaEmbarazo.setBounds(fila_x + 5, 500, 40, 20);
        fila_x += combo_patologiaEmbarazo.getWidth();
        Panel.add(combo_patologiaEmbarazo);

        final JLabel label_Hrs_fuera_de_casa = Elementos.crearJLabel(fila_x + 30, 500, 160, 20, "Hrs fuera de casa:", false);
        fila_x += label_Hrs_fuera_de_casa.getWidth();
        Panel.add(label_Hrs_fuera_de_casa);

        final JTextField texto_Hrs_fuera_de_casa = Elementos.crearJTextField(fila_x + 5, 500, 50, 20, "", true);
        fila_x += texto_Hrs_fuera_de_casa.getWidth();
        Panel.add(texto_Hrs_fuera_de_casa);

        final JLabel label_MadreFamilia = Elementos.crearJLabel(fila_x +40, 500, 80, 20, "Madre:", false);
        fila_x += label_MadreFamilia.getWidth();
        Panel.add(label_MadreFamilia);
        
        final JComboBox<String>  combo_MadreFamilia = new JComboBox<String>(new String[] {"Si","No"});
        combo_MadreFamilia.setBounds(fila_x + 25, 500, 40, 20);
        fila_x += combo_MadreFamilia.getWidth();
        Panel.add(combo_MadreFamilia);

        
        fila_x=36;
        final JLabel label_patologiaParto = Elementos.crearJLabel(fila_x , 530, 180, 20, "Patologia parto:", false);
        fila_x += label_patologiaParto.getWidth();
        Panel.add(label_patologiaParto);
        
        final JComboBox<String> combo_patologiaParto = new JComboBox<String>(new String[] {"Si","No"});
        combo_patologiaParto.setBounds(fila_x + 5, 530, 40, 20);
        fila_x += combo_patologiaParto.getWidth();
        Panel.add(combo_patologiaParto);

        final JLabel label_PadreFamilia = Elementos.crearJLabel(fila_x +250, 530, 80, 20, "Padre:", false);
        fila_x += label_PadreFamilia.getWidth();
        Panel.add(label_PadreFamilia);
        
        final JComboBox<String>  combo_PadreFamilia = new JComboBox<String>(new String[] {"Si","No"});
        combo_PadreFamilia.setBounds(fila_x + 225, 530, 40, 20);
        fila_x += combo_PadreFamilia.getWidth();
        Panel.add(combo_PadreFamilia);

        fila_x=36;
        final JLabel label_patologiaPuerperio = Elementos.crearJLabel(fila_x , 560, 180, 20, "Patologia puerperio:", false);
        fila_x += label_patologiaPuerperio.getWidth();
        Panel.add(label_patologiaPuerperio);
        
        final JComboBox<String> combo_patologiaPuerperio = new JComboBox<String>(new String[] {"Si","No"});
        combo_patologiaPuerperio.setBounds(fila_x + 5, 560, 40, 20);
        fila_x += combo_patologiaPuerperio.getWidth();
        Panel.add(combo_patologiaPuerperio);

        final JLabel label_HermanoFamilia = Elementos.crearJLabel(fila_x +250, 560, 80, 20, "Hermano:", false);
        fila_x += label_HermanoFamilia.getWidth();
        Panel.add(label_HermanoFamilia);
        
        final JComboBox<String>  combo_HermanoFamilia = new JComboBox<String>(new String[] {"Si","No"});
        combo_HermanoFamilia.setBounds(fila_x + 245, 560, 40, 20);
        fila_x += combo_HermanoFamilia.getWidth();
        Panel.add(combo_HermanoFamilia);

        fila_x=36;
        final JLabel texto_NConsultasPrenatales = Elementos.crearJLabel(fila_x , 590, 180, 20, "N~ Consultas prenatales:", false);
        fila_x += texto_NConsultasPrenatales.getWidth();
        Panel.add(texto_NConsultasPrenatales);
        
        final JComboBox<String> combo_NConsultasPrenatales = new JComboBox<String>(new String[] {"Si","No"});
        combo_NConsultasPrenatales.setBounds(fila_x + 5, 590, 40, 20);
        fila_x += combo_NConsultasPrenatales.getWidth();
        Panel.add(combo_NConsultasPrenatales);

        final JLabel label_OtrosFamilia = Elementos.crearJLabel(fila_x +250, 590, 80, 20, "Otros:", false);
        fila_x += label_OtrosFamilia.getWidth();
        Panel.add(label_OtrosFamilia);
        
        final JComboBox<String>  combo_OtrosFamilia = new JComboBox<String>(new String[] {"Si","No"});
        combo_OtrosFamilia.setBounds(fila_x + 225, 590, 40, 20);
        fila_x += combo_OtrosFamilia.getWidth();
        Panel.add(combo_OtrosFamilia);



        // Boton Gestion de Usuario
        final JLabel volverButton = new JLabel("VOLVER AL INICIO", Elementos.botonImagen(Inicio.Tema,"pequeno.0"), SwingConstants.CENTER);
        volverButton.setBounds(20, 650, 308, 67);
        volverButton.setFont(new Font("Roboto Black", 1, 22));
        volverButton.setForeground(Elementos.colores(Inicio.Tema));
        volverButton.setVerticalTextPosition(SwingConstants.CENTER);
        volverButton.setHorizontalTextPosition(SwingConstants.CENTER);

        volverButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Menu Menu = new Menu();
                Menu.setVisible(true);
                dispose();
            }

            public void mouseEntered(MouseEvent e) {
                volverButton.setIcon(Elementos.botonImagen(Inicio.Tema,"pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                volverButton.setIcon(Elementos.botonImagen(Inicio.Tema,"pequeno.0"));
            }
        });
        Panel.add(volverButton);


    /*   JTextField[] textFieldNames = {
                text_apellido_familiar,
                text_ci_jefe_familia,
                text_Numero_de_Historia,
                text_ci,
                text_apellido,
                text_nombre,
                text_Ocupacion,
                text_anosAprovados,
                text_LugarNacimento,
                texto_Estado,
                texto_Pais,
                texto_Dirrecion,
                texto_Telefono,
                texto_Religion,
                texto_Establecimiento,
                texto_Municipio,
                texto_Parroquia,
                texto_Comunidad,
                texto_Madre_N_A,
                texto_Madre_Ocupacion,
                texto_Padre_N_A,
                texto_Padre_Ocupacion,
                texto_Representante_N,
                texto_Representante_ci,
                texto_Representante_Telefono
        };
        for (final JTextField JTextField : textFieldNames) {
            JTextField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTextField.setBackground(Color.red);
            }
            
            });
            
        } */

        // FONDO
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/NHM_part1-claro.png")));
        fondo.setBounds(0, 0, 1290, 720);
        Panel.add(fondo);
    }

    public static void main(String[] args) {
        NHM_part1 hnm_part1 = new NHM_part1();
        hnm_part1.setVisible(true);
    }
}
