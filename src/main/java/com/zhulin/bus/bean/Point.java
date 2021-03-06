package com.zhulin.bus.bean;


import java.sql.Timestamp;
import java.util.List;

public class Point {
    private String pointId;
    private String pointName;
    private Timestamp pointCreateTime;
    private String adminId;
    private int pointSort;
    private String deleteFlag;
    private String elementId;
    private String elementName;
    private String dutyDepartmentId;
    private String dutyName;
    private String leadDepartmentId;
    private String leadName;
    private List<String> dutyDepartmentIds;
    private String projectName;
    private String projectId;
    private List<String> oldDutyIds;

    public List<String> getOldDutyIds() {
        return oldDutyIds;
    }

    public void setOldDutyIds(List<String> oldDutyIds) {
        this.oldDutyIds = oldDutyIds;
    }

    public int getPointSort() {
        return pointSort;
    }

    public void setPointSort(int pointSort) {
        this.pointSort = pointSort;
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

    public List<String> getDutyDepartmentIds() {
        return dutyDepartmentIds;
    }

    public void setDutyDepartmentIds(List<String> dutyDepartmentIds) {
        this.dutyDepartmentIds = dutyDepartmentIds;
    }

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

    public Timestamp getPointCreateTime() {
        return pointCreateTime;
    }

    public void setPointCreateTime(Timestamp pointCreateTime) {
        this.pointCreateTime = pointCreateTime;
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

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
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

    public String getLeadDepartmentId() {
        return leadDepartmentId;
    }

    public void setLeadDepartmentId(String leadDepartmentId) {
        this.leadDepartmentId = leadDepartmentId;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }
}
