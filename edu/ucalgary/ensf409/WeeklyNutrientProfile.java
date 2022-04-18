package edu.ucalgary.ensf409;

//Weekly need of all the family members
public class WeeklyNutrientProfile {
    private long wholeGrains;
    private long fruitVeggies;
    private long protein;
    private long other;
    private long calories;

    public WeeklyNutrientProfile(long wholeGrains,
            long fruitVeggies,
            long protein,
            long other,
            long calories) {

        this.wholeGrains = wholeGrains;
        this.fruitVeggies = fruitVeggies;
        this.protein = protein;
        this.other = other;
        this.calories = calories;
    }

    public long getWholeGrain() {
        return wholeGrains;
    }

    public long getFruitVeggies() {
        return fruitVeggies;
    }

    public long getProtein() {
        return protein;
    }

    public long getOther() {
        return other;
    }

    public long getCalories() {
        return calories;
    }
}
