package com.zhulin.bus.mapper.problem;

import com.zhulin.bus.bean.Problem;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProblemMapper extends ArcMapper<Problem>{
    @Select("SELECT problemId, problemContent, problemCreateTime, adminId, lockFlag FROM pinggu_problem")
    @Results({
            @Result(id = true, column = "problemId", property = "problemId"),
            @Result(column = "problemContent", property = "problemContent"),
            @Result(column = "problemCreateTime", property = "problemCreateTime"),
            @Result(column = "adminId", property = "adminId"),
            @Result(column = "lockFlag", property = "lockFlag")
    })
    @Override
    List<Problem> selectList(Problem problem);

    @Update("UPDATE pinggu_problem SET problemContent=#{problemContent} WHERE problemId=#{problemId}")
    @Override
    boolean update(Problem problem);

    @Select("SELECT problemId, problemContent, problemCreateTime, adminId, lockFlag FROM pinggu_problem WHERE problemId=#{value}")
    @Results({
            @Result(id = true, column = "problemId", property = "problemId"),
            @Result(column = "problemContent", property = "problemContent"),
            @Result(column = "problemCreateTime", property = "problemCreateTime"),
            @Result(column = "adminId", property = "adminId"),
            @Result(column = "lockFlag", property = "lockFlag")
    })
    @Override
    Problem selectDetail(String id);

    @Insert("INSERT INTO pinggu_problem (problemId, problemContent, adminId) VALUES (#{problemId}, #{problemContent}, #{adminId})")
    @Override
    boolean insert(Problem problem);

    @Delete("DELETE FROM pinggu_problem WHERE problemId=#{value}")
    @Override
    boolean delete(String id);

    @Select("SELECT problemId, problemContent, problemCreateTime, adminId, lockFlag FROM pinggu_problem WHERE problemId IN (SELECT problemId FROM pinggu_problem_department WHERE departmentId=#{value})")
    List<Problem> selectDepartmentProblem(String id);
}
