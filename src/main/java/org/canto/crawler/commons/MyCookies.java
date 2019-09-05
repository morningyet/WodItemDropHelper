package org.canto.crawler.commons;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;

/**
 * @author morningyet
 * @create 2019-09-01 6:58
 */
public class MyCookies {

    public static CookieStore cookieStore = new BasicCookieStore();

    public static void outPrint(){
        System.out.println(cookieStore.toString());
//        List<Cookie> cookies = cookieStore.getCookies();
//        cookies.stream().forEach(k -> {
//            System.out.println(k.getName() + ":" + k.getValue());});
    }
}
