package org.canto.crawler.controller;

import org.canto.crawler.mapper.ItemDropMapper;
import org.canto.crawler.pojo.ItemDropInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 该类为
 * 测试用
 * @author morningyet
 * @create 2019-09-03 19:52
 */
@Controller
public class HelloController {

    @Autowired
    ItemDropMapper itemDropMapper;

    @RequestMapping("/")
    public String login(){
        return "index";
    }


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        String s = "hello world </br>"
                +"你好";
        return s;
    }


    @ResponseBody
    @RequestMapping("/item/{id}")
    public String getItemDropInfo(@PathVariable("id") Integer id){



        ItemDropInfo itemDropInfo = itemDropMapper.selectItemDropInfoById(id);
        return itemDropInfo.toString();
    }

    @ResponseBody
    @RequestMapping("/item")
    public String insertItemDropInfo(){

        ItemDropInfo itemDropInfo = new ItemDropInfo();


            itemDropInfo.setDungeonsName("不曾想象的地城");
            itemDropInfo.setFloor("6");
            itemDropInfo.setItemsName("无敌是多么..多么寂寞");

        System.out.println(itemDropInfo);
        Integer i = itemDropMapper.insertItemDropInfo(itemDropInfo);
        return i.toString();
    }




}
