package rjsc;

public class Utilities {

    public static void printHoursMinutesSecond(long mills) {
        long hours = mills / 3600000;
        mills -= hours * 3600000;

        long minutes = mills / 60000;
        mills -= minutes * 60000;

        long seconds = mills / 1000;
        mills -= seconds * 1000;

        System.out.printf("Elapse time %d:%02d:%02d.%03d", hours, minutes, seconds, mills);
    }
}
