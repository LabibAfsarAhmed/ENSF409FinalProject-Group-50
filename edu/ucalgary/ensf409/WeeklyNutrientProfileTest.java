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

public class WeeklyNutrientProfileTest {


    //sample data to test the code with
    //data used is arbitrary    
    long testWholeGrains = 55;
    long testFruitVeggies = 20;
    long testProtein = 30;
    long testOther = 25;
    long testCalories = 1000;

   
    //test constructor of WeeklyNutrientProfile
    //constructor has tested 5 arguments inside the weeklyNutrientConstructor variable
    //testing whether the WeeklyNutrientProfile constructor has successfully created an object or not
    @Test
    public void testWeeklyNutrientConstructor() {
        WeeklyNutrientProfile weeklyNutrientConstructor = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        assertNotNull("weeklyNutrient constructor did not create an object when given valid arguments.",
                weeklyNutrientConstructor);
    }

    //test method getWholeGrain()
    //DailyNeed has tested 7 arguments inside the dailyNeed variable
    //testing whether the the correct amount of whole grains has been returned based on the arbitrary testing values above       @Test
    public void testGetWholeGrain() {
        WeeklyNutrientProfile weeklyNutrient = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        long expectedValue = testWholeGrains;
        long foundValue = weeklyNutrient.getWholeGrain();
        assertEquals("Method getWholeGrain did not return the expected result: ", expectedValue, foundValue);
    }

    // test method getFruitsVeggies()
    @Test
    public void testGetFruitsVeggies() {
        WeeklyNutrientProfile weeklyNutrient = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        long expectedValue = testFruitVeggies;
        long foundValue = weeklyNutrient.getFruitVeggies();
        assertEquals("Method getFruitsVeggies did not return the expected result: ", expectedValue, foundValue);
    }

    // test method getProtein()
    @Test
    public void testGetProtein() {
        WeeklyNutrientProfile weeklyNutrient = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        long expectedValue = testProtein;
        long foundValue = weeklyNutrient.getProtein();
        assertEquals("Method getProtein did not return the expected result: ", expectedValue, foundValue);
    }

    // test method getOther()
    @Test
    public void testGetOther() {
        WeeklyNutrientProfile weeklyNutrient = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        long expectedValue = testOther;
        long foundValue = weeklyNutrient.getOther();
        assertEquals("Method getOther did not return the expected result: ", expectedValue, foundValue);
    }

    // test method getCalories()
    @Test
    public void testGetCalories() {
        WeeklyNutrientProfile weeklyNutrient = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        long expectedValue = testCalories;
        long foundValue = weeklyNutrient.getCalories();
        assertEquals("Method getCalories did not return the expected result: ", expectedValue, foundValue);
    }
}