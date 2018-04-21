package com.zhulin.bus.bean;

import java.sql.Time;
import java.sql.Timestamp;

public class RaterFile {
    private String raterFileId;
    private String raterFileName;
    private String raterFileDbName;
    private String raterFilePath;
    private String departmentId;
    private String userId;
    private String fileTypeFlag;
    private String departmentTypeId;
    private Timestamp raterFileCreateTime;
    private String raterFileRemark;
    private int deleteFlag;

    public Timestamp getRaterFileCreateTime() {
        return raterFileCreateTime;
    }

    public void setRaterFileCreateTime(Timestamp raterFileCreateTime) {
        this.raterFileCreateTime = raterFileCreateTime;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getRaterFileRemark() {

        return raterFileRemark;
    }

    public void setRaterFileRemark(String raterFileRemark) {
        this.raterFileRemark = raterFileRemark;
    }

    public String getDepartmentTypeId() {

        return departmentTypeId;
    }

    public void setDepartmentTypeId(String departmentTypeId) {
        this.departmentTypeId = departmentTypeId;
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

    public String getRaterFilePath() {

        return raterFilePath;
    }

    public void setRaterFilePath(String raterFilePath) {
        this.raterFilePath = raterFilePath;
    }

    public String getRaterFileDbName() {
        return raterFileDbName;
    }

    public void setRaterFileDbName(String raterFileDbName) {
        this.raterFileDbName = raterFileDbName;
    }

    public String getRaterFileName() {

        return raterFileName;
    }

    public void setRaterFileName(String raterFileName) {
        this.raterFileName = raterFileName;
    }

    public String getRaterFileId() {

        return raterFileId;
    }

    public void setRaterFileId(String raterFileId) {
        this.raterFileId = raterFileId;
    }
}
