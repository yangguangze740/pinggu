package com.zhulin.bus.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Config {
    private String configId;
    private Date configStartTime;
    private Date configEndTime;
    private int configLevel;

    public int getConfigLevel() {
        return configLevel;
    }

    public void setConfigLevel(int configLevel) {
        this.configLevel = configLevel;
    }

    public Date getConfigEndTime() {

        return configEndTime;
    }

    public void setConfigEndTime(Date configEndTime) {
        this.configEndTime = configEndTime;
    }

    public Date getConfigStartTime() {

        return configStartTime;
    }

    public void setConfigStartTime(Date configStartTime) {
        this.configStartTime = configStartTime;
    }

    public String getConfigId() {

        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }
}
