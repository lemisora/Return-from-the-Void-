//En este archivo va el ejecutable principal del juego en el que se conectaran todas las partes del mismo
import java.awt.event.TextListener;
import java.util.Scanner;
import Interfaz.StartWindow;
import javax.swing.*;
import Visual.canvasNiveles;
import Model.Input.Teclado;
import Model.Input.Raton;

public class MainJuego extends JFrame implements Runnable {
    static Scanner entrada = new Scanner(System.in); //Se inicializa un objeto de tipo Scanner para el ingreso de datos mediante el teclado
    private final int HEIGHT = 600;
    private final int WIDTH = 1000;
    public Thread hiloVentana;
    private boolean running = false;

    private final int FPS = 40;
    private double TARGETTIME = 1000000000/FPS;
    private double delta = 0;
    private  int averagefps = FPS;
    private Teclado keyboard;
    private Raton mouse;
    private canvasNiveles canvas;


    public MainJuego(){
        setTitle("Return from the Void!");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        canvas = new canvasNiveles(WIDTH,HEIGHT,keyboard,mouse);
    }
    public static void main(String[] args) {
        //Aquí se ejecuta la ventana del juego

    }
    @Override
    public void run() {

    }
}

