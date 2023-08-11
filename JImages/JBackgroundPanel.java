package JImages;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JBackgroundPanel extends JPanel {
    private BufferedImage imagenDeFondo;

    public JBackgroundPanel(String imagePath) {
        try {
            // Carga la imagen de fondo desde un archivo
            imagenDeFondo = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen de fondo en el panel
        if (imagenDeFondo != null) {
            g.drawImage(imagenDeFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}