
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class OrderForm {

    private Order order;

    public OrderForm(Order order) {
        this.order = order;
        outputText();
    }

    public void outputText() {
        try {
            File output = new File("orderform.txt"); 
            FileWriter write = new FileWriter(output);
            BufferedWriter buffer = new BufferedWriter(write);
            buffer.write(order.toString()); 
            buffer.flush();
            buffer.close();
        } catch (FileNotFoundException ex) {
            System.out.print("unable to open file");

        } catch (IOException ex) {
            System.out.print("error writing to file");
        }
    }
}
