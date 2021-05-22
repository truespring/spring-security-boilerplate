package com.mini2S.common.util.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeFormat {
    private static final String formatForDB = "yyyy-MM-dd HH:mm:ss";
    private static final String formatForFront = "yyyy-MM-dd";
    private static final String defaultDttm = "0000-00-00";

    public static LocalDateTime ConvertDttm(String dttm, String type){
        LocalDateTime originDttm;
        if(type.equals("1")){
//            originDttm = String.valueOf(LocalDateTime.parse(dttm, DateTimeFormatter.ofPattern(formatForFront)));
            originDttm = LocalDate.parse(dttm, DateTimeFormatter.ofPattern(formatForFront)).atStartOfDay();
            System.out.println("originDttm : "+originDttm);
            return originDttm;
//            System.out.println("변경 : "+ LocalDateTime.parse(originDttm, DateTimeFormatter.ofPattern(formatForDB)));
//            return LocalDate.parse(originDttm, DateTimeFormatter.ofPattern(formatForDB)).atStartOfDay();
        }else{
//            originDttm = String.valueOf(LocalDateTime.parse(dttm, DateTimeFormatter.ofPattern(formatForDB)));
//          w  return LocalDateTime.parse(originDttm, DateTimeFormatter.ofPattern(formatForFront));
            return null;
        }
    }
    public static LocalDateTime ConvertDefaultDttm(){
        return LocalDate.parse(defaultDttm, DateTimeFormatter.ofPattern(formatForFront)).atStartOfDay();
    }
}
