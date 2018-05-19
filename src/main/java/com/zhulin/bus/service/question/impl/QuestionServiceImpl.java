package com.zhulin.bus.service.question.impl;

import com.zhulin.bus.bean.Question;
import com.zhulin.bus.mapper.question.QuestionMapper;
import com.zhulin.bus.service.question.QuestionServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@ClassRolePermission(group = "question", name = "问题清单管理角色", value = "question:m", menuValue = "/admin/question")
@Service
public class QuestionServiceImpl implements QuestionServiceI {

    @Autowired
    private QuestionMapper questionMapper;

    @MethodRolePermission(group = "question", name = "问题清单查看", value = "question:mr", groupName = "普通用户组")
    @Override
    public List<Question> appReadList(Question question) {
        return questionMapper.selectList(question);
    }

    @MethodRolePermission(group = "question", name = "问题清单查看", value = "question:mr", groupName = "普通用户组")
    @Override
    public Question appReadDetail(String id) {
        return questionMapper.selectDetail(id);
    }

    @Override
    public boolean appUpdate(Question question) {
        return false;
    }

    @MethodRolePermission(group = "question", name = "问题清单删除", value = "question:md", groupName = "普通用户组")
    @Override
    public boolean appDelete(String id) {
        return questionMapper.delete(id);
    }

    @Override
    public boolean appCreate(Question question) {
        return false;
    }
}
