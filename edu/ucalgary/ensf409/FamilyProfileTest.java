package edu.ucalgary.ensf409;

/**
 @author Jannine Osman <a href="mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
         Sukriti Sharma <a href="mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
         Caroline Basta <a href="mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
         Labib Afsar Ahmed <a href="mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 @version       1.5
 @since         1.0
 */

import static org.junit.Assert.*;
import org.junit.*;

public class FamilyProfileTest {
        // sample data for testing
        // initializing number of family members
        int testFemales = 1;
        int testMales = 2;
        int testUnderEight = 3;
        int testOverEight = 4;
        boolean testWeeklyService = false; // initializing weekly services
        WeeklyNutrientProfile testWeeklyNutrientProfile = new WeeklyNutrientProfile(100,
                        110, 20, 60, 1100); // random sample data for testing

        /**
         * test FamilyProfile constructor
         * to ensure that the constructor creates an object when the 5 arguments in
         * FamilyProfile are called correctly
         */
        @Test
        public void testFamilyProfileConstructor() {
                FamilyProfile familyProfileConstructor = new FamilyProfile(testFemales, testMales, testOverEight,
                                testUnderEight, testWeeklyService);
                assertNotNull("familyProfileConstructor constructor did not create an object when given valid arguments.",
                                familyProfileConstructor);

        }

        /**
         * test getAdultFemales()
         * test the getter method to ensure proper retrieval of adult female information
         * from family profile
         */
        @Test
        public void testGetAdultFemales() {
                FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                                testUnderEight, testWeeklyService);
                int expectedValue = testFemales;
                int foundValue = familyProfile.getAdultFemales();
                // checks against the initialized values above
                assertEquals("Method getAdultFemales did not return the expected result: ", expectedValue, foundValue);
        }

        /**
         * test getAdultMales()
         * test the getter method to ensure proper retrieval of adult male information
         * from family profile
         */
        @Test
        public void testGetAdultMales() {
                FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                                testUnderEight, testWeeklyService);
                int expectedValue = testMales;
                int foundValue = familyProfile.getAdultMales();
                // checks against the initialized values above
                assertEquals("Method getAdultMales did not return the expected result: ", expectedValue, foundValue);
        }

        /**
         * test getChildrenOver8()
         * test the getter method to ensure proper retrieval of children over 8
         * information from family profile
         */
        @Test
        public void testGetChildrenOver8() {
                FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                                testUnderEight, testWeeklyService);
                int expectedValue = testOverEight;
                int foundValue = familyProfile.getChildrenOver8();
                // checks against the initialized values above
                assertEquals("Method getChildrenOver8 did not return the expected result: ", expectedValue, foundValue);
        }

        /**
         * test getChildrenUnder8()
         * test the getter method to ensure proper retrieval of children under 8
         * information from family profile
         */
        @Test
        public void testGetChildrenUnder8() {
                FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                                testUnderEight, testWeeklyService);
                int expectedValue = testUnderEight;
                int foundValue = familyProfile.getChildrenUnder8();
                // checks against the initialized values above
                assertEquals("Method getChildrenUnder8 did not return the expected result: ", expectedValue,
                                foundValue);
        }

        /**
         * test getWeeklyServiceHampers()
         * test the getter method to ensure that the weekly service for users with
         * mobility issues is properly created
         */
        @Test
        public void testWeeklyServiceHampers() {
                FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                                testUnderEight, testWeeklyService); // create a new family profile using testing numbers
                                                                    // from above
                boolean expectedValue = testWeeklyService;
                boolean foundValue = familyProfile.getWeeklyServiceHampers(); // would test if the family needed a
                                                                              // weekly service
                assertEquals("Method getWeeklyServiceHampers did not return the expected result: ", expectedValue,
                                foundValue);
        }

        /**
         * test setWeeklyNutrientProfile()
         * checks if the weekly nutrient profile for the family has been created
         */
        @Test
        public void testSetWeeklyNutrientProfile() {
                FamilyProfile familyProfile = new FamilyProfile(testFemales, testMales, testOverEight,
                                testUnderEight, testWeeklyService); // create a new family profile using testing numbers
                                                                    // from above
                WeeklyNutrientProfile testProfile = new WeeklyNutrientProfile(90,
                                100, 60, 20, 1400); // data for testing
                familyProfile.setWeeklyNutrientProfile(testProfile);
                WeeklyNutrientProfile expectedValue = testProfile; // expected value is from the testing data
                WeeklyNutrientProfile foundValue = familyProfile.getWeeklyNutrientProfile();
                assertEquals("Method setWeeklyNutrientProfile did not return the expected result: ", expectedValue,
                                foundValue);
        }

        /**
         * test method toString()
         * test if StringBuilder was able to create a string from the retrieved
         * information
         */
        @Test
        public void testFamilyProfileToString() {
                StringBuilder sb = new StringBuilder();
                assertNotNull("StringBuilder did not create a string.", sb);
        }
}
