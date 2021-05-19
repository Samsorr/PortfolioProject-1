public class Coco extends Planten {

    public static final String SOORT = "Coco";

    public Coco(String naam, String soort, int waterbehoefte, int interval){
        super(naam, soort, waterbehoefte, interval);
    }


    public static String getSOORT() {
        return SOORT;
    }

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
