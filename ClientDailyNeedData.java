import java.sql.*;

public class ClientDailyNeedData {

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

    public static FamilyProfile calculateWeeklyFamilyNeeds(FamilyProfile familyProfile) {
        WeeklyNutrientProfile nutrientProfile = new WeeklyNutrientProfile(
                calculateWeeklyFamilyWholeGrains(familyProfile),
                calculateWeeklyFamilyFruitVeggies(familyProfile),
                calculateWeeklyFamilyProtein(familyProfile),
                calculateWeeklyFamilyOther(familyProfile),
                calculateWeeklyFamilyTotalCalories(familyProfile));
        familyProfile.setWeeklyNutrientProfile(nutrientProfile);
        return familyProfile;
    }

    private static long calculateWeeklyFamilyWholeGrains(FamilyProfile familyProfile) {
        long wholeGrains = 0;
        if (familyProfile.getAdultMales() > 0) {
            DailyNeed maleDailyNeed = getDailyNeed(1);
            wholeGrains = wholeGrains + (maleDailyNeed.getWholeGrain() * 7 * familyProfile.getAdultMales());
        }
        if (familyProfile.getAdultFemales() > 0) {
            DailyNeed femaleDailyNeed = getDailyNeed(2);
            wholeGrains = wholeGrains + (femaleDailyNeed.getWholeGrain() * 7 * familyProfile.getAdultFemales());
        }
        if (familyProfile.getChildrenOver8() > 0) {
            DailyNeed childOverDailyNeed = getDailyNeed(3);
            wholeGrains = wholeGrains
                    + (childOverDailyNeed.getWholeGrain() * 7 * familyProfile.getChildrenOver8());
        }
        if (familyProfile.getChildrenUnder8() > 0) {
            DailyNeed childUnderDailyNeed = getDailyNeed(4);
            wholeGrains = wholeGrains
                    + (childUnderDailyNeed.getWholeGrain() * 7 * familyProfile.getChildrenUnder8());
        }

        return wholeGrains;
    }

    private static long calculateWeeklyFamilyFruitVeggies(FamilyProfile familyProfile) {
        long fruitVeggies = 0;
        if (familyProfile.getAdultMales() > 0) {
            DailyNeed maleDailyNeed = getDailyNeed(1);
            fruitVeggies = fruitVeggies + (maleDailyNeed.getFruitVeggies() * 7 * familyProfile.getAdultMales());
        }
        if (familyProfile.getAdultFemales() > 0) {
            DailyNeed femaleDailyNeed = getDailyNeed(2);
            fruitVeggies = fruitVeggies + (femaleDailyNeed.getFruitVeggies() * 7 * familyProfile.getAdultFemales());
        }
        if (familyProfile.getChildrenOver8() > 0) {
            DailyNeed childOverDailyNeed = getDailyNeed(3);
            fruitVeggies = fruitVeggies
                    + (childOverDailyNeed.getFruitVeggies() * 7 * familyProfile.getChildrenOver8());
        }
        if (familyProfile.getChildrenUnder8() > 0) {
            DailyNeed childUnderDailyNeed = getDailyNeed(4);
            fruitVeggies = fruitVeggies
                    + (childUnderDailyNeed.getFruitVeggies() * 7 * familyProfile.getChildrenUnder8());
        }

        return fruitVeggies;
    }

    private static long calculateWeeklyFamilyProtein(FamilyProfile familyProfile) {
        long protein = 0;
        if (familyProfile.getAdultMales() > 0) {
            DailyNeed maleDailyNeed = getDailyNeed(1);
            protein = protein + (maleDailyNeed.getProtein() * 7 * familyProfile.getAdultMales());
        }
        if (familyProfile.getAdultFemales() > 0) {
            DailyNeed femaleDailyNeed = getDailyNeed(2);
            protein = protein + (femaleDailyNeed.getProtein() * 7 * familyProfile.getAdultFemales());
        }
        if (familyProfile.getChildrenOver8() > 0) {
            DailyNeed childOverDailyNeed = getDailyNeed(3);
            protein = protein
                    + (childOverDailyNeed.getProtein() * 7 * familyProfile.getChildrenOver8());
        }
        if (familyProfile.getChildrenUnder8() > 0) {
            DailyNeed childUnderDailyNeed = getDailyNeed(4);
            protein = protein
                    + (childUnderDailyNeed.getProtein() * 7 * familyProfile.getChildrenUnder8());
        }

        return protein;
    }

    private static long calculateWeeklyFamilyOther(FamilyProfile familyProfile) {
        long other = 0;
        if (familyProfile.getAdultMales() > 0) {
            DailyNeed maleDailyNeed = getDailyNeed(1);
            other = other + (maleDailyNeed.getOther() * 7 * familyProfile.getAdultMales());
        }
        if (familyProfile.getAdultFemales() > 0) {
            DailyNeed femaleDailyNeed = getDailyNeed(2);
            other = other + (femaleDailyNeed.getOther() * 7 * familyProfile.getAdultFemales());
        }
        if (familyProfile.getChildrenOver8() > 0) {
            DailyNeed childOverDailyNeed = getDailyNeed(3);
            other = other
                    + (childOverDailyNeed.getOther() * 7 * familyProfile.getChildrenOver8());
        }
        if (familyProfile.getChildrenUnder8() > 0) {
            DailyNeed childUnderDailyNeed = getDailyNeed(4);
            other = other
                    + (childUnderDailyNeed.getOther() * 7 * familyProfile.getChildrenUnder8());
        }

        return other;
    }

    private static int calculateWeeklyFamilyTotalCalories(FamilyProfile familyProfile) {
        int totalCalories = 0;
        if (familyProfile.getAdultMales() > 0) {
            DailyNeed maleDailyNeed = getDailyNeed(1);
            totalCalories = totalCalories + (maleDailyNeed.getCalories() * 7 * familyProfile.getAdultMales());
        }
        if (familyProfile.getAdultFemales() > 0) {
            DailyNeed femaleDailyNeed = getDailyNeed(2);
            totalCalories = totalCalories + (femaleDailyNeed.getCalories() * 7 * familyProfile.getAdultFemales());
        }
        if (familyProfile.getChildrenOver8() > 0) {
            DailyNeed childOverDailyNeed = getDailyNeed(3);
            totalCalories = totalCalories
                    + (childOverDailyNeed.getCalories() * 7 * familyProfile.getChildrenOver8());
        }
        if (familyProfile.getChildrenUnder8() > 0) {
            DailyNeed childUnderDailyNeed = getDailyNeed(4);
            totalCalories = totalCalories
                    + (childUnderDailyNeed.getCalories() * 7 * familyProfile.getChildrenUnder8());
        }

        return totalCalories;
    }

}