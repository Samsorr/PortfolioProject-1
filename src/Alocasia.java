public class Alocasia extends Planten {

    public static final String SOORT = "Alocasia";
    int luchtVochtigheid;

    public Alocasia(String naam, String soort, int waterbehoefte, int phWaarde, int luchtVochtigheid){
        super(naam, soort, waterbehoefte, phWaarde);
        if(!soort.equals("Alocasia")){
            throw new IllegalArgumentException();
        }
        this.luchtVochtigheid = luchtVochtigheid;
    }

    @Override
    public boolean kwaliteitCheck() {
        if(getPhWaarde() < 3 || getWaterbehoefte() < 2 || getLuchtVochtigheid() < 1){               //deze waarde zijn niet gewenst en melden dit aan de gebruiker.
            return false;
        }
        return true;
    }


    public static String getSOORT() {
        return SOORT;
    }

    public int getLuchtVochtigheid() { return luchtVochtigheid; }

    @Override
    public String toString() {
        String result = String.format("Plant [Naam: %s , Soort: %s, Waterbehoefte: %d, PH: %d Luchtvochtigheid: %d] \n ",
                getNaam(),
                getSOORT(),
                getWaterbehoefte(),
                getPhWaarde(),
                getLuchtVochtigheid());
        return result;
    }

}
