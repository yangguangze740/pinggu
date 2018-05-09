package com.zhulin.bus.service.paper.impl;

import com.zhulin.bus.bean.Paper;
import com.zhulin.bus.bean.Subject;
import com.zhulin.bus.mapper.paper.PaperMapper;
import com.zhulin.bus.service.paper.PaperServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ClassRolePermission(group = "paperFile", name = "试卷管理", value = "paper:m", menuValue = "/admin/paper")
public class PaperServiceImpl implements PaperServiceI{

    @Autowired
    private PaperMapper paperMapper;

    @MethodRolePermission(group = "paperFile", name = "试卷查看", value = "paper:mr", groupName = "试卷文件组")
    @Override
    public List<Paper> appReadList(Paper paper) {
        return paperMapper.selectList(paper);
    }

    @MethodRolePermission(group = "paperFile", name = "试卷查看", value = "paper:mr", groupName = "试卷文件组")
    @Override
    public Paper appReadDetail(String id) {
        return paperMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "paperFile", name = "试卷编辑", value = "paper:mu", groupName = "试卷文件组")
    @Override
    public boolean appUpdate(Paper paper) {
        return paperMapper.update(paper);
    }

    @MethodRolePermission(group = "paperFile", name = "试卷删除", value = "paper:md", groupName = "试卷文件组")
    @Override
    public boolean appDelete(String id) {
        return paperMapper.delete(id);
    }

    @MethodRolePermission(group = "paperFile", name = "试卷添加", value = "paper:mc", groupName = "试卷文件组")
    @Override
    public boolean appCreate(Paper paper) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        paper.setPaperId(id);

        return paperMapper.insert(paper);
    }

    @Override
    public List<Subject> querySubjectByDisciplineId(String disciplineId) {
        return paperMapper.selectSubjectId(disciplineId);
    }
}
