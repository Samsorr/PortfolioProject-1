import java.io.*; // IOException
import java.text.SimpleDateFormat;
import java.util.*; // Scanner
// import jssc.*;

/**
 * Eerste versie: 20190613 Gert den Neijsel
 * Deze versie: 20201208  Gert den Neijsel
 * Dit programma leest data vanaf de seriële poort uit (vanaf bijv. Arduino of Microbit) en insert dit in een SQL database.
 *
 * Deze versie is getest met de volgende software versies:
 * MySQL versie 8.0.13
 * IntelliJ v2020.3
 * Java JDK 1.8.0_271 (JavaSE-1.8)  x86 / 32-bits versie !!!
 *
 * Deze libraries zijn in het project opgenomen:
 * jssc-2.8.0.jar
 * mysql-connector-java-8.0.22.jar
 * protobuf-java-3.11.4.jar
 *
 * Bron van de ComPortSendReceive klasse: https://www.codeproject.com/tips/801262/sending-and-receiving-strings-from-com-port-via-js
 *
 * Gebruik Arduino voorbeeld "7A.Temperaturesensor-Bluetooth.ino" om data te genereren.
 */




/**

public class Comport {

    private static SerialPort serialPort;


     * @param args the command line arguments

    public static void main(String[] args) {
        String portName;
        String[] portNames = SerialPortList.getPortNames();

        if (portNames.length == 0) {
            System.out.println("Er zijn geen seriële poorten. Sluit je Micro:bit aan!");
            System.out.println("Druk Enter om te stoppen");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        if (portNames.length == 1) {
            portName = portNames[0];
            System.out.println(portName + " wordt nu gebruikt");
        } else {

            System.out.println("Meerdere seriële poorten gedetecteerd: ");
            for (int i = 0; i < portNames.length; i++) {
                System.out.println(portNames[i]);
            }
            System.out.println("Type poortnaam die je wilt gebruiken en druk Enter...");
            Scanner in = new Scanner(System.in);
            portName = in.next();
        }

        // Schrijven naar seriële poort
        serialPort = new SerialPort(portName);
        try {
            // seriële poort openen
            serialPort.openPort();

            serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);

            serialPort.addEventListener(new PortReader(), SerialPort.MASK_RXCHAR);
            // schrijf string naar poort
            serialPort.writeString("Test-naar-serieel");

            System.out.println("String naar seriële poort geschreven, wacht op antwoord..");
        } catch (SerialPortException ex) {
            System.out.println("Fout bij schrijven naar seriële poort: " + ex);
        }
    }

    // Ontvangen van data vanaf seriële poort
    // Bron: https://arduino.stackexchange.com/questions/3755/how-to-use-readline-from-jssc
    private static class PortReader implements SerialPortEventListener {
        StringBuilder bericht = new StringBuilder();
        InsertIntoSQL database = new InsertIntoSQL();

        @Override
        public void serialEvent(SerialPortEvent event) {

            if (event.isRXCHAR() && event.getEventValue() > 0) {
                try {
                    // Let op: Als dit programma nog niet gestart is, maar je Microbit was aangesloten en heeft wel data
                    // verstuurd, dan staat er data in de buffer van de seriële poort in je PC (bij mij tot 512 bytes).
                    // Die data wordt uitgelezen zodra het programma gestart wordt. Hou daar rekening mee!
                    byte buffer[] = serialPort.readBytes();
                    for (byte b : buffer) {
                        // indien regeleinde gedetecteerd ('\r' of '\n')
                        if ((b == '\r' || b == '\n') && bericht.length() > 0) {

                            // StringBuilder naar String converteren
                            String berichtData = bericht.toString();

                            // tijdstip = nu
                            String tijdstip = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                            // regeleindes verwijderen
                            berichtData = berichtData.replace("\n", "").replace("\r", "");

                            // regeleindes verwijderen
                            tijdstip = tijdstip.replace("\n", "").replace("\r", "");

                            // String naar float omzetten
                            Float water = Float.parseFloat(berichtData);

                            // afronden op 1 cijfer achter de komma
                            water = (float) (Math.round(temperatuur * 10.0) / 10.0);

                            System.out.print(tijdstip);
                            System.out.print("  ");
                            System.out.println(water);

                            database.startWaterPomp(tijdstip, water);

                            bericht.setLength(0);
                        } else {
                            bericht.append((char) b);
                        }
                    }
                } catch (SerialPortException ex) {
                    System.out.println(ex);
                    System.out.println("serialEvent");
                }
            }

        }
    }
}

*/