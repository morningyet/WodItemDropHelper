package org.canto.crawler.commons;

import org.apache.http.client.HttpClient;
import org.canto.crawler.pojo.HeroInfo;
import org.canto.crawler.pojo.ReportInfo;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.canto.crawler.pojo.HeroInfo;
import org.canto.crawler.pojo.ReportInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author morningyet
 * @create 2019-09-01 7:07
 */
@Component
public class MyHttpClient {

    @Autowired
    HttpClient httpClient;

    /**
     * 将HttpClient解析得到的response转换成字符串String
     *
     * @param response
     * @return
     * @throws IOException
     */
    public String responseParseString(CloseableHttpResponse response) throws IOException {
        String html = null;

        if (response.getStatusLine().getStatusCode() == 200) {

            HttpEntity httpEntity = response.getEntity();

            html = EntityUtils.toString(httpEntity, "utf8");

            response.close();
            return html;
        }

        response.close();
        return "";
    }



    /**
     * GET请求,获得Response,记录当前所有战报的时间,id,名称
     *
     * @param myHeroID
     * @return
     * @throws Exception
     */
    public CloseableHttpResponse reportGet(String myHeroID) throws Exception {

        CloseableHttpResponse reportListResponse = null;

        URIBuilder uriBuilder = null;
        uriBuilder = new URIBuilder(MyUri.reportsUri);
        uriBuilder.setParameter("session_hero_id", myHeroID);

        HttpGet httpGet = new HttpGet(uriBuilder.build());

        System.out.println("发送读取战报列表请求: " + httpGet.toString());

        reportListResponse = (CloseableHttpResponse) httpClient.execute(httpGet);

        return reportListResponse;
    }


    /**
     * Post请求,获取战报列表第num条目的战报的宝库掉落
     *
     * @param myHeroInfo
     * @param reportInfoList
     * @param num            第num条目
     * @return
     * @throws Exception
     */
    public CloseableHttpResponse reportPost(HeroInfo myHeroInfo, List<ReportInfo> reportInfoList, Integer num) throws Exception {

        CloseableHttpResponse loginResponse = null;

        HttpPost httpPost = new HttpPost(MyUri.itemsUri + myHeroInfo.getSession_hero_id());

        httpPost.setEntity(MyParamsForm.getReportFormEntity(myHeroInfo, reportInfoList, num));

        System.out.println("发送读取物品掉落请求: " + httpPost.toString());

        loginResponse = (CloseableHttpResponse) httpClient.execute(httpPost);

        return loginResponse;
    }

    /**
     * 通过session_hero_id 获取hero的其他详细属性值,用来写入post请求表单域中 返回值是response
     *
     * @param myHeroID
     * @return
     * @throws Exception
     */
    public CloseableHttpResponse myHeroInfoGet(String myHeroID) throws Exception {

        CloseableHttpResponse myHeroInfoResponse = null;

        HttpGet httpGet = new HttpGet(MyUri.myHeroInfoUri + myHeroID);

        System.out.println("发送读取Hero信息请求: " + httpGet.toString());

        myHeroInfoResponse = (CloseableHttpResponse) httpClient.execute(httpGet);


        return myHeroInfoResponse;
    }


}
