package com.zhulin.bus.mapper.lead;

import com.zhulin.bus.bean.Lead;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LeadMapper extends ArcMapper<Lead>{

    @Override
    @Select("SELECT leadDepartmentId, leadName, leadCreateTime, adminId, lockFlag FROM pinggu_lead_department WHERE deleteFlag=0")
    @Results({
            @Result(id = true, column = "leadDepartmentId", property = "leadDepartmentId"),
            @Result(column = "leadName", property = "leadName"),
            @Result(column = "leadCreateTime", property = "leadCreateTime"),
            @Result(column = "adminId", property = "adminId"),
            @Result(column = "lockFlag", property = "lockFlag")
    })
    List<Lead> selectList(Lead lead);

    @Override
    @Update("UPDATE pinggu_lead_department SET leadName=#{leadName} WHERE leadDepartmentId=#{leadDepartmentId}")
    boolean update(Lead lead);

    @Override
    @Select("SELECT leadDepartmentId, leadName, leadCreateTime, adminId, lockFlag FROM pinggu_lead_department WHERE leadDepartmentId=#{leadDepartmentId}")
    @Results({
            @Result(id = true, column = "leadDepartmentId", property = "leadDepartmentId"),
            @Result(column = "leadName", property = "leadName"),
            @Result(column = "leadCreateTime", property = "leadCreateTime"),
            @Result(column = "adminId", property = "adminId"),
            @Result(column = "lockFlag", property = "lockFlag")
    })
    Lead selectDetail(String id);

    @Override
    @Insert("INSERT INTO pinggu_lead_department (leadDepartmentId, leadName, adminId) VALUES (#{leadDepartmentId}, #{leadName}, #{adminId})")
    boolean insert(Lead lead);

    @Override
    @Update("UPDATE pinggu_lead_department SET deleteFlag=1 WHERE leadDepartmentId=#{value}")
    boolean delete(String id);
}
