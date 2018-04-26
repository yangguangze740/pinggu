package com.zhulin.bus.mapper.element;

import com.zhulin.bus.bean.Element;
import com.zhulin.bus.bean.Point;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ElementMapper extends ArcMapper<Element> {
    @Select("SELECT elementId,projectName,elementName,elementCreateTime,E.elementSort,E.deleteFlag FROM pinggu_review_element E LEFT JOIN pinggu_review_project P ON E.projectId = P.projectId WHERE E.deleteFlag = 0 ORDER BY elementSort ASC")
    @Results({
            @Result(id = true, column = "elementId", property = "elementId"),
            @Result(column = "projectName", property = "projectName"),
            @Result(column = "elementName", property = "elementName"),
            @Result(column = "elementCreateTime", property = "elementCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "elementSort", property = "elementSort"),
            @Result(column = "deleteFlag", property = "deleteFlag")
    })
    @Override
    List<Element> selectList(Element project);

    @Update("UPDATE pinggu_review_element SET projectId = #{projectId},elementName = #{elementName},elementSort = #{elementSort} WHERE elementId = #{elementId}")
    @Override
    boolean update(Element project);

    @Select("SELECT elementId, projectId,elementName,elementSort FROM pinggu_review_element WHERE elementId = #{value}")
    @Results({
            @Result(id = true, column = "elementId", property = "elementId"),
            @Result(column = "projectId", property = "projectId"),
            @Result(column = "elementName", property = "elementName"),
            @Result(column = "elementSort", property = "elementSort")
    })
    @Override
    Element selectDetail(String id);

    @Insert("INSERT INTO pinggu_review_element (elementId, projectId,elementCreateTime,elementName,elementSort,adminId) VALUES (#{elementId}, #{projectId},#{elementCreateTime},#{elementName},#{elementSort},#{adminId})")
    @Override
    boolean insert(Element project);

    @Delete("DELETE FROM pinggu_review_element WHERE elementId = #{value}")
    @Override
    boolean delete(String id);

    @Select("SELECT elementId, elementName FROM pinggu_review_element WHERE projectId = #{projectId} AND deleteFlag = 0 ORDER BY elementSort")
    @Results({
            @Result(id = true, column = "elementId", property = "elementId"),
            @Result(column = "elementName", property = "elementName")
    })
    List<Element> selectProjectElements(String projectId);

    @Select("SELECT pointId, pointName FROM pinggu_review_point WHERE elementId = #{elementId} AND deleteFlag = 0 ")
    @Results({
            @Result(id = true, column = "pointId", property = "pointId"),
            @Result(column = "pointName", property = "pointName")
    })
    List<Point> selectPointProject(String elementId);
}
