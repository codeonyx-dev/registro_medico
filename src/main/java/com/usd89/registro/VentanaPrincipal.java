package com.usd89.registro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public VentanaPrincipal() {
        frame = new JFrame("Ejemplo de Ventanas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel panel1 = new JPanel();
        JTextField textField1 = new JTextField(20);
        panel1.add(new JLabel("Ventana 1"));
        panel1.add(textField1);
        JButton nextButton1 = new JButton("Siguiente");
        panel1.add(nextButton1);

        JPanel panel2 = new JPanel();
        JTextField textField2 = new JTextField(20);
        panel2.add(new JLabel("Ventana 2"));
        panel2.add(textField2);
        JButton backButton2 = new JButton("Volver");
        panel2.add(backButton2);

        nextButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(cardPanel);
            }
        });

        backButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.previous(cardPanel);
            }
        });

        cardPanel.add(panel1, "ventana1");
        cardPanel.add(panel2, "ventana2");

        frame.add(cardPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal();
            }
        });
    }
}

