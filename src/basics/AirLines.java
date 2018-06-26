package basics;

import java.util.ArrayList;
import java.util.Date;


public class AirLines {

    private static ArrayList<Airline> Airlines = new ArrayList<>();

    static ArrayList<Airline> getAllAirlines() {
        return Airlines;
    }

    static ArrayList<Flight> getCanceledFlights(Date fromDate) {
        ArrayList<Flight> result = new ArrayList<>();

        for (Airline a : Airlines) {
            for (String fn : a.getMyFlights().keySet()) {
                Flight f = a.getMyFlights().get(fn);
                {
                    if (f.getState() == Flight.FlightState.Cancelled
                            && ((fromDate.getTime() - f.getExpectedDepartureDateTime().getTime())
                            / (60 * 60 * 1000) % 24) <= 6) {
                        result.add(f);
                    }
                }
            }
        }

        result.sort(new FlightComparator());
        return result;
    }

    static ArrayList<Flight> getDepartedFligths(Date fromDate) {
        ArrayList<Flight> result = new ArrayList<>();

        for (Airline a : Airlines) {
            for (String fn : a.getMyFlights().keySet()) {
                Flight f = a.getMyFlights().get(fn);
                {
                    if (f.getState() == Flight.FlightState.Departed
                            && ((fromDate.getTime() - f.getExpectedDepartureDateTime().getTime())
                            / (60 * 60 * 1000) % 24) <= 1) {
                        result.add(f);
                    }
                }
            }
        }

        result.sort(new FlightComparator());

        return result;
    }

    static ArrayList<Flight> getOtherFligths() {
        ArrayList<Flight> result = new ArrayList<>();

        for (Airline a : Airlines) {
            for (String fn : a.getMyFlights().keySet()) {
                Flight f = a.getMyFlights().get(fn);
                {
                    if (f.getState() != Flight.FlightState.Departed
                            && f.getState() != Flight.FlightState.Cancelled) {
                        result.add(f);
                    }
                }
            }
        }

        result.sort(new FlightComparator());

        return result;
    }

    static ArrayList<Flight> getAllFligths() {
        ArrayList<Flight> result = new ArrayList<>();

        for (Airline a : Airlines) {
            for (String fn : a.getMyFlights().keySet()) {
                Flight f = a.getMyFlights().get(fn);
                {
                    result.add(f);
                }
            }
        }

        result.sort(new FlightComparator());

        return result;
    }

    private static Flight getFlight(int fid) {
        for (Flight f : getAllFligths()) {
            if (f.getfID() == fid) {
                return f;
            }
        }

        return null;
    }

    static Flight getFlight(String fid) {
        try {
            int fID = Integer.parseInt(fid);
            return getFlight(fID);
        } catch (Exception ex) {
            return null;
        }
    }

    private static boolean flightExists(int fid) {
        for (Flight f : getAllFligths()) {
            if (f.getfID() == fid) {
                return true;
            }
        }

        return false;
    }

    public static boolean flightExists(String fid) {
        try {
            int fID = Integer.parseInt(fid);
            return flightExists(fID);
        } catch (Exception ex) {
            return false;
        }
    }

    public static void setAirlines(ArrayList<Airline> Airlines) {
        AirLines.Airlines = Airlines;
    }

    static void clear() {
        Airlines.clear();
    }

    public static boolean airlineExists(int AirlineID) {
        boolean found = false;
        for (Airline a : Airlines) {
            if (a.getaID() == AirlineID) {
                found = true;
                break;
            }
        }

        return found;
    }

    static boolean airlineExists(String AirlineName) {
        boolean found = false;
        for (Airline a : Airlines) {
            if (a.getAirlineName().equals(AirlineName)) {
                found = true;
                break;
            }
        }

        return found;
    }

    static void addAirline(Airline airline) {
        Airlines.add(airline);
    }

    static Airline getAirline(int AirlineID) {
        Airline result = null;
        for (Airline a : Airlines) {
            if (a.getaID() == AirlineID) {
                result = a;
                break;
            }
        }
        return result;
    }

    static Airline getAirline(String AirlineName) {
        Airline result = null;
        for (Airline a : Airlines) {
            if (a.getAirlineName().equals(AirlineName)) {
                result = a;
                break;
            }
        }
        return result;
    }
}
