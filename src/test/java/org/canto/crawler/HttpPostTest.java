package org.canto.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @author morningyet
 * @create 2019-08-31 15:27
 */
public class HttpPostTest {
    public static String uri="http://www.itcast.com";

    public static void main(String[] args) {


        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);
        System.out.println("发起请求的信息: "+httpPost);
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpPost);
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
