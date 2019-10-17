package lesson13.practice.hortsman;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateRunner {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        today = today.plusDays(1);
        today = today.withDayOfYear(256);
        LocalDate myBirthday = LocalDate.of(1985,4,11);
        myBirthday = myBirthday.plusYears(1);
        LocalTime rightNow = LocalTime.of(22,10);
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(today + " " + myBirthday + " " + rightNow + " " + formatter.format(dateTime));
    }
}
