package com.zhulin.bus.mapper.point.provider;


import com.zhulin.bus.bean.DutyDepartment;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class PointInsertProvider {
    public String insertDutyDepartment(Map map) {

        List<DutyDepartment> dutyDepartments = (List<DutyDepartment>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO pinggu_review_point_duty_department (pointId, dutyDepartmentId) VALUES ");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].pointId}, #'{'list[{0}].dutyDepartmentId})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < dutyDepartments.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < dutyDepartments.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }
}
