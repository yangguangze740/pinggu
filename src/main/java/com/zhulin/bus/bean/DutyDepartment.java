package com.zhulin.bus.bean;


import java.sql.Timestamp;

public class DutyDepartment {
    private String dutyDepartmentId;
    private String dutyName;
    private Timestamp dutyCreateTime;
    private String adminId;
    private String deleteFlag;
    private String lockFlag;
    private String pointId;
    private int dutyAdd;

    public int getDutyAdd() {
        return dutyAdd;
    }

    public void setDutyAdd(int dutyAdd) {
        this.dutyAdd = dutyAdd;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getDutyDepartmentId() {
        return dutyDepartmentId;
    }

    public void setDutyDepartmentId(String dutyDepartmentId) {
        this.dutyDepartmentId = dutyDepartmentId;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public Timestamp getDutyCreateTime() {
        return dutyCreateTime;
    }

    public void setDutyCreateTime(Timestamp dutyCreateTime) {
        this.dutyCreateTime = dutyCreateTime;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
    }


}
