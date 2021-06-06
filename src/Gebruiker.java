public class Gebruiker {

    private String name;
    private String wachtwoord;

    public Gebruiker(String name, String wachtwoord) {
        this.name = name;
        this.wachtwoord = wachtwoord;
    }

    public String getName () {
        return name;
    }

    public boolean wachtwoordCheck (String wachtwoord) {
        return wachtwoord.equals (this.wachtwoord);
    }
}

