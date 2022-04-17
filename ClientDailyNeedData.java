import java.sql.*;

public class ClientDailyNeedData {

    public static DailyNeed getDailyNeed(int clientId) {

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

    public long calculateWeeklyFamilyWholeGrains(FamilyProfile familyProfile) {
        long wholeGrains = 0;
        if (familyProfile.getAdultMale() > 0) {
            DailyNeed maleDailyNeed = getDailyNeed(1);
            wholeGrains = wholeGrains + (maleDailyNeed.getWholeGrain() * 7 * familyProfile.getAdultMale());
        }
        if (familyProfile.getAdultFemale() > 0) {
            DailyNeed femaleDailyNeed = getDailyNeed(2);
            wholeGrains = wholeGrains + (femaleDailyNeed.getWholeGrain() * 7 * familyProfile.getAdultFemale());
        }
        if (familyProfile.getChildrenOverEight() > 0) {
            DailyNeed childOverDailyNeed = getDailyNeed(3);
            wholeGrains = wholeGrains
                    + (childOverDailyNeed.getWholeGrain() * 7 * familyProfile.getChildrenOverEight());
        }
        if (familyProfile.getChildrenUnderEight() > 0) {
            DailyNeed childUnderDailyNeed = getDailyNeed(4);
            wholeGrains = wholeGrains
                    + (childUnderDailyNeed.getWholeGrain() * 7 * familyProfile.getChildrenUnderEight());
        }

        return wholeGrains;
    }

    public long calculateWeeklyFamilyFruitVeggies(FamilyProfile familyProfile) {
        long fruitVeggies = 0;
        if (familyProfile.getAdultMale() > 0) {
            DailyNeed maleDailyNeed = getDailyNeed(1);
            fruitVeggies = fruitVeggies + (maleDailyNeed.getFruitVeggies() * 7 * familyProfile.getAdultMale());
        }
        if (familyProfile.getAdultFemale() > 0) {
            DailyNeed femaleDailyNeed = getDailyNeed(2);
            fruitVeggies = fruitVeggies + (femaleDailyNeed.getFruitVeggies() * 7 * familyProfile.getAdultFemale());
        }
        if (familyProfile.getChildrenOverEight() > 0) {
            DailyNeed childOverDailyNeed = getDailyNeed(3);
            fruitVeggies = fruitVeggies
                    + (childOverDailyNeed.getFruitVeggies() * 7 * familyProfile.getChildrenOverEight());
        }
        if (familyProfile.getChildrenUnderEight() > 0) {
            DailyNeed childUnderDailyNeed = getDailyNeed(4);
            fruitVeggies = fruitVeggies
                    + (childUnderDailyNeed.getFruitVeggies() * 7 * familyProfile.getChildrenUnderEight());
        }

        return fruitVeggies;
    }

    public long calculateWeeklyFamilyProtein(FamilyProfile familyProfile) {
        long protein = 0;
        if (familyProfile.getAdultMale() > 0) {
            DailyNeed maleDailyNeed = getDailyNeed(1);
            protein = protein + (maleDailyNeed.getCalories() * 7 * familyProfile.getAdultMale());
        }
        if (familyProfile.getAdultFemale() > 0) {
            DailyNeed femaleDailyNeed = getDailyNeed(2);
            protein = protein + (femaleDailyNeed.getCalories() * 7 * familyProfile.getAdultFemale());
        }
        if (familyProfile.getChildrenOverEight() > 0) {
            DailyNeed childOverDailyNeed = getDailyNeed(3);
            protein = protein
                    + (childOverDailyNeed.getCalories() * 7 * familyProfile.getChildrenOverEight());
        }
        if (familyProfile.getChildrenUnderEight() > 0) {
            DailyNeed childUnderDailyNeed = getDailyNeed(4);
            protein = protein
                    + (childUnderDailyNeed.getCalories() * 7 * familyProfile.getChildrenUnderEight());
        }

        return protein;
    }

    public long calculateWeeklyFamilyWholeFruitVeggies(FamilyProfile familyProfile) {
        long other = 0;
        if (familyProfile.getAdultMale() > 0) {
            DailyNeed maleDailyNeed = getDailyNeed(1);
            other = other + (maleDailyNeed.getOther() * 7 * familyProfile.getAdultMale());
        }
        if (familyProfile.getAdultFemale() > 0) {
            DailyNeed femaleDailyNeed = getDailyNeed(2);
            other = other + (femaleDailyNeed.getOther() * 7 * familyProfile.getAdultFemale());
        }
        if (familyProfile.getChildrenOverEight() > 0) {
            DailyNeed childOverDailyNeed = getDailyNeed(3);
            other = other
                    + (childOverDailyNeed.getOther() * 7 * familyProfile.getChildrenOverEight());
        }
        if (familyProfile.getChildrenUnderEight() > 0) {
            DailyNeed childUnderDailyNeed = getDailyNeed(4);
            other = other
                    + (childUnderDailyNeed.getOther() * 7 * familyProfile.getChildrenUnderEight());
        }
        
        return other;
    }
    
    public int calculateWeeklyFamilyTotalCalories(FamilyProfile familyProfile) {
        int totalCalories = 0;
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

        return totalCalories;
    }

}
