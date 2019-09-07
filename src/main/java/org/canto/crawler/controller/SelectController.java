package org.canto.crawler.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.canto.crawler.commons.MyHero;
import org.canto.crawler.mapper.ItemDropMapper;
import org.canto.crawler.mapper.LastReportMapper;
import org.canto.crawler.pojo.ItemDropInfo;
import org.canto.crawler.pojo.LastReportInfo;
import org.canto.crawler.util.DateParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author morningyet
 * @create 2019-09-05 13:16
 */
@Controller
public class SelectController {
    @Autowired
    ItemDropMapper itemDropMapper;

    @Autowired
    LastReportMapper lastReportMapper;

    /*

        查询数据库对应的物品信息,返回bbcode字符串,可以直接黏贴到论坛.
     */
    @ResponseBody
    @RequestMapping("/select")
    public StringBuilder itemSelect(@Param("heroNum") Integer heroNum,
                                    @Param("dungeonsName") String dungeonsName,
                                    @Param("branch") String branch) {

        MyHero myHero = MyHero.getMyHeroByNum(heroNum);
        System.out.println("选择查询英雄" + myHero.getDesc());

        LastReportInfo lastReportInfo = lastReportMapper.selectReportByHeroId(myHero.getId());
        List<ItemDropInfo> itemDropInfos = itemDropMapper.selectItemDropInfoByDungeonsName(dungeonsName);

        StringBuilder str = new StringBuilder()
                .append("北京第三区交通委提醒您：").append("<br/>")
                .append("道路千万条，安全第一条。").append("<br/>")
                .append("行车不规范，亲人两行泪。").append("<br/>")
                .append("<br/>");

        str.append("来自十二光年外的Ezantoh智能小助手为您准确播报:").append("<br/>")
                .append("英雄名: ").append("[hero:").append(myHero.getDesc()).append("]").append("<br/>")
                .append("最新一次统计的时间: ").append("[b]")
                .append(lastReportInfo.getDateTime().format(DateParse.fomatter1)).append("[/b]").append("<br/>")
                .append("<br/>");

        str.append("[size=17]").append("[b]").append("[*]")
                .append(dungeonsName)
                .append("[/b]").append("[/size]")
                .append("<br/>");


        for (ItemDropInfo itemDropInfo : itemDropInfos) {
            Integer count = Integer.valueOf(itemCount(itemDropInfo,heroNum));
            for (int i = 0; i < count; i++) {
                str.append(":y:");
            }
            str.append("[item:").append(itemDropInfo.getItemsName()).append("]")
                    .append("    Lv").append(itemDropInfo.getFloor())
                    .append("<br/>");
        }


        return str;
    }


    public String itemCount(ItemDropInfo itemDropInfo ,Integer heroNum){
        MyHero myHero = MyHero.getMyHeroByNum(heroNum);

        switch (myHero){
            case Myhero01 : return itemDropInfo.getRole1()==null?"0":itemDropInfo.getRole1();
            case Myhero02 : return itemDropInfo.getRole2()==null?"0":itemDropInfo.getRole2();
            case Myhero03 : return itemDropInfo.getRole3()==null?"0":itemDropInfo.getRole3();
            case Myhero04 : return itemDropInfo.getRole4()==null?"0":itemDropInfo.getRole4();
//            case Myhero05 : return itemDropInfo.getRole5()==null?"0":itemDropInfo.getRole5();
//            case Myhero06 : return itemDropInfo.getRole5()==null?"0":itemDropInfo.getRole6();
            default:return "0";
        }

    }

}
