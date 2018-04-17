package com.zhulin.sys.mapper.menu.provider;

import com.zhulin.pojo.Menu;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class SystemMenuDeleteProvider {
    public String delete4CleanMenuTable(Map map) {
        List<Menu> cleanMenus = (List<Menu>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("DELETE FROM system_menu WHERE menuId IN (");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("#'{'list[{0}].menuId}");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < cleanMenus.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < (cleanMenus.size() - 1)) {
                builder.append(",");
            }
        }

        builder.append(")");

        return builder.toString();
    }
}
