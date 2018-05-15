package com.zhulin.bus.bean;

import java.sql.Timestamp;

public class PaperFile {
    private String paperFileId;
    private String paperId;
    private String subjectId;
    private String disciplineId;
    private String collegeId;
    private String userId;
    private String fileTypeFlag;
    private Timestamp paperFileCreateTime;
    private String paperFileName;
    private String paperFileDBName;
    private String paperFilePath;
    private String paperFileRemark;
    private String paperName;
    private String subjectName;
    private String disciplineName;
    private String collegeName;
    private String UserName;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPaperFileId() {
        return paperFileId;
    }

    public void setPaperFileId(String paperFileId) {
        this.paperFileId = paperFileId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(String disciplineId) {
        this.disciplineId = disciplineId;
    }

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileTypeFlag() {
        return fileTypeFlag;
    }

    public void setFileTypeFlag(String fileTypeFlag) {
        this.fileTypeFlag = fileTypeFlag;
    }

    public Timestamp getPaperFileCreateTime() {
        return paperFileCreateTime;
    }

    public void setPaperFileCreateTime(Timestamp paperFileCreateTime) {
        this.paperFileCreateTime = paperFileCreateTime;
    }

    public String getPaperFileName() {
        return paperFileName;
    }

    public void setPaperFileName(String paperFileName) {
        this.paperFileName = paperFileName;
    }

    public String getPaperFileDBName() {
        return paperFileDBName;
    }

    public void setPaperFileDBName(String paperFileDBName) {
        this.paperFileDBName = paperFileDBName;
    }

    public String getPaperFilePath() {
        return paperFilePath;
    }

    public void setPaperFilePath(String paperFilePath) {
        this.paperFilePath = paperFilePath;
    }

    public String getPaperFileRemark() {
        return paperFileRemark;
    }

    public void setPaperFileRemark(String paperFileRemark) {
        this.paperFileRemark = paperFileRemark;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
