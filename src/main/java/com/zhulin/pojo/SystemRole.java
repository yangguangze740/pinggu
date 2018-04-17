package com.zhulin.pojo;

import java.sql.Timestamp;
import java.util.List;

public class SystemRole {
    private String roleId;
    private String roleName;
    private String roleRemark = "";
    private Timestamp createTime;
    private String roleGroup;
    private String roleValue;
    private List<Menu> menus;
    private int editFlag;
    private List<String> menuIds;
    private List<String> permissionIds;
    private List<SystemPermission> permissions;
    private List<String> oldMenuIds;
    private List<String> oldPermissionIds;

    public List<String> getOldMenuIds() {
        return oldMenuIds;
    }

    public void setOldMenuIds(List<String> oldMenuIds) {
        this.oldMenuIds = oldMenuIds;
    }

    public List<String> getOldPermissionIds() {
        return oldPermissionIds;
    }

    public void setOldPermissionIds(List<String> oldPermissionIds) {
        this.oldPermissionIds = oldPermissionIds;
    }

    public List<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }

    public List<String> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<String> permissionIds) {
        this.permissionIds = permissionIds;
    }

    public int getEditFlag() {
        return editFlag;
    }

    public void setEditFlag(int editFlag) {
        this.editFlag = editFlag;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<SystemPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SystemPermission> permissions) {
        this.permissions = permissions;
    }

    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
