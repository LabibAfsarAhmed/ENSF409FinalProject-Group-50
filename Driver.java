import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<FamilyProfile> requestedFamilies = new ArrayList<>();
        UI ui = new TerminalUI();
        String name = ui.inputName();

        while (true) {
            requestedFamilies.add(ui.inputFamilyProfile());

            if (!ui.hasMore()) {
                break;
            }
        }

        Order order = new Order(name, requestedFamilies);
        System.out.println(order);

        List<WeeklyNutrientProfile> weeklyNutrientProfiles = new ArrayList<>();
        for (FamilyProfile familyProfile : order.getRequestedFamilies()) {
            InventoryDao dao = new InventoryDao();
            weeklyNutrientProfiles.add(dao.calculateWeeklyFamilyCalories(familyProfile));
        }

        //This method should be check avability ini another class
        long totalCalories = 0;
        for (WeeklyNutrientProfile weeklyNutrientProfile : weeklyNutrientProfiles) {
            totalCalories = totalCalories + weeklyNutrientProfile.getCalories();
            System.out.println(totalCalories);
        }
        
        //This class is the main method to run the program

        //Create hamper will receive nutrition profile and assign the food items according to the nutrition profile.
    }
}
