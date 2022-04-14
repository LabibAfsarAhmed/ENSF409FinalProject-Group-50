import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

// our GUI needs:
// * a place for the name to be entered
// * the date
// * an option to select number of families

// * an input box for the families to enter composition
// * a place to request if one family wants multiple hampers configured
// * finally a place to press enter on the GUI to submit the request for the order form

public class GUI{
    static String employeeName = " ";
    static int families;
    static int adultFemales;
    static int adultMales;
    static int childrenOver8Yrs;
    static int childrenUnder8Yrs;
    static JTextField employeeIn = new JTextField("First name, last name");
    static JSpinner familyNum = new JSpinner();
    static JSpinner AdultFemales = new JSpinner();
    static JSpinner AdultMales = new JSpinner();
    static JSpinner childrenOver8 = new JSpinner();
    static JSpinner childrenUnder8 = new JSpinner();
    public static void main(String args[]){
        

        // creates base frame for other items to go on top
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Foodbank hamper system");
            frame.setSize(1000,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            

            JPanel buttonPanel = new JPanel();
            JPanel clientPanel = new JPanel();
            JPanel rightPanel = new JPanel();
            JPanel titlePanel = new JPanel();
            

            JButton submit = new JButton("Submit");
            JLabel instructions = new JLabel("Please enter the required information to produce a hamper order form");
            JLabel employeeLabel = new JLabel("Please enter employee name:");
            JLabel famillies = new JLabel("Please enter the number of families");
            JLabel family1Females = new JLabel("Please enter the number of adult females in family:");
            JLabel familyMales = new JLabel("Please enter the number of adult males in family:");
            JLabel familyOver8 = new JLabel("Please enter the number of children over 8 in family");
            JLabel familyUnder8 = new JLabel("Please enter the number of children under 8 in family");

            

            buttonPanel.add(submit);
            titlePanel.add(instructions);
            clientPanel.add(employeeLabel);
            clientPanel.add(employeeIn);
            clientPanel.add(famillies);
            rightPanel.add(family1Females);
            rightPanel.add(AdultFemales);
            rightPanel.add(familyMales);
            rightPanel.add(AdultMales);
            rightPanel.add(familyOver8);
            rightPanel.add(childrenOver8);
            rightPanel.add(familyUnder8);
            rightPanel.add(childrenUnder8);

            clientPanel.add(familyNum);


           // MyListener buttonListener = new MyListener();
             submit.addActionListener( (e)-> {
             submitAction();
        });



            //MyListener buttonListener = new MyListener();
            //myButton.addActionListener(buttonListener);
            //buttonsPanel.add(myButton);

            //frame.getContentPane().add(BorderLayout.NORTH, buttonsPanel); //layout manager used here (will place it north most of the frame)
            frame.getContentPane().add(BorderLayout.WEST, clientPanel);
            frame.getContentPane().add(BorderLayout.PAGE_END, buttonPanel);
            frame.getContentPane().add(BorderLayout.NORTH, titlePanel);
            frame.getContentPane().add(BorderLayout.CENTER, rightPanel);
            frame.setVisible(true);
        });



    }

    private static void submitAction() {
        // we will eventually store these in another class 
        employeeName = employeeIn.getText();
        families = (int)familyNum.getValue();
        adultFemales = (int)AdultFemales.getValue();
        adultMales = (int)AdultMales.getValue();
        childrenOver8Yrs = (int)childrenOver8.getValue();
        childrenUnder8Yrs = (int)childrenUnder8.getValue();

        System.out.println(employeeName);
        System.out.println(families);
        System.out.println(adultFemales);
        System.out.println(adultMales);
        System.out.println(childrenOver8Yrs);
        System.out.println(childrenUnder8Yrs);
    }
}

class MyListener implements ActionListener, MouseListener{

    public void actionPerformed(ActionEvent event){
        JOptionPane.showMessageDialog(null, "The order was submitted");

    }

    public void mouseClicked(MouseEvent event){
        
    }

    public void mouseEntered(MouseEvent event){

    }

    public void mouseExited(MouseEvent event){

    }

    public void mousePressed(MouseEvent event){

    }

    public void mouseReleased(MouseEvent event){

    }

}
