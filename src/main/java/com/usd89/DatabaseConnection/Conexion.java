package com.usd89.DatabaseConnection;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class Conexion {
    public static Connection getConexion() {
        Connection conexion = null;
        try {
            String url = "jdbc:mysql://localhost:3306/historia_clinica_integral";
            String usuario = "root";
            String contrasena = "";
            conexion = (Connection) DriverManager.getConnection(url, usuario, contrasena);
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Se a producido un error \n"+"Codigo de error: "+ex.getMessage(), "ERROR",JOptionPane.ERROR_MESSAGE, null);
        }
        return conexion;
    }

    public static void close() {
    }
}
