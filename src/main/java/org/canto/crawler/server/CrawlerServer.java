package org.canto.crawler.server;

import org.apache.http.client.HttpClient;
import org.canto.crawler.commons.MyHero;
import org.canto.crawler.pojo.HeroInfo;
import org.canto.crawler.pojo.LastReportInfo;
import org.canto.crawler.pojo.ReportInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

/**
 * @author morningyet
 * @create 2019-09-05 12:14
 */
@Service
public class CrawlerServer {


    @Autowired
    ReportUpdateServer reportUpdateServer;

    @Autowired
    ItemsDropUpdateServer itemsDropUpdateServer;

    @Autowired
    HttpClient httpClient;

    /**
     * 执行爬虫程序
     * @param num 第几个英雄
     * @return
     */
    public String startCrawler(Integer num){

        MyHero myHero = MyHero.getMyHeroByNum(num);

        HeroInfo heroInfo = reportUpdateServer.getHeroInfo(myHero);
        System.out.println(heroInfo);

        LastReportInfo lastReportInfo = reportUpdateServer.getLastReportInfo(myHero);
        System.out.println(lastReportInfo);

        List<ReportInfo> reportInfoList = reportUpdateServer.getReportInfoList(myHero);
        System.out.println(reportInfoList);

        Integer count = reportUpdateServer.getNeedCrawlerReportNum(reportInfoList, lastReportInfo);
        System.out.println(count);

        List<Map<String, List<String>>> dropmapList = reportUpdateServer.getItemDropInfoList(heroInfo, reportInfoList, count);
        System.out.println(dropmapList);

        itemsDropUpdateServer.updateItemDropCount(dropmapList, myHero);

        reportUpdateServer.updateLastreport(reportInfoList , myHero);

        return "done";
    }
}
