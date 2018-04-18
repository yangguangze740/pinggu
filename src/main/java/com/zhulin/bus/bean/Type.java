package com.zhulin.bus.bean;

import java.sql.Time;

public class Type {
    private String typeId;
    private String typeName;
    private Time typeCreateTime;
    private String adminId;
    private int typeFileNumber;
    private int deleteFlag;
    private int lockFlag;

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

    public int getTypeFileNumber() {

        return typeFileNumber;
    }

    public void setTypeFileNumber(int typeFileNumber) {
        this.typeFileNumber = typeFileNumber;
    }

    public String getAdminId() {

        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Time getTypeCreateTime() {

        return typeCreateTime;
    }

    public void setTypeCreateTime(Time typeCreateTime) {
        this.typeCreateTime = typeCreateTime;
    }

    public String getTypeName() {

        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeId() {

        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
