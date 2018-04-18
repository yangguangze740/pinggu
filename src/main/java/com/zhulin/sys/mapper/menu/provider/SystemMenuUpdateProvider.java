package com.zhulin.sys.mapper.menu.provider;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class SystemMenuUpdateProvider {
    public String updateChildMenuParentId(Map map) {
        String menuId = (String) map.get("menuId");

        List<String> childMenuIds = (List<String>) map.get("list");

        StringBuilder builder = new StringBuilder();

        builder.append("UPDATE system_menu SET parentId = #{menuId} WHERE menuId IN (");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("#'{'list[{0}]}");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < childMenuIds.size(); i++) {

            builder.append(mf.format(new Object[]{i}));

            if (i < childMenuIds.size() - 1) {
                builder.append(",");
            }
        }

        builder.append(")");

        return builder.toString();
    }
}
