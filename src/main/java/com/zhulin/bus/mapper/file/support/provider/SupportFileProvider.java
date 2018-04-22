package com.zhulin.bus.mapper.file.support.provider;


import com.google.common.base.Strings;
import com.zhulin.bus.bean.SupportFile;

import java.util.Map;

public class SupportFileProvider {
    public String selectSupportFile(Map map) {

        SupportFile supportFile = (SupportFile) map.get("supportFile");

        StringBuilder builder = new StringBuilder();
        builder.append("select supportFileId, departmentId, userId, fileTypeFlag, supportFileCreateTime, pointId, dutyDepartmentId, leadDepartmentId, supportFileName, supportFileDbName, supportFilePath, supportFileRemark, projectId, elementId FROM pinggu_support_file WHERE deleteFlag = 0");

        String projectId = supportFile.getProjectId();
        if(!Strings.isNullOrEmpty(projectId)){
            builder.append(" AND projectId = #{supportFile.projectId}");
        }

        String elementId = supportFile.getElementId();
        if(!Strings.isNullOrEmpty(elementId)){
            builder.append(" AND elementId = #{supportFile.elementId}");
        }

        String pointId = supportFile.getPointId();
        if(!Strings.isNullOrEmpty(pointId)){
            builder.append(" AND pointId = #{supportFile.pointId}");
        }

        return builder.toString();
    }
}
