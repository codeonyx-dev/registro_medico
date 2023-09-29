package com.usd89.registro;

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
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 20));
        setLocationRelativeTo(null);

        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBounds(0, 0, 800, 450);
        this.add(Panel);

        // Cerrar ventana
        final JLabel Cerrar = Elementos.cerrar(780, 10, 20, 20);
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
        final JLabel nhmButton = new JLabel("NUEVA HISTORIA MEDICA", Elementos.botonImagen(Inicio.Tema,"grande.0"), SwingConstants.CENTER);
        nhmButton.setBounds(247, 137, 335, 67);
        nhmButton.setFont(new Font("Roboto Black", 1, 22));
        nhmButton.setForeground(Elementos.colores(Inicio.Tema));
        nhmButton.setVerticalTextPosition(SwingConstants.CENTER);
        nhmButton.setHorizontalTextPosition(SwingConstants.CENTER);
        Panel.add(nhmButton);

        nhmButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                NHM ngm = new NHM();
                ngm.setVisible(true);
                dispose();
            }

            public void mouseEntered(MouseEvent e) {
                nhmButton.setIcon(Elementos.botonImagen(Inicio.Tema,"grande.1"));
            }

            public void mouseExited(MouseEvent e) {
                nhmButton.setIcon(Elementos.botonImagen(Inicio.Tema,"grande.0"));
            }
        });

        // Boton Busqueda Historia Medica
        final JLabel bhmButton = new JLabel("BUSCAR HISTORIA MEDICA", Elementos.botonImagen(Inicio.Tema,"gigante.0"), SwingConstants.CENTER);
        bhmButton.setBounds(234, 208, 354, 67);
        bhmButton.setFont(new Font("Roboto Black", 1, 22));
        bhmButton.setForeground(Elementos.colores(Inicio.Tema));
        bhmButton.setHorizontalTextPosition(SwingConstants.CENTER);
        bhmButton.setVerticalTextPosition(SwingConstants.CENTER);
        Panel.add(bhmButton);

        bhmButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                bhmButton.setIcon(Elementos.botonImagen(Inicio.Tema,"gigante.1"));
            }

            public void mouseExited(MouseEvent e) {
                bhmButton.setIcon(Elementos.botonImagen(Inicio.Tema,"gigante.0"));
            }
        });

        // Boton Gestion de Usuario
        final JLabel usButton = new JLabel("GESTION DE USUARIO", Elementos.botonImagen(Inicio.Tema,"mediano.0"), SwingConstants.CENTER);
        usButton.setBounds(260, 280, 308, 67);
        usButton.setFont(new Font("Roboto Black", 1, 22));
        usButton.setForeground(Elementos.colores(Inicio.Tema));
        usButton.setVerticalTextPosition(SwingConstants.CENTER);
        usButton.setHorizontalTextPosition(SwingConstants.CENTER);

        usButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                GestionUser gestion = new GestionUser();
                gestion.setVisible(true);
                dispose();
            }

            public void mouseEntered(MouseEvent e) {
                usButton.setIcon(Elementos.botonImagen(Inicio.Tema,"mediano.1"));
            }

            public void mouseExited(MouseEvent e) {
                usButton.setIcon(Elementos.botonImagen(Inicio.Tema,"mediano.0"));
            }
        });

        if (Inicio.nivel_acceso.equals("administrador")) {
            Panel.add(usButton);
        } else {
            nhmButton.setBounds(247, 208, 335, 67);
            bhmButton.setBounds(234, 280, 354, 67);

        }

        // Boton Cerrar sesion
        final JLabel csButton = new JLabel("CERRAR SESION", Elementos.botonImagen(Inicio.Tema,"pequeno.0"), SwingConstants.CENTER);
        csButton.setBounds(280, 350, 280, 67);
        csButton.setFont(new Font("Roboto Black", 1, 22));
        csButton.setForeground(Elementos.colores(Inicio.Tema));
        csButton.setVerticalTextPosition(SwingConstants.CENTER);
        csButton.setHorizontalTextPosition(SwingConstants.CENTER);
        Panel.add(csButton);

        csButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                csButton.setIcon(Elementos.botonImagen(Inicio.Tema,"pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                csButton.setIcon(Elementos.botonImagen(Inicio.Tema,"pequeno.0"));
            }
        });

        // FONDO
        JLabel fondo = new JLabel();
        fondo.setBounds(0, 0, 800, 450);
        Panel.add(fondo);
        if (Inicio.Tema == "Oscuro") {
            fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Oscuro/fondo-Menu.png")));
        } else {
            fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/fondo-Menu.png")));
        }
    }

}