package com.FirstApp.FirstApp.utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static LocalDateTime now = LocalDateTime.now();

    public static String getCurrentDateTime(){
        return now.format(format);
    }

    public static String getDateTime(LocalDateTime date){
        return date.format(format);
    }

}
