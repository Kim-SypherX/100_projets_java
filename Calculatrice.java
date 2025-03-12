import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;


class Operations {
   private double a;
   private double b;
   
   // Constructeur
    public Operations(double a, double b){
        this.a = a;
        this.b = b;
    }
   
   //Settere
    public void setA(double a){
       this.a = a;
    }
    public void setB(double b){
        this.b = b;
    }
   
   //Getters
    public double getA(){
       return a;
    }
    public double getB(){
       return b;
    }

}

class Calcul extends Operations {
    public Calcul(double a, double b){
        super(a,b);
    }

    public double calculOperation(int choix) {
        switch(choix) {
            case 1:
                return getA() + getB();
            case 2:
                return getA() - getB();
            case 3:
                return getA() * getB();  
            case 4:
                if(getB() == 0){
                    throw new ArithmeticException("Division par zero !");
                }
                return getA() / getB();
            default:
                throw new IllegalArgumentException("Operation invalide !");
        }
    }
}

//Interface graphique
public class Calculatrice extends JFrame{
    private JTextField inputA,inputB;
    private JComboBox<String> operateur;
    private JLabel resultLabel;

    public Calculatrice(){
        super("Calculatrice");

        setLayout(new GridLayout(5,2));

        add(new JLabel("1er nombre: "));
        inputA = new JTextField();
        add(inputA);

        add(new JLabel("2em nombre: "));
        inputB = new JTextField();
        add(inputB);

        add(new JLabel("Operation: "));
        String[] operations ={"+","-","*","/"};
        operateur = new JComboBox<>(operations);
        add(operateur);

        JButton calculBtn = new JButton("Calculer");
        add(calculBtn);

        resultLabel = new JLabel("Resultat :");
        add(resultLabel);

        calculBtn.addActionListener(e -> calculer());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setVisible(true);

    }

    private void calculer(){
        try{
            double a = Double.parseDouble(inputA.getText());
            double b = Double.parseDouble(inputB.getText());
            int choix = operateur.getSelectedIndex() + 1;

            Calcul calcul = new Calcul(a,b);
            double resultat = calcul.calculOperation(choix);
            resultLabel.setText("Resultat: " + resultat);
        }catch (NumberFormatException ex){
            resultLabel.setText("Error !");
        }catch (ArithmeticException ex){
            resultLabel.setText("Error" + ex.getMessage());
        }

    }
    public static void main(String[] args){
        new Calculatrice();
    }

}

