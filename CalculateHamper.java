
import java.util.*;


public class CalculateHamper extends FamilyProfile {
        private int adultMale;
        private int adultFemale;
        private int childrenUnderEight;
        private int childrenOverEight;
        private boolean mobility;

        public CalculateHamper(int adultMale, int adultFemale, int childrenUnderEight, int childrenOverEight,
            boolean mobility) {
            super(adultMale, adultFemale, childrenUnderEight, childrenOverEight, mobility);
            this.adultMale = adultMale;
            this.adultFemale = adultFemale;
            this.childrenUnderEight = childrenUnderEight;
            this.childrenOverEight = childrenOverEight;
            this.mobility = mobility;
            FamilyProfile family = new FamilyProfile(adultMale, adultFemale, childrenUnderEight, childrenOverEight, mobility);
            ClientDailyNeedData.calculateWeeklyFamilyCalories(family);

    }
     /*   if(mobility == true){
            WeeklyService();
        } */



    // need to come up with the algorithm, expected values and how to access
    // database
    // first add items in hamper,and calculate each part(grain, FV, protein,etc),
    // then if it is under the amount needed,
    // add the item with the lowest amount. then if that is not enough, add the
    // second lowest amount
    // and so on. terminate program if item is not in inventory.
}