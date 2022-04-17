package edu.ucalgary.ensf409;

import java.util.List;

public class Hamper {
    private List<FoodItem> foodItems;

    public Hamper(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (FoodItem item : foodItems) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
