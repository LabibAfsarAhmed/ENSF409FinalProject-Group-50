import java.sql.*;

public class ClientDailyNeedData {

    /*
     * public List<DailyNeed> getDailyNeeds() {
     * List<DailyNeed> dailyNeeds = new ArrayList<>();
     * 
     * try {
     * Class.forName("com.mysql.jdbc.Driver");
     * Connection con =
     * DriverManager.getConnection("jdbc:mysql://localhost:3306/food_inventory",
     * "student",
     * "food_inventory");
     * 
     * Statement stmt = con.createStatement();
     * ResultSet rs = stmt.executeQuery("SELECT * FROM daily_client_needs;");
     * 
     * while (rs.next())
     * dailyNeeds.add(new DailyNeed(rs.getInt(1), rs.getString(2), rs.getInt(3),
     * rs.getInt(4), rs.getInt(5),
     * rs.getInt(6), rs.getInt(7)));
     * con.close();
     * } catch (Exception e) {
     * System.out.println(e);
     * }
     * return dailyNeeds;
     * }
     */

    public DailyNeed getDailyNeed(int clientId) {

        DailyNeed dailyNeed = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_inventory", "student",
                    "food_inventory");

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

    public WeeklyNutrientProfile calculateWeeklyFamilyCalories(FamilyProfile familyProfile) {
        // InventoryDao dao = new InventoryDao();
        long totalCalories = 0;
        if (familyProfile.getAdultMale() > 0) {
            DailyNeed maleDailyNeed = getDailyNeed(1);
            totalCalories = totalCalories + (maleDailyNeed.getCalories() * 7 * familyProfile.getAdultMale());
        }
        if (familyProfile.getAdultFemale() > 0) {
            DailyNeed femaleDailyNeed = getDailyNeed(2);
            totalCalories = totalCalories + (femaleDailyNeed.getCalories() * 7 * familyProfile.getAdultFemale());
        }
        if (familyProfile.getChildrenOverEight() > 0) {
            DailyNeed childOverDailyNeed = getDailyNeed(3);
            totalCalories = totalCalories
                    + (childOverDailyNeed.getCalories() * 7 * familyProfile.getChildrenOverEight());
        }
        if (familyProfile.getChildrenUnderEight() > 0) {
            DailyNeed childUnderDailyNeed = getDailyNeed(4);
            totalCalories = totalCalories
                    + (childUnderDailyNeed.getCalories() * 7 * familyProfile.getChildrenUnderEight());
        }

        return new WeeklyNutrientProfile(0, 0, 0, 0, totalCalories);

    }

}
