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


public class ClientDailyNeedDataTest{
    int testFemales = 1;
    int testMales = 2;
    int testUnderEight = 3;
    int testOverEight = 4;
    boolean testWeeklyService = true;
    FamilyProfile family = new FamilyProfile(testFemales, testMales, testOverEight,
            testUnderEight, testWeeklyService);
    DailyNeed female = new DailyNeed(2, "Adult Female", 100, 90,200, 10,2000);
    DailyNeed male = new DailyNeed(1, "Adult Male", 120, 100, 300, 70, 2700);
    DailyNeed childrenOver8 = new DailyNeed(1, "Children Over 8", 60, 180, 100, 30, 3000);
    DailyNeed childrenUnder8 = new DailyNeed(1, "Children Under 8", 80, 380, 120, 40, 3400);

            //test constructor
   /* @Test
    public void calculateWeeklyFamilyNeeds(){

    } */
    //test calculateWeeklyFamilyWholeGrains()
    @Test
    public void testCalculateWeeklyFamilyWholeGrains(){
        //ClientDailyNeedData familyTest = new ClientDailyNeedData();
        long expected = 7*((testMales * 120) + (testFemales * 100)+ (testOverEight * 60) + (testUnderEight * 80));
        long found = ClientDailyNeedData.calculateWeeklyFamilyWholeGrains(family);
        assertEquals("Method CalculateWeeklyFamilyWholeGrains() did not return the expected result: ", expected, found);

    }

    //test calculateWeeklyFamilyFruitVeggies()
    @Test
    public void testCalculateWeeklyFamilyFruitVeggies(){

    }

    

}