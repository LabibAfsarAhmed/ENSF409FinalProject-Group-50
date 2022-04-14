import java.util.*;
import java.io.*;
public class ConfigureHamper extends Hamper {

    private static String requestNewMultipleHampers;
    private static String newRequest;
    public List<Integer> foodID = new ArrayList<>();

    public ConfigureHamper(String form){
        this.newRequest = newRequest;
    //somehow get all the items from order form
    // store it in an array list
    //form will be an adjaceny matrix or convert it to a txt file?
        while (form.hasNextLine()){
            int id = form.nextLine();
            foodID.add(id);        //fills up list with all the food items from form

        }
        setList(foodID);  //full array with all the items are set
    }
    public ConfigureHamper() {
    }
    public void setList(List<Integer> foodID) {   //set the list
        this.foodID = foodID;
    }

    public List getList(){   //get the filled list
        return foodID;
    }
    public static String getNewRequest(){
        return newRequest;
    }

    public static String getRequestMultipleHampers(){
        return requestNewMultipleHampers;
    }
    
}
