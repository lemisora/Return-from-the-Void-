import javax.swing.JFrame;    // Se importa JFrame de Swing para la creación de una ventana de forma sencilla que será dibujada en pantalla por el compositor/servidor del sistema operativo en el que se ejecute este program
import JImages.JBackgroundPanel;


public class PruebasAlex extends JFrame{
    public static final int HEIGHT = 600;
    public static final int WIDTH = 1000;

    public PruebasAlex(){ //Constructor de la ventana
        this.setTitle("Return from the Void");       //Este es el título que tendrá la ventana
        this.setSize(WIDTH,HEIGHT);                  //Se define el tamaño inicial de la ventana
        this.setResizable(false);                  //La ventana inicia maximizada y en primer plano
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//Al apretar la 'X' en la ventana esta terminará todos los procesos relacionados directamente con este programa
  }


  public static void main(String args[]){
    PruebasAlex window = new PruebasAlex();
    JBackgroundPanel mainPanel = new JBackgroundPanel();
    mainPanel.addMainComponents(mainPanel.WIDTH, mainPanel.HEIGHT, window);
    window.add(mainPanel);

    window.setVisible(true);

  }
}
