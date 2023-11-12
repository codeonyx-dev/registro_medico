package com.usd89.registro;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.usd89.DatabaseConnection.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Buscador extends JFrame {
    JTable lista = new JTable();
    JTextField BuscadorText = new JTextField();
    JComboBox<String> BuscarPor = new JComboBox<String>(
            new String[] { "Nombre", "N° de historia medica", "Cédula del paciente", "Estado" });
    static String ID;

    public void buscar() {
        String campo = BuscadorText.getText();
        String where = "";
        String buscarPor = BuscarPor.getSelectedItem().toString().toUpperCase();

        if (buscarPor.equalsIgnoreCase("NOMBRE")) {
            buscarPor = "nombre";
        } else if (buscarPor.equalsIgnoreCase("N° de historia medica")) {
            buscarPor = "Numero_de_Historia";
        } else if (buscarPor.equalsIgnoreCase("Cédula del paciente")) {
            buscarPor = "Ci_cedula";
        } else if (buscarPor.equalsIgnoreCase("ESTADO")) {
            buscarPor = "Estado";
        }

        if (!"".equals(campo)) {
            where = "WHERE " + buscarPor + " LIKE '" + campo + "%'";
        }

        try {
            DefaultTableModel modelo = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int filas, int columnas) {

                    if (columnas == 7) {
                        return true;
                    } else {
                        return false;
                    }
                }

            };

            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conexion = Conexion.getConexion();
            String sql = "";
            if (BuscadorText.getText().equalsIgnoreCase("Buscar...")) {
                sql = " SELECT Numero_de_Historia, nombre, apellido, sexo, Estado,Telefono,Ci_cedula FROM datospersonales ";
            } else {
                sql = " SELECT Numero_de_Historia, nombre, apellido, sexo, Estado,Telefono,Ci_cedula FROM datospersonales "
                        + where;
            }

            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("N° de Historia");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("APELLIDO");
            modelo.addColumn("SEXO");
            modelo.addColumn("ESTADO");
            modelo.addColumn("TELEFONO");
            modelo.addColumn("Cedula del paciente");
            lista.setModel(modelo);

            int[] anchos = { 100, 100, 100, 20, 50, 50, 100 };
            for (int i = 0; i < modelo.getColumnCount(); i++) {
                lista.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);

            }
            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (Exception ex) {
            System.err.println(ex.toString());
        }
    }

    public Buscador() {
        setTitle("Buscar Expediente Médico");
        setSize(1120, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 20));
        setLocationRelativeTo(null);
        setVisible(true);
        buscar();

        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBounds(0, 0, 1120, 720);
        Panel.setBackground(Color.black);
        add(Panel);

        lista.setFont(new Font("Arial", Font.PLAIN, 12));
        lista.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

        // Cambia el tamaño de fuente para los encabezados de las columnas (primera
        // fila)
        JTableHeader header = lista.getTableHeader();
        Font headerFont = new Font("Arial", Font.BOLD, 16);
        header.setFont(headerFont);

        JScrollPane scrollerPanel = new JScrollPane(lista);
        scrollerPanel.setBounds(40, 130, 1046, 500);
        Panel.add(scrollerPanel);

        BuscarPor.setBounds(40, 55, 250, 35);
        BuscarPor.setFont(new Font("Arial", Font.BOLD, 16));
        Panel.add(BuscarPor);

        BuscadorText = Elementos.crearJTextField(330, 55, 540, 35, "Buscar...", true);
        BuscadorText.setFont(new Font("Arial", 1, 20));
        BuscadorText.setForeground(Color.GRAY);
        Panel.add(BuscadorText);
        BuscadorText.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (BuscadorText.getText().equals("Buscar...")) {
                    BuscadorText.setText("");
                }
            }

            public void mouseExited(MouseEvent e) {
                if (BuscadorText.getText().isEmpty()) {
                    BuscadorText.setText("Buscar...");
                }
            }
        });

        // Cerrar ventana
        final JLabel Cerrar = Elementos.cerrar(1090, 10, 20, 20);
        Panel.add(Cerrar);
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

        // Botones

        // Botón volver
        final JLabel volverButton = new JLabel("VOLVER AL INICIO", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                SwingConstants.CENTER);
        volverButton.setBounds(120, 640, 250, 67);
        volverButton.setFont(new Font("Roboto Black", 1, 22));
        volverButton.setForeground(Elementos.colores(Inicio.Tema));
        volverButton.setVerticalTextPosition(SwingConstants.CENTER);
        volverButton.setHorizontalTextPosition(SwingConstants.CENTER);
        Panel.add(volverButton);

        volverButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Menu Menu = new Menu();
                Menu.setVisible(true);
                dispose();
            }

            public void mouseEntered(MouseEvent e) {
                volverButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                volverButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
            }
        });
        final JLabel EliminarButton;
        // Botón Eliminar Registro
        if (!(Inicio.nivel_acceso.equals("administrador"))) {
            EliminarButton = new JLabel("ELIMINAR REGISTRO", Elementos.botonImagen(Inicio.Tema, "mediano_black.0"),
                    SwingConstants.CENTER);
            EliminarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "mediano_black.0"));
        } else {
            EliminarButton = new JLabel("ELIMINAR REGISTRO", Elementos.botonImagen(Inicio.Tema, "mediano.0"),
                    SwingConstants.CENTER);
        }

        EliminarButton.setBounds(375, 640, 320, 67);
        EliminarButton.setFont(new Font("Roboto Black", 1, 22));
        EliminarButton.setForeground(Elementos.colores(Inicio.Tema));
        EliminarButton.setVerticalTextPosition(SwingConstants.CENTER);
        EliminarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        Panel.add(EliminarButton);
        EliminarButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (Inicio.nivel_acceso.equals("administrador")) {
                    int seleccionar = lista.getSelectedRow();
                    if (seleccionar >= 0) {
                        int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas eliminar este dato?",
                                "Confirmación de Eliminación", JOptionPane.YES_NO_OPTION);
                        if (opcion == JOptionPane.YES_OPTION) {
                            // Realiza la acción de eliminación aquí
                            String ID = String.valueOf(lista.getValueAt(seleccionar, 0));
                            try {
                                Connection cn = Conexion.getConexion();
                                PreparedStatement pst1 = cn
                                        .prepareStatement("delete from datospersonales where Numero_de_Historia = ?");
                                pst1.setString(1, ID);
                                pst1.executeUpdate();
                                buscar();

                            } catch (Exception ex) {
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No ha seleccionado ningún registro");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No tiene el permiso para eliminar datos", "Error",
                            JOptionPane.ERROR_MESSAGE, null);
                }
            }

            public void mouseEntered(MouseEvent e) {
                if (!(Inicio.nivel_acceso.equals("administrador"))) {
                    EliminarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "mediano_black.1"));
                } else {
                    EliminarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "mediano.1"));
                }
            }

            public void mouseExited(MouseEvent e) {
                if (!(Inicio.nivel_acceso.equals("administrador"))) {
                    EliminarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "mediano_black.0"));
                } else {
                    EliminarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "mediano.0"));
                }
            }
        });

        // Botón Actualizar Registro
        final JLabel ActualizarButton;
        if (!(Inicio.nivel_acceso.equals("administrador") || Inicio.nivel_acceso.equals("modificacion"))) {
            ActualizarButton = new JLabel("ACTUALIZAR DATOS", Elementos.botonImagen(Inicio.Tema, "pequeno_black.0"),
                    SwingConstants.CENTER);
        } else {
            ActualizarButton = new JLabel("ACTUALIZAR DATOS", Elementos.botonImagen(Inicio.Tema, "pequeno.0"),
                    SwingConstants.CENTER);
        }

        ActualizarButton.setBounds(700, 640, 250, 67);
        ActualizarButton.setFont(new Font("Roboto Black", 1, 22));
        ActualizarButton.setForeground(Elementos.colores(Inicio.Tema));
        ActualizarButton.setVerticalTextPosition(SwingConstants.CENTER);
        ActualizarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        Panel.add(ActualizarButton);
        ActualizarButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (Inicio.nivel_acceso.equals("administrador") || Inicio.nivel_acceso.equals("modificacion")) {
                    int seleccionar = lista.getSelectedRow();
                    System.out.println(seleccionar);
                    if (seleccionar >= 0) {
                        ID = String.valueOf(lista.getValueAt(seleccionar, 0));
                        new NHM_Actualizar().setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No ha seleccionado ningún registro");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No tiene el permiso para Actualizar datos", "Error",
                            JOptionPane.ERROR_MESSAGE, null);
                }

            }

            public void mouseEntered(MouseEvent e) {
                if (!(Inicio.nivel_acceso.equals("administrador") || Inicio.nivel_acceso.equals("modificacion"))) {
                    ActualizarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno_black.1"));
                } else {
                    ActualizarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.1"));
                }
            }

            public void mouseExited(MouseEvent e) {
                if (Inicio.nivel_acceso.equals("administrador") || Inicio.nivel_acceso.equals("modificacion")) {
                    ActualizarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno.0"));
                } else {
                    ActualizarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "pequeno_black.0"));
                }
            }
        });

        // Botón Buscar Registro
        final JLabel BuscarButton = new JLabel("BUSCAR", Elementos.botonImagen(Inicio.Tema, "muypequeno.0"),
                SwingConstants.CENTER);
        BuscarButton.setBounds(850, 40, 250, 67);
        BuscarButton.setFont(new Font("Roboto Black", 1, 22));
        BuscarButton.setForeground(Elementos.colores(Inicio.Tema));
        BuscarButton.setVerticalTextPosition(SwingConstants.CENTER);
        BuscarButton.setHorizontalTextPosition(SwingConstants.CENTER);
        Panel.add(BuscarButton);
        BuscarButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                buscar();
            }

            public void mouseEntered(MouseEvent e) {
                BuscarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.1"));
            }

            public void mouseExited(MouseEvent e) {
                BuscarButton.setIcon(Elementos.botonImagen(Inicio.Tema, "muypequeno.0"));
            }
        });

        JLabel Fondo = new JLabel();
        Fondo.setBounds(0, 0, 1120, 720);
        Panel.add(Fondo);
        if (Inicio.Tema == "Oscuro") {
            Fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Oscuro/Buscador.png")));
        } else {
            Fondo.setIcon(new ImageIcon(getClass().getResource("/imagen/Fondos/Claro/Buscador.png")));
        }
    }
}
