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
            phWaardeCheck(phWaarde);
            this.naam = naam;
            this.soort = soort;
            this.waterbehoefte = waterbehoefte;
            this.phWaarde = phWaarde;
            plants = new ArrayList<>();
            plants.add(this);
        }

    public static boolean waterCheck(int waterbehoefte){
        if(waterbehoefte <= 2){
            throw new IllegalArgumentException("Waterbehoefte te laag");
        }
        return true;
    }

    public static boolean phWaardeCheck(int phWaarde){
        if(phWaarde > 7 || phWaarde < 5){
            throw new IllegalArgumentException("PH verkeerd");
        }
        return true;
    }

    public abstract boolean kwaliteitCheck();


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

    public abstract String toString();
}
