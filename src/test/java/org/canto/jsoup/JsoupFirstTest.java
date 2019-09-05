package org.canto.jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
 * @author morningyet
 * @create 2019-08-31 20:03
 */
public class JsoupFirstTest {

    @Test
    public void testUrl() throws Exception{
        //jsoup 对多线程 连接池 代理等支持不是很好
        Document document = Jsoup.parse(new URL("http://canto.world-of-dungeons.org"), 1000*10);
        ///解析很nb
        String text = document.getElementsByTag("title").first().text();
        System.out.println(text);
    }
    @Test
    public void testString() throws Exception{
        String s =FileUtils.readFileToString(new File("E:\\test.html"),"GBK");
        Document doc = Jsoup.parse(s);
        String text = doc.getElementsByTag("title").first().text();
        System.out.println(text);

    }
    @Test
    public void testFile() throws Exception{
        Document doc =Jsoup.parse(new File("E:\\test.html"),"GBK");
        String text = doc.getElementsByTag("title").first().text();
        System.out.println(text);
    }

    @Test
    public void testDom() throws Exception{
        Document doc =Jsoup.parse(new File("E:\\test.html"),"GBK");
        //获取元素的方式有
        //getElementsByTag,Id,Class,Attribute

        //elements.text()  获取元素的内容
        //Collections.emptyList()
//        Elements elements = doc.getElementsByTag("span");
//        Element first = elements.first();
//        System.out.println(first.text());
//        Elements next = elements.next();
//        System.out.println(next.text());

//        Elements elements = doc.getElementsByAttribute("alt");
        Elements elements = doc.getElementsByAttributeValue("href","/wod/spiel/news/");

        for(Element element : elements){
            System.out.println(element.text());
        }

    }

    @Test
    public void testData() throws Exception{

        /*
        获取元素的id className, 属性的值attr, 所有的属性attributes 文本text
         */
        Document doc =Jsoup.parse(new File("E:\\test.html"),"GBK");
        Elements elements = doc.getElementsByTag("span");

        String str ="";

        for(Element element : elements){
            //System.out.println("获取到的id数据是: "+  element.id());
            System.out.println("获取到的className数据是: "+  element.className());//className获取的应该是集合的值,即可能有多个className
        }
    }

    /*
    el#id  元素+id  h3#city_bj
    el.class  元素+className  li.class_a
    el[attr]  元素+属性名 span[abc]
    任意组合    span[abc].s_name
    ancestor child   .city_con li 查找"city_con"下的所有li
    parent > child   .city_con > ul > li 查找父元素下的直接子元素
    parent > *      查找父元素下的所有直接子元素



     */
    @Test
    public void testSelector() throws Exception{
        Document doc =Jsoup.parse(new File("E:\\test.html"),"GBK");
        Elements elements = doc.select("#infobox_table_left > *");
        for(Element element : elements) {
            System.out.println("获取到的数据是: " + element.text());
        }
    }

}
