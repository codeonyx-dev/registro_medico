package com.usd89.resgitro;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class Menu extends JFrame {

    public Menu() {
        setSize(800, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(800, 450);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 20));
        setLocationRelativeTo(null);

        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBounds(0, 0, 800, 450);
        this.add(Panel);

        // Cerrar ventana
        final JLabel Cerrar = Elementos.Cerrar(780, 10, 20, 20);
        Panel.add(Cerrar);

        Cerrar.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            dispose(); // Cierra la ventana
        }
        public void mouseEntered(MouseEvent e) {
            Cerrar.setForeground(Color.red);
        }
        public void mouseExited(MouseEvent e){
            Cerrar.setForeground(Color.white);
        }
        });
        

        // Minimizar
        final JLabel Minimizar = Elementos.Minimizar(760, 10, 20, 20);
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

        // BOTONES CON JLABEL PARA CREAR HACERLOS DINAMICOS

        // Boton Nueva Historia Medica
        final JLabel nhmButton = new JLabel("NUEVA HISTORIA MEDICA", Elementos.bt_grande_off, SwingConstants.CENTER);
        nhmButton.setBounds(247, 137, 335, 67);
        nhmButton.setFont(new Font("Roboto Black", 1, 22));
        nhmButton.setForeground(new Color(0, 51, 51));
        nhmButton.setVerticalTextPosition(SwingConstants.CENTER);
        nhmButton.setHorizontalTextPosition(SwingConstants.CENTER);
        Panel.add(nhmButton);

        nhmButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                nhmButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/imagen/Fondos/Oscuro/Botones/bt_grande_on.png")));
            }

            public void mouseExited(MouseEvent e) {
                nhmButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/imagen/Fondos/Oscuro/Botones/bt_grande_off.png")));
            }
        });

        // Boton Busqueda Historia Medica
        final JLabel bhmButton = new JLabel("BUSCAR HISTORIA MEDICA", Elementos.bt_gigante_off, SwingConstants.CENTER);
        bhmButton.setBounds(234, 208, 354, 67);
        bhmButton.setFont(new Font("Roboto Black", 1, 22));
        bhmButton.setForeground(new Color(0, 51, 51));
        bhmButton.setHorizontalTextPosition(SwingConstants.CENTER);
        bhmButton.setVerticalTextPosition(SwingConstants.CENTER);
        Panel.add(bhmButton);

        bhmButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                bhmButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/imagen/Fondos/Oscuro/Botones/bt_gigante_on.png")));
            }

            public void mouseExited(MouseEvent e) {
                bhmButton.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/imagen/Fondos/Oscuro/Botones/bt_gigante_off.png")));
            }
        });

        // Boton Gestion de Usuario
        final JLabel usButton = new JLabel("GESTION DE USUARIO", Elementos.bt_mediano_off, SwingConstants.CENTER);
        usButton.setBounds(260, 280, 308, 67);
        usButton.setFont(new Font("Roboto Black", 1, 22));
        usButton.setForeground(new Color(0, 51, 51));
        usButton.setVerticalTextPosition(SwingConstants.CENTER);
        usButton.setHorizontalTextPosition(SwingConstants.CENTER);
        Panel.add(usButton);

        usButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                usButton.setIcon(Elementos.bt_mediano_on);
            }

            public void mouseExited(MouseEvent e) {
                usButton.setIcon(Elementos.bt_mediano_off);
            }
        });

        // Boton Cerrar sesion
        final JLabel csButton = new JLabel("CERRAR SESION", Elementos.bt_pequeno_off, SwingConstants.CENTER);
        csButton.setBounds(280, 350, 280, 67);
        csButton.setFont(new Font("Roboto Black", 1, 22));
        csButton.setForeground(new Color(0, 51, 51));
        csButton.setVerticalTextPosition(SwingConstants.CENTER);
        csButton.setHorizontalTextPosition(SwingConstants.CENTER);
        Panel.add(csButton);

        csButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                csButton.setIcon(Elementos.bt_pequeno_on);
            }

            public void mouseExited(MouseEvent e) {
                csButton.setIcon(Elementos.bt_pequeno_off);
            }
        });

        // FONDO
        JLabel fondo = new JLabel();
        fondo.setBounds(0, 0, 800, 450);
        Panel.add(fondo);
        /*if (Elementos.Tema == "Oscuro") {
            fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/imagen/Fondos/" + Elementos.Tema + "/fondo-Menu.png")));
        } else {
            fondo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/imagen/Fondos/" + Elementos.Tema + "/fondo-Menu.png")));
        }*/
    }

}