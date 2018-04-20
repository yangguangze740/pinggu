package com.zhulin.bus.mapper.lead;

import com.zhulin.bus.bean.Lead;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LeadMapper extends ArcMapper<Lead>{
    @Override
    @Select("SELECT leadId, leadName, leadCreateTime, adminId, lockFlag FROM pinggu_lead WHERE deleteFlag=0")
    @Results({
            @Result(id = true, column = "leadId", property = "leadId"),
            @Result(column = "leadName", property = "leadName"),
            @Result(column = "leadCreateTime", property = "leadCreateTime"),
            @Result(column = "adminId", property = "adminId"),
            @Result(column = "lockFlag", property = "lockFlag")
    })
    List<Lead> selectList(Lead lead);

    @Override
    @Update("UPDATE pinggu_lead SET leadName=#{leadName} WHERE leadId=#{leadId}")
    boolean update(Lead lead);

    @Override
    @Select("SELECT leadId, leadName, leadCreateTime, adminId, lockFlag FROM pinggu_lead WHERE leadId=#{leadId}")
    @Results({
            @Result(id = true, column = "leadId", property = "leadId"),
            @Result(column = "leadName", property = "leadName"),
            @Result(column = "leadCreateTime", property = "leadCreateTime"),
            @Result(column = "adminId", property = "adminId"),
            @Result(column = "lockFlag", property = "lockFlag")
    })
    Lead selectDetail(String id);

    @Override
    @Insert("INSERT INTO pinggu_lead (leadId, leadName, adminId) VALUES (#{leadId}, #{leadName}, #{adminId})")
    boolean insert(Lead lead);

    @Override
    @Update("UPDATE pinggu_lead SET deleteFlag=1 WHERE leadId=#{value}")
    boolean delete(String id);
}
