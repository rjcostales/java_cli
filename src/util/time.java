package util;

public class time {

    void printHoursMinutesSecond(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds - (hours * 3600)) / 60;
    }
}
