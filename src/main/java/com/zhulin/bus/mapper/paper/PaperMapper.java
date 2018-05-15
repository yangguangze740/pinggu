package com.zhulin.bus.mapper.paper;

import com.zhulin.bus.bean.Paper;
import com.zhulin.bus.bean.Subject;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface PaperMapper extends ArcMapper<Paper>{

    @Select("SELECT paperId, paperName, paperCreateTime, P.createUserId, P.subjectId, P.disciplineId, P.collegeId, S.subjectName, D.disciplineName, C.collegeName FROM pinggu_college_structure_paper P LEFT JOIN pinggu_college_structure_subject S ON S.subjectId=P.subjectId LEFT JOIN pinggu_college_structure_discipline D ON D.disciplineId=P.disciplineId LEFT JOIN pinggu_college_structure_college C ON C.collegeId=P.collegeId WHERE P.deleteFlag=0")
    @Results({
            @Result(id = true, column = "paperId", property = "paperId"),
            @Result(column = "paperName", property = "paperName"),
            @Result(column = "paperCreateTime", property = "paperCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "subjectId", property = "subjectId"),
            @Result(column = "disciplineId", property = "disciplineId"),
            @Result(column = "collegeId", property = "collegeId"),
            @Result(column = "subjectName", property = "subjectName"),
            @Result(column = "disciplineName", property = "disciplineName"),
            @Result(column = "collegeName", property = "collegeName")
    })
    List<Paper> selectList(Paper paper);

    @Select("SELECT paperId, paperName, paperCreateTime, P.createUserId, P.subjectId, P.disciplineId, P.collegeId, S.subjectName, D.disciplineName, C.collegeName FROM pinggu_college_structure_paper P LEFT JOIN pinggu_college_structure_subject S ON S.subjectId=P.subjectId LEFT JOIN pinggu_college_structure_discipline D ON D.disciplineId=P.disciplineId LEFT JOIN pinggu_college_structure_college C ON C.collegeId=P.collegeId WHERE paperId=#{value}")
    @Results({
            @Result(id = true, column = "paperId", property = "paperId"),
            @Result(column = "paperName", property = "paperName"),
            @Result(column = "paperCreateTime", property = "paperCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "subjectId", property = "subjectId"),
            @Result(column = "disciplineId", property = "disciplineId"),
            @Result(column = "collegeId", property = "collegeId"),
            @Result(column = "subjectName", property = "subjectName"),
            @Result(column = "disciplineName", property = "disciplineName"),
            @Result(column = "collegeName", property = "collegeName")
    })
    Paper selectDetail(String id);

    @Update("UPDATE pinggu_college_structure_paper SET paperName=#{paperName}, subjectId=#{subjectId}, disciplineId=#{disciplineId}, collegeId=#{collegeId} WHERE paperId=#{paperId}")
    boolean update(Paper paper);

    @Update("UPDATE pinggu_college_structure_paper SET deleteFlag=1 WHERE paperId=#{value}")
    boolean delete(String id);

    @Insert("INSERT INTO pinggu_college_structure_paper (paperId, paperName, createUserId, subjectId, disciplineId, collegeId) VALUES (#{paperId}, #{paperName}, #{createUserId}, #{subjectId}, #{disciplineId}, #{collegeId})")
    boolean insert(Paper paper);

    @Select("SELECT subjectId, subjectName FROM pinggu_college_structure_subject WHERE disciplineId=#{disciplineId} AND deleteFlag=0")
    @Results({
            @Result(column = "subjectId", property = "subjectId"),
            @Result(column = "subjectName", property = "subjectName")
    })
    List<Subject> selectSubjectId(String disciplineId);
}
