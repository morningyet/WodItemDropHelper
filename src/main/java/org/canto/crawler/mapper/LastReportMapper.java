package org.canto.crawler.mapper;

import org.apache.ibatis.annotations.*;
import org.canto.crawler.commons.MyHero;
import org.canto.crawler.pojo.LastReportInfo;
import org.jsoup.select.Evaluator;
import org.springframework.stereotype.Repository;

/*
 CREATE TABLE `wod`.`Last_report`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `hero_id` varchar(20) NOT NULL,
  `report_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `report_id` varchar(20) NOT NULL,
  `date_time` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
);
 */
/*
    private Integer id;
    private Integer heroId ;
    private String reportName ;
    private String reportId;
    private LocalDateTime dateTime;
 */
/**
 * @author morningyet
 * @create 2019-09-04 14:59
 */
@Repository
@Mapper
public interface LastReportMapper {

    @Select("select * from Last_report where id = #{id}")
    public LastReportInfo selectReportById(Integer id);

    @Select("select * from Last_report where hero_id = #{myHeroid}")
    public LastReportInfo selectReportByHeroId(String myHeroid);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into Last_report(hero_id,report_name,report_id,date_time) " +
            "values(#{heroId},#{reportName},#{reportId},#{dateTime})")
    public int insertMyLastReport(LastReportInfo lastReportInfo);

    @Update("update Last_report set report_name = #{reportName} , " +
            "report_id = #{reportId}, date_time = #{dateTime} " +
            "where hero_id = #{heroId}")
    public int updateMylastReport(LastReportInfo lastReportInfo);
}
