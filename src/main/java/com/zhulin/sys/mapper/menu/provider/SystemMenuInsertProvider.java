package com.zhulin.sys.mapper.menu.provider;

import com.zhulin.sys.pojo.Menu;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class SystemMenuInsertProvider {
    public String insertBakMenuToBakMenuTable(Map map) {
        List<Menu> bakMenus = (List<Menu>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO bak_menu (menuId, parentId, menuName, menuURL, menuType, icon, orderNum, menuGroupValue,");
        builder.append(" menuGroupName, version, createTime, isParentMenu) VALUES ");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].menuId}, #'{'list[{0}].parentId}, #'{'list[{0}].menuName},");
        valueFormatBuilder.append(" #'{'list[{0}].menuURL}, #'{'list[{0}].menuType}, #'{'list[{0}].icon},");
        valueFormatBuilder.append(" #'{'list[{0}].orderNum}, #'{'list[{0}].menuGroupValue}, #'{'list[{0}].menuGroupName}");
        valueFormatBuilder.append(", #'{'list[{0}].version}, #'{'list[{0}].createTime}, #'{'list[{0}].isParentMenu})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < bakMenus.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < bakMenus.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public String insertNewMenuToMenuTable(Map map) {
        List<Menu> newMenus = (List<Menu>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO system_menu (menuId, menuName, menuURL, menuType, icon, orderNum, menuGroupValue,");
        builder.append(" menuGroupName) VALUES");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].menuId}, #'{'list[{0}].menuName},");
        valueFormatBuilder.append(" #'{'list[{0}].menuURL}, #'{'list[{0}].menuType}, #'{'list[{0}].icon},");
        valueFormatBuilder.append(" #'{'list[{0}].orderNum}, #'{'list[{0}].menuGroupValue}, #'{'list[{0}].menuGroupName})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < newMenus.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < newMenus.size() - 1) {
            builder.append(",");
            }
        }

        return builder.toString();
    }
}