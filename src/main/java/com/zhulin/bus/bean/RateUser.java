package com.zhulin.bus.bean;


public class RateUser {
    private String raterUserId;
    private String raterUserName;
    private String raterUserPassword;
    private String raterUserAccount;
    private String lockFlag;
    private String deleteFlag;

    public String getRaterUserId() {
        return raterUserId;
    }

    public void setRaterUserId(String raterUserId) {
        this.raterUserId = raterUserId;
    }

    public String getRaterUserName() {
        return raterUserName;
    }

    public void setRaterUserName(String raterUserName) {
        this.raterUserName = raterUserName;
    }

    public String getRaterUserPassword() {
        return raterUserPassword;
    }

    public void setRaterUserPassword(String raterUserPassword) {
        this.raterUserPassword = raterUserPassword;
    }

    public String getRaterUserAccount() {
        return raterUserAccount;
    }

    public void setRaterUserAccount(String raterUserAccount) {
        this.raterUserAccount = raterUserAccount;
    }

    public String getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(String lockFlag) {
        this.lockFlag = lockFlag;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}
