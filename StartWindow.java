import javax.swing.JFrame;    // Se importa JFrame de Swing para la creación de una ventana de forma sencilla que será dibujada en pantalla por el compositor/servidor del sistema operativo en el que se ejecute este programa
import java.awt.*;            //Se importa la librería de awt para manejar componentes de la ventana que se creará

public class StartWindow extends JFrame{
  private static final int HEIGHT = 600;
  private static final int WIDTH = 1000;
  
  public StartWindow(){ //Constructor de la ventana
    setTitle("Return from the Void");       //Este es el título que tendrá la ventana
    setSize(WIDTH,HEIGHT);                  //Se define el tamaño inicial de la ventana
    setVisible(true);                       //La ventana inicia maximizada y en primer plano
    setDefaultCloseOperation(EXIT_ON_CLOSE);//Al apretar la 'X' en la ventana esta terminará todos los procesos relacionados directamente con este programa
  }

  public static void main(String[] args) {
    StartWindow ventanaInicial = new StartWindow(); //Se crea la ventana con las condiciones y propiedades indicadas anteriormente  
  }
}
