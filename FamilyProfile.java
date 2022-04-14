<<<<<<< HEAD
import java.util.Scanner;

public class FamilyProfile {
    
    private int familyNum;
    private int adultsNum;
    private int childrenUnderEight;
    private int childrenOverEight;
    private String gender;
    private boolean mobility;

    public FamilyProfile() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number of family members: ");
        familyNum = scan.nextInt();

        System.out.println("Enter number of adult family members: ");
        adultsNum = scan.nextInt();

        System.out.println("Enter number of children under eight years old: ");
        childrenUnderEight = scan.nextInt();

        System.out.println("Enter number of children over eight years old: ");
        childrenOverEight = scan.nextInt();

        System.out.println("Enter number of children over eight years old: ");
        gender = scan.nextLine();

        System.out.println("Do you need weekly services?(y/n): ");
        mobility = scan.nextBoolean();

        scan.close();
    }

    public int getFamilyNumber() {
        return familyNum;
    }

    public int getAdultsNum() {
        return adultsNum;
    }

    public int getChildrenUnderEight() {
        return childrenUnderEight;
    }

    public int getChildrenOverEight() {
        return childrenOverEight; 
    }

    public String getGender() {
        return gender;

    }

    public boolean getmobility() {
        return mobility;
    }

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
}
