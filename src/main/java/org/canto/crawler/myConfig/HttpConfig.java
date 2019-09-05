package org.canto.crawler.myConfig;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.canto.crawler.commons.MyCookies;
import org.canto.crawler.commons.MyParamsForm;
import org.canto.crawler.commons.MyUri;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author morningyet
 * @create 2019-09-04 18:30
 */

@Configuration
public class HttpConfig {


    @Bean
    public CloseableHttpClient getHttpClient(){

        CloseableHttpClient httpClient = HttpClients.custom().setDefaultCookieStore(MyCookies.cookieStore).build();

//        //模拟登陆,获取Cookies
//        httpClient.loginPost();

        CloseableHttpResponse loginResponse = null;

        HttpPost httpPost = new HttpPost(MyUri.loginUri);

        httpPost.setEntity(MyParamsForm.getLoginInFormEntity());

        System.out.println("发送模拟人物登录请求: " + httpPost.toString());

        try {
            httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return httpClient;
    }



}
