package com.zhulin.sys.mapper.permission.provider;

import com.zhulin.pojo.MethodPermission;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class PermissionInsertProvider {
    public String insertNewPermissionsToPermissionTable(Map map) {
        List<MethodPermission> newPermissions = (List<MethodPermission>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO system_permission ( permissionId, permissionName, permissionRemark, permissionGroup,");
        builder.append(" permissionValue, permissionGroupName) VALUES");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].permissionId}, #'{'list[{0}].name}, #'{'list[{0}].remark},");
        valueFormatBuilder.append(" #'{'list[{0}].group}, #'{'list[{0}].value}, #'{'list[{0}].groupName})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < newPermissions.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < newPermissions.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public String insertBakPermissionToBakPermissionTable(Map map) {
        List<MethodPermission> newPermissions = (List<MethodPermission>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO bak_permission (permissionId, permissionName, permissionRemark, permissionCreateTime,");
        builder.append(" permissionGroup, permissionValue, version, permissionGroupName) VALUES");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].permissionId}, #'{'list[{0}].name}, #'{'list[{0}].remark},");
        valueFormatBuilder.append(" #'{'list[{0}].createTime}, #'{'list[{0}].group}, #'{'list[{0}].value}");
        valueFormatBuilder.append(" , #'{'list[{0}].version}, #'{'list[{0}].groupName})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < newPermissions.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < newPermissions.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }
}
