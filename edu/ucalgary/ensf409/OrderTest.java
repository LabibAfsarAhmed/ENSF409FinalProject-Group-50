package edu.ucalgary.ensf409;

/**
 @author Jannine Osman <a href="mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
         Sukriti Sharma <a href="mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
         Caroline Basta <a href="mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
         Labib Afsar Ahmed <a href="mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 @version       2.6
 @since         1.0
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class OrderTest {
    /**
     * initalize employee name
     * initialize local date
     * initialize requested family by creating a new array list from FamilyProfile
     * initialize sample food by creating a new array list from FoodItem
     * initialize food hampers #1 and #2
     * initialize the expected number of families from the requested families
     * creating a sample hamper from all families
     */
    String testEmployee = "Smith";
    LocalDate testDate = LocalDate.now();
    List<FamilyProfile> requestedFamilies = new ArrayList<FamilyProfile>();
    List<Hamper> initializeHampers = new ArrayList<Hamper>();
    List<FoodItem> sampleFood = new ArrayList<FoodItem>();
    List<FoodItem> foodHamper1 = createFoodItems1(sampleFood);
    List<FoodItem> foodHamper2 = createFoodItems2(sampleFood);
    List<FamilyProfile> expectedFamilies = createSampleFamilies(requestedFamilies);
    List<Hamper> testHampers = createSampleHampers(initializeHampers, foodHamper1, foodHamper2);

    /**
     * initlializes the sample list of requested families
     * @param requestedFamilies creates families from family profiles
     * @return requestedFamilies - returns the requested families created, 2
     */
    public List<FamilyProfile> createSampleFamilies(List<FamilyProfile> requestedFamilies){
        FamilyProfile family1 = new FamilyProfile(1,1,1,4,true);
        FamilyProfile family2 = new FamilyProfile(2, 1, 3, 0, false);
        requestedFamilies.add(family1);
        requestedFamilies.add(family2);
        return requestedFamilies;
    }

    /**
     * initializes the test hampers
     * @param hampers all hampers being made
     * @param food1 food hamper list #1
     * @param food2 food hamper list #2
     * @return hampers created
     */
    public List<Hamper> createSampleHampers(List<Hamper>hampers, List<FoodItem> food1, List<FoodItem> food2){
        Hamper hamper1 = new Hamper(food1);
        Hamper hamper2 = new Hamper(food2);
        hampers.add(hamper1);
        hampers.add(hamper2);
        return hampers;


    }
    /**
     * creates sample food for hamper1
     * @param sampleFood obtained from FoodItem list
     * the sample food contians: food id, food name, grain content, fruits and veggies content,
     * protein content, others, and calories per food item
     * @return sampleFood created
     */
    public List<FoodItem> createFoodItems1(List<FoodItem> sampleFood){
            FoodItem foodItem1 = new FoodItem(34, "Apple", 100,
                88, 23, 15, 1994);
            FoodItem foodItem2 = new FoodItem(14, "Tomato", 30,
                    80, 13, 10, 194);
            sampleFood.add(foodItem1);
            sampleFood.add(foodItem2);
            return sampleFood;
    }

    /**
     * creates sample food for hamper2
     * @param sampleFood obtained from FoodItem list
     * the sample food contians: food id, food name, grain content, fruits and veggies content,
     * protein content, others, and calories per food item
     * @return sampleFood created
     */
    public List<FoodItem> createFoodItems2(List<FoodItem> sampleFood) {
        FoodItem foodItem1 = new FoodItem(10, "Cherry", 0,
                100, 0, 0, 35);
        FoodItem foodItem2 = new FoodItem(14, "Tomato", 0,
                120, 0, 0, 39);
        FoodItem foodItem3 = new FoodItem(14, "Chicken", 0,
                0, 400, 0, 140);
        sampleFood.add(foodItem1);
        sampleFood.add(foodItem2);
        sampleFood.add(foodItem3);
        return sampleFood;
    }

    
    /**
     * test Order constructor
     * ensures that the constructor can create an object
     */
    @Test
    public void testOrderConstructor(){
        Order orderConstructor = new Order(testEmployee,expectedFamilies);
        assertNotNull("orderConstructor did not create an object when given valid arguments.",
                orderConstructor);
    }
    
    /**
     * test getRequestedFamilies()
     * test whether the created families were successfuly added
     */
    @Test
    public void testGetRequestedFamilies(){
        Order orderTest = new Order(testEmployee, expectedFamilies);
        List<FamilyProfile> expected = expectedFamilies;        //expected families are obtained from FamilyProfile
        List<FamilyProfile> found = orderTest.getRequestedFamilies();    //found number of families in the actual test
        assertEquals("Method getRequestedFamilies did not return the expected result: ", expected, found);

    }
    
    
    /**
     * test method toString()
     * to test if a string contains the information has been created
     */
    @Test
    public void testToString() {
        StringBuilder sb = new StringBuilder();
        assertNotNull("StringBuilder did not create a string.",
                sb);
    }
}
