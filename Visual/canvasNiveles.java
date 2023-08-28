package Visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public class canvasNiveles extends Canvas {
    private int nivel = 1;

    private volatile boolean running = true;
    private Thread hilo;

    private final int WIDTH = 1000;
    private final int HEIGHT = 600;

    private BufferStrategy buffStrat;
    private Graphics G;

    public canvasNiveles(int WIDTH, int HEIGHT){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
    }

    public void draw(){
        buffStrat = this.getBufferStrategy();
        if(buffStrat == null){
            this.createBufferStrategy(3);   //Se crea un triple buffer para mejor rendimiento gráfico
            return;
        }
        this.G = buffStrat.getDrawGraphics();

        G.setColor(Color.BLACK);
        G.fillRect(0,0,WIDTH,HEIGHT);
        G.setColor(Color.WHITE);

        G.dispose();
        buffStrat.show();
    }

}
