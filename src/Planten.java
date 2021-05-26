public abstract class Planten {

    private String naam;
    private String soort;
    private int waterbehoefte;
    private int phWaarde;



    public Planten(String naam, String soort, int waterbehoefte, int phWaarde) {
            waterCheck(waterbehoefte);
            phWaardeCheck(phWaarde);
            this.naam = naam;
            this.soort = soort;
            this.waterbehoefte = waterbehoefte;
            this.phWaarde = phWaarde;

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
