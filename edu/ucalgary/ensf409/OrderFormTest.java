package edu.ucalgary.ensf409;

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


public class OrderFormTest{
    /**
     * test to ensure that the text file has been created successfuly
     * Note: program must be run first for the test to pass
     * @catches Exception if new order wasn't created from OrderForm
     */
    private List<FamilyProfile> requestedFamiliesForm = new ArrayList<>(); //creates a new array list of different
                                                                       // families from family profile
    @Test
     public void CreateTxtFile(){
            Order newOrder = null;         //start with an empty order
            try{
                newOrder = new Order("Sam", requestedFamiliesForm); //Order will take a string, and an array list of requested families
                OrderForm orderForm = new OrderForm(newOrder);     //to create the new order form
            }catch(Exception e){

            }
            boolean check = new File("orderform.txt").exists();  //check if the orderform.txt file exsists
            assertTrue("Error: order failed to print.", check);   //if not, show the error statement
      }
}