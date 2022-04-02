public class labibTest {
    public class labibTest {
    @Test 
    public void weeklyServicesWorks() {
        if (familyProfile.mobility == true) {
            int numberofFamilies = 2;

            CreateMultipleHamper multipleHamper = new CreateMultipleHamper();
            int numberofHampers = multipleHamper.CalculateHamper();
            assertEquals(2, numberofHampers);
        }
        
        else {
            assertFalse("Weekly service is not needed", false) 
        }
    }
}