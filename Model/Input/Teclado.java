package Model.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {
    public static boolean A,D,SPACE;

    public Teclado(){
        A = false;
        D = false;
        SPACE = false;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_A){
            A = true;
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
            D = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_A){
            A = false;
        } else if (keyEvent.getKeyCode() == KeyEvent.VK_D) {
            D = false;
        }
    }

    public static boolean isA() {
        return A;
    }

    public static boolean isD() {
        return D;
    }

    public static boolean isSPACE() {
        return SPACE;
    }

}
