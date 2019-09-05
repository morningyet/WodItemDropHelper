package org.canto.crawler.commons;

import org.canto.crawler.pojo.HeroInfo;
import org.canto.crawler.pojo.ReportInfo;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.canto.crawler.pojo.HeroInfo;
import org.canto.crawler.pojo.ReportInfo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author morningyet
 * @create 2019-09-01 7:05
 */
public class MyParamsForm {

    private static UrlEncodedFormEntity ReportFormEntity = null;
    private static UrlEncodedFormEntity LoginInFormEntity = null;

    public static UrlEncodedFormEntity getLoginInFormEntity() {

        UrlEncodedFormEntity formEntity = null;

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        //添加登录表单
        params.add(new BasicNameValuePair("world", "CC"));
        params.add(new BasicNameValuePair("USERNAME", MySecret.MYUSERNAME));
        params.add(new BasicNameValuePair("PASSWORT", MySecret.MYPASSWORD));
        params.add(new BasicNameValuePair("LOGIN_BUTTON", "1"));
        params.add(new BasicNameValuePair("network", "wod"));
        params.add(new BasicNameValuePair("resetskin", ""));
        params.add(new BasicNameValuePair("savepassword", "1"));

        try {
            formEntity = new UrlEncodedFormEntity(params, "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return formEntity;
    }

    //测试用表单,参数已经写死
    public static UrlEncodedFormEntity getReportFormEntity() {
        UrlEncodedFormEntity formEntity = null;

        List<NameValuePair> params = new ArrayList<NameValuePair>();

        /*
        session_hero_id:143040
        wod_post_id:vlykzv64pd652w0n1br17yp9n0m408xw
        wod_post_world:CC
        pay_from_group_cash_box:0
        put_purchases_to:go_lager
        klasse_id:59
        klasse_name:法师
        rasse_id:8
        rasse_name:提伦-埃精灵
        gruppe_id:156776
        gruppe_name:jojo的奇妙冒险
        clan_id:310clan_name:
        Darkest+Dungeon:
        stufe:38
        heldenname:爱故乡的歌
        spielername:morningyet
        current_level_nr:
        report_id[0]:4197635
        items[0]:获得物品
         */
        //添加登录表单
        params.add(new BasicNameValuePair("session_hero_id", MyHero.Myhero04.getId()));
        params.add(new BasicNameValuePair("wod_post_id", "vlykzv64pd652w0n1br17yp9n0m408xw"));
        params.add(new BasicNameValuePair("wod_post_world", "CC"));
        params.add(new BasicNameValuePair("pay_from_group_cash_box", "0"));
        params.add(new BasicNameValuePair("put_purchases_to", "go_lager"));
        params.add(new BasicNameValuePair("klasse_id", "59"));
        params.add(new BasicNameValuePair("klasse_name", "法师"));
        params.add(new BasicNameValuePair("rasse_id", "8"));
        params.add(new BasicNameValuePair("rasse_name", "提伦-埃精灵"));
        params.add(new BasicNameValuePair("gruppe_id", "156776"));
        params.add(new BasicNameValuePair("gruppe_name", "jojo的奇妙冒险"));
        params.add(new BasicNameValuePair("clan_id", "310clan_name:"));
        params.add(new BasicNameValuePair("Darkest+Dungeon", ""));
        params.add(new BasicNameValuePair("stufe", "38"));
        params.add(new BasicNameValuePair("heldenname", "爱故乡的歌"));
        params.add(new BasicNameValuePair("spielername", "morningyet"));
        params.add(new BasicNameValuePair("current_level_nr", ""));
        params.add(new BasicNameValuePair("report_id[0]", "4200185"));
        params.add(new BasicNameValuePair("items[0]", "获得物品"));


        try {
            formEntity = new UrlEncodedFormEntity(params, "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return formEntity;


    }

    //参数化的战报读取表单

    /**
     *
     * @param myHeroInfo   我的英雄数据,session_hero_id外其他的数据需要爬出来
     * @param reportInfoList    当时的战报信息列表
     * @param num   爬第几个战报
     * @return
     */
    public static UrlEncodedFormEntity getReportFormEntity(HeroInfo myHeroInfo, List<ReportInfo> reportInfoList, Integer num) {

        UrlEncodedFormEntity formEntity = null;

        List<NameValuePair> params = new ArrayList<NameValuePair>();


        //添加登录表单
        params.add(new BasicNameValuePair("session_hero_id", myHeroInfo.getSession_hero_id()));

        params.add(new BasicNameValuePair("wod_post_id", myHeroInfo.getWod_post_id()));
        params.add(new BasicNameValuePair("wod_post_world", myHeroInfo.getWod_post_world()));
        params.add(new BasicNameValuePair("pay_from_group_cash_box", myHeroInfo.getPay_from_group_cash_box()));
        params.add(new BasicNameValuePair("put_purchases_to", myHeroInfo.getPut_purchases_to()));

        params.add(new BasicNameValuePair("klasse_id", myHeroInfo.getKlasse_id()));
        params.add(new BasicNameValuePair("klasse_name", myHeroInfo.getKlasse_name()));
        params.add(new BasicNameValuePair("rasse_id", myHeroInfo.getRasse_id()));
        params.add(new BasicNameValuePair("rasse_name", myHeroInfo.getRasse_name()));
        params.add(new BasicNameValuePair("gruppe_id", myHeroInfo.getGruppe_id()));
        params.add(new BasicNameValuePair("gruppe_name", myHeroInfo.getGruppe_name()));
        params.add(new BasicNameValuePair("clan_id", myHeroInfo.getClan_id()));
        params.add(new BasicNameValuePair("clan_name", myHeroInfo.getClan_name()));
        params.add(new BasicNameValuePair("stufe", myHeroInfo.getStufe()));
        params.add(new BasicNameValuePair("heldenname", myHeroInfo.getHeldenname()));
        params.add(new BasicNameValuePair("spielername", myHeroInfo.getSpielername()));

        params.add(new BasicNameValuePair("current_level_nr", ""));

        params.add(new BasicNameValuePair("items["+num+"]", "获得物品"));

        for(ReportInfo reportInfo :reportInfoList){
            params.add(new BasicNameValuePair(reportInfo.getReportNo(), reportInfo.getReportId()));
        }





        try {
            formEntity = new UrlEncodedFormEntity(params, "utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return formEntity;
    }


}
