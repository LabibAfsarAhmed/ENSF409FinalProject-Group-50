<<<<<<< HEAD
=======

>>>>>>> f0bdc379b09ffc77965350f1df423f08c356e312

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class OrderForm {

    private Order order;

    public OrderForm(Order order) {
        this.order = order;
        outputToText();
    }

    public void outputToText() {
        try {
            File obj = new File("orderform.txt"); //creates a new File called orderform.txt
            FileWriter fw = new FileWriter(obj);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(order.toString()); // writes the order string to the orderform file
            bw.flush();
            bw.close();
        } catch (FileNotFoundException ex) { // throws exception if it is unable to open the orderform file
            System.out.print("unable to open file");

        } catch (IOException ex) { // throws error if it is unable to write to orderform.txt
            System.out.print("error writing to file");
        }
    }
}
