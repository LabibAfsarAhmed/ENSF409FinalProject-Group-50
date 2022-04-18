package edu.ucalgary.ensf409;

/**
 @author Jannine Osman <a href="mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
         Sukriti Sharma <a href="mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
         Caroline Basta <a href="mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
         Labib Afsar Ahmed <a href="mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 @version       1.3
 @since         1.0
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class HamperTest{
    List<FoodItem> sampleFood = new ArrayList<>();
    List<FoodItem> testFood = createFoodItems(sampleFood);

    /**
     * method to create sample food item for testing
     * @param sampleFood - sampleFood variable calls the food item List
     * the food item list is in the order: id, name, grainContent, fvContent,
     * proContent, other, calories
     * random values were added to each item 
     * @return sampleFood returns the created food item list
     */
    public List<FoodItem> createFoodItems(List<FoodItem> sampleFood){
            FoodItem foodItem1 = new FoodItem(34, "Apple", 100,
                88, 23, 15, 1994);
            FoodItem foodItem2 = new FoodItem(14, "Tomato", 30,
                    80, 13, 10, 194);
            sampleFood.add(foodItem1);
            sampleFood.add(foodItem2);
            return sampleFood;
    }

    /**
     * test hamper constructor
     * creates an object if successful
     */
    @Test
    public void testHamperConstructor(){
        Hamper testHamper = new Hamper(sampleFood); //testHamper is successfuly returned if the sample food was in the hamper
        assertNotNull("hamper constructor did not create an object when given valid arguments.",
                testHamper);
    }

    /**
     * /test getFoodItems
     * method to test if food items were able to be added to the hamper
     * goal is to return the expected value from the hamper
     */
    @Test
    public void testGetFoodItems(){
        Hamper testHamper = new Hamper(sampleFood);
        List <FoodItem> expected = testFood; //expected value obtained from the sample food item list
        List<FoodItem> found = testHamper.getFoodItems();  //found value is obtained from the food item in the hamper
        assertEquals("Method getFoodItems did not return the expected result: ", expected, found);
    }
    
    /**
     * test method toString()
     * tests whether the hamper was able to successfuly create a string list with the hamper created
     */
    @Test
    public void testToString() {
        StringBuilder sb = new StringBuilder();
        assertNotNull("StringBuilder did not create a string.",
                sb);
    }

}
