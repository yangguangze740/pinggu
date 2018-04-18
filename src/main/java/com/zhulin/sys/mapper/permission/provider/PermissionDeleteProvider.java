package com.zhulin.sys.mapper.permission.provider;

import com.zhulin.sys.pojo.MethodPermission;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class PermissionDeleteProvider {
    public String delete4CleanPermissionTable(Map map) {
        List<MethodPermission> cleanPermissions = (List<MethodPermission>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("DELETE FROM system_permission WHERE permissionId IN (");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("#'{'list[{0}].permissionId}");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < cleanPermissions.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < (cleanPermissions.size() - 1)) {
                builder.append(",");
            }
        }

        builder.append(")");

        return builder.toString();
    }
}
