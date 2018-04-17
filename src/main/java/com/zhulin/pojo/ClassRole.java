package com.zhulin.pojo;

import java.sql.Timestamp;
import java.util.List;

public class ClassRole {
    private String roleId;
    private String group;
    private String name;
    private String value;
    private String remark = "";
    private int version;
    private Timestamp createTime;
    private List<MethodPermission> methodPermissions;

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<MethodPermission> getMethodPermissions() {
        return methodPermissions;
    }

    public void setMethodPermissions(List<MethodPermission> methodPermissions) {
        this.methodPermissions = methodPermissions;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
