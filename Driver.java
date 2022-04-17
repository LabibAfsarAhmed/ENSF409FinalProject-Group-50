import java.util.ArrayList;
import java.util.Collection;
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

        List<ClientDailyNeedData> clientDailyNeedDatas = new ArrayList<>();  //THIS DOES NOT WORK NOW!!!
        int weeklyNutrientProfile = 0;
        for (FamilyProfile familyProfile : order.getRequestedFamilies()) {
            ClientDailyNeedData dao = new ClientDailyNeedData();
            weeklyNutrientProfile = dao.calculateWeeklyFamilyTotalCalories(familyProfile);
        }

        //This method should be check avability ini another class
        long totalCalories = weeklyNutrientProfile;
        //int totalProtein = weeklyNutrientProfiles.stream().map(p -> p.getProtein()).reduce(0, Integer::sum); to calculate the other needs

        System.out.println(totalCalories);
        
        //This class is the main method to run the program

        //Create hamper will receive nutrition profile and assign the food items according to the nutrition profile.
    }
}
