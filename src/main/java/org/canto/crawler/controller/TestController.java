package org.canto.crawler.controller;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.canto.crawler.commons.MyHero;
import org.canto.crawler.commons.MyHttpClient;
import org.canto.crawler.mapper.LastReportMapper;
import org.canto.crawler.pojo.LastReportInfo;
import org.canto.crawler.pojo.ReportInfo;
import org.canto.crawler.server.ReportUpdateServer;
import org.canto.crawler.wod.ReportListCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author morningyet
 * @create 2019-09-04 15:30
 */
@Controller
public class TestController {

    @Autowired
    ReportListCrawler ReportListCrawler;

    @Autowired
    MyHttpClient myHttpClient;

    @Autowired
    LastReportMapper lastReportMapper;

    @Autowired
    ReportUpdateServer reportUpdateServer;

    @ResponseBody
    @RequestMapping("/test")
    public String reportMapperTest() {

        LastReportInfo lastReportInfo = new LastReportInfo();
        lastReportInfo.setDateTime(LocalDateTime.now());
        lastReportInfo.setHeroSessionID("123456");
        lastReportInfo.setReportId("456789");
        lastReportInfo.setReportName("无敌是多么寂寞");


        Integer i = lastReportMapper.insertMyLastReport(lastReportInfo);

        return i.toString();
    }


    @ResponseBody
    @RequestMapping("/reportget/{num}")
    public String reportListGet(@PathVariable("num") Integer num){

        MyHero myHero = MyHero.getMyHeroByNum(num);


        CloseableHttpResponse response = null;
        List<ReportInfo> reportInfos = new ArrayList<>();



        try {
            reportInfos = reportUpdateServer.reportInfoListCrawler(response, myHttpClient, myHero);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ReportInfo reportInfo = reportInfos.get(1);


        LastReportInfo lastReportInfo = new LastReportInfo();
        lastReportInfo.setDateTime(reportInfo.getDateTime());
        lastReportInfo.setHeroSessionID(myHero.getId());
        lastReportInfo.setReportId(reportInfo.getReportId());
        lastReportInfo.setReportName(reportInfo.getReportName());


        Integer i = lastReportMapper.insertMyLastReport(lastReportInfo);

        return i.toString();

    }


    /**
     * 用处生成 mysql  lastreport 表初始文件
     * @return
     */
    @ResponseBody
    @RequestMapping("/reportget")
    public String reportListGet(){


        CloseableHttpResponse response = null;
        List<ReportInfo> reportInfos = new ArrayList<>();
        MyHero myHero;



        for (int i = 1; i < 5; i++) {
            myHero = MyHero.getMyHeroByNum(i);

            try {
                reportInfos = reportUpdateServer.reportInfoListCrawler(response, myHttpClient, myHero);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ReportInfo reportInfo = reportInfos.get(1);

            LastReportInfo lastReportInfo = new LastReportInfo();
            lastReportInfo.setDateTime(reportInfo.getDateTime());
            lastReportInfo.setHeroSessionID(myHero.getId());
            lastReportInfo.setReportId(reportInfo.getReportId());
            lastReportInfo.setReportName(reportInfo.getReportName());

            Integer x = lastReportMapper.insertMyLastReport(lastReportInfo);

            System.out.println(x);

        }


        return "success";

    }

}
