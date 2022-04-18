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
    int testID = 51;
    String testName = "Cantaloupe, dozen";
    int testGrainContent = 55;
    int testFvContent = 20;
    int testProContent = 30;
    int testOther = 25;
    int testCalories = 1000;

    //test Constructor
    public void testFoodItemConstructor(){
            FoodItem foodItemConstructor = new FoodItem(testID,testName,testGrainContent,
                                                        testFvContent,testProContent,testOther,testCalories);
            assertNotNull("FoodItem constructor did not create an object when given valid arguments.", 
                        foodItemConstructor);
    }

    // getItemID
    @Test 
        public void testGetItemID(){
            FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 0);
            int itemIDValue = ourInventory.getId();
            int expectedItemIDValue = 51;
            assertEquals("Method getItemID did not return the expected result:", expectedItemIDValue, itemIDValue);

    }

    // test for getName of inventory item
    @Test
        public void testGetName(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        String itemName = ourInventory.getName();
        String expectedName = "Cantaloupe, dozen";
        assertEquals("Method getName did not return the expected result:", expectedName, itemName);
    }

    // test for getGrain content for inventory item
    @Test 
        public void testGetGrain(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemGrain = ourInventory.getGrainContent();
        int expectedItemGrain = 0;
        assertEquals("Method getGrain did not return the expected result:", expectedItemGrain, itemGrain);
    }

    // test for getFruitsVeggies content for inventory item
    @Test 
        public void testGetFruitsVeggies(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemFV = ourInventory.getFVContent();
        int expectedItemFV = 100;
        assertEquals("Method getFruitsVeggies did not return the expected result:", expectedItemFV, itemFV);
    }

    // test for getProtein content for inventory item
    @Test 
        public void testGetProtein(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemProtein = ourInventory.getProContent();
        int expectedItemProtein = 0;
        assertEquals("Method getProtein did not return the expected result:", expectedItemProtein, itemProtein);
    }

    // test for getOtherContent for inventory item
    @Test 
        public void testGetOtherContent(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemOtherContent = ourInventory.getOther();
        int expectedItemOtherContent = 0;
        assertEquals("Method getOtherContent did not return the expected result:", expectedItemOtherContent, itemOtherContent);
    }

    // test for getCalories for inventory item
    @Test 
        public void testGetCalories(){
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemCalories = ourInventory.getCalories();
        int expectedCalories= 10;
        assertEquals("Method getCalories did not return the expected result:", expectedCalories, itemCalories);
    }
}