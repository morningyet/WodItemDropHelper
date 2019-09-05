package org.canto.crawler;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author morningyet
 * @create 2019-08-31 15:27
 */
public class HttpPostUparamTest {
    public static String uri="http://www.itcast.com";

    public static void main(String[] args) {




        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(uri);

        /**
         * 1.声明LIST集合 封装表单中的参数
         * 2.创建表单的实体对象
         * 3.设置表单的实体对象到post请求中
         */
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("keys","java"));

        UrlEncodedFormEntity formEntity = null;
        try {
            formEntity = new UrlEncodedFormEntity(params,"utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpPost.setEntity(formEntity);


        System.out.println("发起请求的信息: "+httpPost);
        CloseableHttpResponse response = null;
        //发起请求并获得响应
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
