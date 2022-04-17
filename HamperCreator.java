import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HamperCreator {
    private Order order;

    public HamperCreator(Order order) {
        List<FamilyProfile> familyProfiles = order.getRequestedFamilies();
        for (FamilyProfile familyProfile : familyProfiles) {
            ClientDailyNeedData.calculateWeeklyFamilyNeeds(familyProfile);
        }

        long totalGrains = familyProfiles.stream().map(f -> f.getWeeklyNutrientProfile().getWholeGrain()).reduce(0L,
                Long::sum);
        long totalFVContent = familyProfiles.stream().map(f -> f.getWeeklyNutrientProfile().getFruitVeggies())
                .reduce(0L, Long::sum);
        long totalProtein = familyProfiles.stream().map(f -> f.getWeeklyNutrientProfile().getProtein()).reduce(0L,
                Long::sum);
        long totalOther = familyProfiles.stream().map(f -> f.getWeeklyNutrientProfile().getOther()).reduce(0L,
                Long::sum);
        long totalCalories = familyProfiles.stream().map(f -> f.getWeeklyNutrientProfile().getCalories()).reduce(0L,
                Long::sum);

        System.out.println("totalGrains:" + totalGrains);
        System.out.println("totalFVContent:" + totalFVContent);
        System.out.println("totalProtein:" + totalProtein);
        System.out.println("totalOther:" + totalOther);
        System.out.println("totalCalories:" + totalCalories);

        System.out.println("totalGrains:" + InventoryData.getTotalGrain());
        System.out.println("totalFVContent:" + InventoryData.getTotalFVContent());
        System.out.println("totalProtein:" + InventoryData.getTotalProContent());
        System.out.println("totalOther:" + InventoryData.getTotalOther());
        System.out.println("totalCalories:" + InventoryData.getTotalCalories());

        if (totalGrains > InventoryData.getTotalGrain() || totalFVContent > InventoryData.getTotalFVContent() ||
                totalProtein > InventoryData.getTotalProContent() || totalOther > InventoryData.getTotalOther()
                || totalCalories > InventoryData.getTotalCalories()) {

            throw new RuntimeException("Not enough stock!");
        }

        this.order = order;
    }

    public void buildHamper() {
        List<Hamper> hampers = new ArrayList<>();
        List<FamilyProfile> familyProfiles = order.getRequestedFamilies();

        for (FamilyProfile familyProfile : familyProfiles) {
            List<FoodItem> items = pickMinimumItem(InventoryData.getFoodItems(),
                    familyProfile.getWeeklyNutrientProfile());

            Hamper hamper = new Hamper(items);
            hampers.add(hamper);
        }

        order.setCreatedHamper(hampers);
    }

    private List<FoodItem> pickMinimumItem(List<FoodItem> items, WeeklyNutrientProfile nutrientProfile) {
        int totalGrains = 0;
        int totalFVContent = 0;
        int totalProtein = 0;
        int totalOther = 0;
        int totalCalories = 0;
        List<FoodItem> pickedItems = new ArrayList<>();

        Iterator<FoodItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            FoodItem item = iterator.next();

            if (nutrientProfile.getWholeGrain() <= totalGrains && nutrientProfile.getFruitVeggies() <= totalFVContent
                    && nutrientProfile.getProtein() <= totalProtein && nutrientProfile.getOther() <= totalOther
                    && nutrientProfile.getCalories() <= totalCalories) {
                break;
            }

            totalGrains = totalGrains + item.getGrainContent();
            totalFVContent = totalFVContent + item.getFVContent();
            totalProtein = totalProtein + item.getProContent();
            totalOther = totalOther + item.getOther();
            totalCalories = totalCalories + item.getCalories();

            pickedItems.add(item);
            InventoryData.deleteFoodItem(item.getId());
            iterator.remove();
        }

        return pickedItems;
    }

    private List<FoodItem> pickMinimumItem2(List<FoodItem> items, WeeklyNutrientProfile nutrientProfile) {
        Collections.sort(items, new Comparator<FoodItem>() {
            @Override 
            public int compare(FoodItem item1, FoodItem item2) {
                return item1.getGrainContent() - item2.getGrainContent();
            }
        });
        List<FoodItem> minGrainItems = new ArrayList<>();
        long totalGrains = 0;
        for (FoodItem item : items) {
            totalGrains += item.getGrainContent();
            if (totalGrains >= nutrientProfile.getWholeGrain()) {
                break;
            }
        }

        return pickedItems;
    }
}
