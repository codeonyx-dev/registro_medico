package com.usd89.registro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GestionUser extends JFrame {
    public GestionUser() {
        setSize(680, 560);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 20));
        setLocationRelativeTo(null);

        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBounds(0, 0, 680, 560);
        this.add(Panel);

        // Cerrar ventana
        final JLabel Cerrar = Elementos.cerrar(660, 10, 20, 20);
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
        final JLabel Minimizar = Elementos.minimizar(640, 10, 20, 20);
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

        // Datos para rellenar
        JTextField nombreField = Elementos.crearJTextField(14, 76, 260, 29, 15, "Roboto", "", true);
        Panel.add(nombreField);

        JTextField apellidoField = Elementos.crearJTextField(14, 134, 260, 29, 15, "Roboto", "", true);
        Panel.add(apellidoField);

        JTextField cedulaField = Elementos.crearJTextField(14, 194, 260, 29, 15, "Roboto", "", true);
        Panel.add(cedulaField);

        JTextField telefonofield = Elementos.crearJTextField(14, 255, 260, 29, 15, "Roboto", "", true);
        Panel.add(telefonofield);

        JTextField usuariofield = Elementos.crearJTextField(14, 325, 260, 29, 15, "Roboto", "", true);
        Panel.add(usuariofield);

        JTextField contrasenafield = Elementos.crearJTextField(14, 387, 260, 29, 15, "Roboto", "", true);
        Panel.add(contrasenafield);

        // TABLA DE DATOS
        String[] columnas = { "Nombre", "Apellido", "Cedula", "Telefono", "Usuario" };
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        JTable tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(291, 52, 380, 375);
        Panel.add(scrollPane);

        //Botones 
            //VOLVER
        final JLabel buttonRegresar = Elementos.crearJLabel(240, 500, 210, 60,"REGRESAR", false);
        buttonRegresar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        buttonRegresar.setFont(new Font("Roboto Black", 1, 22));
        buttonRegresar.setForeground(Elementos.colores(Inicio.Tema));
        buttonRegresar.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonRegresar.setVerticalTextPosition(SwingConstants.CENTER);
        Panel.add(buttonRegresar);
        buttonRegresar.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            dispose();
            Menu menu = new Menu();
            menu.setVisible(true);
        }
        public void mouseEntered(MouseEvent e) {
            buttonRegresar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.1"));

        }
        public void mouseExited(MouseEvent e){
            buttonRegresar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        }
        });
            //Añadir
        final JLabel buttonAgregar = Elementos.crearJLabel(10, 440, 210, 60,"AGREGAR", false);
        buttonAgregar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        buttonAgregar.setFont(new Font("Roboto Black", 1, 22));
        buttonAgregar.setForeground(Elementos.colores(Inicio.Tema));
        buttonAgregar.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonAgregar.setVerticalTextPosition(SwingConstants.CENTER);
        Panel.add(buttonAgregar);
        buttonAgregar.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {
            buttonAgregar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.1"));
        }
        public void mouseExited(MouseEvent e){
            buttonAgregar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        }
        });
        

            //Eliminar
        final JLabel buttonEliminar = Elementos.crearJLabel(240, 440, 210, 60,"ELIMINAR", false);
        buttonEliminar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        buttonEliminar.setFont(new Font("Roboto Black", 1, 22));
        buttonEliminar.setForeground(Elementos.colores(Inicio.Tema));
        buttonEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonEliminar.setVerticalTextPosition(SwingConstants.CENTER);
        Panel.add(buttonEliminar);
        buttonEliminar.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {
            buttonAgregar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.1"));
        }
        public void mouseExited(MouseEvent e){
            buttonAgregar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        }
        });
        

            //Modificar
        final JLabel buttonModificar = Elementos.crearJLabel(465, 440, 210, 60,"MODIFICAR", false);
        buttonModificar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        buttonModificar.setFont(new Font("Roboto Black", 1, 22));
        buttonModificar.setForeground(Elementos.colores(Inicio.Tema));
        buttonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonModificar.setVerticalTextPosition(SwingConstants.CENTER);
        Panel.add(buttonModificar);
        buttonModificar.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {
            buttonAgregar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.1"));
        }
        public void mouseExited(MouseEvent e){
            buttonAgregar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        }
        });


        // FONDO
        JLabel fondo = new JLabel();
        fondo.setBounds(0, 0, 680, 560);
        fondo.setBackground(Color.BLACK);
        Panel.add(fondo);
        if (Inicio.Tema == "Oscuro") {
            fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Oscuro/Gestion-de-Usuario.png")));
        } else {
            fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/Gestion-de-Usuario.png")));
        }

    }

    public static void main(String[] args) {
        GestionUser gestionUser = new GestionUser();
        gestionUser.setVisible(true);
    }
}
