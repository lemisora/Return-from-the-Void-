package Model.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
    private boolean[] teclas = new boolean[256];
    public static boolean A,D,SPACE;

    public Teclado(){
        A = false;
        D = false;
        SPACE = false;
    }

    public void update(){   //Función que actualiza el estado de presionado de las teclas
        A = teclas[KeyEvent.VK_A];
        D = teclas[KeyEvent.VK_D];
        SPACE = teclas[KeyEvent.VK_SPACE];
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        teclas[keyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {}
}
