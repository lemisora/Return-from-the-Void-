package JImages;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JBackgroundPanel extends JPanel {
    private BufferedImage visible;

    public JBackgroundPanel(String path) {
        try {
            this.visible = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen de fondo en el panel
        if (visible != null) {
            g.drawImage(visible, 0, 0, getWidth(), getHeight(), this);
        }
    }
}