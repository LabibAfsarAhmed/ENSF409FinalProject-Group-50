import java.util.Scanner;

public class TerminalUI implements UI{

    public static Scanner scanner = new Scanner(System.in);
    
    public String inputName() {
        System.out.print("Please enter your name: ");
        return scanner.nextLine();
    }

    public FamilyProfile inputFamilyProfile() {
        System.out.println("Please enter family details: ");
        System.out.print("Number of Adult Male: ");
        int adultMale = scanner.nextInt();
        System.out.print("Number of Adult Female: ");
        int adultFemale = scanner.nextInt();
        System.out.print("Number of Child(under 8): ");
        int childrenOverEight = scanner.nextInt();
        System.out.print("Number of Child(over 8): ");
        int childrenUnderEight = scanner.nextInt();
        System.out.print("Do you need weekly service?(true/false): ");
        boolean mobility = scanner.nextBoolean();

        return new FamilyProfile(adultMale, adultFemale, childrenUnderEight, childrenOverEight, mobility);
    }
    
    public void showFamilyAddedMessage() {
        System.out.print("Family succesfully added!");
    }
    
    public boolean hasMore() {
        System.out.print("Do you want to add another family?(true/false): ");
        return scanner.nextBoolean();
    }

}
