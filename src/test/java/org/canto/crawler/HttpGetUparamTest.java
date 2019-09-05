package org.canto.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author morningyet
 * @create 2019-08-31 15:47
 */
public class HttpGetUparamTest {
    public static String uri="http://yun.itheima.com/search";

    public static void main(String[] args) {


        CloseableHttpClient httpClient = HttpClients.createDefault();

        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        uriBuilder.setParameter("keys","java");

        HttpGet httpGet = null;

        try {
            httpGet = new HttpGet(uriBuilder.build());

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        System.out.println("发起请求的信息: "+httpGet);

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
