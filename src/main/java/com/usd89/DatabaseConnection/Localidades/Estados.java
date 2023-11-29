package com.usd89.DatabaseConnection.Localidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Estados {

    static String idPais;
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

    public Vector<Estados> mostrarEstados(Integer idPais) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = ConexionLocalidad.getConexion();

        Vector<Estados> datos = new Vector<Estados>();
        Estados datoEstados = null;

        try {
            String sql = "SELECT * FROM estado WHERE ubicacionpaisid = " + idPais + " ORDER BY estado.estadonombre ASC";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            datoEstados = new Estados();
            datoEstados.setId(0);
            datoEstados.setNombre("Seleccionar");
            datos.add(datoEstados);

            while (rs.next()) {
                datoEstados = new Estados();
                datoEstados.setId(rs.getInt("id"));
                datoEstados.setNombre(rs.getString("estadonombre"));
                datos.add(datoEstados);
            }
            rs.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return datos;
    }

    public Vector<Estados> obtenerEstados(String NombrePais) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = ConexionLocalidad.getConexion();

        Vector<Estados> datos = new Vector<Estados>();
        Estados datoEstados = null;

        if (NombrePais != null) {
            try {
                String sql = "SELECT * FROM `estado` WHERE ubicacionpaisid = (SELECT id FROM pais WHERE paisnombre = '"+NombrePais+"')";
                ps = cn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    if (NombrePais.equals(NombrePais)) {
                        datoEstados = new Estados();
                        datoEstados.setId(rs.getInt("id"));
                        datoEstados.setNombre(rs.getString("estadonombre"));
                        datos.add(datoEstados);
                    }
                }

                while (rs.next()) {
                    datoEstados = new Estados();
                    datoEstados.setId(rs.getInt("id"));
                    datoEstados.setNombre(rs.getString("estadonombre"));
                    datos.add(datoEstados);
                }
                rs.close();

            } catch (Exception e) {
                System.out.println("Error parte 2: " + e.toString());
            }

        } else {
            try {
                String sql = "SELECT * FROM `estado` WHERE ubicacionpaisid = (SELECT id FROM pais WHERE paisnombre = '"
                        + NombrePais + "')";
                ps = cn.prepareStatement(sql);
                rs = ps.executeQuery();

                datoEstados = new Estados();
                datoEstados.setId(0);
                datoEstados.setNombre("Seleccionar");
                datos.add(datoEstados);

                while (rs.next()) {
                    datoEstados = new Estados();
                    datoEstados.setId(rs.getInt("id"));
                    datoEstados.setNombre(rs.getString("estadonombre"));
                    datos.add(datoEstados);
                }
                rs.close();

            } catch (Exception e) {
                System.out.println("Error parte 2: " + e.toString());
            }
        }

        return datos;
    }
}
