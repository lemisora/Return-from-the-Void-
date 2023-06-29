package Interfaz;
import java.awt.*;
import javax.swing.*;

public class ImagenInicio extends JPanel{
  @Override
  public void paint(Graphics g){
    Dimension dimensiones = this.getSize();
    ImageIcon imagen = new ImageIcon(getClass().getResource("/Resources/Planeta.jpg"));
    g.drawImage(imagen.getImage(),0,0,dimensiones.width,dimensiones.height,null);
    setOpaque(false);
    super.paintChildren(g);
  }
}
