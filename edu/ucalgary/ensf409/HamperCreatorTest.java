package edu.ucalgary.ensf409;

/**
 @author Jannine Osman <a href="mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
         Sukriti Sharma <a href="mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
         Caroline Basta <a href="mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
         Labib Afsar Ahmed <a href="mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 @version       2.3
 @since         1.0
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.io.*;
import java.util.ArrayList;


public class HamperCreatorTest{
    /**
     * initialized the new list for family profile
     * initialize a list of hamper - requested families
     * initializes list of food items
     */
    List<FamilyProfile> requestedFamilies = new ArrayList<FamilyProfile>();
    List<Hamper> initializeHampers = new ArrayList<Hamper>();
    List<FoodItem> sampleFood = new ArrayList<FoodItem>();
    String testEmployee = "Sam";
    List<FamilyProfile> expectedFamilies = createSampleFamilies(requestedFamilies);
    
    Order order = new Order(testEmployee,expectedFamilies);

    /**
     * this initlializes the sample list of requested families
     * create sameple and adds it to requested family list
     * @param requestedFamilies is referencing the FamilyProfile class
     * @return requestedFamilies
     */
    public List<FamilyProfile> createSampleFamilies(List<FamilyProfile> requestedFamilies) {
        //an example of family that requires weekly service due to mobility issues
        FamilyProfile family1 = new FamilyProfile(1, 1, 1, 1, true); 
        //an example of family that doesn't require weekly service due to mobility issues
        FamilyProfile family2 = new FamilyProfile(2, 1, 0, 0, false);
        //adds family 1 and 2 into the requested family list
        requestedFamilies.add(family1);
        requestedFamilies.add(family2);
        return requestedFamilies;
    }
    // //create bad data
    // public List<FamilyProfile> createSampleFamiliesBad(List<FamilyProfile> requestedFamilies) {
    //     FamilyProfile family1 = new FamilyProfile(321, 1, 13, 1, true);
    //     FamilyProfile family2 = new FamilyProfile(42, 19, 0, 0, false);
    //     requestedFamilies.add(family1);
    //     requestedFamilies.add(family2);
    //     return requestedFamilies;
    // } 

    /**
     * test Hamper Creator constructor
     * checks if the constructor has made an object
     */
    @Test
    public void testHamperCreator(){
        HamperCreator testCreator = new HamperCreator(order);
        assertNotNull("HamperConstructor did not create an object when given valid arguments.",
                testCreator);
    } 


    //test RunTimeException
    // @Test
    // public void testRunTimeException(){          //test is supposed to fail as the data is bad, so the exception is caught successfully
    //     List<FamilyProfile> badFamilies = createSampleFamiliesBad(requestedFamilies);
    //     Order badOrder = new Order(testEmployee, badFamilies);
    //     HamperCreator badHamper = new HamperCreator(badOrder);
    //     try{
    //         long expected = InventoryData.getTotalGrain();
    //         fail("HamperCreator method did not throw RunTimeException when given a date not contained within the data.");
    //     }
    //     catch (RuntimeException e){
    //         assertTrue(true);
    //     }
    //     catch (Exception e){
    //         fail("HamperCreator method threw an unexpected exception when given a date not contained within the data.");            
    //     }
    // }  

    /**
     * test buildHamper() 
     * builds the hamper constructor
     */
    @Test
    public void testBuildHamper(){
        Hamper testHamper = new Hamper(sampleFood);
        assertNotNull("BuildHamper did not create an object when given valid arguments.",
                testHamper);

    }
    }

