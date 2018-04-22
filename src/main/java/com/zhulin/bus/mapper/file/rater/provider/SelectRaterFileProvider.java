package com.zhulin.bus.mapper.file.rater.provider;

import com.zhulin.bus.bean.RaterFile;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class SelectRaterFileProvider {
    public String selectRaterFile(Map map){
        RaterFile raterFile = (RaterFile) map.get("raterFile");

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT raterFileId, raterFileName, raterFileDbName, raterFilePath, departmentId, userId, fileTypeFlag, raterFileCreateTime, departmentTypeId, raterFileRemark, deleteFlag FROM pinggu_rater_file WHERE deleteFlag=0 ");

        if (raterFile.getDepartmentId() != null){
            builder.append(" AND departmentId=" + raterFile.getDepartmentId());
        }

        if (raterFile.getDepartmentTypeId() != null) {
            builder.append(" AND departmentTypeId=" + raterFile.getDepartmentTypeId());
        }

        return builder.toString();
    }
}
