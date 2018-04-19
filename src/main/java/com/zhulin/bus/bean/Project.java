package com.zhulin.bus.bean;


import java.sql.Timestamp;

public class Project {
    private String projectId;
    private String projectName;
    private Timestamp projectCreateTime;
    private String adminId;
    private String deleteFlag;
    private String projectSort;

    public String getProjectSort() {
        return projectSort;
    }

    public void setProjectSort(String projectSort) {
        this.projectSort = projectSort;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Timestamp getProjectCreateTime() {
        return projectCreateTime;
    }

    public void setProjectCreateTime(Timestamp projectCreateTime) {
        this.projectCreateTime = projectCreateTime;
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
}
