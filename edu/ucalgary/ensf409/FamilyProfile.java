package edu.ucalgary.ensf409;

public class FamilyProfile {
    private int adultFemales;
    private int adultMales;
    private int childrenUnder8;
    private int childrenOver8;
    private int weeklyServiceHampers;
    private WeeklyNutrientProfile WeeklyNutrientProfile;

    public FamilyProfile(int adultFemales, int adultMales, int childrenOver8, int childrenUnder8, boolean weeklyServiceHampers){
        this.adultFemales = adultFemales;
        this.adultMales = adultMales;
        this.childrenOver8 = childrenOver8;
        this.childrenUnder8 = childrenUnder8;
    }

    public int getAdultFemales(){
        return this.adultFemales;
    }

    public int getAdultMales(){
        return this.adultMales;
    }

    public int getChildrenOver8(){
        return this.childrenOver8;
    }

    public int getChildrenUnder8(){
        return this.childrenUnder8;
    }

    public int getWeeklyServiceHampers() {
        return this.weeklyServiceHampers;
    }

    public WeeklyNutrientProfile getWeeklyNutrientProfile() {
        return this.WeeklyNutrientProfile;
    }

    public void setWeeklyNutrientProfile(WeeklyNutrientProfile weeklyNutrientProfile) {
        this.WeeklyNutrientProfile = weeklyNutrientProfile;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (adultMales > 0)
            sb.append(" ").append(adultMales).append(" Adult Male,");
        if (adultFemales > 0)
            sb.append(" ").append(adultFemales).append(" Adult Female,");
        if (childrenUnder8 > 0)
            sb.append(" ").append(childrenUnder8).append(" Child under 8,");
        if (childrenOver8 > 0)
            sb.append(" ").append(childrenOver8).append(" Child over 8,");
        
        return sb.toString().replaceAll(",$", "");
    }

}
