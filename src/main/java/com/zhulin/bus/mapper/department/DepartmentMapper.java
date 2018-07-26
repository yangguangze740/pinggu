package com.zhulin.bus.mapper.department;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.DepartmentProblem;
import com.zhulin.bus.bean.DepartmentType;
import com.zhulin.bus.bean.Type;
import com.zhulin.bus.bean.bi.DepartmentNumber;
import com.zhulin.bus.mapper.department.provider.DepartmentInsertProvider;
import com.zhulin.framework.mapper.ArcMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMapper extends ArcMapper<Department>{
    @Select("SELECT departmentId, departmentName, departmentCreateTime, adminId, departmentSort, lockFlag, typeFlag FROM pinggu_department ORDER BY departmentSort ASC")
    @Results({
            @Result(id = true, column = "departmentId", property = "departmentId"),
            @Result(column = "departmentName", property = "departmentName"),
            @Result(column = "departmentCreateTime", property = "departmentCreateTime"),
            @Result(column = "adminId", property = "adminId"),
            @Result(column = "departmentSort", property = "departmentSort"),
            @Result(column = "lockFlag", property = "lockFlag"),
            @Result(column = "typeFlag", property = "typeFlag")
    })
    List<Department> selectList(Department department);

    @Insert("INSERT INTO pinggu_department (departmentId, departmentName, adminId, departmentSort, typeFlag) VALUES (#{departmentId}, #{departmentName}, #{adminId}, #{departmentSort}, #{typeFlag})")
    int insertDepartment(Department department);

    @InsertProvider(type = DepartmentInsertProvider.class, method = "insertDepartmentTypes")
    int insertDepartmentType(@Param("list") List<DepartmentType> departmentTypes);

    @Delete("DELETE FROM pinggu_department WHERE departmentId = #{value}")
    int deleteDepartment(String id);

    @Delete("DELETE FROM pinggu_department_type WHERE departmentId = #{value}")
    int deleteDepartmentType(String id);

    @Update("UPDATE pinggu_department SET departmentName=#{departmentName}, departmentSort=#{departmentSort}, typeFlag=#{typeFlag} WHERE departmentId=#{departmentId}")
    int updateDepartment(Department department);

    @Select("SELECT departmentId, departmentName, departmentCreateTime, adminId, lockFlag, departmentSort, typeFlag FROM pinggu_department WHERE departmentId=#{value}")
    @Results({
            @Result(id = true, column = "departmentId", property = "departmentId"),
            @Result(column = "departmentName", property = "departmentName"),
            @Result(column = "departmentCreateTime", property = "departmentCreateTime"),
            @Result(column = "adminId", property = "adminId"),
            @Result(column = "departmentSort", property = "departmentSort"),
            @Result(column = "lockFlag", property = "lockFlag"),
            @Result(column = "typeFlag", property = "typeFlag")
    })
    Department selectDetail(String id);

    @Delete("DELETE FROM pinggu_problem_department WHERE departmentId = #{value}")
    int deleteDepartmentProblems(String departmentId);

    @InsertProvider(type = DepartmentInsertProvider.class, method = "insertDepartmentProblems")
    int insertDepartmentProblems(List<DepartmentProblem> departmentProblems);

    @Select("SELECT COUNT(1) AS number FROM pinggu_rater_file WHERE deleteFlag=0 group by departmentId")
    @Results({
            @Result(column = "departmentName", property = "name"),
            @Result(column = "number", property = "number")
    })
    List<DepartmentNumber> selectDepartmentList();

    @Select("SELECT departmentId, departmentName FROM pinggu_department WHERE departmentId IN (SELECT departmentId FROM pinggu_rater_file_user_department WHERE fileUserId = #{value}) AND deleteFlag=0")
    @Results({
            @Result(id = true, column = "departmentId", property = "departmentId"),
            @Result(column = "departmentName", property = "departmentName")
    })
    List<Department> selectHaveList(String id);

    @Select("SELECT departmentId, departmentName FROM pinggu_department WHERE departmentId IN (SELECT departmentId FROM pinggu_support_file_user_department WHERE fileUserId = #{value}) AND deleteFlag=0")
    @Results({
            @Result(id = true, column = "departmentId", property = "departmentId"),
            @Result(column = "departmentName", property = "departmentName")
    })
    List<Department> selectHaveSupportDepartments(String id);

    @Select("SELECT typeId, typeName FROM pinggu_type WHERE typeId IN (SELECT typeId FROM pinggu_rater_file_user_type WHERE fileUserId = #{value}) AND deleteFlag=0")
    @Results({
            @Result(id = true, column = "typeId", property = "typeId"),
            @Result(column = "typeName", property = "typeName")
    })
    List<Type> selectHaveTypes(String id);
}
