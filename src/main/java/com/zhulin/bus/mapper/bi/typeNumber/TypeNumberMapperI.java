package com.zhulin.bus.mapper.bi.typeNumber;

import com.zhulin.bus.bean.Type;
import com.zhulin.bus.bean.bi.DepartmentTypeNumber;
import com.zhulin.bus.bean.bi.TempTypeNumber;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface TypeNumberMapperI extends ArcMapper<TempTypeNumber>{

    @Select("SELECT typeName, number FROM (SELECT COUNT(1) AS number, departmentTypeId FROM pinggu_rater_file WHERE departmentId=#{value} AND deleteFlag=0 group by departmentTypeId) AS TMP LEFT JOIN pinggu_type ON pinggu_type.typeId = TMP.departmentTypeId order by typeId")
    @Results({
            @Result(column = "typeName", property = "name"),
            @Result(column = "number", property = "number")
    })
    List<TempTypeNumber> selectNumber(String departmentId);

    @Select("SELECT departmentName FROM pinggu_department WHERE lockFlag=0")
    @Results({
            @Result(column = "departmentName", property = "name")
    })
    List<DepartmentTypeNumber> selectDepartmentList(DepartmentTypeNumber departmentTypeNumber);

    @Select("SELECT typeId, typeName, typeFileNumber FROM pinggu_type WHERE deleteFlag=0 AND lockFlag=0")
    @Results({
            @Result(id = true, column = "typeId", property = "typeId"),
            @Result(column = "typeName", property = "typeName"),
            @Result(column = "typeFileNumber", property = "typeFileNumber", jdbcType = JdbcType.TINYINT, javaType = Integer.class)
    })
    List<Type> selectTypeList(Type type);

    @Select("SELECT departmentName FROM pinggu_department WHERE departmentId=#{value}")
    @Results({
            @Result(column = "departmentName", property = "name")
    })
    DepartmentTypeNumber selectDepartmentName(String departmentId);

    @Select("SELECT typeName FROM pinggu_type WHERE deleteFlag=0 AND lockFlag=0 ORDER BY typeId")
    @Results({
            @Result(column = "typeName", property = "name")
    })
    List<DepartmentTypeNumber> selectTypeName(DepartmentTypeNumber departmentTypeNumber);
}
