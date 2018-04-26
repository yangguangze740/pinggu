package com.zhulin.bus.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Question {
    private String problemListId;
    private String projectId;
    private String elementId;
    private String problemContent;
    private String problemShow;
    private String problemModifyMeasure;
    private Date problemPlanSolveTime;
    private String departmentId;
    private Timestamp problemCreateTime;
    private String projectName;
    private String elementName;
    private String departmentName;
    private String createUserId;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getElementName() {

        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getProjectName() {

        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Timestamp getProblemCreateTime() {
        return problemCreateTime;
    }

    public void setProblemCreateTime(Timestamp problemCreateTime) {
        this.problemCreateTime = problemCreateTime;
    }

    public String getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Date getProblemPlanSolveTime() {
        return problemPlanSolveTime;
    }

    public void setProblemPlanSolveTime(Date problemPlanSolveTime) {
        this.problemPlanSolveTime = problemPlanSolveTime;
    }

    public String getProblemModifyMeasure() {

        return problemModifyMeasure;
    }

    public void setProblemModifyMeasure(String problemModifyMeasure) {
        this.problemModifyMeasure = problemModifyMeasure;
    }

    public String getProblemShow() {

        return problemShow;
    }

    public void setProblemShow(String problemShow) {
        this.problemShow = problemShow;
    }

    public String getProblemContent() {

        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent;
    }

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

    public String getProblemListId() {

        return problemListId;
    }

    public void setProblemListId(String problemListId) {
        this.problemListId = problemListId;
    }
}
