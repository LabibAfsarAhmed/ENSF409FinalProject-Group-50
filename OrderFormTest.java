/**
 @author Jannine Osman <a href="mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
         Sukriti Sharma <a href="mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
         Caroline Basta <a href="mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
         Labib Afsar Ahmed <a href="mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 @version       1.2
 @since         1.0
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;


public class OrderFormTest{
    private Order order;

    @Test
    public void testOrderFormConstructor(){
        OrderForm OrderFormConstructor = new OrderForm(order);
        assertNotNull("OrderForm constructor did not create an object when given valid arguments.",
        OrderFormConstructor);
    }

    @Test
     public void CreateTxtFile(){
            Order newOrder = null;

            try{
                newOrder = new Order("Sam", );
                OrderForm orderForm = new OrderForm(newOrder);
            }catch(Exception e){
    
            }
            boolean check = new File("orderform.txt").exists();
            assertTrue("Error: order failed to print.", check); 
      }

}