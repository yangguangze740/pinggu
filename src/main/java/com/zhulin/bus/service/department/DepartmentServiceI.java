package com.zhulin.bus.service.department;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.bi.DepartmentNumber;
import com.zhulin.framework.service.ArcService;

import java.util.List;

public interface DepartmentServiceI extends ArcService<Department>{
    boolean updateProblem(Department department);

    List<DepartmentNumber> selectDepartmentFileNumber();

}
