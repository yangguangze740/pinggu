package com.zhulin.sys.mapper.role.provider;

import com.zhulin.sys.pojo.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class RoleInsertProvider {
    public String insertBakRoleToBakRoleTable(Map map) {
        List<ClassRole> bakRoles = (List<ClassRole>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO bak_role (roleId, roleName, roleRemark, createTime, roleGroup, roleValue, version) VALUES");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].roleId}, #'{'list[{0}].name}, #'{'list[{0}].remark},");
        valueFormatBuilder.append(" #'{'list[{0}].createTime}, #'{'list[{0}].group}, #'{'list[{0}].value}");
        valueFormatBuilder.append(", #'{'list[{0}].version})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < bakRoles.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < bakRoles.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public String insertNewRolesToRoleTable(Map map) {
        List<ClassRole> newRoles = (List<ClassRole>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO system_role (roleId, roleName, roleRemark, roleGroup, roleValue) VALUES");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].roleId}, #'{'list[{0}].name}, #'{'list[{0}].remark},");
        valueFormatBuilder.append(" #'{'list[{0}].group}, #'{'list[{0}].value})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < newRoles.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < newRoles.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public String insertNewRolePermissionsToRolePermissionTable(Map map) {
        List<ClassRole> newRolePermissions = (List<ClassRole>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO system_role_permission (roleId, permissionId) VALUES ");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].roleId}, #'{'list[{0}].permissionId})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < newRolePermissions.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < newRolePermissions.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public String insertBatchRoleMenu(Map map) {
        List<SystemRoleMenu> roleMenus = (List<SystemRoleMenu>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO system_role_menu (roleId, menuId) VALUES ");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].roleId}, #'{'list[{0}].menuId})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < roleMenus.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < roleMenus.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public String insertBatchRolePermission(Map map) {
        List<SystemRolePermission> rolePermissions = (List<SystemRolePermission>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO system_role_permission (roleId, permissionId, shouldDeleteFlag) VALUES ");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].roleId}, #'{'list[{0}].permissionId}, #'{'list[{0}].shouldDeleteFlag})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < rolePermissions.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < rolePermissions.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public String insertUserRoles(Map map) {
        List<SystemUserRole> userRoles = (List<SystemUserRole>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO system_user_role (userId, roleId) VALUES ");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].userId}, #'{'list[{0}].roleId})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < userRoles.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < userRoles.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public String insertRoleMenus(Map map) {
        List<SystemRoleMenu> roleMenus = (List<SystemRoleMenu>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO system_role_menu (roleId, menuId) VALUES");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].roleId}, #'{'list[{0}].menuId})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < roleMenus.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < roleMenus.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }
}
