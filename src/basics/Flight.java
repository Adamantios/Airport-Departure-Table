package basics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Flight {

    public enum FlightState {
        OnTime,
        Boarding,
        GatesClosed,
        Departed,
        Cancelled,
        Delayed
    }

    private String airline;
    private String destination;
    private String flightName;
    private String via;
    private Date scheduledDepartureDateTime;
    private Date expectedDepartureDateTime;
    private Date cancelDate;

    private FlightState flightState;
    private int fID;

    int getfID() {
        return fID;
    }

    String getSfID() {
        return Integer.toString(fID);
    }

    void setfID(int fID) {
        this.fID = fID;
    }

    public Flight() {
        this.airline = "";
        this.destination = "";
        this.flightName = "";
        this.fID = -1;
        this.via = "";
        this.flightState = FlightState.OnTime;
        this.scheduledDepartureDateTime = new Date();
        this.expectedDepartureDateTime = new Date();
    }

    public Flight(int ID, String destination, String flightName, String via, Date scheduledDeparture,
                  Date cancelDate, Date expectedDeparture, String airline, FlightState flightState) {
        this.fID = ID;
        this.destination = destination;
        this.airline = airline;
        this.flightName = flightName;
        this.via = via;
        this.cancelDate = cancelDate;
        this.scheduledDepartureDateTime = scheduledDeparture;
        this.expectedDepartureDateTime = expectedDeparture;
        this.flightState = flightState;
    }

    public Flight(int ID, String destination, String flightName, String via, Date scheduledDeparture,
                  Date expectedDeparture, String airline, FlightState flightState) {
        this.fID = ID;
        this.destination = destination;
        this.airline = airline;
        this.flightName = flightName;
        this.via = via;
        this.scheduledDepartureDateTime = scheduledDeparture;
        this.expectedDepartureDateTime = expectedDeparture;
        this.flightState = flightState;
    }

    public Flight(String destination, String flightName, String via, Date scheduledDeparture, String airline) throws Exception {
        if (scheduledDeparture == null) {
            throw new Exception("You must specify a departure time");
        }

        this.destination = destination;
        this.airline = airline;
        this.flightName = flightName;
        this.via = via;
        this.scheduledDepartureDateTime = scheduledDeparture;
        this.expectedDepartureDateTime = scheduledDeparture;
        // In this method date of departure will be checked wheather it is of the next day.
        // In this case state will be :"future"
        this.flightState = FlightState.OnTime;
    }

    public Flight(String destination, String flightName, Date scheduledDeparture, String airline) throws Exception {
        if (scheduledDeparture == null) {
            throw new Exception("You must specify a departure time");
        }
        // Later in this project constructor will throw exception in case of past time insertion
        this.destination = destination;
        this.airline = airline;
        this.flightName = flightName;
        this.via = "";
        this.scheduledDepartureDateTime = scheduledDeparture;
        this.expectedDepartureDateTime = scheduledDeparture;
        // In this method date of departure will be checked wheather it is of the next day.
        // In this case state will be :"future"
        this.flightState = FlightState.OnTime;
    }

    FlightState getState() {
        return (flightState);
    }

    String getDestination() {
        return destination;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getRemark() {
        String msg = "";
        switch (this.flightState) {
            case Boarding:
                msg = "Boarding";
                break;
            case GatesClosed:
                msg = "Gates Closed";
                break;
            case Cancelled:
                msg = "Cancelled";
                break;
            case Departed:
                msg = "Departed";
                break;
        }
        return msg;
    }

    String getStrState() {
        String msg[] = {"OnTime", "Boarding", "GatesClosed", "Departed", "Cancelled", "Delayed"};
        return msg[this.flightState.ordinal()];
    }

    int getNewFlightID() {
        int newID = 1;
        for (Flight f : AirLines.getAllFligths()) {
            if (f.getfID() >= newID) {
                newID = f.getfID() + 1;
            }
        }
        return newID;
    }

    Date getCancelDate() {
        return cancelDate;
    }

    void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    Date getExpectedDepartureDateTime() {
        return expectedDepartureDateTime;
    }

    void setDestination(String destination) {
        this.destination = destination;
    }

    String getFlightName() {
        return flightName;
    }

    void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    Date getScheduledDepartureDateTime() {
        return scheduledDepartureDateTime;
    }

    void setScheduledDepartureDateTime(Date scheduledDepartureDateTime) {
        this.scheduledDepartureDateTime = scheduledDepartureDateTime;
    }

    public void setFlightState(FlightState flightState) {
        this.flightState = flightState;
    }

    void departed() throws Exception {
        if (flightState != FlightState.GatesClosed && flightState != FlightState.Boarding) {
            throw new Exception("Flight's status can't be Departed because it is "
                    + getStrState());
        }
        flightState = FlightState.Departed;
    }

    void gatesClosed() throws Exception {
        if (flightState != FlightState.OnTime) {
            throw new Exception("Flight's status can't be Gates Closed because it is "
                    + getStrState());
        }
        flightState = FlightState.GatesClosed;
    }

    void boarding() throws Exception {
        if (flightState != FlightState.GatesClosed && flightState != FlightState.OnTime) {
            throw new Exception("Flight's status can't be Boarding because it is "
                    + getStrState());
        }
        flightState = FlightState.Boarding;
    }

    void delay(Date newDepartureTime) throws Exception {
        if (flightState == FlightState.Cancelled
                || flightState == FlightState.Departed) {
            throw new Exception("Flight's status can't be Delayed because it is "
                    + getStrState());
        }
        expectedDepartureDateTime = newDepartureTime;
        flightState = FlightState.Delayed;
    }

    void cancel() throws Exception {
        if (flightState == FlightState.Departed || flightState == FlightState.Cancelled) {
            throw new Exception("Flight's status can't be Canceled because it is "
                    + getStrState());
        }
        flightState = FlightState.Cancelled;
    }

    @Override
    public String toString() {

        if (airline.isEmpty() && destination.isEmpty() && flightName.isEmpty()) {
            return " ";
        }

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return String.format("%-30s", destination)
                + String.format("%-15s", airline)
                + String.format("%-8s", flightName)
                + String.format("%-15s", via == null ? "" : via)
                + String.format("%-20s", flightState == FlightState.Delayed ? df.format(expectedDepartureDateTime) : "")
                + String.format("%-20s", df.format(scheduledDepartureDateTime));
    }
}
