package rjsc;

public class Time {

    public static void printHoursMinutesSecond(long millis) {
        long hours = millis / 3600000;
        millis -= hours * 3600000;

        long minutes = millis / 60000;
        millis -= minutes * 60000;

        long seconds = millis / 1000;
        millis -= seconds * 1000;

        System.out.printf("Elapse time %d:%02d:%02d.%03d", hours, minutes, seconds, millis);
    }
}
