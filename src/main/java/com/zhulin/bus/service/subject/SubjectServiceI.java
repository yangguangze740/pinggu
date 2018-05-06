package com.zhulin.bus.service.subject;

import com.zhulin.bus.bean.Discipline;
import com.zhulin.bus.bean.Subject;
import com.zhulin.framework.service.ArcService;

import java.util.List;

public interface SubjectServiceI extends ArcService<Subject>{
    List<Discipline> queryDisciplineByCollegeId(String collegeId);
}
