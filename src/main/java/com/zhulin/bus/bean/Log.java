package com.zhulin.bus.bean;

import java.sql.Timestamp;

public class Log {
    private String logId;
    private int logAction;
    private int logLevel;
    private String logContent;
    private String logUser;
    private Timestamp logTime;
    private String logIp;
    private String logUserId;

    public String getLogUserId() {
        return logUserId;
    }

    public void setLogUserId(String logUserId) {
        this.logUserId = logUserId;
    }

    public String getLogIp() {

        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public Timestamp getLogTime() {

        return logTime;
    }

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }

    public String getLogUser() {

        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public String getLogContent() {

        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent;
    }

    public int getLogLevel() {

        return logLevel;
    }

    public void setLogLevel(int logLevel) {
        this.logLevel = logLevel;
    }

    public int getLogAction() {

        return logAction;
    }

    public void setLogAction(int logAction) {
        this.logAction = logAction;
    }

    public String getLogId() {

        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }
}
