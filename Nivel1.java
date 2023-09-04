import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;

import Model.Assets;
import Model.Input.Teclado;

import java.util.Random;

import ObjetosEspaciales.Nave.Nave;
import ObjetosEspaciales.Planeta.Planetas;

public class Nivel1 extends JFrame implements Runnable{

    //Se crea una ventana de 1000 x 600
    private final int WIDTH = 1000, HEIGHT = 600;
    private Thread hiloVentana;                             //Se crea un hilo para el control del videojuego
    private Canvas canvas;                                  //Se define un Canvas para el dibujado de los elementos del juego en la ventana
    private boolean running = false;                        //Se establece un booleano que define el estado de ejecucion

    private BufferStrategy buffStrat;                       //Se crea un BufferStrategy para despues establecer un triplebuffer y mejorar el rendimiento
    private Graphics2D G;                                     //Objeto para el dibujado de elementos graficos

    private final int FPS = 60;                             //Limitacion de cuadros en ventana
    private double TARGETTIME = 1000000000/FPS;             //Tiempo objetivo para obtener un cuadro de los 40 por segundo
    private double delta = 0;                               //Diferencia de tiempo
    private int averagefps = FPS;                          //Cuadros promedio

    private Random aleatorio = new Random();

    private Teclado keyboard =  new Teclado();              //Se crea un objeto Teclado de tipo KeyListener con el que se controlaran los movimientos de la nave

    private Nave ship = new Nave(0,WIDTH/2,HEIGHT-80);
    private Planetas planetas[];
    private boolean moving = false;

    private int i = 0;

    public Nivel1(){                                     //Se establecen propiedades para la ventana
        setTitle("Return from the Void!");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();

        //Preferencias para el Canvas
        canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH,HEIGHT));
        canvas.setBackground(Color.black);
        canvas.setFocusable(true);

//        add(canvas);                                        //Adicion del canvas al JFrame
        canvas.addKeyListener(keyboard);                    //Se adhiere el Teclado (KeyListener) al Canvas
        add(canvas);

    }
    public static void main(String[] args) {
<<<<<<< HEAD:Nivel1.java
<<<<<<< HEAD:Nivel1.java
        //Aqui se ejecuta la ventana del juego
        Nivel1 juego = new Nivel1();
=======
        //Aquí se ejecuta la ventana del juego
        MainJuego juego = new MainJuego();
>>>>>>> parent of f28bda5 (Se eliminan clases de StartWindow, JImages, etc):MainJuego.java
=======
        //Aquí se ejecuta la ventana del juego
        MainJuego juego = new MainJuego();
>>>>>>> parent of f28bda5 (Se eliminan clases de StartWindow, JImages, etc):MainJuego.java
        juego.start();
    }

    private void init() throws IOException, FontFormatException {           //Metodo para la inicializacion de los elementos graficos del juego
        Assets.init();
        planetas = new Planetas[aleatorio.nextInt(6)+3];         //Se inicializa el arreglo de planetas
        for(i = 0 ; i < planetas.length ; i++){
            planetas[i] = new Planetas(0,WIDTH-50, HEIGHT/4);
        }
    }
    private void update(){
        ship.moveX(keyboard.isA(),keyboard.isD(),keyboard.isSPACE());
        for(i = 0 ; i < planetas.length ; i++){
            planetas[i].update();
            if(planetas[i].isTieneVida() == true){
                checaColisiones(Assets.nave, ship.getposX(),ship.getposY(),Assets.planetaVivo, planetas[i].getposX(),planetas[i].getposY());
            } else if (planetas[i].isTieneVida() == false) {
                checaColisiones(Assets.nave, ship.getposX(),ship.getposY(),Assets.planetaMuerto, planetas[i].getposX(),planetas[i].getposY());
            }

        }
    }
    private void draw(){
        buffStrat = canvas.getBufferStrategy();
        if(buffStrat == null){
            canvas.createBufferStrategy(2);   //Se crea el triple buffer para mejor rendimiento grafico
            return;
        }
        G = (Graphics2D)buffStrat.getDrawGraphics();

        G.setColor(Color.BLACK);                               //Se establece el color de fondo del Canvas como Negro
        G.fillRect(0,0,WIDTH,HEIGHT);

        G.drawImage(Assets.nave,ship.getposX(),ship.getposY(),null);    //Se dibuja la nave en el centro del Canvas
        for(i = 0 ; i < planetas.length ; i++){
            if(planetas[i].isTieneVida() == true){
                G.drawImage(Assets.planetaVivo,planetas[i].getposX(),planetas[i].getposY(),null);
            } else if (planetas[i].isTieneVida() == false) {
                G.drawImage(Assets.planetaMuerto,planetas[i].getposX(),planetas[i].getposY(),null);
            }

        }
        G.setColor(Color.GREEN);
        G.setFont(Assets.fuenteFPS);
        G.drawString("FPS : "+averagefps,10,20);
        G.dispose();
        buffStrat.show();                                      //Se muestran suavemente los objetos del juego con TripleBuffer
        Toolkit.getDefaultToolkit().sync();                    //Se activa la sincronizacion vertical, mejora el rendimiento con OpenGL en distribuciones de Linux y BSD
    }

    private void checaColisiones(BufferedImage obj1, int x1, int y1, BufferedImage obj2, int x2, int y2){
        int width1 = obj1.getWidth();
        int height1 = obj1.getHeight();

        int width2 = obj2.getWidth();
        int height2 = obj2.getHeight();

        int izq1 = x1; int der1 = x1 + width1; int top1 = y1; int bottom1 = y1 + height1;
        int izq2 = x2; int der2 = x2 + width2; int top2 = y2; int bottom2 = y2 + height2;

        if((der1 > izq2) && (izq1 < der2) && (bottom1 > top2) && (top1 < bottom2)){
            System.out.println("Hubo colision!");
        }
    }

    @Override
    public void run() {
        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        try {
            init();                                             //Se carga en memoria cada uno de los elementos que se necesitan para la ejecucion del juego
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

