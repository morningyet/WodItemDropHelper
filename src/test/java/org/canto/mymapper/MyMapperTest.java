package org.canto.mymapper;

import org.canto.crawler.mapper.LastReportMapper;
import org.canto.crawler.pojo.LastReportInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

/**
 * @author morningyet
 * @create 2019-09-04 15:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class MyMapperTest {

    @Autowired
    LastReportMapper LastReportMapper;

    @Test
    public void reportMapperTest(){

        LastReportInfo lastReportInfo = new LastReportInfo();
        lastReportInfo.setDateTime(LocalDateTime.now());
        lastReportInfo.setHeroSessionID("123456");
        lastReportInfo.setReportId("456789");
        lastReportInfo.setReportName("无敌是多么寂寞");


        int i = LastReportMapper.insertMyLastReport(lastReportInfo);

        System.out.println(i);
    }
}
