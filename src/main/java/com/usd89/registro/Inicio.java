package com.usd89.registro;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.usd89.DatabaseConnection.Conexion;

public class Inicio extends JFrame {
  static String Tema = "Oscuro";
  static String nivel_acceso = "lectura";
  static String UsuarioNombre = "";
  static JTextField Usuario;
  static JPasswordField Contraseña;
  int xMouse, yMouse;

  public Inicio() {
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setUndecorated(true);
    setSize(400, 425);
    ImageIcon icono = new ImageIcon(getClass().getResource("/imagen/Icono.png"));
    setIconImage(icono.getImage());
    setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 20));
    setLocationRelativeTo(null);

    // Panel
    JPanel Panel = new JPanel();
    Panel.setLayout(null);
    Panel.setBounds(0, 0, 400, 425);
    add(Panel);

    Usuario = Elementos.crearJTextField(79, 155, 250, 25, "", true);
    Usuario.setFont(new Font("Arial", 1, 14));
    Panel.add(Usuario);
    // Campo de Contraseña
    Contraseña = new JPasswordField("");
    Contraseña.setBounds(79, 230, 250, 25);
    Contraseña.setFont(new Font("Arial", 1, 14));
    Contraseña.setBorder(BorderFactory.createLineBorder(new Color(73, 176, 213)));
    Panel.add(Contraseña);
    // Cerrar
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
    // Minimizar
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
    // Mostrar contraseña
    final JLabel btnMostrar = Elementos.crearJLabel(79, 260, 150, 30, "Estado: Oculto", false);
    btnMostrar.setFont(new Font("Roboto", 1, 10));
    btnMostrar.setForeground(Color.white);
    Panel.add(btnMostrar);
    btnMostrar.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (btnMostrar.getText().equals("Estado: Oculto")) {
          Contraseña.setEchoChar((char) 0);
          btnMostrar.setText("Estado: Visible");
        } else {
          Contraseña.setEchoChar(('•'));
          btnMostrar.setText("Estado: Oculto");
        }
      }
    });

    // Botón Inicio de Sesión
    final JButton btnInicio = Elementos.crearJButton(150, 370, 100, 30, "Inicio");
    btnInicio.setFont(new Font("Roboto", 1, 20));
    btnInicio.setBackground(new Color(0, 62, 88));
    btnInicio.setForeground(Color.white);
    Panel.add(btnInicio);
    btnInicio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String usuario = Usuario.getText();
        String clave = new String(Contraseña.getPassword());

        // Validación de datos de usuario
        // Se conecta la bdd
        Connection conexion = Conexion.getConexion();
        if (conexion != null) {

          try {
            String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?  ";
            // Crear la consulta
            PreparedStatement consultaStatement = conexion.prepareStatement(sql);
            consultaStatement.setString(1, usuario);
            consultaStatement.setString(2, clave);
            // resultado de los datos
            ResultSet resultado = consultaStatement.executeQuery();

            if (!usuario.isEmpty() && !clave.isEmpty()) {
              if (resultado.next()) {
                nivel_acceso = resultado.getString("nivel_acceso");
                UsuarioNombre = resultado.getString("nombre_usuario");
                new Menu().setVisible(true);
                dispose();
              } else {
                Usuario.setText("");
                Contraseña.setText("");
                JOptionPane.showMessageDialog(null, "Usuario o clave inválido", "Error", JOptionPane.ERROR_MESSAGE);
              }
            } else {
              JOptionPane.showMessageDialog(null, "Rellene todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
            }
            // Cierra la conexión de la bdd
            conexion.close();
          } catch (SQLException ex) {
            System.out.println(ex);
          }
        } else {
        }

      }
    });

    // Acción para activar el enter
    Contraseña.addKeyListener(new KeyListener() {

      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          // Acción que quieres realizar al presionar Enter
          btnInicio.doClick(); // Simula un clic en el botón
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }
    });
    Usuario.addKeyListener(new KeyListener() {

      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          // Acción que quieres realizar al presionar Enter
          btnInicio.doClick(); // Simula un clic en el botón
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }
    });
    // Botón cambio de Tema
    final JLabel cambio_tema = Elementos.crearJLabel(10, 10, 40, 40, "", false);
    try {
      cambio_tema.setIcon(new ImageIcon(getClass().getResource("/imagen/Claro.png")));
    } catch (Exception e) {
      e.printStackTrace();
    }
    Panel.add(cambio_tema);

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
    // Fondo
    final JLabel fondo = Elementos.crearJLabel(0, 0, 400, 425, "", false);
    fondo.setIcon((new ImageIcon(getClass().getResource("/imagen/Fondos/" + Inicio.Tema + "/fondo-Inicio.png"))));
    Panel.add(fondo);

    fondo.setFocusable(true);
    cambio_tema.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (Tema == "Oscuro") {
          // Cambio a tema oscuro
          Tema = "Claro";
          fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/" + Tema + "/fondo-Inicio.png")));
          cambio_tema.setIcon(new ImageIcon(getClass().getResource("/imagen/Oscuro.png")));
          cambio_tema.setBounds(10, 5, 40, 40);
          btnInicio.setBackground(new Color(21, 147, 219));
          btnMostrar.setForeground(new Color(45, 158, 212));
        } else {
          // Cambio a tema claro
          Inicio.Tema = "Oscuro";
          fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/" + Inicio.Tema + "/fondo-Inicio.png")));
          cambio_tema.setIcon(new ImageIcon(getClass().getResource("/imagen/Claro.png")));
          cambio_tema.setBounds(10, 10, 40, 40);
          btnInicio.setBackground(new Color(0, 62, 88));
        }
      }
    });

    Panel.requestFocusInWindow();
  }

  public static void main(String[] args) {
    new Inicio().setVisible(true);
  }
}
