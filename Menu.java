import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Loader;

public class Menu extends JFrame{
    private final int WIDTH=1000, HEIGHT=600;
    JPanel panel;
    JButton lev1B, lev2B, lev3B;

    public Menu(){
        setTitle("Return from the Void!");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        //Creacion de los botones
        lev1B = new JButton("Level 1");

        //Agregamos action listener a los botones
        lev1B.addActionListener(e-> goToLevel(1));

        //Posicionamos los botones
        lev1B.setBounds(450,100, 100, 30);

        //Agregamos los botones al panel
        panel.add(lev1B);

        add(panel);
        setVisible(true);
    }

    private void goToLevel(int index){
        this.setVisible(false);
        if(index==1){
            Nivel1 lvl1 = new Nivel1();
            lvl1.start();
            lvl1.setVisible(true);
        }
    }

    //MAIN INICIO DEL MENU DEL JUEGO
    public static void main(String[] args) {
        //Aqui se ejecuta la ventana del juego
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}
