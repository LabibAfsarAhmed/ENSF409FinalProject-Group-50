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
import java.io.*;
import java.util.*;
public class DailyNeedTest{
        
        //sample data to test the code with
        //data used is arbitrary
        int testId = 30;
        String testClientType = "Adult Male";
        int testWholeGrains = 55;
        int testFruitVeggies = 20;
        int testProtein = 30;
        int testOther = 25;
        int testCalories = 1000;

        //test constructor of DailyNeed
        //constructor has tested 7 arguments inside the dailyNeedConstructor variable
        //testing whether the DailyNeed constructor has successfully created an object or not
        @Test
        public void testDailyNeedConstructor(){
                DailyNeed dailyNeedConstructor = new DailyNeed(testId,testClientType,testWholeGrains,
                                                               testFruitVeggies,testProtein,testOther,testCalories);
                assertNotNull("DailyNeed constructor did not create an object when given valid arguments.",
                                dailyNeedConstructor);
        }
        
        //test method getId
        //DailyNeed has tested 7 arguments inside the dailyNeed variable
        //testing whether the the correct ID has been returned based on the arbitrary testing values above   
        @Test
        public void testGetId(){
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
               int expectedValue = testId;          //expectedValue obtained from arbitrary values
               int foundValue = dailyNeed.getId(); //foundValue obtained from the DailyNeed class for getId
               assertEquals("Method getId did not return the expected result: ", expectedValue, foundValue);
        }
        
        //test method getClientType()
        //DailyNeed has tested 7 arguments inside the dailyNeed variable
        //testing whether the the correct client type has been returned based on the arbitrary testing values above   
        @Test
        public void testClientType() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                String expectedValue = testClientType;          //expectedValue obtained from arbitrary values
                String foundValue = dailyNeed.getClientType(); //foundValue obtained from DailyNeed class 
                assertEquals("Method getClientType did not return the expected result: ", expectedValue, foundValue);
        }
        
        //test method getWholeGrain()
        //DailyNeed has tested 7 arguments inside the dailyNeed variable
        //testing whether the the correct amount of whole grains has been returned based on the arbitrary testing values above   
        @Test
        public void testGetWholeGrain() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testWholeGrains;          //expectedValue obtained from arbitrary values
                int foundValue = dailyNeed.getWholeGrain();   //foundValue obtained from DailyNeed class for getWholeGrain
                assertEquals("Method getWholeGrain did not return the expected result: ", expectedValue, foundValue);
        }
        
        //test method getFruitsVeggies()
        //DailyNeed has tested 7 arguments inside the dailyNeed variable
        //testing whether the the correct amount of whole grains has been returned based on the arbitrary testing values above   
        @Test
        public void testGetFruitsVeggies() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testFruitVeggies;          //expectedValue obtained from arbitrary values
                int foundValue = dailyNeed.getFruitVeggies();  //foundValue obtained from DailyNeed class for getFruitVeggies
                assertEquals("Method getFruitsVeggies did not return the expected result: ", expectedValue, foundValue);
        }

        //test method getProtein()
        //DailyNeed has tested 7 arguments inside the dailyNeed variable
        //testing whether the the correct amount of protein has been returned based on the arbitrary testing values above   
        @Test
        public void testGetProtein() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testProtein;          //expectedValue obtained from arbitrary values
                int foundValue = dailyNeed.getProtein();  //foundValue obtained from DailyNeed class for getProtein
                assertEquals("Method getProtein did not return the expected result: ", expectedValue, foundValue);
        }
        
        // test method getOther()
        //DailyNeed has tested 7 arguments inside the dailyNeed variable
        //testing whether the the correct amount of other food items has been returned based on the arbitrary testing values above   
        @Test
        public void testGetOther() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testOther;         //expectedValue obtained from arbitrary values
                int foundValue = dailyNeed.getOther(); //foundValue obtained from DailyNeed class for getOther
                assertEquals("Method getOther did not return the expected result: ", expectedValue, foundValue);
        }
        
        // test method getCalories()
        //DailyNeed has tested 7 arguments inside the dailyNeed variable
        //testing whether the the correct amount of calories has been returned based on the arbitrary testing values above  
        @Test
        public void testGetCalories() {
                DailyNeed dailyNeed = new DailyNeed(testId, testClientType, testWholeGrains,
                                testFruitVeggies, testProtein, testOther, testCalories);
                int expectedValue = testCalories;         //expectedValue obtained from arbitrary values
                int foundValue = dailyNeed.getCalories(); //foundValue obtained from DailyNeed class for getCalories
                assertEquals("Method getCalories did not return the expected result: ", expectedValue, foundValue);
        }

        //test method toString()
        //test to ensure method toString in DailyNeed can properly create a string
        @Test
        public void testToString(){
                StringBuilder sb = new StringBuilder();
                assertNotNull("StringBuilder did not create a string.", sb);
        }
}