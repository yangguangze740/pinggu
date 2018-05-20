package com.zhulin.bus.mapper.dutyDepartment;

import com.zhulin.bus.bean.DutyDepartment;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface DutyDepartmentMapper extends ArcMapper<DutyDepartment>{
    @Select("SELECT dutyDepartmentId,dutyName,dutyCreateTime,deleteFlag,lockFlag FROM pinggu_duty_department where deleteFlag = 0")
    @Results({
            @Result(id = true, column = "dutyDepartmentId", property = "dutyDepartmentId"),
            @Result(column = "dutyName", property = "dutyName"),
            @Result(column = "dutyCreateTime", property = "dutyCreateTime", jdbcType = JdbcType.TIMESTAMP, javaType = Timestamp.class),
            @Result(column = "deleteFlag", property = "deleteFlag"),
            @Result(column = "lockFlag", property = "lockFlag")
    })
    @Override
    List<DutyDepartment> selectList(DutyDepartment dutyDepartment);

    @Update("UPDATE pinggu_duty_department SET dutyName = #{dutyName} WHERE dutyDepartmentId = #{dutyDepartmentId}")
    @Override
    boolean update(DutyDepartment dutyDepartment);

    @Select("SELECT dutyDepartmentId, dutyName FROM pinggu_duty_department WHERE dutyDepartmentId = #{value}")
    @Results({
            @Result(id = true, column = "dutyDepartmentId", property = "dutyDepartmentId"),
            @Result(column = "dutyName", property = "dutyName")
    })
    @Override
    DutyDepartment selectDetail(String id);

    @Insert("INSERT INTO pinggu_duty_department (dutyDepartmentId, dutyName,dutyCreateTime,adminId) VALUES (#{dutyDepartmentId}, #{dutyName},#{dutyCreateTime},#{adminId})")
    @Override
    boolean insert(DutyDepartment dutyDepartment);

    @Update("UPDATE pinggu_duty_department SET deleteFlag = '1' WHERE dutyDepartmentId = #{dutyDepartmentId}")
    @Override
    boolean delete(String id);

    @Select("SELECT dutyDepartmentId, dutyName FROM pinggu_duty_department WHERE dutyDepartmentId IN (SELECT dutyDepartmentId FROM pinggu_review_point_duty_department WHERE pointId = #{value}) AND deleteFlag = 0")
    @Results({
            @Result(id = true, column = "dutyDepartmentId", property = "dutyDepartmentId"),
            @Result(column = "dutyName", property = "dutyName"),
    })
    List<DutyDepartment> selectHaveDutyDepartments(String id);

    @Insert("INSERT INTO pinggu_duty_department (dutyDepartmentId, dutyName,dutyCreateTime,adminId, dutyAdd) VALUES (#{dutyDepartmentId}, #{dutyName},#{dutyCreateTime},#{adminId},#{dutyAdd})")
    int insertDepartment(DutyDepartment department);
}
