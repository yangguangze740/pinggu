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
//        builder.append("SELECT raterFileId, raterFileName, raterFileDbName, raterFilePath, departmentId, userId, fileTypeFlag, raterFileCreateTime, departmentTypeId, raterFileRemark, deleteFlag FROM pinggu_rater_file WHERE deleteFlag=0 ");
        builder.append("SELECT RF.raterFileId, RF.raterFileName, RF.raterFileDbName, RF.raterFilePath, RF.departmentId, RF.userId, RF.fileTypeFlag,");
        builder.append(" RF.raterFileCreateTime, RF.departmentTypeId, RF.raterFileRemark,RF.deleteFlag, A.createTime, A.createUserName,");
        builder.append(" B.modifyTime, B.modifyUserName, D.departmentName, T.typeName");
        builder.append(" FROM pinggu_rater_file RF");
        builder.append(" LEFT JOIN (SELECT raterFileId, MIN(raterFileModifyTime) AS createTime, MIN(GU.userName) AS createUserName");
        builder.append(" FROM pinggu_rater_file_modify RFM LEFT JOIN pinggu_general_user GU ON RFM.userId = GU.userId");
        builder.append(" GROUP BY raterFileId) A ON A.raterFileId = RF.raterFileId");
        builder.append(" LEFT JOIN (SELECT raterFileId, MAX(raterFileModifyTime) AS modifyTime, MAX(GU.userName) AS modifyUserName");
        builder.append(" FROM pinggu_rater_file_modify RFM LEFT JOIN pinggu_general_user GU ON RFM.userId = GU.userId");
        builder.append(" GROUP BY raterFileId) B ON B.raterFileId = RF.raterFileId");
        builder.append(" LEFT JOIN pinggu_department D ON RF.departmentId = D.departmentId");
        builder.append(" LEFT JOIN pinggu_type T ON RF.departmentTypeId = T.typeId");
        builder.append(" WHERE RF.deleteFlag = 0 ORDER BY D.departmentSort");

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
