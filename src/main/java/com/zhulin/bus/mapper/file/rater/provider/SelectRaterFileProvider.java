package com.zhulin.bus.mapper.file.rater.provider;

import com.google.common.base.Strings;
import com.zhulin.bus.bean.RaterFile;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

public class SelectRaterFileProvider {
    public String selectRaterFile(Map map){
        RaterFile raterFile = (RaterFile) map.get("raterFile");

        StringBuilder builder = new StringBuilder();
        builder.append("SELECT raterFileId, raterFileName, raterFileDbName, raterFilePath, departmentId, userId, fileTypeFlag, raterFileCreateTime, departmentTypeId, raterFileRemark, deleteFlag FROM pinggu_rater_file WHERE deleteFlag=0 ");

        String departmentId = raterFile.getDepartmentId();
        if (!Strings.isNullOrEmpty(departmentId)){
            builder.append(" AND departmentId=#{raterFile.departmentId}");
        }

        String departmentTypeId = raterFile.getDepartmentTypeId();
        if (!Strings.isNullOrEmpty(departmentTypeId)) {
            builder.append(" AND departmentTypeId=#{raterFile.departmentTypeId}");
        }

        return builder.toString();
    }
}
