/**
 @author Jannine Osman <a href="mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
         Sukriti Sharma <a href="mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
         Caroline Basta <a href="mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
         Labib Afsar Ahmed <a href="mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 @version       1.8
 @since         1.0
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.sql.*;


public class ClientDailyNeedDataTest{
    int testFemales = 1;
    int testMales = 2;
    int testUnderEight = 3;
    int testOverEight = 4;
    boolean testWeeklyService = true;
    FamilyProfile family = new FamilyProfile(testFemales, testMales, testOverEight,
            testUnderEight, testWeeklyService);
    // DailyNeed female = new DailyNeed(2, "Adult Female", 100, 90,200, 10,2000);
    // DailyNeed male = new DailyNeed(1, "Adult Male", 120, 100, 300, 70, 2700);
    // DailyNeed childrenOver8 = new DailyNeed(1, "Children Over 8", 60, 180, 100, 30, 3000);
    // DailyNeed childrenUnder8 = new DailyNeed(1, "Children Under 8", 80, 380, 120, 40, 3400);

            //test constructor
   /* @Test
    public void calculateWeeklyFamilyNeeds(){

    } */
   

    public static DailyNeed getDailyNeed(int clientId) {

        DailyNeed dailyNeed = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_inventory", "student",
                    "ensf");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `DAILY_CLIENT_NEEDS` WHERE ClientID = " + clientId);

            while (rs.next())
                dailyNeed = new DailyNeed(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6), rs.getInt(7));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return dailyNeed;
    }
    
    DailyNeed maleDailyNeed = getDailyNeed(1);
    DailyNeed femaleDailyNeed = getDailyNeed(2);
    DailyNeed childOverDailyNeed = getDailyNeed(3);
    DailyNeed childUnderDailyNeed = getDailyNeed(4);
    
    // test calculateWeeklyFamilyWholeGrains()
    @Test
    public void testCalculateWeeklyFamilyWholeGrains(){
        //ClientDailyNeedData familyTest = new ClientDailyNeedData();
        long expected = 7*((testMales * maleDailyNeed.getWholeGrain()) + (testFemales * femaleDailyNeed.getWholeGrain())+ 
                                (testOverEight * childOverDailyNeed.getWholeGrain()) + (testUnderEight * childUnderDailyNeed.getWholeGrain()));
        long found = ClientDailyNeedData.calculateWeeklyFamilyWholeGrains(family);
        assertEquals("Method CalculateWeeklyFamilyWholeGrains() did not return the expected result: ", expected, found);

    }

    //test calculateWeeklyFamilyFruitVeggies()
    @Test
    public void testCalculateWeeklyFamilyFruitVeggies(){

    }

    

}