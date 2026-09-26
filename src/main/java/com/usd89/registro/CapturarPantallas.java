package com.usd89.registro;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.usd89.DatabaseConnection.Conexion;

/**
 * Genera capturas reales de las ventanas para docs/images.
 * Uso: java -cp target/registro_medico-1.0-SNAPSHOT.jar com.usd89.registro.CapturarPantallas [carpeta]
 */
public class CapturarPantallas {

  public static void main(String[] args) throws Exception {
    final String outDir = args.length > 0 ? args[0] : "docs/images";
    new File(outDir).mkdirs();
    seedSampleData();

    Inicio.Tema = "Oscuro";
    Inicio.nivel_acceso = "administrador";
    Inicio.UsuarioNombre = "admin";

    SwingUtilities.invokeAndWait(() -> {
      try {
        capture(new Inicio(), outDir + "/login.png");
        capture(new Menu(), outDir + "/menu.png");
        capture(new Buscador(), outDir + "/buscador.png");
        capture(new GestionUsuarios(), outDir + "/usuarios.png");
        capture(new NHM(), outDir + "/historia-1.png");
        capture(new Grafica(), outDir + "/estadistica.png");
        // Reusar historia-1 también como 2/3 si no hay pantallas separadas
        File h1 = new File(outDir + "/historia-1.png");
        if (h1.exists()) {
          ImageIO.write(ImageIO.read(h1), "png", new File(outDir + "/historia-2.png"));
          ImageIO.write(ImageIO.read(h1), "png", new File(outDir + "/historia-3.png"));
        }
        System.out.println("Capturas guardadas en " + outDir);
      } catch (Exception e) {
        e.printStackTrace();
        System.exit(1);
      }
    });
    System.exit(0);
  }

  private static void seedSampleData() {
    Connection c = Conexion.getConexion();
    if (c == null) {
      System.err.println("Sin conexión MySQL; capturas sin datos de ejemplo.");
      return;
    }
    try {
      Statement st = c.createStatement();
      st.executeUpdate("DELETE FROM datospersonales WHERE Numero_de_Historia IN ('HM-001','HM-002')");
      st.executeUpdate(
          "INSERT INTO datospersonales (Numero_de_Historia, nombre, apellido, Ci_cedula, Estado, sexo, FechaRegistro, RegistradoPor) "
              + "VALUES ('HM-001', 'Ana', 'Perez', 'V12345678', 'Zulia', 'F', CURDATE(), 'admin'), "
              + "('HM-002', 'Luis', 'Garcia', 'V87654321', 'Zulia', 'M', CURDATE(), 'admin')");
      st.executeUpdate("DELETE FROM estadistica_pacientes WHERE fecha = CURDATE()");
      st.executeUpdate(
          "INSERT INTO estadistica_pacientes (fecha, cantidad_pacientes) VALUES (CURDATE(), 2), (DATE_SUB(CURDATE(), INTERVAL 1 DAY), 5)");
      c.close();
    } catch (Exception e) {
      System.err.println("Aviso seed: " + e.getMessage());
    }
  }

  private static void capture(JFrame frame, String path) throws Exception {
    frame.setLocationRelativeTo(null);
    frame.setAlwaysOnTop(true);
    frame.setVisible(true);
    frame.toFront();
    frame.repaint();
    Thread.sleep(700);

    Rectangle bounds = frame.getBounds();
    // Preferir paintAll (incluye hijos); si falla visualmente, Robot de respaldo
    BufferedImage img = new BufferedImage(Math.max(bounds.width, 1), Math.max(bounds.height, 1),
        BufferedImage.TYPE_INT_RGB);
    Graphics2D g = img.createGraphics();
    frame.paintAll(g);
    g.dispose();

    // Si sale casi negro, usar Robot
    if (isMostlyDark(img)) {
      Robot robot = new Robot();
      robot.setAutoDelay(50);
      Thread.sleep(300);
      img = robot.createScreenCapture(bounds);
    }

    ImageIO.write(img, "png", new File(path));
    System.out.println("OK " + path + " (" + bounds.width + "x" + bounds.height + ")");
    frame.setVisible(false);
    frame.dispose();
    Thread.sleep(200);
  }

  private static boolean isMostlyDark(BufferedImage img) {
    int samples = 0;
    int dark = 0;
    for (int y = 0; y < img.getHeight(); y += 20) {
      for (int x = 0; x < img.getWidth(); x += 20) {
        int rgb = img.getRGB(x, y);
        int r = (rgb >> 16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = rgb & 0xff;
        samples++;
        if (r + g + b < 40) dark++;
      }
    }
    return samples > 0 && (dark * 1.0 / samples) > 0.85;
  }
}
