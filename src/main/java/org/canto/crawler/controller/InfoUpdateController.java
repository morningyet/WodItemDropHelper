package org.canto.crawler.controller;

import org.canto.crawler.server.ItemsDropUpdateServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author morningyet
 * @create 2019-09-04 8:13
 */
@Controller
public class InfoUpdateController {
    @Autowired
    ItemsDropUpdateServer itemsDropUpdateServer;


    /**
     * 用于生成mySQL数据库列表文件
     * @return
     */
    @ResponseBody
    @RequestMapping("/itemsDropUpdate/all")
    public String itemsDropUpdate(){

        //这部分应该放到server中去
        for (int i = 1; i < 16; i++) {
            itemsDropUpdateServer.creatItemsDropList(i);
        }

        return "done";

    }

}
