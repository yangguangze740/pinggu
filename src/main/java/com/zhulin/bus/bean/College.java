package com.zhulin.bus.bean;

import java.sql.Timestamp;

public class College {
    private String collegeId;
    private String collegeName;
    private String createUserId;
    private Timestamp createTime;
    private int deleteFlag;
    private int lockFlag;

    public int getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(int lockFlag) {
        this.lockFlag = lockFlag;
    }

    public String getCollegeName() {

        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCollegeId() {

        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }
}
