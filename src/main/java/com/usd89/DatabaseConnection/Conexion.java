package com.usd89.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
    public static Connection getConexion() {
        Connection conexion = null;
        try {
            String url = "jdbc:mysql://localhost:3306/historia_clinica_integral";
            String usuario = "root";
            String contrasena = "";

            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(); // Imprime la excepción en la consola
            JOptionPane.showMessageDialog(null, "Se ha producido un error:\nCódigo de error: " + ex.getMessage(),
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
}
