package com.zhulin.bus.mapper.project;


import com.zhulin.bus.bean.Project;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ProjectMapper extends ArcMapper<Project>{

    @Select("SELECT projectId,projectName,projectCreateTime,deleteFlag,projectSort FROM pinggu_review_project where deleteFlag = 0")
    @Results({
            @Result(id = true, column = "projectId", property = "projectId"),
            @Result(column = "projectName", property = "projectName"),
            @Result(column = "projectCreateTime", property = "projectCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "deleteFlag", property = "deleteFlag"),
            @Result(column = "projectSort", property = "projectSort")
    })
    @Override
    List<Project> selectList(Project project);

    @Update("UPDATE pinggu_review_project SET projectName = #{projectName}, projectSort = #{projectSort} WHERE projectId = #{projectId}")
    @Override
    boolean update(Project project);

    @Select("SELECT projectId, projectName,projectSort FROM pinggu_review_project WHERE projectId = #{value}")
    @Results({
            @Result(id = true, column = "projectId", property = "projectId"),
            @Result(column = "projectName", property = "projectName"),
            @Result(column = "projectSort", property = "projectSort")
    })
    @Override
    Project selectDetail(String id);

    @Insert("INSERT INTO pinggu_review_project (projectId, projectName,projectCreateTime,projectSort,adminId) VALUES (#{projectId}, #{projectName},#{projectCreateTime},#{projectSort},#{adminId})")
    @Override
    boolean insert(Project project);

    @Delete("DELETE FROM pinggu_review_project WHERE projectId = #{value}")
    @Override
    boolean delete(String id);
}
