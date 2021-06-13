import java.util.Scanner;

public class Applicatie {
    private static PlantenCatalog plantenCatalog;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running == true) {

            System.out.println("Please make your choice:\n"
                    + "1 - Show the entire Planten catalogue\n"
                    + "2 - Add a new Alocasia plant\n"
                    + "3 - Add a new Coco plant\n"
                    + "4 - Add a new Kentiaplam\n"
                    + "5 - Stop the program\n");

            int option = sc.nextInt();

            if (option == 1) {
                System.out.print("Here is the entire Planten catalogue: \n");
                for (Planten plant : Connect.selectPlant() ) {
                    System.out.print(plant.toString());
                }
            } else if (option == 2 || option == 3 || option == 4) {
                System.out.print("Naam: ");
                String naam = sc.next();

                int waterbehoefte = Integer.MIN_VALUE;
                int phWaarde = Integer.MIN_VALUE;

                System.out.print("Waterbehoefte: ");
                waterbehoefte = sc.nextInt();

                System.out.println("PH: ");
                phWaarde = sc.nextInt();


                Planten plant = null;

                if (option == 2) {
                    int luchtVochtigheid = Integer.MIN_VALUE;
                    System.out.print("Humidity: ");
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


            }

            else if (option == 5) {
                System.out.print("The program is stopping...");
                running = false;
                sc.close();
            }

        }
    }
}
