
/**
 * @author Jannine Osman <a href=
 *         "mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
 *         Sukriti Sharma <a href=
 *         "mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
 *         Caroline Basta <a href=
 *         "mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
 *         Labib Afsar Ahmed <a href=
 *         "mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 * @version 2.3
 * @since 1.0
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class HamperCreatorTest{
    List<FamilyProfile> requestedFamilies = new ArrayList<FamilyProfile>();
    List<Hamper> initializeHampers = new ArrayList<Hamper>();
    List<FoodItem> sampleFood = new ArrayList<FoodItem>();
    String testEmployee = "Sam";
    List<FamilyProfile> expectedFamilies = createSampleFamilies(requestedFamilies);
    Order order = new Order(testEmployee,expectedFamilies);
    

    // this initlializes the sample list of requested families
    public List<FamilyProfile> createSampleFamilies(List<FamilyProfile> requestedFamilies) {
        FamilyProfile family1 = new FamilyProfile(1, 1, 1, 4, true);
        FamilyProfile family2 = new FamilyProfile(2, 1, 3, 0, false);
        requestedFamilies.add(family1);
        requestedFamilies.add(family2);
        return requestedFamilies;
    }



    //test constructor
    @Test
    public void testHamperCreator(){
        HamperCreator testCreator = new HamperCreator(order);
        assertNotNull("HamperConstructor did not create an object when given valid arguments.",
                testCreator);
    }
}
