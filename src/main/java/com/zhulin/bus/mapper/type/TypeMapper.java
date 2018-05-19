package com.zhulin.bus.mapper.type;

import com.zhulin.bus.bean.Type;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TypeMapper extends ArcMapper<Type> {
    @Select("SELECT typeId, typeName, typeCreateTime, adminId, typeFileNumber FROM pinggu_type WHERE deleteFlag=0 ORDER BY typeId")
    @Results({
            @Result(id = true, column = "typeId", property = "typeId"),
            @Result(column = "typeName", property = "typeName"),
            @Result(column = "typeCreateTime", property = "typeCreateTime"),
            @Result(column = "adminId", property = "adminId"),
            @Result(column = "typeFileNumber", property = "typeFileNumber")
    })
    @Override
    List<Type> selectList(Type type);

    @Update("UPDATE pinggu_type SET typeName=#{typeName}, typeFileNumber=#{typeFileNumber} WHERE typeId=#{typeId}")
    @Override
    boolean update(Type type);

    @Select("SELECT typeId, typeName, typeCreateTime, adminId, typeFileNumber FROM pinggu_type WHERE typeId=#{value} AND deleteFlag=0")
    @Results({
            @Result(id = true, column = "typeId", property = "typeId"),
            @Result(column = "typeName", property = "typeName"),
            @Result(column = "typeCreateTime", property = "typeCreateTime"),
            @Result(column = "adminId", property = "adminId"),
            @Result(column = "typeFileNumber", property = "typeFileNumber")
    })
    @Override
    Type selectDetail(String id);

    @Insert("INSERT INTO pinggu_type (typeId, typeName, adminId, typeFileNumber) VALUES (#{typeId}, #{typeName}, #{adminId}, #{typeFileNumber})")
    @Override
    boolean insert(Type type);

    @Update("UPDATE pinggu_type SET deleteFlag=1 WHERE typeId=#{value}")
    @Override
    boolean delete(String id);

    @Select("SELECT typeId, typeName, typeCreateTime, adminId, typeFileNumber FROM pinggu_type WHERE typeId IN (SELECT typeId FROM pinggu_department_type WHERE departmentId = #{value}) AND deleteFlag=0")
    @Results({
            @Result(id = true, column = "typeId", property = "typeId"),
            @Result(column = "typeName", property = "typeName"),
            @Result(column = "typeCreateTime", property = "typeCreateTime"),
            @Result(column = "adminId", property = "adminId"),
            @Result(column = "typeFileNumber", property = "typeFileNumber")
    })
    List<Type> selectHaveList(String id);
}
