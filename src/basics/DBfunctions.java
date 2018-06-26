package basics;

import java.sql.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


class DBfunctions {

    private static Connection myConnection;

    private static Connection getMyConnection() {
        if (myConnection != null) {
            return myConnection;
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            myConnection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe", "system", "sa");
            return myConnection;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DemoGUI.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static void deleteAllFlights() {
        try {
            Statement stmt = Objects.requireNonNull(getMyConnection()).createStatement();
            stmt.executeQuery("delete from FLMGMT_FLIGHTS");
        } catch (SQLException ex) {
            String s = ex.getMessage();
        }
    }

    private static boolean foundRecords(String query) {
        try {
            Statement stmt = Objects.requireNonNull(getMyConnection()).createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs.next();
        } catch (SQLException ex) {
            String s = ex.getMessage();
            return false;
        }
    }

    static void saveAllToDB() {
        String query1 = "insert into FLMGMT_AIRLINES (AIRLINEID, AIRLINENAME) values (?, ?)";
        String query2
                = "insert into FLMGMT_FLIGHTS (FLIGHTID, AIRLINEID, FLIGHTNAME, DESTINATION, VIA, "
                + "SCHEDULEDDEPARTUREDATE, SCHEDULEDDEPARTURETIME, EXPECTEDDEPARTUREDATE, "
                + "EXPECTEDDEPARTURETIME, FLIGHTSTATE, CANCELDATE, CANCELTIME) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String query3
                = "insert into FLMGMT_FLIGHTS (FLIGHTID, AIRLINEID, FLIGHTNAME, DESTINATION, VIA, "
                + "SCHEDULEDDEPARTUREDATE, SCHEDULEDDEPARTURETIME, EXPECTEDDEPARTUREDATE, "
                + "EXPECTEDDEPARTURETIME, FLIGHTSTATE) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        java.sql.Date sqlDate;
        java.sql.Time sqlTime;

        try {
            deleteAllFlights();
            PreparedStatement preparedStatement = Objects.requireNonNull(getMyConnection()).prepareStatement(query1);
            for (Airline a : AirLines.getAllAirlines()) {

                if (!foundRecords("select * from FLMGMT_AIRLINES where AIRLINEID=" + a.getSaID())) {
                    preparedStatement.setInt(1, a.getaID());
                    preparedStatement.setString(2, a.getAirlineName());
                    preparedStatement.execute();
                }

                for (String fn : a.getMyFlights().keySet()) {
                    Flight f = a.getMyFlights().get(fn);
                    //if (foundRecords("select * from FLMGMT_FLIGHTS where FLIGHTID=" + f.getSfID())) {   
                    //    continue;
                    //}

                    PreparedStatement preparedStatement2;
                    if (f.getState() == Flight.FlightState.Cancelled) {
                        preparedStatement2 = getMyConnection().prepareStatement(query2);
                    } else {
                        preparedStatement2 = getMyConnection().prepareStatement(query3);
                    }

                    preparedStatement2.setInt(1, f.getfID());
                    preparedStatement2.setInt(2, a.getaID());
                    preparedStatement2.setString(3, f.getFlightName());
                    preparedStatement2.setString(4, f.getDestination());
                    preparedStatement2.setString(5, f.getVia());

                    long t = f.getScheduledDepartureDateTime().getTime();
                    sqlDate = new java.sql.Date(t);
                    sqlTime = new java.sql.Time(t);

                    preparedStatement2.setDate(6, sqlDate);
                    preparedStatement2.setTime(7, sqlTime);

                    t = f.getExpectedDepartureDateTime().getTime();
                    sqlDate = new java.sql.Date(t);
                    sqlTime = new java.sql.Time(t);

                    preparedStatement2.setDate(8, sqlDate);
                    preparedStatement2.setTime(9, sqlTime);

                    preparedStatement2.setInt(10, f.getState().ordinal());

                    if (f.getState() == Flight.FlightState.Cancelled) {
                        t = f.getCancelDate().getTime();
                        sqlDate = new java.sql.Date(t);
                        sqlTime = new java.sql.Time(t);

                        preparedStatement2.setDate(11, sqlDate);
                        preparedStatement2.setTime(12, sqlTime);
                    }

                    preparedStatement2.execute();

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBfunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void readAllFromDB() {
        AirLines.clear();

        String query1 = "select * from FLMGMT_AIRLINES";
        String query2
                = "select t1.FLIGHTID, t1.AIRLINEID, t2.AIRLINENAME, t1.FLIGHTNAME, t1.DESTINATION, t1.VIA, "
                + "       t1.SCHEDULEDDEPARTUREDATE, t1.EXPECTEDDEPARTUREDATE, t1.CANCELDATE, "
                + "       t1.SCHEDULEDDEPARTURETIME, t1.EXPECTEDDEPARTURETIME, t1.CANCELTIME, t1.FLIGHTSTATE "
                + "from FLMGMT_FLIGHTS t1 inner join FLMGMT_AIRLINES t2 on "
                + "       t1.AIRLINEID=t2.AIRLINEID "
                + "order by t1.SCHEDULEDDEPARTUREDATE, t1.SCHEDULEDDEPARTURETIME desc";

        try {
            Statement stmt = Objects.requireNonNull(getMyConnection()).createStatement();
            ResultSet rs = stmt.executeQuery(query1);

            AirLines.clear();

            while (rs.next()) {
                String anm = rs.getString("AIRLINENAME");
                int aid = rs.getInt("AIRLINEID");
                AirLines.addAirline(new Airline(anm, aid));
            }

            rs.close();

            rs = stmt.executeQuery(query2);

            java.sql.Date sqlDate;
            java.sql.Time sqlTime;

            while (rs.next()) {
                int aID = rs.getInt("AIRLINEID");

                Airline a = AirLines.getAirline(aID);

                sqlDate = rs.getDate("SCHEDULEDDEPARTUREDATE");
                sqlTime = rs.getTime("SCHEDULEDDEPARTURETIME");
                Date schD = new Date(sqlDate.getTime() + sqlTime.getTime());
                sqlDate = rs.getDate("EXPECTEDDEPARTUREDATE");
                sqlTime = rs.getTime("EXPECTEDDEPARTURETIME");
                Date expD = new Date(sqlDate.getTime() + sqlTime.getTime());
                Flight f;
                Date canD;
                try {
                    sqlDate = rs.getDate("CANCELDATE");
                    sqlTime = rs.getTime("CANCELTIME");

                    canD = new Date(sqlDate.getTime() + sqlTime.getTime());
                    f = new Flight(
                            rs.getInt("FLIGHTID"),
                            rs.getString("DESTINATION"),
                            rs.getString("FLIGHTNAME"),
                            rs.getString("VIA"),
                            schD,
                            canD,
                            expD,
                            rs.getString("AIRLINENAME"),
                            Flight.FlightState.values()[rs.getInt("FLIGHTSTATE")]);

                } catch (Exception e) {
                    f = new Flight(
                            rs.getInt("FLIGHTID"),
                            rs.getString("DESTINATION"),
                            rs.getString("FLIGHTNAME"),
                            rs.getString("VIA"),
                            schD,
                            expD,
                            rs.getString("AIRLINENAME"),
                            Flight.FlightState.values()[rs.getInt("FLIGHTSTATE")]);
                }

                a.addFlight(f);
            }
        } catch (SQLException ex) {
            String s = ex.getMessage();
        }
    }
}
