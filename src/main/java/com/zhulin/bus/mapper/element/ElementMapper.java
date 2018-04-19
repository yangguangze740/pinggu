package com.zhulin.bus.mapper.element;

import com.zhulin.bus.bean.Element;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ElementMapper extends ArcMapper<Element> {
    @Select("SELECT elementId,projectName,elementName,elementCreateTime,E.elementSort,E.deleteFlag FROM pinggu_element E LEFT JOIN pinggu_project P ON E.projectId = P.projectId WHERE E.deleteFlag = 0")
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

    @Update("UPDATE pinggu_element SET projectId = #{projectId},elementName = #{elementName},elementSort = #{elementSort} WHERE elementId = #{elementId}")
    @Override
    boolean update(Element project);

    @Select("SELECT elementId, projectId,elementName,elementSort FROM pinggu_element WHERE elementId = #{value}")
    @Results({
            @Result(id = true, column = "elementId", property = "elementId"),
            @Result(column = "projectId", property = "projectId"),
            @Result(column = "elementName", property = "elementName"),
            @Result(column = "elementSort", property = "elementSort")
    })
    @Override
    Element selectDetail(String id);

    @Insert("INSERT INTO pinggu_element (elementId, projectId,elementCreateTime,elementName,elementSort,adminId) VALUES (#{elementId}, #{projectId},#{elementCreateTime},#{elementName},#{elementSort},#{adminId})")
    @Override
    boolean insert(Element project);

    @Delete("DELETE FROM pinggu_element WHERE elementId = #{value}")
    @Override
    boolean delete(String id);
}
