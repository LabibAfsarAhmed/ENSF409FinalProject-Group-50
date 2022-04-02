package edu.ucalgary.ensf409;

import org.junit.*;
import org.junit.Assert.*;

import java.io.*;
import java.util.*;

public class sukritiTest {
    // Hello 


    // Test the constructor for ConfigureHamper
    @Test
    public void testConfigureHamper() {
        ConfigureHamper hamperConfigured = new ConfigureHamper(orderForm);
        assertNotNull("ConfigureHamper constructor did not create an object.",
                hamperConfigured);
    }

    // Test the constructor for Hamper
    @Test
    public void testHamper() {
        Hamper hamper = new Hamper(orderForm);
        assertNotNull("Hamper constructor did not create an object.",
                hamper);
    }

    //Make sure hamper calculates enough 
    @Test
    public void testCalculateHamper(){
        int hamperCalc = calculateHamper(hamper);
        int expectedHamperCalc = 1067;


        if(hamperCalc < expectedHamperCalc ){
            assertEquals("Not enough stock in inventory", expectedHamperCalc, hamperCalc);
        }

  }



    /*
    @Test
    public void testGetNewRequest(){
        ConfigureHamper hamper = new ConfigureHamper(orderForm);
        String expectedRequest = "1 Adult Female, 2 Child under 8";
        String foundRequest = getNewRequest(orderform);       //FIX THIS
        assertEquals("Method getNewRequest did not return the expected result ", expectedRequest, foundRequest);
        

    }

    @Test 
    public void testSetNewRequest(){
        ConfigureHamper hamper = new ConfigureHamper(orderform);
        hamper.setNewRequest("1 Adult Male, 1 Child over 8");    //GENERALIZE TO MAKE A ITERATOR FOR EACH HAMPER TO READ IN FROM FILE
        String foundRequest = hamper.getNewRequest();
        String expectedRequest = "1 Adult Male, 1 Child over 8";
        assertEquals("Method setNewRequest did not return the expected result: ", expectedRequest, foundRequest);
    } */

     





}



