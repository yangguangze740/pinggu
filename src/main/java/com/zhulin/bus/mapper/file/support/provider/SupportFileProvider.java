package com.zhulin.bus.mapper.file.support.provider;


import com.google.common.base.Strings;
import com.zhulin.bus.bean.SupportFile;

import java.util.Map;

public class SupportFileProvider {
    public String selectSupportFile(Map map) {

        SupportFile supportFile = (SupportFile) map.get("supportFile");

        StringBuilder builder = new StringBuilder();
//        builder.append("select supportFileId, departmentId, userId, fileTypeFlag, supportFileCreateTime, pointId, dutyDepartmentId, leadDepartmentId, supportFileName, supportFileDbName, supportFilePath, supportFileRemark, projectId, elementId FROM pinggu_support_file WHERE deleteFlag = 0");
        builder.append("SELECT PSF.supportFileId, PSF.departmentId, PSF.userId, fileTypeFlag, supportFileCreateTime, PSF.pointId, REP.pointName, ");
        builder.append(" PSF.dutyDepartmentId, DD.dutyName, PSF.leadDepartmentId, LD.leadName, supportFileName, supportFileDbName, supportFilePath,");
        builder.append(" supportFileRemark, PSF.projectId, RP.projectName, PSF.elementId, RE.elementName, A.createTime, B.modifyTime, A.createUserId,");
        builder.append(" B.modifyUserId, A.createUserName, B.modifyUserName, D.departmentName");
        builder.append(" FROM pinggu_support_file PSF LEFT JOIN");
        builder.append(" (SELECT supportFileId, MIN(supportModifyTime) AS createTime, MIN(PSFM.userId) AS createUserId, MIN(GU.userName) AS createUserName");
        builder.append(" FROM pinggu_support_file_modify PSFM LEFT JOIN pinggu_general_user GU ON PSFM.userId = GU.userId");
        builder.append(" GROUP BY supportFileId) A ON A.supportFileId = PSF.supportFileId LEFT JOIN");
        builder.append(" (SELECT supportFileId, MAX(supportModifyTime) AS modifyTime, MIN(PSFM.userId) AS modifyUserId,");
        builder.append(" MIN(GU.userName) AS modifyUserName FROM pinggu_support_file_modify PSFM");
        builder.append(" LEFT JOIN pinggu_general_user GU ON PSFM.userId = GU.userId");
        builder.append(" GROUP BY supportFileId) B ON PSF.supportFileId = B.supportFileId");
        builder.append(" LEFT JOIN pinggu_review_project RP ON PSF.projectId = RP.projectId");
        builder.append(" LEFT JOIN pinggu_review_point REP ON PSF.pointId = REP.pointId");
        builder.append(" LEFT JOIN pinggu_review_element RE ON PSF.elementId = RE.elementId");
        builder.append(" LEFT JOIN pinggu_duty_department DD ON PSF.dutyDepartmentId = DD.dutyDepartmentId");
        builder.append(" LEFT JOIN pinggu_lead_department LD ON PSF.leadDepartmentId = LD.leadDepartmentId");
        builder.append(" LEFT JOIN pinggu_department D ON PSF.departmentId = D.departmentId");
        builder.append(" WHERE PSF.deleteFlag = 0 ORDER BY RP.projectSort, RE.elementSort, REP.pointSort");

        String projectId = supportFile.getProjectId();
        if(!Strings.isNullOrEmpty(projectId)){
            builder.append(" AND PSF.projectId = #{supportFile.projectId}");
        }

        String elementId = supportFile.getElementId();
        if(!Strings.isNullOrEmpty(elementId)){
            builder.append(" AND PSF.elementId = #{supportFile.elementId}");
        }

        String pointId = supportFile.getPointId();
        if(!Strings.isNullOrEmpty(pointId)){
            builder.append(" AND PSF.pointId = #{supportFile.pointId}");
        }

        return builder.toString();
    }
}
