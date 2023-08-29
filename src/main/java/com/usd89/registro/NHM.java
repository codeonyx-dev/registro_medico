package com.usd89.registro;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class NHM {
    private JFrame frame;

    public NHM() {
        frame = new JFrame("Expediente Médico");
        frame.setSize(1120, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 30, 20));
        frame.setLocationRelativeTo(null);

        final JPanel contentPane = new JPanel();
        final CardLayout cardLayout = new CardLayout();

        contentPane.setLayout(cardLayout);

        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();

        frame.add(contentPane, BorderLayout.CENTER);
        frame.setVisible(true);
    
    
        Panel1.setLayout(null);
        Panel1.setBounds(0, 0, 1120, 720);
        frame.add(Panel1);

        // Cerrar ventana
        final JLabel Cerrar = Elementos.cerrar(1090, 10, 20, 20);
        Panel1.add(Cerrar);
        Cerrar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose(); // Cierra la ventana
            }

            public void mouseEntered(MouseEvent e) {
                Cerrar.setForeground(Color.RED);
            }

            public void mouseExited(MouseEvent e) {
                Cerrar.setForeground(Color.WHITE);
            }
        });

        // Minimizar
        final JLabel Minimizar = Elementos.minimizar(1070, 10, 20, 20);
        Panel1.add(Minimizar);
        Minimizar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.setExtendedState(1);
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
        Panel1.add(label_apellido_familiar);

        final JTextField text_apellido_familiar = Elementos.crearJTextField(fila_x + 5, 65, 150, 20, "", true);
        fila_x += text_apellido_familiar.getWidth();
        Panel1.add(text_apellido_familiar);

        final JLabel label_ci_jefe_familia = Elementos.crearJLabel(fila_x + 15, 65, 130, 20, "C.I Jefe de familia:",
                false);
        fila_x += label_ci_jefe_familia.getWidth();
        Panel1.add(label_ci_jefe_familia);

        final JTextField text_ci_jefe_familia = Elementos.crearJTextField(fila_x + 15, 65, 150, 20, "", true);
        fila_x += text_ci_jefe_familia.getWidth();
        Panel1.add(text_ci_jefe_familia);

        final JLabel Label_Numero_de_Historia = Elementos.crearJLabel(fila_x + 25, 65, 130, 20, "C.I Jefe de familia:",
                false);
        fila_x += Label_Numero_de_Historia.getWidth();
        Panel1.add(Label_Numero_de_Historia);

        final JTextField text_Numero_de_Historia = Elementos.crearJTextField(fila_x + 25, 65, 150, 20, "", true);
        fila_x += text_Numero_de_Historia.getWidth();
        Panel1.add(text_Numero_de_Historia);

        // Segunda linea
        final JLabel Label_ci = Elementos.crearJLabel(36, 95, 20, 20, "CI", false);
        Panel1.add(Label_ci);
        final JComboBox<String> ci_ComboBox = new JComboBox<String>(new String[] { "V", "E" });
        ci_ComboBox.setBounds(61, 95, 40, 20);
        Panel1.add(ci_ComboBox);

        final JTextField text_ci = Elementos.crearJTextField(105, 95, 150, 20, "", true);
        Panel1.add(text_ci);

        final JLabel label_apellido = Elementos.crearJLabel(270, 95, 70, 20, "Apellido:", false);
        Panel1.add(label_apellido);

        final JTextField text_apellido = Elementos.crearJTextField(335, 95, 150, 20, "", true);
        Panel1.add(text_apellido);

        final JLabel label_nombre = Elementos.crearJLabel(500, 95, 65, 20, "Nombre:", false);
        Panel1.add(label_nombre);

        final JTextField text_nombre = Elementos.crearJTextField(565, 95, 130, 20, "", true);
        Panel1.add(text_nombre);

        final JLabel label_estadoCivil = Elementos.crearJLabel(700, 95, 90, 20, "Estado civil:", false);
        Panel1.add(label_estadoCivil);

        final JComboBox<String> ComboBox_estadoCivil = new JComboBox<String>(new String[] { "S", "C", "V", "D", "O" });
        ComboBox_estadoCivil.setBounds(790, 95, 50, 20);
        Panel1.add(ComboBox_estadoCivil);

        final JLabel label_Ocupacion = Elementos.crearJLabel(860, 95, 80, 20, "Ocupacion:", false);
        Panel1.add(label_Ocupacion);

        final JTextField text_Ocupacion = Elementos.crearJTextField(943, 95, 100, 20, "", true);
        Panel1.add(text_Ocupacion);

        // Tercera linea
        final JLabel label_Estudios = Elementos.crearJLabel(36, 125, 80, 20, "Estudios:", false);
        Panel1.add(label_Estudios);

        final JComboBox<String> combo_estudio = new JComboBox<String>(new String[] { "P", "S", "U", "O" });
        combo_estudio.setBounds(110, 125, 50, 20);
        Panel1.add(combo_estudio);

        final JLabel label_anosAprovados = Elementos.crearJLabel(170, 125, 120, 20, "Años aprovados:", false);
        Panel1.add(label_anosAprovados);

        final JTextField text_anosAprovados = Elementos.crearJTextField(295, 125, 80, 20, "", true);
        Panel1.add(text_anosAprovados);

        final JLabel label_Analfabeta = Elementos.crearJLabel(380, 125, 80, 20, "Analfabeta:", false);
        Panel1.add(label_Analfabeta);

        final JComboBox<String> combo_Analfabeta = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Analfabeta.setBounds(465, 125, 50, 20);
        Panel1.add(combo_Analfabeta);

        final JLabel label_Sexo = Elementos.crearJLabel(525, 125, 50, 20, "Sexo:", false);
        Panel1.add(label_Sexo);

        final JComboBox<String> combo_sexo = new JComboBox<String>(new String[] { "F", "M" });
        combo_sexo.setBounds(575, 125, 50, 20);
        Panel1.add(combo_sexo);

        // FECHA DE NACIMIENTO
        final JLabel label_fechaNacimiento = Elementos.crearJLabel(630, 125, 130, 20, "Fecha nacimiento:", false);
        Panel1.add(label_fechaNacimiento);

        final JTextField text_NDia = Elementos.crearJTextField(765, 125, 50, 20, "DD", true);
        final JTextField text_NMes = Elementos.crearJTextField(815, 125, 50, 20, "MM", true);
        final JTextField text_NaAno = Elementos.crearJTextField(865, 125, 50, 20, "AA", true);
        Panel1.add(text_NDia);
        Panel1.add(text_NMes);
        Panel1.add(text_NaAno);

        final JLabel label_LugarNacimento = Elementos.crearJLabel(36, 175, 150, 20, "Lugar de nacimiento:", false);
        Panel1.add(label_LugarNacimento);

        final JTextField text_LugarNacimento = Elementos.crearJTextField(190, 175, 150, 20, "", true);
        Panel1.add(text_LugarNacimento);

        final JLabel label_Estado = Elementos.crearJLabel(345, 175, 80, 20, "Estado:", false);
        Panel1.add(label_Estado);

        final JTextField texto_Estado = Elementos.crearJTextField(400, 175, 100, 20, "", true);
        Panel1.add(texto_Estado);

        final JLabel label_Pais = Elementos.crearJLabel(505, 175, 40, 20, "Pais:", false);
        Panel1.add(label_Pais);

        final JTextField texto_Pais = Elementos.crearJTextField(545, 175, 100, 20, "", true);
        Panel1.add(texto_Pais);

        final JLabel label_Dirrecion = Elementos.crearJLabel(650, 175, 80, 20, "Dirrecion:", false);
        Panel1.add(label_Dirrecion);

        final JTextField texto_Dirrecion = Elementos.crearJTextField(725, 175, 325, 20, "", true);
        Panel1.add(texto_Dirrecion);

        // Cuarta linea
        fila_x = 36;
        final JLabel label_Telefono = Elementos.crearJLabel(fila_x, 205, 70, 20, "Telefono:", false);
        fila_x += label_Telefono.getWidth();
        Panel1.add(label_Telefono);

        final JTextField texto_Telefono = Elementos.crearJTextField(fila_x + 5, 205, 100, 20, "", true);
        fila_x += texto_Telefono.getWidth();
        Panel1.add(texto_Telefono);

        final JLabel label_Religion = Elementos.crearJLabel(fila_x + 15, 205, 70, 20, "Religion:", false);
        fila_x += label_Religion.getWidth();
        Panel1.add(label_Religion);

        final JTextField texto_Religion = Elementos.crearJTextField(fila_x + 15, 205, 100, 20, "", true);
        fila_x += texto_Religion.getWidth();
        Panel1.add(texto_Religion);

        final JLabel label_Establecimiento = Elementos.crearJLabel(fila_x + 25, 205, 120, 20, "Establecimiento:",
                false);
        fila_x += label_Establecimiento.getWidth();
        Panel1.add(label_Establecimiento);

        final JTextField texto_Establecimiento = Elementos.crearJTextField(fila_x + 25, 205, 110, 20, "", true);
        fila_x += texto_Establecimiento.getWidth();
        Panel1.add(texto_Establecimiento);

        final JLabel label_Municipio = Elementos.crearJLabel(fila_x + 35, 205, 80, 20, "Municipio:", false);
        fila_x += label_Municipio.getWidth();
        Panel1.add(label_Municipio);

        final JTextField texto_Municipio = Elementos.crearJTextField(fila_x + 35, 205, 120, 20, "", true);
        fila_x += texto_Municipio.getWidth();
        Panel1.add(texto_Municipio);

        final JLabel label_Parroquia = Elementos.crearJLabel(fila_x + 45, 205, 80, 20, "Parroquia:", false);
        fila_x += label_Parroquia.getWidth();
        Panel1.add(label_Parroquia);

        final JTextField texto_Parroquia = Elementos.crearJTextField(fila_x + 45, 205, 120, 20, "", true);
        fila_x += texto_Parroquia.getWidth();
        Panel1.add(texto_Parroquia);

        // Quinta linea
        fila_x = 36;
        final JLabel label_Comunidad = Elementos.crearJLabel(fila_x, 235, 85, 20, "Comunidad:", false);
        fila_x += label_Comunidad.getWidth();
        Panel1.add(label_Comunidad);

        final JTextField texto_Comunidad = Elementos.crearJTextField(fila_x + 5, 235, 120, 20, "", true);
        fila_x += texto_Comunidad.getWidth();
        Panel1.add(texto_Comunidad);

        // Sextima linea
        fila_x = 36;
        final JLabel label_Madre_N_A = Elementos.crearJLabel(fila_x, 310, 220, 20, "Nombre y apellido de la madre:",
                false);
        fila_x += label_Madre_N_A.getWidth();
        Panel1.add(label_Madre_N_A);

        final JTextField texto_Madre_N_A = Elementos.crearJTextField(fila_x + 5, 310, 200, 20, "", true);
        fila_x += texto_Madre_N_A.getWidth();
        Panel1.add(texto_Madre_N_A);

        final JLabel label_Madre_Ocupacion = Elementos.crearJLabel(fila_x + 15, 310, 85, 20, "Ocupacion:", false);
        fila_x += label_Madre_Ocupacion.getWidth();
        Panel1.add(label_Madre_Ocupacion);

        final JTextField texto_Madre_Ocupacion = Elementos.crearJTextField(fila_x + 15, 310, 100, 20, "", true);
        fila_x += texto_Madre_Ocupacion.getWidth();
        Panel1.add(texto_Madre_Ocupacion);

        // Octaba linea
        fila_x = 36;
        final JLabel label_Padre_N_A = Elementos.crearJLabel(fila_x, 335, 220, 20, "Nombre y apellido de la padre:",
                false);
        fila_x += label_Padre_N_A.getWidth();
        Panel1.add(label_Padre_N_A);

        final JTextField texto_Padre_N_A = Elementos.crearJTextField(fila_x + 5, 335, 200, 20, "", true);
        fila_x += texto_Padre_N_A.getWidth();
        Panel1.add(texto_Padre_N_A);

        final JLabel label_Padre_Ocupacion = Elementos.crearJLabel(fila_x + 15, 335, 85, 20, "Ocupacion:", false);
        fila_x += label_Padre_Ocupacion.getWidth();
        Panel1.add(label_Padre_Ocupacion);

        final JTextField texto_Padre_Ocupacion = Elementos.crearJTextField(fila_x + 15, 335, 100, 20, "", true);
        fila_x += texto_Padre_Ocupacion.getWidth();
        Panel1.add(texto_Padre_Ocupacion);

        // Nobena linea
        fila_x = 36;
        final JLabel label_Representante = Elementos.crearJLabel(fila_x, 360, 110, 20, "Representante:", false);
        fila_x += label_Representante.getWidth();
        Panel1.add(label_Representante);

        final JComboBox<String> combo_Representante = new JComboBox<String>(new String[] { "Padre", "Madre", "Otros" });
        combo_Representante.setBounds(fila_x + 5, 360, 80, 20);
        fila_x += combo_Representante.getWidth();
        Panel1.add(combo_Representante);

        final JLabel label_Representante_N = Elementos.crearJLabel(fila_x + 15, 360, 70, 20, "Nombre:", false);
        fila_x += label_Representante_N.getWidth();
        Panel1.add(label_Representante_N);

        final JTextField texto_Representante_N = Elementos.crearJTextField(fila_x + 10, 360, 100, 20, "", true);
        fila_x += texto_Representante_N.getWidth();
        Panel1.add(texto_Representante_N);

        final JLabel label_Representante_ci = Elementos.crearJLabel(fila_x + 20, 360, 60, 20, "Cedula:", false);
        fila_x += label_Representante_ci.getWidth();
        Panel1.add(label_Representante_ci);

        final JComboBox<String> combo__Representante_ci = new JComboBox<String>(new String[] { "V", "E" });
        combo__Representante_ci.setBounds(fila_x + 25, 360, 40, 20);
        fila_x += combo__Representante_ci.getWidth();
        Panel1.add(combo__Representante_ci);

        final JTextField texto_Representante_ci = Elementos.crearJTextField(fila_x + 25, 360, 100, 20, "", true);
        fila_x += texto_Representante_ci.getWidth();
        Panel1.add(texto_Representante_ci);

        final JLabel label_Representante_Telefono = Elementos.crearJLabel(fila_x + 35, 360, 70, 20, "Telefono:", false);
        fila_x += label_Representante_Telefono.getWidth();
        Panel1.add(label_Representante_Telefono);

        final JTextField texto_Representante_Telefono = Elementos.crearJTextField(fila_x + 35, 360, 100, 20, "", true);
        fila_x += texto_Representante_Telefono.getWidth();
        Panel1.add(texto_Representante_Telefono);

        // Antecedentes perinatales en menores de 12 años
        fila_x = 36;
        final JLabel label_CarnetPrenatal = Elementos.crearJLabel(fila_x, 470, 180, 20, "Carnet prenatal:", false);
        fila_x += label_CarnetPrenatal.getWidth();
        Panel1.add(label_CarnetPrenatal);

        final JComboBox<String> combo_Carnet_prenatal = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Carnet_prenatal.setBounds(fila_x + 5, 470, 40, 20);
        fila_x += combo_Carnet_prenatal.getWidth();
        Panel1.add(combo_Carnet_prenatal);

        fila_x = 36;
        final JLabel label_patologiaEmbarazo = Elementos.crearJLabel(fila_x, 500, 180, 20, "Patologia embarazo:", false);
        fila_x += label_patologiaEmbarazo.getWidth();
        Panel1.add(label_patologiaEmbarazo);

        final JComboBox<String> combo_patologiaEmbarazo = new JComboBox<String>(new String[] { "Si", "No" });
        combo_patologiaEmbarazo.setBounds(fila_x + 5, 500, 40, 20);
        fila_x += combo_patologiaEmbarazo.getWidth();
        Panel1.add(combo_patologiaEmbarazo);

        final JLabel label_Hrs_fuera_de_casa = Elementos.crearJLabel(fila_x + 30, 500, 160, 20, "Hrs fuera de casa:",
                false);
        fila_x += label_Hrs_fuera_de_casa.getWidth();
        Panel1.add(label_Hrs_fuera_de_casa);

        final JTextField texto_Hrs_fuera_de_casa = Elementos.crearJTextField(fila_x + 5, 500, 50, 20, "", true);
        fila_x += texto_Hrs_fuera_de_casa.getWidth();
        Panel1.add(texto_Hrs_fuera_de_casa);

        final JLabel label_MadreFamilia = Elementos.crearJLabel(fila_x + 40, 500, 80, 20, "Madre:", false);
        fila_x += label_MadreFamilia.getWidth();
        Panel1.add(label_MadreFamilia);

        final JComboBox<String> combo_MadreFamilia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_MadreFamilia.setBounds(fila_x + 25, 500, 40, 20);
        fila_x += combo_MadreFamilia.getWidth();
        Panel1.add(combo_MadreFamilia);

        fila_x = 36;
        final JLabel label_patologiaParto = Elementos.crearJLabel(fila_x, 530, 180, 20, "Patologia parto:", false);
        fila_x += label_patologiaParto.getWidth();
        Panel1.add(label_patologiaParto);

        final JComboBox<String> combo_patologiaParto = new JComboBox<String>(new String[] { "Si", "No" });
        combo_patologiaParto.setBounds(fila_x + 5, 530, 40, 20);
        fila_x += combo_patologiaParto.getWidth();
        Panel1.add(combo_patologiaParto);

        final JLabel label_PadreFamilia = Elementos.crearJLabel(fila_x + 250, 530, 80, 20, "Padre:", false);
        fila_x += label_PadreFamilia.getWidth();
        Panel1.add(label_PadreFamilia);

        final JComboBox<String> combo_PadreFamilia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_PadreFamilia.setBounds(fila_x + 225, 530, 40, 20);
        fila_x += combo_PadreFamilia.getWidth();
        Panel1.add(combo_PadreFamilia);

        fila_x = 36;
        final JLabel label_patologiaPuerperio = Elementos.crearJLabel(fila_x, 560, 180, 20, "Patologia puerperio:", false);
        fila_x += label_patologiaPuerperio.getWidth();
        Panel1.add(label_patologiaPuerperio);

        final JComboBox<String> combo_patologiaPuerperio = new JComboBox<String>(new String[] { "Si", "No" });
        combo_patologiaPuerperio.setBounds(fila_x + 5, 560, 40, 20);
        fila_x += combo_patologiaPuerperio.getWidth();
        Panel1.add(combo_patologiaPuerperio);

        final JLabel label_HermanoFamilia = Elementos.crearJLabel(fila_x + 250, 560, 80, 20, "Hermano:", false);
        fila_x += label_HermanoFamilia.getWidth();
        Panel1.add(label_HermanoFamilia);

        final JComboBox<String> combo_HermanoFamilia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_HermanoFamilia.setBounds(fila_x + 245, 560, 40, 20);
        fila_x += combo_HermanoFamilia.getWidth();
        Panel1.add(combo_HermanoFamilia);

        fila_x = 36;
        final JLabel texto_NConsultasPrenatales = Elementos.crearJLabel(fila_x, 590, 180, 20, "N~ Consultas prenatales:", false);
        fila_x += texto_NConsultasPrenatales.getWidth();
        Panel1.add(texto_NConsultasPrenatales);

        final JComboBox<String> combo_NConsultasPrenatales = new JComboBox<String>(new String[] { "Si", "No" });
        combo_NConsultasPrenatales.setBounds(fila_x + 5, 590, 40, 20);
        fila_x += combo_NConsultasPrenatales.getWidth();
        Panel1.add(combo_NConsultasPrenatales);

        final JLabel label_OtrosFamilia = Elementos.crearJLabel(fila_x + 250, 590, 80, 20, "Otros:", false);
        fila_x += label_OtrosFamilia.getWidth();
        Panel1.add(label_OtrosFamilia);

        final JTextField text_OtrosFamilia = Elementos.crearJTextField(fila_x + 225, 590, 80, 20, "", true);
        fila_x += text_OtrosFamilia.getWidth();
        Panel1.add(text_OtrosFamilia);

        // Boton Volver al menu
        final JLabel volverButton = new JLabel("VOLVER AL INICIO", Elementos.botonImagen(Inicio.Tema, "pequeno.0"), SwingConstants.CENTER);
        volverButton.setBounds(20, 650, 308, 67);
        volverButton.setFont(new Font("Roboto Black", 1, 22));
        volverButton.setForeground(Elementos.colores(Inicio.Tema));
        volverButton.setVerticalTextPosition(SwingConstants.CENTER);
        volverButton.setHorizontalTextPosition(SwingConstants.CENTER);

        volverButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Menu Menu = new Menu();
                Menu.setVisible(true);
                frame.dispose();
            }

            public void mouseEntered(MouseEvent e) {
                volverButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                volverButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel1.add(volverButton);

        // Boton Limpiar datos
        final JLabel limpiarD_Button = new JLabel("LIMPIAR CAMPOS", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),SwingConstants.CENTER);
        limpiarD_Button.setBounds(400, 650, 308, 67);
        limpiarD_Button.setFont(new Font("Roboto Black", 1, 22));
        limpiarD_Button.setForeground(Elementos.colores(Inicio.Tema));
        limpiarD_Button.setVerticalTextPosition(SwingConstants.CENTER);
        limpiarD_Button.setHorizontalTextPosition(SwingConstants.CENTER);

        limpiarD_Button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTextField[] textFieldNames = {
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
                        texto_Representante_Telefono,
                        texto_Hrs_fuera_de_casa
                };
                for (final JTextField JTextField : textFieldNames) {
                    JTextField.setText("");
                }
            }

            public void mouseEntered(MouseEvent e) {
                limpiarD_Button.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                limpiarD_Button.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel1.add(limpiarD_Button);

        // Boton Siguiente
        final JLabel seguienteButton = new JLabel("SIGUIENTE", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),SwingConstants.CENTER);
        seguienteButton.setBounds(800, 650, 308, 67);
        seguienteButton.setFont(new Font("Roboto Black", 1, 22));
        seguienteButton.setForeground(Elementos.colores(Inicio.Tema));
        seguienteButton.setVerticalTextPosition(SwingConstants.CENTER);
        seguienteButton.setHorizontalTextPosition(SwingConstants.CENTER);

        seguienteButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTextField[] textFieldNames = {
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
                };
                // int datosfantates = 0;
                for (final JTextField JTextField : textFieldNames) {
                    if (JTextField.getText().isEmpty()) {
                        JTextField.setBackground(Color.red);
                        // datosfantates++;
                    }
                    cardLayout.show(contentPane, "panel2");

                    // if (datosfantates==0) {
                    // }
                }
            }

            public void mouseEntered(MouseEvent e) {
                seguienteButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                seguienteButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel1.add(seguienteButton);

        JTextField[] textFieldNames = {
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
                texto_Representante_Telefono,
                texto_Hrs_fuera_de_casa
        };

        for (final JTextField textField : textFieldNames) {
            textField.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    textField.setBackground(Color.white);
                }
            });
        }

        // FONDO
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/NHM_part1-claro.png")));
        fondo.setBounds(0, 0, 1290, 720);
        Panel1.add(fondo);
        contentPane.add(Panel1, "panel1");


//Segundo Panel

        Panel2.setLayout(null);
        Panel2.setBounds(0, 0, 1120, 720);
        frame.add(Panel2);
        // Cerrar ventana
        final JLabel cerrar2 = Elementos.cerrar(1090, 10, 20, 20);
        Panel2.add(cerrar2);
        cerrar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose(); // Cierra la ventana
            }

            public void mouseEntered(MouseEvent e) {
                cerrar2.setForeground(Color.RED);
            }

            public void mouseExited(MouseEvent e) {
                cerrar2.setForeground(Color.WHITE);
            }
        });

        // Minimizar
        final JLabel Minimizar2 = Elementos.minimizar(1070, 10, 20, 20);
        Panel2.add(Minimizar2);
        Minimizar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.setExtendedState(1);
            }

            public void mouseEntered(MouseEvent e) {
                Minimizar2.setForeground(Color.red);
            }

            public void mouseExited(MouseEvent e) {
                Minimizar2.setForeground(Color.white);
            }
        });

        // Edad_Gestacional *edad - Semanas

        int fila_x2 = 36;
        final JLabel label_Edad_Gestacional = Elementos.crearJLabel(fila_x2, 65, 130, 20, "Edad Gestacional:", false);
        fila_x2 += label_Edad_Gestacional.getWidth();
        Panel2.add(label_Edad_Gestacional);

        final JTextField text_Edad_Gestacional = Elementos.crearJTextField(fila_x2 + 5, 65, 50, 20, "", true);
        fila_x2 += text_Edad_Gestacional.getWidth();
        Panel2.add(text_Edad_Gestacional);

        final JLabel label_sem = Elementos.crearJLabel(fila_x2 + 10, 65, 80, 20, "Semanas:", false);
        fila_x2 += label_sem.getWidth();
        Panel2.add(label_sem);

        final JTextField text_sem = Elementos.crearJTextField(fila_x2 + 15, 65, 50, 20, "", true);
        fila_x2 += text_sem.getWidth();
        Panel2.add(text_sem);

        fila_x2 = 36;
        final JLabel label_Forceps = Elementos.crearJLabel(fila_x2, 95, 65, 20, "Forceps:", false);
        fila_x2 += label_Forceps.getWidth();
        Panel2.add(label_Forceps);

        final JComboBox<String> combo_Forceps = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Forceps.setBounds(fila_x2 + 5, 95, 50, 20);
        fila_x2 += combo_Forceps.getWidth();
        Panel2.add(combo_Forceps);

        final JLabel label_Cesarea = Elementos.crearJLabel(fila_x2 + 35, 95, 70, 20, "Cesarea:", false);
        fila_x2 += label_Cesarea.getWidth();
        Panel2.add(label_Cesarea);

        final JComboBox<String> combo_Cesarea = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Cesarea.setBounds(fila_x2 + 35, 95, 50, 20);
        fila_x2 += combo_Cesarea.getWidth();
        Panel2.add(combo_Cesarea);

        final JLabel label_Parto = Elementos.crearJLabel(fila_x2 + 65, 95, 50, 20, "Parto:", false);
        fila_x2 += label_Parto.getWidth();
        Panel2.add(label_Parto);

        final JComboBox<String> combo_Parto = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Parto.setBounds(fila_x2 + 65, 95, 50, 20);
        fila_x2 += combo_Parto.getWidth();
        Panel2.add(combo_Parto);

        final JLabel label_Peso_Al_Nacer = Elementos.crearJLabel(fila_x2 + 95, 95, 105, 20, "Peso al nacer:", false);
        fila_x2 += label_Peso_Al_Nacer.getWidth();
        Panel2.add(label_Peso_Al_Nacer);

        final JTextField text_Peso_al_nacer = Elementos.crearJTextField(fila_x2 + 95, 95, 50, 20, "", true);
        fila_x2 += text_Peso_al_nacer.getWidth();
        Panel2.add(text_Peso_al_nacer);

        final JLabel label_Peso_Al_Nacer_gr = Elementos.crearJLabel(fila_x2 + 100, 95, 20, 20, "gr", false);
        fila_x2 += label_Peso_Al_Nacer_gr.getWidth();
        Panel2.add(label_Peso_Al_Nacer_gr);

        final JLabel label_Talla = Elementos.crearJLabel(fila_x2 + 120, 95, 40, 20, "Talla:", false);
        fila_x2 += label_Talla.getWidth();
        Panel2.add(label_Talla);

        final JTextField text_Talla = Elementos.crearJTextField(fila_x2 + 120, 95, 50, 20, "", true);
        fila_x2 += text_Talla.getWidth();
        Panel2.add(text_Talla);

        final JLabel label_Talla_cm = Elementos.crearJLabel(fila_x2 + 125, 95, 20, 20, "cm", false);
        fila_x2 += label_Talla_cm.getWidth();
        Panel2.add(label_Talla_cm);

        final JLabel label_Circunferencia = Elementos.crearJLabel(fila_x2 + 150, 95, 170, 20, "Circunferencia cefalica:",
                false);
        fila_x2 += label_Circunferencia.getWidth();
        Panel2.add(label_Circunferencia);

        final JTextField text_Circunferencia = Elementos.crearJTextField(fila_x2 + 150, 95, 50, 20, "", true);
        fila_x2 += text_Circunferencia.getWidth();
        Panel2.add(text_Circunferencia);

        final JLabel label_Circunferencia_cm = Elementos.crearJLabel(fila_x2 + 155, 95, 20, 20, "cm", false);
        fila_x2 += label_Circunferencia_cm.getWidth();
        Panel2.add(label_Circunferencia_cm);

        // segunda linea
        fila_x2 = 36;
        final JLabel label_ApgarMin = Elementos.crearJLabel(fila_x2, 125, 80, 20,"Apgar min:", false);
        fila_x2 += label_ApgarMin.getWidth();
        Panel2.add(label_ApgarMin);

        final JTextField text_ApgarMin = Elementos.crearJTextField(fila_x2 + 5, 125,80, 20, "", true);
        fila_x2 += text_ApgarMin.getWidth();
        Panel2.add(text_ApgarMin);

        final JLabel label_Asfixia = Elementos.crearJLabel(fila_x2 + 35, 125, 60, 25, "Asfixia:",false);
        fila_x2 += label_Asfixia.getWidth();
        Panel2.add(label_Asfixia);
        
        final JComboBox<String> combo_Asfixia = new JComboBox<String>(new String[] {"Si", "No" });
        combo_Asfixia.setBounds(fila_x2 + 35, 125, 50, 20);
        fila_x2 += combo_Asfixia.getWidth();
        Panel2.add(combo_Asfixia);
        
        final JLabel label_Reanimacion = Elementos.crearJLabel(fila_x2+65, 125, 100,20, "Reanimacion:", false);
        fila_x2 += label_Reanimacion.getWidth();
        Panel2.add(label_Reanimacion);
        
        final JComboBox<String> combo_Reanimacion = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Reanimacion.setBounds(fila_x2 + 65, 125, 50, 20);
        fila_x2 += combo_Reanimacion.getWidth();
        Panel2.add(combo_Reanimacion);

        final JLabel label_PatologiasRN = Elementos.crearJLabel(fila_x2+95, 125, 110, 20, "Patologias RN:",false);
        fila_x2 += label_PatologiasRN.getWidth();
        Panel2.add(label_PatologiasRN);
        
        final JComboBox<String> combo_PatologiasRN = new JComboBox<String>(new String[] { "Si", "No" });
        combo_PatologiasRN.setBounds(fila_x2 + 95, 125, 50, 20);
        fila_x2 += combo_PatologiasRN.getWidth();
        Panel2.add(combo_PatologiasRN);
        
        final JLabel label_EngresoRN = Elementos.crearJLabel(fila_x2+125, 125, 100, 20,"Engreso RN:", false);
        fila_x2 += label_EngresoRN.getWidth();
        Panel2.add(label_EngresoRN);
        
        final JComboBox<String> combo_EngresoRN = new JComboBox<String>(new String[] { "Sanos", "Patologico" });
        combo_EngresoRN.setBounds(fila_x2 + 125,125, 95, 20);
        fila_x2 += combo_EngresoRN.getWidth();
        Panel2.add(combo_EngresoRN);

        // tercera linea
        fila_x2 = 36;
        final JLabel label_lamtancia = Elementos.crearJLabel(fila_x2, 160, 80, 20,"Lamtancia:", false);
        fila_x2 += label_lamtancia.getWidth();
        Panel2.add(label_lamtancia);

        final JLabel label_Exclusiva = Elementos.crearJLabel(fila_x2+30, 160, 80, 20,"Exclusiva:", false);
        fila_x2 += label_Exclusiva.getWidth();
        Panel2.add(label_Exclusiva);

        final JTextField text_Exclusiva = Elementos.crearJTextField(fila_x2 + 30, 160,80, 20, "", true);
        fila_x2 += text_Exclusiva.getWidth();
        Panel2.add(text_Exclusiva);

        final JLabel label_Exclusiva_m = Elementos.crearJLabel(fila_x2+35, 160, 20, 20,"m", false);
        fila_x2 += label_Exclusiva_m.getWidth();
        Panel2.add(label_Exclusiva_m);

        final JLabel label_Mixta = Elementos.crearJLabel(fila_x2+60, 160, 50, 20,"Mixta:", false);
        fila_x2 += label_Mixta.getWidth();
        Panel2.add(label_Mixta);

        final JTextField text_Mixta = Elementos.crearJTextField(fila_x2 + 60, 160,80, 20, "", true);
        fila_x2 += text_Mixta.getWidth();
        Panel2.add(text_Mixta);

        final JLabel label_Mixta_m = Elementos.crearJLabel(fila_x2+65, 160, 20, 20,"m", false);
        fila_x2 += label_Mixta_m.getWidth();
        Panel2.add(label_Mixta_m);

        final JLabel label_Ablactacion = Elementos.crearJLabel(fila_x2+90, 160, 90, 20,"Ablactacion:", false);
        fila_x2 += label_Ablactacion.getWidth();
        Panel2.add(label_Ablactacion);

        final JTextField text_Ablactacion = Elementos.crearJTextField(fila_x2 + 90, 160,80, 20, "", true);
        fila_x2 += text_Ablactacion.getWidth();
        Panel2.add(text_Ablactacion);

        final JLabel label_Ablactacion_m = Elementos.crearJLabel(fila_x2+95, 160, 20, 20,"m", false);
        fila_x2 += label_Ablactacion_m.getWidth();
        Panel2.add(label_Ablactacion_m);
        
        //Primera fila
        fila_x2=36; int fila_y =250;

        final JLabel label_Alergia = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Alergia:", false);
        fila_x2 += label_Alergia.getWidth();
        Panel2.add(label_Alergia);
        
        final JComboBox<String> combo_Alergia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Alergia.setBounds(fila_x2,fila_y, 50, 20);
        fila_x2 += combo_Alergia.getWidth();
        Panel2.add(combo_Alergia);

        fila_y=290; fila_x2=36;
        final JLabel label_Asma = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Asma:", false);
        fila_x2 += label_Asma.getWidth();
        Panel2.add(label_Asma);
        
        final JComboBox<String> combo_Asma = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Asma.setBounds(fila_x2,fila_y, 50, 20);
        fila_x2 += combo_Asma.getWidth();
        Panel2.add(combo_Asma);

        fila_y=330; fila_x2=36;
        final JLabel label_TBC = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"T.B.C:", false);
        fila_x2 += label_TBC.getWidth();
        Panel2.add(label_TBC);
        
        final JComboBox<String> combo_TBC = new JComboBox<String>(new String[] { "Si", "No" });
        combo_TBC.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_TBC.getWidth();
        Panel2.add(combo_TBC);

        fila_y=370; fila_x2=36;
        final JLabel label_Cardiopatia = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Cardiopatia:", false);
        fila_x2 += label_Cardiopatia.getWidth();
        Panel2.add(label_Cardiopatia);
        
        final JComboBox<String> combo_Cardiopatia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Cardiopatia.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Cardiopatia.getWidth();
        Panel2.add(combo_Cardiopatia);

        fila_y=410; fila_x2=36;
        final JLabel label_Hipertension = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Hipertension:", false);
        fila_x2 += label_Hipertension.getWidth();
        Panel2.add(label_Hipertension);
        
        final JComboBox<String> combo_Hipertension = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hipertension.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Hipertension.getWidth();
        Panel2.add(combo_Hipertension);

        fila_y=450; fila_x2=36;
        final JLabel label_Varice = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Varice:", false);
        fila_x2 += label_Varice.getWidth();
        Panel2.add(label_Varice);
        
        final JComboBox<String> combo_Varice = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Varice.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Varice.getWidth();
        Panel2.add(combo_Varice);

        fila_y=490; fila_x2=36; 
        final JLabel label_Desnutricion = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Desnutricion:", false);
        fila_x2 += label_Desnutricion.getWidth();
        Panel2.add(label_Desnutricion);
        
        final JComboBox<String> combo_Desnutricion = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Desnutricion.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Desnutricion.getWidth();
        Panel2.add(combo_Desnutricion);

        //Segunda fila
        fila_x2=220; fila_y=250;
        final JLabel label_Diabetes = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Diabetes:", false);
        fila_x2 += label_Diabetes.getWidth();
        Panel2.add(label_Diabetes);
        
        final JComboBox<String> combo_Diabetes = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Diabetes.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Diabetes.getWidth();
        Panel2.add(combo_Diabetes);

        fila_x2=220; fila_y=290;
        final JLabel label_Obesidad = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Obesidad:", false);
        fila_x2 += label_Obesidad.getWidth();
        Panel2.add(label_Obesidad);
        
        final JComboBox<String> combo_Obesidad = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Obesidad.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Obesidad.getWidth();
        Panel2.add(combo_Obesidad);

        fila_x2=220; fila_y=330;
        final JLabel label_Gastropatia = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Gastropatia:", false);
        fila_x2 += label_Gastropatia.getWidth();
        Panel2.add(label_Gastropatia);
        
        final JComboBox<String> combo_Gastropatia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Gastropatia.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Gastropatia.getWidth();
        Panel2.add(combo_Gastropatia);

        fila_x2=220; fila_y=370;
        final JLabel label_Neurologiaca = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Neurologiaca:", false);
        fila_x2 += label_Neurologiaca.getWidth();
        Panel2.add(label_Neurologiaca);
        
        final JComboBox<String> combo_Neurologiaca = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Neurologiaca.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Neurologiaca.getWidth();
        Panel2.add(combo_Neurologiaca);

        fila_x2=220; fila_y=410;
        final JLabel label_Enf_Renal = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Enf.Renal:", false);
        fila_x2 += label_Enf_Renal.getWidth();
        Panel2.add(label_Enf_Renal);
        
        final JComboBox<String> combo_Enf_Renal = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_Renal.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Enf_Renal.getWidth();
        Panel2.add(combo_Enf_Renal);

        fila_x2=220; fila_y=450;
        final JLabel label_Cancer = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Cancer:", false);
        fila_x2 += label_Cancer.getWidth();
        Panel2.add(label_Cancer);
        
        final JComboBox<String> combo_Cancer = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Cancer.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Cancer.getWidth();
        Panel2.add(combo_Cancer);

        fila_x2=220; fila_y=490;
        final JLabel label_Alcohol = Elementos.crearJLabel(fila_x2, fila_y, 100, 20,"Alcohol:", false);
        fila_x2 += label_Alcohol.getWidth();
        Panel2.add(label_Alcohol);
        
        final JComboBox<String> combo_Alcohol = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Alcohol.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Alcohol.getWidth();
        Panel2.add(combo_Alcohol);

        //Tercera fila
        fila_x2=400; fila_y=250;
        final JLabel label_Drogas = Elementos.crearJLabel(fila_x2, fila_y, 70, 20,"Drogas:", false);
        fila_x2 += label_Drogas.getWidth();
        Panel2.add(label_Drogas);
        
        final JComboBox<String> combo_Drogas = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Drogas.setBounds(fila_x2,fila_y, 50, 20);
        fila_x2 += combo_Drogas.getWidth();
        Panel2.add(combo_Drogas);

        fila_x2=400; fila_y=290;
        final JLabel label_Sifilis = Elementos.crearJLabel(fila_x2, fila_y, 70, 20,"Sifilis:", false);
        fila_x2 += label_Sifilis.getWidth();
        Panel2.add(label_Sifilis);
        
        final JComboBox<String> combo_Sifilis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Sifilis.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Sifilis.getWidth();
        Panel2.add(combo_Sifilis);

        fila_x2=400; fila_y=330;
        final JLabel label_SIDA = Elementos.crearJLabel(fila_x2, fila_y, 70, 20,"SIDA:", false);
        fila_x2 += label_SIDA.getWidth();
        Panel2.add(label_SIDA);
        
        final JComboBox<String> combo_SIDA = new JComboBox<String>(new String[] { "Si", "No" });
        combo_SIDA.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_SIDA.getWidth();
        Panel2.add(combo_SIDA);

        fila_x2=400; fila_y=370;
        final JLabel label_Artritis = Elementos.crearJLabel(fila_x2, fila_y, 70, 20,"Artritis:", false);
        fila_x2 += label_Artritis.getWidth();
        Panel2.add(label_Artritis);
        
        final JComboBox<String> combo_Artritis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Artritis.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Artritis.getWidth();
        Panel2.add(combo_Artritis);

        fila_x2=400; fila_y=410;
        final JLabel label_otros = Elementos.crearJLabel(fila_x2, fila_y, 70, 20,"Otros:", false);
        fila_x2 += label_otros.getWidth();
        Panel2.add(label_otros);
        
        final JComboBox<String> combo_otros = new JComboBox<String>(new String[] { "Si", "No" });
        combo_otros.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_otros.getWidth();
        Panel2.add(combo_otros);

        //Cuarta fila 
        fila_x2=600; fila_y=250;
        final JLabel label_Padre = Elementos.crearJLabel(fila_x2, fila_y, 50, 20,"Padre:", false);
        fila_x2 += label_Padre.getWidth();
        Panel2.add(label_Padre);
        
        final JComboBox<String> combo_Padre = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Padre.setBounds(fila_x2 , fila_y, 50, 20);
        fila_x2 += combo_Padre.getWidth();
        Panel2.add(combo_Padre);

        fila_x2=600; fila_y=290;
        final JLabel label_Madre = Elementos.crearJLabel(fila_x2, fila_y, 50, 20,"Madre:", false);
        fila_x2 += label_Madre.getWidth();
        Panel2.add(label_Madre);
        
        final JComboBox<String> combo_Madre = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Madre.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Madre.getWidth();
        Panel2.add(combo_Madre);

        fila_x2=600; fila_y=330;
        final JLabel label_Hermanos = Elementos.crearJLabel(fila_x2, fila_y, 110, 20,"Hermanos(as):", false);
        fila_x2 += label_Hermanos.getWidth();
        Panel2.add(label_Hermanos);
        
        final JComboBox<String> combo_Hermanos = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hermanos.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Hermanos.getWidth();
        Panel2.add(combo_Hermanos);

        fila_x2=600; fila_y=370;
        final JLabel label_Otros = Elementos.crearJLabel(fila_x2, fila_y, 50, 20,"Otros:", false);
        fila_x2 += label_Otros.getWidth();
        Panel2.add(label_Otros);
        
        final JComboBox<String> combo_Otros = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Otros.setBounds(fila_x2 ,fila_y, 50, 20);
        fila_x2 += combo_Otros.getWidth();
        Panel2.add(combo_Otros);

        

        // Boton Volver
        final JLabel volverButton2 = new JLabel("VOLVER", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        volverButton2.setBounds(20, 650, 308, 67);
        volverButton2.setFont(new Font("Roboto Black", 1, 22));
        volverButton2.setForeground(Elementos.colores(Inicio.Tema));
        volverButton2.setVerticalTextPosition(SwingConstants.CENTER);
        volverButton2.setHorizontalTextPosition(SwingConstants.CENTER);
        volverButton2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(contentPane, "panel1");
            }

            public void mouseEntered(MouseEvent e) {
                volverButton2.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                volverButton2.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel2.add(volverButton2);

        contentPane.add(Panel2, "panel2");

        // Boton Siguiente
        final JLabel seguienteButton2 = new JLabel("SIGUIENTE", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        seguienteButton2.setBounds(800, 650, 308, 67);
        seguienteButton2.setFont(new Font("Roboto Black", 1, 22));
        seguienteButton2.setForeground(Elementos.colores(Inicio.Tema));
        seguienteButton2.setVerticalTextPosition(SwingConstants.CENTER);
        seguienteButton2.setHorizontalTextPosition(SwingConstants.CENTER);

        seguienteButton2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               // int datosfantates = 0;
               // if (datosfantates == 0) {
                cardLayout.show(contentPane, "panel3");
            //  }
            }

            public void mouseEntered(MouseEvent e) {
                seguienteButton2.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                seguienteButton2.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel2.add(seguienteButton2);

        // FONDO
        JLabel fondo2 = new JLabel();
        fondo2.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/NHM_part2-claro.png")));
        fondo2.setBounds(0, 0, 1290, 720);
        Panel2.add(fondo2);

//Tercer Panel

        Panel3.setLayout(null);
        Panel3.setBounds(0, 0, 1120, 720);
        frame.add(Panel3);
        // Cerrar ventana
        final JLabel Cerrar3 = Elementos.cerrar(1090, 10, 20, 20);
        Panel3.add(Cerrar3);
        Cerrar3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.dispose(); // Cierra la ventana
            }

            public void mouseEntered(MouseEvent e) {
                Cerrar3.setForeground(Color.RED);
            }

            public void mouseExited(MouseEvent e) {
                Cerrar3.setForeground(Color.WHITE);
            }
        });

        // Minimizar
        final JLabel Minimizar3 = Elementos.minimizar(1070, 10, 20, 20);
        Panel3.add(Minimizar3);
        Minimizar3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.setExtendedState(1);
            }

            public void mouseEntered(MouseEvent e) {
                Minimizar3.setForeground(Color.red);
            }

            public void mouseExited(MouseEvent e) {
                Minimizar3.setForeground(Color.white);
            }
        });

        //Primera fila - Arriba
        int fila_x3 = 36;  int fila_y3 = 50; 
        final JLabel label_Menarquia = Elementos.crearJLabel(fila_x3, fila_y3, 90, 20, "Menarquia:", false);
        fila_x3 += label_Menarquia.getWidth();
        Panel3.add(label_Menarquia);

        final JTextField texto_Menarquia = Elementos.crearJTextField(fila_x3, fila_y3, 80, 20, "", true);
        fila_x3 += texto_Menarquia.getWidth();
        Panel3.add(texto_Menarquia);

        fila_x3 = 36; fila_y3 = 80; 
        final JLabel label_Cliclo_menstrual = Elementos.crearJLabel(fila_x3 , fila_y3, 120, 20, "Cliclo menstrual:", false);
        fila_x3 += label_Cliclo_menstrual.getWidth();
        Panel3.add(label_Cliclo_menstrual);

        final JTextField texto_Cliclo_menstrual = Elementos.crearJTextField(fila_x3 , fila_y3, 50, 20, "", true);
        fila_x3 += texto_Cliclo_menstrual.getWidth();
        Panel3.add(texto_Cliclo_menstrual);

        fila_x3 = 36; fila_y3 = 110; 
        final JLabel label_PRSexual = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "P.R. Sexual:", false);
        fila_x3 += label_PRSexual.getWidth();
        Panel3.add(label_PRSexual);

        final JTextField texto_PRSexual = Elementos.crearJTextField(fila_x3 , fila_y3, 50, 20, "", true);
        fila_x3 += texto_PRSexual.getWidth();
        Panel3.add(texto_PRSexual);

        fila_x3 = 36; fila_y3 = 140; 
        final JLabel label_FrecuenciaRSexual = Elementos.crearJLabel(fila_x3, fila_y3,160, 20, "Frecuencia R. Sexual:", false);
        fila_x3 += label_FrecuenciaRSexual.getWidth();
        Panel3.add(label_FrecuenciaRSexual);

        final JTextField texto_FrecuenciaRSexual = Elementos.crearJTextField(fila_x3 , fila_y3, 50, 20, "", true);
        fila_x3 += texto_FrecuenciaRSexual.getWidth();
        Panel3.add(texto_FrecuenciaRSexual);

        fila_x3 = 36; fila_y3 = 170; 
        final JLabel label_N_Parejas = Elementos.crearJLabel(fila_x3, fila_y3,90, 20, "N~ Parejas:", false);
        fila_x3 += label_N_Parejas.getWidth();
        Panel3.add(label_N_Parejas);

        final JTextField texto_N_Parejas = Elementos.crearJTextField(fila_x3 , fila_y3, 50, 20, "", true);
        fila_x3 += texto_N_Parejas.getWidth();
        Panel3.add(texto_N_Parejas);

        fila_x3 = 36; fila_y3 = 200; 
        final JLabel label_Dispareunia = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Dispareunia:", false);
        fila_x3 += label_Dispareunia.getWidth();
        Panel3.add(label_Dispareunia);

        final JComboBox<String> combo_Dispareunia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Dispareunia.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Dispareunia.getWidth();
        Panel3.add(combo_Dispareunia);

        //Segunda fila - Arriba
        fila_x3 = 280;  fila_y3 = 50; 
        final JLabel label_Anticoncepcion = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Anticoncepcion:", false);
        fila_x3 += label_Anticoncepcion.getWidth();
        Panel3.add(label_Anticoncepcion);

        final JComboBox<String> combo_Anticoncepcion = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Anticoncepcion.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Anticoncepcion.getWidth();
        Panel3.add(combo_Anticoncepcion);

        fila_x3 = 280; fila_y3 = 80; 
        final JComboBox<String> combo_AC_DIU = new JComboBox<String>(new String[] {"ACO","DIU","Otros"});
        combo_AC_DIU.setBounds(fila_x3 , fila_y3, 80, 20);
        fila_x3 += combo_AC_DIU.getWidth();
        Panel3.add(combo_AC_DIU);

        fila_x3 = 280; fila_y3 = 110; 
        final JLabel label_Menospausia = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Menospausia:", false);
        fila_x3 += label_Menospausia.getWidth();
        Panel3.add(label_Menospausia);

        final JComboBox<String> combo_Menospausia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Menospausia.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Menospausia.getWidth();
        Panel3.add(combo_Menospausia);

        fila_x3 = 280; fila_y3 = 140; 
        final JLabel label_Gesta = Elementos.crearJLabel(fila_x3, fila_y3,120, 20, "Gesta", false);
        fila_x3 += label_Gesta.getWidth();
        Panel3.add(label_Gesta);

        final JComboBox<String> combo_Gesta = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Gesta.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Gesta.getWidth();
        Panel3.add(combo_Gesta);

        fila_x3 = 280; fila_y3 = 170; 
        final JLabel label_Partos = Elementos.crearJLabel(fila_x3, fila_y3,120, 20, "Partos:", false);
        fila_x3 += label_Partos.getWidth();
        Panel3.add(label_Partos);

        final JComboBox<String> combo_Partos = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Partos.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Partos.getWidth();
        Panel3.add(combo_Partos);

        fila_x3 = 280; fila_y3 = 200; 
        final JLabel label_Cesarea2 = Elementos.crearJLabel(fila_x3, fila_y3,120, 20, "Cesarea:", false);
        fila_x3 += label_Cesarea2.getWidth();
        Panel3.add(label_Cesarea2);

        final JComboBox<String> combo_Cesarea2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Cesarea2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Cesarea2.getWidth();
        Panel3.add(combo_Cesarea2);

        // tercera fila - Arriba
        fila_x3 = 500;  fila_y3 = 50; 
        final JLabel label_Aborto = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Aborto:", false);
        fila_x3 += label_Aborto.getWidth();
        Panel3.add(label_Aborto);

        final JComboBox<String> combo_Aborto = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Aborto.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Aborto.getWidth();
        Panel3.add(combo_Aborto);

        fila_x3 = 500; fila_y3 = 80; 
        final JLabel label_E1erparto = Elementos.crearJLabel(fila_x3 , fila_y3, 100, 20, "E 1er parto:", false);
        fila_x3 += label_E1erparto.getWidth();
        Panel3.add(label_E1erparto);

        final JTextField texto_E1erparto = Elementos.crearJTextField(fila_x3 , fila_y3, 50, 20, "", true);
        fila_x3 += texto_E1erparto.getWidth();
        Panel3.add(texto_E1erparto);

        fila_x3 = 500; fila_y3 = 110; 
        final JLabel label_F_Uparto = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "F.U parto:", false);
        fila_x3 += label_F_Uparto.getWidth();
        Panel3.add(label_F_Uparto);

        final JTextField texto_F_Uparto = Elementos.crearJTextField(fila_x3 , fila_y3, 50, 20, "", true);
        fila_x3 += texto_F_Uparto.getWidth();
        Panel3.add(texto_F_Uparto);

        fila_x3 = 500; fila_y3 = 140; 
        final JLabel label_F_UAborto = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "F.U Aborto:", false);
        fila_x3 += label_F_UAborto.getWidth();
        Panel3.add(label_F_UAborto);

        final JTextField texto_F_UAborto = Elementos.crearJTextField(fila_x3 , fila_y3, 50, 20, "", true);
        fila_x3 += texto_F_UAborto.getWidth();
        Panel3.add(texto_F_UAborto);

        //Cuarta fila - Arriba
        fila_x3 = 700;  fila_y3 = 50; 
        final JLabel label_Curetaje = Elementos.crearJLabel(fila_x3, fila_y3, 80, 20, "Curetaje:", false);
        fila_x3 += label_Curetaje.getWidth();
        Panel3.add(label_Curetaje);

        final JTextField combo_Curetaje = Elementos.crearJTextField(fila_x3, fila_y3, 80, 20, "", true);
        fila_x3 += combo_Curetaje.getWidth();
        Panel3.add(combo_Curetaje);

        fila_x3 = 700; fila_y3 = 80; 
        final JLabel label_N_de_Hijos = Elementos.crearJLabel(fila_x3 , fila_y3, 100, 20, "N~ de Hijos:", false);
        fila_x3 += label_N_de_Hijos.getWidth();
        Panel3.add(label_N_de_Hijos);

        final JTextField texto_N_de_Hijos = Elementos.crearJTextField(fila_x3 , fila_y3, 50, 20, "", true);
        fila_x3 += texto_N_de_Hijos.getWidth();
        Panel3.add(texto_N_de_Hijos);

        fila_x3 = 700; fila_y3 = 110; 
        final JLabel label_Vivos = Elementos.crearJLabel(fila_x3, fila_y3, 80, 20, "Vivos:", false);
        fila_x3 += label_Vivos.getWidth();
        Panel3.add(label_Vivos);

        final JTextField texto_Vivos = Elementos.crearJTextField(fila_x3 , fila_y3, 50, 20, "", true);
        fila_x3 += texto_Vivos.getWidth();
        Panel3.add(texto_Vivos);

        fila_x3 = 700; fila_y3 = 140; 
        final JLabel label_Muertos = Elementos.crearJLabel(fila_x3, fila_y3,80, 20, "Muertos:", false);
        fila_x3 += label_Muertos.getWidth();
        Panel3.add(label_Muertos);

        final JTextField texto_Muertos = Elementos.crearJTextField(fila_x3 , fila_y3, 50, 20, "", true);
        fila_x3 += texto_Muertos.getWidth();
        Panel3.add(texto_Muertos);

        fila_x3 = 700; fila_y3 = 170; 
        final JLabel label_RN_mayor_peso = Elementos.crearJLabel(fila_x3, fila_y3,150, 20, "RN de mayor peso:", false);
        fila_x3 += label_RN_mayor_peso.getWidth();
        Panel3.add(label_RN_mayor_peso);

        final JTextField text_RN_de_mayor_peso = Elementos.crearJTextField(fila_x3 , fila_y3, 50, 20, "", true);
        fila_x3 += text_RN_de_mayor_peso.getWidth();
        Panel3.add(text_RN_de_mayor_peso);

        final JLabel text_RN_de_mayor_peso_gr = Elementos.crearJLabel(fila_x3+10, fila_y3,20, 20, "gr:", false);
        fila_x3 += text_RN_de_mayor_peso_gr.getWidth();
        Panel3.add(text_RN_de_mayor_peso_gr);

        //Primera fila - abajo
        fila_x3 = 36;  fila_y3 = 270; 
        final JLabel label_Alergia2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Alergia:", false);
        fila_x3 += label_Alergia2.getWidth();
        Panel3.add(label_Alergia2);

        final JComboBox<String> combo_Alergia2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Alergia2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Alergia2.getWidth();
        Panel3.add(combo_Alergia2);

        fila_x3 = 36; fila_y3 = 300; 
        final JLabel label_Asma2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Asma:", false);
        fila_x3 += label_Asma2.getWidth();
        Panel3.add(label_Asma2);

        final JComboBox<String> combo_Asma2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Asma2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Asma2.getWidth();
        Panel3.add(combo_Asma2);

        fila_x3 = 36; fila_y3 = 330; 
        final JLabel label_Neumonia = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Neumonia", false);
        fila_x3 += label_Neumonia.getWidth();
        Panel3.add(label_Neumonia);

        final JComboBox<String> combo_Neumonia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Neumonia.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Neumonia.getWidth();
        Panel3.add(combo_Neumonia);

        fila_x3 = 36; fila_y3 = 360; 
        final JLabel label_TBC2 = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "T.B.C:", false);
        fila_x3 += label_TBC2.getWidth();
        Panel3.add(label_TBC2);

        final JComboBox<String> combo_TBC2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_TBC2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_TBC2.getWidth();
        Panel3.add(combo_TBC2);

        fila_x3 = 36; fila_y3 = 390; 
        final JLabel label_Cardiopatia2 = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Cardiopatia:", false);
        fila_x3 += label_Cardiopatia2.getWidth();
        Panel3.add(label_Cardiopatia2);

        final JComboBox<String> combo_Cardiopatia2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Cardiopatia2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Cardiopatia2.getWidth();
        Panel3.add(combo_Cardiopatia2);

        fila_x3 = 36; fila_y3 = 420; 
        final JLabel label_Hipertension2 = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Hipertension:", false);
        fila_x3 += label_Hipertension2.getWidth();
        Panel3.add(label_Hipertension2);

        final JComboBox<String> combo_Hipertension2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hipertension2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Hipertension2.getWidth();
        Panel3.add(combo_Hipertension2);

        fila_x3 = 36; fila_y3 = 450; 
        final JLabel label_Hiperlipidemias = Elementos.crearJLabel(fila_x3, fila_y3,120, 20, "Hiperlipidemias:", false);
        fila_x3 += label_Hiperlipidemias.getWidth();
        Panel3.add(label_Hiperlipidemias);

        final JComboBox<String> combo_Hiperlipidemias = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hiperlipidemias.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Hiperlipidemias.getWidth();
        Panel3.add(combo_Hiperlipidemias);

        fila_x3 = 36; fila_y3 = 480; 
        final JLabel label_Varices = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Varices:", false);
        fila_x3 += label_Varices.getWidth();
        Panel3.add(label_Varices);

        final JComboBox<String> combo_Varices = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Varices.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Varices.getWidth();
        Panel3.add(combo_Varices);

        //Segunda fila - abajo
        fila_x3 = 280;  fila_y3 = 270; 
        final JLabel label_Hepatopatia = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Hepatopatia:", false);
        fila_x3 += label_Hepatopatia.getWidth();
        Panel3.add(label_Hepatopatia);

        final JComboBox<String> combo_Hepatopatia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hepatopatia.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Hepatopatia.getWidth();
        Panel3.add(combo_Hepatopatia);

        fila_x3 = 280; fila_y3 = 300; 
        final JLabel label_Desnutricion2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Desnutricion:", false);
        fila_x3 += label_Desnutricion2.getWidth();
        Panel3.add(label_Desnutricion2);

        final JComboBox<String> combo_Desnutricion2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Desnutricion2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Desnutricion2.getWidth();
        Panel3.add(combo_Desnutricion2);

        fila_x3 = 280; fila_y3 = 330; 
        final JLabel label_Diabetes2 = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Diabetes", false);
        fila_x3 += label_Diabetes2.getWidth();
        Panel3.add(label_Diabetes2);

        final JComboBox<String> combo_Diabetes2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Diabetes2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Diabetes2.getWidth();
        Panel3.add(combo_Diabetes2);

        fila_x3 = 280; fila_y3 = 360; 
        final JLabel label_Obesidad2 = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Obesidad:", false);
        fila_x3 += label_Obesidad2.getWidth();
        Panel3.add(label_Obesidad2);

        final JComboBox<String> combo_Obesidad2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Obesidad2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Obesidad2.getWidth();
        Panel3.add(combo_Obesidad2);

        fila_x3 = 280; fila_y3 = 390; 
        final JLabel label_Gastroenteritis = Elementos.crearJLabel(fila_x3, fila_y3,120, 20, "Gastroenteritis:", false);
        fila_x3 += label_Gastroenteritis.getWidth();
        Panel3.add(label_Gastroenteritis);

        final JComboBox<String> combo_Gastroenteritis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Gastroenteritis.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Gastroenteritis.getWidth();
        Panel3.add(combo_Gastroenteritis);

        fila_x3 = 280; fila_y3 = 420; 
        final JLabel label_Encoprexis = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Encoprexis:", false);
        fila_x3 += label_Encoprexis.getWidth();
        Panel3.add(label_Encoprexis);

        final JComboBox<String> combo_Encoprexis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Encoprexis.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Encoprexis.getWidth();
        Panel3.add(combo_Encoprexis);

        fila_x3 = 280; fila_y3 = 450; 
        final JLabel label_Enf_Renal2 = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Enf. Renal:", false);
        fila_x3 += label_Enf_Renal2.getWidth();
        Panel3.add(label_Enf_Renal2);

        final JComboBox<String> combo_Enf_Renal2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_Renal2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Enf_Renal2.getWidth();
        Panel3.add(combo_Enf_Renal2);

        fila_x3 = 280; fila_y3 = 480; 
        final JLabel label_Enuresis = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Enuresis:", false);
        fila_x3 += label_Enuresis.getWidth();
        Panel3.add(label_Enuresis);

        final JComboBox<String> combo_Enuresis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enuresis.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Enuresis.getWidth();
        Panel3.add(combo_Enuresis);

        //Tercera fila - abajo
        fila_x3 = 500;  fila_y3 = 270; 
        final JLabel label_Cancer2 = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Cancer:", false);
        fila_x3 += label_Cancer2.getWidth();
        Panel3.add(label_Cancer2);

        final JComboBox<String> combo_Cancer2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Cancer2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Cancer2.getWidth();
        Panel3.add(combo_Cancer2);

        fila_x3 = 500; fila_y3 = 300; 
        final JLabel label_Tromboembolica = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Tromboembolica:", false);
        fila_x3 += label_Tromboembolica.getWidth();
        Panel3.add(label_Tromboembolica);

        final JComboBox<String> combo_Tromboembolica = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Tromboembolica.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Tromboembolica.getWidth();
        Panel3.add(combo_Tromboembolica);

        fila_x3 = 500; fila_y3 = 320; 
        final JLabel label_Tumor_Mamario = Elementos.crearJLabel(fila_x3, fila_y3,130, 20, "Tumor Mamario:", false);
        fila_x3 += label_Tumor_Mamario.getWidth();
        Panel3.add(label_Tumor_Mamario);

        final JComboBox<String> combo_Tumor_Mamario = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Tumor_Mamario.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Tumor_Mamario.getWidth();
        Panel3.add(combo_Tumor_Mamario);

        fila_x3 = 500; fila_y3 = 360; 
        final JLabel label_Meningitis = Elementos.crearJLabel(fila_x3, fila_y3,130, 20, "Meningitis:", false);
        fila_x3 += label_Meningitis.getWidth();
        Panel3.add(label_Meningitis);

        final JComboBox<String> combo_Meningitis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Meningitis.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Meningitis.getWidth();
        Panel3.add(combo_Meningitis);

        fila_x3 = 500; fila_y3 = 390; 
        final JLabel label_TCraneoencefal = Elementos.crearJLabel(fila_x3, fila_y3,130, 20, "T Craneoencefal:", false);
        fila_x3 += label_TCraneoencefal.getWidth();
        Panel3.add(label_TCraneoencefal);

        final JComboBox<String> combo_TCraneoencefal = new JComboBox<String>(new String[] { "Si", "No" });
        combo_TCraneoencefal.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_TCraneoencefal.getWidth();
        Panel3.add(combo_TCraneoencefal);

        fila_x3 = 500; fila_y3 = 420; 
        final JLabel label_Enf_Eruptivas = Elementos.crearJLabel(fila_x3, fila_y3,130, 20, "Enf.Eruptivas:", false);
        fila_x3 += label_Enf_Eruptivas.getWidth();
        Panel3.add(label_Enf_Eruptivas);

        final JComboBox<String> combo_Enf_Eruptivas = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_Eruptivas.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Enf_Eruptivas.getWidth();
        Panel3.add(combo_Enf_Eruptivas);

        fila_x3 = 500; fila_y3 = 450; 
        final JLabel label_Dengue = Elementos.crearJLabel(fila_x3, fila_y3,130, 20, "Dengue:", false);
        fila_x3 += label_Dengue.getWidth();
        Panel3.add(label_Dengue);

        final JComboBox<String> combo_Dengue = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Dengue.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Dengue.getWidth();
        Panel3.add(combo_Dengue);

        fila_x3 = 500; fila_y3 = 480; 
        final JLabel label_Hospitalizacion = Elementos.crearJLabel(fila_x3, fila_y3,130, 20, "Hospitalizacion:", false);
        fila_x3 += label_Hospitalizacion.getWidth();
        Panel3.add(label_Hospitalizacion);

        final JComboBox<String> combo_Hospitalizacion = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hospitalizacion.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Hospitalizacion.getWidth();
        Panel3.add(combo_Hospitalizacion);

        //Cuarta fila - abajo
        fila_x3 = 750;  fila_y3 = 270; 
        final JLabel label_Interv_Quirugica = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Interv. Quirugica:", false);
        fila_x3 += label_Interv_Quirugica.getWidth();
        Panel3.add(label_Interv_Quirugica);

        final JComboBox<String> combo_Interv_Quirugica = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Interv_Quirugica.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Interv_Quirugica.getWidth();
        Panel3.add(combo_Interv_Quirugica);

        fila_x3 = 750; fila_y3 = 300; 
        final JLabel label_Accidentes = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Accidentes:", false);
        fila_x3 += label_Accidentes.getWidth();
        Panel3.add(label_Accidentes);

        final JComboBox<String> combo_Accidentes = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Accidentes.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Accidentes.getWidth();
        Panel3.add(combo_Accidentes);

        fila_x3 = 750; fila_y3 = 330; 
        final JLabel label_Artritis2 = Elementos.crearJLabel(fila_x3, fila_y3,130, 20, "Artritis:", false);
        fila_x3 += label_Artritis2.getWidth();
        Panel3.add(label_Artritis2);

        final JComboBox<String> combo_Artritis2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Artritis2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Artritis2.getWidth();
        Panel3.add(combo_Artritis2);

        fila_x3 =750; fila_y3 = 360; 
        final JLabel label_Enf_TS = Elementos.crearJLabel(fila_x3, fila_y3,130, 20, "Enf. T.S:", false);
        fila_x3 += label_Enf_TS.getWidth();
        Panel3.add(label_Enf_TS);

        final JComboBox<String> combo_Enf_TS = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_TS.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Enf_TS.getWidth();
        Panel3.add(combo_Enf_TS);

        fila_x3 = 750; fila_y3 = 390; 
        final JLabel label_Enf_Infec_Tran = Elementos.crearJLabel(fila_x3, fila_y3,130, 20, "Enf. Infec y Tran:", false);
        fila_x3 += label_Enf_Infec_Tran.getWidth();
        Panel3.add(label_Enf_Infec_Tran);

        final JComboBox<String> combo_Enf_Infec_Tran = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_Infec_Tran.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Enf_Infec_Tran.getWidth();
        Panel3.add(combo_Enf_Infec_Tran);

        fila_x3 = 750; fila_y3 = 420; 
        final JLabel label_Enf_Laboral = Elementos.crearJLabel(fila_x3, fila_y3,130, 20, "Enf. Laboral:", false);
        fila_x3 += label_Enf_Laboral.getWidth();
        Panel3.add(label_Enf_Laboral);

        final JComboBox<String> combo_Enf_Laboral = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_Laboral.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Enf_Laboral.getWidth();
        Panel3.add(combo_Enf_Laboral);

        fila_x3 = 750; fila_y3 = 450; 
        final JLabel label_Otros2 = Elementos.crearJLabel(fila_x3, fila_y3,130, 20, "Otros:", false);
        fila_x3 += label_Otros2.getWidth();
        Panel3.add(label_Otros2);

        final JTextField text_Otros = Elementos.crearJTextField(fila_x3 , fila_y3, 100, 20, "", true);
        fila_x3 += text_Otros.getWidth();
        Panel3.add(text_Otros);

        //Primera fila - Factores de riesgo
        fila_x3 = 36;  fila_y3 = 540; 
        final JLabel label_Alcohol2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Alcohol:", false);
        fila_x3 += label_Alcohol2.getWidth();
        Panel3.add(label_Alcohol2);

        final JComboBox<String> combo_Alcohol2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Alcohol2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Alcohol2.getWidth();
        Panel3.add(combo_Alcohol2);

        fila_x3 = 36; fila_y3 = 570; 
        final JLabel label_Drogas2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Drogas:", false);
        fila_x3 += label_Drogas2.getWidth();
        Panel3.add(label_Drogas2);

        final JComboBox<String> combo_Drogas2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Drogas2.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Drogas2.getWidth();
        Panel3.add(combo_Drogas2);

        fila_x3 = 36; fila_y3 = 600; 
        final JLabel label_Insecticidas = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Insecticidas:", false);
        fila_x3 += label_Insecticidas.getWidth();
        Panel3.add(label_Insecticidas);

        final JComboBox<String> combo_Insecticidas = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Insecticidas.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Insecticidas.getWidth();
        Panel3.add(combo_Insecticidas);

        fila_x3 = 36; fila_y3 = 630; 
        final JLabel label_Deoirtes = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Deoirtes:", false);
        fila_x3 += label_Deoirtes.getWidth();
        Panel3.add(label_Deoirtes);

        final JComboBox<String> combo_Deoirtes = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Deoirtes.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Deoirtes.getWidth();
        Panel3.add(combo_Deoirtes);

        //segunda fila - Factores de riesgo
        fila_x3 = 280;  fila_y3 = 540; 
        final JLabel label_Sedentarismo = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Sedentarismo:", false);
        fila_x3 += label_Sedentarismo.getWidth();
        Panel3.add(label_Sedentarismo);

        final JComboBox<String> combo_Sedentarismo = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Sedentarismo.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Sedentarismo.getWidth();
        Panel3.add(combo_Sedentarismo);

        fila_x3 = 280; fila_y3 = 570; 
        final JLabel label_Sueno = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Sueño:", false);
        fila_x3 += label_Sueno.getWidth();
        Panel3.add(label_Sueno);

        final JComboBox<String> combo_Sueno = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Sueno.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Sueno.getWidth();
        Panel3.add(combo_Sueno);

        fila_x3 = 280; fila_y3 = 600; 
        final JLabel label_ChuparDedo = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Chupar Dedo:", false);
        fila_x3 += label_ChuparDedo.getWidth();
        Panel3.add(label_ChuparDedo);

        final JComboBox<String> combo_ChuparDedo = new JComboBox<String>(new String[] { "Si", "No" });
        combo_ChuparDedo.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_ChuparDedo.getWidth();
        Panel3.add(combo_ChuparDedo);

        fila_x3 = 280; fila_y3 = 630; 
        final JLabel label_Onicofagia = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Onicofagia:", false);
        fila_x3 += label_Onicofagia.getWidth();
        Panel3.add(label_Onicofagia);

        final JComboBox<String> combo_Onicofagia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Onicofagia.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Onicofagia.getWidth();
        Panel3.add(combo_Onicofagia);

        //Tercera fila - Factores de riesgo
        fila_x3 = 500;  fila_y3 = 540; 
        final JLabel label_Micciones = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Micciones:", false);
        fila_x3 += label_Micciones.getWidth();
        Panel3.add(label_Micciones);

        final JComboBox<String> combo_Micciones = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Micciones.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Micciones.getWidth();
        Panel3.add(combo_Micciones);

        fila_x3 = 500; fila_y3 = 570; 
        final JLabel label_Evacuaciones = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Evacuaciones:", false);
        fila_x3 += label_Evacuaciones.getWidth();
        Panel3.add(label_Evacuaciones);

        final JComboBox<String> combo_Evacuaciones = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Evacuaciones.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Evacuaciones.getWidth();
        Panel3.add(combo_Evacuaciones);

        fila_x3 = 500; fila_y3 = 600; 
        final JLabel label_Stres = Elementos.crearJLabel(fila_x3, fila_y3,100, 20, "Stres:", false);
        fila_x3 += label_Stres.getWidth();
        Panel3.add(label_Stres);

        final JComboBox<String> combo_Stres = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Stres.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Stres.getWidth();
        Panel3.add(combo_Stres);

        fila_x3 = 500; fila_y3 = 630; 
        final JLabel label_Metales_Pensados = Elementos.crearJLabel(fila_x3, fila_y3,140, 20, "Metales Pensados:", false);
        fila_x3 += label_Metales_Pensados.getWidth();
        Panel3.add(label_Metales_Pensados);

        final JComboBox<String> combo_Metales_Pensados = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Metales_Pensados.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Metales_Pensados.getWidth();
        Panel3.add(combo_Metales_Pensados);

        //cuarta fila - Factores de riesgo
        fila_x3 = 750;  fila_y3 = 540; 
        final JLabel label_Alimentacion = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Alimentacion:", false);
        fila_x3 += label_Alimentacion.getWidth();
        Panel3.add(label_Alimentacion);

        final JComboBox<String> combo_Alimentacion = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Alimentacion.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Alimentacion.getWidth();
        Panel3.add(combo_Alimentacion);

        fila_x3 = 750; fila_y3 = 570; 
        final JLabel label_Fuma = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Fuma:", false);
        fila_x3 += label_Fuma.getWidth();
        Panel3.add(label_Fuma);

        final JComboBox<String> combo_Fuma = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Fuma.setBounds(fila_x3 , fila_y3, 50, 20);
        fila_x3 += combo_Fuma.getWidth();
        Panel3.add(combo_Fuma);

        fila_x3 = 750; fila_y3 = 600; 
        final JLabel label_NCigarrillos_diarios = Elementos.crearJLabel(fila_x3, fila_y3,160, 20, "N~ Cigarrillos diarios:", false);
        fila_x3 += label_NCigarrillos_diarios.getWidth();
        Panel3.add(label_NCigarrillos_diarios);

        final JTextField texto_NCigarrillos_diarios = Elementos.crearJTextField(fila_x3 , fila_y3, 100, 20, "", true);
        fila_x3 += texto_NCigarrillos_diarios.getWidth();
        Panel3.add(texto_NCigarrillos_diarios);
        
        // Boton Volver 
        final JLabel volverButton3 = new JLabel("VOLVER", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        volverButton3.setBounds(20, 650, 308, 67);
        volverButton3.setFont(new Font("Roboto Black", 1, 22));
        volverButton3.setForeground(Elementos.colores(Inicio.Tema));
        volverButton3.setVerticalTextPosition(SwingConstants.CENTER);
        volverButton3.setHorizontalTextPosition(SwingConstants.CENTER);
        volverButton3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(contentPane, "panel2");
            }

            public void mouseEntered(MouseEvent e) {
                volverButton3.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                volverButton3.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel3.add(volverButton3);

        // Boton Siguiente
        final JLabel GuardarButton = new JLabel("GUARDAR", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        GuardarButton.setBounds(800, 650, 308, 67);
        GuardarButton.setFont(new Font("Roboto Black", 1, 22));
        GuardarButton.setForeground(Elementos.colores(Inicio.Tema));
        GuardarButton.setVerticalTextPosition(SwingConstants.CENTER);
        GuardarButton.setHorizontalTextPosition(SwingConstants.CENTER);

        GuardarButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int datosfantates = 0;
                if (datosfantates == 0) {
                }
            }

            public void mouseEntered(MouseEvent e) {
                GuardarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                GuardarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel3.add(GuardarButton);

        

        // FONDO
        JLabel fondo3 = new JLabel();
        fondo3.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/NHM_part3-claro.png")));
        fondo3.setBounds(0, 0, 1290, 720);
        Panel3.add(fondo3);
        contentPane.add(Panel3, "panel3");

        frame.setContentPane(contentPane);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación en el subproceso de la interfaz gráfica
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NHM(); // Crear una instancia de la aplicación
            }
        });
    }
}
