package com.zhulin.bus.service.bi.question.impl;

import com.zhulin.bus.bean.Question;
import com.zhulin.bus.bean.bi.QuestionNumber;
import com.zhulin.bus.bean.bi.QuestionNumberBI;
import com.zhulin.bus.mapper.bi.question.QuestionBiMapper;
import com.zhulin.bus.service.bi.question.QuestionBiServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionBiServiceImpl implements QuestionBiServiceI{

    @Autowired
    private QuestionBiMapper questionBiMapper;

    @Override
    public List<Question> appReadList(Question question) {
        return null;
    }

    @Override
    public Question appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(Question question) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return false;
    }

    @Override
    public boolean appCreate(Question question) {
        return false;
    }

    @Override
    public List<QuestionNumber> readDepartmentList(QuestionNumber questionNumber) {
        return questionBiMapper.selectDepartmentList(questionNumber);
    }

    @Override
    public List<QuestionNumber> readProjectList(QuestionNumber questionNumber) {
        return questionBiMapper.selectProjectList(questionNumber);
    }

    @Override
    public List<QuestionNumber> readElementList(QuestionNumber questionNumber) {
        return questionBiMapper.selectElementList(questionNumber);
    }

    @Override
    public List<QuestionNumberBI> readAllElement(QuestionNumberBI questionNumberBI) {
        return questionBiMapper.selectAllElement(questionNumberBI);
    }

    @Override
    public Integer queryDepartmentNumber(String departmentId) {
        return questionBiMapper.selectDepartmentNumberById(departmentId);
    }

    @Override
    public List<Integer> queryProjectNumberById(String projectId) {
        return questionBiMapper.selectProjectNumberById(projectId);
    }

    @Override
    public List<Integer> queryElementNumberById(String elementId) {
        return questionBiMapper.selectElementNumberById(elementId);
    }

}
