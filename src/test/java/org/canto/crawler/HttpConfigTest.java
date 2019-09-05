package org.canto.crawler;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @author morningyet
 * @create 2019-08-31 17:49
 */
public class HttpConfigTest {
    public static String uri="http://www.itcast.com";

    public static void main(String[] args) {


        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(10*000)              //创建连接的最长时间
                .setConnectionRequestTimeout(1000*20)   //获取连接的最长时间
                .setConnectTimeout(1000*60*5)           //设置数据传输的最长时间
                .build();

        httpGet.setConfig(config);



        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }


        HttpGetTest.responseStatuCodeIs200(response);

        try {
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
