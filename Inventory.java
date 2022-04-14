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
    private int ItemID;
    private String name;
    private int grain;
    private int protein;
    private int fruitsVeggies;
    private int otherContent;
    //private int stock;
    //private String inputFile;
    //private NutrientType nutrientHelper = new NutrientType();
    
    public Inventory(){
        
    }
    
    public Inventory(int itemID, String name, int grain, int fruitsVeggies, int protein, int otherContent, int stock){

    }

    // the following getters will use the nutrient class 

    public int getItemID(){
        //return nutrientHelper.getItemID();
        return 0;
    }

    public String getName(){
        //return nutrientHelper.getName();
        return "";
    }

    public int getGrain(){
        //return nutrientHelper.getGrain();
        return 0;
    }

    public int getFruitsVeggies(){
        //return nutrientHelper.getFruitsVeggies();
        return 0;
    }

    public int getProtein(){
        //return nutrientHelper.getProtein();
        return 0;
    }

    public int getOtherContent(){
        //return nutrientHelper.getOtherContent();
        return 0;
    }

    public int getStock(){
        //return this.stock;
        return 0;
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
            while(results.next()){
                System.out.println("Print results:" + results.getString("Name"));
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

    }

}
