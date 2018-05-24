package com.zhulin.bus.bean;

import java.sql.Date;

public class BusConfig {
    private String configId;
    private Date configReviewStartDay;
    private Date configReviewEndDay;
    private int configFrontReadLevel;

    public int getConfigFrontReadLevel() {
        return configFrontReadLevel;
    }

    public void setConfigFrontReadLevel(int configFrontReadLevel) {
        this.configFrontReadLevel = configFrontReadLevel;
    }

    public Date getConfigReviewEndDay() {

        return configReviewEndDay;
    }

    public void setConfigReviewEndDay(Date configReviewEndDay) {
        this.configReviewEndDay = configReviewEndDay;
    }

    public Date getConfigReviewStartDay() {

        return configReviewStartDay;
    }

    public void setConfigReviewStartDay(Date configReviewStartDay) {
        this.configReviewStartDay = configReviewStartDay;
    }

    public String getConfigId() {

        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }
}
