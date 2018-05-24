package com.zhulin.bus.mapper.bi.support;


import com.zhulin.bus.bean.bi.SupportFileNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentSupportFileBiMapper {

    @Select("SELECT IFNULL(A.number, 0) AS number FROM (SELECT COUNT(1) AS number, SF.departmentId FROM pinggu_support_file SF LEFT JOIN pinggu_department D ON SF.departmentId = D.departmentId GROUP BY SF.departmentId ORDER BY D.departmentSort) AS A RIGHT JOIN pinggu_department AS B ON A.departmentId = B.departmentId ORDER BY b.departmentSort")
    @Results({
            @Result(column = "number", property = "number")
    })
    List<SupportFileNumber> selectDepartmentFileNumber();

    @Select("SELECT IFNULL(A.number, 0) AS number, B.departmentName FROM (SELECT COUNT(1) AS number, SF.departmentId FROM pinggu_support_file SF LEFT JOIN pinggu_review_project P ON SF.projectId = P.projectId LEFT JOIN pinggu_department D ON SF.departmentId = D.departmentId WHERE SF.projectId = #{projectId} GROUP BY SF.departmentId ORDER BY D.departmentSort) AS A RIGHT JOIN pinggu_department AS B ON A.departmentId = B.departmentId ORDER BY b.departmentSort")
    @Results({
            @Result(column = "number", property = "number")
    })
    List<SupportFileNumber> selectProjectFileNumber(String projectId);

    @Select("SELECT IFNULL(A.number, 0) AS number, B.departmentName FROM (SELECT COUNT(1) AS number, SF.departmentId FROM pinggu_support_file SF LEFT JOIN pinggu_review_element E ON SF.elementId = E.elementId LEFT JOIN pinggu_department D ON SF.departmentId = D.departmentId WHERE SF.elementId = #{elementId} GROUP BY SF.departmentId ORDER BY D.departmentSort) AS A RIGHT JOIN pinggu_department AS B ON A.departmentId = B.departmentId ORDER BY b.departmentSort")
    @Results({
            @Result(column = "number", property = "number")
    })
    List<SupportFileNumber> selectElementNumber(String elementId);
}
