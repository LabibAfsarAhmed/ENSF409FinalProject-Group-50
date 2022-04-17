import java.util.*;
public class CalculateHamper extends ConfigureHamper {
    
    public CalculateHamper(){
        super();   //needs a super constructor, still have to fix this
        List foodID = getList();
        int males = getAdultMales();
        int females = getAdultFemales();
        int over8 = getChildrenOver8();
        int under8 = getChildrenUnder8();

    }
    
    //need to come up with the algorithm, expected values and how to access database
    //first add items in hamper,and calculate each part(grain, FV, protein,etc), then if it is under the amount needed,
    //add the item with the lowest amount. then if that is not enough, add the second lowest amount
    //and so on. terminate program if item is not in inventory. 
}
