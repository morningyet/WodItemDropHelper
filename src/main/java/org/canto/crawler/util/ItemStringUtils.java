package org.canto.crawler.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 物品帖子字符串处理函数
 * @author morningyet
 * @create 2019-09-04 8:17
 */
public class ItemStringUtils {

    public static Boolean isBlankLine(String s){
        //return StringUtils.isEmpty(s);
        /*
            StringUtils.isBlank(null) = true
            StringUtils.isBlank("") = true
            StringUtils.isBlank(" ") = true
            StringUtils.isBlank("        ") = true
         */
        return StringUtils.isBlank(s);
    }
    public static Boolean isitemsName(String s){
        String ss = StringUtils.trim(s);
        int index = StringUtils.indexOf(ss,"item");
        if(index == 1) return true;
        return false;
    }
    public static Boolean isDungeonsName(String s){
        int index = StringUtils.indexOf(s,"size");
        if(index == 1) return true;
        if(StringUtils.contains(s,"[*]")) return true;
        return false;
    }
    public static Boolean isFloor(String s){
        int index = StringUtils.indexOf(s,"F");
        if(index == 0) return true;
        index  = StringUtils.indexOf(s,"lv");
        if(index == 0) return true;
        index  = StringUtils.indexOf(s,"f");
        if(index == 0) return true;
        index  = StringUtils.indexOf(s,"LV");
        if(index == 0) return true;
        index  = StringUtils.indexOf(s,"Lv");
        if(index == 0) return true;
        if(StringUtils.indexOf(s,"第")==0  &&StringUtils.indexOf(s,"层")==2)
            return true;
        return false;
    }
    public static Boolean isBranch(String s){
        int index = StringUtils.indexOf(s,"线");
        if(index == 2) return true;
        return false;
    }

    public static String getItemName(String s){

        String[] s1 = s.split("item:");
        String[] s2 = StringUtils.split(s1[1],"]");
        String s3 = StringUtils.strip(s2[0]);
        return s3;
    }
    public static String getDungeonsName(String s){
        String[] s1 = StringUtils.split(s,"*");
        String s2 = StringUtils.removeStart(s1[1], "]");
        String s3 = StringUtils.removeStart(s2, "[b]");
        String[] s4 = StringUtils.split(s3,"[");
        String s5 = StringUtils.strip(s4[0]);

        return s5;
    }
    public static String getFloor(String s){

        if(StringUtils.indexOf(s,"第")==0  &&StringUtils.indexOf(s,"层")==2){
            char[] chars = s.toCharArray();

            switch (chars[1]+""){
                case "一":return "1";
                case "二":return "2";
                case "三":return "3";
                case "四":return "4";
                case "五":return "5";
                case "六":return "6";
                case "七":return "7";
                case "八":return "8";
                case "九":return "9";
                default:return null;


            }



        }



        String s1 = StringUtils.removeStart(s, "F");
        String s2 = StringUtils.removeStart(s1, "f");
        String s3 = StringUtils.removeStart(s2, "L");
        String s4 = StringUtils.removeStart(s3, "l");
        String s5 = StringUtils.removeStart(s4, "V");
        String s6 = StringUtils.removeStart(s5, "v");

        String s7 = StringUtils.left(s6,2);
        if("10".equals(s7) ||"11".equals(s7)||"12".equals(s7) )return StringUtils.trim(s7);

        String s8 = StringUtils.left(s6,1);
        return StringUtils.trim(s8);
    }
    public static String getBranch(String s){
        String[] s1 = StringUtils.split(s,"线");
        return StringUtils.trim(s1[0]);
    }


}
