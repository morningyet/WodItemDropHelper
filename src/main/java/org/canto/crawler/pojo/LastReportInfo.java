package org.canto.crawler.pojo;

import java.time.LocalDateTime;

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





/**
 * @author morningyet
 * @create 2019-09-04 12:26
 */
public class LastReportInfo {
    private Integer id;
    private String heroId ;
    private String reportName ;
    private String reportId;
    private LocalDateTime dateTime;

    public LastReportInfo() {
    }

    public LastReportInfo(Integer id, String heroId, String reportName, String reportId, LocalDateTime dateTime) {
        this.id = id;
        this.heroId = heroId;
        this.reportName = reportName;
        this.reportId = reportId;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeroSessionID() {
        return heroId;
    }

    public void setHeroSessionID(String heroId) {
        this.heroId = heroId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "LastReportInfo{" +
                "id=" + id +
                ", heroSessionID=" + heroId +
                ", reportName='" + reportName + '\'' +
                ", reportId='" + reportId + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
