package com.zhuravishkin.courses.javarush;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTests {
    public static void main(String[] args) {
        Date date = new Date(26192246400000L);
        Date date1 = new Date(26192246400001L);
        System.out.println(date.before(date1));

        int i = 12;
        try {
            Integer.parseInt(String.valueOf(i));
        } catch (NumberFormatException e) {
            System.out.println("Not number");
        }

        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.now().plusDays(1);
        System.out.println(ChronoUnit.DAYS.between(localDateTime1, localDateTime2));

        Date minDate = new Date(0);
        Date maxDate = new Date(9223372036854775807L);
        System.out.println(minDate);
        System.out.println(maxDate);

        System.out.println(TimeZone.getDefault());
        System.out.println(Locale.getDefault());
    }
}
