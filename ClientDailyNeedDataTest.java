/**
 @author Jannine Osman <a href="mailto:jannine.osman@ucalgary.ca">jannine.osman@ucalgary.ca</a>
         Sukriti Sharma <a href="mailto:sukriti.sharma@ucalgary.ca">sukriti.sharma@ucalgary.ca</a>
         Caroline Basta <a href="mailto:caroline.basta1@ucalgary.ca">caroline.basta1@ucalgary.ca</a>
         Labib Afsar Ahmed <a href="mailto:labibafsar.ahmed@ucalgary.ca">labibafsar.ahmed@ucalgary.ca</a>
 @version       1.8
 @since         1.0
 */

import static org.junit.Assert.*;
import org.junit.*;


public class ClientDailyNeedDataTest{
    int testAdultMaleGrains = 385;
    int testAdultFemaleGrains  = 350;
    int testChildUnderEightGrains  = 175;
    int testChildOverEightGrains  = 140;

    int testAdultMaleFV= 385;
    int testAdultFemaleFV= 350;
    int testChildUnderEightFV = 175;
    int testChildOverEightFV  = 140;

    int testAdultMalePro= 385;
    int testAdultFemalePro= 350;
    int testChildUnderEightPro= 175;
    int testChildOverEightPro = 140;

    int testAdultMaleOther= 385;
    int testAdultFemaleOther= 350;
    int testChildUnderEightOther= 175;
    int testChildOverEightOther = 140;

    int testAdultMaleCalories = 385;
    int testAdultFemaleCalories= 350;
    int testChildUnderEightCalories= 175;
    int testChildOverEightCalories = 140;

    int testID = 1;

    public void calculateWeeklyFamilyNeedsConstructorAdultMale(){
        //DailyNeed testConstructor = new DailyNeed(1,"Adult Male",testAdultMaleGrains,testAdultMaleFV,testAdultMalePro, testAdultMaleOther, testAdultMaleCalories);
        //DailyNeed DailyNeedConstructorMale = testConstructor.getDailyNeed(1);
        ClientDailyNeedData con = new ClientDailyNeedData();
        ClientDailyNeedData expected = con.getDailyNeed(1);
        assertNotNull("Daily Need constructor did not create an object when given valid arguments.", DailyNeedConstructorMale);
    }
    
    public void calculateWeeklyFamilyNeedsConstructorAdultFemale(){
        DailyNeed DailyNeedConstructorFemale = getDailyNeed(2);
        assertNotNull("Daily Need constructor did not create an object when given valid arguments.", DailyNeedConstructorFemale);
    }
    

    public void calculateWeeklyFamilyNeedsConstructorChildOverEight(){
            DailyNeed DailyNeedConstructorChildOverEight = getDailyNeed(3);
            assertNotNull("Daily Need constructor did not create an object when given valid arguments.", DailyNeedConstructorChildOverEight);
    }
    

    public void calculateWeeklyFamilyNeedsConstructorChildUnderEight(){
        DailyNeed DailyNeedConstructorChildUnderEight = getDailyNeed(4);
        assertNotNull("Daily Need constructor did not create an object when given valid arguments.", DailyNeedConstructorChildUnderEight);
    }

    @Test 
        public void calculateWeeklyFamilyWholeGrains(){
            ClientDailyNeedData newData = new ClientDailyNeedData();
            int wholeGrainforOneDay = newData.getWholeGrain(testAdultMaleGrains, testNameId, testAdultFemaleGrains, testChildUnderEightGrains, testChildOverEightGrains);
            int totalGrains = 1020;
            assertEquals("Method for whole grains didn't return expected values", totalGrains, wholeGrainforOneDay);
        }

    @Test 
        public void calculateWeeklyFamilyFruitVeggies(){}

    @Test 
        public void calculateWeeklyFamilyProtein(){}




}