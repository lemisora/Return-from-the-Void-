package JImages;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JBackgroundPanel extends JPanel {
    private BufferedImage visible;

    public JBackgroundPanel() {
        try {
            this.visible = ImageIO.read(new File("Resource/Images/7.png"));
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


   
    public void addMainComponents(int WIDTH, int HEIGHT, JFrame frame){

        this.setSize(WIDTH, HEIGHT);
        this.setLayout(null);
        //Buttons
        JButton starLv1 = new JButton();
        JButton starLv2 = new JButton();
        JButton starLv3 = new JButton();

        starLv1.setOpaque(true);
        starLv1.setContentAreaFilled(false);
        starLv1.setBorderPainted(false);

        starLv2.setOpaque(true);
        starLv2.setContentAreaFilled(false);
        starLv2.setBorderPainted(false);

        starLv3.setOpaque(true);
        starLv3.setContentAreaFilled(false);
        starLv3.setBorderPainted(false);
        
        starLv1.setBounds(313, 190, 361, 65);
        starLv2.setBounds(313, 285, 361, 65);
        starLv3.setBounds(313, 385, 361, 65);
    
        this.add(starLv1);
        this.add(starLv2);
        this.add(starLv3);
        
    }
}