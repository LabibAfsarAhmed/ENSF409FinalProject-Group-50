public class WeeklyNutrientProfile {
    private int wholeGrains;
    private int fruitVeggies;
    private int protein;
    private int other;
    private long calories;

    public WeeklyNutrientProfile(int wholeGrains,
            int fruitVeggies,
            int protein,
            int other,
            long calories) {

        this.wholeGrains = wholeGrains;
        this.fruitVeggies = fruitVeggies;
        this.protein = protein;
        this.other = other;
        this.calories = calories;
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

    public long getCalories() {
        return calories;
    }
}
