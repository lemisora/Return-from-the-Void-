import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;    // Se importa JFrame de Swing para la creación de una ventana de forma sencilla que será dibujada en pantalla por el compositor/servidor del sistema operativo en el que se ejecute este programa
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import JImages.JBackgroundPanel;
import Interfaz.RoundedBorder;

import java.awt.*;            //Se importa la librería de awt para manejar componentes de la ventana que se creará

public class StartWindow extends JFrame{
  private static final int HEIGHT = 600;
  private static final int WIDTH = 1000;
  private static final  Color grey = new Color(140,40,40);
  
  public StartWindow(){ //Constructor de la ventana
    this.setTitle("Return from the Void");       //Este es el título que tendrá la ventana
    this.setSize(WIDTH,HEIGHT);                  //Se define el tamaño inicial de la ventana
    this.setResizable(false);                  //La ventana inicia maximizada y en primer plano
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Al apretar la 'X' en la ventana esta terminará todos los procesos relacionados directamente con este programa
    //JPanel
    JBackgroundPanel mainPanel = new JBackgroundPanel("Resource/Images/7.png");
    mainPanel.setSize(WIDTH,HEIGHT);

    mainPanel.setLayout(null);
    
    //Buffer de imagenes;
    BufferedImage [] bufImage = new BufferedImage[6];
    for(int i=0; i<6; i++){
      try {
        bufImage[i] = ImageIO.read(new File("Resource/Images/"+ (i+1)+ ".png"));
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

    //Buttons
    JButton starLv1 = new JButton();
    JButton starLv2 = new JButton();
    JButton starLv3 = new JButton();
    JButton scoreB = new JButton("S");
    JButton creditsB = new JButton("!");
    JButton exiButton = new JButton("X");

    starLv1.setOpaque(false);
    starLv1.setContentAreaFilled(false);
    starLv1.setBorderPainted(false);
    starLv1.addActionListener(e -> cambiarImagenDeFondo(mainPanel, bufImage[0]));

    starLv2.setOpaque(false);
    starLv2.setContentAreaFilled(false);
    starLv2.setBorderPainted(false);
    starLv2.addActionListener(e -> cambiarImagenDeFondo(mainPanel, bufImage[1]));

    starLv3.setOpaque(false);
    starLv3.setContentAreaFilled(false);
    starLv3.setBorderPainted(false);
    starLv3.addActionListener(e -> cambiarImagenDeFondo(mainPanel, bufImage[2]));
    
    starLv1.setBounds(313, 190, 361, 65);
    starLv2.setBounds(313, 285, 361, 65);
    starLv3.setBounds(313, 385, 361, 65);
   
 
    mainPanel.add(starLv1);
    mainPanel.add(starLv2);
    mainPanel.add(starLv3);
    mainPanel.add(scoreB);
    mainPanel.add(creditsB);
    mainPanel.add(exiButton);


    this.add(mainPanel);

    this.setVisible(true);
  }

  

  private void cambiarImagenDeFondo(JBackgroundPanel panelConImagen, BufferedImage image) {
      panelConImagen.setImagen(image);
      panelConImagen.repaint();
  }

  public static void main(String[] args) {
    StartWindow ventanaInicial = new StartWindow(); //Se crea la ventana con las condiciones y propiedades indicadas anteriormente  
  }
}
