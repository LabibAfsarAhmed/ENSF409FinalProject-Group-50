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
        List<FoodItem> minGrainItems = new ArrayList<>();
        Collections.sort(items, new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem item1, FoodItem item2) {
                return item1.getGrainContent() - item2.getGrainContent();
            }
        });

        long totalGrains = 0;
        for (FoodItem item : items) {
            if (item.getGrainContent() == 0) {
                continue;
            }
            if (totalGrains >= nutrientProfile.getWholeGrain()) {
                break;
            }
            totalGrains += item.getGrainContent();
            minGrainItems.add(item);

        }

        List<FoodItem> minFVItems = new ArrayList<>();
        Collections.sort(items, new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem item1, FoodItem item2) {
                return item1.getFVContent() - item2.getFVContent();
            }
        });

        long totalFV = 0;
        for (FoodItem item : items) {
            if (item.getFVContent() == 0) {
                continue;
            }
            if (totalFV >= nutrientProfile.getFruitVeggies()) {
                break;
            }
            totalFV += item.getFVContent();
            minFVItems.add(item);

        }

        List<FoodItem> minProteinItems = new ArrayList<>();
        Collections.sort(items, new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem item1, FoodItem item2) {
                return item1.getProContent() - item2.getProContent();
            }
        });

        long totalProtein = 0;
        for (FoodItem item : items) {
            if (item.getProContent() == 0) {
                continue;
            }
            if (totalProtein >= nutrientProfile.getProtein()) {
                break;
            }
            totalProtein += item.getProContent();
            minProteinItems.add(item);

        }

        List<FoodItem> minOtherItems = new ArrayList<>();
        Collections.sort(items, new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem item1, FoodItem item2) {
                return item1.getOther() - item2.getOther();
            }
        });

        long totalOther = 0;
        for (FoodItem item : items) {
            if (item.getOther() == 0) {
                continue;
            }
            if (totalOther >= nutrientProfile.getOther()) {
                break;
            }
            totalOther += item.getOther();
            minOtherItems.add(item);

        }

        List<FoodItem> minCaloriesItems = new ArrayList<>();
        Collections.sort(items, new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem item1, FoodItem item2) {
                return item1.getCalories() - item2.getCalories();
            }
        });

        long totalCalories = 0;
        for (FoodItem item : items) {
            if (item.getCalories() == 0) {
                continue;
            }
            if (totalCalories >= nutrientProfile.getCalories()) {
                break;
            }
            totalCalories += item.getCalories();
            minCaloriesItems.add(item);

        }

        // System.out.println("\n\n");
        // System.out.println(minGrainItems);
        // System.out.println("\n\n");
        // System.out.println(minFVItems);
        // System.out.println("\n\n");
        // System.out.println(minProteinItems);
        // System.out.println("\n\n");
        // System.out.println(minOtherItems);
        // System.out.println("\n\n");
        // System.out.println(minCaloriesItems);

        List<FoodItem> pickedItems = new ArrayList<>();
        pickedItems.addAll(minGrainItems);
        pickedItems.addAll(minFVItems);
        pickedItems.addAll(minProteinItems);
        pickedItems.addAll(minOtherItems);
        pickedItems.addAll(minCaloriesItems);

        pickedItems = new ArrayList<>(new HashSet<>(pickedItems));

        Collections.sort(pickedItems, new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem item1, FoodItem item2) {
                return item1.getId() - item2.getId();
            }
        });

        pickedItems.stream().map(i -> i.getId()).forEach(InventoryData::deleteFoodItem);
        items.removeAll(pickedItems);

        return pickedItems;
    }

}
