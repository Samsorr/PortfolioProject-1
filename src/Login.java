import java.util.ArrayList;

public class Login {


        private static Login singleton;
        private Gebruiker gebruiker;

        private Login () {

            gebruiker = new Gebruiker ("Hannah", "1234");

        }

        public static Login getInstance () {

            if (singleton == null) {
                singleton = new Login ();
            }

            return singleton;
        }

    public String getGebruikersnaam () {

        if (gebruiker == null) {
            return "";
        }

        return gebruiker.getNaam();
    }

    public String getWachtwoord () {

        if (gebruiker == null) {
            return "";
        }

        return gebruiker.getWachtwoord();
    }


}


/**
 private boolean gebruikerBekend (String name) {

 for (Gebruiker gebruiker : gebruikers) {
 if (gebruiker.getNaam().equals(name)) {
 this.gebruiker = gebruiker;
 return true;
 }
 }
 return false;
 }
*/