package com.usd89.DatabaseConnection.Localidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public static String EstadosObtener;
    public static boolean Estados = true;
    public Vector<Estados> obtenerEstados(Integer idEstados){
    
        //base de datos Estados
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        Connection cn = ConexionLocalidad.getConexion();
        
        Vector<Estados> datos = new Vector<Estados>();
        Estados datoEstados = null;
        
        if(Estados == true){
        try {

            String sql2 = "SELECT id,estadonombre FROM estado WHERE estadonombre LIKE '%"+EstadosObtener+"%'";
            ps2 = cn.prepareStatement(sql2);
            rs2 = ps2.executeQuery();
            rs2.next();
                    
            datoEstados = new Estados();
            datoEstados.setId(rs2.getInt("id"));
            datoEstados.setNombre(rs2.getString("municipio"));
            datos.add(datoEstados);
            rs2.close();              
        } catch (SQLException ex) {
            System.out.println("Error parte 1: " +ex.toString());
        }
        }
        
            try {
            String sql = "SELECT * FROM estado WHERE ubicacionpaisid = " + idEstados;
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(Estados == false){
            datoEstados = new Estados();
            datoEstados.setId(0);
            datoEstados.setNombre("Seleccionar");
            datos.add(datoEstados);
            }
            
            while (rs.next()) {
                datoEstados = new Estados();
                datoEstados.setId(rs.getInt("id"));
                datoEstados.setNombre(rs.getString("municipio"));
                datos.add(datoEstados);
            }  
            rs.close();    
            
            } catch (Exception e) {
            System.out.println("Error parte 2: " +e.toString());
            }
        
        return datos;
    }
}
