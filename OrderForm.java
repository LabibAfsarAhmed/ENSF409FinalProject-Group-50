import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class OrderForm {
    public String placeOrder(){
        String info = "Hamper Order Form\n\n";
        String newOrder = "";
        info += "Name: \n";
        info += "Date: \n";
        info += "Original Request: \n";
        for (int i = 0; i< familyNum.size(); i++){
            info += String.format("Hamper %d: ", i+1);
            info += Integer.toString(familyNum.get(i).adultFemales.getAdultsNum() + " Adult female"
                  + Integer.toString(familyNum.get(i).adultMales.getAdultsNum() + " Adult male"
                  + Integer.toString(familyNum.get(i).childrenUnder8Yrs.getChildrenUnderEight() + " Child under 8"
                  + Integer.toString(familyNum.get(i).childrenOver8Yrs.getChildrenOverEight() + " Child over 8"))));
        }
        info += "\n"; 

        for (int i = 0; i< familyNum.size(); i++){
            hamperItems += String.format("Hamper %d Items: \n", i+1);
            Hamper hamper = familyNum.get(i).getListFoodItems();
            hamperItems += hamper.newRequest();
            hamperItems += "\n\n";
        }
        info += hamperItems;
        return info;
    }

    public String getListFoodItems(){
        String list = "";
        Iterator<Inventory> newIterator = this.newRequest.iterator();
        while (newIterator.hasNext()){
            list += newIterator.next().getName() + "\n";
        }
        return list;
    }


   public static void outputToText(FamilyProfile fam, String filename){
        String order = fam.placeOrder();
        try {
            FileWriter myWriter = new FileWriter(filename);  
            myWriter.write(order);
            myWriter.close();
            System.out.println("Order printed successfully");  
            } catch (IOException e) {
            System.out.println("Error: please try again.");
            e.printStackTrace();
            }
        }
    }


