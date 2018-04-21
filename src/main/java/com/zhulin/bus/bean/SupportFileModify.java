package com.zhulin.bus.bean;

import java.sql.Timestamp;

public class SupportFileModify {
    private String supportChangeId;
    private String userId;
    private String supportFileId;
    private String supportArchiveId;
    private Timestamp supportChangeTime;
    private int modifyFlag;

    public int getModifyFlag() {
        return modifyFlag;
    }

    public void setModifyFlag(int modifyFlag) {
        this.modifyFlag = modifyFlag;
    }

    public Timestamp getSupportChangeTime() {

        return supportChangeTime;
    }

    public void setSupportChangeTime(Timestamp supportChangeTime) {
        this.supportChangeTime = supportChangeTime;
    }

    public String getSupportArchiveId() {

        return supportArchiveId;
    }

    public void setSupportArchiveId(String supportArchiveId) {
        this.supportArchiveId = supportArchiveId;
    }

    public String getSupportFileId() {

        return supportFileId;
    }

    public void setSupportFileId(String supportFileId) {
        this.supportFileId = supportFileId;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSupportChangeId() {

        return supportChangeId;
    }

    public void setSupportChangeId(String supportChangeId) {
        this.supportChangeId = supportChangeId;
    }
}
