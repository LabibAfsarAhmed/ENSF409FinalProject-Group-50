package edu.ucalgary.ensf409;

/**
 @author Jannine Osman <a href="mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
         Sukriti Sharma <a href="mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
         Caroline Basta <a href="mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
         Labib Afsar Ahmed <a href="mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 @version       1.4
 @since         1.0
 */

import static org.junit.Assert.*;
import org.junit.*;


public class FoodItemTest{
    //testing data
    int testID = 51;
    String testName = "Cantaloupe, dozen";
    int testGrainContent = 55;
    int testFvContent = 20;
    int testProContent = 30;
    int testOther = 25;
    int testCalories = 1000;
  
    /**
     * test Constructor for FoodItem class
     * FoodItem constructor is testing the validity of the 7 arguments
     * stored under foodItemConstructor
     * testing whether the FoodItem constructor returns an object when called properly
     */
    public void testFoodItemConstructor(){
            FoodItem foodItemConstructor = new FoodItem(testID,testName,testGrainContent,
                                                        testFvContent,testProContent,testOther,testCalories);
            assertNotNull("FoodItem constructor did not create an object when given valid arguments.", 
                        foodItemConstructor);
    }

    /**
     * test ItemID 
     * itemID should return the correct food ID when called properly
     * test passes when the expected item ID is found, and testing to see if it matches with the ID in the database
     */
    @Test 
        public void testGetItemID(){
            FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 0);
            int itemIDValue = ourInventory.getId();
            int expectedItemIDValue = 51;
            assertEquals("Method getItemID did not return the expected result:", expectedItemIDValue, itemIDValue);

    }

     /**
     *  test for getName of inventory item
     * getName should return the correct food name when called properly
     * test passes when the expected item name is found, and testing to see if it matches with the name in the database
     */
    @Test
        public void testGetName(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        String itemName = ourInventory.getName();
        String expectedName = "Cantaloupe, dozen";
        assertEquals("Method getName did not return the expected result:", expectedName, itemName);
    }

    /**
     * test for getGrain content for inventory item
     * getGrain should return the correct grain when called properly
     * test passes when the expected grain name is found, and testing to see if it matches with the grain in the database
     */
    @Test 
        public void testGetGrain(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemGrain = ourInventory.getGrainContent();
        int expectedItemGrain = 0;
        assertEquals("Method getGrain did not return the expected result:", expectedItemGrain, itemGrain);
    }

    /**
     * test for getFruitsVeggies content for inventory item
     * getFruitsVeggies should return the correct fruits and vegetable when called properly
     * test passes when the expected fruits and vegetable name is found, and testing to see if it matches with the fruits and vegetable in the database
     */
    @Test 
        public void testGetFruitsVeggies(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemFV = ourInventory.getFVContent();
        int expectedItemFV = 100;
        assertEquals("Method getFruitsVeggies did not return the expected result:", expectedItemFV, itemFV);
    }

    /**
     * test for getProtein content for inventory item
     * getProtein should return the correct protein when called properly
     * test passes when the expected item protein is found, and testing to see if it matches with the protein in the database
     */
    @Test 
        public void testGetProtein(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemProtein = ourInventory.getProContent();
        int expectedItemProtein = 0;
        assertEquals("Method getProtein did not return the expected result:", expectedItemProtein, itemProtein);
    }

     /**
     * test for getOtherContent for inventory item
     * getOtherContent should return the correct other content when called properly
     * test passes when the expected other content is found, and testing to see if it matches with the other content in the database
     */
    @Test 
        public void testGetOtherContent(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemOtherContent = ourInventory.getOther();
        int expectedItemOtherContent = 0;
        assertEquals("Method getOtherContent did not return the expected result:", expectedItemOtherContent, itemOtherContent);
    }

    /**
     * test for getCalories for inventory item
     * getCalories should return the correct calorie content when called properly
     * test passes when the expected calorie content of a particular food item is found, 
     * and testing to see if it matches with the calorie in the database
     */
    @Test 
        public void testGetCalories(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemCalories = ourInventory.getCalories();
        int expectedCalories= 10;
        assertEquals("Method getCalories did not return the expected result:", expectedCalories, itemCalories);
    }
}