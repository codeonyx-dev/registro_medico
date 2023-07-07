package com.usd89.resgitro;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class Inicio extends JFrame {
  static String Tema = "Oscuro";

  public Inicio() {
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setUndecorated(true);
    setSize(400, 425);
    setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 20));
    setLocationRelativeTo(null);

    // Panel
    JPanel Panel = new JPanel();
    Panel.setLayout(null);
    Panel.setBounds(0, 0, 400, 425);
    add(Panel);

    JTextField Usuario = Elementos.crearJTextField(79, 155, 250, 25, 14, "Arial", "Usuario", true);
    Panel.add(Usuario);

    JPasswordField Contrasena = new JPasswordField("Contraseña");
    Contrasena.setBounds(79, 230, 250, 25);
    Contrasena.setFont(new Font("Arial", 1, 14));
    Contrasena.setBorder(BorderFactory.createLineBorder(new Color(73, 176, 213)));
    Panel.add(Contrasena);

    final JLabel Cerrar = Elementos.cerrar(370, 10, 20, 20);
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

    final JLabel Minimizar = Elementos.minimizar(340, 10, 20, 20);
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

    final JButton btnInicio = Elementos.crearJButton(150, 370, 100, 30, "Inicio");
    btnInicio.setFont(new Font("Roboto", 1, 20));
    btnInicio.setBackground(new Color(0, 62, 88));
    btnInicio.setForeground(Color.white);
    Panel.add(btnInicio);
    btnInicio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new Menu().setVisible(true);
        dispose();
      }
    });

    final JLabel cambio_tema = Elementos.crearJLabel(10, 10, 40, 40, "", false);
    cambio_tema.setIcon(new ImageIcon(getClass().getResource("/imagen/Claro.png")));
    Panel.add(cambio_tema);

    final JLabel fondo = Elementos.crearJLabel(0, 0, 400, 425, "", false);
    fondo.setIcon((new ImageIcon(Elementos.class.getResource("/imagen/Fondos/"+Inicio.Tema+"/fondo-Inicio.png"))));
    Panel.add(fondo);

    cambio_tema.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (Inicio.Tema == "Oscuro") {
          // Cambio a tema oscuro
          Inicio.Tema = "Claro";
          fondo.setIcon(new ImageIcon(Elementos.class.getResource("/imagen/Fondos/"+Inicio.Tema+"/fondo-Inicio.png")));
          cambio_tema.setIcon(new ImageIcon(getClass().getResource("/imagen/Oscuro.png")));
          cambio_tema.setBounds(10, 5, 40, 40);
          btnInicio.setBackground(new Color(21, 147, 219));
        } else {
          // Cambio a tema claro
          Inicio.Tema = "Oscuro";
          fondo.setIcon(new ImageIcon(Elementos.class.getResource("/imagen/Fondos/"+Inicio.Tema+"/fondo-Inicio.png")));
          cambio_tema.setIcon(new ImageIcon(getClass().getResource("/imagen/Claro.png")));
          cambio_tema.setBounds(10, 10, 40, 40);
          btnInicio.setBackground(new Color(0, 62, 88));
        }
      }
    });

  }

  public static void main(String[] args) {
    new Inicio().setVisible(true);
  }
}
