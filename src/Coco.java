public class Coco extends Planten {

    public static final String SOORT = "Coco";

    public Coco(String naam, String soort, int waterbehoefte, int phWaarde){
        super(naam, soort, waterbehoefte, phWaarde);
    }

    @Override
    public boolean kwaliteitCheck() {
        if(getPhWaarde() < 3 || getWaterbehoefte() > 18){               //deze waarde zijn niet gewenst en melden dit aan de gebruiker.
            return false;
            }
            return true;
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
