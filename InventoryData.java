import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryData {
    public static List<FoodItem> getFoodItems() {
        List<FoodItem> items = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_inventory", "student",
                    "ensf");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `AVAILABLE_FOOD`");

            while (rs.next())
                items.add(new FoodItem(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6), rs.getInt(7)));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return items;
    }

    public static void deleteFoodItem(int itemId) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_inventory", "student",
                    "ensf");

            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM `AVAILABLE_FOOD` WHERE ItemID = " + itemId);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static long getTotal(String column) {
        long total = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_inventory", "student",
                    "ensf");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUM(" + column + ") FROM `AVAILABLE_FOOD`");

            while (rs.next())
                total = rs.getLong(1);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return total;
    }

    public static long getTotalGrain() {
        return getTotal("GrainContent");
    }

    public static long getTotalFVContent() {
        return getTotal("FVContent");
    }

    public static long getTotalProContent() {
        return getTotal("ProContent");
    }

    public static long getTotalOther() {
        return getTotal("Other");
    }

    public static long getTotalCalories() {
        return getTotal("Calories");
    }
}
