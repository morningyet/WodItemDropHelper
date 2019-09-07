package org.canto.crawler.controller;

import org.apache.http.client.HttpClient;
import org.canto.crawler.commons.MyHero;
import org.canto.crawler.pojo.HeroInfo;
import org.canto.crawler.pojo.LastReportInfo;
import org.canto.crawler.pojo.ReportInfo;
import org.canto.crawler.server.CrawlerServer;
import org.canto.crawler.server.ItemsDropUpdateServer;
import org.canto.crawler.server.ReportUpdateServer;
import org.canto.crawler.wod.WodCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 *
 *     Myhero01("158850","“甜党领袖”咸鱼爱夏"),
 *     Myhero02("163052","爱夏 ver6.0"),
 *     Myhero03("148463","爱故乡的夏ver 2.0"),
 *     Myhero04("143040","爱故乡的歌"),
 *
 *
 * @author morningyet
 * @create 2019-09-04 14:12
 */
@Controller
public class CrawlerController {

    @Autowired
    ReportUpdateServer reportUpdateServer;
    
    @Autowired
    ItemsDropUpdateServer itemsDropUpdateServer;

    @Autowired
    HttpClient httpClient;

    @Autowired
    CrawlerServer crawlerServer;

    /**
     * 主要功能:完成物品掉落查询
     * @return
     */
    @ResponseBody
    @RequestMapping("/start")
    public String start(){

        for (int i = 1; i < 5; i++) {
            crawlerServer.startCrawler(i);
        }

        return "执行完毕";

    }
}
