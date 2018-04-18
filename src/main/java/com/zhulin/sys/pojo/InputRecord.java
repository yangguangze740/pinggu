package com.zhulin.sys.pojo;

import java.sql.Date;

public class InputRecord {
    private String inputRecordId;
    private String userId;
    private String userRealName;
    private String officeSupplyTypeId;
    private String officeSupplyTypeName;
    private String officeSupplyId;
    private String officeSupplyName;
    private String inputRecordRemark;
    private int officeSupplyNumber;
    private float inputAccountOfMoney;
    private float officeSupplyUnivalent;
    private Date inputDay;

    public String getInputRecordId() {
        return inputRecordId;
    }

    public void setInputRecordId(String inputRecordId) {
        this.inputRecordId = inputRecordId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getOfficeSupplyTypeId() {
        return officeSupplyTypeId;
    }

    public void setOfficeSupplyTypeId(String officeSupplyTypeId) {
        this.officeSupplyTypeId = officeSupplyTypeId;
    }

    public String getOfficeSupplyTypeName() {
        return officeSupplyTypeName;
    }

    public void setOfficeSupplyTypeName(String officeSupplyTypeName) {
        this.officeSupplyTypeName = officeSupplyTypeName;
    }

    public String getOfficeSupplyId() {
        return officeSupplyId;
    }

    public void setOfficeSupplyId(String officeSupplyId) {
        this.officeSupplyId = officeSupplyId;
    }

    public String getOfficeSupplyName() {
        return officeSupplyName;
    }

    public void setOfficeSupplyName(String officeSupplyName) {
        this.officeSupplyName = officeSupplyName;
    }

    public String getInputRecordRemark() {
        return inputRecordRemark;
    }

    public void setInputRecordRemark(String inputRecordRemark) {
        this.inputRecordRemark = inputRecordRemark;
    }

    public int getOfficeSupplyNumber() {
        return officeSupplyNumber;
    }

    public void setOfficeSupplyNumber(int officeSupplyNumber) {
        this.officeSupplyNumber = officeSupplyNumber;
    }

    public float getInputAccountOfMoney() {
        return inputAccountOfMoney;
    }

    public void setInputAccountOfMoney(float inputAccountOfMoney) {
        this.inputAccountOfMoney = inputAccountOfMoney;
    }

    public float getOfficeSupplyUnivalent() {
        return officeSupplyUnivalent;
    }

    public void setOfficeSupplyUnivalent(float officeSupplyUnivalent) {
        this.officeSupplyUnivalent = officeSupplyUnivalent;
    }

    public Date getInputDay() {
        return inputDay;
    }

    public void setInputDay(Date inputDay) {
        this.inputDay = inputDay;
    }
}
