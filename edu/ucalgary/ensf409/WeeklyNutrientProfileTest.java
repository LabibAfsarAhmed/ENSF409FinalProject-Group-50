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
    //sample data for testing
    long testWholeGrains = 55;
    long testFruitVeggies = 20;
    long testProtein = 30;
    long testOther = 25;
    long testCalories = 1000;

    /**
     * test WeeklyNutrientconstructor
     * check if the constructor creates an object when the 5 arguments are valid
     */
    @Test
    public void testWeeklyNutrientConstructor() {
        WeeklyNutrientProfile weeklyNutrientConstructor = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        assertNotNull("weeklyNutrient constructor did not create an object when given valid arguments.",
                weeklyNutrientConstructor);
    }

     /**
     * test method getWholeGrain()
     * checks if the family needs of whole grains for the entire week has been met 
     */
    @Test
    public void testWeeklyGetWholeGrain() {
        WeeklyNutrientProfile weeklyNutrient = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        long expectedValue = testWholeGrains;   //expected value obtained from data above
        long foundValue = weeklyNutrient.getWholeGrain(); 
        assertEquals("Method getWholeGrain did not return the expected result: ", expectedValue, foundValue);
    }

    /**
     * test method getFruitsVeggies()
     * checks if the family needs of fruits and vegetables for the entire week has been met 
     */
    @Test
    public void testWeeklyGetFruitsVeggies() {
        WeeklyNutrientProfile weeklyNutrient = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        long expectedValue = testFruitVeggies;
        long foundValue = weeklyNutrient.getFruitVeggies(); //expected value obtained from data above
        assertEquals("Method getFruitsVeggies did not return the expected result: ", expectedValue, foundValue);
    }

     /**
     * test method getProtein()
     * checks if the family needs of protein for the entire week has been met 
     */
    @Test
    public void testWeeklyGetProtein() {
        WeeklyNutrientProfile weeklyNutrient = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        long expectedValue = testProtein;
        long foundValue = weeklyNutrient.getProtein(); //expected value obtained from data above
        assertEquals("Method getProtein did not return the expected result: ", expectedValue, foundValue);
    }

     /**
     * test method getOther()
     * checks if the family needs of other food items for the entire week has been met 
     */
    @Test
    public void testWeeklyGetOther() {
        WeeklyNutrientProfile weeklyNutrient = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        long expectedValue = testOther;
        long foundValue = weeklyNutrient.getOther(); //expected value obtained from data above
        assertEquals("Method getOther did not return the expected result: ", expectedValue, foundValue);
    }

    /**
     * test method getCalories()
     * checks if the family needs of calories food items for the entire week has been met 
     */
    @Test
    public void testWeeklyGetCalories() {
        WeeklyNutrientProfile weeklyNutrient = new WeeklyNutrientProfile(testWholeGrains,
                testFruitVeggies, testProtein, testOther, testCalories);
        long expectedValue = testCalories;
        long foundValue = weeklyNutrient.getCalories(); //expected value obtained from data above
        assertEquals("Method getCalories did not return the expected result: ", expectedValue, foundValue);
    }
}
