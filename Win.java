import javax.swing.JButton;
import javax.swing.JFrame;
import JImages.*;

public class Win extends JFrame{
    private final int WIDTH=1000, HEIGHT=600;
    JBackgroundPanel panel;
    JButton returnB;

    public Win(){
        setTitle("Return from the Void!");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panel = new JBackgroundPanel("Resource/Images/win.png");
        panel.setLayout(null);

        returnB = new JButton();

        returnB.setOpaque(true);
        returnB.setContentAreaFilled(false);
        returnB.setBorderPainted(false);
        returnB.addActionListener(e-> goToMenu());

        returnB.setBounds(312, 440 ,355, 65);
        panel.add(returnB);

        add(panel);
        this.setVisible(true);
    }

    public void goToMenu(){
        this.setVisible(false);
        Menu menu = new Menu();
        menu.setVisible(true);
    }

}
