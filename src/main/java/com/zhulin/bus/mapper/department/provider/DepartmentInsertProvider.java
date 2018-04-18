package com.zhulin.bus.mapper.department.provider;

import com.zhulin.bus.bean.DepartmentType;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class DepartmentInsertProvider {
    public String insertDepartmentTypes(Map map) {
        List<DepartmentType> departmentTypes = (List<DepartmentType>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO pinggu_department_type (departmentId, typeId) VALUES ");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].departmentId}, #'{'list[{0}].typeId})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < departmentTypes.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < departmentTypes.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }
}
