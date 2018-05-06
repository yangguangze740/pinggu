package com.zhulin.bus.mapper.subject;

import com.zhulin.bus.bean.Discipline;
import com.zhulin.bus.bean.Subject;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface SubjectMapper extends ArcMapper<Subject>{

    @Select("SELECT subjectId, subjectName, S.disciplineId, S.createUserId, S.createTime, S.collegeId, D.disciplineName, C.collegeName FROM pinggu_college_structure_subject S LEFT JOIN pinggu_college_structure_discipline D ON D.disciplineId=S.disciplineId LEFT JOIN pinggu_college_structure_college C ON C.collegeId=S.collegeId WHERE S.deleteFlag=0")
    @Results({
            @Result(id = true, column = "subjectId", property = "subjectId"),
            @Result(column = "subjectName", property = "subjectName"),
            @Result(column = "disciplineId", property = "disciplineId"),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "collegeId", property = "collegeId"),
            @Result(column = "disciplineName", property = "disciplineName"),
            @Result(column = "collegeName", property = "collegeName")
    })
    List<Subject> selectList(Subject subject);

    @Select("SELECT subjectId, subjectName, S.disciplineId, S.createUserId, S.createTime, S.collegeId, D.disciplineName, C.collegeName FROM pinggu_college_structure_subject S LEFT JOIN pinggu_college_structure_discipline D ON D.disciplineId=S.disciplineId LEFT JOIN pinggu_college_structure_college C ON C.collegeId=S.collegeId WHERE subjectId=#{value}")
    @Results({
            @Result(id = true, column = "subjectId", property = "subjectId"),
            @Result(column = "subjectName", property = "subjectName"),
            @Result(column = "disciplineId", property = "disciplineId"),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "createTime", property = "createTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "collegeId", property = "collegeId"),
            @Result(column = "disciplineName", property = "disciplineName"),
            @Result(column = "collegeName", property = "collegeName")
    })
    Subject selectDetail(String id);

    @Update("UPDATE pinggu_college_structure_subject SET subjectName=#{subjectName}, disciplineId=#{disciplineId}, collegeId=#{collegeId} WHERE subjectId=#{subjectId}")
    boolean update(Subject subject);

    @Update("UPDATE pinggu_college_structure_subject SET deleteFlag=1 WHERE subjectId=#{value}")
    boolean delete(String id);

    @Insert("INSERT INTO pinggu_college_structure_subject (subjectId, subjectName, disciplineId, createUserId, collegeId) VALUES (#{subjectId}, #{subjectName}, #{disciplineId}, #{createUserId}, #{collegeId})")
    boolean insert(Subject subject);

    @Select("SELECT disciplineId, disciplineName FROM pinggu_college_structure_discipline WHERE collegeId=#{value} AND deleteFlag=0")
    @Results({
            @Result(column = "disciplineId", property = "disciplineId"),
            @Result(column = "disciplineName", property = "disciplineName")
    })
    List<Discipline> selectDiscipline(String collegeId);
}
