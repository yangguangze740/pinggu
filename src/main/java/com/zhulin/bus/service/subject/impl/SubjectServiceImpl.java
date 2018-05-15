package com.zhulin.bus.service.subject.impl;

import com.zhulin.bus.bean.Discipline;
import com.zhulin.bus.bean.Subject;
import com.zhulin.bus.mapper.subject.SubjectMapper;
import com.zhulin.bus.service.subject.SubjectServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ClassRolePermission(group = "paperFile", name = "课程管理", value = "subject:m", menuValue = "/admin/subject")
public class SubjectServiceImpl implements SubjectServiceI{

    @Autowired
    private SubjectMapper subjectMapper;

    @MethodRolePermission(group = "paperFile", name = "课程查看", value = "subject:mr", groupName = "试卷文件组")
    @Override
    public List<Subject> appReadList(Subject subject) {
        return subjectMapper.selectList(subject);
    }

    @MethodRolePermission(group = "paperFile", name = "课程查看详细", value = "subject:mr", groupName = "试卷文件组")
    @Override
    public Subject appReadDetail(String id) {
        return subjectMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "paperFile", name = "课程编辑", value = "subject:mu", groupName = "试卷文件组")
    @Override
    public boolean appUpdate(Subject subject) {
        return subjectMapper.update(subject);
    }

    @MethodRolePermission(group = "paperFile", name = "课程删除", value = "subject:md", groupName = "试卷文件组")
    @Override
    public boolean appDelete(String id) {
        return subjectMapper.delete(id);
    }

    @MethodRolePermission(group = "paperFile", name = "课程添加", value = "subject:mc", groupName = "试卷文件组")
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
