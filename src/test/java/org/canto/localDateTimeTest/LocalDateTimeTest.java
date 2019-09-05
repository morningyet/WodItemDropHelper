package org.canto.localDateTimeTest;

import org.canto.crawler.util.DateParse;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author morningyet
 * @create 2019-09-01 20:12
 */
public class LocalDateTimeTest {


    @Test
    public void localDateTimeFormatTest() {
        DateTimeFormatter[] dtf = new DateTimeFormatter[]{
                //直接使用常量创建DateTimeFormatter格式器
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                //使用本地化的不同风格来创建DateTimeFormatter格式器
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
                DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG),
                //根据模式字符串来创建DateTimeFormatter格式器
                DateTimeFormatter.ofPattern("Gyyyy%%MMM%%dd HH:mm:ss"),
                DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm")

        };
        LocalDateTime date = LocalDateTime.now();
        //依次使用不同的格式器对LocalDateTime进行格式化
        for (int i = 0; i < dtf.length; i++) {
            //下面两行代码的作用相同
            System.out.println(date.format(dtf[i]));
            System.out.println(dtf[i].format(date));
        }
    }

    @Test
    public void StringFormatterParseLocalDateTime() {

        String str1 = "2017==04==12 01时06分09秒";

        DateTimeFormatter fomatter1 = DateTimeFormatter
                .ofPattern("yyyy==MM==dd HH时mm分ss秒");

        LocalDateTime dt1 = LocalDateTime.parse(str1, fomatter1);
        System.out.println(dt1); // 输出 2014-04-12T01:06:09


        String str2 = "2017$$$四月$$$13 20小时";
        DateTimeFormatter fomatter2 = DateTimeFormatter
                .ofPattern("yyy$$$MMM$$$dd HH小时");
        LocalDateTime dt2 = LocalDateTime.parse(str2, fomatter2);
        System.out.println(dt2); // 输出 2014-04-13T20:00

        String str3 = "2017年04月12日 01:06";
        DateTimeFormatter fomatter3 = DateTimeFormatter
                .ofPattern("yyyy年MM月dd日 HH:mm");
        LocalDateTime dt3 = LocalDateTime.parse(str3, fomatter3);

        DateTimeFormatter fomatter4 = DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm");

        System.out.println(dt3);
        System.out.println(dt3.format(fomatter4));
    }


    @Test
    public void parseTest(){
        String s1 ="今天 20:45";
        String s2 ="昨天 10:26";
        String s3 ="2019年08月30日 19:49";
        String s4 ="2019年08月28日 13:29";

        System.out.println(DateParse.stringToDate(s1).format(DateParse.fomatter1));
        System.out.println(DateParse.stringToDate(s2).format(DateParse.fomatter2));
        System.out.println(DateParse.stringToDate(s3).format(DateParse.fomatter1));
        System.out.println(DateParse.stringToDate(s4).format(DateParse.fomatter2));


    }
}
