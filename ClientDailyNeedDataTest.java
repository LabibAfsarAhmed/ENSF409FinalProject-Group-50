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
    

    // test calculateWeeklyFamilyWholeGrains()
    @Test
    public void testCalculateWeeklyFamilyWholeGrains(){
        //ClientDailyNeedData familyTest = new ClientDailyNeedData();
        long expected = 7*((testMales * maleDailyNeed.getWholeGrain()) + (testFemales * femaleDailyNeed.getWholeGrain())+ 
                                (testOverEight * childOverDailyNeed.getWholeGrain()) + (testUnderEight * childUnderDailyNeed.getWholeGrain()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyWholeGrains(family);
        assertEquals("Method CalculateWeeklyFamilyWholeGrains() did not return the expected result: ", expected, found);

    }

    //test calculateWeeklyFamilyFruitVeggies()
    @Test
    public void testCalculateWeeklyFamilyFruitVeggies(){

        long expected = 7* ((testMales * maleDailyNeed.getFruitVeggies()) + (testFemales * femaleDailyNeed.getFruitVeggies()) +
                        (testOverEight * childOverDailyNeed.getFruitVeggies())
                        + (testUnderEight * childUnderDailyNeed.getFruitVeggies()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyFruitVeggies(family);
        assertEquals("Method CalculateWeeklyFamilyWholeGrains() did not return the expected result: ", expected, found);
    } 

    // test calculateWeeklyFamilyProtein()
    @Test
    public void testCalculateWeeklyFamilyProtein() {

        long expected = 7
                * ((testMales * maleDailyNeed.getProtein()) + (testFemales * femaleDailyNeed.getProtein()) +
                        (testOverEight * childOverDailyNeed.getProtein())
                        + (testUnderEight * childUnderDailyNeed.getProtein()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyProtein(family);
        assertEquals("Method CalculateWeeklyFamilyProtein() did not return the expected result: ", expected, found);
    }

    // test calculateWeeklyOther()
    @Test
    public void testCalculateWeeklyFamilyOther() {

        long expected = 7
                * ((testMales * maleDailyNeed.getOther()) + (testFemales * femaleDailyNeed.getOther()) +
                        (testOverEight * childOverDailyNeed.getOther())
                        + (testUnderEight * childUnderDailyNeed.getOther()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyOther(family);
        assertEquals("Method CalculateWeeklyFamilyOther() did not return the expected result: ", expected, found);
    }

    // test calculateWeeklyFamilyTotalCalories()
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