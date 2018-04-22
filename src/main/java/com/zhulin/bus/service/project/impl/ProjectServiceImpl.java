package com.zhulin.bus.service.project.impl;

import com.zhulin.bus.bean.Project;
import com.zhulin.bus.mapper.project.ProjectMapper;
import com.zhulin.bus.service.project.ProjectServiceI;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectServiceI{

    @Autowired
    private ProjectMapper projectMapper;

    @MethodRolePermission(group = "supportFile", name = "审核项目查看", value = "project:fr", groupName = "审核项目管理组")
    @Override
    public List<Project> appReadList(Project project) {
        return projectMapper.selectList(project);
    }

    @MethodRolePermission(group = "supportFile", name = "审核项目详细", value = "project:fd", groupName = "审核项目管理组")
    @Override
    public Project appReadDetail(String id) {
        return projectMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "supportFile", name = "审核项目编辑", value = "project:fe", groupName = "审核项目管理组")
    @Transactional
    @Override
    public boolean appUpdate(Project project) {
        return projectMapper.update(project);
    }

    @MethodRolePermission(group = "supportFile", name = "审核项目删除", value = "project:fd", groupName = "审核项目管理组")
    @Transactional
    @Override
    public boolean appDelete(String id) {
        return projectMapper.delete(id);
    }

    @MethodRolePermission(group = "supportFile", name = "审核项目添加", value = "project:fc", groupName = "审核项目管理组")
    @Transactional
    @Override
    public boolean appCreate(Project project) {

        String primaryKey = PrimaryKeyUtil.uuidPrimaryKey();
        project.setProjectId(primaryKey);

        return projectMapper.insert(project);
    }
}
