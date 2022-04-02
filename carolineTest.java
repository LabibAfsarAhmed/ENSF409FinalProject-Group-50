import org.junit.Test;

import jdk.jfr.Timestamp;

import org.junit.Assert;
import static org.junit.Assert.*;


public class carolineTest {
    //testing for shortage in inventory 
    @Test
    public void testShortageException(){
        Inventroy inventory = new Inventory ("inventory.sql");
        inventory.getStock(Inventory);

        try{
            inventory.ShortageException();
            fail("Error: shortage in inventory");
        }
        catch (Excetion e){
            assertTrue(True);
        }
    }
}
