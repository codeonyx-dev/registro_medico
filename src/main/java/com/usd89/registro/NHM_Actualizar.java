package com.usd89.registro;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import com.usd89.DatabaseConnection.Conexion;
import com.usd89.DatabaseConnection.Localidades.Estados;
import com.usd89.DatabaseConnection.Localidades.Municipio;
import com.usd89.DatabaseConnection.Localidades.Pais;

public class NHM_Actualizar extends JFrame {
    int xMouse, yMouse;
    String RegistradoPor, FechaRegistro, ModificadoPor, FechaModificacion, Observacion;

    public String[] Obtener_datos() {
        String[] tablaBDD = { "RegistradoPor", "FechaRegistro", "ModificadoPor", "FechaModificacion",
                "apellido_familiar", "Numero_de_Historia", "ci_jefe_familia", "ci_tipo", "Ci_cedula",
                "apellido", "nombre", "estadoCivil", "Ocupacion", "estudio", "anosAprobados", "Analfabeta", "sexo",
                "NFecha", "LugarNacimiento", "Pais", "Estado", "Municipio", "Telefono", "Religion",
                "Establecimiento", "Direccion", "Parroquia", "Comunidad", "Madre_N_A", "Madre_Ocupacion",
                "Padre_N_A", "Padre_Ocupacion", "Representante", "Representante_N", "Representante_tipo_ci",
                "Representante_ci", "Representante_Telefono", "Carnet_prenatal", "patologiaEmbarazo",
                "patologiaParto", "patologiaPuerperio", "NConsultasPrenatales", "Hrs_fuera_de_casa", "MadreFamilia",
                "PadreFamilia", "HermanoFamilia", "OtrosFamilia", "Edad_Gestacional", "sem", "Forceps", "Cesarea",
                "Parto", "ApgarMin", "Reanimacion", "EgresoRN", "Exclusiva", "Mixta", "Ablactacion",
                "Peso_al_nacer", "Talla", "Circunferencia", "Asfixia", "PatologiasRN", "Alergia", "Asma", "TBC",
                "Cardiopatia", "Hipertension", "Varice", "Desnutricion", "Diabetes", "Obesidad", "Gastropatia",
                "Neurologica", "Enf_Renal", "Cancer", "Alcohol", "Drogas", "Sifilis", "SIDA", "Artritis",
                "otros_1", "Padre", "Madre", "Hermanos", "Otros_2", "Menarquia", "Ciclo_menstrual", "PRSexual",
                "FrecuenciaRSexual", "N_Parejas", "Dispareunia", "Anticoncepcion", "AC_DIU", "Menopausia", "Gesta",
                "Partos", "Cesarea2", "Aborto", "E1erparto", "F_Uparto", "F_UAborto", "Curetaje", "N_de_Hijos",
                "Vivos", "Muertos", "RN_de_mayor_peso", "Alergia2", "Asma2", "Neumonia", "TBC2", "Cardiopatia2",
                "Hipertension2", "Hiperlipidemias", "Varices", "Hepatopatia", "Desnutricion2", "Diabetes2",
                "Obesidad2", "Gastroenteritis", "Encoprexis", "Enf_Renal2", "Enuresis", "Cancer2", "Tromboembolica",
                "Tumor_Mamario", "Meningitis", "TCraneoencefal", "Enf_Eruptivas", "Dengue", "Hospitalizacion",
                "Interv_Quirurgica", "Accidentes", "Artritis2", "Enf_TS", "Enf_Infec_Tran", "Enf_Laboral", "Otros_3",
                "Alcohol2", "Drogas2", "Insecticidas", "Deportes", "Sedentarismo", "Sueno", "ChuparDedo",
                "Onicofagia", "Micciones", "Evacuaciones", "Estres", "Metales_Pensados", "Alimentacion", "Fuma",
                "NCigarrillos_diarios", "Observacion" };
        String[] datosBDD = new String[tablaBDD.length];

        try {
            Connection connection = Conexion.getConexion();
            String consultaSQL = ("select * from datospersonales where Numero_de_Historia = ?");
            PreparedStatement statement = connection.prepareStatement(consultaSQL);
            statement.setString(1, Buscador.ID);
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                for (int i = 0; i < datosBDD.length; i++) {
                    datosBDD[i] = resultado.getString(i + 1); // Nota: i + 1 porque el índice de las columnas es 1-based
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return datosBDD;
    }

    public NHM_Actualizar() {

        setTitle("Actualizar Expediente Médico");
        setSize(1120, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagen/Icono.png"));
        setIconImage(icono.getImage());
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 20));
        setLocationRelativeTo(null);

        final JPanel contentPanel = new JPanel();
        final CardLayout cardLayout = new CardLayout();

        contentPanel.setLayout(cardLayout);

        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();
        JLabel Encabezado = new JLabel();
        Encabezado.setBounds(0, 0, getWidth(), 20);
        Encabezado.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - xMouse, y - yMouse);
            }
        });
        Encabezado.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        });
        Panel1.add(Encabezado);
        Panel2.add(Encabezado);
        Panel3.add(Encabezado);

        add(contentPanel, BorderLayout.CENTER);
        setVisible(true);

        Panel1.setLayout(null);
        Panel1.setBounds(0, 0, 1120, 720);
        add(Panel1);

        // Cerrar ventana
        final JLabel Cerrar = Elementos.cerrar(1090, 10, 20, 20);
        Panel1.add(Cerrar);
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
        final JLabel Minimizar = Elementos.minimizar(1070, 10, 20, 20);
        Panel1.add(Minimizar);
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
        final JLabel label_apellido_familiar = Elementos.crearJLabel(fila_x, 70, 150, 20, "Apellido de tu familia:",
                false);
        fila_x += label_apellido_familiar.getWidth();
        Panel1.add(label_apellido_familiar);

        JButton masInfo = new JButton("Información sobre el registro");
        masInfo.setBounds(fila_x, 35, 200, 20);
        Panel1.add(masInfo);

        final JTextField text_apellido_familiar = Elementos.crearJTextField(fila_x + 5, 70, 140, 20, "", true);
        fila_x += text_apellido_familiar.getWidth();
        Panel1.add(text_apellido_familiar);
        text_apellido_familiar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_ci_jefe_familia = Elementos.crearJLabel(fila_x + 25, 70, 130, 20, "C.I Jefe de familia:",
                false);
        fila_x += label_ci_jefe_familia.getWidth();
        Panel1.add(label_ci_jefe_familia);

        final JTextField text_ci_jefe_familia = Elementos.crearJTextField(fila_x + 30, 70, 100, 20, "", true);
        fila_x += text_ci_jefe_familia.getWidth();
        Panel1.add(text_ci_jefe_familia);
        text_ci_jefe_familia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel Label_Numero_de_Historia = Elementos.crearJLabel(fila_x + 50, 70, 150, 20, "Numero de Historia:",
                false);
        fila_x += Label_Numero_de_Historia.getWidth();
        Panel1.add(Label_Numero_de_Historia);

        final JTextField text_Numero_de_Historia = Elementos.crearJTextField(fila_x + 50, 70, 80, 20, "",
                true);
        fila_x += text_Numero_de_Historia.getWidth();
        text_Numero_de_Historia.setEditable(false);
        Panel1.add(text_Numero_de_Historia);

        // Segunda linea
        final JLabel Label_ci = Elementos.crearJLabel(36, 115, 20, 20, "CI", false);
        Panel1.add(Label_ci);
        final JComboBox<String> ci_ComboBox = new JComboBox<String>(new String[] { "V", "E" });
        ci_ComboBox.setBounds(61, 115, 40, 20);
        Panel1.add(ci_ComboBox);
        final JTextField text_ci = Elementos.crearJTextField(105, 115, 100, 20, "", true);
        Panel1.add(text_ci);
        text_ci.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_nombre = Elementos.crearJLabel(220, 115, 65, 20, "Nombre:", false);
        Panel1.add(label_nombre);

        final JTextField text_nombre = Elementos.crearJTextField(285, 115, 130, 20, "", true);
        Panel1.add(text_nombre);
        text_nombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_apellido = Elementos.crearJLabel(430, 115, 70, 20, "Apellido:", false);
        Panel1.add(label_apellido);

        final JTextField text_apellido = Elementos.crearJTextField(495, 115, 150, 20, "", true);
        Panel1.add(text_apellido);
        text_apellido.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_Sexo = Elementos.crearJLabel(660, 115, 50, 20, "Sexo:", false);
        Panel1.add(label_Sexo);

        final JComboBox<String> combo_sexo = new JComboBox<String>(new String[] { "Femenino", "Masculino" });
        combo_sexo.setBounds(705, 115, 85, 20);
        Panel1.add(combo_sexo);

        final JLabel label_estadoCivil = Elementos.crearJLabel(805, 115, 90, 20, "Estado civil:", false);
        Panel1.add(label_estadoCivil);

        final JComboBox<String> ComboBox_estadoCivil = new JComboBox<String>(
                new String[] { "Soltero/a", "Casado/a", "Viudo/a", "Divorciado/a", "Otros" });
        ComboBox_estadoCivil.setBounds(895, 115, 100, 20);
        Panel1.add(ComboBox_estadoCivil);

        // FECHA DE NACIMIENTO
        final JLabel label_fechaNacimiento = Elementos.crearJLabel(36, 150, 130, 20, "Fecha nacimiento:", false);
        Panel1.add(label_fechaNacimiento);

        // Agregar el calendario
        JDateChooser calendario = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        calendario.setFont(new Font("Arial", 3, 15));
        calendario.setBounds(170, 150, 100, 20);
        Panel1.add(calendario);

        final JLabel label_Estudios = Elementos.crearJLabel(285, 150, 80, 20, "Estudios:", false);
        Panel1.add(label_Estudios);

        final JComboBox<String> combo_estudio = new JComboBox<String>(new String[] { "P", "S", "U", "O" });
        combo_estudio.setBounds(360, 150, 55, 20);
        Panel1.add(combo_estudio);

        final JLabel label_anosAprobados = Elementos.crearJLabel(430, 150, 120, 20, "Años aprobados:", false);
        Panel1.add(label_anosAprobados);

        final JTextField text_anosAprobados = Elementos.crearJTextField(550, 150, 95, 20, "", true);
        Panel1.add(text_anosAprobados);
        text_anosAprobados.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_Analfabeta = Elementos.crearJLabel(660, 150, 80, 20, "Analfabeta:", false);
        Panel1.add(label_Analfabeta);

        final JComboBox<String> combo_Analfabeta = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Analfabeta.setBounds(740, 150, 50, 20);
        Panel1.add(combo_Analfabeta);

        final JLabel label_Ocupacion = Elementos.crearJLabel(805, 150, 80, 20, "Ocupación:", false);
        Panel1.add(label_Ocupacion);

        final JTextField text_Ocupacion = Elementos.crearJTextField(885, 150, 150, 20, "", true);
        Panel1.add(text_Ocupacion);
        text_Ocupacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        // Tercera linea
        final JLabel label_Pais = Elementos.crearJLabel(36, 190, 40, 20, "Pais:", false);
        Panel1.add(label_Pais);

        Pais pais = new Pais();
        DefaultComboBoxModel<String> modelPais = new DefaultComboBoxModel(pais.mostrarPais());
        JComboBox<String> combo_Pais = new JComboBox<String>();
        combo_Pais.setName("combo_Pais");
        combo_Pais.setBounds(76, 190, 195, 20);
        combo_Pais.setFont(new Font("Roboto", 1, 15));
        combo_Pais.setModel(modelPais);
        Panel1.add(combo_Pais);

        final JLabel label_Estado = Elementos.crearJLabel(285, 190, 80, 20, "Estado:", false);
        Panel1.add(label_Estado);

        Estados estado = new Estados();
        DefaultComboBoxModel<String> modelEstado = new DefaultComboBoxModel();
        JComboBox<String> combo_Estado = new JComboBox<String>(new String[] { "Seleccionar" });
        combo_Estado.setName("combo_Estado");
        combo_Estado.setBounds(340, 190, 210, 20);
        combo_Estado.setFont(new Font("Roboto", 1, 15));
        Panel1.add(combo_Estado);

        final JLabel label_Municipio = Elementos.crearJLabel(575, 190, 80, 20, "Municipio:", false);
        Panel1.add(label_Municipio);

        Municipio Municipio = new Municipio();
        JComboBox<String> Combo_municipio = new JComboBox<String>();
        Combo_municipio.setBounds(660, 190, 130, 20);
        Combo_municipio.setFont(new Font("Roboto", 1, 15));
        Combo_municipio.setName("Combo_municipio");
        Panel1.add(Combo_municipio);
        Combo_municipio.setVisible(true);

        final JTextField texto_Municipio = Elementos.crearJTextField(660, 190, 130, 20, "", true);
        texto_Municipio.setName("texto_Municipio");
        Panel1.add(texto_Municipio);
        texto_Municipio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });
        texto_Municipio.setVisible(false);
        combo_Pais.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String obtenerPais = combo_Pais.getSelectedItem().toString();
                    DefaultComboBoxModel<String> modelEstado = new DefaultComboBoxModel(
                            estado.obtenerEstados(obtenerPais));
                    combo_Estado.setModel(modelEstado);
                    if (obtenerPais.equals("Venezuela")) {
                        texto_Municipio.setVisible(false);
                        Combo_municipio.setVisible(true);
                    } else {
                        texto_Municipio.setVisible(true);
                        Combo_municipio.setVisible(false);
                    }
                }
            }
        });

        combo_Estado.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Estados estados = (Estados) combo_Estado.getSelectedItem();
                    DefaultComboBoxModel<String> modelMunicipio = new DefaultComboBoxModel(
                            Municipio.mostrarMunicipios(estados.getId()));
                    Combo_municipio.setModel(modelMunicipio);
                }
            }
        });

        final JLabel label_Parroquia = Elementos.crearJLabel(805, 190, 80, 20, "Parroquia:", false);
        fila_x += label_Parroquia.getWidth();
        Panel1.add(label_Parroquia);

        final JTextField texto_Parroquia = Elementos.crearJTextField(885, 190, 150, 20, "", true);
        fila_x += texto_Parroquia.getWidth();
        Panel1.add(texto_Parroquia);

        // Cuarta linea
        final JLabel label_Dirección = Elementos.crearJLabel(36, 230, 80, 20, "Dirección:", false);
        Panel1.add(label_Dirección);

        final JTextField texto_Direccion = Elementos.crearJTextField(115, 230, 325, 20, "", true);
        Panel1.add(texto_Direccion);

        final JLabel label_LugarNacimiento = Elementos.crearJLabel(460, 230, 150, 20, "Lugar de nacimiento:", false);
        Panel1.add(label_LugarNacimiento);

        final JTextField text_LugarNacimiento = Elementos.crearJTextField(610, 230, 180, 20, "", true);
        Panel1.add(text_LugarNacimiento);

        final JLabel label_Establecimiento = Elementos.crearJLabel(800, 230, 120, 20, "Establecimiento:", false);
        fila_x += label_Establecimiento.getWidth();
        Panel1.add(label_Establecimiento);

        final JTextField texto_Establecimiento = Elementos.crearJTextField(920, 230, 115, 20, "", true);
        fila_x += texto_Establecimiento.getWidth();
        Panel1.add(texto_Establecimiento);

        // Quinta linea
        final JLabel label_Comunidad = Elementos.crearJLabel(36, 270, 85, 20, "Comunidad:", false);
        Panel1.add(label_Comunidad);

        final JTextField texto_Comunidad = Elementos.crearJTextField(125, 270, 120, 20, "", true);
        Panel1.add(texto_Comunidad);

        final JLabel label_Telefono = Elementos.crearJLabel(260, 270, 70, 20, "Telefono:", false);
        Panel1.add(label_Telefono);

        final JTextField text_Telefono = Elementos.crearJTextField(330, 270, 110, 20, "", true);
        Panel1.add(text_Telefono);

        text_Telefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == '+')) {
                    evt.consume();
                }
            }
        });

        final JLabel label_Religion = Elementos.crearJLabel(460, 270, 70, 20, "Religion:", false);
        fila_x += label_Religion.getWidth();
        Panel1.add(label_Religion);

        final JTextField text_Religion = Elementos.crearJTextField(525, 270, 120, 20, "", true);
        fila_x += text_Religion.getWidth();
        Panel1.add(text_Religion);

        // Sexta linea Datos del representante
        fila_x = 36;
        final JLabel label_Madre_N_A = Elementos.crearJLabel(fila_x, 355, 220, 20, "Nombre y apellido de la madre:",
                false);
        fila_x += label_Madre_N_A.getWidth();
        Panel1.add(label_Madre_N_A);

        final JTextField texto_Madre_N_A = Elementos.crearJTextField(fila_x + 5, 355, 300, 20, "", true);
        fila_x += texto_Madre_N_A.getWidth();
        Panel1.add(texto_Madre_N_A);
        texto_Madre_N_A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });
        final JLabel label_Madre_Ocupacion = Elementos.crearJLabel(fila_x + 15, 355, 85, 20, "Ocupacion:", false);
        fila_x += label_Madre_Ocupacion.getWidth();
        Panel1.add(label_Madre_Ocupacion);

        final JTextField texto_Madre_Ocupacion = Elementos.crearJTextField(fila_x + 15, 355, 114, 20, "", true);
        fila_x += texto_Madre_Ocupacion.getWidth();
        Panel1.add(texto_Madre_Ocupacion);
        texto_Madre_Ocupacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        // Octava linea Datos del representante
        fila_x = 36;
        final JLabel label_Padre_N_A = Elementos.crearJLabel(fila_x, 390, 220, 20, "Nombre y apellido del padre:",
                false);
        fila_x += label_Padre_N_A.getWidth();
        Panel1.add(label_Padre_N_A);

        final JTextField texto_Padre_N_A = Elementos.crearJTextField(fila_x + 5, 390, 300, 20, "", true);
        fila_x += texto_Padre_N_A.getWidth();
        Panel1.add(texto_Padre_N_A);
        texto_Padre_N_A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_Padre_Ocupacion = Elementos.crearJLabel(fila_x + 15, 390, 85, 20, "Ocupacion:", false);
        fila_x += label_Padre_Ocupacion.getWidth();
        Panel1.add(label_Padre_Ocupacion);

        final JTextField texto_Padre_Ocupacion = Elementos.crearJTextField(fila_x + 15, 390, 114, 20, "", true);
        fila_x += texto_Padre_Ocupacion.getWidth();
        Panel1.add(texto_Padre_Ocupacion);
        texto_Padre_Ocupacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        // Novena linea
        fila_x = 36;
        final JLabel label_Representante = Elementos.crearJLabel(fila_x, 420, 110, 20, "Representante:", false);
        fila_x += label_Representante.getWidth();
        Panel1.add(label_Representante);

        final JComboBox<String> combo_Representante = new JComboBox<String>(new String[] { "Padre", "Madre", "Otros" });
        combo_Representante.setBounds(fila_x + 5, 420, 80, 20);
        fila_x += combo_Representante.getWidth();
        Panel1.add(combo_Representante);

        final JLabel label_Representante_N = Elementos.crearJLabel(fila_x + 35, 420, 70, 20, "Nombre:", false);
        fila_x += label_Representante_N.getWidth();
        Panel1.add(label_Representante_N);

        final JTextField texto_Representante_N = Elementos.crearJTextField(fila_x + 30, 420, 235, 20, "", true);
        fila_x += texto_Representante_N.getWidth();
        Panel1.add(texto_Representante_N);
        texto_Representante_N.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_Representante_ci = Elementos.crearJLabel(fila_x + 40, 420, 60, 20, "Cédula:", false);
        fila_x += label_Representante_ci.getWidth();
        Panel1.add(label_Representante_ci);

        final JComboBox<String> combo__Representante_ci = new JComboBox<String>(new String[] { "V", "E" });
        combo__Representante_ci.setBounds(fila_x + 40, 420, 40, 20);
        fila_x += combo__Representante_ci.getWidth();
        Panel1.add(combo__Representante_ci);

        final JTextField texto_Representante_ci = Elementos.crearJTextField(fila_x + 42, 420, 100, 20, "", true);
        fila_x += texto_Representante_ci.getWidth();
        Panel1.add(texto_Representante_ci);
        texto_Representante_ci.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_Representante_Telefono = Elementos.crearJLabel(fila_x + 50, 420, 70, 20, "Telefono:", false);
        fila_x += label_Representante_Telefono.getWidth();
        Panel1.add(label_Representante_Telefono);

        final JTextField texto_Representante_Telefono = Elementos.crearJTextField(fila_x + 50, 420, 100, 20, "", true);
        fila_x += texto_Representante_Telefono.getWidth();
        Panel1.add(texto_Representante_Telefono);
        texto_Representante_Telefono.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        // Décima linea Patologias
        final JLabel label_CarnetPrenatal = Elementos.crearJLabel(36, 500, 180, 20, "Carnet prenatal:", false);
        Panel1.add(label_CarnetPrenatal);

        final JComboBox<String> combo_Carnet_prenatal = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Carnet_prenatal.setBounds(216, 500, 40, 20);
        Panel1.add(combo_Carnet_prenatal);

        final JLabel NConsultasPrenatales = Elementos.crearJLabel(280, 500, 180, 20, "N~ Consultas prenatales:", false);
        Panel1.add(NConsultasPrenatales);

        final JTextField text_NConsultasPrenatales = Elementos.crearJTextField(470, 500, 60, 20, "", true);
        Panel1.add(text_NConsultasPrenatales);

        final JLabel label_patologiaEmbarazo = Elementos.crearJLabel(36, 530, 180, 20, "Patologia embarazo:", false);
        Panel1.add(label_patologiaEmbarazo);

        final JComboBox<String> combo_patologiaEmbarazo = new JComboBox<String>(new String[] { "Si", "No" });
        combo_patologiaEmbarazo.setBounds(216, 530, 40, 20);
        Panel1.add(combo_patologiaEmbarazo);

        final JLabel label_patologiaParto = Elementos.crearJLabel(36, 560, 180, 20, "Patologia parto:", false);
        Panel1.add(label_patologiaParto);

        final JComboBox<String> combo_patologiaParto = new JComboBox<String>(new String[] { "Si", "No" });
        combo_patologiaParto.setBounds(216, 560, 40, 20);
        Panel1.add(combo_patologiaParto);

        final JLabel label_patologiaPuerperio = Elementos.crearJLabel(36, 590, 180, 20, "Patologia puerperio:", false);
        Panel1.add(label_patologiaPuerperio);

        final JComboBox<String> combo_patologiaPuerperio = new JComboBox<String>(new String[] { "Si", "No" });
        combo_patologiaPuerperio.setBounds(216, 590, 40, 20);
        Panel1.add(combo_patologiaPuerperio);

        final JLabel label_Hrs_fuera_de_casa = Elementos.crearJLabel(600, 540, 160, 20, "Hrs fuera de casa", false);
        Panel1.add(label_Hrs_fuera_de_casa);

        final JTextField texto_Hrs_fuera_de_casa = Elementos.crearJTextField(640, 570, 50, 20, "", true);
        Panel1.add(texto_Hrs_fuera_de_casa);
        texto_Hrs_fuera_de_casa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_MadreFamilia = Elementos.crearJLabel(790, 550, 80, 20, "Madre:", false);
        Panel1.add(label_MadreFamilia);

        final JComboBox<String> combo_MadreFamilia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_MadreFamilia.setBounds(845, 550, 40, 20);
        Panel1.add(combo_MadreFamilia);

        final JLabel label_PadreFamilia = Elementos.crearJLabel(790, 580, 80, 20, "Padre:", false);
        Panel1.add(label_PadreFamilia);

        final JComboBox<String> combo_PadreFamilia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_PadreFamilia.setBounds(845, 580, 40, 20);
        Panel1.add(combo_PadreFamilia);

        final JLabel label_HermanoFamilia = Elementos.crearJLabel(900, 550, 80, 20, "Hermano:", false);
        Panel1.add(label_HermanoFamilia);

        final JComboBox<String> combo_HermanoFamilia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_HermanoFamilia.setBounds(980, 550, 40, 20);
        Panel1.add(combo_HermanoFamilia);

        final JLabel label_OtrosFamilia = Elementos.crearJLabel(900, 580, 80, 20, "Otros:", false);
        Panel1.add(label_OtrosFamilia);

        final JTextField text_OtrosFamilia = Elementos.crearJTextField(950, 580, 80, 20, "", true);
        Panel1.add(text_OtrosFamilia);

        text_OtrosFamilia.addKeyListener(new KeyAdapter() {

        });

        // Botón Volver al menu
        final JLabel volverButton = new JLabel("VOLVER", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        volverButton.setBounds(20, 650, 308, 67);
        volverButton.setFont(new Font("Roboto Black", 1, 22));
        volverButton.setForeground(Elementos.colores(Inicio.Tema));
        volverButton.setVerticalTextPosition(SwingConstants.CENTER);
        volverButton.setHorizontalTextPosition(SwingConstants.CENTER);
        volverButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Buscador Buscador = new Buscador();
                Buscador.setVisible(true);
                dispose();
            }

            public void mouseEntered(MouseEvent e) {
                volverButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                volverButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel1.add(volverButton);

        // Botón Limpiar datos
        final JLabel limpiarD_Button = new JLabel("LIMPIAR CAMPOS", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
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
                        text_ci,
                        text_apellido,
                        text_nombre,
                        text_Ocupacion,
                        text_anosAprobados,
                        text_LugarNacimiento,
                        texto_Direccion,
                        text_Telefono,
                        text_Religion,
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
                combo_Pais.setSelectedIndex(0);
                combo_Estado.setSelectedIndex(0);
            }

            public void mouseEntered(MouseEvent e) {
                limpiarD_Button.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                limpiarD_Button.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel1.add(limpiarD_Button);

        // Botón Siguiente
        final JLabel siguienteButton = new JLabel("SIGUIENTE", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        siguienteButton.setBounds(800, 650, 308, 67);
        siguienteButton.setFont(new Font("Roboto Black", 1, 22));
        siguienteButton.setForeground(Elementos.colores(Inicio.Tema));
        siguienteButton.setVerticalTextPosition(SwingConstants.CENTER);
        siguienteButton.setHorizontalTextPosition(SwingConstants.CENTER);

        siguienteButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JComponent[] Componentes = {
                        text_apellido_familiar,
                        text_ci_jefe_familia,
                        text_ci,
                        text_apellido,
                        text_nombre,
                        text_Ocupacion,
                        text_anosAprobados,
                        combo_Pais,
                        combo_Estado,
                        text_LugarNacimiento,
                        texto_Direccion,
                        text_Telefono,
                        text_Religion,
                        texto_Establecimiento,
                        texto_Parroquia,
                        texto_Comunidad,
                        calendario
                };
                JComponent[] nuevoArrayComponentes = new JComponent[Componentes.length + 1];
                System.arraycopy(Componentes, 0, nuevoArrayComponentes, 0, Componentes.length);
                if (texto_Municipio.isVisible()) {
                    nuevoArrayComponentes[Componentes.length] = texto_Municipio;
                } else {
                    nuevoArrayComponentes[Componentes.length] = Combo_municipio;
                }
                Componentes = nuevoArrayComponentes;

                int datosFaltantes = 0;
                for (final JComponent Component : Componentes) {
                    if (Component instanceof JTextField) {
                        if (((JTextField) Component).getText().isEmpty()) {
                            Component.setBackground(Color.red);
                            datosFaltantes++;
                        }
                    } else if (Component instanceof JComboBox) {
                        if (((JComboBox<?>) Component).getSelectedItem().toString().equalsIgnoreCase("Seleccionar")) {
                            Component.setBackground(Color.red);
                            datosFaltantes++;
                        }
                    } else if (Component instanceof JDateChooser) {
                        if (((JDateChooser) Component).getDate() == null) {
                            Component.setBackground(Color.red);
                            if (datosFaltantes == 0) {
                                JOptionPane.showMessageDialog(null, "Falta colocar la fecha de nacimiento");
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Falta colocar la fecha de nacimiento y otros datos");
                            }
                            datosFaltantes++;
                        }
                    }
                }
                // Verificar si hay datos faltantes después del bucle
                if (datosFaltantes == 0) {
                    cardLayout.show(contentPanel, "panel2");
                }
            }

            public void mouseEntered(MouseEvent e) {
                siguienteButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                siguienteButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel1.add(siguienteButton);

        // Evento de selección para que las casillas en rojo pasen a blancas
        JComponent[] Componentes = {
                text_apellido_familiar,
                text_ci_jefe_familia,
                text_Numero_de_Historia,
                text_ci,
                text_apellido,
                text_nombre,
                text_Ocupacion,
                text_anosAprobados,
                text_LugarNacimiento,
                combo_Pais,
                texto_Direccion,
                text_Telefono,
                text_Religion,
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
        for (final JComponent Componte : Componentes) {
            Componte.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    Componte.setBackground(Color.white);
                }
            });
        }

        // FONDO
        JLabel fondo = new JLabel();
        if (Inicio.Tema == "Oscuro") {
            fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Oscuro/NHM_part1-Oscuro.png")));
        } else {
            fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/NHM_part1-claro.png")));
        }
        fondo.setBounds(0, 0, 1290, 720);
        Panel1.add(fondo);
        contentPanel.add(Panel1, "panel1");

        // Segundo Panel

        Panel2.setLayout(null);
        Panel2.setBounds(0, 0, 1120, 720);
        add(Panel2);
        // Cerrar ventana
        final JLabel cerrar2 = Elementos.cerrar(1090, 10, 20, 20);
        Panel2.add(cerrar2);
        cerrar2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose(); // Cierra la ventana
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
                setExtendedState(1);
            }

            public void mouseEntered(MouseEvent e) {
                Minimizar2.setForeground(Color.red);
            }

            public void mouseExited(MouseEvent e) {
                Minimizar2.setForeground(Color.white);
            }
        });

        // Edad_Gestacion *edad - Semanas

        int fila_x2 = 36;
        final JLabel label_Edad_Gestacion = Elementos.crearJLabel(fila_x2, 65, 130, 20, "Edad Gestacional:", false);
        fila_x2 += label_Edad_Gestacion.getWidth();
        Panel2.add(label_Edad_Gestacion);

        final JTextField text_Edad_Gestacion = Elementos.crearJTextField(fila_x2 + 5, 65, 50, 20, "", true);
        fila_x2 += text_Edad_Gestacion.getWidth();
        Panel2.add(text_Edad_Gestacion);
        text_Edad_Gestacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == '.' || c == ',' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_sem = Elementos.crearJLabel(fila_x2 + 10, 65, 80, 20, "Semanas:", false);
        fila_x2 += label_sem.getWidth();
        Panel2.add(label_sem);

        final JTextField text_sem = Elementos.crearJTextField(fila_x2 + 15, 65, 50, 20, "", true);
        fila_x2 += text_sem.getWidth();
        Panel2.add(text_sem);
        text_sem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == '.' || c == ',' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        fila_x2 = 36;
        final JLabel label_Forces = Elementos.crearJLabel(fila_x2, 95, 65, 20, "Fórceps:", false);
        fila_x2 += label_Forces.getWidth();
        Panel2.add(label_Forces);

        final JComboBox<String> combo_Forces = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Forces.setBounds(fila_x2 + 5, 95, 50, 20);
        fila_x2 += combo_Forces.getWidth();
        Panel2.add(combo_Forces);

        final JLabel label_Cesarea = Elementos.crearJLabel(fila_x2 + 35, 95, 70, 20, "Cesárea:", false);
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
        text_Peso_al_nacer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == '.' || c == ',' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

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

        final JLabel label_Circunferencia = Elementos.crearJLabel(fila_x2 + 150, 95, 170, 20,
                "Circunferencia cefálica:",
                false);
        fila_x2 += label_Circunferencia.getWidth();
        Panel2.add(label_Circunferencia);

        final JTextField text_Circunferencia = Elementos.crearJTextField(fila_x2 + 150, 95, 50, 20, "", true);
        fila_x2 += text_Circunferencia.getWidth();
        Panel2.add(text_Circunferencia);
        text_Circunferencia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == '.' || c == ',' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_Circunferencia_cm = Elementos.crearJLabel(fila_x2 + 155, 95, 20, 20, "cm", false);
        fila_x2 += label_Circunferencia_cm.getWidth();
        Panel2.add(label_Circunferencia_cm);

        // segunda linea
        fila_x2 = 36;
        final JLabel label_ApgarMin = Elementos.crearJLabel(fila_x2, 125, 80, 20, "Apgar min:", false);
        fila_x2 += label_ApgarMin.getWidth();
        Panel2.add(label_ApgarMin);

        final JTextField text_ApgarMin = Elementos.crearJTextField(fila_x2 + 5, 125, 80, 20, "", true);
        fila_x2 += text_ApgarMin.getWidth();
        Panel2.add(text_ApgarMin);
        text_ApgarMin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JLabel label_Asfixia = Elementos.crearJLabel(fila_x2 + 35, 125, 60, 25, "Asfixia:", false);
        fila_x2 += label_Asfixia.getWidth();
        Panel2.add(label_Asfixia);

        final JComboBox<String> combo_Asfixia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Asfixia.setBounds(fila_x2 + 35, 125, 50, 20);
        fila_x2 += combo_Asfixia.getWidth();
        Panel2.add(combo_Asfixia);

        final JLabel label_Reanimacion = Elementos.crearJLabel(fila_x2 + 65, 125, 100, 20, "Reanimación:", false);
        fila_x2 += label_Reanimacion.getWidth();
        Panel2.add(label_Reanimacion);

        final JComboBox<String> combo_Reanimacion = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Reanimacion.setBounds(fila_x2 + 65, 125, 50, 20);
        fila_x2 += combo_Reanimacion.getWidth();
        Panel2.add(combo_Reanimacion);

        final JLabel label_PatologiasRN = Elementos.crearJLabel(fila_x2 + 95, 125, 110, 20, "Patologias RN:", false);
        fila_x2 += label_PatologiasRN.getWidth();
        Panel2.add(label_PatologiasRN);

        final JComboBox<String> combo_PatologiasRN = new JComboBox<String>(new String[] { "Si", "No" });
        combo_PatologiasRN.setBounds(fila_x2 + 95, 125, 50, 20);
        fila_x2 += combo_PatologiasRN.getWidth();
        Panel2.add(combo_PatologiasRN);

        final JLabel label_EgresoRN = Elementos.crearJLabel(fila_x2 + 125, 125, 100, 20, "Egreso RN:", false);
        fila_x2 += label_EgresoRN.getWidth();
        Panel2.add(label_EgresoRN);

        final JComboBox<String> combo_EgresoRN = new JComboBox<String>(new String[] { "Sanos", "Patológico" });
        combo_EgresoRN.setBounds(fila_x2 + 125, 125, 95, 20);
        fila_x2 += combo_EgresoRN.getWidth();
        Panel2.add(combo_EgresoRN);

        // tercera linea
        fila_x2 = 36;
        final JLabel label_lactancia = Elementos.crearJLabel(fila_x2, 160, 80, 20, "Lactancia:", false);
        fila_x2 += label_lactancia.getWidth();
        Panel2.add(label_lactancia);

        final JLabel label_Exclusiva = Elementos.crearJLabel(fila_x2 + 30, 160, 80, 20, "Exclusiva:", false);
        fila_x2 += label_Exclusiva.getWidth();
        Panel2.add(label_Exclusiva);

        final JTextField text_Exclusiva = Elementos.crearJTextField(fila_x2 + 30, 160, 80, 20, "", true);
        fila_x2 += text_Exclusiva.getWidth();
        Panel2.add(text_Exclusiva);

        final JLabel label_Exclusiva_m = Elementos.crearJLabel(fila_x2 + 35, 160, 20, 20, "m", false);
        fila_x2 += label_Exclusiva_m.getWidth();
        Panel2.add(label_Exclusiva_m);

        final JLabel label_Mixta = Elementos.crearJLabel(fila_x2 + 60, 160, 50, 20, "Mixta:", false);
        fila_x2 += label_Mixta.getWidth();
        Panel2.add(label_Mixta);

        final JTextField text_Mixta = Elementos.crearJTextField(fila_x2 + 60, 160, 80, 20, "", true);
        fila_x2 += text_Mixta.getWidth();
        Panel2.add(text_Mixta);

        final JLabel label_Mixta_m = Elementos.crearJLabel(fila_x2 + 65, 160, 20, 20, "m", false);
        fila_x2 += label_Mixta_m.getWidth();
        Panel2.add(label_Mixta_m);

        final JLabel label_Ablactacion = Elementos.crearJLabel(fila_x2 + 90, 160, 90, 20, "Ablactacion:", false);
        fila_x2 += label_Ablactacion.getWidth();
        Panel2.add(label_Ablactacion);

        final JTextField text_Ablactacion = Elementos.crearJTextField(fila_x2 + 90, 160, 80, 20, "", true);
        fila_x2 += text_Ablactacion.getWidth();
        Panel2.add(text_Ablactacion);

        final JLabel label_Ablactacion_m = Elementos.crearJLabel(fila_x2 + 95, 160, 20, 20, "m", false);
        fila_x2 += label_Ablactacion_m.getWidth();
        Panel2.add(label_Ablactacion_m);

        // Primera fila
        fila_x2 = 36;
        int fila_y = 250;

        final JLabel label_Alergia = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Alergia:", false);
        fila_x2 += label_Alergia.getWidth();
        Panel2.add(label_Alergia);

        final JComboBox<String> combo_Alergia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Alergia.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Alergia.getWidth();
        Panel2.add(combo_Alergia);

        fila_y = 290;
        fila_x2 = 36;
        final JLabel label_Asma = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Asma:", false);
        fila_x2 += label_Asma.getWidth();
        Panel2.add(label_Asma);

        final JComboBox<String> combo_Asma = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Asma.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Asma.getWidth();
        Panel2.add(combo_Asma);

        fila_y = 330;
        fila_x2 = 36;
        final JLabel label_TBC = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "T.B.C:", false);
        fila_x2 += label_TBC.getWidth();
        Panel2.add(label_TBC);

        final JComboBox<String> combo_TBC = new JComboBox<String>(new String[] { "Si", "No" });
        combo_TBC.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_TBC.getWidth();
        Panel2.add(combo_TBC);

        fila_y = 370;
        fila_x2 = 36;
        final JLabel label_Cardiopatia = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Cardiopatia:", false);
        fila_x2 += label_Cardiopatia.getWidth();
        Panel2.add(label_Cardiopatia);

        final JComboBox<String> combo_Cardiopatia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Cardiopatia.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Cardiopatia.getWidth();
        Panel2.add(combo_Cardiopatia);

        fila_y = 410;
        fila_x2 = 36;
        final JLabel label_Hipertension = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Hipertensión:", false);
        fila_x2 += label_Hipertension.getWidth();
        Panel2.add(label_Hipertension);

        final JComboBox<String> combo_Hipertension = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hipertension.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Hipertension.getWidth();
        Panel2.add(combo_Hipertension);

        fila_y = 450;
        fila_x2 = 36;
        final JLabel label_Varice = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Varices:", false);
        fila_x2 += label_Varice.getWidth();
        Panel2.add(label_Varice);

        final JComboBox<String> combo_Varice = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Varice.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Varice.getWidth();
        Panel2.add(combo_Varice);

        fila_y = 490;
        fila_x2 = 36;
        final JLabel label_Desnutricion = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Desnutrición:", false);
        fila_x2 += label_Desnutricion.getWidth();
        Panel2.add(label_Desnutricion);

        final JComboBox<String> combo_Desnutricion = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Desnutricion.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Desnutricion.getWidth();
        Panel2.add(combo_Desnutricion);

        // Segunda fila
        fila_x2 = 220;
        fila_y = 250;
        final JLabel label_Diabetes = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Diabetes:", false);
        fila_x2 += label_Diabetes.getWidth();
        Panel2.add(label_Diabetes);

        final JComboBox<String> combo_Diabetes = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Diabetes.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Diabetes.getWidth();
        Panel2.add(combo_Diabetes);

        fila_x2 = 220;
        fila_y = 290;
        final JLabel label_Obesidad = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Obesidad:", false);
        fila_x2 += label_Obesidad.getWidth();
        Panel2.add(label_Obesidad);

        final JComboBox<String> combo_Obesidad = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Obesidad.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Obesidad.getWidth();
        Panel2.add(combo_Obesidad);

        fila_x2 = 220;
        fila_y = 330;
        final JLabel label_Gastropatia = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Gastropatia:", false);
        fila_x2 += label_Gastropatia.getWidth();
        Panel2.add(label_Gastropatia);

        final JComboBox<String> combo_Gastropatia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Gastropatia.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Gastropatia.getWidth();
        Panel2.add(combo_Gastropatia);

        fila_x2 = 220;
        fila_y = 370;
        final JLabel label_Neurologica = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Neurologica:", false);
        fila_x2 += label_Neurologica.getWidth();
        Panel2.add(label_Neurologica);

        final JComboBox<String> combo_Neurologica = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Neurologica.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Neurologica.getWidth();
        Panel2.add(combo_Neurologica);

        fila_x2 = 220;
        fila_y = 410;
        final JLabel label_Enf_Renal = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Enf.Renal:", false);
        fila_x2 += label_Enf_Renal.getWidth();
        Panel2.add(label_Enf_Renal);

        final JComboBox<String> combo_Enf_Renal = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_Renal.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Enf_Renal.getWidth();
        Panel2.add(combo_Enf_Renal);

        fila_x2 = 220;
        fila_y = 450;
        final JLabel label_Cancer = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Cancer:", false);
        fila_x2 += label_Cancer.getWidth();
        Panel2.add(label_Cancer);

        final JComboBox<String> combo_Cancer = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Cancer.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Cancer.getWidth();
        Panel2.add(combo_Cancer);

        fila_x2 = 220;
        fila_y = 490;
        final JLabel label_Alcohol = Elementos.crearJLabel(fila_x2, fila_y, 100, 20, "Alcohol:", false);
        fila_x2 += label_Alcohol.getWidth();
        Panel2.add(label_Alcohol);

        final JComboBox<String> combo_Alcohol = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Alcohol.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Alcohol.getWidth();
        Panel2.add(combo_Alcohol);

        // Tercera fila
        fila_x2 = 400;
        fila_y = 250;
        final JLabel label_Drogas = Elementos.crearJLabel(fila_x2, fila_y, 70, 20, "Drogas:", false);
        fila_x2 += label_Drogas.getWidth();
        Panel2.add(label_Drogas);

        final JComboBox<String> combo_Drogas = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Drogas.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Drogas.getWidth();
        Panel2.add(combo_Drogas);

        fila_x2 = 400;
        fila_y = 290;
        final JLabel label_Sífilis = Elementos.crearJLabel(fila_x2, fila_y, 70, 20, "Sífilis:", false);
        fila_x2 += label_Sífilis.getWidth();
        Panel2.add(label_Sífilis);

        final JComboBox<String> combo_Sífilis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Sífilis.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Sífilis.getWidth();
        Panel2.add(combo_Sífilis);

        fila_x2 = 400;
        fila_y = 330;
        final JLabel label_SIDA = Elementos.crearJLabel(fila_x2, fila_y, 70, 20, "SIDA:", false);
        fila_x2 += label_SIDA.getWidth();
        Panel2.add(label_SIDA);

        final JComboBox<String> combo_SIDA = new JComboBox<String>(new String[] { "Si", "No" });
        combo_SIDA.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_SIDA.getWidth();
        Panel2.add(combo_SIDA);

        fila_x2 = 400;
        fila_y = 370;
        final JLabel label_Artritis = Elementos.crearJLabel(fila_x2, fila_y, 70, 20, "Artritis:", false);
        fila_x2 += label_Artritis.getWidth();
        Panel2.add(label_Artritis);

        final JComboBox<String> combo_Artritis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Artritis.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Artritis.getWidth();
        Panel2.add(combo_Artritis);

        fila_x2 = 400;
        fila_y = 410;
        final JLabel label_otros = Elementos.crearJLabel(fila_x2, fila_y, 70, 20, "Otros:", false);
        fila_x2 += label_otros.getWidth();
        Panel2.add(label_otros);

        final JComboBox<String> combo_otros = new JComboBox<String>(new String[] { "Si", "No" });
        combo_otros.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_otros.getWidth();
        Panel2.add(combo_otros);

        // Cuarta fila
        fila_x2 = 600;
        fila_y = 250;
        final JLabel label_Padre = Elementos.crearJLabel(fila_x2, fila_y, 50, 20, "Padre:", false);
        fila_x2 += label_Padre.getWidth();
        Panel2.add(label_Padre);

        final JComboBox<String> combo_Padre = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Padre.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Padre.getWidth();
        Panel2.add(combo_Padre);

        fila_x2 = 600;
        fila_y = 290;
        final JLabel label_Madre = Elementos.crearJLabel(fila_x2, fila_y, 50, 20, "Madre:", false);
        fila_x2 += label_Madre.getWidth();
        Panel2.add(label_Madre);

        final JComboBox<String> combo_Madre = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Madre.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Madre.getWidth();
        Panel2.add(combo_Madre);

        fila_x2 = 600;
        fila_y = 330;
        final JLabel label_Hermanos = Elementos.crearJLabel(fila_x2, fila_y, 110, 20, "Hermanos(as):", false);
        fila_x2 += label_Hermanos.getWidth();
        Panel2.add(label_Hermanos);

        final JComboBox<String> combo_Hermanos = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hermanos.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Hermanos.getWidth();
        Panel2.add(combo_Hermanos);

        fila_x2 = 600;
        fila_y = 370;
        final JLabel label_Otros = Elementos.crearJLabel(fila_x2, fila_y, 50, 20, "Otros:", false);
        fila_x2 += label_Otros.getWidth();
        Panel2.add(label_Otros);

        final JComboBox<String> combo_Otros = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Otros.setBounds(fila_x2, fila_y, 50, 20);
        fila_x2 += combo_Otros.getWidth();
        Panel2.add(combo_Otros);

        // Botón Volver
        final JLabel volverButton2 = new JLabel("VOLVER", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        volverButton2.setBounds(20, 650, 308, 67);
        volverButton2.setFont(new Font("Roboto Black", 1, 22));
        volverButton2.setForeground(Elementos.colores(Inicio.Tema));
        volverButton2.setVerticalTextPosition(SwingConstants.CENTER);
        volverButton2.setHorizontalTextPosition(SwingConstants.CENTER);
        volverButton2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(contentPanel, "panel1");
            }

            public void mouseEntered(MouseEvent e) {
                volverButton2.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                volverButton2.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel2.add(volverButton2);

        contentPanel.add(Panel2, "panel2");

        // Botón Siguiente
        final JLabel siguienteButton2 = new JLabel("SIGUIENTE", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        siguienteButton2.setBounds(800, 650, 308, 67);
        siguienteButton2.setFont(new Font("Roboto Black", 1, 22));
        siguienteButton2.setForeground(Elementos.colores(Inicio.Tema));
        siguienteButton2.setVerticalTextPosition(SwingConstants.CENTER);
        siguienteButton2.setHorizontalTextPosition(SwingConstants.CENTER);

        siguienteButton2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(contentPanel, "panel3");
            }

            public void mouseEntered(MouseEvent e) {
                siguienteButton2.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                siguienteButton2.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel2.add(siguienteButton2);

        // FONDO
        JLabel fondo2 = new JLabel();
        if (Inicio.Tema == "Oscuro") {
            fondo2.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Oscuro/NHM_part2-Oscuro.png")));
        } else {
            fondo2.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/NHM_part2-claro.png")));
        }

        fondo2.setBounds(0, 0, 1290, 720);
        Panel2.add(fondo2);

        // Tercer Panel

        Panel3.setLayout(null);
        Panel3.setBounds(0, 0, 1120, 720);
        add(Panel3);
        // Cerrar ventana
        final JLabel Cerrar3 = Elementos.cerrar(1090, 10, 20, 20);
        Panel3.add(Cerrar3);
        Cerrar3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose(); // Cierra la ventana
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
                setExtendedState(1);
            }

            public void mouseEntered(MouseEvent e) {
                Minimizar3.setForeground(Color.red);
            }

            public void mouseExited(MouseEvent e) {
                Minimizar3.setForeground(Color.white);
            }
        });

        // Primera fila - Arriba
        int fila_x3 = 36;
        int fila_y3 = 50;
        final JLabel label_Menarquia = Elementos.crearJLabel(fila_x3, fila_y3, 90, 20, "Menarquia:", false);
        fila_x3 += label_Menarquia.getWidth();
        Panel3.add(label_Menarquia);

        final JTextField texto_Menarquia = Elementos.crearJTextField(fila_x3, fila_y3, 80, 20, "", true);
        fila_x3 += texto_Menarquia.getWidth();
        Panel3.add(texto_Menarquia);

        fila_x3 = 36;
        fila_y3 = 80;
        final JLabel label_Ciclo_menstrual = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Ciclo menstrual:",
                false);
        fila_x3 += label_Ciclo_menstrual.getWidth();
        Panel3.add(label_Ciclo_menstrual);

        final JTextField texto_Ciclo_menstrual = Elementos.crearJTextField(fila_x3, fila_y3, 50, 20, "", true);
        fila_x3 += texto_Ciclo_menstrual.getWidth();
        Panel3.add(texto_Ciclo_menstrual);

        fila_x3 = 36;
        fila_y3 = 110;
        final JLabel label_PRSexual = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "P.R. Sexual:", false);
        fila_x3 += label_PRSexual.getWidth();
        Panel3.add(label_PRSexual);

        final JTextField texto_PRSexual = Elementos.crearJTextField(fila_x3, fila_y3, 50, 20, "", true);
        fila_x3 += texto_PRSexual.getWidth();
        Panel3.add(texto_PRSexual);

        fila_x3 = 36;
        fila_y3 = 140;
        final JLabel label_FrecuenciaRSexual = Elementos.crearJLabel(fila_x3, fila_y3, 160, 20, "Frecuencia R. Sexual:",
                false);
        fila_x3 += label_FrecuenciaRSexual.getWidth();
        Panel3.add(label_FrecuenciaRSexual);

        final JTextField texto_FrecuenciaRSexual = Elementos.crearJTextField(fila_x3, fila_y3, 50, 20, "", true);
        fila_x3 += texto_FrecuenciaRSexual.getWidth();
        Panel3.add(texto_FrecuenciaRSexual);

        fila_x3 = 36;
        fila_y3 = 170;
        final JLabel label_N_Parejas = Elementos.crearJLabel(fila_x3, fila_y3, 90, 20, "N~ Parejas:", false);
        fila_x3 += label_N_Parejas.getWidth();
        Panel3.add(label_N_Parejas);

        final JTextField texto_N_Parejas = Elementos.crearJTextField(fila_x3, fila_y3, 50, 20, "", true);
        fila_x3 += texto_N_Parejas.getWidth();
        Panel3.add(texto_N_Parejas);
        texto_N_Parejas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        fila_x3 = 36;
        fila_y3 = 200;
        final JLabel label_Dispareunia = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Dispareunia:", false);
        fila_x3 += label_Dispareunia.getWidth();
        Panel3.add(label_Dispareunia);

        final JComboBox<String> combo_Dispareunia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Dispareunia.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Dispareunia.getWidth();
        Panel3.add(combo_Dispareunia);

        // Segunda fila - Arriba
        fila_x3 = 280;
        fila_y3 = 50;
        final JLabel label_Anticoncepcion = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Anticonceptivo:", false);
        fila_x3 += label_Anticoncepcion.getWidth();
        Panel3.add(label_Anticoncepcion);

        final JComboBox<String> combo_Anticoncepcion = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Anticoncepcion.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Anticoncepcion.getWidth();
        Panel3.add(combo_Anticoncepcion);

        fila_x3 = 280;
        fila_y3 = 80;
        final JComboBox<String> combo_AC_DIU = new JComboBox<String>(new String[] { "ACO", "DIU", "Otros" });
        combo_AC_DIU.setBounds(fila_x3, fila_y3, 80, 20);
        fila_x3 += combo_AC_DIU.getWidth();
        Panel3.add(combo_AC_DIU);

        fila_x3 = 280;
        fila_y3 = 110;
        final JLabel label_Menopausia = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Menopausia:", false);
        fila_x3 += label_Menopausia.getWidth();
        Panel3.add(label_Menopausia);

        final JComboBox<String> combo_Menopausia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Menopausia.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Menopausia.getWidth();
        Panel3.add(combo_Menopausia);

        fila_x3 = 280;
        fila_y3 = 140;
        final JLabel label_Gesta = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Gesta", false);
        fila_x3 += label_Gesta.getWidth();
        Panel3.add(label_Gesta);

        final JComboBox<String> combo_Gesta = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Gesta.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Gesta.getWidth();
        Panel3.add(combo_Gesta);

        fila_x3 = 280;
        fila_y3 = 170;
        final JLabel label_Partos = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Partos:", false);
        fila_x3 += label_Partos.getWidth();
        Panel3.add(label_Partos);

        final JComboBox<String> combo_Partos = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Partos.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Partos.getWidth();
        Panel3.add(combo_Partos);

        fila_x3 = 280;
        fila_y3 = 200;
        final JLabel label_Cesarea2 = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Cesarea:", false);
        fila_x3 += label_Cesarea2.getWidth();
        Panel3.add(label_Cesarea2);

        final JComboBox<String> combo_Cesarea2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Cesarea2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Cesarea2.getWidth();
        Panel3.add(combo_Cesarea2);

        // tercera fila - Arriba
        fila_x3 = 500;
        fila_y3 = 50;
        final JLabel label_Aborto = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Aborto:", false);
        fila_x3 += label_Aborto.getWidth();
        Panel3.add(label_Aborto);

        final JComboBox<String> combo_Aborto = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Aborto.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Aborto.getWidth();
        Panel3.add(combo_Aborto);

        fila_x3 = 500;
        fila_y3 = 80;
        final JLabel label_E1erParto = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "E 1er parto:", false);
        fila_x3 += label_E1erParto.getWidth();
        Panel3.add(label_E1erParto);

        final JTextField texto_E1erParto = Elementos.crearJTextField(fila_x3, fila_y3, 50, 20, "", true);
        fila_x3 += texto_E1erParto.getWidth();
        Panel3.add(texto_E1erParto);

        fila_x3 = 500;
        fila_y3 = 110;
        final JLabel label_F_U_Parto = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "F.U parto:", false);
        fila_x3 += label_F_U_Parto.getWidth();
        Panel3.add(label_F_U_Parto);

        final JTextField texto_F_U_Parto = Elementos.crearJTextField(fila_x3, fila_y3, 50, 20, "", true);
        fila_x3 += texto_F_U_Parto.getWidth();
        Panel3.add(texto_F_U_Parto);

        fila_x3 = 500;
        fila_y3 = 140;
        final JLabel label_F_UAborto = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "F.U Aborto:", false);
        fila_x3 += label_F_UAborto.getWidth();
        Panel3.add(label_F_UAborto);

        final JTextField texto_F_UAborto = Elementos.crearJTextField(fila_x3, fila_y3, 50, 20, "", true);
        fila_x3 += texto_F_UAborto.getWidth();
        Panel3.add(texto_F_UAborto);

        // Cuarta fila - Arriba
        fila_x3 = 700;
        fila_y3 = 50;
        final JLabel label_Curetaje = Elementos.crearJLabel(fila_x3, fila_y3, 80, 20, "Curetaje:", false);
        fila_x3 += label_Curetaje.getWidth();
        Panel3.add(label_Curetaje);

        final JTextField combo_Curetaje = Elementos.crearJTextField(fila_x3, fila_y3, 80, 20, "", true);
        fila_x3 += combo_Curetaje.getWidth();
        Panel3.add(combo_Curetaje);

        fila_x3 = 700;
        fila_y3 = 80;
        final JLabel label_N_de_Hijos = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "N~ de Hijos:", false);
        fila_x3 += label_N_de_Hijos.getWidth();
        Panel3.add(label_N_de_Hijos);

        final JTextField texto_N_de_Hijos = Elementos.crearJTextField(fila_x3, fila_y3, 50, 20, "", true);
        fila_x3 += texto_N_de_Hijos.getWidth();
        Panel3.add(texto_N_de_Hijos);

        fila_x3 = 700;
        fila_y3 = 110;
        final JLabel label_Vivos = Elementos.crearJLabel(fila_x3, fila_y3, 80, 20, "Vivos:", false);
        fila_x3 += label_Vivos.getWidth();
        Panel3.add(label_Vivos);

        final JTextField texto_Vivos = Elementos.crearJTextField(fila_x3, fila_y3, 50, 20, "", true);
        fila_x3 += texto_Vivos.getWidth();
        Panel3.add(texto_Vivos);

        fila_x3 = 700;
        fila_y3 = 140;
        final JLabel label_Muertos = Elementos.crearJLabel(fila_x3, fila_y3, 80, 20, "Muertos:", false);
        fila_x3 += label_Muertos.getWidth();
        Panel3.add(label_Muertos);

        final JTextField texto_Muertos = Elementos.crearJTextField(fila_x3, fila_y3, 50, 20, "", true);
        fila_x3 += texto_Muertos.getWidth();
        Panel3.add(texto_Muertos);

        fila_x3 = 700;
        fila_y3 = 170;
        final JLabel label_RN_mayor_peso = Elementos.crearJLabel(fila_x3, fila_y3, 150, 20, "RN de mayor peso:", false);
        fila_x3 += label_RN_mayor_peso.getWidth();
        Panel3.add(label_RN_mayor_peso);

        final JTextField text_RN_de_mayor_peso = Elementos.crearJTextField(fila_x3, fila_y3, 50, 20, "", true);
        fila_x3 += text_RN_de_mayor_peso.getWidth();
        Panel3.add(text_RN_de_mayor_peso);

        final JLabel label_RN_de_mayor_peso_gr = Elementos.crearJLabel(fila_x3 + 10, fila_y3, 20, 20, "gr:", false);
        fila_x3 += label_RN_de_mayor_peso_gr.getWidth();
        Panel3.add(label_RN_de_mayor_peso_gr);
        text_RN_de_mayor_peso.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == '.' || c == ',' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        // Primera fila - abajo
        fila_x3 = 36;
        fila_y3 = 270;
        final JLabel label_Alergia2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Alergia:", false);
        fila_x3 += label_Alergia2.getWidth();
        Panel3.add(label_Alergia2);

        final JComboBox<String> combo_Alergia2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Alergia2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Alergia2.getWidth();
        Panel3.add(combo_Alergia2);

        fila_x3 = 36;
        fila_y3 = 300;
        final JLabel label_Asma2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Asma:", false);
        fila_x3 += label_Asma2.getWidth();
        Panel3.add(label_Asma2);

        final JComboBox<String> combo_Asma2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Asma2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Asma2.getWidth();
        Panel3.add(combo_Asma2);

        fila_x3 = 36;
        fila_y3 = 330;
        final JLabel label_Neumonia = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Neumonía", false);
        fila_x3 += label_Neumonia.getWidth();
        Panel3.add(label_Neumonia);

        final JComboBox<String> combo_Neumonia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Neumonia.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Neumonia.getWidth();
        Panel3.add(combo_Neumonia);

        fila_x3 = 36;
        fila_y3 = 360;
        final JLabel label_TBC2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "T.B.C:", false);
        fila_x3 += label_TBC2.getWidth();
        Panel3.add(label_TBC2);

        final JComboBox<String> combo_TBC2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_TBC2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_TBC2.getWidth();
        Panel3.add(combo_TBC2);

        fila_x3 = 36;
        fila_y3 = 390;
        final JLabel label_Cardiopatia2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Cardiopatia:", false);
        fila_x3 += label_Cardiopatia2.getWidth();
        Panel3.add(label_Cardiopatia2);

        final JComboBox<String> combo_Cardiopatia2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Cardiopatia2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Cardiopatia2.getWidth();
        Panel3.add(combo_Cardiopatia2);

        fila_x3 = 36;
        fila_y3 = 420;
        final JLabel label_Hipertension2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Hipertension:", false);
        fila_x3 += label_Hipertension2.getWidth();
        Panel3.add(label_Hipertension2);

        final JComboBox<String> combo_Hipertension2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hipertension2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Hipertension2.getWidth();
        Panel3.add(combo_Hipertension2);

        fila_x3 = 36;
        fila_y3 = 450;
        final JLabel label_Hiperlipidemias = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Hiperlipidemias:",
                false);
        fila_x3 += label_Hiperlipidemias.getWidth();
        Panel3.add(label_Hiperlipidemias);

        final JComboBox<String> combo_Hiperlipidemias = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hiperlipidemias.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Hiperlipidemias.getWidth();
        Panel3.add(combo_Hiperlipidemias);

        fila_x3 = 36;
        fila_y3 = 480;
        final JLabel label_Varices = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Varices:", false);
        fila_x3 += label_Varices.getWidth();
        Panel3.add(label_Varices);

        final JComboBox<String> combo_Varices = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Varices.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Varices.getWidth();
        Panel3.add(combo_Varices);

        // Segunda fila - abajo
        fila_x3 = 280;
        fila_y3 = 270;
        final JLabel label_Hepatopatia = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Hepatopatia:", false);
        fila_x3 += label_Hepatopatia.getWidth();
        Panel3.add(label_Hepatopatia);

        final JComboBox<String> combo_Hepatopatia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hepatopatia.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Hepatopatia.getWidth();
        Panel3.add(combo_Hepatopatia);

        fila_x3 = 280;
        fila_y3 = 300;
        final JLabel label_Desnutricion2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Desnutricion:", false);
        fila_x3 += label_Desnutricion2.getWidth();
        Panel3.add(label_Desnutricion2);

        final JComboBox<String> combo_Desnutricion2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Desnutricion2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Desnutricion2.getWidth();
        Panel3.add(combo_Desnutricion2);

        fila_x3 = 280;
        fila_y3 = 330;
        final JLabel label_Diabetes2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Diabetes", false);
        fila_x3 += label_Diabetes2.getWidth();
        Panel3.add(label_Diabetes2);

        final JComboBox<String> combo_Diabetes2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Diabetes2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Diabetes2.getWidth();
        Panel3.add(combo_Diabetes2);

        fila_x3 = 280;
        fila_y3 = 360;
        final JLabel label_Obesidad2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Obesidad:", false);
        fila_x3 += label_Obesidad2.getWidth();
        Panel3.add(label_Obesidad2);

        final JComboBox<String> combo_Obesidad2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Obesidad2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Obesidad2.getWidth();
        Panel3.add(combo_Obesidad2);

        fila_x3 = 280;
        fila_y3 = 390;
        final JLabel label_Gastroenteritis = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Gastroenteritis:",
                false);
        fila_x3 += label_Gastroenteritis.getWidth();
        Panel3.add(label_Gastroenteritis);

        final JComboBox<String> combo_Gastroenteritis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Gastroenteritis.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Gastroenteritis.getWidth();
        Panel3.add(combo_Gastroenteritis);

        fila_x3 = 280;
        fila_y3 = 420;
        final JLabel label_Encoprexis = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Encoprexis:", false);
        fila_x3 += label_Encoprexis.getWidth();
        Panel3.add(label_Encoprexis);

        final JComboBox<String> combo_Encoprexis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Encoprexis.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Encoprexis.getWidth();
        Panel3.add(combo_Encoprexis);

        fila_x3 = 280;
        fila_y3 = 450;
        final JLabel label_Enf_Renal2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Enf. Renal:", false);
        fila_x3 += label_Enf_Renal2.getWidth();
        Panel3.add(label_Enf_Renal2);

        final JComboBox<String> combo_Enf_Renal2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_Renal2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Enf_Renal2.getWidth();
        Panel3.add(combo_Enf_Renal2);

        fila_x3 = 280;
        fila_y3 = 480;
        final JLabel label_Enuresis = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Enuresis:", false);
        fila_x3 += label_Enuresis.getWidth();
        Panel3.add(label_Enuresis);

        final JComboBox<String> combo_Enuresis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enuresis.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Enuresis.getWidth();
        Panel3.add(combo_Enuresis);

        // Tercera fila - abajo
        fila_x3 = 500;
        fila_y3 = 270;
        final JLabel label_Cancer2 = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Cancer:", false);
        fila_x3 += label_Cancer2.getWidth();
        Panel3.add(label_Cancer2);

        final JComboBox<String> combo_Cancer2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Cancer2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Cancer2.getWidth();
        Panel3.add(combo_Cancer2);

        fila_x3 = 500;
        fila_y3 = 300;
        final JLabel label_Tromboembolica = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Tromboembolica:", false);
        fila_x3 += label_Tromboembolica.getWidth();
        Panel3.add(label_Tromboembolica);

        final JComboBox<String> combo_Tromboembolica = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Tromboembolica.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Tromboembolica.getWidth();
        Panel3.add(combo_Tromboembolica);

        fila_x3 = 500;
        fila_y3 = 330;
        final JLabel label_Tumor_Mamario = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Tumor Mamario:", false);
        fila_x3 += label_Tumor_Mamario.getWidth();
        Panel3.add(label_Tumor_Mamario);

        final JComboBox<String> combo_Tumor_Mamario = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Tumor_Mamario.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Tumor_Mamario.getWidth();
        Panel3.add(combo_Tumor_Mamario);

        fila_x3 = 500;
        fila_y3 = 360;
        final JLabel label_Meningitis = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Meningitis:", false);
        fila_x3 += label_Meningitis.getWidth();
        Panel3.add(label_Meningitis);

        final JComboBox<String> combo_Meningitis = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Meningitis.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Meningitis.getWidth();
        Panel3.add(combo_Meningitis);

        fila_x3 = 500;
        fila_y3 = 390;
        final JLabel label_TCraneoencefal = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "T Craneoencefal:", false);
        fila_x3 += label_TCraneoencefal.getWidth();
        Panel3.add(label_TCraneoencefal);

        final JComboBox<String> combo_TCraneoencefal = new JComboBox<String>(new String[] { "Si", "No" });
        combo_TCraneoencefal.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_TCraneoencefal.getWidth();
        Panel3.add(combo_TCraneoencefal);

        fila_x3 = 500;
        fila_y3 = 420;
        final JLabel label_Enf_Eruptivas = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Enf.Eruptivas:", false);
        fila_x3 += label_Enf_Eruptivas.getWidth();
        Panel3.add(label_Enf_Eruptivas);

        final JComboBox<String> combo_Enf_Eruptivas = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_Eruptivas.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Enf_Eruptivas.getWidth();
        Panel3.add(combo_Enf_Eruptivas);

        fila_x3 = 500;
        fila_y3 = 450;
        final JLabel label_Dengue = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Dengue:", false);
        fila_x3 += label_Dengue.getWidth();
        Panel3.add(label_Dengue);

        final JComboBox<String> combo_Dengue = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Dengue.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Dengue.getWidth();
        Panel3.add(combo_Dengue);

        fila_x3 = 500;
        fila_y3 = 480;
        final JLabel label_Hospitalizacion = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Hospitalización:",
                false);
        fila_x3 += label_Hospitalizacion.getWidth();
        Panel3.add(label_Hospitalizacion);

        final JComboBox<String> combo_Hospitalizacion = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Hospitalizacion.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Hospitalizacion.getWidth();
        Panel3.add(combo_Hospitalizacion);

        // Cuarta fila - abajo
        fila_x3 = 750;
        fila_y3 = 270;
        final JLabel label_Interv_Quirurgica = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Interv. Quirúrgica:",
                false);
        fila_x3 += label_Interv_Quirurgica.getWidth();
        Panel3.add(label_Interv_Quirurgica);

        final JComboBox<String> combo_Interv_Quirurgica = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Interv_Quirurgica.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Interv_Quirurgica.getWidth();
        Panel3.add(combo_Interv_Quirurgica);

        fila_x3 = 750;
        fila_y3 = 300;
        final JLabel label_Accidentes = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Accidentes:", false);
        fila_x3 += label_Accidentes.getWidth();
        Panel3.add(label_Accidentes);

        final JComboBox<String> combo_Accidentes = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Accidentes.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Accidentes.getWidth();
        Panel3.add(combo_Accidentes);

        fila_x3 = 750;
        fila_y3 = 330;
        final JLabel label_Artritis2 = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Artritis:", false);
        fila_x3 += label_Artritis2.getWidth();
        Panel3.add(label_Artritis2);

        final JComboBox<String> combo_Artritis2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Artritis2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Artritis2.getWidth();
        Panel3.add(combo_Artritis2);

        fila_x3 = 750;
        fila_y3 = 360;
        final JLabel label_Enf_TS = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Enf. T.S:", false);
        fila_x3 += label_Enf_TS.getWidth();
        Panel3.add(label_Enf_TS);

        final JComboBox<String> combo_Enf_TS = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_TS.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Enf_TS.getWidth();
        Panel3.add(combo_Enf_TS);

        fila_x3 = 750;
        fila_y3 = 390;
        final JLabel label_Enf_Infec_Tran = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Enf. Infec y Tran:",
                false);
        fila_x3 += label_Enf_Infec_Tran.getWidth();
        Panel3.add(label_Enf_Infec_Tran);

        final JComboBox<String> combo_Enf_Infec_Tran = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_Infec_Tran.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Enf_Infec_Tran.getWidth();
        Panel3.add(combo_Enf_Infec_Tran);

        fila_x3 = 750;
        fila_y3 = 420;
        final JLabel label_Enf_Laboral = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Enf. Laboral:", false);
        fila_x3 += label_Enf_Laboral.getWidth();
        Panel3.add(label_Enf_Laboral);

        final JComboBox<String> combo_Enf_Laboral = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Enf_Laboral.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Enf_Laboral.getWidth();
        Panel3.add(combo_Enf_Laboral);

        fila_x3 = 750;
        fila_y3 = 450;
        final JLabel label_Otros2 = Elementos.crearJLabel(fila_x3, fila_y3, 130, 20, "Otros:", false);
        fila_x3 += label_Otros2.getWidth();
        Panel3.add(label_Otros2);

        final JTextField text_Otros = Elementos.crearJTextField(fila_x3, fila_y3, 100, 20, "", true);
        fila_x3 += text_Otros.getWidth();
        Panel3.add(text_Otros);

        // Primera fila - Factores de riesgo
        fila_x3 = 36;
        fila_y3 = 540;
        final JLabel label_Alcohol2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Alcohol:", false);
        fila_x3 += label_Alcohol2.getWidth();
        Panel3.add(label_Alcohol2);

        final JComboBox<String> combo_Alcohol2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Alcohol2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Alcohol2.getWidth();
        Panel3.add(combo_Alcohol2);

        fila_x3 = 36;
        fila_y3 = 570;
        final JLabel label_Drogas2 = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Drogas:", false);
        fila_x3 += label_Drogas2.getWidth();
        Panel3.add(label_Drogas2);

        final JComboBox<String> combo_Drogas2 = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Drogas2.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Drogas2.getWidth();
        Panel3.add(combo_Drogas2);

        fila_x3 = 36;
        fila_y3 = 600;
        final JLabel label_Insecticidas = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Insecticidas:", false);
        fila_x3 += label_Insecticidas.getWidth();
        Panel3.add(label_Insecticidas);

        final JComboBox<String> combo_Insecticidas = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Insecticidas.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Insecticidas.getWidth();
        Panel3.add(combo_Insecticidas);

        fila_x3 = 36;
        fila_y3 = 630;
        final JLabel label_Deporte = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Deportes:", false);
        fila_x3 += label_Deporte.getWidth();
        Panel3.add(label_Deporte);

        final JComboBox<String> combo_Deporte = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Deporte.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Deporte.getWidth();
        Panel3.add(combo_Deporte);

        // segunda fila - Factores de riesgo
        fila_x3 = 280;
        fila_y3 = 540;
        final JLabel label_Sedentarismo = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Sedentarismo:", false);
        fila_x3 += label_Sedentarismo.getWidth();
        Panel3.add(label_Sedentarismo);

        final JComboBox<String> combo_Sedentarismo = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Sedentarismo.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Sedentarismo.getWidth();
        Panel3.add(combo_Sedentarismo);

        fila_x3 = 280;
        fila_y3 = 570;
        final JLabel label_Sueno = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Sueño:", false);
        fila_x3 += label_Sueno.getWidth();
        Panel3.add(label_Sueno);

        final JComboBox<String> combo_Sueno = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Sueno.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Sueno.getWidth();
        Panel3.add(combo_Sueno);

        fila_x3 = 280;
        fila_y3 = 600;
        final JLabel label_ChuparDedo = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Chupar Dedo:", false);
        fila_x3 += label_ChuparDedo.getWidth();
        Panel3.add(label_ChuparDedo);

        final JComboBox<String> combo_ChuparDedo = new JComboBox<String>(new String[] { "Si", "No" });
        combo_ChuparDedo.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_ChuparDedo.getWidth();
        Panel3.add(combo_ChuparDedo);

        fila_x3 = 280;
        fila_y3 = 630;
        final JLabel label_Onicofagia = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Onicofagia:", false);
        fila_x3 += label_Onicofagia.getWidth();
        Panel3.add(label_Onicofagia);

        final JComboBox<String> combo_Onicofagia = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Onicofagia.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Onicofagia.getWidth();
        Panel3.add(combo_Onicofagia);

        // Tercera fila - Factores de riesgo
        fila_x3 = 500;
        fila_y3 = 540;
        final JLabel label_Micciones = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Micciones:", false);
        fila_x3 += label_Micciones.getWidth();
        Panel3.add(label_Micciones);

        final JComboBox<String> combo_Micciones = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Micciones.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Micciones.getWidth();
        Panel3.add(combo_Micciones);

        fila_x3 = 500;
        fila_y3 = 570;
        final JLabel label_Evacuaciones = Elementos.crearJLabel(fila_x3, fila_y3, 120, 20, "Evacuaciones:", false);
        fila_x3 += label_Evacuaciones.getWidth();
        Panel3.add(label_Evacuaciones);

        final JComboBox<String> combo_Evacuaciones = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Evacuaciones.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Evacuaciones.getWidth();
        Panel3.add(combo_Evacuaciones);

        fila_x3 = 500;
        fila_y3 = 600;
        final JLabel label_Estres = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Estrés:", false);
        fila_x3 += label_Estres.getWidth();
        Panel3.add(label_Estres);

        final JComboBox<String> combo_Estres = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Estres.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Estres.getWidth();
        Panel3.add(combo_Estres);

        fila_x3 = 500;
        fila_y3 = 630;
        final JLabel label_Metales_Pensados = Elementos.crearJLabel(fila_x3, fila_y3, 140, 20, "Metales Pensados:",
                false);
        fila_x3 += label_Metales_Pensados.getWidth();
        Panel3.add(label_Metales_Pensados);

        final JComboBox<String> combo_Metales_Pensados = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Metales_Pensados.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Metales_Pensados.getWidth();
        Panel3.add(combo_Metales_Pensados);

        // cuarta fila - Factores de riesgo
        fila_x3 = 750;
        fila_y3 = 540;
        final JLabel label_Alimentacion = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Alimentación:", false);
        fila_x3 += label_Alimentacion.getWidth();
        Panel3.add(label_Alimentacion);

        final JComboBox<String> combo_Alimentacion = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Alimentacion.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Alimentacion.getWidth();
        Panel3.add(combo_Alimentacion);

        fila_x3 = 750;
        fila_y3 = 570;
        final JLabel label_Fuma = Elementos.crearJLabel(fila_x3, fila_y3, 100, 20, "Fuma:", false);
        fila_x3 += label_Fuma.getWidth();
        Panel3.add(label_Fuma);

        final JComboBox<String> combo_Fuma = new JComboBox<String>(new String[] { "Si", "No" });
        combo_Fuma.setBounds(fila_x3, fila_y3, 50, 20);
        fila_x3 += combo_Fuma.getWidth();
        Panel3.add(combo_Fuma);

        fila_x3 = 750;
        fila_y3 = 600;
        final JLabel label_NCigarrillos_diarios = Elementos.crearJLabel(fila_x3, fila_y3, 160, 20,
                "N~ Cigarrillos diarios:", false);
        fila_x3 += label_NCigarrillos_diarios.getWidth();
        Panel3.add(label_NCigarrillos_diarios);

        final JTextField texto_NCigarrillos_diarios = Elementos.crearJTextField(fila_x3, fila_y3, 100, 20, "", true);
        fila_x3 += texto_NCigarrillos_diarios.getWidth();
        Panel3.add(texto_NCigarrillos_diarios);
        texto_NCigarrillos_diarios.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

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
                cardLayout.show(contentPanel, "panel2");
            }

            public void mouseEntered(MouseEvent e) {
                volverButton3.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                volverButton3.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel3.add(volverButton3);

        // Boton Guardar
        final JLabel GuardarButton = new JLabel("GUARDAR", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        GuardarButton.setBounds(800, 650, 308, 67);
        GuardarButton.setFont(new Font("Roboto Black", 1, 22));
        GuardarButton.setForeground(Elementos.colores(Inicio.Tema));
        GuardarButton.setVerticalTextPosition(SwingConstants.CENTER);
        GuardarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        GuardarButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JComponent[] componentes = {
                        text_apellido_familiar,
                        text_ci_jefe_familia,
                        text_Numero_de_Historia,
                        ci_ComboBox,
                        text_ci,
                        text_apellido,
                        text_nombre,
                        ComboBox_estadoCivil,
                        text_Ocupacion,
                        combo_estudio,
                        text_anosAprobados,
                        combo_Analfabeta,
                        combo_sexo,
                        calendario,
                        text_LugarNacimiento,
                        combo_Estado,
                        combo_Pais,
                        texto_Direccion,
                        text_Telefono,
                        text_Religion,
                        texto_Establecimiento,
                        texto_Parroquia,
                        texto_Comunidad,
                        texto_Madre_N_A,
                        texto_Madre_Ocupacion,
                        texto_Padre_N_A,
                        texto_Padre_Ocupacion,
                        combo_Representante,
                        texto_Representante_N,
                        combo__Representante_ci,
                        texto_Representante_ci,
                        texto_Representante_Telefono,
                        combo_Carnet_prenatal,
                        combo_patologiaEmbarazo,
                        combo_patologiaParto,
                        combo_patologiaPuerperio,
                        text_NConsultasPrenatales,
                        texto_Hrs_fuera_de_casa,
                        combo_MadreFamilia,
                        combo_PadreFamilia,
                        combo_HermanoFamilia,
                        text_OtrosFamilia,
                        text_Edad_Gestacion,
                        text_sem,
                        combo_Forces,
                        combo_Cesarea,
                        combo_Parto,
                        text_ApgarMin,
                        combo_Reanimacion,
                        combo_EgresoRN,
                        text_Exclusiva,
                        text_Mixta,
                        text_Ablactacion,
                        text_Peso_al_nacer,
                        text_Talla,
                        text_Circunferencia,
                        combo_Asfixia,
                        combo_PatologiasRN,
                        combo_Alergia,
                        combo_Asma,
                        combo_TBC,
                        combo_Cardiopatia,
                        combo_Hipertension,
                        combo_Varice,
                        combo_Desnutricion,
                        combo_Diabetes,
                        combo_Obesidad,
                        combo_Gastropatia,
                        combo_Neurologica,
                        combo_Enf_Renal,
                        combo_Cancer,
                        combo_Alcohol,
                        combo_Drogas,
                        combo_Sífilis,
                        combo_SIDA,
                        combo_Artritis,
                        combo_otros,
                        combo_Padre,
                        combo_Madre,
                        combo_Hermanos,
                        combo_Otros,
                        texto_Menarquia,
                        texto_Ciclo_menstrual,
                        texto_PRSexual,
                        texto_FrecuenciaRSexual,
                        texto_N_Parejas,
                        combo_Dispareunia,
                        combo_Anticoncepcion,
                        combo_AC_DIU,
                        combo_Menopausia,
                        combo_Gesta,
                        combo_Partos,
                        combo_Cesarea2,
                        combo_Aborto,
                        texto_E1erParto,
                        texto_F_U_Parto,
                        texto_F_UAborto,
                        combo_Curetaje,
                        texto_N_de_Hijos,
                        texto_Vivos,
                        texto_Muertos,
                        text_RN_de_mayor_peso,
                        combo_Alergia2,
                        combo_Asma2,
                        combo_Neumonia,
                        combo_TBC2,
                        combo_Cardiopatia2,
                        combo_Hipertension2,
                        combo_Hiperlipidemias,
                        combo_Varices,
                        combo_Hepatopatia,
                        combo_Desnutricion2,
                        combo_Diabetes2,
                        combo_Obesidad2,
                        combo_Gastroenteritis,
                        combo_Encoprexis,
                        combo_Enf_Renal2,
                        combo_Enuresis,
                        combo_Cancer2,
                        combo_Tromboembolica,
                        combo_Tumor_Mamario,
                        combo_Meningitis,
                        combo_TCraneoencefal,
                        combo_Enf_Eruptivas,
                        combo_Dengue,
                        combo_Hospitalizacion,
                        combo_Interv_Quirurgica,
                        combo_Accidentes,
                        combo_Artritis2,
                        combo_Enf_TS,
                        combo_Enf_Infec_Tran,
                        combo_Enf_Laboral,
                        text_Otros,
                        combo_Alcohol2,
                        combo_Drogas2,
                        combo_Insecticidas,
                        combo_Deporte,
                        combo_Sedentarismo,
                        combo_Sueno,
                        combo_ChuparDedo,
                        combo_Onicofagia,
                        combo_Micciones,
                        combo_Evacuaciones,
                        combo_Estres,
                        combo_Metales_Pensados,
                        combo_Alimentacion,
                        combo_Fuma,
                        texto_NCigarrillos_diarios
                };
                JComponent[] nuevoArrayComponentes = new JComponent[componentes.length + 1];
                System.arraycopy(componentes, 0, nuevoArrayComponentes, 0, componentes.length);
                if (texto_Municipio.isVisible()) {
                    nuevoArrayComponentes[componentes.length] = texto_Municipio;
                } else {
                    nuevoArrayComponentes[componentes.length] = Combo_municipio;
                }
                componentes = nuevoArrayComponentes;
                try {
                    Connection conexion = Conexion.getConexion();
                    String textoIngresado = JOptionPane.showInputDialog(null, "Ingrese las observaciones del paciente");
                    String Observacion = "";
                    if (textoIngresado != null && !textoIngresado.isEmpty()) {
                        Observacion = textoIngresado;
                    }
                    PreparedStatement pst = conexion.prepareStatement(
                            "update datospersonales set ModificadoPor=?, FechaModificacion=?, apellido_familiar=?, ci_jefe_familia=?, Numero_de_Historia=?,"
                                    +
                                    "ci_tipo=?, Ci_cedula=?, apellido=?, nombre=?, estadoCivil=?, Ocupacion=?, estudio=?, anosAprobados=?, Analfabeta=?, sexo=?, NFecha=?,"
                                    +
                                    "LugarNacimiento=?, Estado=?, Pais=?, Direccion=?, Telefono=?, Religion=?, Establecimiento=?, Municipio=?, Parroquia=?, Comunidad=?,"
                                    +
                                    "Madre_N_A=?, Madre_Ocupacion=?, Padre_N_A=?, Padre_Ocupacion=?, Representante=?, Representante_N=?, Representante_tipo_ci=?, Representante_ci=?,"
                                    +
                                    "Representante_Telefono=?, Carnet_prenatal=?, patologiaEmbarazo=?, patologiaParto=?, patologiaPuerperio=?, NConsultasPrenatales=?, Hrs_fuera_de_casa=?,"
                                    +
                                    "MadreFamilia=?, PadreFamilia=?, HermanoFamilia=?, OtrosFamilia=?, Edad_Gestacional=?, sem=?, Forceps=?, Cesarea=?, Parto=?, ApgarMin=?, Reanimacion=?,"
                                    +
                                    "EgresoRN=?, Exclusiva=?, Mixta=?, Ablactacion=?, Peso_al_nacer=?, Talla=?, Circunferencia=?, Asfixia=?, PatologiasRN=?, Alergia=?, Asma=?, TBC=?,"
                                    +
                                    "Cardiopatia=?, Hipertension=?, Varice=?, Desnutricion=?, Diabetes=?, Obesidad=?, Gastropatia=?, Neurologica=?, Enf_Renal=?, Cancer=?, Alcohol=?,"
                                    +
                                    "Drogas=?, Sifilis=?, SIDA=?, Artritis=?, otros_1=?, Padre=?, Madre=?, Hermanos=?, Otros_2=?, Menarquia=?, Ciclo_menstrual=?, PRSexual=?, FrecuenciaRSexual=?,"
                                    +
                                    "N_Parejas=?, Dispareunia=?, Anticoncepcion=?, AC_DIU=?, Menopausia=?, Gesta=?, Partos=?, Cesarea2=?, Aborto=?, E1erparto=?, F_Uparto=?, F_UAborto=?, Curetaje=?,"
                                    +
                                    "N_de_Hijos=?, Vivos=?, Muertos=?, RN_de_mayor_peso=?, Alergia2=?, Asma2=?, Neumonia=?, TBC2=?, Cardiopatia2=?, Hipertension2=?, Hiperlipidemias=?, Varices=?, Hepatopatia=?,"
                                    +
                                    "Desnutricion2=?, Diabetes2=?, Obesidad2=?, Gastroenteritis=?, Encoprexis=?, Enf_Renal2=?, Enuresis=?, Cancer2=?, Tromboembolica=?, Tumor_Mamario=?, Meningitis=?, TCraneoencefal=?,"
                                    +
                                    "Enf_Eruptivas=?, Dengue=?, Hospitalizacion=?, Interv_Quirurgica=?, Accidentes=?, Artritis2=?, Enf_TS=?, Enf_Infec_Tran=?, Enf_Laboral=?, Otros_3=?, Alcohol2=?, Drogas2=?, Insecticidas=?,"
                                    +
                                    "Deportes=?, Sedentarismo=?, Sueno=?, ChuparDedo=?, Onicofagia=?, Micciones=?, Evacuaciones=?, Estres=?, Metales_Pensados=?, Alimentacion=?, Fuma=?, NCigarrillos_diarios=?, Observacion=? where Numero_de_Historia ="
                                    + Buscador.ID);

                    int index = 1;
                    pst.setString(1, Inicio.UsuarioNombre);
                    Date fechaActual = new Date();
                    DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                    String fechaFormateada = formatoFecha.format(fechaActual);
                    pst.setString(2, fechaFormateada);

                    index = 3;
                    // indice para los marcadores de posición
                    for (JComponent componente : componentes) {
                        if (componente instanceof JTextField) {
                            String valor = ((JTextField) componente).getText().toString();
                            pst.setString(index, valor);
                            index++;
                        } else if (componente instanceof JComboBox<?>) {
                            Object selectedItem = ((JComboBox<?>) componente).getSelectedItem();
                            if (selectedItem != null) {
                                String valor = selectedItem.toString();
                                pst.setString(index, valor);
                                index++;
                            }
                        } else if (componente instanceof JDateChooser) {
                            Date selectedDate = ((JDateChooser) componente).getDate();
                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            String valor = dateFormat.format(selectedDate);
                            pst.setString(index, valor);
                            index++;
                        }
                    }
                    pst.setString(152,Observacion);
                    pst.executeUpdate();
                    new Buscador().setVisible(true);
                    dispose();
                    JOptionPane.showMessageDialog(null, "Se a guardado con éxito", "Completado",
                            JOptionPane.INFORMATION_MESSAGE, null);

                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(null, "Se a producido un error \n" + "Código de error:" + e1, "ERROR",
                            JOptionPane.ERROR_MESSAGE, null);
                    e1.printStackTrace();
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

        // Para imprimir los datos
        final JLabel ImprimirButton = new JLabel("IMPRIMIR REGISTRO", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        ImprimirButton.setBounds(400, 650, 308, 67);
        ImprimirButton.setFont(new Font("Roboto Black", 1, 22));
        ImprimirButton.setForeground(Elementos.colores(Inicio.Tema));
        ImprimirButton.setVerticalTextPosition(SwingConstants.CENTER);
        ImprimirButton.setHorizontalTextPosition(SwingConstants.CENTER);

        ImprimirButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Document document = new Document(PageSize.LETTER.rotate());
                // Establecer los márgenes (en puntos) - Ejemplo: márgenes de 50 puntos en cada /lado
                float margenSuperior = 10f;
                float margenInferior = 50f;
                float margenIzquierdo = 20f;
                float margenDerecho = 50f;
                document.setMargins(margenIzquierdo, margenDerecho, margenSuperior, margenInferior);

                try {
                    PdfWriter.getInstance(document,
                            new FileOutputStream("historia_clinica " + text_Numero_de_Historia.getText() + ".pdf"));
                    document.open();

                    Paragraph encabezado = new Paragraph("Historia Clínica Integral");
                    encabezado.setAlignment(Element.ALIGN_CENTER);
                    document.add(encabezado);

                    // Título "Datos del Usuario"
                    Paragraph titulo1 = new Paragraph("Datos del Paciente");
                    document.add(titulo1);

                    document.add(new Paragraph("\n"));
                    // Crear tabla con 3 columnas
                    PdfPTable PrimeraFila = new PdfPTable(3);
                    PrimeraFila.setWidthPercentage(100);
                    PrimeraFila.addCell("Apellido de tu familia: " + text_apellido_familiar.getText());
                    PrimeraFila.addCell("C.I Jefe de familia: " + text_ci_jefe_familia.getText());
                    PrimeraFila.addCell("Numero de Historia: " + text_Numero_de_Historia.getText());
                    document.add(PrimeraFila);

                    PdfPTable SegundaFila = new PdfPTable(5);
                    SegundaFila.setWidthPercentage(100);
                    SegundaFila.addCell("CI:" + ci_ComboBox.getSelectedItem() + text_ci.getText());
                    SegundaFila.addCell("Nombre: " + text_nombre.getText());
                    SegundaFila.addCell("Apellido: " + text_apellido.getText());
                    SegundaFila.addCell("Sexo: " + combo_sexo.getSelectedItem());
                    SegundaFila.addCell("Estado Civil: " + ComboBox_estadoCivil.getSelectedItem());
                    document.add(SegundaFila);

                    float[] columnWidths = { 130f, 100f, 100f, 100f, 100f };
                    PdfPTable TerceraFila = new PdfPTable(5);
                    TerceraFila.setWidths(columnWidths);
                    TerceraFila.setTotalWidth(PageSize.A4.getWidth() - document.leftMargin() - document.rightMargin());
                    TerceraFila.setWidthPercentage(100);
                    Date selectedDate = calendario.getDate();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String valor = dateFormat.format(selectedDate);
                    TerceraFila.addCell("Fecha nacimiento: " + valor);
                    TerceraFila.addCell("Estudios: " + combo_estudio.getSelectedItem());
                    TerceraFila.addCell("Años aprobados: " + text_anosAprobados.getText());
                    TerceraFila.addCell("Analfabeta: " + combo_Analfabeta.getSelectedItem());
                    TerceraFila.addCell("Ocupacion: " + text_Ocupacion.getText());
                    document.add(TerceraFila);

                    PdfPTable CuartaFila = new PdfPTable(4);
                    CuartaFila.setWidthPercentage(100);
                    CuartaFila.addCell("Pais: " + combo_Pais.getSelectedItem());
                    CuartaFila.addCell("Estado: " + combo_Estado.getSelectedItem());
                    String[] ObtenerDatos = Obtener_datos();
                    String pais = ObtenerDatos[16];
                    if (pais.equals("Venezuela")) {
                        CuartaFila.addCell("Municipio: " + Combo_municipio.getSelectedItem());
                    } else {
                        CuartaFila.addCell("Municipio: " + texto_Municipio.getText());
                    }

                    CuartaFila.addCell("Parroquia: " + texto_Parroquia.getText());
                    document.add(CuartaFila);

                    PdfPTable QuintaFila = new PdfPTable(3);
                    QuintaFila.setWidthPercentage(100);
                    QuintaFila.addCell("Direccion: " + texto_Direccion.getText());
                    QuintaFila.addCell("Lugar de nacimiento: " + text_LugarNacimiento.getText());
                    QuintaFila.addCell("Establecimiento: " + texto_Establecimiento.getText());
                    document.add(QuintaFila);

                    PdfPTable SextoFila = new PdfPTable(3);
                    SextoFila.setWidthPercentage(100);
                    SextoFila.addCell("Comunidad: " + texto_Comunidad.getText());
                    SextoFila.addCell("Telefono: " + text_Telefono.getText());
                    SextoFila.addCell("Religion: " + text_Religion.getText());
                    document.add(SextoFila);

                    // Título "Datos del Padre y de la Madre"
                    Paragraph titulo2 = new Paragraph("Datos del Padre y de la Madre");
                    document.add(titulo2);
                    document.add(new Paragraph("\n"));

                    PdfPTable SectimoFila = new PdfPTable(2);
                    SectimoFila.setWidthPercentage(100);
                    SectimoFila.addCell("Nombre y apellido de la madre: " + texto_Madre_N_A.getText());
                    SectimoFila.addCell("Ocupacion: " + texto_Madre_Ocupacion.getText());
                    document.add(SectimoFila);

                    PdfPTable OctavoFila = new PdfPTable(2);
                    OctavoFila.setWidthPercentage(100);
                    OctavoFila.addCell("Nombre y apellido del padre: " + texto_Padre_N_A.getText());
                    OctavoFila.addCell("Ocupacion: " + texto_Padre_Ocupacion.getText());
                    document.add(OctavoFila);

                    PdfPTable NovenaFila = new PdfPTable(4);
                    NovenaFila.setWidthPercentage(100);
                    NovenaFila.addCell("Representante: " + combo_Representante.getSelectedItem());
                    NovenaFila.addCell("Nombre: " + texto_Representante_N.getText());
                    NovenaFila.addCell(
                            "Cedula: " + combo__Representante_ci.getSelectedItem() + texto_Representante_ci.getText());
                    NovenaFila.addCell("Telefono: " + texto_Representante_Telefono.getText());
                    document.add(NovenaFila);

                    // Título "Antecedentes Perinatales en menores de 12 años"
                    Paragraph titulo3 = new Paragraph("Antecedentes Perinatales en menores de 12 años");
                    document.add(titulo3);
                    document.add(new Paragraph("\n"));

                    PdfPTable CentésimoFila = new PdfPTable(4);
                    float[] CentésimoFila_column = { 80f, 80f, 80f, 120f };
                    CentésimoFila.setWidths(CentésimoFila_column);
                    CentésimoFila
                            .setTotalWidth(PageSize.A4.getWidth() - document.leftMargin() - document.rightMargin());
                    CentésimoFila.setWidthPercentage(100);
                    CentésimoFila.addCell("Carnet Prenatal: " + combo_Carnet_prenatal.getSelectedItem());
                    CentésimoFila.addCell("N~Consultas prenatales: " + text_NConsultasPrenatales.getText());
                    CentésimoFila.addCell("Madre");
                    CentésimoFila.addCell("Familia");
                    document.add(CentésimoFila);

                    PdfPTable OnceavaFila = new PdfPTable(5);
                    float[] OnceavaFila_column = { 100f, 100f, 90f, 70f, 70f };
                    OnceavaFila.setWidths(OnceavaFila_column);
                    OnceavaFila.setTotalWidth(PageSize.A4.getWidth() - document.leftMargin() - document.rightMargin());
                    OnceavaFila.setWidthPercentage(100);
                    OnceavaFila.addCell("Patologia embarazo: " + combo_patologiaEmbarazo.getSelectedItem());
                    OnceavaFila.addCell("Patologia de pacto: " + combo_patologiaParto.getSelectedItem());
                    OnceavaFila.addCell("Hrs fuera de casa: " + texto_Hrs_fuera_de_casa.getText());
                    OnceavaFila.addCell("Madre: " + combo_MadreFamilia.getSelectedItem());
                    OnceavaFila.addCell("Hermano: " + combo_HermanoFamilia.getSelectedItem());
                    document.add(OnceavaFila);

                    PdfPTable DoceavaFila = new PdfPTable(3);
                    float[] DoceavaFila_column = { 400f, 100f, 100f };
                    DoceavaFila.setWidths(DoceavaFila_column);
                    DoceavaFila.setTotalWidth(PageSize.A4.getWidth() - document.leftMargin() - document.rightMargin());
                    DoceavaFila.setWidthPercentage(100);
                    DoceavaFila.addCell("Patologia Puerperio: " + combo_patologiaPuerperio.getSelectedItem());
                    DoceavaFila.addCell("Padre: " + combo_PadreFamilia.getSelectedItem());
                    DoceavaFila.addCell("Otros: " + text_OtrosFamilia.getText());
                    document.add(DoceavaFila);
                    // SEGUNDA VENTANA
                    PdfPTable PrimeraFila_v2 = new PdfPTable(2);
                    PrimeraFila_v2.setWidthPercentage(100);
                    PrimeraFila_v2.addCell("Edad Gestacional: " + text_Edad_Gestacion.getText());
                    PrimeraFila_v2.addCell("Semanas: " + text_sem.getText());
                    document.add(PrimeraFila_v2);

                    PdfPTable SegundaFila_v2 = new PdfPTable(6);
                    float[] SegundaFila_v2_column = { 70f, 70f, 70f, 100f, 90f, 140f };
                    SegundaFila_v2.setWidths(SegundaFila_v2_column);
                    SegundaFila_v2
                            .setTotalWidth(PageSize.A4.getWidth() - document.leftMargin() - document.rightMargin());
                    SegundaFila_v2.setWidthPercentage(100);
                    SegundaFila_v2.addCell("Forceps: " + combo_Forces.getSelectedItem());
                    SegundaFila_v2.addCell("Cesarea: " + combo_Cesarea.getSelectedItem());
                    SegundaFila_v2.addCell("Pacto: " + combo_Parto.getSelectedItem());
                    SegundaFila_v2.addCell("Peso al nacer: " + text_Peso_al_nacer.getText() + " gr");
                    SegundaFila_v2.addCell("Talla: " + text_Talla.getText() + " cm");
                    SegundaFila_v2.addCell("Circunferencia cefálica: " + text_Circunferencia.getText() + " cm");
                    document.add(SegundaFila_v2);

                    PdfPTable TerceraFila_v2 = new PdfPTable(5);
                    TerceraFila_v2.setWidthPercentage(100);
                    TerceraFila_v2.addCell("Apgar min: " + text_ApgarMin.getText());
                    TerceraFila_v2.addCell("Asfixia: " + combo_Asfixia.getSelectedItem());
                    TerceraFila_v2.addCell("Reanimacion: " + combo_Reanimacion.getSelectedItem());
                    TerceraFila_v2.addCell("Patologias RN: " + combo_PatologiasRN.getSelectedItem());
                    TerceraFila_v2.addCell("Egreso RN: " + combo_EgresoRN.getSelectedItem());
                    document.add(TerceraFila_v2);

                    PdfPTable CuartaFila_v2 = new PdfPTable(1);
                    CuartaFila_v2.setWidthPercentage(100);
                    CuartaFila_v2.addCell("Lactancia:     Exclusiva: " + text_Exclusiva.getText() + "m  Mixta: "
                            + text_Mixta.getText() + "m  Ablactacion: " + text_Ablactacion.getText() + "m");
                    document.add(CuartaFila_v2);

                    Paragraph titulo4 = new Paragraph("Antecedentes Familiares");
                    document.add(titulo4);
                    document.add(new Paragraph("\n"));

                    PdfPTable QuintaFila_v2 = new PdfPTable(7);
                    QuintaFila_v2.setWidthPercentage(100);
                    QuintaFila_v2.addCell("Alergia: " + combo_Alergia.getSelectedItem());
                    QuintaFila_v2.addCell("Diabetes: " + combo_Diabetes.getSelectedItem());
                    QuintaFila_v2.addCell("Drogas: " + combo_Drogas.getSelectedItem());
                    QuintaFila_v2.addCell("Asma: " + combo_Asma.getSelectedItem());
                    QuintaFila_v2.addCell("Obesidad: " + combo_Obesidad.getSelectedItem());
                    QuintaFila_v2.addCell("Sifilis: " + combo_Sífilis.getSelectedItem());
                    QuintaFila_v2.addCell("T.B.C: " + combo_TBC.getSelectedItem());
                    document.add(QuintaFila_v2);

                    PdfPTable SextaFila_v2 = new PdfPTable(7);
                    SextaFila_v2.setWidthPercentage(100);
                    SextaFila_v2.addCell("Gastropatia: " + combo_Gastropatia.getSelectedItem());
                    SextaFila_v2.addCell("SIDA: " + combo_SIDA.getSelectedItem());
                    SextaFila_v2.addCell("Cardiopatia: " + combo_Cardiopatia.getSelectedItem());
                    SextaFila_v2.addCell("Neurologica: " + combo_Neurologica.getSelectedItem());
                    SextaFila_v2.addCell("Artritis: " + combo_Artritis.getSelectedItem());
                    SextaFila_v2.addCell("Hipertension: " + combo_Hipertension.getSelectedItem());
                    SextaFila_v2.addCell("Enf.Renal: " + combo_Enf_Renal.getSelectedItem());
                    document.add(SextaFila_v2);

                    PdfPTable SéptimaFila_v2 = new PdfPTable(7);
                    SéptimaFila_v2.setWidthPercentage(100);
                    SéptimaFila_v2.addCell("Otros: " + combo_otros.getSelectedItem());
                    SéptimaFila_v2.addCell("Varices: " + combo_Varice.getSelectedItem());
                    SéptimaFila_v2.addCell("Cancer: " + combo_Cancer.getSelectedItem());
                    SéptimaFila_v2.addCell("Desnutricion: " + combo_Desnutricion.getSelectedItem());
                    SéptimaFila_v2.addCell("Alcohol: " + combo_Alcohol.getSelectedItem());
                    document.add(SéptimaFila_v2);

                    Paragraph titulo5 = new Paragraph("Otros contactos");
                    document.add(titulo5);
                    document.add(new Paragraph("\n"));

                    PdfPTable OctavaFila_v2 = new PdfPTable(4);
                    OctavaFila_v2.setWidthPercentage(100);
                    OctavaFila_v2.addCell("Padre: " + combo_Padre.getSelectedItem());
                    OctavaFila_v2.addCell("Madre: " + combo_Madre.getSelectedItem());
                    OctavaFila_v2.addCell("Hermanos(as): " + combo_Hermanos.getSelectedItem());
                    OctavaFila_v2.addCell("Otros: " + combo_Otros.getSelectedItem());
                    document.add(OctavaFila_v2);
                    document.add(new Paragraph("\n"));
                    document.add(new Paragraph("\n"));

                    Paragraph encabezado1 = new Paragraph("Antecedentes Personales");
                    encabezado1.setAlignment(Element.ALIGN_CENTER);
                    document.add(encabezado1);

                    Paragraph titulo6 = new Paragraph("Sexualidad y Obstétrica");
                    document.add(titulo6);
                    document.add(new Paragraph("\n"));

                    PdfPTable PrimeraFila_v3 = new PdfPTable(4);
                    PrimeraFila_v3.setWidthPercentage(100);
                    PrimeraFila_v3.addCell("Menarquia: " + texto_Menarquia.getText());
                    PrimeraFila_v3.addCell("Anticonceptivo: " + combo_Anticoncepcion.getSelectedItem());
                    PrimeraFila_v3.addCell("Aborto: " + combo_Aborto.getSelectedItem());
                    PrimeraFila_v3.addCell("Curetaje: " + combo_Curetaje.getText());
                    document.add(PrimeraFila_v3);

                    PdfPTable SegundaFila_v3 = new PdfPTable(4);
                    SegundaFila_v3.setWidthPercentage(100);
                    SegundaFila_v3.addCell("Ciclo Menstrual: " + texto_Ciclo_menstrual.getText());
                    SegundaFila_v3.addCell(combo_AC_DIU.getSelectedItem().toString());
                    SegundaFila_v3.addCell("E 1er parto: " + texto_E1erParto.getText());
                    SegundaFila_v3.addCell("N~ de Hijos: " + texto_N_de_Hijos.getText());
                    document.add(SegundaFila_v3);

                    PdfPTable TerceraFila_v3 = new PdfPTable(4);
                    TerceraFila_v3.setWidthPercentage(100);
                    TerceraFila_v3.addCell("P.R. Sexual: " + texto_PRSexual.getText());
                    TerceraFila_v3.addCell("Menopausia: " + combo_Menopausia.getSelectedItem());
                    TerceraFila_v3.addCell("F.U parto: " + texto_F_U_Parto.getText());
                    TerceraFila_v3.addCell("Vivos: " + texto_Vivos.getText());
                    document.add(TerceraFila_v3);

                    PdfPTable CuartaFila_v3 = new PdfPTable(4);
                    CuartaFila_v3.setWidthPercentage(100);
                    CuartaFila_v3.addCell("Frecuencia R. Sexual: " + texto_FrecuenciaRSexual.getText());
                    CuartaFila_v3.addCell("Gesta: " + combo_Gesta.getSelectedItem());
                    CuartaFila_v3.addCell("F.U Aborto: " + texto_F_UAborto.getText());
                    CuartaFila_v3.addCell("Muertos: " + texto_Muertos.getText());
                    document.add(CuartaFila_v3);

                    PdfPTable QuintaFila_v3 = new PdfPTable(4);
                    QuintaFila_v3.setWidthPercentage(100);
                    QuintaFila_v3.addCell("N~ Parejas: " + texto_N_Parejas.getText());
                    QuintaFila_v3.addCell("Partos: " + combo_Partos.getSelectedItem());
                    QuintaFila_v3.addCell("RN de mayor peso: " + text_RN_de_mayor_peso.getText());
                    document.add(QuintaFila_v3);

                    PdfPTable SextaFila_v3 = new PdfPTable(3);
                    SextaFila_v3.setWidthPercentage(100);
                    SextaFila_v3.addCell("Dispareunia: " + combo_Dispareunia.getSelectedItem());
                    SextaFila_v3.addCell("Cesarea: " + combo_Cesarea2.getSelectedItem());
                    SextaFila_v3.addCell("RN de mayor peso: " + text_RN_de_mayor_peso.getText());
                    document.add(SextaFila_v3);

                    Paragraph titulo7 = new Paragraph("Patologia Personal");
                    document.add(titulo7);
                    document.add(new Paragraph("\n"));

                    PdfPTable SéptimaFila_v3 = new PdfPTable(4);
                    SéptimaFila_v3.setWidthPercentage(100);
                    SéptimaFila_v3.addCell("Alergia: " + combo_Alergia2.getSelectedItem());
                    SéptimaFila_v3.addCell("Hepatopatia: " + combo_Hepatopatia.getSelectedItem());
                    SéptimaFila_v3.addCell("Cancer: " + combo_Cancer2.getSelectedItem());
                    SéptimaFila_v3.addCell("Interv. Quirurgica: " + combo_Interv_Quirurgica.getSelectedItem());
                    document.add(SéptimaFila_v3);

                    PdfPTable OctavaFila_v3 = new PdfPTable(4);
                    OctavaFila_v3.setWidthPercentage(100);
                    OctavaFila_v3.addCell("Asma: " + combo_Asma2.getSelectedItem());
                    OctavaFila_v3.addCell("Desnutricion: " + combo_Desnutricion2.getSelectedItem());
                    OctavaFila_v3.addCell("Tromboembolica: " + combo_Tromboembolica.getSelectedItem());
                    OctavaFila_v3.addCell("Accidentes: " + combo_Accidentes.getSelectedItem());
                    document.add(OctavaFila_v3);

                    PdfPTable NovenaFila_v3 = new PdfPTable(4);
                    NovenaFila_v3.setWidthPercentage(100);
                    NovenaFila_v3.addCell("Asma: " + combo_Asma2.getSelectedItem());
                    NovenaFila_v3.addCell("Desnutricion: " + combo_Desnutricion2.getSelectedItem());
                    NovenaFila_v3.addCell("Tromboembolica: " + combo_Tromboembolica.getSelectedItem());
                    NovenaFila_v3.addCell("Accidentes: " + combo_Accidentes.getSelectedItem());
                    document.add(NovenaFila_v3);

                    PdfPTable DécimoFila_v3 = new PdfPTable(4);
                    DécimoFila_v3.setWidthPercentage(100);
                    DécimoFila_v3.addCell("Neumonia: " + combo_Neumonia.getSelectedItem());
                    DécimoFila_v3.addCell("Diabetes: " + combo_Diabetes2.getSelectedItem());
                    DécimoFila_v3.addCell("Tumor Mamario: " + combo_Tumor_Mamario.getSelectedItem());
                    DécimoFila_v3.addCell("Artritis: " + combo_Artritis2.getSelectedItem());
                    document.add(DécimoFila_v3);

                    PdfPTable OnceavaFila_v3 = new PdfPTable(4);
                    OnceavaFila_v3.setWidthPercentage(100);
                    OnceavaFila_v3.addCell("T.B.C: " + combo_TBC2.getSelectedItem());
                    OnceavaFila_v3.addCell("Obesidad: " + combo_Obesidad2.getSelectedItem());
                    OnceavaFila_v3.addCell("Meningitis: " + combo_Meningitis.getSelectedItem());
                    OnceavaFila_v3.addCell("Enf. T.S: " + combo_Enf_TS.getSelectedItem());
                    document.add(OnceavaFila_v3);

                    PdfPTable DoceavaFila_v3 = new PdfPTable(4);
                    DoceavaFila_v3.setWidthPercentage(100);
                    DoceavaFila_v3.addCell("Cardiopatia: " + combo_Cardiopatia2.getSelectedItem());
                    DoceavaFila_v3.addCell("Gastroenteritis: " + combo_Gastroenteritis.getSelectedItem());
                    DoceavaFila_v3.addCell("T Craneoencefal: " + combo_TCraneoencefal.getSelectedItem());
                    DoceavaFila_v3.addCell("Enf. Infec y Tran: " + combo_Enf_Infec_Tran.getSelectedItem());
                    document.add(DoceavaFila_v3);

                    PdfPTable TreceavaFila_v3 = new PdfPTable(4);
                    TreceavaFila_v3.setWidthPercentage(100);
                    TreceavaFila_v3.addCell("Hipertension: " + combo_Hipertension2.getSelectedItem());
                    TreceavaFila_v3.addCell("Encoprexis: " + combo_Encoprexis.getSelectedItem());
                    TreceavaFila_v3.addCell("Enf. Eruptivas: " + combo_Enf_Eruptivas.getSelectedItem());
                    TreceavaFila_v3.addCell("Enf. Laboral: " + combo_Enf_Laboral.getSelectedItem());
                    document.add(TreceavaFila_v3);

                    PdfPTable CuarteabaFila_v3 = new PdfPTable(4);
                    CuarteabaFila_v3.setWidthPercentage(100);
                    CuarteabaFila_v3.addCell("Hiperlipidemias: " + combo_Hiperlipidemias.getSelectedItem());
                    CuarteabaFila_v3.addCell("Enf. Renal: " + combo_Enf_Renal2.getSelectedItem());
                    CuarteabaFila_v3.addCell("Dengue: " + combo_Dengue.getSelectedItem());
                    CuarteabaFila_v3.addCell("Otros: " + text_Otros.getText());
                    document.add(CuarteabaFila_v3);

                    PdfPTable QuintabaFila_v3 = new PdfPTable(3);
                    QuintabaFila_v3.setWidthPercentage(100);
                    QuintabaFila_v3.addCell("Varices: " + combo_Varices.getSelectedItem());
                    QuintabaFila_v3.addCell("Enuresis: " + combo_Enuresis.getSelectedItem());
                    QuintabaFila_v3.addCell("Hospitalizacion: " + combo_Hospitalizacion.getSelectedItem());
                    document.add(QuintabaFila_v3);

                    Paragraph titulo8 = new Paragraph("Factores de riesgo(Hábitos Sicobilogicos)");
                    document.add(titulo8);
                    document.add(new Paragraph("\n"));

                    PdfPTable DieciseisavaFila_v3 = new PdfPTable(4);
                    DieciseisavaFila_v3.setWidthPercentage(100);
                    DieciseisavaFila_v3.addCell("Alcohol: " + combo_Alcohol2.getSelectedItem());
                    DieciseisavaFila_v3.addCell("Sedentarismo: " + combo_Sedentarismo.getSelectedItem());
                    DieciseisavaFila_v3.addCell("Micciones: " + combo_Micciones.getSelectedItem());
                    DieciseisavaFila_v3.addCell("Alimentacion: " + combo_Alimentacion.getSelectedItem());
                    document.add(DieciseisavaFila_v3);

                    PdfPTable DiecisieteavaFila_v3 = new PdfPTable(4);
                    DiecisieteavaFila_v3.setWidthPercentage(100);
                    DiecisieteavaFila_v3.addCell("Drogas: " + combo_Drogas2.getSelectedItem());
                    DiecisieteavaFila_v3.addCell("Sueño: " + combo_Sueno.getSelectedItem());
                    DiecisieteavaFila_v3.addCell("Evacuaciones: " + combo_Evacuaciones.getSelectedItem());
                    DiecisieteavaFila_v3.addCell("Fuma: " + combo_Fuma.getSelectedItem());
                    document.add(DiecisieteavaFila_v3);

                    PdfPTable DieciochoFila_v3 = new PdfPTable(4);
                    DieciochoFila_v3.setWidthPercentage(100);
                    DieciochoFila_v3.addCell("Insecticidas: " + combo_Insecticidas.getSelectedItem());
                    DieciochoFila_v3.addCell("Chupar Dedo: " + combo_ChuparDedo.getSelectedItem());
                    DieciochoFila_v3.addCell("Estres: " + combo_Estres.getSelectedItem());
                    DieciochoFila_v3.addCell("N~ Cigarrillos diarios: " + texto_NCigarrillos_diarios.getText());
                    document.add(DieciochoFila_v3);

                    PdfPTable Veinte_v3 = new PdfPTable(3);
                    Veinte_v3.setWidthPercentage(100);
                    Veinte_v3.addCell("Deporte: " + combo_Deporte.getSelectedItem());
                    Veinte_v3.addCell("Onicofagia: " + combo_Onicofagia.getSelectedItem());
                    Veinte_v3.addCell("Metales Pesados: " + combo_Metales_Pensados.getSelectedItem());
                    document.add(Veinte_v3);

                    PdfPTable Observacion = new PdfPTable(1);
                    Observacion.addCell("Observacion: " + ObtenerDatos[153]);
                    document.add(Observacion);

                    document.close();

                    JOptionPane.showMessageDialog(null, "Se guardo el documento exitosamente");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

            public void mouseEntered(MouseEvent e) {
                ImprimirButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                ImprimirButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        Panel3.add(ImprimirButton);

        // FONDO
        JLabel fondo3 = new JLabel();
        if (Inicio.Tema == "Oscuro") {
            fondo3.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Oscuro/NHM_part3-Oscuro.png")));
            JComponent[] componentesLabel = {
                    label_apellido_familiar,
                    label_ci_jefe_familia,
                    Label_Numero_de_Historia,
                    Label_ci,
                    label_apellido,
                    label_nombre,
                    label_estadoCivil,
                    label_Ocupacion,
                    label_Estudios,
                    label_anosAprobados,
                    label_Analfabeta,
                    label_Sexo,
                    label_fechaNacimiento,
                    label_Municipio,
                    label_Parroquia,
                    label_LugarNacimiento,
                    label_Estado,
                    label_Pais,
                    label_Dirección,
                    label_Telefono,
                    label_Religion,
                    label_Establecimiento,
                    label_Comunidad,
                    label_Madre_N_A,
                    label_Madre_Ocupacion,
                    label_Padre_N_A,
                    label_Padre_Ocupacion,
                    label_Representante,
                    label_Representante_N,
                    label_Representante_ci,
                    label_Representante_Telefono,
                    label_CarnetPrenatal,
                    label_patologiaEmbarazo,
                    label_Hrs_fuera_de_casa,
                    label_MadreFamilia,
                    label_patologiaParto,
                    label_PadreFamilia,
                    label_patologiaPuerperio,
                    label_HermanoFamilia,
                    NConsultasPrenatales,
                    label_OtrosFamilia,
                    label_Edad_Gestacion,
                    label_sem,
                    label_Forces,
                    label_Cesarea,
                    label_Parto,
                    label_Peso_Al_Nacer,
                    label_Peso_Al_Nacer_gr,
                    label_Talla,
                    label_Talla_cm,
                    label_Circunferencia,
                    label_Circunferencia_cm,
                    label_ApgarMin,
                    label_Asfixia,
                    label_Reanimacion,
                    label_PatologiasRN,
                    label_EgresoRN,
                    label_lactancia,
                    label_Exclusiva,
                    label_Exclusiva_m,
                    label_Mixta,
                    label_Mixta_m,
                    label_Ablactacion,
                    label_Ablactacion_m,
                    label_Alergia,
                    label_Asma,
                    label_TBC,
                    label_Cardiopatia,
                    label_Hipertension,
                    label_Varice,
                    label_Desnutricion,
                    label_Diabetes,
                    label_Obesidad,
                    label_Gastropatia,
                    label_Neurologica,
                    label_Enf_Renal,
                    label_Cancer,
                    label_Alcohol,
                    label_Drogas,
                    label_Sífilis,
                    label_SIDA,
                    label_Artritis,
                    label_otros,
                    label_Padre,
                    label_Madre,
                    label_Hermanos,
                    label_Otros,
                    label_Menarquia,
                    label_Ciclo_menstrual,
                    label_PRSexual,
                    label_FrecuenciaRSexual,
                    label_N_Parejas,
                    label_Dispareunia,
                    label_Anticoncepcion,
                    label_Menopausia,
                    label_Gesta,
                    label_Partos,
                    label_Cesarea2,
                    label_Aborto,
                    label_E1erParto,
                    label_F_U_Parto,
                    label_F_UAborto,
                    label_Curetaje,
                    label_N_de_Hijos,
                    label_Vivos,
                    label_Muertos,
                    label_RN_mayor_peso,
                    label_RN_de_mayor_peso_gr,
                    label_Alergia2,
                    label_Asma2,
                    label_Neumonia,
                    label_TBC2,
                    label_Cardiopatia2,
                    label_Hipertension2,
                    label_Hiperlipidemias,
                    label_Varices,
                    label_Hepatopatia,
                    label_Desnutricion2,
                    label_Diabetes2,
                    label_Obesidad2,
                    label_Gastroenteritis,
                    label_Encoprexis,
                    label_Enf_Renal2,
                    label_Enuresis,
                    label_Cancer2,
                    label_Tromboembolica,
                    label_Tumor_Mamario,
                    label_Meningitis,
                    label_TCraneoencefal,
                    label_Enf_Eruptivas,
                    label_Dengue,
                    label_Hospitalizacion,
                    label_Interv_Quirurgica,
                    label_Accidentes,
                    label_Artritis2,
                    label_Enf_TS,
                    label_Enf_Infec_Tran,
                    label_Enf_Laboral,
                    label_Otros2,
                    label_Alcohol2,
                    label_Drogas2,
                    label_Insecticidas,
                    label_Deporte,
                    label_Sedentarismo,
                    label_Sueno,
                    label_ChuparDedo,
                    label_Onicofagia,
                    label_Micciones,
                    label_Evacuaciones,
                    label_Estres,
                    label_Metales_Pensados,
                    label_Alimentacion,
                    label_Fuma,
                    label_NCigarrillos_diarios
            };
            for (JComponent componetLabel : componentesLabel) {
                componetLabel.setForeground(Color.white);
            }
        } else {
            fondo3.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/NHM_part3-claro.png")));
        }
        fondo3.setBounds(0, 0, 1290, 720);
        Panel3.add(fondo3);
        contentPanel.add(Panel3, "panel3");
        setContentPane(contentPanel);

        JComponent[] componentes = {
                text_apellido_familiar,
                text_ci_jefe_familia,
                text_Numero_de_Historia,
                ci_ComboBox,
                text_ci,
                text_apellido,
                text_nombre,
                ComboBox_estadoCivil,
                text_Ocupacion,
                combo_estudio,
                text_anosAprobados,
                combo_Analfabeta,
                combo_sexo,
                calendario,
                text_LugarNacimiento,
                combo_Estado,
                combo_Pais,
                texto_Direccion,
                text_Telefono,
                text_Religion,
                texto_Establecimiento,
                texto_Parroquia,
                texto_Comunidad,
                texto_Madre_N_A,
                texto_Madre_Ocupacion,
                texto_Padre_N_A,
                texto_Padre_Ocupacion,
                combo_Representante,
                texto_Representante_N,
                combo__Representante_ci,
                texto_Representante_ci,
                texto_Representante_Telefono,
                combo_Carnet_prenatal,
                combo_patologiaEmbarazo,
                combo_patologiaParto,
                combo_patologiaPuerperio,
                text_NConsultasPrenatales,
                texto_Hrs_fuera_de_casa,
                combo_MadreFamilia,
                combo_PadreFamilia,
                combo_HermanoFamilia,
                text_OtrosFamilia,
                text_Edad_Gestacion,
                text_sem,
                combo_Forces,
                combo_Cesarea,
                combo_Parto,
                text_ApgarMin,
                combo_Reanimacion,
                combo_EgresoRN,
                text_Exclusiva,
                text_Mixta,
                text_Ablactacion,
                text_Peso_al_nacer,
                text_Talla,
                text_Circunferencia,
                combo_Asfixia,
                combo_PatologiasRN,
                combo_Alergia,
                combo_Asma,
                combo_TBC,
                combo_Cardiopatia,
                combo_Hipertension,
                combo_Varice,
                combo_Desnutricion,
                combo_Diabetes,
                combo_Obesidad,
                combo_Gastropatia,
                combo_Neurologica,
                combo_Enf_Renal,
                combo_Cancer,
                combo_Alcohol,
                combo_Drogas,
                combo_Sífilis,
                combo_SIDA,
                combo_Artritis,
                combo_otros,
                combo_Padre,
                combo_Madre,
                combo_Hermanos,
                combo_Otros,
                texto_Menarquia,
                texto_Ciclo_menstrual,
                texto_PRSexual,
                texto_FrecuenciaRSexual,
                texto_N_Parejas,
                combo_Dispareunia,
                combo_Anticoncepcion,
                combo_AC_DIU,
                combo_Menopausia,
                combo_Gesta,
                combo_Partos,
                combo_Cesarea2,
                combo_Aborto,
                texto_E1erParto,
                texto_F_U_Parto,
                texto_F_UAborto,
                combo_Curetaje,
                texto_N_de_Hijos,
                texto_Vivos,
                texto_Muertos,
                text_RN_de_mayor_peso,
                combo_Alergia2,
                combo_Asma2,
                combo_Neumonia,
                combo_TBC2,
                combo_Cardiopatia2,
                combo_Hipertension2,
                combo_Hiperlipidemias,
                combo_Varices,
                combo_Hepatopatia,
                combo_Desnutricion2,
                combo_Diabetes2,
                combo_Obesidad2,
                combo_Gastroenteritis,
                combo_Encoprexis,
                combo_Enf_Renal2,
                combo_Enuresis,
                combo_Cancer2,
                combo_Tromboembolica,
                combo_Tumor_Mamario,
                combo_Meningitis,
                combo_TCraneoencefal,
                combo_Enf_Eruptivas,
                combo_Dengue,
                combo_Hospitalizacion,
                combo_Interv_Quirurgica,
                combo_Accidentes,
                combo_Artritis2,
                combo_Enf_TS,
                combo_Enf_Infec_Tran,
                combo_Enf_Laboral,
                text_Otros,
                combo_Alcohol2,
                combo_Drogas2,
                combo_Insecticidas,
                combo_Deporte,
                combo_Sedentarismo,
                combo_Sueno,
                combo_ChuparDedo,
                combo_Onicofagia,
                combo_Micciones,
                combo_Evacuaciones,
                combo_Estres,
                combo_Metales_Pensados,
                combo_Alimentacion,
                combo_Fuma,
                texto_NCigarrillos_diarios
        };
        JComponent[] nuevoArrayComponentes = new JComponent[componentes.length + 1];
        System.arraycopy(componentes, 0, nuevoArrayComponentes, 0, componentes.length);

        String[] ObtenerDatos = Obtener_datos();
        String obtenerPais = ObtenerDatos[19];

        if (obtenerPais.equals("Venezuela")) {
            nuevoArrayComponentes[componentes.length] = Combo_municipio;
            texto_Municipio.setVisible(false);
        } else {
            nuevoArrayComponentes[componentes.length] = texto_Municipio;
            Combo_municipio.setVisible(false);
            texto_Municipio.setVisible(true);
        }
        componentes = nuevoArrayComponentes;
        int index = 0; // indice para los marcadores de posición
        for (String iterable_element : ObtenerDatos) {

            System.out.println(iterable_element + " " + index++);
        }

        index = 4;
        Object selectedEstado = null;
        for (JComponent componente : componentes) {
            if (componente instanceof JTextField) {
                ((JTextField) componente).setText(ObtenerDatos[index]);
                String nombreComponente1 = componente.getName();
                if (nombreComponente1 != null && nombreComponente1.equals("texto_Municipio")) {
                    texto_Municipio.setText(ObtenerDatos[index]);
                }
                index++;
            } else if (componente instanceof JComboBox<?>) {
                ((JComboBox<?>) componente).setSelectedItem(ObtenerDatos[index]);
                String nombreComponente1 = componente.getName();
                if (nombreComponente1 != null && nombreComponente1.equals("combo_Pais")) {
                    ItemListener itemListener = combo_Pais.getItemListeners()[0];
                    combo_Pais.removeItemListener(itemListener);
                    Object selectedPais = ObtenerDatos[index];
                    modelPais.setSelectedItem(selectedPais);
                    combo_Pais.setModel(modelPais);
                    combo_Pais.addItemListener(itemListener);

                } else if (nombreComponente1 != null && nombreComponente1.equals("combo_Estado")) {
                    selectedEstado = ObtenerDatos[index];
                    DefaultComboBoxModel<String> modelestado = new DefaultComboBoxModel(
                            estado.obtenerEstados(obtenerPais));
                    modelestado.setSelectedItem(selectedEstado);
                    combo_Estado.setModel(modelestado);

                } else if (nombreComponente1 != null && nombreComponente1.equals("Combo_municipio")) {
                    Object selectedMunicipio = ObtenerDatos[index];
                    String estado_Municipio = selectedEstado.toString();
                    DefaultComboBoxModel<String> modelMunicipio = new DefaultComboBoxModel(
                            Municipio.obtenerMunicipios(estado_Municipio));
                    modelMunicipio.setSelectedItem(selectedMunicipio);
                    Combo_municipio.setModel(modelMunicipio);

                }
                index++;
            } else if (componente instanceof JDateChooser) {
                try {
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String datos = ObtenerDatos[index];
                    Date parsedDate;
                    parsedDate = dateFormat.parse(datos);
                    ((JDateChooser) componente).setDate(parsedDate);
                    index++;
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
        }

        masInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "-Registrado por: " + ObtenerDatos[0] + "\n-Fecha de registro: " + ObtenerDatos[1]
                                + "\n-Modificado Por: " + ObtenerDatos[2] + "\n-Fecha de Modificación:"
                                + ObtenerDatos[3]+"\n-Observaciones del paciente:\n "+ ObtenerDatos[153]);
            }

        });

    }
}