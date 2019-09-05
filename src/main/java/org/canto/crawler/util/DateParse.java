package org.canto.crawler.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author morningyet
 * @create 2019-09-01 21:09
 */
public class DateParse {
    public static DateTimeFormatter fomatter1 = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm");
    public static DateTimeFormatter fomatter2 = DateTimeFormatter
            .ofPattern("yyyy年MM月dd日 HH:mm");
    public static DateTimeFormatter fomatter3 = DateTimeFormatter
            .ofPattern("yyyy年MM月dd日");

    public static LocalDateTime stringToDate(String reportTime){
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate date = LocalDate.now();
        LocalDate yesterday = date.plusDays(-1);
        String[] report = reportTime.split(" ");
        if("今天".equals(report[0])){
            report[0]=date.format(DateParse.fomatter3);
        }else if("昨天".equals(report[0])){
            report[0]=yesterday.format(DateParse.fomatter3);
        }
//        System.out.println(report[0]+" "+report[1]);
        dateTime = LocalDateTime.parse(report[0]+" "+report[1], fomatter2);
        return dateTime;
    }


}
