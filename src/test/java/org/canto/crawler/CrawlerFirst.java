package org.canto.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author morningyet
 * @create 2019-08-31 11:20
 */
public class CrawlerFirst {

    public static void main(String[] args) throws Exception {
        //1.打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.输入网址
        String uri="http://www.itcast.com";
        HttpGet httpGet = new HttpGet(uri);
        //3.回车 浏览器发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
        //4.浏览器解析响应获取数据
        //5.判断状态码
        if(response.getStatusLine().getStatusCode() == 200 ){
            HttpEntity httpEntity = response.getEntity();
            String html = EntityUtils.toString(httpEntity, "utf8");
            System.out.println(html.length());
        }

        //SSL 连接部分的内容https://blog.csdn.net/w372426096/article/details/82713315
    }
}
