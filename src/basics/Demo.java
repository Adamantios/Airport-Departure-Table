package basics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Demo {

    private static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    static ArrayList<Airline> airlines = new ArrayList<>();
    private static FlightsTable flightsTable = new FlightsTable();

    public static void main(String[] args) {
        InitializeComponents();
    }

    /* InitializeComponents method */
    private static void InitializeComponents() { /* creates 3 airlines and adds 20 flights */

        Airline a1 = new Airline("Aegean");
        Airline a2 = new Airline("Alitalia");
        Airline a3 = new Airline("Air France");
        try {
            a1.createFlight("Milos", "a1 018", formatter.parse("31/1/2009 11:00"), a1.getAirlineName());
            a1.createFlight("Limnos", "a1 022", formatter.parse("31/1/2009 11:15"), a1.getAirlineName());
            a1.createFlight("Mitilini", "a1 026", formatter.parse("31/1/2009 11:40"), a1.getAirlineName());
            a1.createFlight("Thessaloniki", "a1 032", formatter.parse("31/1/2009 15:10"), a1.getAirlineName());
            a1.createFlight("Rhodes", "a1 048", formatter.parse("31/1/2009 15:20"), a1.getAirlineName());
            a1.createFlight("Heraklion", "a1 058", formatter.parse("31/1/2009 15:30"), a1.getAirlineName());
            a1.createFlight("Kalimnos", "a1 063", formatter.parse("31/1/2009 15:50"), a1.getAirlineName());
            a2.createFlight("Geneva", "a2 403", "Nice", formatter.parse("31/1/2009 16:15"), a2.getAirlineName());
            a2.createFlight("Zurich", "a2 404", formatter.parse("31/1/2009 16:35"), a2.getAirlineName());
            a2.createFlight("Frankfurt", "a2 406", formatter.parse("31/1/2009 16:45"), a2.getAirlineName());
            a2.createFlight("Bahrain", "a2 412", formatter.parse("31/1/2009 15:00"), a2.getAirlineName());
            a2.createFlight("Milan", "a2 424", formatter.parse("31/1/2009 17:15"), a2.getAirlineName());
            a2.createFlight("Amsterdam", "a2 448", formatter.parse("31/1/2009 17:30"), a2.getAirlineName());
            a2.createFlight("Paris", "a2 492", formatter.parse("31/1/2009 17:45"), a2.getAirlineName());
            a3.createFlight("London", "a3 504", formatter.parse("31/1/2009 12:00"), a3.getAirlineName());
            a3.createFlight("Frankfurt", "a3 518", formatter.parse("31/1/2009 13:15"), a3.getAirlineName());
            a3.createFlight("Lisbon", "a3 218", "Rome", formatter.parse("31/1/2009 18:30"), a3.getAirlineName());
            a3.createFlight("Rome", "a3 532", formatter.parse("31/1/2009 18:45"), a3.getAirlineName());
            a3.createFlight("Moscow", "a3 533", formatter.parse("31/1/2009 19:00"), a3.getAirlineName());
            a3.createFlight("Stockholm", "a3 599", "Berlin", formatter.parse("31/1/2009 19:30"), a3.getAirlineName());
        } catch (ParseException e) {
            System.out.println("Error during data input");
        } catch (Exception ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }

        airlines.add(a1);
        airlines.add(a2);
        airlines.add(a3);

        flightsTable.createFlightsTableFromAirlines(airlines);
        flightsTable.PrintTable();

        System.out.println();
        try {
            a1.boardingFlight("a1 018");
            System.out.println(a1.getMyFlights().get("a1 018").toString());
            a1.delayFlight("a1 022", formatter.parse("31/1/2009 14:50"));
            System.out.println(a1.getMyFlights().get("a1 022").toString());
            a1.boardingFlight("a1 026");
            System.out.println(a1.getMyFlights().get("a1 026").toString());
            a1.gatesClosedFlight("a1 026");
            System.out.println(a1.getMyFlights().get("a1 026").toString());
            a1.departedFlight("a1 026");
            System.out.println(a1.getMyFlights().get("a1 026").toString());
        } catch (Exception ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
