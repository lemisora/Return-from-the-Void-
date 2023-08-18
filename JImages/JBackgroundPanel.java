package JImages;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JBackgroundPanel extends JPanel {
    private BufferedImage visible;
    private BufferedImage[] bufImage;

    public JBackgroundPanel() {
        this.bufImage = new BufferedImage[6];
        for(int i=0; i<6; i++){
            try {
                this.bufImage[i] = ImageIO.read(new File("Resource/Images/"+ (i+1)+ ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.visible = this.bufImage[5];
    }

    public void setImagen(int index) {
        this.visible = bufImage[index];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen de fondo en el panel
        if (visible != null) {
            g.drawImage(visible, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void changeBackground(int index) {
        System.out.print("hola");
        this.setImagen(index);
        this.repaint();
    }

    public void changeWindow(JFrame frame, int index){
        this.changeBackground(index);
        frame.getContentPane().removeAll();
        frame.repaint();
    }

    public void addMainComponents(int WIDTH, int HEIGHT, JFrame frame){

        this.setSize(WIDTH, HEIGHT);
        this.setLayout(null);
        //Buttons
        JButton starLv1 = new JButton();
        JButton starLv2 = new JButton();
        JButton starLv3 = new JButton();
        JButton scoreB = new JButton("S");
        JButton creditsB = new JButton("!");
        JButton exiButton = new JButton("X");

        starLv1.setOpaque(true);
        starLv1.setContentAreaFilled(false);
        starLv1.setBorderPainted(false);
        starLv1.addActionListener(e -> this.changeWindow(frame, 0));

        starLv2.setOpaque(true);
        starLv2.setContentAreaFilled(false);
        starLv2.setBorderPainted(false);
        starLv2.addActionListener(e -> this.changeBackground(1));

        starLv3.setOpaque(true);
        starLv3.setContentAreaFilled(false);
        starLv3.setBorderPainted(false);
        starLv3.addActionListener(e -> this.changeBackground(2));
        
        starLv1.setBounds(313, 190, 361, 65);
        starLv2.setBounds(313, 285, 361, 65);
        starLv3.setBounds(313, 385, 361, 65);
    
        this.add(starLv1);
        this.add(starLv2);
        this.add(starLv3);
        
    }
}