import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Applicatie {
    private static List<Planten> plantenList;

    public static void main(String[] args) {
        plantenList = new ArrayList<>(Connect.selectPlant());
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running == true) {

            System.out.println("Maak alstublieft een keuze:\n"
                    + "1 - Toon de gehele Planten collectie\n"
                    + "2 - Voeg een nieuwe Alocasia plant toe\n"
                    + "3 - Voeg een nieuwe Coco plant toe\n"
                    + "4 - Voeg een nieuwe Kentiaplam plant toe\n"
                    + "5 - Pas een plant aan\n"
                    + "6 - Verwijder een plant\n"
                    + "7 - Stop de app\n");

            int option = sc.nextInt();

            if (option == 1) {
                System.out.print("Hier is de gehele collectie planten: \n");
                for (Planten plant : plantenList) {
                    System.out.print(plant.toString());
                }
            } else if (option == 2 || option == 3 || option == 4) {
                System.out.print("Naam: \n");
                String naam = sc.next();

                int waterbehoefte = Integer.MIN_VALUE;
                int phWaarde;

                System.out.print("PH: \n");
                phWaarde = sc.nextInt();

                System.out.print("Waterbehoefte: \n");
                waterbehoefte = sc.nextInt();



                Planten plant = null;

                if (option == 2) {
                    int luchtVochtigheid = Integer.MIN_VALUE;
                    System.out.print("Luchtvochtigheid: ");
                    luchtVochtigheid = sc.nextInt();
                    plant = new Alocasia(naam, Alocasia.SOORT, waterbehoefte, phWaarde, luchtVochtigheid);
                    Connect.insertPlant(naam, Alocasia.SOORT, waterbehoefte, phWaarde, null, luchtVochtigheid);
                } else if (option == 3) {
                    plant = new Coco(naam, Coco.SOORT, waterbehoefte, phWaarde);
                    Connect.insertPlant(naam, Coco.SOORT, waterbehoefte, phWaarde, null, null);
                } else {
                    int interval = Integer.MIN_VALUE;
                    System.out.print("Interval: ");
                    interval = sc.nextInt();
                    plant = new Kentiaplam(naam, Kentiaplam.SOORT, waterbehoefte, phWaarde, interval);
                    Connect.insertPlant(naam, Kentiaplam.SOORT, waterbehoefte, phWaarde, interval, null);
                }


            } else if (option == 5) {
                System.out.print("Geef de naam van de plant die u wilt wijzigen: \n");
                String naam = sc.next();

                for (Planten plant : plantenList) {
                    if (plant.getNaam().equals(naam)) {
                        System.out.print("Uw Keuze: \n");
                        System.out.println(plant.toString());


                        System.out.println("Maak een keuze uit: \n"
                                + "1. Naam wijzigen \n"
                                + "2. Waterbehoefte wijzigen\n"
                                + "3. Allebei wijzigen");

                        int keuze = 0;
                        keuze = sc.nextInt();


                        switch (keuze) {
                            case 1:
                                System.out.print("Voer de nieuwe naam in: ");
                                String naam1 = sc.next();
                                plant.setNaam(naam1);
                                Connect.updatePlant(plant);
                                break;
                            case 2:
                                System.out.print("Voer de nieuwe waterbehoefte in: \n");
                                int water = sc.nextInt();
                                plant.setWaterbehoefte(water);
                                Connect.updatePlant(plant);
                                break;
                            case 3:
                                System.out.print("Voer de nieuwe naam en waterbehoefte in: \n");

                                System.out.println("Naam \n");
                                String naam2 = sc.nextLine();

                                System.out.println("Waterbehoefte: \n");
                                int water1 = sc.nextInt();

                                plant.setNaam(naam2);
                                plant.setWaterbehoefte(water1);
                                Connect.updatePlant(plant);
                                break;
                            default:
                                System.out.println("Voer keuze in");
                        }

                    }
                }
            }

            else if (option == 6){
                System.out.print("Voer de naam in van de plant die u wilt verwijderen: \n");
                String naam = sc.next();

                for(Planten plant: plantenList){
                    if(plant.getNaam().equals(naam)){
                        Connect.deletePlant(naam);
                        System.out.println("Succes! \n");
                        break;
                    }
                }
            }

            else if(option == 7) {
                    System.out.print("De app stopt...");
                    running = false;
                    sc.close();
                }


        }
    }
}
