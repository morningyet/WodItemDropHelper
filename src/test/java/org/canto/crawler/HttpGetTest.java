package org.canto.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author morningyet
 * @create 2019-08-31 15:27
 */
public class HttpGetTest {
    public static String uri="http://www.itcast.com";

    public static void main(String[] args) {


        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }


        responseStatuCodeIs200(response);


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

    static void responseStatuCodeIs200(CloseableHttpResponse response) {
        if(response.getStatusLine().getStatusCode() == 200 ){
            HttpEntity httpEntity = response.getEntity();

            String html = null;

            try {
                html = EntityUtils.toString(httpEntity, "utf8");
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(html);
        }
    }
}
