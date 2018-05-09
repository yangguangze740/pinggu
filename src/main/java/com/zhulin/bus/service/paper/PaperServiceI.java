package com.zhulin.bus.service.paper;

import com.zhulin.bus.bean.Paper;
import com.zhulin.bus.bean.Subject;
import com.zhulin.framework.service.ArcService;

import java.util.List;

public interface PaperServiceI extends ArcService<Paper>{
    List<Subject> querySubjectByDisciplineId(String disciplineId);
}
