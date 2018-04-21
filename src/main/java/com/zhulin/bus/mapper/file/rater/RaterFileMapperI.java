package com.zhulin.bus.mapper.file.rater;

import com.zhulin.bus.bean.RaterFile;
import com.zhulin.bus.bean.RaterFileModify;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface RaterFileMapperI extends ArcMapper<RaterFile>{

    @Select("SELECT raterFileId, raterFileName, raterFileDbName, raterFilePath, departmentId, userId, fileTypeFlag, raterFileCreateTime, departmentTypeId, raterFileRemark, deleteFlag FROM pinggu_rater_file WHERE deleteFlag=0")
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
            @Result(column = "raterFileRemark", property = "raterFileRemark")
    })
    List<RaterFile> selectList(RaterFile raterFile);

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
