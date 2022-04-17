import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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
            List<FoodItem> items = pickMinimumItem2(InventoryData.getFoodItems(),
                    familyProfile.getWeeklyNutrientProfile());

            Hamper hamper = new Hamper(items);
            hampers.add(hamper);
        }

        order.setCreatedHamper(hampers);
    }

    // private List<FoodItem> pickMinimumItem(List<FoodItem> items, WeeklyNutrientProfile nutrientProfile) {
    //     int totalGrains = 0;
    //     int totalFVContent = 0;
    //     int totalProtein = 0;
    //     int totalOther = 0;
    //     int totalCalories = 0;
    //     List<FoodItem> pickedItems = new ArrayList<>();

    //     Iterator<FoodItem> iterator = items.iterator();
    //     while (iterator.hasNext()) {
    //         FoodItem item = iterator.next();

    //         if (nutrientProfile.getWholeGrain() <= totalGrains && nutrientProfile.getFruitVeggies() <= totalFVContent
    //                 && nutrientProfile.getProtein() <= totalProtein && nutrientProfile.getOther() <= totalOther
    //                 && nutrientProfile.getCalories() <= totalCalories) {
    //             break;
    //         }

    //         totalGrains = totalGrains + item.getGrainContent();
    //         totalFVContent = totalFVContent + item.getFVContent();
    //         totalProtein = totalProtein + item.getProContent();
    //         totalOther = totalOther + item.getOther();
    //         totalCalories = totalCalories + item.getCalories();

    //         pickedItems.add(item);
    //         InventoryData.deleteFoodItem(item.getId());
    //         iterator.remove();
    //     }

    //     return pickedItems;
    // }

    private List<FoodItem> pickMinimumItem2(List<FoodItem> items, WeeklyNutrientProfile nutrientProfile) {
        List<FoodItem> minGrainItems = new ArrayList<>();
        long neededGrains = nutrientProfile.getWholeGrain();
        long neededFV = nutrientProfile.getFruitVeggies();
        long neededProtein = nutrientProfile.getProtein();
        long neededOther = nutrientProfile.getOther();
        long neededCalories = nutrientProfile.getCalories();

        items.sort(Comparator.comparing(FoodItem::getGrainContent).reversed());
        for (FoodItem item : items) {
            if (neededGrains <= 0)
                break;
            if (item.getGrainContent() == 0 || item.getGrainContent() > neededGrains)
                continue;
            neededGrains -= item.getGrainContent();
            neededFV -= item.getFVContent();
            neededProtein -= item.getProContent();
            neededOther -= item.getOther();
            neededCalories -= item.getCalories();
            minGrainItems.add(item);
        }

        List<FoodItem> minFVItems = new ArrayList<>();
        items.sort(Comparator.comparing(FoodItem::getFVContent).reversed());
        for (FoodItem item : items) {
            if (neededFV <= 0)
                break;
            if (item.getFVContent() == 0 || item.getFVContent() > neededFV)
                continue;
            neededGrains -= item.getGrainContent();
            neededFV -= item.getFVContent();
            neededProtein -= item.getProContent();
            neededOther -= item.getOther();
            neededCalories -= item.getCalories();
            minFVItems.add(item);
        }

        List<FoodItem> minProteinItems = new ArrayList<>();
        items.sort(Comparator.comparing(FoodItem::getProContent).reversed());
        for (FoodItem item : items) {
            if (neededProtein <= 0)
                break;
            if (item.getProContent() == 0 || item.getProContent() > neededProtein)
                continue;
            neededGrains -= item.getGrainContent();
            neededFV -= item.getFVContent();
            neededProtein -= item.getProContent();
            neededOther -= item.getOther();
            neededCalories -= item.getCalories();
            minProteinItems.add(item);
        }

        List<FoodItem> minOtherItems = new ArrayList<>();
        items.sort(Comparator.comparing(FoodItem::getOther).reversed());
        for (FoodItem item : items) {
            if (neededOther <= 0)
                break;
            if (item.getOther() == 0 || item.getOther() > neededOther)
                continue;
            neededGrains -= item.getGrainContent();
            neededFV -= item.getFVContent();
            neededProtein -= item.getProContent();
            neededOther -= item.getOther();
            neededCalories -= item.getCalories();
            minOtherItems.add(item);
        }


        List<FoodItem> minCaloriesItems = new ArrayList<>();
        items.sort(Comparator.comparing(FoodItem::getCalories).reversed());
        for (FoodItem item : items) {
            if (neededCalories <= 0)
                break;
            if (item.getCalories() == 0 || item.getCalories() > neededCalories)
                continue;
            neededGrains -= item.getGrainContent();
            neededFV -= item.getFVContent();
            neededProtein -= item.getProContent();
            neededOther -= item.getOther();
            neededCalories -= item.getCalories();
            minCaloriesItems.add(item);
        }


        List<FoodItem> pickedItems = new ArrayList<>();
        pickedItems.addAll(minGrainItems);
        pickedItems.addAll(minFVItems);
        pickedItems.addAll(minProteinItems);
        pickedItems.addAll(minOtherItems);
        pickedItems.addAll(minCaloriesItems);

        pickedItems = new ArrayList<>(new HashSet<>(pickedItems));
        pickedItems.sort(Comparator.comparing(FoodItem::getId));
        pickedItems.stream().map(i -> i.getId()).forEach(InventoryData::deleteFoodItem);
        items.removeAll(pickedItems);

        // System.out.println("Expected Grains: " + nutrientProfile.getWholeGrain());
        // System.out.println(pickedItems.stream().map(FoodItem::getGrainContent).reduce(0, Integer::sum));
        // System.out.println("Expected Fruits: " + nutrientProfile.getFruitVeggies());
        // System.out.println(pickedItems.stream().map(FoodItem::getFVContent).reduce(0, Integer::sum));
        // System.out.println("Expected Protein: " + nutrientProfile.getProtein());
        // System.out.println(pickedItems.stream().map(FoodItem::getProContent).reduce(0, Integer::sum));
        // System.out.println("Expected Other: " + nutrientProfile.getOther());
        // System.out.println(pickedItems.stream().map(FoodItem::getOther).reduce(0, Integer::sum));
        // System.out.println("Expected Calories: " + nutrientProfile.getCalories());
        // System.out.println(pickedItems.stream().map(FoodItem::getCalories).reduce(0, Integer::sum));

        return pickedItems;
    }

}