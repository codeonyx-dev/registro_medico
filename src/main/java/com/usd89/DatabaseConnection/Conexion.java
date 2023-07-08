package com.usd89.DatabaseConnection;


import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class Conexion {
    public static Connection getConexion() {
        Connection conexion = null;
        try {
            String url = "jdbc:mysql://localhost:3306/historia_clinica_integral";
            String usuario = "root";
            String contrasena = "";
            conexion = (Connection) DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa");

        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos: " + ex.getMessage());
        }
        return conexion;
    }
}
