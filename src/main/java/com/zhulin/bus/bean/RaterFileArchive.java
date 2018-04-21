package com.zhulin.bus.bean;

import java.sql.Time;

public class RaterFileArchive {
    private String raterFileArchiveId;
    private String archiveUserId;
    private Time raterArchiveTime;
    private String raterFileName;
    private String raterFileDbName;
    private String raterFilePath;
    private int fileReadNum;
    private String uploadUserId;
    private Time uploadTime;
    private String archiveFilePath;
    private String raterFileId;

    public String getRaterFileId() {
        return raterFileId;
    }

    public void setRaterFileId(String raterFileId) {
        this.raterFileId = raterFileId;
    }

    public String getArchiveFilePath() {

        return archiveFilePath;
    }

    public void setArchiveFilePath(String archiveFilePath) {
        this.archiveFilePath = archiveFilePath;
    }

    public Time getUploadTime() {

        return uploadTime;
    }

    public void setUploadTime(Time uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUploadUserId() {

        return uploadUserId;
    }

    public void setUploadUserId(String uploadUserId) {
        this.uploadUserId = uploadUserId;
    }

    public int getFileReadNum() {

        return fileReadNum;
    }

    public void setFileReadNum(int fileReadNum) {
        this.fileReadNum = fileReadNum;
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

    public Time getRaterArchiveTime() {

        return raterArchiveTime;
    }

    public void setRaterArchiveTime(Time raterArchiveTime) {
        this.raterArchiveTime = raterArchiveTime;
    }

    public String getArchiveUserId() {

        return archiveUserId;
    }

    public void setArchiveUserId(String archiveUserId) {
        this.archiveUserId = archiveUserId;
    }

    public String getRaterFileArchiveId() {

        return raterFileArchiveId;
    }

    public void setRaterFileArchiveId(String raterFileArchiveId) {
        this.raterFileArchiveId = raterFileArchiveId;
    }
}
