package com.usd89.DatabaseConnection.Localidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            String sql = "SELECT * FROM municipios WHERE estado_id = " + idEstado + " ORDER BY municipios.estado_id ASC";
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

    public static String MunicipiosObtener;
    public static boolean Municipios = true;

    public Vector<Municipio> obtenerMunicipios(Integer idEstados){
    
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        Connection cn = ConexionLocalidad.getConexion();
        
        Vector<Municipio> datos = new Vector<Municipio>();
        Municipio datoMunicipios = null;
        
        if(Municipios == true){
        try {

            String sql2 = "SELECT id,municipio FROM municipios WHERE municipio LIKE '%"+ MunicipiosObtener +"%'";
            ps2 = cn.prepareStatement(sql2);
            rs2 = ps2.executeQuery();
            rs2.next();
                    
            datoMunicipios = new Municipio();
            datoMunicipios.setId(rs2.getInt("id"));
            datoMunicipios.setNombre(rs2.getString("municipio"));
            datos.add(datoMunicipios);
            rs2.close();              
        } catch (SQLException ex) {
            System.out.println("Error parte 1: " +ex.toString());
        }
        }
        
            try {
            String sql = "SELECT * FROM municipios WHERE estado_id = " + idEstado;
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(Municipios == false){
            datoMunicipios = new Municipio();
            datoMunicipios.setId(0);
            datoMunicipios.setNombre("Seleccionar");
            datos.add(datoMunicipios);
            }
            
            while (rs.next()) {
                datoMunicipios = new Municipio();
                datoMunicipios.setId(rs.getInt("id"));
                datoMunicipios.setNombre(rs.getString("municipio"));
                datos.add(datoMunicipios);
            }  
            rs.close();    
            
            } catch (Exception e) {
            System.out.println("Error parte 2: " +e.toString());
            }
        
        return datos;
    }
}

