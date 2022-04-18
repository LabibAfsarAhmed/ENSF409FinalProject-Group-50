/**
 * @author Jannine Osman <a href=
 *         "mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
 *         Sukriti Sharma <a href=
 *         "mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
 *         Caroline Basta <a href=
 *         "mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
 *         Labib Afsar Ahmed <a href=
 *         "mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 * @version 1.3
 * @since 1.0
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

public class HamperTest{
    List<FoodItem> sampleFood = new ArrayList<>();
    List<FoodItem> testFood = createFoodItems(sampleFood);

    public List<FoodItem> createFoodItems(List<FoodItem> sampleFood){
            FoodItem foodItem1 = new FoodItem(34, "Apple", 100,
                88, 23, 15, 1994);
            FoodItem foodItem2 = new FoodItem(14, "Tomato", 30,
                    80, 13, 10, 194);
            sampleFood.add(foodItem1);
            sampleFood.add(foodItem2);
            return sampleFood;
    }
    //test hamper constructor
    @Test
    public void testHamperConstructor(){
        Hamper testHamper = new Hamper(sampleFood);
        assertNotNull("hamper constructor did not create an object when given valid arguments.",
                testHamper);
    }

    //test getFoodItems
    @Test
    public void testGetFoodItems(){
        Hamper testHamper = new Hamper(sampleFood);
        List <FoodItem> expected = testFood;
        List<FoodItem> found = testHamper.getFoodItems();
        assertEquals("Method getFoodItems did not return the expected result: ", expected, found);
    }
    
    // test method toString()
    @Test
    public void testToString() {
        StringBuilder sb = new StringBuilder();
        assertNotNull("StringBuilder did not create a string.",
                sb);
    }

}
