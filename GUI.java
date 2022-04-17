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

// fix multiple hamper configuration

public class GUI{
    static String employeeName = " ";
    static int families;
    static int adultFemales;
    static int adultMales;
    static int childrenOver8Yrs;
    static int childrenUnder8Yrs;
    static int multipleHampers;
    static int weeklyServiceHampers;
    static JTextField employeeIn = new JTextField("First name, last name");
    //static JSpinner familyNum = new JSpinner();
    static JSpinner AdultFemales = new JSpinner();
    static JSpinner AdultMales = new JSpinner();
    static JSpinner childrenOver8 = new JSpinner();
    static JSpinner childrenUnder8 = new JSpinner();
    static JSpinner multipleHamperSelect = new JSpinner();
    static JSpinner weeklyServiceNeeded = new JSpinner();
    static JTextField numOfFams = new JTextField("  ");
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
            

            JButton submit = new JButton("Submit family");
            JButton doneSubmit = new JButton("Submit final order");
            JLabel instructions = new JLabel("Please enter the required information to produce a hamper order form.");
            JLabel employeeLabel = new JLabel("Please enter employee name:");
            //JLabel famillies = new JLabel("Please enter the number of families");
            JLabel family1Females = new JLabel("Please enter the number of adult females in family:");
            JLabel familyMales = new JLabel("Please enter the number of adult males in family:");
            JLabel familyOver8 = new JLabel("Please enter the number of children over 8 in family");
            JLabel familyUnder8 = new JLabel("Please enter the number of children under 8 in family");
            JLabel multipleHampersLbl = new JLabel("Please enter the number of hampers to configure");
            JLabel weeklyServiceLbl = new JLabel("If there are mobility concerns, please enter the number of hampers desired for weekly service");
            JLabel numberOfFams = new JLabel("The number of families submitted: ");

            

            buttonPanel.add(submit);
            titlePanel.add(instructions);
            clientPanel.add(employeeLabel);
            clientPanel.add(employeeIn);
            rightPanel.add(family1Females);
            rightPanel.add(AdultFemales);
            rightPanel.add(familyMales);
            rightPanel.add(AdultMales);
            rightPanel.add(familyOver8);
            rightPanel.add(childrenOver8);
            rightPanel.add(familyUnder8);
            rightPanel.add(childrenUnder8);
            rightPanel.add(multipleHampersLbl);
            rightPanel.add(multipleHamperSelect);
            rightPanel.add(weeklyServiceLbl);
            rightPanel.add(weeklyServiceNeeded);

            buttonPanel.add(doneSubmit);
            buttonPanel.add(doneSubmit);
            buttonPanel.add(numberOfFams);
            buttonPanel.add(numOfFams);


           // MyListener buttonListener = new MyListener();
             submit.addActionListener( (e)-> {
             submitAction();
        });

            MyListener buttonListener = new MyListener();
            doneSubmit.addActionListener(buttonListener);
            //buttonsPanel.add(myButton);

            //frame.getContentPane().add(BorderLayout.NORTH, buttonsPanel); //layout manager used here (will place it north most of the frame)
            frame.getContentPane().add(BorderLayout.WEST, clientPanel);
            frame.getContentPane().add(BorderLayout.PAGE_END, buttonPanel);
            frame.getContentPane().add(BorderLayout.NORTH, titlePanel);
            frame.getContentPane().add(BorderLayout.CENTER, rightPanel);
            frame.setVisible(true);
        });



    }

    public static FamilyProfile submitAction() {
        // we will eventually store these in another class 
        families += 1;
        employeeName = employeeIn.getText();
        adultFemales = (int)AdultFemales.getValue();
        adultMales = (int)AdultMales.getValue();
        childrenOver8Yrs = (int)childrenOver8.getValue();
        childrenUnder8Yrs = (int)childrenUnder8.getValue();
        
        multipleHampers = (int)multipleHamperSelect.getValue();
        weeklyServiceHampers = (int)weeklyServiceNeeded.getValue();

        

        

 
        //FamilyProfile family = new FamilyProfile(adultFemales, adultMales, childrenOver8Yrs, childrenUnder8Yrs, multipleHampers, weeklyServiceHampers);
        // do actions to create hamper for them here too

        AdultFemales.setValue(0);
        AdultMales.setValue(0);
        childrenOver8.setValue(0);
        childrenUnder8.setValue(0);
        multipleHamperSelect.setValue(0);
        weeklyServiceNeeded.setValue(0);
        numOfFams.setText(Integer.toString(families));

       // return new FamilyProfile(adultMales, adultFemales, childrenUnder8Yrs, childrenOver8Yrs );
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