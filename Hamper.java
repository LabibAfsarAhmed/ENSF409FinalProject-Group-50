import java.util.*;

public class Hamper extends FamilyProfile {

    private int adultFemales;
    private int adultMales;
    private int childrenUnder8;
    private int childrenOver8;

    public Hamper(){

    }

    public Hamper(int adultFemales,int adultMales, int childrenUnder8, int childrenOver8){
        this.adultFemales = adultFemales;
        this.adultMales = adultMales;
        this.childrenUnder8 = childrenUnder8;
        this.childrenOver8 = childrenOver8;
    }
    

    public int getChildrenUnder8(){
        return this.childrenUnder8;
    }

    public int getChildrenOver8() {
        return this.childrenOver8;
    }

    public int getAdultFemales(){
        return this.adultFemales;
    }

    public int getAdultMales(){
        return this.adultMales;
    }
}
