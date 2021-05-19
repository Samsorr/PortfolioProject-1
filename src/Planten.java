import java.util.ArrayList;

public class Planten {

    private String naam;
    private String soort;
    private int waterbehoefte;
    private static ArrayList<Planten> plantenlijst = new ArrayList<>();


    public Planten(String naam, String soort, int waterbehoefte) {
            soortCheck(soort);
            waterCheck(waterbehoefte);
            this.naam = naam;
            this.soort = soort;
            this.waterbehoefte = waterbehoefte;
            plantenlijst.add(this);
        }


    public boolean soortCheck(String soort){
            if(!(soort.equals("Kentiapalm") || soort.equals("Alocasia") || soort.equals("Coco"))){
                throw new IllegalArgumentException("Error, verkeerde soort");
            }
        return true;
    }
    public boolean waterCheck(int waterbehoefte){
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

    public static ArrayList<Planten> getPlantenlijst() {
        return plantenlijst;
    }
}
