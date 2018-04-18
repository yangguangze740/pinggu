package com.zhulin.sys.pojo;

public class SystemRolePermission {
    private String roleId;
    private String permissionId;
    private int shouldDeleteFlag;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public int getShouldDeleteFlag() {
        return shouldDeleteFlag;
    }

    public void setShouldDeleteFlag(int shouldDeleteFlag) {
        this.shouldDeleteFlag = shouldDeleteFlag;
    }
}
