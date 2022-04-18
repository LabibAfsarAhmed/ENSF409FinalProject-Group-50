/**
 @author Jannine Osman <a href="mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
         Sukriti Sharma <a href="mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
         Caroline Basta <a href="mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
         Labib Afsar Ahmed <a href="mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 @version       1.2
 @since         1.0
 **/

import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;

// testing order form and making sure file has been created
public class OrderFormTest{
    private List<FamilyProfile> requestedFamilies = new ArrayList<>(); 

    @Test
     public void CreateTxtFile(){
            Order newOrder = null;

            try{
                newOrder = new Order("Sam", requestedFamilies);
                OrderForm orderForm = new OrderForm(newOrder);
            }catch(Exception e){

            }
            boolean check = new File("orderform.txt").exists();
            assertTrue("Error: order failed to print.", check); 
      }
}
