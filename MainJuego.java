//En este archivo va el ejecutable principal del juego en el que se conectaran todas las partes del mismo
import java.util.Scanner;
import Interfaz.StartWindow;
import Visual.ventanaJuego;
public class MainJuego{
  static Scanner entrada = new Scanner(System.in); //Se inicializa un objeto de tipo Scanner para el ingreso de datos mediante el teclado
  public Thread hiloVentana;
  public static void main(String[] args) {
    //Aquí se ejecuta la ventana del juego

      StartWindow ventanaPrincipal = new StartWindow();

  }
}

