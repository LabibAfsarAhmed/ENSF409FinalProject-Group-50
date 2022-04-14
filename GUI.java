import javax.swing.*;
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
    public static void main(String args[]){

        // creates base frame for other items to go on top
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Foodbank hamper system");
            frame.setSize(400,400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // will add rest of the components onto this button panel
            JPanel buttonsPanel = new JPanel();
            //JButton myButton = new JButton("Click here!");
            JLabel employee = new JLabel("Please enter employee name:");

            MyListener buttonListener = new MyListener();
            //myButton.addActionListener(buttonListener);
            //buttonsPanel.add(myButton);
            buttonsPanel.add(employee);

            //frame.getContentPane().add(BorderLayout.NORTH, buttonsPanel); //layout manager used here (will place it north most of the frame)
            frame.getContentPane().add(BorderLayout.WEST, buttonsPanel);
            frame.setVisible(true);
        });
    }
}

class MyListener implements ActionListener{

    public void actionPerformed(ActionEvent event){
        
        JOptionPane.showMessageDialog(null, "This button has been pushed");
    }

}

class GUIFoodHampers extends JFrame implements ActionListener, MouseListener{

    
}