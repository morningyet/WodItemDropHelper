package org.canto.crawler.wod;

import org.canto.crawler.commons.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author morningyet
 * @create 2019-08-31 22:19
 * <p>
 * *  模拟过程
 * *  1.httpClient 发送 post 请求登录  表单:Username  passwort  服务器名
 * *  2.保存cookie  参考https://blog.csdn.net/blueboz/article/details/82558871
 * *  3.发送GET请求  导入战报目录页,获取战报对应report_id 和 对应时间  发送GET附加cookie
 * *  4.发送Post请求 获得 所有的item  发送Post附加cookie
 * *
 */
@Component
public class WodCrawler {

    @Autowired
    MyHttpClient myHttpClient;
    /**
     * 模拟爬虫过程
     *
     * @param myHero
     * @throws Exception
     */
    public void startMyCrawler(MyHero myHero) throws Exception {





        //模拟登陆,获取Cookies
//        response = MyHttpClient.loginPost();
        //一个无用的转换
        //String login = myHttpClient.responseParseString(response);

//        MyCrawler.doCrawler(response, myHttpClient, myHero);
//        MyCrawler.doCrawler(response, myHttpClient, MySessionHeroId.MyheroID_03);
//        MyCrawler.doCrawler(response, myHttpClient, MySessionHeroId.MyheroID_02);
//        MyCrawler.doCrawler(response, myHttpClient, MySessionHeroId.MyheroID_01);


    }
}
