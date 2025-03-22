package com.npo.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static String format(LocalDate localDate, String pattern) {
        if(localDate != null) {
            return localDate.format(DateTimeFormatter.ofPattern(pattern));
        }else{
            return "";
        }
    }
}
