import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Dit programma communiceert met de database.
 *
 * Deze versie is getest met de volgende software versies:
 * MySQL versie 8.0.13
 * IntelliJ v2020.3
 * Java JDK 1.8.0_271 (JavaSE-1.8)  x86 / 32-bits versie !!!
 *
 * Deze libraries zijn in het project opgenomen:
 * maven
 * mysql-connector-java-8.0.22.jar
 *
 * @author 20222556 Samsor Wali
 * @version 3.3
 * @since 1.0
 */

public class Connect {



    //login details of the database
    private static final String dburl = "jdbc:mysql://localhost/PlantDB";
    private static final String dbuser = "root";
    private static final String dbpassword = "";

    private static Connection connection;
    private static Statement getStmt;
    private static ResultSet resultSet;



    /**
     * Selecteert alle planten uit de database en zet ze in een list
     *
     * @return plants
     */

    public static List<Planten> selectPlant(){
        List<Planten> plants = new ArrayList<>();

        try{
            connection = DriverManager.getConnection(dburl, dbuser, dbpassword);

            String sql ="SELECT * FROM Plant";
            getStmt = connection.createStatement();
            resultSet = getStmt.executeQuery(sql);

            while(resultSet.next()) {
                int id = resultSet.getInt("Plant_id");
                String naam = resultSet.getString("Plant_naam");
                String soort = resultSet.getString("Plant_soort");
                int waterbehoefte = resultSet.getInt("Plant_waterbehoefte");
                int phWaarde = resultSet.getInt("Plant_phWaarde");
                int interval = resultSet.getInt("Plant_interval");
                int luchtVochtigheid = resultSet.getInt("Plant_LuchtVochtigheid");

                switch (soort){
                    case "Alocasia":
                        plants.add(new Alocasia(naam, soort,waterbehoefte,phWaarde, luchtVochtigheid));
                        break;
                    case "Coco":
                        plants.add(new Coco(naam, soort, waterbehoefte, phWaarde));
                        break;
                    case "Kentiapalm":
                        plants.add(new Kentiaplam(naam,soort,waterbehoefte,phWaarde,interval));
                        break;
                }
            }
            connection.close();
            return plants;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return plants;
    }


    /**
     * Voeg nieuwe plant toe aan database
     *
     * @param naam
     * @param soort
     * @param waterbehoefte
     * @param phWaarde
     * @param interval   // mag null zijn
     * @param luchtVochtigheid // mag null zijn
     */

    public static void insertPlant(String naam, String soort, int waterbehoefte, int phWaarde, Integer interval, Integer luchtVochtigheid) {

        try{
            connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
            String sql = "INSERT INTO Plant(naam, soort, waterbehoefte, phWaarde, interval, luchtVochtigheid) VALUES(?,?,?,?,?,?)";
            getStmt = connection.createStatement();
            getStmt.executeUpdate(sql);
            getStmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Update de gegevens van de plant
     *
     * @param plant
     * @param interval
     * @param luchtVochtigheid
     */

    public static void updatePlant(Planten plant, Integer interval, Integer luchtVochtigheid) {

        try{
            connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
            String sql = "UPDATE Plant " +
                    "SET Plant_naam = '" + plant.getNaam()
                    + "', Plant_soort = '" + plant.getSoort()
                    + "', Plant_waterbehoefte = '" + plant.getWaterbehoefte()
                    + "', Plant_phWaarde = '" + plant.getPhWaarde()
                    + "', Plant_interval = '" + interval
                    + "', Plant_luchtVochtigheid = '" + luchtVochtigheid
                    + "' WHERE Plant_naam = '" + plant.getNaam() + "';";
            getStmt = connection.createStatement();
            getStmt.executeUpdate(sql);
            getStmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Verwijder een plant uit de database.
     *
     * @param naam
     */

    public static void deletePlant(String naam) {

        try{
            connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
            String sql = "DELETE FROM 'PlantDB'.'Plant' WHERE ('Plant_naam' = '" + naam + "');";
            getStmt = connection.createStatement();
            getStmt.executeUpdate(sql);
            getStmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


        /**
         * Insert een nieuwe actie voor de waterpomp(voor aan en uitzetten)
         *
         * @param tijdstip
         * @param water
         */
        public static void startWaterPomp(String tijdstip, float water) {
            String sql = "INSERT INTO Waterpomp(tijdstip, water) VALUES(?,?)";

            try {connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
                 PreparedStatement pstmt = connection.prepareStatement(sql);

                pstmt.setString(1, tijdstip);
                pstmt.setFloat(2, water);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


