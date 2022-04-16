public class FamilyProfile {
    private String employeeName;
    private int adultFemales;
    private int adultMales;
    private int childrenUnder8;
    private int childrenOver8;
    private int multipleHampers;
    private int weeklyServiceHampers;

    public FamilyProfile(String employeeName, int adultFemales, int adultMales, int childrenOver8, int childrenUnder8,
            int multipleHampers, int weeklyServiceHampers) {
        this.employeeName = employeeName;
        this.adultFemales = adultFemales;
        this.adultMales = adultMales;
        this.childrenOver8 = childrenOver8;
        this.childrenUnder8 = childrenUnder8;
        this.multipleHampers = multipleHampers;

        
    }

    public String getemployeeName() {
        return this.employeeName;
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

    public int getMultipleHampers(){
        return this.multipleHampers;
    }

    public int getWeeklyServiceHampers() {
        return this.weeklyServiceHampers;
    }
     
}
