package com.zhulin.bus.bean;

import java.sql.Time;

public class Problem {
    private String problemId;
    private String problemContent;
    private String adminId;
    private Time problemCreateTime;
    private int lockFlag;

    public int getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(int lockFlag) {
        this.lockFlag = lockFlag;
    }

    public Time getProblemCreateTime() {

        return problemCreateTime;
    }

    public void setProblemCreateTime(Time problemCreateTime) {
        this.problemCreateTime = problemCreateTime;
    }

    public String getAdminId() {

        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getProblemContent() {

        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent;
    }

    public String getProblemId() {

        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }
}
