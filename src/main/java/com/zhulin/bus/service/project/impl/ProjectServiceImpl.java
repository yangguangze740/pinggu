package com.zhulin.bus.service.project.impl;

import com.zhulin.bus.bean.Project;
import com.zhulin.bus.mapper.project.ProjectMapper;
import com.zhulin.bus.service.project.ProjectServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectServiceI{

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> appReadList(Project project) {
        return projectMapper.selectList(project);
    }

    @Override
    public Project appReadDetail(String id) {
        return projectMapper.selectDetail(id);
    }

    @Override
    public boolean appUpdate(Project project) {
        return projectMapper.update(project);
    }

    @Override
    public boolean appDelete(String id) {
        return projectMapper.delete(id);
    }

    @Override
    public boolean appCreate(Project project) {

        String primaryKey = PrimaryKeyUtil.uuidPrimaryKey();
        project.setProjectId(primaryKey);

        return projectMapper.insert(project);
    }
}
