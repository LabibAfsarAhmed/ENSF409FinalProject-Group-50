import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class GUIFoodHampers extends JFrame implements ActionListener, MouseListener{

    private String employeeName;
    private String family;
    private int numberOfFamilies;

    private JLabel instructions;
    private JLabel employeeLabel;
    private JLabel numFamilies;
    
    private JTextField employeeNameIn;
    private JTextField numFamiliesIn;

    public GUIFoodHampers(){
        super("Food hamper order form creator");
        setupGUI();
        setSize(650,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setupGUI(){
        instructions = new JLabel("Please enter required information to generate an order form");
        employeeLabel = new JLabel("Please enter employee name");
        numFamilies = new JLabel("Please enter the number of families");

        employeeNameIn = new JTextField("First name, last name", 15);
        employeeNameIn.addMouseListener(this);

        numFamiliesIn = new JTextField("1    ");
        numFamiliesIn.addMouseListener(this);

        JButton submitInfo = new JButton("Submit");
        submitInfo.addActionListener(this);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());

        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());

        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        headerPanel.add(instructions);
        clientPanel.add(employeeLabel);
        clientPanel.add(employeeNameIn);
        clientPanel.add(numFamilies);
        clientPanel.add(numFamiliesIn);
        submitPanel.add(submitInfo);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.WEST);
        this.add(submitPanel, BorderLayout.PAGE_END);

    }

    public void actionPerformed(ActionEvent event){
        this.employeeName = employeeNameIn.getText();
        this.numberOfFamilies = Integer.parseInt(numFamiliesIn.getText());
    }

    public void mouseClicked(MouseEvent event){
        if(event.getSource().equals(employeeNameIn)){
            employeeNameIn.setText("");
        }
        if(event.getSource().equals(numFamiliesIn)){
            numFamiliesIn.setText("");
        }
    }

    public void mouseEntered(MouseEvent event){

    }

    public void mouseExited(MouseEvent event){

    }

    public void mousePressed(MouseEvent event){

    }

    public void mouseReleased(MouseEvent event){

    }

    public static void main(String[] args){
       // GUIFoodHampers initial = new GUIFoodHampers();
       EventQueue.invokeLater(() -> {
            new GUIFoodHampers().setVisible(true);
        });
        
    }
    
}
