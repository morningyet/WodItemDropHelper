package org.canto.crawler.pojo;


/**
 * CREATE TABLE `wod`.`items_drop`  (
 * `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
 * `items_name` varchar(255) NOT NULL,
 * `dungeons_id` int(10) NULL,
 * `dungeons_name` varchar(255) NOT NULL,
 * `branch` varchar(20) NULL,
 * `floor` tinyint(8) NULL,
 * `uni` varchar(20) NULL,
 * `role1` tinyint(8) NULL,
 * `role2` tinyint(8) NULL,
 * `role3` tinyint(8) NULL,
 * `role4` tinyint(8) NULL,
 * `role5` tinyint(8) NULL,
 * `role6` tinyint(8) NULL,
 * PRIMARY KEY (`id`)
 * );
 */


import org.apache.commons.lang3.StringUtils;
import org.canto.crawler.commons.MyHero;

/**
 * @author morningyet
 * @create 2019-09-03 8:56
 */
public class ItemDropInfo {
    private Integer id;
    private String itemsName;
    private Integer dungeonsId;
    private String dungeonsName;
    private String branch;
    private String floor;
    private String uni;
    private String role1;
    private String role2;
    private String role3;
    private String role4;
    private String role5;
    private String role6;

    public ItemDropInfo(String itemsName, String dungeonsName, String branch, String floor) {
        this.itemsName = itemsName;
        this.dungeonsName = dungeonsName;
        this.branch = branch;
        this.floor = floor;
    }

    public ItemDropInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public Integer getDungeonsId() {
        return dungeonsId;
    }

    public void setDungeonsId(Integer dungeonsId) {
        this.dungeonsId = dungeonsId;
    }

    public String getDungeonsName() {
        return dungeonsName;
    }

    public void setDungeonsName(String dungeonsName) {
        this.dungeonsName = dungeonsName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getRole1() {
        return role1;
    }

    public void setRole1(String role1) {
        this.role1 = role1;
    }

    public String getRole2() {
        return role2;
    }

    public void setRole2(String role2) {
        this.role2 = role2;
    }

    public String getRole3() {
        return role3;
    }

    public void setRole3(String role3) {
        this.role3 = role3;
    }

    public String getRole4() {
        return role4;
    }

    public void setRole4(String role4) {
        this.role4 = role4;
    }

    public String getRole5() {
        return role5;
    }

    public void setRole5(String role5) {
        this.role5 = role5;
    }

    public String getRole6() {
        return role6;
    }

    public void setRole6(String role6) {
        this.role6 = role6;
    }


    public String toMyString() {
        return "ItemDropInfo{" +
                "itemsName=" + itemsName +
                ", dungeonsName=" + dungeonsName +
                ", branch=" + branch +
                ", floor=" + floor +
                '}';
    }

    @Override
    public String toString() {
        return "ItemDropInfo{" +
                "id=" + id +
                ", itemsName='" + itemsName + '\'' +
                ", dungeonsId=" + dungeonsId +
                ", dungeonsName='" + dungeonsName + '\'' +
                ", branch='" + branch + '\'' +
                ", floor='" + floor + '\'' +
                ", uni='" + uni + '\'' +
                ", role1='" + role1 + '\'' +
                ", role2='" + role2 + '\'' +
                ", role3='" + role3 + '\'' +
                ", role4='" + role4 + '\'' +
                ", role5='" + role5 + '\'' +
                ", role6='" + role6 + '\'' +
                '}';
    }


    public void addHerorecord(MyHero myHero) {
        String s = myHero.name();
//        System.out.println(s);
        switch (StringUtils.right(s, 1)) {
            case "1":
                if (this.getRole1() == null) {
                    this.setRole1("1");
                }else{
                    Integer i = Integer.valueOf(this.getRole1());
                    i++;
                    this.setRole1(i.toString());
                }
                break;
            case "2":
                if (this.getRole2() == null) {
                    this.setRole2("1");
                }else{
                    Integer i = Integer.valueOf(this.getRole2());
                    i++;
                    this.setRole2(i.toString());
                }
                break;
            case "3":
                if (this.getRole3() == null) {
                    this.setRole3("1");
                }else{
                    Integer i = Integer.valueOf(this.getRole3());
                    i++;
                    this.setRole3(i.toString());
                }
                break;
            case "4":
                if (this.getRole4() == null) {
                    this.setRole4("1");
                }else{
                    Integer i = Integer.valueOf(this.getRole4());
                    i++;
                    this.setRole4(i.toString());
                }
                break;
            case "5":
                if (this.getRole5() == null) {
                    this.setRole5("1");
                }else{
                    Integer i = Integer.valueOf(this.getRole5());
                    i++;
                    this.setRole5(i.toString());
                }
                break;
            case "6":
                if (this.getRole6() == null) {
                    this.setRole6("1");
                }else{
                    Integer i = Integer.valueOf(this.getRole6());
                    i++;
                    this.setRole6(i.toString());
                }
                break;
            default:
                break;


        }
    }
}
