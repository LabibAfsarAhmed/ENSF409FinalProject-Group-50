package edu.ucalgary.ensf409;

import static org.junit.Assert.*;
import org.junit.*;
public class TestFiles {

    //ClientDailyNeedDataTest
    /**
     * this creates the composition of each family
     * boolean for weekly service needed is initially true
     * the number of each family member get passed to the family profile to create
     * the family
     * the client ID is obtained from the getter in the ClientDailyNeedData file
     */
    int FemalesClient = 2;
    int MalesClient = 2;
    int clientUnderEight = 1;
    int clientOverEight = 3;
    boolean testWeeklyService = true;
    FamilyProfile family = new FamilyProfile(FemalesClient, MalesClient, clientOverEight,
            clientUnderEight, testWeeklyService);

    DailyNeed maleDailyNeed = ClientDailyNeedData.getDailyNeed(1);
    DailyNeed femaleDailyNeed = ClientDailyNeedData.getDailyNeed(2);
    DailyNeed childOverDailyNeed = ClientDailyNeedData.getDailyNeed(3);
    DailyNeed childUnderDailyNeed = ClientDailyNeedData.getDailyNeed(4);

    /**
     * test calculateWeeklyFamilyWholeGrains()
     * takes amount of grains per food item and multiplies it by each family
     * member's daily needs
     * then, this value is multiplied by 7 for the the whole week
     * this process is repeated for every family member
     */
    @Test
    public void testCalculateWeeklyFamilyWholeGrains() {
        // ClientDailyNeedData familyTest = new ClientDailyNeedData();
        long expected = 7
                * ((MalesClient * maleDailyNeed.getWholeGrain()) + (FemalesClient * femaleDailyNeed.getWholeGrain()) +
                        (clientOverEight * childOverDailyNeed.getWholeGrain())
                        + (clientUnderEight * childUnderDailyNeed.getWholeGrain()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyWholeGrains(family);
        assertEquals("Method CalculateWeeklyFamilyWholeGrains() did not return the expected result: ", expected, found);

    }

    /**
     * test calculateWeeklyFamilyFruitVeggies()
     * takes amount of fruits and vegetables per food item and multiplies it by each
     * family member's daily needs
     * then, this value is multiplied by 7 for the the whole week
     * this process is repeated for every family member
     */
    @Test
    public void testCalculateWeeklyFamilyFruitVeggies() {

        long expected = 7 * ((MalesClient * maleDailyNeed.getFruitVeggies())
                + (FemalesClient * femaleDailyNeed.getFruitVeggies()) +
                (clientOverEight * childOverDailyNeed.getFruitVeggies())
                + (clientUnderEight * childUnderDailyNeed.getFruitVeggies()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyFruitVeggies(family);
        assertEquals("Method CalculateWeeklyFamilyWholeGrains() did not return the expected result: ", expected, found);
    }

    /**
     * test calculateWeeklyFamilyProtein()
     * takes amount of protein per food item and multiplies it by each family
     * member's daily needs
     * then, this value is multiplied by 7 for the the whole week
     * this process is repeated for every family member
     */
    @Test
    public void testCalculateWeeklyFamilyProtein() {

        long expected = 7
                * ((MalesClient * maleDailyNeed.getProtein()) + (FemalesClient * femaleDailyNeed.getProtein()) +
                        (clientOverEight * childOverDailyNeed.getProtein())
                        + (clientUnderEight * childUnderDailyNeed.getProtein()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyProtein(family);
        assertEquals("Method CalculateWeeklyFamilyProtein() did not return the expected result: ", expected, found);
    }

    /**
     * test calculateWeeklyOther()
     * takes amount of other food items and multiplies it by each family member's
     * daily needs
     * then, this value is multiplied by 7 for the the whole week
     * this process is repeated for every family member
     */
    @Test
    public void testCalculateWeeklyFamilyOther() {

        long expected = 7
                * ((MalesClient * maleDailyNeed.getOther()) + (FemalesClient * femaleDailyNeed.getOther()) +
                        (clientOverEight * childOverDailyNeed.getOther())
                        + (clientUnderEight * childUnderDailyNeed.getOther()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyOther(family);
        assertEquals("Method CalculateWeeklyFamilyOther() did not return the expected result: ", expected, found);
    }

    /**
     * test calculateWeeklyFamilyTotalCalories()
     * takes amount of calories per food item and multiplies it by each family
     * member's daily needs
     * then, this value is multiplied by 7 for the the whole week
     * this process is repeated for every family member
     */
    @Test
    public void testCalculateWeeklyFamilyTotalCalories() {

        long expected = 7
                * ((MalesClient * maleDailyNeed.getCalories()) + (FemalesClient * femaleDailyNeed.getCalories()) +
                        (clientOverEight * childOverDailyNeed.getCalories())
                        + (clientUnderEight * childUnderDailyNeed.getCalories()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyTotalCalories(family);
        assertEquals("Method CalculateWeeklyFamilyTotalCalories() did not return the expected result: ", expected,
                found);
    }

    //DailyNeedTest
    // sample data
    // this data is used for testing
    int sampleId = 30;
    String testClientType = "Adult Male";
    int sampleGrains = 55;
    int sampleFV = 20;
    int sampleProtein = 30;
    int sampleOther = 25;
    int sampleCalories = 1000;

    /**
     * test Constructor for DailyNeed class
     * DailyNeed constructor is testing the validity of the 7 arguments
     * stored under dailyNeedConstructor
     * testing whether the DailyNeed constructor returns an object when called
     * properly
     */
    @Test
    public void testDailyNeedConstructor() {
        DailyNeed dailyNeedConstructor = new DailyNeed(sampleId, testClientType, sampleGrains,
                sampleFV, sampleProtein, sampleOther, sampleCalories);
        assertNotNull("DailyNeed constructor did not create an object when given valid arguments.",
                dailyNeedConstructor);
    }

    /**
     * test method getId()
     * getId should return the correct food ID when called properly
     * test passes when the expected item ID is found, and testing to see if it
     * matches with the ID in the database
     */
    @Test
    public void testGetId() {
        DailyNeed dailyNeed = new DailyNeed(sampleId, testClientType, sampleGrains,
                sampleFV, sampleProtein, sampleOther, sampleCalories);
        int expectedValue = sampleId;
        int foundValue = dailyNeed.getId();
        assertEquals("Method getId did not return the expected result: ", expectedValue, foundValue);
    }

    /**
     * test method getClientType()
     * getClientType should return the correct type of family member when called
     * properly
     * test passes when the expected member is found, and testing to see if it
     * matches with the family member in the database
     */
    @Test
    public void testClientType() {
        DailyNeed dailyNeed = new DailyNeed(sampleId, testClientType, sampleGrains,
                sampleFV, sampleProtein, sampleOther, sampleCalories);
        String expectedValue = testClientType;
        String foundValue = dailyNeed.getClientType();
        assertEquals("Method getClientType did not return the expected result: ", expectedValue, foundValue);
    }

    /**
     * test method getWholeGrain()
     * getWholeGrain should return the correct type of family member when called
     * properly
     * test passes when the expected whole grain is found, and testing to see if it
     * matches with the whole grain in the database
     */
    @Test
    public void testDailyNeedGetWholeGrain() {
        DailyNeed dailyNeed = new DailyNeed(sampleId, testClientType, sampleGrains,
                sampleFV, sampleProtein, sampleOther, sampleCalories);
        int expectedValue = sampleGrains;
        int foundValue = dailyNeed.getWholeGrain();
        assertEquals("Method getWholeGrain did not return the expected result: ", expectedValue, foundValue);
    }

    /**
     * test method getFruitsVeggies()
     * getFruitsVeggies should return the correct type of family member when called
     * properly
     * test passes when the expected fruits and vegetable is found, and testing to
     * see if it matches with the fruits and vegetable in the database
     */
    @Test
    public void testDailyNeedGetFruitsVeggies() {
        DailyNeed dailyNeed = new DailyNeed(sampleId, testClientType, sampleGrains,
                sampleFV, sampleProtein, sampleOther, sampleCalories);
        int expectedValue = sampleFV;
        int foundValue = dailyNeed.getFruitVeggies();
        assertEquals("Method getFruitsVeggies did not return the expected result: ", expectedValue, foundValue);
    }

    /**
     * test method getProtein()
     * getProtein should return the correct type of family member when called
     * properly
     * test passes when the expected protein is found, and testing to see if it
     * matches with the protein in the database
     */
    @Test
    public void testDailyNeedGetProtein() {
        DailyNeed dailyNeed = new DailyNeed(sampleId, testClientType, sampleGrains,
                sampleFV, sampleProtein, sampleOther, sampleCalories);
        int expectedValue = sampleProtein;
        int foundValue = dailyNeed.getProtein();
        assertEquals("Method getProtein did not return the expected result: ", expectedValue, foundValue);
    }

    /**
     * test method getOther()
     * getOther should return the correct type of family member when called properly
     * test passes when the expected other food item is found, and testing to see if
     * it matches with the other in the database
     */
    @Test
    public void testDailyNeedGetOther() {
        DailyNeed dailyNeed = new DailyNeed(sampleId, testClientType, sampleGrains,
                sampleFV, sampleProtein, sampleOther, sampleCalories);
        int expectedValue = sampleOther;
        int foundValue = dailyNeed.getOther();
        assertEquals("Method getOther did not return the expected result: ", expectedValue, foundValue);
    }

    /**
     * test method getCalories()
     * getCalories() should return the correct type of family member when called
     * properly
     * test passes when the expected calorie content is found, and testing to see if
     * it matches with the calories in the database
     */
    @Test
    public void testDailyNeedGetCalories() {
        DailyNeed dailyNeed = new DailyNeed(sampleId, testClientType, sampleGrains,
                sampleFV, sampleProtein, sampleOther, sampleCalories);
        int expectedValue = sampleCalories;
        int foundValue = dailyNeed.getCalories();
        assertEquals("Method getCalories did not return the expected result: ", expectedValue, foundValue);
    }

    /**
     * test method toString() in DailyNeed
     * this method tests if a string is correctly created
     */
    @Test
    public void testDailyNeedToString() {
        StringBuilder sb = new StringBuilder();
        assertNotNull("StringBuilder did not create a string.",
                sb);
    }

    //FamilyProfileTest

    //FoodItemTest

    //HamperCreatorTest

    //HamperTest

    //OrderFormTest

    //OrderTest

    //WeeklyNutrientProfileTest
}
