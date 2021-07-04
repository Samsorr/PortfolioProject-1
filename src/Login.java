import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {


        private static Login singleton;
        private ArrayList<Gebruiker> gebruikers;
        private Gebruiker ingelogd;

        private Login () {
            gebruikers = new ArrayList<>();
            gebruikers.add(new Gebruiker ("Hannah", "1234"));
            ingelogd = null;
        }

        public static Login getInstance () {

            if (singleton == null) {
                singleton = new Login ();
            }

            return singleton;
        }

    public String getGebruikersnaam () {

        if (ingelogd == null) {
            return "";
        }

        return ingelogd.getNaam();
    }

    private Gebruiker getGebruiker (String gebruikersnaam) {
        for(Gebruiker gebruiker: gebruikers) {
            if (gebruiker.getNaam().equals(gebruikersnaam)) {
                return gebruiker;
            }
        }
        return null;
    }

    public String getWachtwoord () {

        if (ingelogd == null) {
            return "";
        }

        return ingelogd.getWachtwoord();
    }

    private boolean gebruikerHeeftToegang () {
        return ingelogd != null;
    }


    public boolean isAuthenticated () {

        if (gebruikerHeeftToegang ()) {
            return true;
        }
        else {

            Scanner scanner = new Scanner(System.in);

            for (int i = 2 ; i > -1 ; i--) {
                System.out.println("Welkom!");
                System.out.println("==============");
                System.out.println("Log in..... ");
                System.out.print("Gebruikersnaam: ");
                String gebruikersnaam = scanner.nextLine();
                System.out.print ("Wachtwoord: ");
                String wachtwoord = scanner.nextLine();


                Gebruiker gebruiker = getGebruiker(gebruikersnaam);

                if (gebruiker != null && gebruiker.wachtwoordCheck(wachtwoord)) {
                    this.ingelogd = gebruiker;
                    System.out.print("Gebruiker is ingelogd");
                    System.out.println ();
                    return true;
                }

                System.out.println ("De combinatie van gebruikersnaam en password is niet OK.");
                System.out.println(String.format ("Nog %d pogingen over", i));
                System.out.println();
            }
            System.out.println ();
            return false;
        }

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