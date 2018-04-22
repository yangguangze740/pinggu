package com.zhulin.bus.service.problem.impl;

import com.zhulin.bus.bean.Problem;
import com.zhulin.bus.mapper.problem.ProblemMapper;
import com.zhulin.bus.service.problem.ProblemServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ClassRolePermission(group = "problem", name = "问题管理", value = "problem:m", menuValue = "/admin/problem")
@Service
public class ProblemServiceImpl implements ProblemServiceI {

    @Autowired
    private ProblemMapper problemMapper;

    @MethodRolePermission(group = "problem", name = "问题查看", value = "problem:mr", groupName = "问题组")
    @Override
    public List<Problem> appReadList(Problem problem) {
        return problemMapper.selectList(problem);
    }

    @MethodRolePermission(group = "problem", name = "问题详细", value = "problem:mr", groupName = "问题组")
    @Override
    public Problem appReadDetail(String id) {
        return problemMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "problem", name = "问题编辑", value = "problem:mu", groupName = "问题组")
    @Transactional
    @Override
    public boolean appUpdate(Problem problem) {
        return problemMapper.update(problem);
    }

    @MethodRolePermission(group = "problem", name = "问题删除", value = "problem:md", groupName = "问题组")
    @Transactional
    @Override
    public boolean appDelete(String id) {
        return problemMapper.delete(id);
    }

    @MethodRolePermission(group = "problem", name = "问题添加", value = "problem:mc", groupName = "问题组")
    @Transactional
    @Override
    public boolean appCreate(Problem problem) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        problem.setProblemId(id);

        return problemMapper.insert(problem);
    }

    @MethodRolePermission(group = "problem", name = "问题查看", value = "problem:mr", groupName = "问题组")
    @Override
    public List<Problem> readDepartmentProblem(String id) {
        return problemMapper.selectDepartmentProblem(id);
    }
}
