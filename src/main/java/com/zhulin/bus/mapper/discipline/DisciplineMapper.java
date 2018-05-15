package com.zhulin.bus.mapper.discipline;

import com.zhulin.bus.bean.Discipline;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface DisciplineMapper extends ArcMapper<Discipline>{

    @Select("SELECT disciplineId, disciplineName, D.collegeId, D.createUserId, D.createTime, D.lockFlag, C.collegeName FROM pinggu_college_structure_discipline D LEFT JOIN pinggu_college_structure_college C ON C.collegeId=D.collegeId WHERE D.deleteFlag=0")
    @Results({
            @Result(id = true, column = "disciplineId", property = "disciplineId"),
            @Result(column = "disciplineName", property = "disciplineName"),
            @Result(column = "collegeId", property = "collegeId"),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "lockFlag", property = "lockFlag", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(column = "collegeName", property = "collegeName")
    })
    List<Discipline> selectList(Discipline discipline);

    @Select("SELECT disciplineId, disciplineName, D.collegeId, D.createUserId, D.createTime, D.lockFlag, C.collegeName FROM pinggu_college_structure_discipline D LEFT JOIN pinggu_college_structure_college C ON C.collegeId=D.collegeId WHERE disciplineId=#{value}")
    @Results({
            @Result(id = true, column = "disciplineId", property = "disciplineId"),
            @Result(column = "disciplineName", property = "disciplineName"),
            @Result(column = "collegeId", property = "collegeId"),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "lockFlag", property = "lockFlag", jdbcType = JdbcType.TINYINT, javaType = Integer.class),
            @Result(column = "collegeName", property = "collegeName")
    })
    Discipline selectDetail(String id);

    @Update("UPDATE pinggu_college_structure_discipline SET disciplineName=#{disciplineName}, collegeId=#{collegeId} WHERE disciplineId=#{disciplineId}")
    boolean update(Discipline discipline);

    @Update("UPDATE pinggu_college_structure_discipline SET deleteFlag=1 WHERE disciplineId=#{value}")
    boolean delete(String id);

    @Insert("INSERT INTO pinggu_college_structure_discipline (disciplineId, disciplineName, collegeId, createUserId) VALUES (#{disciplineId}, #{disciplineName}, #{collegeId}, #{createUserId})")
    boolean insert(Discipline discipline);
}
