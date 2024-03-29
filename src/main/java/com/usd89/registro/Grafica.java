package com.usd89.registro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import com.toedter.calendar.JCalendar;
import com.usd89.DatabaseConnection.Conexion;

public class Grafica extends JFrame {
    int xMouse, yMouse;

    public Grafica() {

        setSize(1300, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagen/Icono.png"));
        setIconImage(icono.getImage());
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 20));
        setLocationRelativeTo(null);

        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(new Color(0, 62, 88));
        Panel.setBounds(0, 0, 1300, 500);
        this.add(Panel);

        // Cerrar
        final JLabel Cerrar = Elementos.cerrar(1280, 10, 20, 20);
        Panel.add(Cerrar);
        Cerrar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose(); // Cierra la ventana
            }

            public void mouseEntered(MouseEvent e) {
                Cerrar.setForeground(Color.red);
            }

            public void mouseExited(MouseEvent e) {
                Cerrar.setForeground(Color.white);
            }
        });

        // Minimizar
        final JLabel Minimizar = Elementos.minimizar(1260, 10, 20, 20);
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

        JLabel laber_buscadorFecha = new JLabel("Buscar la fecha:");
        laber_buscadorFecha.setBounds(1020, 80, 200, 30);
        laber_buscadorFecha.setFont(new Font("Arial", 3, 20));
        Panel.add(laber_buscadorFecha);

        JCalendar calendario = new JCalendar();
        calendario.setFont(new Font("Arial", 3, 12));
        calendario.setBounds(1020, 120, 250, 200);
        Panel.add(calendario);

        DefaultCategoryDataset datos = new DefaultCategoryDataset();

        JFreeChart grafico_barra = ChartFactory.createBarChart(
                "Frecuencia de pacientes semanales",
                "Días de la semana",
                "",
                datos,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
        

        ChartPanel panelGrafica = new ChartPanel(grafico_barra);
        panelGrafica.setMouseWheelEnabled(true);
        panelGrafica.setPreferredSize(new Dimension(800, 450));
        panelGrafica.setBounds(20, 20, 990, 450);
        Panel.add(panelGrafica);

        final JLabel ObtenerFecha = new JLabel("OBTENER ESTADÍSTICA", Elementos.botonImagen(Inicio.Tema, "mediano.0"),SwingConstants.CENTER);
        ObtenerFecha.setBounds(995, 340, 308, 67);
        ObtenerFecha.setFont(new Font("Roboto Black", 1, 22));
        ObtenerFecha.setForeground(Elementos.colores(Inicio.Tema));
        ObtenerFecha.setVerticalTextPosition(SwingConstants.CENTER);
        ObtenerFecha.setHorizontalTextPosition(SwingConstants.CENTER);
        ObtenerFecha.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                datos.clear();
                try {
                    Connection con = Conexion.getConexion();

                    // Supongamos que recibes la fecha a buscar desde algún método o variable
                    Date selectedDate = calendario.getDate();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String fechaSeleccionada = dateFormat.format(selectedDate);

                    // Convertir la fecha seleccionada a tipo Date
                    Date fecha = dateFormat.parse(fechaSeleccionada);

                    // Obtener el día de la semana de la fecha seleccionada (1 = domingo, 2 = lunes,..., 7 = sábado)
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(fecha);
                    int diaSemana = cal.get(Calendar.DAY_OF_WEEK);

                    // Si la fecha es domingo, retrocede una semana para obtener la semana actual
                    if (diaSemana == Calendar.SUNDAY) {
                        cal.add(Calendar.DATE, -6); // Retroceder 6 días para obtener el lunes de la misma semana
                    } else {
                        cal.add(Calendar.DATE, -(diaSemana - Calendar.MONDAY)); // Retroceder para obtener el lunes de
                    }
                    Date fechaLunes = cal.getTime();

                    // Avanzar para obtener el domingo de la semana
                    cal.add(Calendar.DATE, 6); // Avanzar 6 días desde el lunes para llegar al domingo
                    Date fechaDomingo = cal.getTime();

                    // Consulta para obtener la cantidad de pacientes para cada día de la semana
                    String consultaPacientes = "SELECT fecha, cantidad_pacientes FROM estadistica_pacientes WHERE fecha BETWEEN ? AND ?";
                    PreparedStatement pstmtPacientes = con.prepareStatement(consultaPacientes);
                    pstmtPacientes.setDate(1, new java.sql.Date(fechaLunes.getTime()));
                    pstmtPacientes.setDate(2, new java.sql.Date(fechaDomingo.getTime()));
                    ResultSet rsPacientes = pstmtPacientes.executeQuery();

                    // Crear un mapa para almacenar la cantidad de pacientes por fecha
                    Map<Date, Integer> pacientesPorFecha = new HashMap<>();
                    while (rsPacientes.next()) {
                        Date fechaBD = rsPacientes.getDate("fecha");
                        int cantidad = rsPacientes.getInt("cantidad_pacientes");
                        pacientesPorFecha.put(fechaBD, cantidad);
                    }

                    // Mostrar la cantidad de pacientes para cada día de la semana con el nombre del día
                    SimpleDateFormat sdfOutput = new SimpleDateFormat("EEEE\nyyyy-MM-dd"); // Formato para mostrar el día de la semana
                    cal.setTime(fechaLunes);
                    while (!cal.getTime().after(fechaDomingo)) {
                        Date fechaActual = cal.getTime();
                        Integer cantidadPacientes = pacientesPorFecha.getOrDefault(fechaActual, 0);
                        datos.setValue(cantidadPacientes, sdfOutput.format(fechaActual), "");
                        cal.add(Calendar.DATE, 1); // Avanzar al siguiente día
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            public void mouseEntered(MouseEvent e) {
                ObtenerFecha.setIcon(Elementos.botonImagen(Inicio.Tema, "mediano.1"));
            }

            public void mouseExited(MouseEvent e) {
                ObtenerFecha.setIcon(Elementos.botonImagen(Inicio.Tema, "mediano.0"));
            }

        });
        Panel.add(ObtenerFecha);

        final JLabel volverButton = new JLabel("VOLVER AL INICIO", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        volverButton.setBounds(1000, 400, 308, 67);
        volverButton.setFont(new Font("Roboto Black", 1, 22));
        volverButton.setForeground(Elementos.colores(Inicio.Tema));
        volverButton.setVerticalTextPosition(SwingConstants.CENTER);
        volverButton.setHorizontalTextPosition(SwingConstants.CENTER);
        volverButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Menu menu = new Menu();
                menu.setVisible(true);
                dispose();
            }

            public void mouseEntered(MouseEvent e) {
                volverButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                volverButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }

        });
        Panel.add(volverButton);
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
        Panel.add(Encabezado);

        JLabel fondo = new JLabel();
        fondo.setBounds(0, 0, 1300, 500);
        Panel.add(fondo);
        if (Inicio.Tema == "Oscuro") {
            fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Oscuro/Estadistica.png")));
            grafico_barra.setBackgroundPaint(new Color(0, 62, 88));
            laber_buscadorFecha.setForeground(Color.white);

            TextTitle title = grafico_barra.getTitle();
            if (title != null) {
                title.setPaint(Color.white); // Cambia el color del título a azul
            }
            // Cambiar el color del texto del eje X (horizontal)
            CategoryPlot plot = (CategoryPlot) grafico_barra.getPlot();
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setLabelPaint(Color.white); // Cambia el color del texto del eje X a rojo
            domainAxis.setTickLabelPaint(Color.white); // Cambia el color de las etiquetas del eje X a verde
    
            // Cambiar el color del texto del eje Y (vertical)
            NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
            rangeAxis.setLabelPaint(Color.white); // Cambia el color del texto del eje Y a naranja
            rangeAxis.setTickLabelPaint(Color.white); // Cambia el color de las etiquetas del eje Y a magenta   
        } else {
            fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/Estadistica.png")));
            laber_buscadorFecha.setForeground(Color.black);
            grafico_barra.setBackgroundPaint(new Color(143, 224, 250));
            TextTitle title = grafico_barra.getTitle();
            if (title != null) {
                title.setPaint(Color.black); // Cambia el color del título a azul
            }
            // Cambiar el color del texto del eje X (horizontal)
            CategoryPlot plot = (CategoryPlot) grafico_barra.getPlot();
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setLabelPaint(Color.black); // Cambia el color del texto del eje X a rojo
            domainAxis.setTickLabelPaint(Color.black); // Cambia el color de las etiquetas del eje X a verde
    
            // Cambiar el color del texto del eje Y (vertical)
            NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
            rangeAxis.setLabelPaint(Color.black); // Cambia el color del texto del eje Y a naranja
            rangeAxis.setTickLabelPaint(Color.black); // Cambia el color de las etiquetas del eje Y a magenta
        }
    }
}
