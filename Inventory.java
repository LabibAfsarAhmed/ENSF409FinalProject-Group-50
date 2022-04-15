<<<<<<< HEAD
public class Inventory {
    
=======
/** @author Jannine Osman <ahref = "mailto: jannine.osman@ucalgary.ca"
 * @version 1.3
 * @since 1.0 
 */

// inventory class should read in the invetory from the SQL file 
// so reads in the inventory 
// should also be able to update the database once the hamper is made 
// inventory uses will use the NutrientType class to access macronutrient information 
// for each item in the inventory 


import java.sql.*;

class mainTest{

    // main method for testing
    public static void main(String[] args){
        Inventory newInv = new Inventory();
        newInv.getInventory();
    }
}
public class Inventory {
    private Connection dbConnect;

    // once this equals false, we will need to update the database and remove the items used 
    // to create the hamper from collected data, and update the new inventory to the database 
    private boolean hamperMade = false;
    private int[] ItemID;
    private int[] grain;
    private int[] protein;
    private int[]fruitsVeggies;
    private int[]otherContent;
    private int[] calories;
    private int[][] inventoryArray;
    private int numberItemsInventory = 0;;
    //private int stock;
    //private String inputFile;
    //private NutrientType nutrientHelper = new NutrientType();
    
    public Inventory(){
        
    }
    
    public Inventory(int[] itemID, int[] grain, int[] fruitsVeggies, int[] protein, int[] otherContent, int[] calories){
        for(int i = 0; i < numberItemsInventory; i++ ){
            this.inventoryArray[i][0] = itemID[i];
            this.ItemID[i] = itemID[i];
        }
        for(int i = 0; i < numberItemsInventory; i++ ){
            this.inventoryArray[i][1] = grain[i];
            this.grain[i] = grain[i];
        }
        for(int i = 0; i < numberItemsInventory; i++ ){
            this.inventoryArray[i][2] = fruitsVeggies[i];
            this.fruitsVeggies[i] = fruitsVeggies[i];
        }
        for(int i = 0; i < numberItemsInventory; i++ ){
            this.inventoryArray[i][3] = protein[i];
            this.protein[i] = protein[i];
        }
        for(int i = 0; i < numberItemsInventory; i++ ){
            this.inventoryArray[i][4] = otherContent[i];
            this.otherContent[i] = otherContent[i];
        }
        for(int i = 0; i < numberItemsInventory; i++ ){
            this.inventoryArray[i][5] = calories[i];
            this.calories[i] = calories[i];
        }
    }

    // the following getters will use the nutrient class 

    public int[] getItemID(int row){
        return this.ItemID;
    }

    public int[] getGrain(){
        return this.grain;
    }

    public int[] getFruitsVeggies(){
        return this.fruitsVeggies;
    }

    public int[] getProtein(){
        return this.protein;
    }

    public int[] getOtherContent(){
        return this.otherContent;
    }

    public int[] getCalories(){
        return this.calories;
    }

    public void setHamperMade(boolean torF){
        this.hamperMade = torF;
    }

    // will access the database
    public String getInventory(){
        // Step 1: Creat a connection
        try{
        dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "student", "ensf");
        }catch(SQLException e){
            e.printStackTrace();
        }
       
        // Step 4: 
        try{
             // Step 2: Create a statement
             // statement is simple, no paramteres needed
              Statement myStmt = dbConnect.createStatement();

            // Step 3: Execute the statement
            ResultSet results = myStmt.executeQuery("SELECT * FROM AVAILABLE_FOOD");
            //int rowCount = myStmt.executeUpdate(); // after execture statement will show how many rows were affected
            int tempID[] = new int[400];
            int tempGrainContent[] = new int[400];
            int tempFVContent[] = new int[400];
            int tempProContent[] = new int[400];
            int tempOther[] = new int[400];
            int tempCalories[] = new int[400];
            int i = 0;
            while(results.next()){
                //System.out.println("Print results:" + results.getString("Name"));
                tempID[i] = i;
                tempGrainContent[i] = results.getInt("GrainContent");
                tempFVContent[i] = results.getInt("FVContent");
                tempProContent[i] = results.getInt("ProContent");
                tempOther[i] = results.getInt("Other");
                tempCalories[i] = results.getInt("Calories");
                new Inventory(tempID, tempGrainContent, tempFVContent, tempProContent, tempOther, tempCalories);
                numberItemsInventory +=1;
                i+=1; 

            }
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return " ";

    }

    // will have to take in the created hamper and remove the items
    // the hamper uses from the collected data, then 
    // update the database 
    public void updateInventory(){
        // if hamper successfully made update database 
        if(hamperMade  == true){

        }

    }

>>>>>>> ce069e862eae348dbd1399009c31f330dd6986d1
}
