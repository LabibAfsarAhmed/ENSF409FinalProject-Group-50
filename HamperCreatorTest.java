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
import java.io.*;
import java.util.ArrayList;


public class HamperCreatorTest{
    List<FamilyProfile> requestedFamilies = new ArrayList<FamilyProfile>();
    List<Hamper> initializeHampers = new ArrayList<Hamper>();
    List<FoodItem> sampleFood = new ArrayList<FoodItem>();
    String testEmployee = "Sam";
    List<FamilyProfile> expectedFamilies = createSampleFamilies(requestedFamilies);
    List<FamilyProfile> badFamilies = createSampleFamiliesBad(requestedFamilies);
    Order order = new Order(testEmployee,expectedFamilies);
    //Order badOrder = new Order(testEmployee, badFamilies);

    // this initlializes the sample list of requested families
    public List<FamilyProfile> createSampleFamilies(List<FamilyProfile> requestedFamilies) {
        FamilyProfile family1 = new FamilyProfile(1, 1, 1, 1, true);
        FamilyProfile family2 = new FamilyProfile(2, 1, 0, 0, false);
        requestedFamilies.add(family1);
        requestedFamilies.add(family2);
        return requestedFamilies;
    }
    //create bad data
    public List<FamilyProfile> createSampleFamiliesBad(List<FamilyProfile> requestedFamilies) {
        FamilyProfile family1 = new FamilyProfile(321, 1, 13, 1, true);
        FamilyProfile family2 = new FamilyProfile(42, 19, 0, 0, false);
        requestedFamilies.add(family1);
        requestedFamilies.add(family2);
        return requestedFamilies;
    }



    //test constructor
  /*  @Test
    public void testHamperCreator(){
        HamperCreator testCreator = new HamperCreator(order);
        assertNotNull("HamperConstructor did not create an object when given valid arguments.",
                testCreator);
    } */


    @Test
    public void testRunTimeException(){
        Order badOrder = new Order(testEmployee, badFamilies);
        HamperCreator testCreate = new HamperCreator(badOrder);
        try{
            //long totalGrain = 10000000;
            long expected = InventoryData.getTotalGrain();
            fail("HamperCreator method did not throw RunTimeException when given a date not contained within the data.");
        }
        catch (RuntimeException e){
            assertTrue(true);
        }
        catch (Exception e){
            fail("HamperCreator method threw an unexpected exception when given a date not contained within the data.");            
        }
    }
       

    }

