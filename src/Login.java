import java.util.ArrayList;

public class Login {


        private static Login singleton;
        private ArrayList<Gebruiker> gebruikers;
        private Gebruiker gebruiker;

        private Login () {
            gebruikers = new ArrayList<> ();
            gebruikers.add (new Gebruiker ("Samsor", "1234"));

        }

        public static Login getInstance () {

            if (singleton == null) {
                singleton = new Login ();
            }

            return singleton;
        }

        private boolean gebruikerBekend (String name) {

            for (Gebruiker gebruiker : gebruikers) {
                if (gebruiker.getName().equals(name)) {
                    this.gebruiker = gebruiker;
                    return true;
                }
            }
            return false;
        }


}
