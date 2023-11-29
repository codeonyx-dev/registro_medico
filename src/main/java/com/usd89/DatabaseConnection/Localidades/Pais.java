package com.usd89.DatabaseConnection.Localidades;

import java.sql.*;
import java.util.Vector;

public class Pais {
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return this.nombre;
    }

    public Vector<Pais> mostrarPais() {
        // Obtiene la conexion de la base de datos
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = ConexionLocalidad.getConexion();

        Vector<Pais> datos = new Vector<Pais>();
        Pais datePais = null;

        try {
            String sql = "SELECT * FROM pais ORDEr BY `paisnombre` ASC";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            datePais = new Pais();
            datePais.getId();
            datePais.setNombre("Seleccionar");
            datos.add(datePais);

            while (rs.next()) {
                datePais = new Pais();
                datePais.setId(rs.getInt("id"));
                datePais.setNombre(rs.getString("paisnombre"));
                datos.add(datePais);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return datos;
    }

}
