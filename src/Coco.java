public class Coco extends Planten {

    public static final String SOORT = "Coco";

    public Coco(String naam, String soort, int waterbehoefte){
        super(naam, soort, waterbehoefte);
    }


    public static String getSOORT() {
        return SOORT;
    }

    @Override
    public String toString() {
        String result = String.format("Plant [Naam: %s , Soort: %s, Waterbehoefte: %d] \n ",
                getNaam(),
                getSOORT(),
                getWaterbehoefte());
        return result;
    }

}
