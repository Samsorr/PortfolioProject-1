public class Alocasia extends Planten {

    public static final String SOORT = "Alocasia";
    int humidity;

    public Alocasia(String naam, String soort, int waterbehoefte, int humidity){
        super(naam, soort, waterbehoefte);
        if(!soort.equals("Alocasia")){
            throw new IllegalArgumentException();
        }
        this.humidity = humidity;
    }


    public static String getSOORT() {
        return SOORT;
    }

    public int getHumidity() { return humidity; }

    @Override
    public String toString() {
        String result = String.format("Plant [Naam: %s , Soort: %s, Waterbehoefte: %d, Humidity: %d] \n ",
                getNaam(),
                getSOORT(),
                getWaterbehoefte(),
                getHumidity());
        return result;
    }

}
