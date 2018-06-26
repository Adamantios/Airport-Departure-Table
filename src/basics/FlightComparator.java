package basics;

import java.util.Comparator;


public class FlightComparator implements Comparator<Flight> {

    @Override
    public int compare(Flight f1, Flight f2) {
        // initially the expected time is the same as the scheduled time.
        return f1.getExpectedDepartureDateTime().compareTo(f2.getExpectedDepartureDateTime());
    }
}
