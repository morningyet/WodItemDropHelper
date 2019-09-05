package org.canto.crawler.jsoup;

import org.canto.crawler.pojo.HeroInfo;
import org.canto.crawler.pojo.ReportInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author morningyet
 * @create 2019-09-01 14:42
 */
public class JsoupParse {

    /**
     * 将获取战利品页面所有的宝库掉落提取并加入List
     * @param items
     * @return
     */
    public static List<String> itemsListParse(String items) {

        Document doc = Jsoup.parse(items);
        //选择器:选择<i>标签的父节点 的 上一个节点
        // <i> 通常是指"被明信片放入宝库中"类的字样
        Elements elements = doc.getElementsByTag("i").parents().prev();

        List<String> itemsList = new ArrayList<>();

        if (elements != null) {
            for (Element element : elements) {
                //在i父标签上一个节点<td>中,选择<a>标签同时className为report的元素的text文本
                String item = element.select("a.report").text();
                //该文本如果不为空,且不是空字符串,就是想要得到的放入宝库的item了
                if (item != null && !item.equals("") && !item.equals(" ")) {
                    itemsList.add(item);
                }
            }
        }
        return itemsList;
    }


    /**
     * 将战报列表response的到的字符串 解析为战报列表List
     * @param reports
     * @return
     */
    public static List<ReportInfo> reportInfoListParse(String reports) {
        List<ReportInfo> reportInfoList = new ArrayList<>() ;
        List<String> reportsName = new ArrayList<>();
        List<String> reportsTime = new ArrayList<>();
        List<String> reportsNum = new ArrayList<>();
        List<String> reportsId = new ArrayList<>();

        String reportName = null;
        String reportTime = null;
        String reportNum = null;
        String reportId = null;

        Document doc = Jsoup.parse(reports);

        Elements elements = doc.select(".content_table td");

        if (elements != null) {
            for (Element element : elements) {
                reportName = element.getElementsByAttribute(" align").next().text();
                if (reportName != null && !"".equals(reportName) && !" ".equals(reportName)) {
                    reportsName.add(reportName);
                }

                reportTime = element.getElementsByAttribute(" align").text();
                if (reportTime != null && !"".equals(reportTime) && !" ".equals(reportTime)) {
                    reportsTime.add(reportTime);
                }
            }
        }

        Elements elements2 = doc.select(".content_table input[type=hidden]");

        if (elements2 != null) {
            for (Element element : elements2) {
                reportNum = element.attr("name");
                reportId = element.attr("value");

                if (reportNum != null && !"".equals(reportNum) && !" ".equals(reportNum)) {
                    reportsNum.add(reportNum);
                }

                if (reportId != null && !"".equals(reportId) && !" ".equals(reportId)) {
                    reportsId.add(reportId);
                }



            }
        }

        if(reportsNum.size() !=0){
            int n = reportsNum.size();
            for (int i = 0; i < n-1; i++) {
                //System.out.println(reportsName.get(i)+"{"+reportsTime.get(i)+"}"+reportsNum.get(i)+reportsId.get(i));

                ReportInfo reportInfo = new ReportInfo(
                        reportsNum.get(i),
                        reportsName.get(i),
                        reportsTime.get(i),
                        reportsId.get(i)
                );

                reportInfoList.add(reportInfo);
            }



        }else{
            System.out.println("采集战报数量不统一,什么情况?!");
        }


        //System.out.println(reportInfoList.toString());


        return reportInfoList;

    }

    /**
     * 将英雄信息页得到的字符串,解析为HeroInfo类
     * @param myheroinformation
     * @return
     */
    public static HeroInfo HeroInfoParse(String myheroinformation){

        /**
         *  <form action="/wod/spiel/hero/profile.php?session_hero_id=143040" name="the_form" accept-charset="UTF-8" method="post">
         * 	<input type="hidden" name="session_hero_id" value="143040" />
         * 	<input type="hidden" name="wod_post_id" value="5x0rd1g2k2l9kkh1doawsq0h2jaa9twv" />
         * 	<input type="hidden" name="wod_post_world" value="CC" />
         * 	<input type="hidden" name="pay_from_group_cash_box" value="0" />
         * 	<input type="hidden" name="put_purchases_to" value="go_lager" />
         * 	<input type="hidden" name="klasse_id" value="59" />
         * 	<input type="hidden" name="klasse_name" value="法师" />
         * 	<input type="hidden" name="rasse_id" value="8" />
         * 	<input type="hidden" name="rasse_name" value="提伦-埃精灵" />
         * 	<input type="hidden" name="gruppe_id" value="156776" />
         * 	<input type="hidden" name="gruppe_name" value="jojo的奇妙冒险" />
         * 	<input type="hidden" name="clan_id"	 value="310" />
         * 	<input type="hidden" name="clan_name" value="Darkest Dungeon" />
         * 	<input type="hidden" name="stufe" value="38" />
         * 	<input type="hidden" name="heldenname" value="爱故乡的歌" />
         * 	<input type="hidden" name="spielername" value="morningyet" />
         * 	<input type="hidden" name="display_hero_id" value="143040" />
         */
        HeroInfo MyheroInfo = new HeroInfo();

        Document doc = Jsoup.parse(myheroinformation);

        Element element = doc.getElementsByAttributeValue("name","the_form").first();

        MyheroInfo.setSession_hero_id(element.getElementsByAttributeValue("name","session_hero_id").attr("value"));
        MyheroInfo.setWod_post_id(element.getElementsByAttributeValue("name","wod_post_id").attr("value"));
        MyheroInfo.setWod_post_world(element.getElementsByAttributeValue("name","wod_post_world").attr("value"));
        MyheroInfo.setPay_from_group_cash_box(element.getElementsByAttributeValue("name","pay_from_group_cash_box").attr("value"));
        MyheroInfo.setPut_purchases_to(element.getElementsByAttributeValue("name","put_purchases_to").attr("value"));
        MyheroInfo.setKlasse_id(element.getElementsByAttributeValue("name","klasse_id").attr("value"));
        MyheroInfo.setKlasse_name(element.getElementsByAttributeValue("name","klasse_name").attr("value"));
        MyheroInfo.setRasse_id(element.getElementsByAttributeValue("name","rasse_id").attr("value"));
        MyheroInfo.setRasse_name(element.getElementsByAttributeValue("name","rasse_name").attr("value"));
        MyheroInfo.setGruppe_id(element.getElementsByAttributeValue("name","gruppe_id").attr("value"));
        MyheroInfo.setGruppe_name(element.getElementsByAttributeValue("name","gruppe_name").attr("value"));
        MyheroInfo.setClan_id(element.getElementsByAttributeValue("name","clan_id").attr("value"));
        MyheroInfo.setClan_name(element.getElementsByAttributeValue("name","clan_name").attr("value"));
        MyheroInfo.setStufe(element.getElementsByAttributeValue("name","stufe").attr("value"));
        MyheroInfo.setHeldenname(element.getElementsByAttributeValue("name","heldenname").attr("value"));
        MyheroInfo.setSpielername(element.getElementsByAttributeValue("name","spielername").attr("value"));
        MyheroInfo.setDisplay_hero_id(element.getElementsByAttributeValue("name","display_hero_id").attr("value"));

        //System.out.println(MyheroInfo.toString());

        return MyheroInfo;
    }




}
