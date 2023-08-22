package Model.Input;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Raton extends MouseAdapter{
    public static int x,y;
    public static boolean Boton_Izq;

    @Override
    public void mousePressed(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON1){
            Boton_Izq = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON1){
            Boton_Izq = false;
        }
    }

}
