import java.util.ArrayList;
import java.util.List;

public class PlantenCatalog {

    private static ArrayList<Planten> planten;

    public PlantenCatalog() {
        this.planten = new ArrayList<>();
    }

    public static void add(Planten plant) {
        planten.add(plant);
    }


    public static ArrayList<Planten> retrieveCatalog(){
        return planten = Connect.selectPlant();
    }

    public static ArrayList<Planten> getPlanten() {
        return planten;
    }

    public static void updatePlant(Planten plant) {
        planten.removeIf(plant1 -> plant1.equals(plant));
        planten.add(plant);
    }

    public static void deletePlant(Planten plant) {
        planten.removeIf(plant1 -> plant1.equals(plant));
    }


    public String toString() {
        String result = "";
        for (Planten plant : planten) {
            result += plant.toString();
        }

        return result;
    }


}


