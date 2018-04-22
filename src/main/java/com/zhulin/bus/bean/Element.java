package com.zhulin.bus.bean;


import java.sql.Timestamp;

public class Element {
    private String elementId;
    private String elementName;
    private String projectId;
    private String projectName;
    private Timestamp elementCreateTime;
    private String adminId;
    private String elementSort;
    private String deleteFlag;
    private String pointId;
    private String pointName;

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }
    public Timestamp getElementCreateTime() {
        return elementCreateTime;
    }

    public void setElementCreateTime(Timestamp elementCreateTime) {
        this.elementCreateTime = elementCreateTime;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
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

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getElementSort() {
        return elementSort;
    }

    public void setElementSort(String elementSort) {
        this.elementSort = elementSort;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
