package org.canto.crawler.pojo;

import org.canto.crawler.util.DateParse;

import java.time.LocalDateTime;

/**
 * @author morningyet
 * @create 2019-09-01 14:59
 */
public class ReportInfo {
/*
<input type="hidden" name="report_id[0]" value="4199934">
reportname="<span>帕沙雷的召唤</span>" reporttime="<span>今天 13:27</span>"
 */
    private Integer Id ;
    private String reportNo; //战报当日排序  不应该持久化!
    private String reportName ;
    private LocalDateTime dateTime;
    private String reportId;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public ReportInfo() {
    }



    public ReportInfo(String reportNo, String reportName, String dateTime, String reportId) {
        Id = null;
        this.reportNo = reportNo;
        this.reportName = reportName;
        this.dateTime = DateParse.stringToDate(dateTime);
        this.reportId = reportId;
    }

    @Override
    public String toString() {
        return "ReportInfo{" +
                "reportNo='" + reportNo + '\'' +
                ", reportName='" + reportName + '\'' +
                ", dateTime=" + dateTime +
                ", reportId='" + reportId + '\'' +
                '}';
    }
}
