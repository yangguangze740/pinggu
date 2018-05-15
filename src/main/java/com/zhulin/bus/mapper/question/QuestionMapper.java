package com.zhulin.bus.mapper.question;

import com.zhulin.bus.bean.Question;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface QuestionMapper extends ArcMapper<Question>{
    @Select("SELECT problemListId, L.projectId, L.elementId, problemContent, problemShow, problemModifyMeasure, problemPlanSolveTime, L.departmentId, problemCreateTime, projectName, elementName, departmentName, createUserId, userName FROM pinggu_problem_list L LEFT JOIN pinggu_review_project P ON L.projectId=P.projectId LEFT JOIN pinggu_review_element E ON L.elementId=E.elementId LEFT JOIN pinggu_department D ON L.departmentId=D.departmentId LEFT JOIN pinggu_general_user U ON L.createUserId=U.userId WHERE L.deleteFlag=0")
    @Results({
            @Result(id = true, column = "problemListId", property = "problemListId"),
            @Result(column = "projectId", property = "projectId"),
            @Result(column = "elementId", property = "elementId"),
            @Result(column = "problemContent", property = "problemContent"),
            @Result(column = "problemShow", property = "problemShow"),
            @Result(column = "problemModifyMeasure", property = "problemModifyMeasure"),
            @Result(column = "problemPlanSolveTime", property = "problemPlanSolveTime", jdbcType = JdbcType.DATE, javaType = Date.class),
            @Result(column = "departmentId", property = "departmentId"),
            @Result(column = "problemCreateTime", property = "problemCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "projectName", property = "projectName"),
            @Result(column = "elementName", property = "elementName"),
            @Result(column = "departmentName", property = "departmentName"),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "userName", property = "userName")
    })
    List<Question> selectList(Question question);

    @Delete("UPDATE pinggu_problem_list SET deleteFlag=1 WHERE problemListId=#{value}")
    boolean delete(String id);

    @Select("SELECT problemListId, L.projectId, L.elementId, problemContent, problemShow, problemModifyMeasure, problemPlanSolveTime, L.departmentId, problemCreateTime, projectName, elementName, departmentName, createUserId, userName, problemAnalysis, problemListRemark FROM pinggu_problem_list L LEFT JOIN pinggu_review_project P ON L.projectId=P.projectId LEFT JOIN pinggu_review_element E ON L.elementId=E.elementId LEFT JOIN pinggu_department D ON L.departmentId=D.departmentId LEFT JOIN pinggu_general_user U ON L.createUserId=U.userId WHERE L.problemListId=#{value}")
    @Results({
            @Result(id = true, column = "problemListId", property = "problemListId"),
            @Result(column = "projectId", property = "projectId"),
            @Result(column = "elementId", property = "elementId"),
            @Result(column = "problemContent", property = "problemContent"),
            @Result(column = "problemShow", property = "problemShow"),
            @Result(column = "problemModifyMeasure", property = "problemModifyMeasure"),
            @Result(column = "problemPlanSolveTime", property = "problemPlanSolveTime", jdbcType = JdbcType.DATE, javaType = Date.class),
            @Result(column = "departmentId", property = "departmentId"),
            @Result(column = "problemCreateTime", property = "problemCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "projectName", property = "projectName"),
            @Result(column = "elementName", property = "elementName"),
            @Result(column = "departmentName", property = "departmentName"),
            @Result(column = "createUserId", property = "createUserId"),
            @Result(column = "userName", property = "userName"),
            @Result(column = "problemAnalysis", property = "problemAnalysis"),
            @Result(column = "problemListRemark", property = "problemListRemark")
    })
    Question selectDetail(String id);
}
