package com.zhulin.bus.mapper.bi.question;

import com.zhulin.bus.bean.Question;
import com.zhulin.bus.bean.bi.QuestionNumber;
import com.zhulin.bus.bean.bi.QuestionNumberBI;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionBiMapper extends ArcMapper<Question>{
    @Select("SELECT departmentName FROM pinggu_department ORDER BY departmentSort ASC")
    @Results({
            @Result(column = "departmentName", property = "name")
    })
    List<QuestionNumber> selectDepartmentList(QuestionNumber questionNumber);

    @Select("SELECT projectName FROM pinggu_review_project WHERE deleteFlag = 0 ORDER BY projectSort ASC")
    @Results({
            @Result(column = "projectName", property = "name")
    })
    List<QuestionNumber> selectProjectList(QuestionNumber questionNumber);

    @Select("SELECT elementName FROM pinggu_review_element WHERE deleteFlag = 0 ORDER BY elementSort ASC")
    @Results({
            @Result(column = "elementName", property = "name")
    })
    List<QuestionNumber> selectElementList(QuestionNumber questionNumber);

    @Select("SELECT elementId, elementName FROM pinggu_review_element WHERE deleteFlag = 0 ORDER BY elementSort ASC")
    @Results({
            @Result(id = true, column = "elementId", property = "id"),
            @Result(column = "elementName", property = "name")
    })
    List<QuestionNumberBI> selectAllElement(QuestionNumberBI questionNumberBI);

    @Select("SELECT COUNT(1) AS number FROM pinggu_problem_list WHERE departmentId=#{value} GROUP BY departmentId")
    Integer selectDepartmentNumberById(String departmentId);

    @Select("SELECT IFNULL(a.a,0) AS num \n" +
            "FROM (SELECT COUNT(*) AS a, a.departmentId AS b\n" +
            "FROM pinggu_department AS a LEFT JOIN pinggu_problem_list AS b ON a.departmentId=b.departmentId \n" +
            "WHERE b.projectId = #{projectId}\n" +
            "GROUP BY a.departmentId) AS a RIGHT JOIN pinggu_department AS b ON a.b = b.departmentId\n" +
            "ORDER BY b.departmentSort")
    List<Integer> selectProjectNumberById(String projectId);

    @Select("SELECT IFNULL(a.a,0) AS num \n" +
            "FROM (SELECT COUNT(*) AS a, a.departmentId AS b\n" +
            "FROM pinggu_department AS a LEFT JOIN pinggu_problem_list AS b ON a.departmentId=b.departmentId \n" +
            "WHERE b.elementId = #{elementId}\n" +
            "GROUP BY a.departmentId) AS a RIGHT JOIN pinggu_department AS b ON a.b = b.departmentId\n" +
            "ORDER BY b.departmentSort")
    List<Integer> selectElementNumberById(String elementId);
}
