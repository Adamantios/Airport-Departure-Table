package basics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Control {

    private static final Scanner scanIn = new Scanner(System.in);

    /* this method reads a string and depending on the boolean value it allows an empty string */
    private static String readString(String message, Boolean emptyPermitted) {
        String s = "";
        while (s.isEmpty()) {
            System.out.print(message);
            s = scanIn.nextLine().trim();
            if (s.isEmpty() && emptyPermitted) {
                return "";
            }
        }
        return s;
    }

    /* this method reads and checks the format of a date when read from keyboard */
    private static Date readDate(String message, String formatString, Boolean emptyPermitted) {
        Date inDate = new Date();
        boolean retry = true;
        while (retry) {
            System.out.print(message);
            String s = scanIn.nextLine().trim();
            if (s.isEmpty() && emptyPermitted) {
                return null;
            }
            try {
                inDate = new SimpleDateFormat(formatString).parse(s);
                retry = false;
            } catch (ParseException ex) {
                System.out.println("Παρακαλώ πληκτρολογείστε μια έγκυρη τιμή με τη μορφή " + formatString);
            }
        }
        return inDate;
    }

    /* this method reads a flight from the keyboard */
    public Flight flightKeyboardRead(String AirlineName) {
        System.out.println("Δώστε Προορισμό");
        String destination = readString("Προορισμός: ", false);
        System.out.println("Δώστε Κωδικό Πτήσης");
        String flightName = readString("Κωδικός Πτήσης:", false);
        System.out.println("Δώστε Χώρα(ενδιάμεση στάση - enter if none)");
        String via = readString("Χώρα(ενδιάμεση στάση): ", true);
        System.out.println("Δώστε Ημερομηνία και Ώρα αναχώρησης");
        Flight f = null;
        Date scheduledDepartureDateTime = readDate("Ημερομηνία και Ώρα αναχώρησης (dd/MM/yyyy HH:mm):", "dd/MM/yyyy HH:mm", false);
        try {
            f = via.equals("") ? new Flight(destination, flightName, scheduledDepartureDateTime, AirlineName)
                    : new Flight(destination, flightName, via, scheduledDepartureDateTime, AirlineName);
        } catch (Exception ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }

    public Airline airlineKeyboardRead() {
        System.out.println("Δώστε Όνομα Αερομεταφορέα");
        String name = readString("Αερομεταφορέας: ", false);
        return new Airline(name);
    }

    public ArrayList<Flight> fileRead(String ArlineName) {  /* this method reads all flights of an airline from a file */

        String line;     /* this will reference one line at a time */

        String delims = "[-]+";     /* one delimiter (-) and consecutive delimiters */

        DateFormat formatter;
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");       /* convert String to Date */

        ArrayList<Flight> flights = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(ArlineName + ".txt");      /* reads text files in the default encoding */

            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] tokens = line.split(delims);       /* add each string to proper variable */

                    Flight f;
                    try {
                        f = tokens[2].equals("")
                                ? new Flight(tokens[0], tokens[1], formatter.parse(tokens[3]), ArlineName)
                                : new Flight(tokens[0], tokens[2], tokens[1], formatter.parse(tokens[3]), ArlineName);
                        flights.add(f);
                    } catch (Exception ex) {
                        System.out.println("Flight not added, error: " + ex.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
        return flights;
    }
}
