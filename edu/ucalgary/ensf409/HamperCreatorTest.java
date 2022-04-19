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
    List<FamilyProfile> familiesRequested = new ArrayList<FamilyProfile>();
    List<Hamper> initializeHampers = new ArrayList<Hamper>();
    List<FoodItem> sampleFood = new ArrayList<FoodItem>();
    String sampleEmployee = "Sam";
    List<FamilyProfile> familiesExpected = createSampleFamilies(familiesRequested);
    
    Order order = new Order(sampleEmployee,familiesExpected);

    /**
     * this initlializes the sample list of requested families
     * create sameple and adds it to requested family list
     * @param familiesRequested is referencing the FamilyProfile class
     * @return familiesRequested
     */
    public List<FamilyProfile> createSampleFamilies(List<FamilyProfile> familiesRequested) {
        //an example of family that requires weekly service due to mobility issues
        FamilyProfile family1 = new FamilyProfile(1, 1, 1, 1, true); 
        //an example of family that doesn't require weekly service due to mobility issues
        FamilyProfile family2 = new FamilyProfile(2, 1, 0, 0, false);
        //adds family 1 and 2 into the requested family list
        familiesRequested.add(family1);
        familiesRequested.add(family2);
        return familiesRequested;
    }

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

