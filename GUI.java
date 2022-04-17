import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

// our GUI needs:
// * a place for the name to be entered
// * the date
// * an option to select number of families

// * an input box for the families to enter composition
// * a place to request if one family wants multiple hampers configured
// * finally a place to press enter on the GUI to submit the request for the order form

public class GUI {
    private static List<FamilyProfile> requestedFamilies = new ArrayList<>();

    static String employeeName = " ";
    static int families;
    static int adultFemales;
    static int adultMales;
    static int childrenOver8Yrs;
    static int childrenUnder8Yrs;
    static int multipleHampers;
    static int weeklyServiceHampers;
    static JTextField employeeIn = new JTextField("First name, last name");
    // static JSpinner familyNum = new JSpinner();
    static JSpinner AdultFemales = new JSpinner();
    static JSpinner AdultMales = new JSpinner();
    static JSpinner childrenOver8 = new JSpinner();
    static JSpinner childrenUnder8 = new JSpinner();
    static JSpinner multipleHamperSelect = new JSpinner();
    static JSpinner weeklyServiceNeeded = new JSpinner();
    static JTextField numOfFams = new JTextField("  ");

    public static void main(String args[]) {

        // creates base frame for other items to go on top
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Foodbank hamper system");
            frame.setSize(1000, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel buttonPanel = new JPanel();
            JPanel clientPanel = new JPanel();
            JPanel rightPanel = new JPanel();
            JPanel titlePanel = new JPanel();

            JButton submit = new JButton("Add family");
            JButton doneSubmit = new JButton("Submit final order");
            JLabel instructions = new JLabel("Please enter the required information to produce a hamper order form.");
            JLabel employeeLabel = new JLabel("Please enter employee name:");
            // JLabel famillies = new JLabel("Please enter the number of families");
            JLabel family1Females = new JLabel("Please enter the number of adult females in family:");
            JLabel familyMales = new JLabel("Please enter the number of adult males in family:");
            JLabel familyOver8 = new JLabel("Please enter the number of children over 8 in family");
            JLabel familyUnder8 = new JLabel("Please enter the number of children under 8 in family");
            JLabel multipleHampersLbl = new JLabel("Please enter the number of hampers to configure");
            JLabel weeklyServiceLbl = new JLabel(
                    "If there are mobility concerns, please enter the number of hampers desired for weekly service");
            JLabel numberOfFams = new JLabel("The number of families added: ");

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
            submit.addActionListener((e) -> {
                submitAction();
            });

            // MyListener buttonListener = new MyListener();
            // doneSubmit.addActionListener(buttonListener);
            doneSubmit.addActionListener((e) -> {
                submitFinalOrder();
            });

            // buttonsPanel.add(myButton);

            // frame.getContentPane().add(BorderLayout.NORTH, buttonsPanel); //layout
            // manager used here (will place it north most of the frame)
            frame.getContentPane().add(BorderLayout.WEST, clientPanel);
            frame.getContentPane().add(BorderLayout.PAGE_END, buttonPanel);
            frame.getContentPane().add(BorderLayout.NORTH, titlePanel);
            frame.getContentPane().add(BorderLayout.CENTER, rightPanel);
            frame.setVisible(true);
        });

    }

    private static void submitFinalOrder() {
        if ("".equals(employeeName) || requestedFamilies.size() == 0) {
            JOptionPane.showMessageDialog(null, "Input data!");
            return;
        }

        Order order = new Order(employeeName, requestedFamilies);
        System.out.println(order);
        try {
            HamperCreator hamperCreator = new HamperCreator(order);
            hamperCreator.buildHamper();
            System.out.println(order);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        // resetting families
        requestedFamilies = new ArrayList<>();
        numOfFams.setText("0");
    }

    private static void submitAction() {
        // we will eventually store these in another class
        families += 1;
        employeeName = employeeIn.getText();
        adultFemales = (int) AdultFemales.getValue();
        adultMales = (int) AdultMales.getValue();
        childrenOver8Yrs = (int) childrenOver8.getValue();
        childrenUnder8Yrs = (int) childrenUnder8.getValue();
        multipleHampers = (int) multipleHamperSelect.getValue();
        weeklyServiceHampers = (int) weeklyServiceNeeded.getValue();

        FamilyProfile family = new FamilyProfile(adultFemales, adultMales, childrenOver8Yrs, childrenUnder8Yrs,
                multipleHampers, weeklyServiceHampers);
        requestedFamilies.add(family);
        // do actions to create hamper for them here too

        // System.out.println(employeeName);
        // System.out.println(families);
        // System.out.println(adultFemales);
        // System.out.println(adultMales);
        // System.out.println(childrenOver8Yrs);
        // System.out.println(childrenUnder8Yrs);
        // System.out.println(multipleHampers);
        // System.out.println(weeklyServiceHampers);

        AdultFemales.setValue(0);
        AdultMales.setValue(0);
        childrenOver8.setValue(0);
        childrenUnder8.setValue(0);
        multipleHamperSelect.setValue(0);
        weeklyServiceNeeded.setValue(0);
        numOfFams.setText(Integer.toString(families));
    }
}

class MyListener implements ActionListener, MouseListener {

    public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "The order was submitted");
    }

    public void mouseClicked(MouseEvent event) {

    }

    public void mouseEntered(MouseEvent event) {

    }

    public void mouseExited(MouseEvent event) {

    }

    public void mousePressed(MouseEvent event) {

    }

    public void mouseReleased(MouseEvent event) {

    }

}
