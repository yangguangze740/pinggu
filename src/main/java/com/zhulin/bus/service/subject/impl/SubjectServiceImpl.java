package com.zhulin.bus.service.subject.impl;

import com.zhulin.bus.bean.Discipline;
import com.zhulin.bus.bean.Subject;
import com.zhulin.bus.mapper.subject.SubjectMapper;
import com.zhulin.bus.service.subject.SubjectServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectServiceI{

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Subject> appReadList(Subject subject) {
        return subjectMapper.selectList(subject);
    }

    @Override
    public Subject appReadDetail(String id) {
        return subjectMapper.selectDetail(id);
    }

    @Override
    public boolean appUpdate(Subject subject) {
        return subjectMapper.update(subject);
    }

    @Override
    public boolean appDelete(String id) {
        return subjectMapper.delete(id);
    }

    @Override
    public boolean appCreate(Subject subject) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        subject.setSubjectId(id);

        return subjectMapper.insert(subject);
    }

    @Override
    public List<Discipline> queryDisciplineByCollegeId(String collegeId) {
        return subjectMapper.selectDiscipline(collegeId);
    }
}
