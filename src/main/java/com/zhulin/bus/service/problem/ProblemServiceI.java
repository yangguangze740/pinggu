package com.zhulin.bus.service.problem;

import com.zhulin.bus.bean.Problem;
import com.zhulin.framework.service.ArcService;

import java.util.List;

public interface ProblemServiceI extends ArcService<Problem>{
    List<Problem> readDepartmentProblem(String id);
}
