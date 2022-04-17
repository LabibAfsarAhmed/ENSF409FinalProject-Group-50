import java.util.List;

public class Hamper {
    private List<FoodItem> foodItems;

    public Hamper(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }
}
