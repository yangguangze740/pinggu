package com.zhulin.bus.mapper.college;

import com.zhulin.bus.bean.College;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface CollegeMapper extends ArcMapper<College>{

    @Select("SELECT collegeId, collegeName, createUserId, createTime, lockFlag FROM pinggu_college_structure_college WHERE deleteFlag=0")
    @Results({
            @Result(id = true, column = "collegeId", property = "collegeId"),
            @Result(column = "collegeName", property = "collegeName"),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "lockFlag", property = "lockFlag", jdbcType = JdbcType.TINYINT, javaType = Integer.class)
    })
    List<College> selectList(College college);

    @Select("SELECT collegeId, collegeName, createUserId, createTime, lockFlag FROM pinggu_college_structure_college WHERE collegeId=#{value}")
    @Results({
            @Result(id = true, column = "collegeId", property = "collegeId"),
            @Result(column = "collegeName", property = "collegeName"),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "lockFlag", property = "lockFlag", jdbcType = JdbcType.TINYINT, javaType = Integer.class)
    })
    College selectDetail(String id);

    @Update("UPDATE pinggu_college_structure_college SET collegeName=#{collegeName} WHERE collegeId=#{collegeId}")
    boolean update(College college);

    @Update("UPDATE pinggu_college_structure_college SET deleteFlag=1 WHERE collegeId=#{value}")
    boolean delete(String id);

    @Insert("INSERT INTO pinggu_college_structure_college (collegeId, collegeName, createUserId) VALUES (#{collegeId}, #{collegeName}, #{createUserId})")
    boolean insert(College college);
}
