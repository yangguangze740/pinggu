package com.zhulin.bus.service.problem.impl;

import com.zhulin.bus.bean.Problem;
import com.zhulin.bus.mapper.problem.ProblemMapper;
import com.zhulin.bus.service.problem.ProblemServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemServiceI {

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public List<Problem> appReadList(Problem problem) {
        return problemMapper.selectList(problem);
    }

    @Override
    public Problem appReadDetail(String id) {
        return problemMapper.selectDetail(id);
    }

    @Transactional
    @Override
    public boolean appUpdate(Problem problem) {
        return problemMapper.update(problem);
    }

    @Transactional
    @Override
    public boolean appDelete(String id) {
        return problemMapper.delete(id);
    }

    @Transactional
    @Override
    public boolean appCreate(Problem problem) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        problem.setProblemId(id);

        return problemMapper.insert(problem);
    }

    @Override
    public List<Problem> readDepartmentProblem(String id) {
        return problemMapper.selectDepartmentProblem(id);
    }
}
