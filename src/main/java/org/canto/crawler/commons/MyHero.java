package org.canto.crawler.commons;

/**
 * @author morningyet
 * @create 2019-09-04 14:39
 */
public enum MyHero {
    Myhero01("158850", "“甜党领袖”咸鱼爱夏"),  //158850 “甜党领袖”咸鱼爱夏
    Myhero02("163052", "爱夏 ver6.0"),
    Myhero03("148463", "爱故乡的夏ver 2.0"),
    Myhero04("143040", "爱故乡的歌"),

    HeroKey("HeroSessionKey", "session_hero_id");  //一个常量定义


    private String desc;//中文描述
    private String id;

    private MyHero(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public static MyHero getMyHeroByNum(Integer i) {
        switch (i) {
            case 1:
                return MyHero.Myhero01;
            case 2:
                return MyHero.Myhero02;
            case 3:
                return MyHero.Myhero03;
            case 4:
                return MyHero.Myhero04;
            default:
                return MyHero.HeroKey;
        }
    }

}
