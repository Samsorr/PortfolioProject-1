import java.util.ArrayList;
import java.util.List;

public class PlantenCatalog {

    private List<Planten> planten;

    public PlantenCatalog() {
        this.planten = new ArrayList<>();
    }

    public void add(Planten plant) {
        planten.add(plant);
    }

    public String toString() {
        String result = "";
        for (Planten plant : planten) {
            result += plant.toString();
        }

        return result;
    }


    public List<Planten> sortType() {
        List<Planten> sortedList = new ArrayList<>();
        for (Planten plant : planten) {
            sortedList.add(plant);
        }
        return sortedList;
    }
}


