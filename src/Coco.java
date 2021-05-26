public class Coco extends Planten {

    public static final String SOORT = "Coco";

    public Coco(String naam, String soort, int waterbehoefte, int phWaarde){
        super(naam, soort, waterbehoefte, phWaarde);
    }


    public static String getSOORT() {
        return SOORT;
    }

    @Override
    public String toString() {
        String result = String.format("Plant [Naam: %s , Soort: %s, Waterbehoefte: %d, PH: %d] \n ",
                getNaam(),
                getSOORT(),
                getWaterbehoefte(),
                getPhWaarde());
        return result;
    }

}
