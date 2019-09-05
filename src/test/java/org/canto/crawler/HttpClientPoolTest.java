package org.canto.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author morningyet
 * @create 2019-08-31 17:15
 */
public class HttpClientPoolTest {

    public static void main(String[] args) {
        //连接池管理器


        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(10);
        cm.setDefaultMaxPerRoute(10);//每个主机的最大连接数
        //使用连接池管理器发起请求
        doGet(cm);
        doGet(cm);
    }

    private static void doGet(PoolingHttpClientConnectionManager cm) {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);


            if(response.getStatusLine().getStatusCode() == 200){
                String s = EntityUtils.toString(response.getEntity(), "utf8");
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
             //不需要关闭httpClient 由连接池管理
        }





        System.out.println(response.toString());

    }


}
