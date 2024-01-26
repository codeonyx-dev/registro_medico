package com.usd89.registro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.usd89.DatabaseConnection.Conexion;

public class GestionUsuarios extends JFrame {
    String id;
    int xMouse, yMouse;

    public DefaultTableModel CargarTabla() {
        String[] columnas = { "Nombre", "Apellido", "Cédula", "Telefono", "Usuario" };
        DefaultTableModel modeloTable = new DefaultTableModel(null, columnas);
        Connection conectar = Conexion.getConexion();
        try {
            String sql = "SELECT * FROM usuarios";
            Statement statement = conectar.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            // Nombre, Apellido, cédula, Telefono, nombre_usuario
            while (resultSet.next()) {
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellido");
                String cedula = resultSet.getString("cedula");
                String telefono = resultSet.getString("telefono");
                String nombre_usuario = resultSet.getString("nombre_usuario");
                modeloTable.addRow(new Object[] { nombre, apellido, cedula, telefono, nombre_usuario });
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return modeloTable;
    }

    public GestionUsuarios() {
        setSize(680, 560);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagen/Icono.png"));
        setIconImage(icono.getImage());
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
        final JTextField nombreField = Elementos.crearJTextField(14, 76, 260, 29, "", true);
        Panel.add(nombreField);
        nombreField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                nombreField.setBackground(Color.white);
            }
        });
        nombreField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE
                        || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JTextField apellidoField = Elementos.crearJTextField(14, 134, 260, 29, "", true);
        Panel.add(apellidoField);
        apellidoField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                apellidoField.setBackground(Color.white);
            }
        });
        apellidoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isAlphabetic(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE
                        || c == ' ')) {
                    evt.consume();
                }
            }
        });

        final JTextField cedulaField = Elementos.crearJTextField(14, 194, 260, 29, "", true);
        Panel.add(cedulaField);
        cedulaField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cedulaField.setBackground(Color.white);
            }
        });
        cedulaField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JTextField telefonofield = Elementos.crearJTextField(14, 255, 260, 29, "", true);
        Panel.add(telefonofield);
        telefonofield.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                telefonofield.setBackground(Color.white);
            }
        });
        telefonofield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(Character.isDigit(c) || c == '-' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    evt.consume();
                }
            }
        });

        final JTextField usuarioField = Elementos.crearJTextField(14, 325, 260, 29, "", true);
        Panel.add(usuarioField);
        usuarioField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                usuarioField.setBackground(Color.white);
            }
        });
        usuarioField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (c == ' ') {
                    evt.consume();
                }
            }
        });

        final JTextField contrasenaField = Elementos.crearJTextField(14, 387, 260, 29, "", true);
        Panel.add(contrasenaField);
        contrasenaField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                contrasenaField.setBackground(Color.white);
            }
        });
        contrasenaField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (c == ' ') {
                    evt.consume();
                }
            }
        });

        // TABLA DE DATOS
        final JTable tabla = new JTable(CargarTabla());
        tabla.setDefaultEditor(Object.class, null);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(291, 52, 380, 375);
        Panel.add(scrollPane);
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Connection conexion = Conexion.getConexion();
                int selectedRow = tabla.getSelectedRow();
                String cedula = CargarTabla().getValueAt(selectedRow, 2).toString();
                try {
                    String sql = "SELECT * FROM usuarios WHERE cedula = ?";
                    PreparedStatement consultasStatement = conexion.prepareStatement(sql);
                    consultasStatement.setString(1, cedula);
                    ResultSet resultSet = consultasStatement.executeQuery();
                    while (resultSet.next()) {
                        id = resultSet.getString("id");
                        nombreField.setText(resultSet.getString("Nombre"));
                        apellidoField.setText(resultSet.getString("Apellido"));
                        cedulaField.setText(resultSet.getString("cedula"));
                        telefonofield.setText(resultSet.getString("telefono"));
                        usuarioField.setText(resultSet.getString("nombre_usuario"));
                        contrasenaField.setText(resultSet.getString("contrasena"));
                    }
                    conexion.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        // Botones
        // VOLVER

        final JLabel buttonRegresar = Elementos.crearJLabel(130, 500, 210, 60, "REGRESAR", false);
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

            public void mouseExited(MouseEvent e) {
                buttonRegresar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
            }
        });

        final JLabel buttonLimpiar = Elementos.crearJLabel(340, 500, 210, 60, "LIMPIAR CAMPOS", false);
        buttonLimpiar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        buttonLimpiar.setFont(new Font("Roboto Black", 1, 22));
        buttonLimpiar.setForeground(Elementos.colores(Inicio.Tema));
        buttonLimpiar.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonLimpiar.setVerticalTextPosition(SwingConstants.CENTER);
        Panel.add(buttonLimpiar);
        buttonLimpiar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JTextField[] textField = { nombreField, apellidoField, cedulaField, telefonofield, contrasenaField,
                        usuarioField };
                for (JTextField JTextField : textField) {
                    JTextField.setText("");
                    JTextField.setBackground(Color.white);
                }
            }

            public void mouseEntered(MouseEvent e) {
                buttonLimpiar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.1"));

            }

            public void mouseExited(MouseEvent e) {
                buttonLimpiar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
            }
        });

        // Añadir
        final JLabel buttonAgregar = Elementos.crearJLabel(10, 440, 210, 60, "AGREGAR", false);
        buttonAgregar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        buttonAgregar.setFont(new Font("Roboto Black", 1, 22));
        buttonAgregar.setForeground(Elementos.colores(Inicio.Tema));
        buttonAgregar.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonAgregar.setVerticalTextPosition(SwingConstants.CENTER);
        Panel.add(buttonAgregar);
        buttonAgregar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int comprobar = 0;
                nombreField.setBackground(
                        usuarioField.getText().isEmpty() ? new Color(255, 102, 102) : new Color(255, 255, 255));
                comprobar += nombreField.getText().isEmpty() ? 1 : 0;
                apellidoField.setBackground(
                        usuarioField.getText().isEmpty() ? new Color(255, 102, 102) : new Color(255, 255, 255));
                comprobar += apellidoField.getText().isEmpty() ? 1 : 0;
                cedulaField.setBackground(
                        usuarioField.getText().isEmpty() ? new Color(255, 102, 102) : new Color(255, 255, 255));
                comprobar += cedulaField.getText().isEmpty() ? 1 : 0;
                usuarioField.setBackground(
                        usuarioField.getText().isEmpty() ? new Color(255, 102, 102) : new Color(255, 255, 255));
                comprobar += usuarioField.getText().isEmpty() ? 1 : 0;
                contrasenaField.setBackground(
                        usuarioField.getText().isEmpty() ? new Color(255, 102, 102) : new Color(255, 255, 255));
                comprobar += contrasenaField.getText().isEmpty() ? 1 : 0;

                if (comprobar == 0) {
                    String[] privilegios = { "lectura", "modificacion", "administrador" };
                    String privilegio = (String) JOptionPane.showInputDialog(null,
                            "Selecciones el Privilegio del nuevo usuario", "Privilegio",
                            JOptionPane.INFORMATION_MESSAGE, null, privilegios, privilegios[0]);
                    if (privilegio != null) {
                        Connection conexion = Conexion.getConexion();
                        try {
                            String sql2 = "SELECT nombre_usuario FROM usuarios WHERE  nombre_usuario = ?";
                            PreparedStatement consultaStatement2 = conexion.prepareStatement(sql2);
                            consultaStatement2.setString(1, usuarioField.getText().toString());
                            ResultSet resultado2 = consultaStatement2.executeQuery();
                            // Si la cedula esta repetida
                            String sql1 = "SELECT cedula FROM usuarios WHERE cedula = ?";
                            PreparedStatement consultaStatement1 = conexion.prepareStatement(sql1);
                            consultaStatement1.setString(1, cedulaField.getText().toString());
                            ResultSet resultado = consultaStatement1.executeQuery();
                            if (resultado2.next()) {
                                JOptionPane.showMessageDialog(null, "Este usuario ya esta registrado", "Error",
                                        JOptionPane.ERROR_MESSAGE, null);
                            } else if (resultado.next()) {
                                JOptionPane.showMessageDialog(null, "Esta cedula ya esta registrada", "Error",
                                        JOptionPane.ERROR_MESSAGE, null);
                            } else {
                                String sql = "INSERT INTO usuarios (nombre_usuario, contrasena, Nombre, Apellido, cedula, telefono, nivel_acceso) VALUES (?, ?, ?, ?, ?, ?, ?)";
                                try {
                                    conexion.prepareStatement(sql);
                                    PreparedStatement consultaStatement = conexion.prepareStatement(sql);
                                    consultaStatement.setString(1, usuarioField.getText().toString().toLowerCase());
                                    consultaStatement.setString(2, contrasenaField.getText().toString());
                                    consultaStatement.setString(3, nombreField.getText().toString());
                                    consultaStatement.setString(4, apellidoField.getText().toString());
                                    consultaStatement.setString(5, cedulaField.getText().toString());
                                    consultaStatement.setString(6, telefonofield.getText().toString());
                                    consultaStatement.setString(7, privilegio);
                                    consultaStatement.executeUpdate();
                                    conexion.close();
                                    tabla.setModel(CargarTabla());
                                    tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
                                } catch (SQLException ex) {
                                    System.out.println(ex);
                                }

                            }
                        } catch (SQLException ex) {

                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aun no ha llenado todo los campos", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }

            public void mouseEntered(MouseEvent e) {
                buttonAgregar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                buttonAgregar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
            }
        });

        // Eliminar
        final JLabel buttonEliminar = Elementos.crearJLabel(240, 440, 210, 60, "ELIMINAR", false);
        buttonEliminar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        buttonEliminar.setFont(new Font("Roboto Black", 1, 22));
        buttonEliminar.setForeground(Elementos.colores(Inicio.Tema));
        buttonEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonEliminar.setVerticalTextPosition(SwingConstants.CENTER);
        Panel.add(buttonEliminar);
        buttonEliminar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tabla.getSelectedRow();
                // Obtener los valores de las celdas de la fila seleccionada
                String usuario = CargarTabla().getValueAt(selectedRow, 4).toString();
                try {
                    Connection conexion = Conexion.getConexion();
                    // Crear una sentencia SQL DELETE
                    String sql = "DELETE FROM usuarios WHERE  nombre_usuario = ?";
                    // Crear un objeto PreparedStatement con la sentencia SQL
                    PreparedStatement statement = conexion.prepareStatement(sql);
                    // Establecer el valor del parámetro en la sentencia SQL
                    statement.setString(1, usuario);
                    // Ejecutar la sentencia SQL DELETE
                    int filasAfectadas = statement.executeUpdate();
                    // Mostrar una confirmación si se eliminó el registro
                    if (filasAfectadas > 0) {
                        JOptionPane.showMessageDialog(null, "El Usuario se eliminó correctamente", "Éxito",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El Usuario no se encontró", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    tabla.setModel(CargarTabla());
                    tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
                } catch (SQLException ex) {
                    System.out.println(ex);
                } finally {
                }
            }

            public void mouseEntered(MouseEvent e) {
                buttonEliminar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                buttonEliminar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
            }
        });

        // Modificar
        final JLabel buttonModificar = Elementos.crearJLabel(465, 440, 210, 60, "MODIFICAR", false);
        buttonModificar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
        buttonModificar.setFont(new Font("Roboto Black", 1, 22));
        buttonModificar.setForeground(Elementos.colores(Inicio.Tema));
        buttonModificar.setHorizontalTextPosition(SwingConstants.CENTER);
        buttonModificar.setVerticalTextPosition(SwingConstants.CENTER);
        Panel.add(buttonModificar);
        buttonModificar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Connection conexion = Conexion.getConexion();
                try {
                    String sql = "UPDATE usuarios SET contrasena=?, Nombre=?, Apellido=?, telefono=? WHERE id=?";
                    PreparedStatement consultasStatement = conexion.prepareStatement(sql);
                    consultasStatement.setString(1, contrasenaField.getText());
                    consultasStatement.setString(2, nombreField.getText());
                    consultasStatement.setString(3, apellidoField.getText());
                    consultasStatement.setString(4, telefonofield.getText());
                    consultasStatement.setString(5, id);

                    int filaActualizada = consultasStatement.executeUpdate();

                    if (filaActualizada > 0) {
                        JOptionPane.showMessageDialog(null,
                                "Se ha actualizado los datos del Usuario con la cedula " + cedulaField.getText()
                                        + "\nNota: La cedula y el usuario no se pueden modificar para prevenir conflicto a la hora de ver los registros");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con ID " + id);
                    }
                    conexion.close();
                    tabla.setModel(CargarTabla());
                    tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }

            public void mouseEntered(MouseEvent e) {
                buttonModificar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                buttonModificar.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
            }
        });

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
}