package org.canto.crawler.commons;

/**
 * @author morningyet
 * @create 2019-09-01 6:58
 */
public class MyUri {

    /**
     * 登录用的uri 进行post登录,并记录cookies
     */
    public static final String loginUri = "http://canto.world-of-dungeons.org";

    /**
     * 获取战报列表页 做GET请求,有uribuilder绑定请求参数
     */
    public static final String reportsUri = "http://canto.world-of-dungeons.org/wod/spiel/dungeon/report.php";


    /**
     * 获取掉落品列表,做post请求,需要绑定form表单,为了使用方便,加了后缀?session_hero_id=
     * 使用时注意拼接上heroId字符串
     */
    public static final String itemsUri = "http://canto.world-of-dungeons.org/wod/spiel//dungeon/report.php?session_hero_id=";

    /**
     * 获取英雄属性的GET请求页, 因为只会有一个参数,为了使用方便,加了后缀?session_hero_id=
     * 使用时注意拼接上heroId字符串
     */
    public static final String myHeroInfoUri = "http://canto.world-of-dungeons.org/wod/spiel/hero/profile.php?session_hero_id=";


}
