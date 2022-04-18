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
        int testId = 30;
        String testClientType = "Adult Male";
        int testWholeGrains = 55;
        int testFruitVeggies = 20;
        int testProtein = 30;
        int testOther = 25;
        int testCalories = 1000;

        //test constructor
        @Test
        public void testDailyNeedConstructor(){
                DailyNeed dailyNeedConstructor = new DailyNeed(testId,testClientType,testWholeGrains,
                                                               testFruitVeggies,testProtein,testOther,testCalories);
                assertNotNull("DailyNeed constructor did not create an object when given valid arguments.",
                                dailyNeedConstructor);
        }
        //test method getId()
        @Test
        public void testGetId(){
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
               int expectedValue = testId;
               int foundValue = dailyNeed.getId();
               assertEquals("Method getId did not return the expected result: ", expectedValue, foundValue);
        }
        
        // test method getClientType()
        @Test
        public void testClientType() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                String expectedValue = testClientType;
                String foundValue = dailyNeed.getClientType();
                assertEquals("Method getClientType did not return the expected result: ", expectedValue, foundValue);
        }
        
        // test method getWholeGrain()
        @Test
        public void testGetWholeGrain() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testWholeGrains;
                int foundValue = dailyNeed.getWholeGrain();
                assertEquals("Method getWholeGrain did not return the expected result: ", expectedValue, foundValue);
        }
        
        // test method getFruitsVeggies()
        @Test
        public void testGetFruitsVeggies() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testFruitVeggies;
                int foundValue = dailyNeed.getFruitVeggies();
                assertEquals("Method getFruitsVeggies did not return the expected result: ", expectedValue, foundValue);
        }

        // test method getProtein()
        @Test
        public void testGetProtein() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testProtein;
                int foundValue = dailyNeed.getProtein();
                assertEquals("Method getProtein did not return the expected result: ", expectedValue, foundValue);
        }
        
        // test method getOther()
        @Test
        public void testGetOther() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testOther;
                int foundValue = dailyNeed.getOther();
                assertEquals("Method getOther did not return the expected result: ", expectedValue, foundValue);
        }
        
        // test method getCalories()
        @Test
        public void testGetCalories() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testCalories;
                int foundValue = dailyNeed.getCalories();
                assertEquals("Method getCalories did not return the expected result: ", expectedValue, foundValue);
        }

        //test method toString()
        @Test
        public void testToString(){
                StringBuilder sb = new StringBuilder();
                assertNotNull("StringBuilder did not create a string.",
                                sb);
        }
}