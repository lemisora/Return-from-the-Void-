import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import JImages.*;

public class Menu extends JFrame{
    private final int WIDTH=1000, HEIGHT=600;
    JBackgroundPanel panel;
    JButton lev1B, lev2B, lev3B;
    BufferedImage backGroundPanel;

    public Menu(){
        setTitle("Return from the Void!");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        //Creacion del panel
        panel = new JBackgroundPanel();
        panel.setLayout(null);

        //Creacion de los botones
        lev1B = new JButton();
        lev1B.setOpaque(true);
        lev1B.setContentAreaFilled(false);
        lev1B.setBorderPainted(false);

        lev2B = new JButton();
        lev2B.setOpaque(true);
        lev2B.setContentAreaFilled(false);
        lev2B.setBorderPainted(false);

        lev3B = new JButton();
        lev3B.setOpaque(true);
        lev3B.setContentAreaFilled(false);
        lev3B.setBorderPainted(false);

        //Agregamos action listener a los botones
        lev1B.addActionListener(e-> goToLevel(1));
        lev2B.addActionListener(e-> goToLevel(2));
        lev3B.addActionListener(e-> goToLevel(3));

        //Posicionamos los botones
        lev1B.setBounds(300, 190, 390, 70);
        lev2B.setBounds(300, 300, 390, 70);
        lev3B.setBounds(300, 410, 390, 70);

        //Agregamos los botones al panel
        panel.add(lev1B);
        panel.add(lev2B);
        panel.add(lev3B);

        add(panel);
        setVisible(true);
    }

    //Funcion para cambiar de nivel
    private void goToLevel(int index){
        this.setVisible(false);
        if(index==1){
            Nivel1 lvl1 = new Nivel1();
            lvl1.start();
            lvl1.setVisible(true);
        }
        if(index == 2){
            System.out.println("ir al nivel 2");
            this.setVisible(true);
        }
        if(index == 3){
            System.out.println("ir al nivel 3");
            this.setVisible(true);
        }
    }

    //MAIN INICIO DEL MENU DEL JUEGO
    public static void main(String[] args) {
        //Aqui se ejecuta la ventana del juego
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}
