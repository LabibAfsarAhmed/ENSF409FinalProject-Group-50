package edu.ucalgary.ensf409;

public class DailyNeed {
    private int id;
    private String clientType;
    private int wholeGrains;
    private int fruitVeggies;
    private int protein;
    private int other;
    private int calories;

    public DailyNeed(int id,
            String clientType,
            int wholeGrains,
            int fruitVeggies,
            int protein,
            int other,
            int calories) {

        this.id = id;
        this.clientType = clientType;
        this.wholeGrains = wholeGrains;
        this.fruitVeggies = fruitVeggies;
        this.protein = protein;
        this.other = other;
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public String getClientType() {
        return clientType;
    }

    public int getWholeGrain() {
        return wholeGrains;
    }

    public int getFruitVeggies() {
        return fruitVeggies;
    }

    public int getProtein() {
        return protein;
    }

    public int getOther() {
        return other;
    }

    public int getCalories() {
        return calories;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(" ");
        sb.append(clientType).append(" ");
        sb.append(wholeGrains).append(" ");
        sb.append(fruitVeggies).append(" ");
        sb.append(protein).append(" ");
        sb.append(other).append(" ");
        sb.append(calories).append(" ");
        return sb.toString();
    }
}