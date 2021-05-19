import java.util.ArrayList;

public abstract class Planten {

    private String naam;
    private String soort;
    private int waterbehoefte;
    private int interval;


    public Planten(String naam, String soort, int waterbehoefte, int interval) {
            waterCheck(waterbehoefte);
            this.naam = naam;
            this.soort = soort;
            this.waterbehoefte = waterbehoefte;
            this.interval =interval;

        }

    public static boolean waterCheck(int waterbehoefte){
        if(waterbehoefte <= 2){
            throw new IllegalArgumentException("Error, waterbehoefte te laag");
        }
        return true;
    }


    public String getNaam() {
        return naam;
    }

    public String getSoort() {
        return soort;
    }

    public int getWaterbehoefte() {
        return waterbehoefte;
    }

    public void setWaterbehoefte(int waterbehoefte) {
        this.waterbehoefte = waterbehoefte;
    }

    public int getInterval() {
        return interval;
    }


    public abstract String toString();
}
