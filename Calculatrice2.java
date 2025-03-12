import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent.*;
import java.awt.event.ActionListener.*;
import java.awt.*;

public class  Calculatrice2 extends JFrame implements ActionListener {
    private JTextField ecran;
    private String operateur = "";
    private double firstNumber;
    private boolean isNewinput = true;

    public Calculatrice2() {
        setTitle("Calculatrice");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        ecran = new JTextField("0");
        ecran.setFont(new Font("Arial", Font.BOLD, 24));
        ecran.setHorizontalAlignment(JTextField.RIGHT);
        ecran.setEditable(false);
        add(ecran, BorderLayout.NORTH);

        JPanel panelBoutons = new JPanel();
        panelBoutons.setLayout(new GridLayout(4, 4, 1, 1));

        String[] boutons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "+",
                "0", "C", "=", "-"
        };

        for (String text : boutons) {
            JButton bouton = new JButton(text);
            bouton.setFont(new Font("Arial", Font.BOLD, 18));
            bouton.addActionListener(this);
            panelBoutons.add(bouton);
        }

        add(panelBoutons, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public  void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.matches("[0-9]")){
            if(isNewinput){
                ecran.setText(command);
                isNewinput = false;
            }else {
                ecran.setText((ecran.getText() + command));
            }
        }else if (command.matches("[+\\-*/]")) {
            if(!operateur.isEmpty()){
                return;
            }
            firstNumber = Double.parseDouble(ecran.getText());
            operateur = command;
            ecran.setText(ecran.getText() + " " + operateur + " ");
            isNewinput = false;
        }else if (command.equals("=")) {
            String[] parts = ecran.getText().split(" ");
            if(parts.length < 3){
                return;
            }
            double secondNumber = Double.parseDouble(parts[2]);
            double resultat = 0;

            switch (operateur) {
                case "+": resultat = firstNumber + secondNumber;
                          break;
                case "-": resultat = firstNumber - secondNumber;
                          break;
                case "*": resultat = firstNumber * secondNumber;
                          break;
                case "/": resultat = secondNumber != 0 ? firstNumber / secondNumber : 0;
                          break;
            }
            ecran.setText(String.valueOf(resultat));
            isNewinput = true;
        }else if (command.equals("C")) {
            ecran.setText("0");
            firstNumber = 0;
            operateur = "";
            isNewinput = true;

        }
    }

    public static void main(String[] args){
        new Calculatrice2();
    }

}



