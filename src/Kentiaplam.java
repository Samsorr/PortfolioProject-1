public class Kentiaplam extends Planten {
    public static final String SOORT = "Kentiaplam";
    private int interval;

    public Kentiaplam(String naam, String soort, int waterbehoefte, int interval){
        super(naam, soort, waterbehoefte);
        this.interval =interval;
    }


    public static String getSOORT() {
        return SOORT;
    }

    public int getInterval() { return interval;}

    public int setInterval() { return interval; }

    @Override
    public String toString() {
        String result = String.format("Plant [Naam: %s , Soort: %s, Waterbehoefte: %d, Interval: %d] \n ",
                getNaam(),
                getSOORT(),
                getWaterbehoefte(),
                getInterval());
        return result;
    }


}
