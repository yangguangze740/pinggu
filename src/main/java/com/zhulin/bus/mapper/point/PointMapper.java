package com.zhulin.bus.mapper.point;


import com.zhulin.bus.bean.DutyDepartment;
import com.zhulin.bus.bean.Element;
import com.zhulin.bus.bean.Point;
import com.zhulin.bus.mapper.point.provider.PointInsertProvider;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;
@Mapper
public interface PointMapper extends ArcMapper<Point>{

    @Select("SELECT pointId,pointName,pointCreateTime,pointSort,P.deleteFlag,projectName,elementName,leadName FROM pinggu_review_point P LEFT JOIN pinggu_review_element E ON P.elementId = E.elementId LEFT JOIN pinggu_review_project D ON P.projectId = D.projectId LEFT JOIN pinggu_lead_department L ON P.leadDepartmentId = L.leadDepartmentId WHERE P.deleteFlag = 0 ORDER BY pointSort ASC")
    @Results({
            @Result(id = true, column = "pointId", property = "pointId"),
            @Result(column = "pointName", property = "pointName"),
            @Result(column = "pointCreateTime", property = "pointCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "pointSort", property = "pointSort", jdbcType = JdbcType.INTEGER, javaType = Integer.class),
            @Result(column = "deleteFlag", property = "deleteFlag"),
            @Result(column = "projectName", property = "projectName"),
            @Result(column = "elementName", property = "elementName"),
            @Result(column = "leadName", property = "leadName")
    })
    @Override
    List<Point> selectList(Point point);

    @Update("UPDATE pinggu_review_point SET pointName = #{pointName},pointSort = #{pointSort},projectId = #{projectId},elementId = #{elementId},leadDepartmentId = #{leadDepartmentId} WHERE pointId = #{pointId}")
    int updatePoint(Point point);

    @Select("SELECT pointId, pointName,pointSort, RP.projectId, RP.elementId, RE.elementName, leadDepartmentId FROM pinggu_review_point RP LEFT JOIN pinggu_review_element RE ON RE.elementId = RP.elementId WHERE pointId = #{value}")
    @Results({
            @Result(id = true, column = "pointId", property = "pointId"),
            @Result(column = "pointName", property = "pointName"),
            @Result(column = "pointSort", property = "pointSort"),
            @Result(column = "projectId", property = "projectId"),
            @Result(column = "elementId", property = "elementId"),
            @Result(column = "elementName", property = "elementName"),
            @Result(column = "c", property = "leadDepartmentId")
    })
    @Override
    Point selectDetail(String id);

    @Insert("INSERT INTO pinggu_review_point (pointId, pointName,pointCreateTime,pointSort,projectId,elementId,leadDepartmentId,adminId) VALUES (#{pointId}, #{pointName},#{pointCreateTime},#{pointSort},#{projectId},#{elementId},#{leadDepartmentId},#{adminId})")
    int insertPoint(Point point);

    @Delete("DELETE FROM pinggu_review_point WHERE pointId = #{value}")
    int pointDelete(String id);

    @InsertProvider(type = PointInsertProvider.class, method = "insertDutyDepartment")
    int insertDutyDepartment(@Param("list") List<DutyDepartment> DutyDepartments);

    @Delete("DELETE FROM pinggu_review_point_duty_department WHERE pointId = #{value}")
    int deleteDutyDepartment(String pointId);

    @Select("SELECT elementId, elementName FROM pinggu_review_element WHERE projectId = #{value} AND deleteFlag = 0")
    @Results({
            @Result(id = true, column = "elementId", property = "elementId"),
            @Result(column = "elementName", property = "elementName")
    })
    List<Element> selectElementByProject(String projectId);


    @Select("SELECT dutyDepartmentId, dutyName FROM pinggu_duty_department WHERE dutyDepartmentId IN (SELECT dutyDepartmentId FROM pinggu_review_point_duty_department WHERE pointId = #{value}) AND deleteFlag = 0")
    @Results({
            @Result(id = true, column = "dutyDepartmentId", property = "dutyDepartmentId"),
            @Result(column = "dutyName", property = "dutyName"),
    })
    List<Point> selectOldDepartments(String id);
}
