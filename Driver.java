import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<FamilyProfile> requestedFamilies = new ArrayList<>();
        UI ui = new TerminalUI();
        String name = ui.inputName();

        while (true) {
            requestedFamilies.add(ui.inputFamilyProfile());

            if (!ui.hasMore()) {
                break;
            }
        }

        Order order = new Order(name, requestedFamilies);
        System.out.println(order);

    }
}
