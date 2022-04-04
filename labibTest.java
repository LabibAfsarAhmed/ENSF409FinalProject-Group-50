import java.io.*;
import java.util.*;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

public class labibTest {
    public class labibTest {
    @Test 
    public void weeklyServicesWorks() {
        if (familyProfile.mobility == true) {
            int numberofFamilyHampersNeeded = Order.NUMBER_OF_FAMILIES();

            CreateMultipleHamper multipleHamper = new CreateMultipleHamper();
            int numberofHampers = multipleHamper.CalculateHamper();
            assertEquals("The correct number of weekly hampers not made.", numberofFamilyHampersNeeded, numberofHampers);
        }
        
        else {
            assertFalse("Weekly service is not needed", false) 
        }
    }
}