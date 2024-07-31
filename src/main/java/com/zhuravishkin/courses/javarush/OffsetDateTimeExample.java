package com.zhuravishkin.courses.javarush;

import java.io.PrintWriter;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class OffsetDateTimeExample {
    public static void main(String[] args) {
        OffsetDateTime offsetDateTime = OffsetDateTime.now().withNano(0);
        System.out.println(offsetDateTime);
        LocalDateTime localDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        System.out.println(localDateTime);
        System.out.println(DateTimeFormatter.BASIC_ISO_DATE.format(offsetDateTime));
        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE.format(offsetDateTime));
        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(offsetDateTime));
        System.out.println(DateTimeFormatter.ISO_INSTANT.format(offsetDateTime));

        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("Hello world!");

        String s = "2020-03-18T17:50:33+03:00";
        OffsetDateTime parseOffsetDateTime = OffsetDateTime.parse(s);
        LocalDateTime parseLocalDateTime = offsetDateTime.toLocalDateTime();
        System.out.println(parseOffsetDateTime);
        System.out.println(parseLocalDateTime);
        System.out.println(parseLocalDateTime.with(LocalTime.MIDNIGHT));
        System.out.println(parseLocalDateTime.with(LocalTime.MIN));
        System.out.println(parseLocalDateTime.with(LocalTime.MAX));
        System.out.println(parseLocalDateTime.with(LocalDateTime.MIN));
        System.out.println(parseLocalDateTime.with(LocalDateTime.MAX));

        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli());

        System.out.println("tarantool:");
        LocalDateTime localDateTimeMilli = LocalDateTime.parse("2020-04-02T15:00:00");
        System.out.println(localDateTimeMilli.toInstant(ZoneOffset.UTC).toEpochMilli());
        System.out.println(localDateTimeMilli.minusDays(1));

        System.out.println("dateTimeFormatter:");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTimeEmpty = LocalDateTime.parse("2020-04-02 15:00:00", dateTimeFormatter);
        System.out.println(localDateTimeEmpty);
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTimeEmpty));

        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");
        LocalDateTime localDateTimeEmpty2 = LocalDateTime.parse("20200514T150000", dateTimeFormatter2);
        System.out.println(localDateTimeEmpty2);

        System.out.println("between:");
        LocalDateTime localDateTimeFrom = LocalDateTime.parse("2020-05-13T15:00:00");
        LocalDateTime localDateTimeNow = LocalDateTime.parse("2020-05-13T15:00:01");
        LocalDateTime localDateTimeTo = LocalDateTime.parse("2020-05-13T15:00:02");
        System.out.println(localDateTimeFrom.isBefore(localDateTimeNow));
        System.out.println(localDateTimeTo.isAfter(localDateTimeNow));
    }
}
