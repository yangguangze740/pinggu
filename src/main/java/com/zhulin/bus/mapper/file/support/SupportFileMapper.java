package com.zhulin.bus.mapper.file.support;

import com.zhulin.bus.bean.SupportFile;
import com.zhulin.bus.bean.SupportFileModify;
import com.zhulin.bus.mapper.file.support.provider.SupportFileProvider;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface SupportFileMapper extends ArcMapper<SupportFile>{
    @SelectProvider(type = SupportFileProvider.class, method = "selectSupportFile")
    @Results({
            @Result(id = true, column = "supportFileId", property = "supportFileId"),
            @Result(column = "departmentId", property = "departmentId"),
            @Result(column = "userId", property = "userId"),
            @Result(column = "fileTypeFlag",property = "fileTypeFlag"),
            @Result(column = "supportFileCreateTime", property = "supportFileCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "pointId", property = "pointId"),
            @Result(column = "dutyDepartmentId", property = "dutyDepartmentId"),
            @Result(column = "leadDepartmentId", property = "leadDepartmentId"),
            @Result(column = "supportFileName", property = "supportFileName"),
            @Result(column = "supportFileDbName", property = "supportFileDbName"),
            @Result(column = "supportFilePath", property = "supportFilePath"),
            @Result(column = "supportFileRemark", property = "supportFileRemark"),
            @Result(column = "projectId", property = "projectId"),
            @Result(column = "elementId", property = "elementId"),
            @Result(column = "elementName", property = "elementName"),
            @Result(column = "projectName", property = "projectName"),
            @Result(column = "pointName", property = "pointName"),
            @Result(column = "leadName", property = "leadName"),
            @Result(column = "dutyName", property = "dutyName"),
            @Result(column = "createUserName", property = "createUserName"),
            @Result(column = "modifyUserName", property = "modifyUserName"),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "modifyUserId", property = "modifyUserId"),
            @Result(column = "departmentName", property = "departmentName"),
            @Result(column = "createTime", property = "createTime", javaType = Timestamp.class, jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "modifyTime", property = "modifyTime", javaType = Timestamp.class, jdbcType = JdbcType.TIMESTAMP)
    })
    List<SupportFile> selectList(@Param("supportFile") SupportFile supportFile);

    @Insert("INSERT INTO pinggu_support_file_modify (supportFileModifyId, userId, supportFileId, modifyFlag) VALUES (#{supportFileModifyId}, #{userId}, #{supportFileId}, 1)")
    boolean insertModify(SupportFileModify supportFileModify);

    @Update("UPDATE pinggu_support_file SET deleteFlag=1 WHERE supportFileId=#{value}")
    boolean delete(String id);

    @Select("SELECT supportFileId, supportFileName, supportFileDbName, supportFilePath FROM pinggu_support_file WHERE supportFileId=#{value}")
    @Results({
            @Result(id = true, column = "supportFileId", property = "supportFileId"),
            @Result(column = "supportFileName", property = "supportFileName"),
            @Result(column = "supportFileDbName", property = "supportFileDbName"),
            @Result(column = "supportFilePath", property = "supportFilePath")
    })
    SupportFile selectFileFullPathFile(String fileId);
}
