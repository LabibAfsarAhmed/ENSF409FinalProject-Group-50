import org.junit.Test;

import jdk.jfr.Timestamp;

import org.junit.Assert;
import static org.junit.Assert.*;



public class jannineTest {
    // IN THIS FILE:
    // getters and setters
    // IOExceptions 

    // getters and setters tests needed:

    /** ***** ConfigureHamper *****
     * getNewRequest // done
     * setNewRequest // done
     * getRequestMultipleHampers
     * setRequestMultipleHampers
     */

    // test for getNewRequest in ConfigureHamper
    @Test
    public void testGetNewRequest(){
        ConfigureHamper newHamper = new ConfigureHamper(String newRequest);
        String theRequest = newHamper.getNewRequest();
        String expectedRequest = "Hamper 1: 1 Adult Female, 2 Child under 8 \n
        Hamper 2: 1 Adult Male, 1 Child over 8";
        assertEquals("Method getNewRequest did not return the expected result:", expectedRequest, theRequest);
    }

   // test for setNewRequest in ConfigureHamper
     @Test
     public void testSetNewRequest(){
        ConfigureHamper newHamper = new ConfigureHamper(String newRequest);
        String theRequest = newHamper.setNewRequest("Hamper 1: Adult Female, Adult Male");
        String expectedRequest = "Hamper 1: Adult Male, Adult Female";
        assertEquals("Method setNewRequest did not return the expected result:", expectedRequest, theRequest);

     }

     // test for RequestMultipleHampers
     @Test
     public void testGetRequestMultipleHampers(){
         ConfigureHamper newHamper = new ConfigureHamper(String requestMultiple);
         String theValue = newHamper.getRequestMultipleHampers();
         String expectedValue = "Hamper 1: 1 Adult Female, 2 Child under 8 \n
         Hamper 2: 1 Adult Male, 1 Child over 8";
         assertEquals("Method getRequestMultipleHampers did not return the expected result:", expectedRequest, theRequest);
     }

     // test for setMultipleHampers
     @Test
     public void testSetMultipleHampers(){
        ConfigureHamper newHamper = new ConfigureHamper(String requestMultiple);
        newHamper.setRequestMultipleHampers("Hamper 1: 1 Adult Female, 2 Child under 8 \n
        Hamper 2: 1 Adult Male, 1 Child over 8");
        String theValue = newHamper.getRequestMultipleHampers();
        String expectedValue = "Hamper 1: 1 Adult Female, 2 Child under 8 \n
        Hamper 2: 1 Adult Male, 1 Child over 8";
        assertEquals("Method setRequestMultipleHampers did not return the expected result:", expectedRequest, theValue);         
     }

     /**
      * ***** HAMPER *****
      *  - getListFoodItems
      */

      // test for getListFoodItems
      @Test 
      public void testGetListFoodItems(){
         Hamper newHamper = new Hamper(1, 2);
         String theValue = newHamper.getListFoodItems();
         String expectedValue = "34	Avocado, dozen\n
         35	Avocado, dozen\n
         54	Soy protein, 1 kg\n 
         55	Turkey, whole\n 
         56	Mixed nuts, 1 kg\n
         105	Teff flour, 2 kg\n
         142	Whey powder, large jar\n
         143	Oranges, bag\n
         145	Raisins, 40 g\n
         147	Lettuce, 1 head\n
         151	Peaches, crate";
         assertEquals("Method getListFoodItems did not return the expected result:", expectedValue, theValue);

      }

      // ***** INVENTORY ******
      /**
       *  - getItemID *
       *  - getName  *
       *  - getGrain * 
       *  - getFruitsVeggies * 
       *  - getProtein * 
       *  - getOtherContent * 
       *  - getStock * 
       *  - setStock * 
       *  - getInventory *
       */

       // getItemID
       @Test 
       public void testGetItemID(){
           Inventory ourInventory = new Inventory(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
           int itemIDValue = ourInventory.getItemID();
           int expectedItemIDValue = 51;
           assertEquals("Method getItemID did not return the expected result:", expectedItemIDValue, itemIDValue);

       }

       // test for getName of inventory item
       @Test
       public void testGetName(){
        Inventory ourInventory = new Inventory(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemName = ourInventory.getName();
        int expectedName = "Cantaloupe dozen";
        assertEquals("Method getName did not return the expected result:", expectedName, itemName);
       }

       // test for getGrain content for inventory item
       @Test 
       public void testGetGrain(){
        Inventory ourInventory = new Inventory(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemGrain = ourInventory.getGrain();
        int expectedItemGrain = 0;
        assertEquals("Method getGrain did not return the expected result:", expectedItemGrain, itemGrain);
       }

       // test for getFruitsVeggies content for inventory item
       @Test 
       public void testGetFruitsVeggies(){
        Inventory ourInventory = new Inventory(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemFV = ourInventory.getFruitsVeggies();
        int expectedItemFV = 100;
        assertEquals("Method getFruitsVeggies did not return the expected result:", expectedItemFV, itemFV);
       }

       // test for getProtein content for inventory item
       @Test 
       public void testGetProtein(){
        Inventory ourInventory = new Inventory(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemProtein = ourInventory.getProtein();
        int expectedItemProtein = 0;
        assertEquals("Method getProtein did not return the expected result:", expectedItemProtein, itemProtein);
       }

       // test for getOtherContent for inventory item
       @Test 
       public void testGetOtherContent(){
        Inventory ourInventory = new Inventory(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemOtherContent = ourInventory.getOtherContent();
        int expectedItemOtherContent = 0;
        assertEquals("Method getOtherContent did not return the expected result:", expectedItemOtherContent itemOtherContent);
       }

       // test for getStock for inventory item
       @Test 
       public void testGetStock(){
        Inventory ourInventory = new Inventory(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        int itemStock = ourInventory.getStock();
        int expectedItemStock= 10;
        assertEquals("Method getStock did not return the expected result:", expectedItemStock, itemStock);
       }

       // test for setStock for inventory item
       @Test
       public void testSetStock(){
        Inventory ourInventory = new Inventory(51, "Cantaloupe, dozen", 0, 100, 0, 0, 10);
        ourInventory.setStock(5);
        int itemStock = ourInventory.getStock();
        int expectedItemStock = 5;
        assertEquals("Method setStock did not return the expected result:", expectedItemStock, itemStock);
       }
      
       // test for Inventory construction with good input 
       // this method should not throw an exception since input is good
       @Test
       public void testInventoryConstructorGoodInput(){
           File inventoryFile = new File("Inventory.txt");

           boolean returnIsTrue = true;
           boolean exceptionThrown = false;
           Inventory ourInventory = new Inventory(inventoryFile);
           try{
               returnIsTrue = ourInventory.readFile();
           }catch(Exception e){
               exceptionThrown = true;
           }
           assertFalse("An unexpected exception was thrown when reading a valid input file", exceptionThrown);
           assertTrue("readFile() returned false when operation should have been successful", returnIsTrue);

       }

       // test for inventory contructor with bad input data txt file
       // this method should throw an exception
       @Test 
       public void testInventoryConstructorBadInput(){
           File noSuchFile = new File("this_file_does_not_exist.txt");

           boolean returnIsTrue = true;
           boolean exceptionThrown = false;

           Inventory ourInventory = new Inventory(noSuchFile);
           try{
               returnIsTrue = ourInventory.readFile();
           }catch(Exception e){
               exceptionThrown = true;
           }
           assertFalse("An unexpected exception was thrown when the file couldn't be read", exceptionThrown);
        assertFalse("readFile() returned true when operation failed due to file not existing", returnIsTrue);

       }

       // test for getInventory (assuming the file was read properly)
       @Test
       public void testGetInventory(){
        File inventoryFile = new File("Inventory.txt");

        boolean returnIsTrue = true;
        boolean exceptionThrown = false;
        Inventory ourInventory = new Inventory(inventoryFile);
        String inventory = ourInventory.getInventor();
        String expectedInventory = "(Cantaloupe, dozen, 0, 100, 0, 0, 3324, 40),
        ('Cottage cheese', 0, 0, 11, 89, 840, 60), 
        ('Trail mix, 1 kg', 21, 0, 20, 59, 6000, 20),";
        assertEquals("Method getInventory did not return the expected result:", expectedInventory, inventory);

       }

          // ***** FamilyProfile *****
        /**
         *  - getFamilyNumber
         *  - setFamilyNumber
         *  - getAdultsNum
         *  - setAdultsNum
         *  - getChildrenUnderEight
         *  - setChildrenUnderEight
         *  - getChildrenOverEight
         *  - setChildrenOverEight
         *  - getGender
         *  - setGender
         */

         // test for setFamilyNumber
         @Test
         public void testSetFamilyNumber(){
             FamilyProfile theFam = new FamilyProfile();
             theFam.setFamilyNumber(150);
             int familyNumber = theFam.getFamilyNumber();
             int familyNumberExpected = 150;
             assertEquals("Method setFamilyNumber did not return the expected results:", familyNumberExpected, familyNumber);
         }

         // test for getFamilyNumber
         @Test
         public void testGetFamilyNumber(){
             
         }



       // ***** getUser ****
       /**
        *  - getNumberOfClients
        *  - getTypeOfClient
        *  - getHamper
        *  - differentHampers
        */

     

         // ***** IOEXCEPTIONS *****
         // does placeOrder throw an IOException if wrong info is provided

   
}
