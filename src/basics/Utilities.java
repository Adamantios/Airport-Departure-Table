package basics;

import java.util.Calendar;
import java.util.Date;


class Utilities {

    static final int BOARDING_MINUTES_BEFORE_DEPARTURE = 30;
    static final int GATESCLOSE_MINUTES_BEFORE_DEPARTURE = 35;
    private static final int AIRPORD_OPEN_HOUR = 5;
    private static final int AIRPORD_OPEN_MINUTES = 0;
    private static final int AIRPORD_CLOSE_HOUR = 1;
    private static final int AIRPORD_CLOSE_MINUTES = 0;

    private static int timeMultiplier;
    private static Date currentDateTime;

    static Date getCurrentDateTime() {
        return currentDateTime;
    }

    static void setCurrentDateTime(Date currentDateTime) {
        Utilities.currentDateTime = currentDateTime;
    }

    static int getTimeMultiplier() {
        return timeMultiplier;
    }

    static void setTimeMultiplier(int timeMultiplier) {
        Utilities.timeMultiplier = timeMultiplier;
    }

    static boolean offDuty(Date time) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int testDate = hourOfDay * 60 + minute;
        int airPortOpen = AIRPORD_OPEN_HOUR * 60 + AIRPORD_OPEN_MINUTES;
        int airPortClose = AIRPORD_CLOSE_HOUR * 60 + AIRPORD_CLOSE_MINUTES;

        return testDate > airPortClose && testDate < airPortOpen;
    }

    static Date addMinutes(Date date, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    /**
     * We insert a flight every 10 minutes,
     * assuming that the number of arrivals is the same as the number of departures.
     *
     * @param dt the date to be checked
     * @return boolean
     */
    static boolean timeCannotBeUsed(Date dt) {
        long examTime = dt.getTime() / 60000;

        for (Flight f : AirLines.getAllFligths()) {
            long flTime = f.getExpectedDepartureDateTime().getTime() / 60000;
            if ((examTime > flTime - 10) && (examTime < flTime + 10)) {
                return true;
            }
        }

        return false;
    }
}
