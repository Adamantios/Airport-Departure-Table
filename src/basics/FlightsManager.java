package basics;

import static basics.Utilities.BOARDING_MINUTES_BEFORE_DEPARTURE;
import static basics.Utilities.GATESCLOSE_MINUTES_BEFORE_DEPARTURE;

import java.util.ArrayList;


public class FlightsManager extends Thread {

    public void run() {
        TimeWrapper.flightsManagerRunning = true;

        ArrayList<Flight> flights = AirLines.getAllFligths();

        for (Flight f : flights) {

            switch (f.getState()) {

                case OnTime:
                    if ((Utilities.addMinutes(Utilities.getCurrentDateTime(),
                            GATESCLOSE_MINUTES_BEFORE_DEPARTURE).after(
                            f.getExpectedDepartureDateTime()))) {
                        try {
                            f.gatesClosed();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;

                case GatesClosed:
                    if ((Utilities.addMinutes(Utilities.getCurrentDateTime(),
                            BOARDING_MINUTES_BEFORE_DEPARTURE).after(
                            f.getExpectedDepartureDateTime()))) {
                        try {
                            f.boarding();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;

                case Boarding:
                    if (Utilities.getCurrentDateTime().after(
                            f.getExpectedDepartureDateTime())) {
                        try {
                            f.departed();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
            }
        }

        TimeWrapper.flightsManagerRunning = false;
    }
}
