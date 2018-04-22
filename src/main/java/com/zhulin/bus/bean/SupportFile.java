package com.zhulin.bus.bean;

import java.sql.Timestamp;

public class SupportFile {
    private String supportFileId;
    private String departmentId;
    private String userId;
    private String fileTypeFlag;
    private Timestamp supportFileCreateTime;
    private String pointId;
    private String dutyDepartmentId;
    private String leadDepartmentId;
    private String supportFileName;
    private String supportFileDbName;
    private String supportFilePath;
    private int deleteFlag;
    private String supportFileRemark;
    private String projectId;
    private String elementId;

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getProjectId() {

        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSupportFileRemark() {

        return supportFileRemark;
    }

    public void setSupportFileRemark(String supportFileRemark) {
        this.supportFileRemark = supportFileRemark;
    }

    public int getDeleteFlag() {

        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getSupportFilePath() {

        return supportFilePath;
    }

    public void setSupportFilePath(String supportFilePath) {
        this.supportFilePath = supportFilePath;
    }

    public String getSupportFileDbName() {

        return supportFileDbName;
    }

    public void setSupportFileDbName(String supportFileDbName) {
        this.supportFileDbName = supportFileDbName;
    }

    public String getSupportFileName() {

        return supportFileName;
    }

    public void setSupportFileName(String supportFileName) {
        this.supportFileName = supportFileName;
    }

    public String getLeadDepartmentId() {

        return leadDepartmentId;
    }

    public void setLeadDepartmentId(String leadDepartmentId) {
        this.leadDepartmentId = leadDepartmentId;
    }

    public String getDutyDepartmentId() {

        return dutyDepartmentId;
    }

    public void setDutyDepartmentId(String dutyDepartmentId) {
        this.dutyDepartmentId = dutyDepartmentId;
    }

    public String getPointId() {

        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public Timestamp getSupportFileCreateTime() {
        return supportFileCreateTime;
    }

    public void setSupportFileCreateTime(Timestamp supportFileCreateTime) {
        this.supportFileCreateTime = supportFileCreateTime;
    }

    public String getFileTypeFlag() {

        return fileTypeFlag;
    }

    public void setFileTypeFlag(String fileTypeFlag) {
        this.fileTypeFlag = fileTypeFlag;
    }

    public String getUserId() {

        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getSupportFileId() {

        return supportFileId;
    }

    public void setSupportFileId(String supportFileId) {
        this.supportFileId = supportFileId;
    }
}
