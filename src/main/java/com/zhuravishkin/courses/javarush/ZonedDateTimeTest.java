package com.zhuravishkin.courses.javarush;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeTest {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        System.out.println(ZonedDateTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now(ZoneOffset.UTC));
        System.out.println(ZonedDateTime.ofInstant(ZonedDateTime.now().toInstant(), ZoneOffset.UTC));

        System.out.println();

        String utc_offset = "+10";
        Long event_time = 1606886871001L;
        ZoneOffset offset = ZoneOffset.of(utc_offset);
        System.out.println(ZonedDateTime.ofInstant(Instant.ofEpochMilli(event_time), offset));
        System.out.println(ZonedDateTime.ofInstant(Instant.ofEpochMilli(event_time), ZoneOffset.UTC));
        System.out.println(ZonedDateTime.ofInstant(Instant.ofEpochMilli(event_time), ZoneOffset.UTC).getNano());

        System.out.println();

        System.out.println(Clock.systemDefaultZone().millis());
        System.out.println(LocalDateTime.now(Clock.systemDefaultZone()));
    }
}
