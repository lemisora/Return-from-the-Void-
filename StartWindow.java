import Interfaz.ImagenInicio;
import javax.swing.*;    // Se importa JFrame de Swing para la creacion de una ventana de forma sencilla que sera dibujada en pantalla por el compositor/servidor del sistema operativo en el que se ejecute este programa
import java.awt.*;            //Se importa la libreria de awt para manejar componentes de la ventana que se creara

public class StartWindow extends JFrame{
  ImagenInicio imagen = new ImagenInicio();
  private static final int HEIGHT = 600;
  private static final int WIDTH = 1000;
  
  public StartWindow(){ //Constructor de la ventana
    this.setTitle("Return from the Void");       //Este es el titulo que tendra la ventana
    this.setSize(WIDTH,HEIGHT);                  //Se define el tamanio inicial de la ventana
    this.setVisible(true);                       //La ventana inicia maximizada y en primer plano
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Al apretar la 'X' en la ventana esta terminara todos los procesos relacionados directamente con este programa
    this.setLocationRelativeTo(null);
    this.add(imagen,BorderLayout.CENTER);
  }

  public static void main(String[] args) {
    StartWindow ventanaInicial = new StartWindow(); //Se crea la ventana con las condiciones y propiedades indicadas anteriormente  
  }
}
