public class FoodItem {
    private int id;
    private String name;
    private int grainContent;
    private int fvContent;
    private int proContent;
    private int other;
    private int calories;

    public FoodItem(int id,
            String name,
            int grainContent,
            int fvContent,
            int proContent,
            int other,
            int calories) {
        this.id = id;
        this.name = name;
        this.grainContent = grainContent;
        this.fvContent = fvContent;
        this.proContent = proContent;
        this.other = other;
        this.calories = calories;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrainContent() {
        return grainContent;
    }

    public int getFVContent() {
        return fvContent;
    }

    public int getProContent() {
        return proContent;
    }

    public int getOther() {
        return other;
    }

    public int getCalories() {
        return calories;
    }
}
