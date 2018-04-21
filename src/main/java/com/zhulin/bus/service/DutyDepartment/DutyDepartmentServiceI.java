package com.zhulin.bus.service.DutyDepartment;


import com.zhulin.bus.bean.DutyDepartment;
import com.zhulin.framework.service.ArcService;

import java.util.List;

public interface DutyDepartmentServiceI extends ArcService<DutyDepartment> {
    List<DutyDepartment> haveDutyDepartments(String id);
}
