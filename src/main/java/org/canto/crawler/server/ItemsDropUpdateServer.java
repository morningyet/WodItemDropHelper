package org.canto.crawler.server;

import org.apache.commons.io.FileUtils;
import org.canto.crawler.commons.MyHero;
import org.canto.crawler.mapper.ItemDropMapper;
import org.canto.crawler.pojo.ItemDropInfo;
import org.canto.crawler.util.ItemStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 更新物品记录的步骤
 * <p>
 * 1.根据物品名,地城名,查出数据库中单条记录
 * 2.对每个在对应角色下的数量+1
 * 3.更新数据库信息
 * 4.更新数据库LastReport
 *
 * @author morningyet
 * @create 2019-09-04 8:14
 */
@Service
public class ItemsDropUpdateServer {

    @Autowired
    ItemDropMapper itemDropMapper;


    /**
     * 处理第x页物品请求  导入掉落帖子列表时用到
     *
     * @param pageNum
     */
    public void creatItemsDropList(Integer pageNum) {
        List<ItemDropInfo> itemDropInfoList = new ArrayList<>();

        List<String> readLines = null;

        try {
            readLines = FileUtils.readLines(new File("G:\\iWod\\dropList\\post\\" + pageNum + ".txt"), "utf8");
            System.out.println("处理第" + pageNum + "页物品请求......");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String dungeonsName = null;
        String floor = null;
        String branch = null;
        String itemsName = null;


        for (String s : readLines) {

            if (ItemStringUtils.isBlankLine(s)) continue;
            if (ItemStringUtils.isDungeonsName(s)) {
                dungeonsName = ItemStringUtils.getDungeonsName(s);
                branch = null;
                floor = null;
            }

            if (ItemStringUtils.isBranch(s)) {
                branch = ItemStringUtils.getBranch(s);
                if ("普通".equals(branch)) branch = null;
            }

            if (ItemStringUtils.isFloor(s)) floor = ItemStringUtils.getFloor(s);

            if (ItemStringUtils.isitemsName(s)) {
                itemsName = ItemStringUtils.getItemName(s);
                ItemDropInfo itemDropInfo = new ItemDropInfo(itemsName, dungeonsName, branch, floor);
                itemDropInfoList.add(itemDropInfo);
            }
        }

        for (ItemDropInfo itemDropInfo : itemDropInfoList) {
            //System.out.println(itemDropInfo.toMyString());
            int i = itemDropMapper.insertItemDropInfo(itemDropInfo);
            if (i != 1) System.out.println("出了什么问题?");
        }


    }


    /**
     * 根据战报更新物品掉落的信息
     * @param itemDropMapList
     * @param myHero
     * @return
     */
    public Integer updateItemDropCount(List<Map<String, List<String>>> itemDropMapList, MyHero myHero) {

        Integer line = 0;

        for (Map<String, List<String>> itemDropMap : itemDropMapList) {

            String dungeonsName = null;
            List<String> dropList = new ArrayList<>();


            if (itemDropMap.isEmpty() && itemDropMap.size() != 1) continue;
            else {
                //迭代出key:dungeonsName
                for (String s : itemDropMap.keySet()) {
                    dungeonsName = s;
                }
                //迭代出List<String>
                for (List<String> list : itemDropMap.values()) {
                    dropList = list;
                }
            }

            if (dropList == null && dropList.isEmpty() && dungeonsName == null) continue;
            else {
                for (String itemsName : dropList) {

                    System.out.println(itemsName);

                    ItemDropInfo itemDropInfo = itemDropMapper.selectItemDropInfoByName(itemsName, dungeonsName);

                    if (itemDropInfo == null) continue;

                    System.out.println(itemDropInfo.toString());

                    itemDropInfo.addHerorecord(myHero);

                    System.out.println(itemDropInfo.toString());

                    line += itemDropMapper.updateItemDropInfo(itemDropInfo);
                }
            }
        }
        return line;
    }


}
