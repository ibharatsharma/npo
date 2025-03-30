package com.npo.common;

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

}
