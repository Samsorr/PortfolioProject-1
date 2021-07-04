import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Applicatie {
    private static ArrayList<Planten> plantenList;

    public static void main(String[] args) {
        plantenList = PlantenCatalog.retrieveCatalog();
        Scanner sc = new Scanner(System.in);
        boolean running = true;


            while (running == true) {

            if (Login.getInstance().isAuthenticated()) {
                plantenList = PlantenCatalog.getPlanten();
                System.out.println("====================");
                System.out.println();
                System.out.println("Maak alstublieft een keuze:\n"
                        + "1 - Toon de gehele Planten collectie\n"
                        + "2 - Voeg een nieuwe Alocasia plant toe\n"
                        + "3 - Voeg een nieuwe Coco plant toe\n"
                        + "4 - Voeg een nieuwe Kentiaplam plant toe\n"
                        + "5 - Pas een plant aan\n"
                        + "6 - Verwijder een plant\n"
                        + "7 - Stop de app\n");

            } else {
                System.out.println("Geen pogingen meer over, het programma stopt.");
                running = false;
                sc.close();
            }
                int option = sc.nextInt();

                if (option == 1) {
                    System.out.print("Hier is de gehele collectie planten: \n");
                    for (Planten plant : plantenList) {
                        System.out.print(plant.toString());
                    }
                } else if (option == 2 || option == 3 || option == 4) {
                    sc.nextLine();
                    System.out.print("Naam: ");
                    String naam = sc.nextLine();

                    int waterbehoefte = Integer.MIN_VALUE;
                    int phWaarde;

                    System.out.print("PH: ");
                    phWaarde = sc.nextInt();

                    System.out.print("Waterbehoefte: ");
                    waterbehoefte = sc.nextInt();


                    Planten plant = null;

                    if (option == 2) {
                        int luchtVochtigheid = Integer.MIN_VALUE;
                        System.out.print("Luchtvochtigheid: ");
                        luchtVochtigheid = sc.nextInt();
                        plant = new Alocasia(naam, Alocasia.SOORT, waterbehoefte, phWaarde, luchtVochtigheid);
                        Connect.insertPlant(naam, Alocasia.SOORT, waterbehoefte, phWaarde, null, luchtVochtigheid);
                        PlantenCatalog.add(plant);
                    } else if (option == 3) {
                        plant = new Coco(naam, Coco.SOORT, waterbehoefte, phWaarde);
                        Connect.insertPlant(naam, Coco.SOORT, waterbehoefte, phWaarde, null, null);
                        PlantenCatalog.add(plant);
                    } else {
                        int interval = Integer.MIN_VALUE;
                        System.out.print("Interval: ");
                        interval = sc.nextInt();
                        plant = new Kentiaplam(naam, Kentiaplam.SOORT, waterbehoefte, phWaarde, interval);
                        Connect.insertPlant(naam, Kentiaplam.SOORT, waterbehoefte, phWaarde, interval, null);
                        PlantenCatalog.add(plant);
                    }


                } else if (option == 5) {
                    System.out.print("Geef de naam van de plant die u wilt wijzigen: \n");
                    String naam = sc.next();
                    Planten plant = null;
                    for (Planten plant1 : plantenList) {
                        if (plant1.getNaam().equals(naam)) {
                            System.out.print("Uw Keuze: \n");
                            System.out.println(plant1.toString());
                            plant = plant1;
                        }
                    }

                            System.out.println("Maak een keuze uit: \n"
                                    + "1. Naam wijzigen \n"
                                    + "2. Waterbehoefte wijzigen");

                            int keuze = 0;
                            keuze = sc.nextInt();
                            sc.nextLine();


                              switch(keuze){
                                  case 1:
                                    System.out.print("Voer de nieuwe naam in: ");
                                    String naam1 = sc.nextLine();
                                    plant.setNaam(naam1);
                                    Connect.updatePlant(plant, naam);
                                    PlantenCatalog.updatePlant(plant);
                                    break;
                                case 2:
                                    System.out.print("Voer de nieuwe waterbehoefte in: ");
                                    int water = sc.nextInt();
                                    plant.setWaterbehoefte(water);
                                    Connect.updatePlant(plant, naam);
                                    PlantenCatalog.updatePlant(plant);
                                    break;
                                default:
                                    System.out.println("Voer keuze in");
                                     }


                } else if (option == 6) {
                    System.out.print("Voer de naam in van de plant die u wilt verwijderen: \n");
                    String naam = sc.next();

                    for (Planten plant : plantenList) {
                        if (plant.getNaam().equals(naam)) {
                            Connect.deletePlant(plant);
                            PlantenCatalog.deletePlant(plant);
                            System.out.println("Succes! \n");
                            break;
                        }
                    }
                } else if (option == 7) {
                    System.out.print("De app stopt...");
                    running = false;
                    sc.close();
                }


            }
        }
    }
