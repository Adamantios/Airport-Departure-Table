package basics;

import java.util.Date;
import java.util.HashMap;


public class Airline {

    private String airlineName;
    private int aID;
    private HashMap<String, Flight> Flights;

    public Airline(String airlineName, int aID) {
        this.airlineName = airlineName;
        this.aID = aID;
        Flights = new HashMap<>();
    }

    public Airline(String airlineName) {
        Flights = new HashMap<>();
        this.airlineName = airlineName;
        this.aID = 1;
        if (!AirLines.getAllAirlines().isEmpty()) {
            for (Airline a : AirLines.getAllAirlines()) {
                if (a.getaID() >= this.aID) {
                    this.aID = a.getaID() + 1;
                }
            }
        }
    }

    HashMap<String, Flight> getMyFlights() {
        return Flights;
    }

    String getAirlineName() {
        return airlineName;
    }

    int getaID() {
        return aID;
    }

    String getSaID() {
        return Integer.toString(aID);
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    void addFlight(Flight flight) {
        Flights.put(flight.getFlightName(), flight);
    }

    void removeFlight(Flight flight) {
        Flights.remove(flight.getFlightName());
    }

    void createFlight(String destination, String flightName, String via, Date scheduledDeparture, String airline) throws Exception {
        Flights.put(flightName, new Flight(destination, flightName, via, scheduledDeparture, airline));
    }

    void createFlight(String destination, String flightName, Date scheduledDeparture, String airline) throws Exception {
        Flights.put(flightName, new Flight(destination, flightName, scheduledDeparture, airline));
    }

    void departedFlight(String flightName) throws Exception {
        Flights.get(flightName).departed();
    }

    void gatesClosedFlight(String flightName) throws Exception {
        Flights.get(flightName).gatesClosed();
    }

    void boardingFlight(String flightName) throws Exception {
        Flights.get(flightName).boarding();
    }

    void delayFlight(String flightName, Date expectedDepartureDateTime) throws Exception {
        Flights.get(flightName).delay(expectedDepartureDateTime);
    }

    public void cancelFlight(String flightName) throws Exception {
        Flights.get(flightName).cancel();
    }
}
