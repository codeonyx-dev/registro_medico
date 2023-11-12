package com.usd89.registro;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Elementos {
    

    // Crear Crear textfield
    public static JTextField crearJTextField(int x, int y, int ancho, int altura, String texto, boolean Bordes) {

        JTextField textField = new JTextField();
        textField.setBounds(x, y, ancho, altura);
        textField.setFont(new Font("Roboto", 1, 15));
        textField.setText(texto);
        if (Bordes == true) {
            textField.setBorder(BorderFactory.createLineBorder(new Color(73, 176, 213)));
        }
        return textField;
    }

    // Crear label
    public static JLabel crearJLabel(int x, int y, int ancho, int altura, String texto, boolean Bordes) {

        JLabel JLabel = new JLabel();
        JLabel.setBounds(x, y, ancho, altura);
        JLabel.setFont(new Font("Roboto", 1, 15));
        JLabel.setText(texto);
        if (Bordes == true) {
            JLabel.setBorder(BorderFactory.createLineBorder(new Color(73, 176, 213)));
        }
        return JLabel;
    }

    // Crear botón
    public static JButton crearJButton(int x, int y, int ancho, int altura, String texto) {
        JButton JButton = new JButton();
        JButton.setBounds(x, y, ancho, altura);
        JButton.setText(texto);
        return JButton;
    }

    // Botón para cerrar
    public static JLabel cerrar(int x, int y, int ancho, int altura) {
        JLabel JLabel = new JLabel();
        JLabel.setFont(new Font("Roboto", 1, 18));
        JLabel.setBounds(x, y, ancho, altura);
        JLabel.setForeground(Color.white);
        JLabel.setText("X");
        return JLabel;
    }

    // Botón para minimizar
    public static JLabel minimizar(int x, int y, int ancho, int altura) {

        JLabel JLabel = new JLabel();
        JLabel.setFont(new Font("Roboto", 0, 20));
        JLabel.setBounds(x, y, ancho, altura);
        JLabel.setForeground(Color.white);
        JLabel.setText("▬");
        return JLabel;
        
    }
    
    public static ImageIcon Tema(String Tema){
        ImageIcon fondo = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + Tema + "/fondo-Inicio.png"));
        return fondo;
    }
    //Imágenes de botones 
    public static ImageIcon botonImagen(String tema,String modelo){
        ImageIcon boton = new ImageIcon();
        switch (modelo) {
            case "gigante.0":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_gigante_off.png"));
                break;
            case "gigante.1":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_gigante_on.png"));
                break;  
            case "grande.0":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_grande_off.png"));
                break;
            case "grande.1":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_grande_on.png"));
                break;      
            case "mediano.0":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_mediano_off.png"));
                break;
            case "mediano.1":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_mediano_on.png"));
                break;

            case "mediano_black.0":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_mediano_off_black.png"));
                break;
            case "mediano_black.1":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_mediano_on_black.png"));
                break;
            
            case "pequeno.0":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_pequeno_off.png"));
                break;

            case "pequeno_black.0":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_pequeno_off_black.png"));  
                break; 

            case "pequeno_black.1":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_pequeno_on_black.png"));  
                break;      

            case "pequeno.1":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_pequeno_on.png"));
                break;           
            case "muypequeno.0":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_muypequeno_off.png"));
                break;           
            case "muypequeno.1":
                boton = new ImageIcon(Elementos.class.getResource("/imagen/Fondos/" + tema + "/Botones/bt_muypequeno_on.png"));  
                break;           
                
            default:
                break;
        }
        
        return boton;
    }
    //Colores de letras
    public static Color colores(String tema){
        Color color = new Color(0,0,0);

        if (tema=="Oscuro") {
            color = new Color(0, 51, 51);
        } else {
            color = new Color(255,255,255);
        }

        return color;
    }

}