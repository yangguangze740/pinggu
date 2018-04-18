package com.zhulin.sys.pojo;

import java.sql.Timestamp;

public class MethodPermission {
    private String permissionId;
    private String group;
    private String name;
    private String value;
    private int version;
    private Timestamp createTime1;
    private String remark = "";
    private String groupName;

    public Timestamp getCreateTime1() {
        return createTime1;
    }

    public void setCreateTime1(Timestamp createTime1) {
        this.createTime1 = createTime1;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Timestamp getCreateTime() {
        return createTime1;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime1 = createTime;
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

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
