package com.zhulin.bus.bean;

import java.sql.Time;

public class RaterFileModify {
    private String raterFileModifyId;
    private String userId;
    private String raterFileId;
    private Time raterFileModifyTime;
    private String raterArchiveId;
    private int modifyFlag;

    public int getModifyFlag() {
        return modifyFlag;
    }

    public void setModifyFlag(int modifyFlag) {
        this.modifyFlag = modifyFlag;
    }

    public String getRaterArchiveId() {

        return raterArchiveId;
    }

    public void setRaterArchiveId(String raterArchiveId) {
        this.raterArchiveId = raterArchiveId;
    }

    public Time getRaterFileModifyTime() {

        return raterFileModifyTime;
    }

    public void setRaterFileModifyTime(Time raterFileModifyTime) {
        this.raterFileModifyTime = raterFileModifyTime;
    }

    public String getRaterFileId() {

        return raterFileId;
    }

    public void setRaterFileId(String raterFileId) {
        this.raterFileId = raterFileId;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRaterFileModifyId() {

        return raterFileModifyId;
    }

    public void setRaterFileModifyId(String raterFileModifyId) {
        this.raterFileModifyId = raterFileModifyId;
    }
}

