import java.util.Scanner;

public class Applicatie {
    private static PlantenCatalog plantenCatalog;

    public static void main(String[] args) {
        plantenCatalog = new PlantenCatalog();
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
                for (Planten plant : plantenCatalog.sortType()) {
                    System.out.print(plant.toString());
                }
            } else if (option == 2 || option == 3 || option == 4) {
                System.out.print("Naam: ");
                String naam = sc.next();

                int waterbehoefte = Integer.MIN_VALUE;

                System.out.print("Waterbehoefte: ");
                waterbehoefte = sc.nextInt();


                Planten plant = null;

                if (option == 2) {
                    int humidity = Integer.MIN_VALUE;
                    System.out.print("Humidity: ");
                    humidity = sc.nextInt();
                    plant = new Alocasia(naam, Alocasia.SOORT, waterbehoefte, humidity);
                } else if (option == 3) {
                    plant = new Coco(naam, Coco.SOORT, waterbehoefte);
                } else {
                    int interval = Integer.MIN_VALUE;
                    System.out.print("Interval: ");
                    interval = sc.nextInt();
                    plant = new Kentiaplam(naam, Kentiaplam.SOORT, waterbehoefte, interval);
                }

                plantenCatalog.add(plant);
            }

            else if (option == 5) {
                System.out.print("The program is stopping...");
                running = false;
                sc.close();
            }

        }
    }
}
