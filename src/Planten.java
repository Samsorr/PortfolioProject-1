import java.util.ArrayList;
import java.util.List;

public abstract class Planten {

    private String naam;
    private String soort;
    private int waterbehoefte;
    private int phWaarde;
    private List<Planten> plants;


    public Planten(String naam, String soort, int waterbehoefte, int phWaarde) {
        waterCheck(waterbehoefte);

        this.naam = naam;
        this.soort = soort;
        this.waterbehoefte = waterbehoefte;
        this.phWaarde = phWaarde;
        plants = new ArrayList<>();
        plants.add(this);
    }

    public static boolean waterCheck(int waterbehoefte) {
        if (waterbehoefte <= 2) {
            throw new IllegalArgumentException("Waterbehoefte te laag");
        }
        return true;
    }


    public abstract boolean kwaliteitCheck();

    public abstract String toString();


    public String getNaam() {
        return naam;
    }

    public String getSoort() {
        return soort;
    }

    public int getWaterbehoefte() {
        return waterbehoefte;
    }

    public int getPhWaarde() {
        return phWaarde;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public void setWaterbehoefte(int waterbehoefte) {
        this.waterbehoefte = waterbehoefte;
    }

    public void setPhWaarde(int phWaarde) {
        this.phWaarde = phWaarde;
    }

    public void setPlants(List<Planten> plants) {
        this.plants = plants;
    }

}

