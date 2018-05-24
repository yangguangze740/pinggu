package com.zhulin.bus.service.bi.question;

import com.zhulin.bus.bean.Question;
import com.zhulin.bus.bean.bi.QuestionNumber;
import com.zhulin.bus.bean.bi.QuestionNumberBI;
import com.zhulin.framework.service.ArcService;

import java.util.List;
import java.util.Map;

public interface QuestionBiServiceI extends ArcService<Question>{
    Map<String, Object> queryData(QuestionNumber questionNumber);
}
