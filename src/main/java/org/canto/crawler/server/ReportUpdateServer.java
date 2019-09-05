package org.canto.crawler.server;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.canto.crawler.commons.MyHero;
import org.canto.crawler.commons.MyHttpClient;
import org.canto.crawler.jsoup.JsoupParse;
import org.canto.crawler.mapper.LastReportMapper;
import org.canto.crawler.pojo.HeroInfo;
import org.canto.crawler.pojo.ItemDropInfo;
import org.canto.crawler.pojo.LastReportInfo;
import org.canto.crawler.pojo.ReportInfo;
import org.canto.crawler.util.DateParse;
import org.canto.crawler.wod.ReportListCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 逻辑如下:
 * 1.查询当前hero id 下 mysql对应的最后战报 LastReportInfo    httpClint 应该是个单例bean
 * 2.查询当前hero id 下 爬虫所得战报  ReportInfoList
 * 3.将ReportInfoList中 DateTime 晚于 LastReportInfo DateTime.plus(+1)的战报数量
 * 4.根据HeroId获取英雄信息,构建查询表单from
 * 5.爬虫物品查询
 * 6.将物品列表按物品名更新数量+1到对应role的数据库中
 * 7.更新数据库LastReport
 * <p>
 * 6.7应该是一个事务
 *
 * @author morningyet
 * @create 2019-09-04 16:50
 */
@Service
public class ReportUpdateServer {
    @Autowired
    MyHttpClient myHttpClient;

    @Autowired
    HttpClient httpClient;

    @Autowired
    ReportListCrawler reportListCrawler;

    @Autowired
    LastReportMapper lastReportMapper;

    //查询当前hero mysql对应的最后战报 LastReportInfo
    public LastReportInfo getLastReportInfo(MyHero myHero) {
        LastReportInfo lastReportInfo = lastReportMapper.selectReportByHeroId(myHero.getId());
        return lastReportInfo;
    }

    //查询当前hero id 下 爬虫所得战报
    public List<ReportInfo> getReportInfoList(MyHero myHero) {

        CloseableHttpResponse response = null;
        List<ReportInfo> reportInfoList = new ArrayList<>();

        try {
            reportInfoList = this.reportInfoListCrawler(response, myHttpClient, myHero);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            try {
//                response.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return reportInfoList;
    }

    //得出ReportInfoList中 DateTime 晚于 LastReportInfo DateTime.plus(+1)的战报数量
    public Integer getNeedCrawlerReportNum(List<ReportInfo> reportInfoList, LastReportInfo lastReportInfo) {
        Integer i = 0;
        for (ReportInfo reportInfo : reportInfoList) {
            if (reportInfo.getDateTime().isAfter(lastReportInfo.getDateTime().plusHours(1)))
                i++;
        }
        return i;
    }

    //构建查询表单from
    public HeroInfo getHeroInfo(MyHero myHero){
        //根据HeroId获取英雄信息

        CloseableHttpResponse response = null;
        try {
            response = myHttpClient.myHeroInfoGet(myHero.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String myHeroInfomation = null;
        try {
            myHeroInfomation = myHttpClient.responseParseString(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HeroInfo heroInfo = JsoupParse.HeroInfoParse(myHeroInfomation);
        return  heroInfo;
    }

    //爬虫物品查询
    public List<Map<String,List<String>>> getItemDropInfoList(HeroInfo heroInfo, List<ReportInfo> reportInfoList, Integer num) {

        CloseableHttpResponse response = null;
        //解析字符串
        String items = null;
        List<Map<String,List<String>>>  itemsListList = new ArrayList<>();

        //获取列表num掉落
        for (int i = 0; i < num; i++) {

            //发送请求
            try {
                response = myHttpClient.reportPost(heroInfo, reportInfoList, i);
                //解析成字符串
                items = myHttpClient.responseParseString(response);

                List<String> itemsList = JsoupParse.itemsListParse(items);

                //输出掉落
                System.out.println(reportInfoList.get(i).getDateTime().format(DateParse.fomatter1) + " "
                        + reportInfoList.get(i).getReportName() + " "
                        + itemsList.toString());

                Map<String,List<String>> itemsListMap = new HashMap<>();
                itemsListMap.put(reportInfoList.get(i).getReportName(),itemsList);

                itemsListList.add(itemsListMap);

                itemsList = null;


            } catch (Exception e) {
                e.printStackTrace();
                i--;
            }finally {

            }



        }
        return itemsListList;
    }



    //根据所爬战报列表 更新最新战报列表
    public Integer updateLastreport(List<ReportInfo> reportInfoList , MyHero myHero){
        LastReportInfo lastReportInfo = new LastReportInfo();
        lastReportInfo.setReportName(reportInfoList.get(0).getReportName());
        lastReportInfo.setReportId(reportInfoList.get(0).getReportId());
        lastReportInfo.setDateTime(reportInfoList.get(0).getDateTime());
        lastReportInfo.setHeroSessionID(myHero.getId());

        Integer changerLineNum = lastReportMapper.updateMylastReport(lastReportInfo);

        System.out.println(lastReportMapper.selectReportByHeroId(myHero.getId()));
        System.out.println("======================================================");
        System.out.println(" ");
        System.out.println("======================================================");

        return changerLineNum;
    }


    /**
     * 获取战报信息的列表
     * @param response
     * @param myHttpClient
     * @param myHero
     * @return
     * @throws Exception
     */
    public List<ReportInfo> reportInfoListCrawler(
            CloseableHttpResponse response, MyHttpClient myHttpClient , MyHero myHero) throws Exception {

        //获取战报列表
        response = myHttpClient.reportGet(myHero.getId());
        String reports = myHttpClient.responseParseString(response);
        List<ReportInfo> reportInfoList = JsoupParse.reportInfoListParse(reports);

        return reportInfoList;
    }
}
