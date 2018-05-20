package com.zhulin.bus.bean;

import java.sql.Time;
import java.util.List;

public class Department {
    private String departmentId;
    private String departmentName;
    private Time departmentCreateTime;
    private String adminId;
    private int lockFlag;
    private List<String> typeIds;
    private List<String> problemIds;
    private int departmentSort;

    public int getDepartmentSort() {
        return departmentSort;
    }

    public void setDepartmentSort(int departmentSort) {
        this.departmentSort = departmentSort;
    }

    public List<String> getProblemIds() {
        return problemIds;
    }

    public void setProblemIds(List<String> problemIds) {
        this.problemIds = problemIds;
    }

    public List<String> getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(List<String> typeIds) {
        this.typeIds = typeIds;
    }

    public int getLockFlag() {
        return lockFlag;
    }

    public void setLockFlag(int lockFlag) {
        this.lockFlag = lockFlag;
    }

    public String getAdminId() {

        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Time getDepartmentCreateTime() {

        return departmentCreateTime;
    }

    public void setDepartmentCreateTime(Time departmentCreateTime) {
        this.departmentCreateTime = departmentCreateTime;
    }

    public String getDepartmentName() {

        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {

        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
