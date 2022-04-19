package edu.ucalgary.ensf409;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
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
    // testing data
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
     * testing whether the FoodItem constructor returns an object when called
     * properly
     */
    public void testFoodItemConstructor() {
        FoodItem foodItemConstructor = new FoodItem(testID, testName, testGrainContent,
                testFvContent, testProContent, testOther, testCalories);
        assertNotNull("FoodItem constructor did not create an object when given valid arguments.",
                foodItemConstructor);
    }

    /**
     * test ItemID
     * itemID should return the correct food ID when called properly
     * test passes when the expected item ID is found, and testing to see if it
     * matches with the ID in the database
     */
    @Test
    public void testGetItemID() {
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 0);
        int itemIDValue = ourInventory.getId();
        int expectedItemIDValue = 51;
        assertEquals("Method getItemID did not return the expected result:", expectedItemIDValue, itemIDValue);

    }

    /**
     * test for getName of inventory item
     * getName should return the correct food name when called properly
     * test passes when the expected item name is found, and testing to see if it
     * matches with the name in the database
     */
    @Test
    public void testGetName() {
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        String itemName = ourInventory.getName();
        String expectedName = "Cantaloupe, dozen";
        assertEquals("Method getName did not return the expected result:", expectedName, itemName);
    }

    /**
     * test for getGrain content for inventory item
     * getGrain should return the correct grain when called properly
     * test passes when the expected grain name is found, and testing to see if it
     * matches with the grain in the database
     */
    @Test
    public void testGetGrain() {
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemGrain = ourInventory.getGrainContent();
        int expectedItemGrain = 0;
        assertEquals("Method getGrain did not return the expected result:", expectedItemGrain, itemGrain);
    }

    /**
     * test for getFruitsVeggies content for inventory item
     * getFruitsVeggies should return the correct fruits and vegetable when called
     * properly
     * test passes when the expected fruits and vegetable name is found, and testing
     * to see if it matches with the fruits and vegetable in the database
     */
    @Test
    public void testGetFruitsVeggies() {
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemFV = ourInventory.getFVContent();
        int expectedItemFV = 100;
        assertEquals("Method getFruitsVeggies did not return the expected result:", expectedItemFV, itemFV);
    }

    /**
     * test for getProtein content for inventory item
     * getProtein should return the correct protein when called properly
     * test passes when the expected item protein is found, and testing to see if it
     * matches with the protein in the database
     */
    @Test
    public void testGetProtein() {
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemProtein = ourInventory.getProContent();
        int expectedItemProtein = 0;
        assertEquals("Method getProtein did not return the expected result:", expectedItemProtein, itemProtein);
    }

    /**
     * test for getOtherContent for inventory item
     * getOtherContent should return the correct other content when called properly
     * test passes when the expected other content is found, and testing to see if
     * it matches with the other content in the database
     */
    @Test
    public void testGetOtherContent() {
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemOtherContent = ourInventory.getOther();
        int expectedItemOtherContent = 0;
        assertEquals("Method getOtherContent did not return the expected result:", expectedItemOtherContent,
                itemOtherContent);
    }

    /**
     * test for getCalories for inventory item
     * getCalories should return the correct calorie content when called properly
     * test passes when the expected calorie content of a particular food item is
     * found,
     * and testing to see if it matches with the calorie in the database
     */
    @Test
    public void testGetCalories() {
        FoodItem ourInventory = new FoodItem(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemCalories = ourInventory.getCalories();
        int expectedCalories = 10;
        assertEquals("Method getCalories did not return the expected result:", expectedCalories, itemCalories);
    }

    //HamperCreatorTest
    /**
     * initialized the new list for family profile
     * initialize a list of hamper - requested families
     * initializes list of food items
     */
    List<FamilyProfile> familiesRequested = new ArrayList<FamilyProfile>();
    List<Hamper> initializeHampers = new ArrayList<Hamper>();
    List<FoodItem> sampleFood = new ArrayList<FoodItem>();
    String sampleEmployee = "Sam";
    List<FamilyProfile> familiesExpected = createSampleFamilies(familiesRequested);

    Order order = new Order(sampleEmployee, familiesExpected);

    /**
     * this initlializes the sample list of requested families
     * create sameple and adds it to requested family list
     * 
     * @param familiesRequested is referencing the FamilyProfile class
     * @return familiesRequested
     */
    public List<FamilyProfile> createSampleFamilies(List<FamilyProfile> familiesRequested) {
        // an example of family that requires weekly service due to mobility issues
        FamilyProfile family1 = new FamilyProfile(1, 1, 1, 1, true);
        // an example of family that doesn't require weekly service due to mobility
        // issues
        FamilyProfile family2 = new FamilyProfile(2, 1, 0, 0, false);
        // adds family 1 and 2 into the requested family list
        familiesRequested.add(family1);
        familiesRequested.add(family2);
        return familiesRequested;
    }

    /**
     * test Hamper Creator constructor
     * checks if the constructor has made an object
     */
    @Test
    public void testHamperCreator() {
        HamperCreator testCreator = new HamperCreator(order);
        assertNotNull("HamperConstructor did not create an object when given valid arguments.",
                testCreator);
    }

    /**
     * test buildHamper()
     * builds the hamper constructor
     */
    @Test
    public void testBuildHamper() {
        Hamper testHamper = new Hamper(sampleFood);
        assertNotNull("BuildHamper did not create an object when given valid arguments.",
                testHamper);

}

    //HamperTest

    //OrderFormTest

    //OrderTest

    //WeeklyNutrientProfileTest
}
