import java.util.Objects;

public class User {

    String gebruikersnaam;
    String wachtwoord;
    String geslacht;


    public User(String gebruikersnaam, String wachtwoord, String geslacht){

        this.gebruikersnaam = maxString(gebruikersnaam);
        this.wachtwoord = wachtwoord;
        this.geslacht = geslacht;
    }

    public String maxString(String gebruikersnaam){
        int max = 15;

        if(gebruikersnaam.length() > max){
            gebruikersnaam = gebruikersnaam.substring(0, max);
        }
        return gebruikersnaam;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public String getGeslacht() {
        return geslacht;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(gebruikersnaam, user.gebruikersnaam) && Objects.equals(wachtwoord, user.wachtwoord) && Objects.equals(geslacht, user.geslacht);
    }


}
