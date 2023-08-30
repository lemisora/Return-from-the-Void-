//En este archivo va el ejecutable principal del juego en el que se conectaran todas las partes del mismo
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import javax.swing.*;

import Model.Assets;
import Model.Input.Teclado;
import ObjetosEspaciales.Nave.Nave;

public class MainJuego extends JFrame implements Runnable { //Se crea una ventana de 1000 x 600
    private final int WIDTH = 1000, HEIGHT = 600;
    private Thread hiloVentana;                             //Se crea un hilo para el control del videojuego
    private Canvas canvas;                                  //Se define un Canvas para el dibujado de los elementos del juego en la ventana
    private boolean running = false;                        //Se establece un booleano que define el estado de ejecución

    private BufferStrategy buffStrat;                       //Se crea un BufferStrategy para despues establecer un triplebuffer y mejorar el rendimiento
    private Graphics2D G;                                     //Objeto para el dibujado de elementos graficos

    private final int FPS = 60;                             //Limitacion de cuadros en ventana
    private double TARGETTIME = 1000000000/FPS;             //Tiempo objetivo para obtener un cuadro de los 40 por segundo
    private double delta = 0;                               //Diferencia de tiempo
    private  int averagefps = FPS;                          //Cuadros promedio

    private Teclado keyboard =  new Teclado();              //Se crea un objeto Teclado de tipo KeyListener con el que se controlarán los movimientos de la nave
    private Nave ship = new Nave(0,WIDTH/2,HEIGHT-50);

    public MainJuego(){                                     //Se establecen propiedades para la ventana
        setTitle("Return from the Void!");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        canvas = new Canvas();                              //Se crea el canvas
        //Preferencias para el Canvas
        canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH,HEIGHT));
        canvas.setFocusable(true);

        add(canvas);                                        //Adicion del canvas al JFrame
        canvas.addKeyListener(keyboard);                    //Se adhiere el Teclado (KeyListener) al Canvas
    }
    public static void main(String[] args) {
        //Aquí se ejecuta la ventana del juego
        new MainJuego().start();
    }

    private void init() throws IOException, FontFormatException {           //Método para la inicialización de los elementos gráficos del juego
        Assets.init();
    }
    private void update(){
        keyboard.update();
        ship.move(keyboard.isA(),keyboard.isD(),keyboard.isSPACE());
    }
    public void draw(){
        buffStrat = canvas.getBufferStrategy();
        if(buffStrat == null){
            canvas.createBufferStrategy(3);   //Se crea el triple buffer para mejor rendimiento gráfico
            return;
        }
        G = (Graphics2D)buffStrat.getDrawGraphics();

        G.setColor(Color.BLACK);                               //Se establece el color de fondo del Canvas como Negro
        G.fillRect(0,0,WIDTH,HEIGHT);

        if(ship.getposX() > WIDTH-10){
            ship.setPosX(WIDTH - 10);

        }else if(ship.getposX() < 0){
            ship.setPosX(10);
        }

        G.drawImage(Assets.nave,ship.getposX(),ship.getposY(),null);    //Se dibuja la nave en el centro del Canvas
        G.setColor(Color.WHITE);
        G.setFont(Assets.fuenteFPS);
        G.drawString(""+averagefps,10,20);
        G.dispose();
        buffStrat.show();                                      //Se muestran suavemente los objetos del juego con TripleBuffer
        Toolkit.getDefaultToolkit().sync();
    }
    @Override
    public void run() {
        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        try {
            init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }

        while (running){
            now = System.nanoTime();
            delta += (now - lastTime)/TARGETTIME;
            time += (now - lastTime);
            lastTime = now;

            if(delta >= 1){
                update();
                draw();
                delta --;
                frames ++;
            }
            if(time >= 1000000000){
                averagefps = frames;
                frames = 0;
                time = 0;
            }
        }
        stop();
    }
    private void start(){
        hiloVentana = new Thread(this);
        hiloVentana.start();
        running = true;
    }

    private void stop(){
        try {
            hiloVentana.join();
            running = false;
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

