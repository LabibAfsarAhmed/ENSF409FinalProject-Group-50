package edu.ucalgary.ensf409;

/**
 * @author Jannine Osman <a href=
 *         "mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
 *         Sukriti Sharma <a href=
 *         "mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
 *         Caroline Basta <a href=
 *         "mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
 *         Labib Afsar Ahmed <a href=
 *         "mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 * @version 1.5
 * @since 1.0
 */

import static org.junit.Assert.*;
import org.junit.*;

public class FamilyProfileTest{
    //sample data
    int testFemales =1;
    int testMales =2;
    int testUnderEight =3;
    int testOverEight =4;
    boolean testWeeklyService = true;
    WeeklyNutrientProfile testWeeklyNutrientProfile = new WeeklyNutrientProfile(100,
            110, 20, 60, 1100);

    // test constructor
    @Test
    public void testFamilyProfileConstructor() {
        FamilyProfile familyProfileConstructor = new FamilyProfile(testFemales,testMales,testOverEight,
                                                                 testUnderEight,testWeeklyService);
        assertNotNull("familyProfileConstructor constructor did not create an object when given valid arguments.",
                familyProfileConstructor);
        
    }
    //test getAdultFemales()
    @Test
    public void testGetAdultFemales(){
        FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                                           testUnderEight, testWeeklyService);
        int expectedValue = testFemales;
        int foundValue = familyProfile.getAdultFemales();
        assertEquals("Method getAdultFemales did not return the expected result: ", expectedValue, foundValue);
    }

    // test getAdultMales()
    @Test
    public void testGetAdultMales() {
        FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                testUnderEight, testWeeklyService);
        int expectedValue = testMales;
        int foundValue = familyProfile.getAdultMales();
        assertEquals("Method getAdultMales did not return the expected result: ", expectedValue, foundValue);
    }

    // test getChildrenOver8()
    @Test
    public void testGetChildrenOver8() {
        FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                testUnderEight, testWeeklyService);
        int expectedValue = testOverEight;
        int foundValue = familyProfile.getChildrenOver8();
        assertEquals("Method getChildrenOver8 did not return the expected result: ", expectedValue, foundValue);
    }

    // test getChildrenUnder8()
    @Test
    public void testGetChildrenUnder8() {
        FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                testUnderEight, testWeeklyService);
        int expectedValue = testUnderEight;
        int foundValue = familyProfile.getChildrenUnder8();
        assertEquals("Method getChildrenUnder8 did not return the expected result: ", expectedValue, foundValue);
    }

    // test getWeeklyServiceHampers()
    @Test
    public void testWeeklyServiceHampers() {
        FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                testUnderEight, testWeeklyService);
        boolean expectedValue = testWeeklyService;
        boolean foundValue = familyProfile.getWeeklyServiceHampers();
        assertEquals("Method getWeeklyServiceHampers did not return the expected result: ", expectedValue, foundValue);
    }

    // test getWeeklyNutrientProfile()
    @Test
    public void testGetWeeklyNutrientProfile() {   //NOT PASSING!!!!!!
        FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                testUnderEight, testWeeklyService);
        WeeklyNutrientProfile expectedValue = testWeeklyNutrientProfile;
        WeeklyNutrientProfile foundValue = familyProfile.getWeeklyNutrientProfile();
        assertEquals("Method getWeeklyNutrientProfile did not return the expected result: ", expectedValue, foundValue);
    }
    
    // test setWeeklyNutrientProfile()
    @Test
    public void testSetWeeklyNutrientProfile() {
        FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                testUnderEight, testWeeklyService);
        WeeklyNutrientProfile testProfile = new WeeklyNutrientProfile(90,
                100, 60, 20, 1400);
        familyProfile.setWeeklyNutrientProfile(testProfile);
        WeeklyNutrientProfile expectedValue = testProfile;
        WeeklyNutrientProfile foundValue = familyProfile.getWeeklyNutrientProfile();
        assertEquals("Method setWeeklyNutrientProfile did not return the expected result: ", expectedValue, foundValue);
    }

    // test method toString()
    @Test
    public void testToString() {
        StringBuilder sb = new StringBuilder();
        assertNotNull("StringBuilder did not create a string.",
                sb);
    }
}
