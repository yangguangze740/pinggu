package com.zhulin.bus.bean;

import java.sql.Timestamp;

public class PaperFileModify {
    private String paperFileModifyId;
    private String userId;
    private String paperFileId;
    private Timestamp paperFileModifyTime;
    private String paperArchiveId;
    private int modifyFlag;

    public String getPaperFileModifyId() {
        return paperFileModifyId;
    }

    public void setPaperFileModifyId(String paperFileModifyId) {
        this.paperFileModifyId = paperFileModifyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPaperFileId() {
        return paperFileId;
    }

    public void setPaperFileId(String paperFileId) {
        this.paperFileId = paperFileId;
    }

    public Timestamp getPaperFileModifyTime() {
        return paperFileModifyTime;
    }

    public void setPaperFileModifyTime(Timestamp paperFileModifyTime) {
        this.paperFileModifyTime = paperFileModifyTime;
    }

    public String getPaperArchiveId() {
        return paperArchiveId;
    }

    public void setPaperArchiveId(String paperArchiveId) {
        this.paperArchiveId = paperArchiveId;
    }

    public int getModifyFlag() {
        return modifyFlag;
    }

    public void setModifyFlag(int modifyFlag) {
        this.modifyFlag = modifyFlag;
    }
}
