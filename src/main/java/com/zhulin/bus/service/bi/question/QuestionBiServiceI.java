package com.zhulin.bus.service.bi.question;

import com.zhulin.bus.bean.Question;
import com.zhulin.bus.bean.bi.QuestionNumber;
import com.zhulin.bus.bean.bi.QuestionNumberBI;
import com.zhulin.framework.service.ArcService;

import java.util.List;

public interface QuestionBiServiceI extends ArcService<Question>{
    List<QuestionNumber> readDepartmentList(QuestionNumber questionNumber);

    List<QuestionNumber> readProjectList(QuestionNumber questionNumber);

    List<QuestionNumber> readElementList(QuestionNumber questionNumber);

    List<QuestionNumberBI> readAllElement(QuestionNumberBI questionNumberBI);

    Integer queryDepartmentNumber(String departmentId);

    List<Integer> queryProjectNumberById(String projectId);

    List<Integer> queryElementNumberById(String elementId);
}
