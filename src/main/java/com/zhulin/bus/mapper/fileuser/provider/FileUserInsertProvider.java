package com.zhulin.bus.mapper.fileuser.provider;


import com.zhulin.bus.bean.FileDepartment;
import com.zhulin.bus.bean.FileType;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class FileUserInsertProvider {
    public String insertRaterDepartments(Map map) {
        List<FileDepartment> fileDepartments = (List<FileDepartment>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO pinggu_rater_file_user_department (fileUserId, departmentId) VALUES ");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].fileUserId}, #'{'list[{0}].departmentId})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < fileDepartments.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < fileDepartments.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public String insertSupportDepartment(Map map) {
        List<FileDepartment> fileDepartments = (List<FileDepartment>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO pinggu_support_file_user_department (fileUserId, departmentId) VALUES ");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].fileUserId}, #'{'list[{0}].supportDepartmentId})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < fileDepartments.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < fileDepartments.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }

    public String insertFileTypes(Map map) {
        List<FileType> fileTypes = (List<FileType>) map.get("list");

        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO pinggu_rater_file_user_type (fileUserId, typeId) VALUES ");

        StringBuilder valueFormatBuilder = new StringBuilder();
        valueFormatBuilder.append("(#'{'list[{0}].fileUserId}, #'{'list[{0}].typeId})");

        MessageFormat mf = new MessageFormat(valueFormatBuilder.toString());
        for (int i = 0; i < fileTypes.size(); i++) {
            builder.append(mf.format(new Object[]{i}));

            if (i < fileTypes.size() - 1) {
                builder.append(",");
            }
        }

        return builder.toString();
    }
}
