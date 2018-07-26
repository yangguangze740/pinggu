package com.zhulin.bus.bean;



public class FileDepartment {
    private String fileUserId;
    private String departmentId;
    private String supportDepartmentId;

    public String getSupportDepartmentId() {
        return supportDepartmentId;
    }

    public void setSupportDepartmentId(String supportDepartmentId) {
        this.supportDepartmentId = supportDepartmentId;
    }

    public String getFileUserId() {
        return fileUserId;
    }

    public void setFileUserId(String fileUserId) {
        this.fileUserId = fileUserId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
