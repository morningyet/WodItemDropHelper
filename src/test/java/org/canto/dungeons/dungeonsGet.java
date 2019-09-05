package org.canto.dungeons;

import org.canto.crawler.mapper.ItemDropMapper;
import org.canto.crawler.pojo.ItemDropInfo;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.canto.crawler.pojo.ItemDropInfo;
import org.canto.crawler.util.ItemStringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author morningyet
 * @create 2019-09-02 15:52
 */
public class dungeonsGet {

    //https://blog.csdn.net/u012882577/article/details/78989560
    //FileUtil 用法
    @Autowired
    ItemDropMapper itemDropMapper;
    /**
     * 得到所有地城列表
     */
    @Test
    public void dungeonsGet() {

        List<String> readLines = null;
        List<String> writeLines = new ArrayList<>();
        try {
            readLines = FileUtils.readLines(new File("G:\\iWod\\dungeonsList\\dungeonsCopy.txt"), "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String readLine : readLines) {
            String[] line = readLine.split(" ");
            writeLines.add(line[0]);
        }
        try {
            FileUtils.writeLines(new File("G:\\iWod\\dungeonsList\\dungeonsList.txt"), writeLines, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据掉落文件生成物品掉落表: 包含 itemsName,dungeonsName,branch,floor
     */
    @Test
    public void creatItemsDropList() {
        List<ItemDropInfo> itemDropInfoList= new ArrayList<>();

        List<String> readLines = null;

        try {
            readLines = FileUtils.readLines(new File("G:\\iWod\\dropList\\post\\1.txt"), "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String dungeonsName = null;
        String floor = null;
        String branch = null;
        String itemsName = null;


        for (String s : readLines){

            if(isBlankLine(s)) continue;
            if(isDungeonsName(s)){
                dungeonsName = getDungeonsName(s);
                branch=null;
                floor=null;
            }

            if(isBranch(s)) {
                branch=getBranch(s);
                if("普通".equals(branch)) branch=null;
            }

            if(isFloor(s)) floor=getFloor(s);

            if(isitemsName(s)){
                itemsName = getItemName(s);
                ItemDropInfo itemDropInfo = new ItemDropInfo(itemsName,dungeonsName,branch,floor);
                itemDropInfoList.add(itemDropInfo);
            }
        }

        for(ItemDropInfo info: itemDropInfoList){
            System.out.println(info.toString());
            itemDropMapper.insertItemDropInfo(info);
        }
    }
    //https://www.cnblogs.com/peak911/p/9283143.html
    @Test
    public void tempTest(){
        String s ="[item:Steffan Apfells的十倍强效炼金药水]  ";
        String x = "身体 [item:荒年盛宴]";
        String y = "第一层";

//        String[] s1 = x.split("item:");
//        String[] s2 = StringUtils.split(s1[1],"]");
//        String s3 = StringUtils.strip(s2[0]);

        System.out.println(ItemStringUtils.isFloor(y));
        System.out.println(ItemStringUtils.getFloor(y));

    }

    /**
     *
     * @param s
     * @return
     */
    public Boolean isBlankLine(String s){
        //return StringUtils.isEmpty(s);
        /*
            StringUtils.isBlank(null) = true
            StringUtils.isBlank("") = true
            StringUtils.isBlank(" ") = true
            StringUtils.isBlank("        ") = true
         */
        return StringUtils.isBlank(s);
    }
    public Boolean isitemsName(String s){
        String ss = StringUtils.trim(s);
        int index = StringUtils.indexOf(ss,"item");
        if(index == 1) return true;
        return false;
    }
    public Boolean isDungeonsName(String s){
        int index = StringUtils.indexOf(s,"size");
        if(index == 1) return true;
        if(StringUtils.contains(s,"[*]")) return true;
        return false;
    }
    public Boolean isFloor(String s){
        int index = StringUtils.indexOf(s,"F");
        if(index == 0) return true;
        index  = StringUtils.indexOf(s,"lv");
        if(index == 0) return true;
        index  = StringUtils.indexOf(s,"f");
        if(index == 0) return true;
        index  = StringUtils.indexOf(s,"LV");
        if(index == 0) return true;
        return false;
    }
    public Boolean isBranch(String s){
        int index = StringUtils.indexOf(s,"线");
        if(index == 2) return true;
        return false;
    }

    public String getItemName(String s){

        String[] s1 = s.split("item:");
        String[] s2 = StringUtils.split(s1[1],"]");
        String s3 = StringUtils.strip(s2[0]);
        return s3;
    }
    public String getDungeonsName(String s){
        String[] s1 = StringUtils.split(s,"*");
        String s2 = StringUtils.removeStart(s1[1], "]");
        String s3 = StringUtils.removeStart(s2, "[b]");
        String[] s4 = StringUtils.split(s3,"[");
        String s5 = StringUtils.strip(s4[0]);

        return s5;
    }
    public String getFloor(String s){
        String s1 = StringUtils.removeStart(s, "F");
        String s2 = StringUtils.removeStart(s1, "f");
        String s3 = StringUtils.removeStart(s2, "lv");
        String s4 = StringUtils.removeStart(s3, "LV");
        String s5 = StringUtils.left(s4,2);
        if("10".equals(s5) ||"11".equals(s5)||"12".equals(s5) )return StringUtils.trim(s5);

        String s6 = StringUtils.left(s4,1);
        return StringUtils.trim(s6);
    }
    public String getBranch(String s){
        String[] s1 = StringUtils.split(s,"线");
        return StringUtils.trim(s1[0]);
    }







}
