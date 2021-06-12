public class Gebruiker {

    private String naam;
    private String wachtwoord;

    public Gebruiker(String naam, String wachtwoord) {
        this.naam = naam;
        this.wachtwoord = wachtwoord;
    }




    public boolean wachtwoordCheck (String wachtwoord) {
        return wachtwoord.equals (this.wachtwoord);
    }




    public String getNaam () {
        return naam;
    }

    public void setName(String name) {
        this.naam = name;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

}
