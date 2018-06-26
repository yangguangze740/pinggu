package com.zhulin.bus.mapper.file.rater;

import com.zhulin.bus.bean.RaterFile;
import com.zhulin.bus.bean.RaterFileModify;
import com.zhulin.bus.mapper.file.rater.provider.SelectRaterFileProvider;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.JdbcType;
import org.springframework.data.repository.query.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface RaterFileMapperI extends ArcMapper<RaterFile>{

    @SelectProvider(type = SelectRaterFileProvider.class, method = "selectRaterFile")
    @Results({
            @Result(id = true, column = "raterFileId", property = "raterFileId"),
            @Result(column = "raterFileName", property = "raterFileName"),
            @Result(column = "raterFileDbName", property = "raterFileDbName"),
            @Result(column = "raterFilePath", property = "raterFilePath"),
            @Result(column = "departmentId", property = "departmentId"),
            @Result(column = "userId", property = "userId"),
            @Result(column = "fileTypeFlag", property = "fileTypeFlag"),
            @Result(column = "raterFileCreateTime", property = "raterFileCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "departmentTypeId", property = "departmentTypeId"),
            @Result(column = "raterFileRemark", property = "raterFileRemark"),
            @Result(column = "createUserName", property = "createUserName"),
            @Result(column = "modifyUserName", property = "modifyUserName"),
            @Result(column = "departmentName", property = "departmentName"),
            @Result(column = "typeName", property = "departmentTypeName"),
            @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "modifyTime", property = "modifyTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class)
    })
    List<RaterFile> selectList(@Param("raterFile") RaterFile raterFile);

    @Select("SELECT raterFileId, raterFilePath, raterFileDbName, raterFileName FROM pinggu_rater_file WHERE raterFileId = #{value}")
    @Results({
            @Result(id = true, column = "raterFileId", property = "raterFileId"),
            @Result(column = "raterFilePath", property = "raterFilePath"),
            @Result(column = "raterFileDbName", property = "raterFileDbName"),
            @Result(column = "raterFileName", property = "raterFileName")
    })
    RaterFile selectRaterFileFullPathFile(String fileId);

    @Update("UPDATE pinggu_rater_file SET deleteFlag=1 WHERE raterFileId = #{value}")
    boolean delete(String id);

    @Insert("INSERT INTO pinggu_rater_file_modify (raterFileModifyId, userId, raterFileId, modifyFlag) VALUES (#{raterFileModifyId}, #{userId}, #{raterFileId}, 1)")
    boolean insertModify(RaterFileModify raterFileModify);
}
