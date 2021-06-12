public class Alocasia extends Planten {

    public static final String SOORT = "Alocasia";
    int humidity;

    public Alocasia(String naam, String soort, int waterbehoefte, int phWaarde, int humidity){
        super(naam, soort, waterbehoefte, phWaarde);
        if(!soort.equals("Alocasia")){
            throw new IllegalArgumentException();
        }
        this.humidity = humidity;
    }

    @Override
    public boolean kwaliteitCheck() {
        return false;
    }


    public static String getSOORT() {
        return SOORT;
    }

    public int getHumidity() { return humidity; }

    @Override
    public String toString() {
        String result = String.format("Plant [Naam: %s , Soort: %s, Waterbehoefte: %d, PH: %d Humidity: %d] \n ",
                getNaam(),
                getSOORT(),
                getWaterbehoefte(),
                getPhWaarde(),
                getHumidity());
        return result;
    }

}
