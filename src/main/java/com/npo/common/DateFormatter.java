package com.npo.common;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    public static String format(LocalDate localDate, String pattern) {
        if(localDate != null) {
            return localDate.format(DateTimeFormatter.ofPattern(pattern));
        }else{
            return "";
        }
    }

    public static String formatTimestamp(LocalDateTime localDateTime, String pattern) {
        if(localDateTime != null) {
            return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
        }else{
            return "";
        }
    }

    public static String formatTimestamp(LocalDateTime localDateTime) {
        return formatTimestamp(localDateTime, "dd-MMM-yyyy hh:mm a");
    }

    public static String formatTimestampWithDayOfWeek(LocalDateTime localDateTime) {
        return formatTimestamp(localDateTime, "EEEE, dd-MMM-yyyy hh:mm a");
    }

    public static String duration(LocalDateTime startDate, LocalDateTime endDate){
        Duration duration = Duration.between(startDate, endDate);
        return String.format("%d Hours, %d Minutes",duration.toHoursPart(), duration.toMinutesPart());
    }

}
