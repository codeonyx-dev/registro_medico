package com.usd89.registro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafica extends JFrame {

    public Grafica(int lunes, int martes, int miércoles, int jueves, int vienes, int sábado, int domingo){
        
        setSize(800, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 20));
        setLocationRelativeTo(null);
    
        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(Color.BLACK);
        Panel.setBounds(0, 0, 800, 450);
        this.add(Panel);

        //Cerrar
        final JLabel Cerrar = Elementos.cerrar(780, 10, 20, 20);
        Cerrar.setForeground(Color.black);
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
        final JLabel Minimizar = Elementos.minimizar(760, 10, 20, 20);
        Minimizar.setForeground(Color.black);
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
    
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        datos.setValue(lunes,"Lunes","Pacientes");
        datos.setValue(martes,"Martes","Pacientes");
        datos.setValue(miércoles,"Miércoles","Pacientes");
        datos.setValue(jueves,"Jueves","Pacientes");
        datos.setValue(vienes,"Viernes","Pacientes");
        datos.setValue(sábado,"Sábado","Pacientes");
        datos.setValue(domingo,"Domingo","Pacientes");

        JFreeChart grafico_barra = ChartFactory.createBarChart(
            "Frecuencia de pacientes semanales", 
            "Días de la semana", 
            "Frecuencia de pacientes",
            datos,
            PlotOrientation.HORIZONTAL,
            true,
            true,
            false);
            
        ChartPanel panelGrafica = new ChartPanel(grafico_barra);
        panelGrafica.setMouseWheelEnabled(true);
        panelGrafica.setPreferredSize(new Dimension(800, 450));
        panelGrafica.setBounds(0, 0, 800, 450);
        Panel.add(panelGrafica);
        
    }

    public static void main(String[] args) {
        Grafica grafica = new Grafica(5,4,8,7,9,7,9);
        grafica.setVisible(true);
    }
}
