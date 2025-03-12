import javax.swing.*;
import java.awt.event.*;

public class Swing2 extends JFrame {
    public Swing2(){
        super("Calculatrice");

        WindowListener kim = new WindowAdapter() {
            public void WindowClosing(WindowEvent e){
                System.exit(0);
            }
        };
        addWindowListener(kim);
        setSize(500, 400);
        setVisible(true);
    }

    public static void main(String[] args){
        JFrame frame = new Swing2();
    }

}