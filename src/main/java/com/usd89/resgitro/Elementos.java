package com.usd89.resgitro;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Elementos {
    public static String Tema = "Oscuro";
    
//Crear Crear textfield
    public static JTextField crearJTextField(int x, int y, int ancho, int altura,
        int tamanoLetra, String tipoLetra, String texto, boolean Bordes) {

        JTextField textField = new JTextField();
        textField.setBounds(x, y, ancho, altura);
        textField.setFont(new Font(tipoLetra, 1, tamanoLetra));
        textField.setText(texto);
        if (Bordes == true) {
            textField.setBorder(BorderFactory.createLineBorder(new Color(73, 176, 213)));
        }
        return textField;
    }
//Crear label
    public static JLabel crearJLabel(int x, int y, int ancho, int altura, String texto, boolean Bordes) {

        JLabel JLabel = new JLabel();
        JLabel.setBounds(x, y, ancho, altura);
        JLabel.setText(texto);
        if (Bordes == true) {
            JLabel.setBorder(BorderFactory.createLineBorder(new Color(73, 176, 213)));
        }
        return JLabel;
    }
//Crear boton
    public static JButton crearJButton(int x, int y, int ancho, int altura, String texto) {
        JButton JButton = new JButton();
        JButton.setBounds(x, y, ancho, altura);
        JButton.setText(texto);
        return JButton;
    }
//Boton para cerrar
    public static JLabel Cerrar(int x, int y, int ancho, int altura) {
        JLabel JLabel = new JLabel();
        JLabel.setFont(new Font("Roboto", 1, 18));
        JLabel.setBounds(x, y, ancho, altura);
        JLabel.setForeground(Color.white);
        JLabel.setText("X");
        return JLabel;
    }
//Boton para minimizar
    public static JLabel Minimizar(int x, int y, int ancho, int altura) {

        JLabel JLabel = new JLabel();
        JLabel.setFont(new Font("Roboto", 0, 20));
        JLabel.setBounds(x, y, ancho, altura);
        JLabel.setForeground(Color.white);
        JLabel.setText("▬");
        return JLabel;
    }

static ImageIcon fondo = new ImageIcon("/imagen/Fondos/"+Tema+"/fondo-Inicio.png");  

//Imagenes de botones Oscuros
static ImageIcon bt_gigante_off = new ImageIcon("/imagen/Fondos/"+Tema+"/Botones/bt_gigante_off.png");
static ImageIcon bt_gigante_on = new ImageIcon("/imagen/Fondos/"+Tema+"/Botones/bt_gigante_on.png");

static ImageIcon bt_grande_off = new ImageIcon("/imagen/Fondos/"+Tema+"/Botones/bt_grande_off.png");
static ImageIcon bt_grande_on = new ImageIcon("/imagen/Fondos/"+Tema+"/Botones/bt_grande_on.png");

static ImageIcon bt_mediano_off = new ImageIcon("/imagen/Fondos/"+Tema+"/Botones/bt_mediano_off.png");
static ImageIcon bt_mediano_on = new ImageIcon("/imagen/Fondos/"+Tema+"/Botones/bt_mediano_on.png");

static ImageIcon bt_pequeno_off = new ImageIcon("/imagen/Fondos/"+Tema+"/Botones/bt_pequeno_off.png");
static ImageIcon bt_pequeno_on = new ImageIcon("/imagen/Fondos/"+Tema+"/Botones/bt_pequeno_on.png");

}
