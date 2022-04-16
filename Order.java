import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String employeeName;
    private LocalDateTime date;

    private List<FamilyProfile> requestedFamilies;
    private List<FoodItem> createdHampers;

    public Order(String employeeName, List<FamilyProfile> requestedFamilies) {
        this.employeeName = employeeName;
        this.date = LocalDateTime.now();
        this.requestedFamilies = requestedFamilies;
        this.createdHampers = new ArrayList<>();
    }

    public List<FamilyProfile> getRequestedFamilies() {
        return requestedFamilies;
    }
    public List<FoodItem> getCreatedHampers() {
        return createdHampers;
    }

    public void setCreatedHamper(List<FoodItem> createdHampers) {
        this.createdHampers = createdHampers;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(employeeName);
        sb.append("\nDate: ").append(date);

        sb.append("\n\nOriginal Request\n");
        for (int i = 0; i < requestedFamilies.size(); i++) {
            sb.append("Hamper ").append(i + 1).append(":");
            sb.append(requestedFamilies.get(i)).append("\n");
        }

        sb.append("\n");
        for (int i = 0; i < createdHampers.size(); i++) {
            sb.append("\nHamper ").append(i + 1).append(" Items\n");
            sb.append(createdHampers.get(i)).append("\n");
        }

        return sb.toString();
    }


}
