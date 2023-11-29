package com.usd89.DatabaseConnection.Localidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Municipio {

    static String idEstado;
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
    
    public Vector<Municipio> mostrarMunicipios(Integer idEstado) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conexion = ConexionLocalidad.getConexion();
        Vector<Municipio> datos = new Vector<Municipio>();
        Municipio datoMunicipios = null;

        try {
            String sql = "SELECT * FROM municipios WHERE estado_id = " + idEstado
                    + " ORDER BY municipios.estado_id ASC";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            datoMunicipios = new Municipio();
            datoMunicipios.setId(0);
            datoMunicipios.setNombre("Seleccionar");
            datos.add(datoMunicipios);

            while (rs.next()) {
                datoMunicipios = new Municipio();
                datoMunicipios.setId(rs.getInt("id"));
                datoMunicipios.setNombre(rs.getString("municipio"));
                datos.add(datoMunicipios);
            }
            rs.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return datos;
    }

    public Vector<Municipio> obtenerMunicipios(String NombreEstado) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cn = ConexionLocalidad.getConexion();
        Vector<Municipio> datos = new Vector<Municipio>();
        Municipio datoMunicipios = null;

        if (NombreEstado != null) {
            try {
                String sql = "SELECT * FROM `municipios` WHERE estado_id IN (SELECT id FROM estado WHERE estadonombre ='"+ NombreEstado+"')";
                ps = cn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    if (NombreEstado.equals(NombreEstado)) {
                        datoMunicipios = new Municipio();
                        datoMunicipios.setId(rs.getInt("id"));
                        datoMunicipios.setNombre(rs.getString("municipio"));
                        datos.add(datoMunicipios);
                    }
                }

                while (rs.next()) {
                    datoMunicipios = new Municipio();
                    datoMunicipios.setId(rs.getInt("id"));
                    datoMunicipios.setNombre(rs.getString("municipio"));
                    datos.add(datoMunicipios);
                }
                rs.close();

            } catch (Exception e) {
                System.out.println("Error parte 2: " + e.toString());
            }

        } else {
            try {
                String sql = "SELECT * FROM municipios WHERE estado_id = (SELECT id FROM estado WHERE estadonombre ='"
                        + NombreEstado + "')";
                ps = cn.prepareStatement(sql);
                rs = ps.executeQuery();

                datoMunicipios = new Municipio();
                datoMunicipios.setId(0);
                datoMunicipios.setNombre("Seleccionar");
                datos.add(datoMunicipios);

                while (rs.next()) {
                    datoMunicipios = new Municipio();
                    datoMunicipios.setId(rs.getInt("id"));
                    datoMunicipios.setNombre(rs.getString("municipio"));
                    datos.add(datoMunicipios);
                }
                rs.close();

            } catch (Exception e) {
                System.out.println("Error parte 2: " + e.toString());
            }
        }
        return datos;
    }
}
