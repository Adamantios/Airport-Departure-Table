package basics;

import java.util.ArrayList;

/**
 * Holds data for the message board
 */
public class FlightsTable {

    private Flight[] myTable = new Flight[10];
    private int currentPosition;
    private ArrayList<Flight> allFlights;

    FlightsTable() {
        this.allFlights = new ArrayList<>();
        currentPosition = 0;

        for (int i = 0; i < 10; i++) {
            myTable[i] = new Flight();
        }
    }

    boolean isFull() {
        return this.currentPosition == 10;
    }

    public ArrayList<Flight> getAllFlights() {
        return allFlights;
    }

    public void setAllFlights(ArrayList<Flight> allFlights) {
        this.allFlights = allFlights;
    }

    Flight[] getMyTable() {
        return myTable;
    }

    void addFlight(Flight f) throws Exception {     /* this method adds a flight to the list */

        if (this.currentPosition == 10) {
            throw new Exception("The table is full");
        }
        myTable[currentPosition++] = f;
    }

    public void replaceFlight(String oldFlightName, Flight newFlight) {
        for (int i = 0; i < 10; i++) {
            if (myTable[i].getFlightName().equals(oldFlightName)) {
                myTable[i] = newFlight;
                break;
            }
        }
    }

    public void replaceFlight(int position, Flight newFlight) {
        myTable[position] = newFlight;
    }

    void PrintTable() {
        for (int i = 0; i < 10; i++) {
            System.out.println(myTable[i].toString());
        }
    }

    void clearTable() {
        for (int i = 0; i < 10; i++) {
            myTable[i] = new Flight();
        }

        currentPosition = 0;
    }

    // deprecated
    void createFlightsTableFromAirlines(ArrayList<Airline> airlines) {

        clearTable();
        allFlights.clear();

        for (Airline a : airlines) {
            allFlights.addAll(a.getMyFlights().values());
        }

        allFlights.sort(new FlightComparator());

        int i = 0;
        do {
            try {
                this.addFlight(allFlights.get(i));
                i++;
            } catch (Exception ex) {
                System.out.println("flight can't be added, error:" + ex.getMessage());
            }

        } while ((i != 10) || (i >= allFlights.size()));
    }
}
