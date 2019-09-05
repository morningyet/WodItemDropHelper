package org.canto.crawler.wod;

import org.canto.crawler.commons.MyHero;
import org.canto.crawler.commons.MyHttpClient;
import org.canto.crawler.jsoup.JsoupParse;
import org.canto.crawler.pojo.HeroInfo;
import org.canto.crawler.pojo.ReportInfo;
import org.canto.crawler.server.ReportUpdateServer;
import org.canto.crawler.util.DateParse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author morningyet
 * @create 2019-09-02 9:6
 */
public class MyCrawler {

    @Autowired
    ReportUpdateServer reportUpdateServer;

    public void doCrawler(CloseableHttpResponse response, MyHttpClient myHttpClient , MyHero myHero) throws Exception{

        //根据HeroId获取英雄信息
        response = myHttpClient.myHeroInfoGet(myHero.getId());
        String myHeroInfomation = myHttpClient.responseParseString(response);
        HeroInfo myHeroInfo = JsoupParse.HeroInfoParse(myHeroInfomation);

        //获取战报列表

        List<ReportInfo> reportInfoList = reportUpdateServer.reportInfoListCrawler(response,myHttpClient,myHero);

        //输出战报列表
        //System.out.println(reportInfoList.toString());

        for (int i = 0, n = reportInfoList.size(); i < n - 1; i++) {

            //获取列表num掉落
            response = myHttpClient.reportPost(myHeroInfo, reportInfoList, i);
            String items = myHttpClient.responseParseString(response);
            List<String> itemsList = JsoupParse.itemsListParse(items);

            //输出掉落
            System.out.println(reportInfoList.get(i).getDateTime().format(DateParse.fomatter1)+" "
                    + reportInfoList.get(i).getReportName()+" "
                    + itemsList.toString());
        }
    }
}
