package com.zhulin.sys.mapper.role.provider;

import com.zhulin.sys.pojo.ClassRole;
import com.zhulin.sys.pojo.SystemUserRole;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class RoleDeleteProvider {
    public String delete4CleanRoleTable(Map map) {
        List<ClassRole> cleanRoles = (List<ClassRole>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("DELETE FROM system_role WHERE roleId IN (");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("#'{'list[{0}].roleId}");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < cleanRoles.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < (cleanRoles.size() - 1)) {
                builder.append(",");
            }
        }

        builder.append(")");

        return builder.toString();
    }

    public String delete4CleanRolePermissionTable(Map map) {
        List<ClassRole> cleanRolePermissions = (List<ClassRole>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("DELETE FROM system_role_permission WHERE roleId IN (");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("#'{'list[{0}].roleId}");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < cleanRolePermissions.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < (cleanRolePermissions.size() - 1)) {
                builder.append(",");
            }
        }

        builder.append(")");

        return builder.toString();
    }

    public String deleteUserRoles(Map map) {
        List<String> roleIds = (List<String>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("DELETE FROM system_user_role WHERE roleId IN (");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("#'{'list[{0}]}");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < roleIds.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < (roleIds.size() - 1)) {
                builder.append(",");
            }
        }

        builder.append(")");

        return builder.toString();
    }

    public String deleteAllUserRoles(Map map) {
        List<SystemUserRole> userRoles = (List<SystemUserRole>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("DELETE FROM system_user_role WHERE roleId IN (");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("#'{'list[{0}].roleId}");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < userRoles.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < (userRoles.size() - 1)) {
                builder.append(",");
            }
        }

        builder.append(")");

        return builder.toString();
    }
}
