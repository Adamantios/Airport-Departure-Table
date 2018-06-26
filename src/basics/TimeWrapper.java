package basics;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


class TimeWrapper {

    private static boolean running = false;
    private static boolean suspended = true;

    static boolean flightsManagerRunning = false;

    private static ScheduledExecutorService service;

    static void Suspend() {
        suspended = true;
    }

    static void Start() {
        suspended = false;
    }

    static void ShutDown() {
        running = false;
    }

    static void StartUp() {

        if (running) {
            return;
        }

        service = Executors.newSingleThreadScheduledExecutor();

        service.scheduleWithFixedDelay(() -> {

            //debugging
            //System.out.println(
            //        "run:" + (running ? "yes" : "no") +
            //                " suspend:" + (suspended ? "yes" : "no"));

            if (!running) {
                service.shutdown();
                return;
            }
            if (!suspended) {
                Utilities.setCurrentDateTime(new Date(
                        Utilities.getCurrentDateTime().getTime() +
                                (Utilities.getTimeMultiplier() * 1000)));
                if (!flightsManagerRunning) {
                    (new FlightsManager()).start();
                }
            }
        }, 1, 1, TimeUnit.SECONDS);

        running = true;
    }
}
