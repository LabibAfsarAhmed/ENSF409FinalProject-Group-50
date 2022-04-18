package edu.ucalgary.ensf409;

/**
 @author Jannine Osman <a href="mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
         Sukriti Sharma <a href="mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
         Caroline Basta <a href="mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
         Labib Afsar Ahmed <a href="mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 @version       1.8
 @since         1.0
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.sql.*;


public class ClientDailyNeedDataTest{
    /**
     * this creates the composition of each family
     * boolean for weekly service needed is initially true 
     * the number of each family member get passed to the family profile to create the family
     * the client ID is obtained from the getter in the ClientDailyNeedData file
     */
    int testFemales = 2;
    int testMales = 2;
    int testUnderEight = 1;
    int testOverEight = 3;
    boolean testWeeklyService = true;
    FamilyProfile family = new FamilyProfile(testFemales, testMales, testOverEight,
            testUnderEight, testWeeklyService);
    
    DailyNeed maleDailyNeed = ClientDailyNeedData.getDailyNeed(1);
    DailyNeed femaleDailyNeed = ClientDailyNeedData.getDailyNeed(2);
    DailyNeed childOverDailyNeed = ClientDailyNeedData.getDailyNeed(3);
    DailyNeed childUnderDailyNeed = ClientDailyNeedData.getDailyNeed(4);
    

    /**
     * test calculateWeeklyFamilyWholeGrains()
     * takes amount of grains per food item and multiplies it by each family member's daily needs
     * then, this value is multiplied by 7 for the the whole week
     * this process is repeated for every family member 
     */
    @Test
    public void testCalculateWeeklyFamilyWholeGrains(){
        //ClientDailyNeedData familyTest = new ClientDailyNeedData();
        long expected = 7*((testMales * maleDailyNeed.getWholeGrain()) + (testFemales * femaleDailyNeed.getWholeGrain())+ 
                                (testOverEight * childOverDailyNeed.getWholeGrain()) + (testUnderEight * childUnderDailyNeed.getWholeGrain()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyWholeGrains(family);
        assertEquals("Method CalculateWeeklyFamilyWholeGrains() did not return the expected result: ", expected, found);

    }

    /**
     * test calculateWeeklyFamilyFruitVeggies()
     * takes amount of fruits and vegetables per food item and multiplies it by each family member's daily needs
     * then, this value is multiplied by 7 for the the whole week
     * this process is repeated for every family member 
     */
    @Test
    public void testCalculateWeeklyFamilyFruitVeggies(){

        long expected = 7* ((testMales * maleDailyNeed.getFruitVeggies()) + (testFemales * femaleDailyNeed.getFruitVeggies()) +
                        (testOverEight * childOverDailyNeed.getFruitVeggies())
                        + (testUnderEight * childUnderDailyNeed.getFruitVeggies()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyFruitVeggies(family);
        assertEquals("Method CalculateWeeklyFamilyWholeGrains() did not return the expected result: ", expected, found);
    } 


     /**
     * test calculateWeeklyFamilyProtein()
     * takes amount of protein per food item and multiplies it by each family member's daily needs
     * then, this value is multiplied by 7 for the the whole week
     * this process is repeated for every family member 
     */
    @Test
    public void testCalculateWeeklyFamilyProtein() {

        long expected = 7
                * ((testMales * maleDailyNeed.getProtein()) + (testFemales * femaleDailyNeed.getProtein()) +
                        (testOverEight * childOverDailyNeed.getProtein())
                        + (testUnderEight * childUnderDailyNeed.getProtein()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyProtein(family);
        assertEquals("Method CalculateWeeklyFamilyProtein() did not return the expected result: ", expected, found);
    }

     /**
     * test calculateWeeklyOther()
     * takes amount of other food items and multiplies it by each family member's daily needs
     * then, this value is multiplied by 7 for the the whole week
     * this process is repeated for every family member 
     */
    @Test
    public void testCalculateWeeklyFamilyOther() {

        long expected = 7
                * ((testMales * maleDailyNeed.getOther()) + (testFemales * femaleDailyNeed.getOther()) +
                        (testOverEight * childOverDailyNeed.getOther())
                        + (testUnderEight * childUnderDailyNeed.getOther()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyOther(family);
        assertEquals("Method CalculateWeeklyFamilyOther() did not return the expected result: ", expected, found);
    }

     /**
     * test calculateWeeklyFamilyTotalCalories()
     * takes amount of calories per food item and multiplies it by each family member's daily needs
     * then, this value is multiplied by 7 for the the whole week
     * this process is repeated for every family member 
     */
    @Test
    public void testCalculateWeeklyFamilyTotalCalories() {

        long expected = 7
                * ((testMales * maleDailyNeed.getCalories()) + (testFemales * femaleDailyNeed.getCalories()) +
                        (testOverEight * childOverDailyNeed.getCalories())
                        + (testUnderEight * childUnderDailyNeed.getCalories()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyTotalCalories(family);
        assertEquals("Method CalculateWeeklyFamilyTotalCalories() did not return the expected result: ", expected, found);
    }

}