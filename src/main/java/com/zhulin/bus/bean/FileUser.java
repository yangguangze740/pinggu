package com.zhulin.bus.bean;


import java.util.List;

public class FileUser {
    private String fileUserId;
    private String fileUserName;
    private String trueName;
    private String password;
    private String createUserId;
    private String deleteFlag;
    private List<String> departmentIds;
    private List<String> typeIds;
    private List<String> supportDepartmentIds;

    public List<String> getSupportDepartmentIds() {
        return supportDepartmentIds;
    }

    public void setSupportDepartmentIds(List<String> supportDepartmentIds) {
        this.supportDepartmentIds = supportDepartmentIds;
    }

    public List<String> getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(List<String> typeIds) {
        this.typeIds = typeIds;
    }

    public List<String> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<String> departmentIds) {
        this.departmentIds = departmentIds;
    }

    public String getFileUserId() {
        return fileUserId;
    }

    public void setFileUserId(String fileUserId) {
        this.fileUserId = fileUserId;
    }

    public String getFileUserName() {
        return fileUserName;
    }

    public void setFileUserName(String fileUserName) {
        this.fileUserName = fileUserName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
