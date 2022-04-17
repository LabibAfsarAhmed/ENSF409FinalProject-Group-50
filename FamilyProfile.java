<<<<<<< HEAD
<<<<<<< HEAD
import java.util.Scanner;

=======
>>>>>>> db31d11ed78c9725df1fc6feaeda0d16291fd871
public class FamilyProfile {
    private int adultMale;
    private int adultFemale;
    private int childrenUnderEight;
    private int childrenOverEight;
    private boolean mobility;

    public FamilyProfile(int adultMale, int adultFemale,  int childrenUnderEight, int childrenOverEight, boolean mobility) {
        this.adultMale = adultMale;
        this.adultFemale = adultFemale;
        this.childrenUnderEight = childrenUnderEight;
        this.childrenOverEight = childrenOverEight;
        this.mobility = mobility;
    }

    public int getAdultMale() {
        return adultMale;
    }

    public int getAdultFemale() {
        return adultFemale;
    }

    public int getChildrenUnderEight() {
        return childrenUnderEight;
    }

    public int getChildrenOverEight() {
        return childrenOverEight;
    }

    public boolean isMobility() {
        return mobility;
    }

<<<<<<< HEAD
    public void getFamilyNumber(int familyNum) {
        this.familyNum = familyNum;
    }

    public void getAdultsNum(int adultsNum) {
        this.adultsNum = adultsNum;
    }

    public void getChildrenUnderEight(int childrenUnderEight) {
        this.childrenUnderEight = childrenUnderEight;
    }

    public void getChildrenOverEight(int childrenOverEight) {
        this.childrenOverEight= childrenOverEight;
    }

    public void getGender(String gender) {
        this.gender = gender;
    }

    public void setmobility(boolean mobility) {
        this.mobility = mobility;
    }
=======



public class FamilyProfile {
    private int adultFemales;
    private int adultMales;
    private int childrenUnder8;
    private int childrenOver8;
    private int multipleHampers;
    private int weeklyServiceHampers;

    public FamilyProfile(int adultFemales, int adultMales, int childrenOver8, int childrenUnder8, int multipleHampers, int weeklyServiceHampers){
        this.adultFemales = adultFemales;
        this.adultMales = adultMales;
        this.childrenOver8 = childrenOver8;
        this.childrenUnder8 = childrenUnder8;
        this.multipleHampers = multipleHampers;
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

    public int getWeeklyServiceHampers(){
        return this.weeklyServiceHampers;
    }

>>>>>>> ce069e862eae348dbd1399009c31f330dd6986d1
=======
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (adultMale > 0)
            sb.append(" ").append(adultMale).append(" Adult Male,");
        if (adultFemale > 0)
            sb.append(" ").append(adultFemale).append(" Adult Female,");
        if (childrenUnderEight > 0)
            sb.append(" ").append(childrenUnderEight).append(" Child under 8,");
        if (childrenOverEight > 0)
            sb.append(" ").append(childrenOverEight).append(" Child over 8,");
        if (mobility)
            sb.append(" Weekly Service Needed,");
        
        return sb.toString().replaceAll(",$", "");
    }

>>>>>>> db31d11ed78c9725df1fc6feaeda0d16291fd871
}
