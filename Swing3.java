import javax.swing.*;
import java.awt.event.*;

public class Swing3 extends JFrame {
    public Swing3() {
        super("titre de l'application");

        WindowListener l = new WindowAdapter() {
            public  void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };

        addWindowListener(l);

        ImageIcon img = new ImageIcon("img.gif");
        JButton bouton = new JButton("Mon button", img);

        JPanel panneau = new JPanel();
        panneau.add(bouton);
        setContentPane(panneau);
        setSize(300,400);
        setVisible(true);

    }

    public static  void main(String[] args){
        JFrame frame = new Swing3();
    }
}