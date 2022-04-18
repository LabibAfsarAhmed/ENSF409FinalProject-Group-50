package edu.ucalgary.ensf409;

/**
 @author Jannine Osman <a href="mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
         Sukriti Sharma <a href="mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
         Caroline Basta <a href="mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
         Labib Afsar Ahmed <a href="mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 @version       1.6
 @since         1.0
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;
public class DailyNeedTest{
        
        //sample data
        //this data is used for testing
        int testId = 30;
        String testClientType = "Adult Male";
        int testWholeGrains = 55;
        int testFruitVeggies = 20;
        int testProtein = 30;
        int testOther = 25;
        int testCalories = 1000;

        /**
         * test Constructor for DailyNeed class
         * DailyNeed constructor is testing the validity of the 7 arguments
         * stored under dailyNeedConstructor
         * testing whether the DailyNeed constructor returns an object when called properly
         */        
        @Test
        public void testDailyNeedConstructor(){
                DailyNeed dailyNeedConstructor = new DailyNeed(testId,testClientType,testWholeGrains,
                                                               testFruitVeggies,testProtein,testOther,testCalories);
                assertNotNull("DailyNeed constructor did not create an object when given valid arguments.",
                                dailyNeedConstructor);
        }
        
         /**
         * test method getId()
         * getId should return the correct food ID when called properly
         * test passes when the expected item ID is found, and testing to see if it matches with the ID in the database
         */
        @Test
        public void testGetId(){
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
               int expectedValue = testId;
               int foundValue = dailyNeed.getId();
               assertEquals("Method getId did not return the expected result: ", expectedValue, foundValue);
        }
        
         /**
         * test method getClientType()
         * getClientType should return the correct type of family member when called properly
         * test passes when the expected member is found, and testing to see if it matches with the family member in the database
         */
        @Test
        public void testClientType() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                String expectedValue = testClientType;
                String foundValue = dailyNeed.getClientType();
                assertEquals("Method getClientType did not return the expected result: ", expectedValue, foundValue);
        }
        
         /**
         * test method getWholeGrain()
         * getWholeGrain should return the correct type of family member when called properly
         * test passes when the expected whole grain is found, and testing to see if it matches with the whole grain in the database
         */
        @Test
        public void testGetWholeGrain() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testWholeGrains;
                int foundValue = dailyNeed.getWholeGrain();
                assertEquals("Method getWholeGrain did not return the expected result: ", expectedValue, foundValue);
        }
        
         /**
         * test method getFruitsVeggies()
         * getFruitsVeggies should return the correct type of family member when called properly
         * test passes when the expected fruits and vegetable is found, and testing to see if it matches with the fruits and vegetable in the database
         */
        @Test
        public void testGetFruitsVeggies() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testFruitVeggies;
                int foundValue = dailyNeed.getFruitVeggies();
                assertEquals("Method getFruitsVeggies did not return the expected result: ", expectedValue, foundValue);
        }

         /**
         * test method getProtein()
         * getProtein should return the correct type of family member when called properly
         * test passes when the expected protein is found, and testing to see if it matches with the protein in the database
         */
        @Test
        public void testGetProtein() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testProtein;
                int foundValue = dailyNeed.getProtein();
                assertEquals("Method getProtein did not return the expected result: ", expectedValue, foundValue);
        }
        
         /**
         * test method getOther()
         * getOther should return the correct type of family member when called properly
         * test passes when the expected other food item is found, and testing to see if it matches with the other in the database
         */
        @Test
        public void testGetOther() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testOther;
                int foundValue = dailyNeed.getOther();
                assertEquals("Method getOther did not return the expected result: ", expectedValue, foundValue);
        }
        
        /**
         * test method getCalories()
         * getCalories() should return the correct type of family member when called properly
         * test passes when the expected calorie content is found, and testing to see if it matches with the calories in the database
         */
        @Test
        public void testGetCalories() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testCalories;
                int foundValue = dailyNeed.getCalories();
                assertEquals("Method getCalories did not return the expected result: ", expectedValue, foundValue);
        }

         /**
         * test method toString()
         * this method tests if a string is correctly created
         */
        @Test
        public void testToString(){
                StringBuilder sb = new StringBuilder();
                assertNotNull("StringBuilder did not create a string.",
                                sb);
        }
}