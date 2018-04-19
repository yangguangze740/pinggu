package com.zhulin.bus.service.department;

import com.zhulin.bus.bean.Department;
import com.zhulin.framework.service.ArcService;

public interface DepartmentServiceI extends ArcService<Department>{
    boolean updateProblem(Department department);
}
