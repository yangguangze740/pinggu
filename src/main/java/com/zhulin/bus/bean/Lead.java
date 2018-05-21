package com.zhulin.bus.bean;

import java.sql.Time;

public class Lead {
    private String leadDepartmentId;
    private String leadName;
    private Time leadCreateTime;
    private String adminId;
    private int deleteFlag;
    private int lockFlag;
    private int leadAdd;

    public int getLeadAdd() {
        return leadAdd;
    }

    public void setLeadAdd(int leadAdd) {
        this.leadAdd = leadAdd;
    }

    public int getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(int lockFlag) {
        this.lockFlag = lockFlag;
    }

    public int getDeleteFlag() {

        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getAdminId() {

        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Time getLeadCreateTime() {

        return leadCreateTime;
    }

    public void setLeadCreateTime(Time leadCreateTime) {
        this.leadCreateTime = leadCreateTime;
    }

    public String getLeadName() {

        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public String getLeadDepartmentId() {
        return leadDepartmentId;
    }

    public void setLeadDepartmentId(String leadDepartmentId) {
        this.leadDepartmentId = leadDepartmentId;
    }
}

