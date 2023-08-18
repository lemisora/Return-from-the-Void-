package Visual;
import Model.Loader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;

public class ventanaJuego extends JFrame implements Runnable {
    private volatile boolean running = true;
    private Thread hilo;

    private final int WIDTH = 1000;
    private final int HEIGHT = 600;
    public ventanaJuego(){
        this.setTitle("Return from the Void - Nivel ");
        this.setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void run() {
        while (running){
            try {
                hilo.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stop();
        }
    }

    public void start(){
        hilo = new Thread(this);
        hilo.start();
    }


    public void stop(){
        running = false;
        try {
            hilo.join();
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
