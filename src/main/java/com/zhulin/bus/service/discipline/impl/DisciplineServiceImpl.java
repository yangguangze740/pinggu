package com.zhulin.bus.service.discipline.impl;

import com.zhulin.bus.bean.Discipline;
import com.zhulin.bus.mapper.discipline.DisciplineMapper;
import com.zhulin.bus.service.discipline.DisciplineServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ClassRolePermission(group = "paperFile", name = "专业管理", value = "discipline:m", menuValue = "/admin/discipline")
public class DisciplineServiceImpl implements DisciplineServiceI{

    @Autowired
    private DisciplineMapper disciplineMapper;

    @MethodRolePermission(group = "paperFile", name = "专业查看", value = "discipline:mr", groupName = "试卷文件组")
    @Override
    public List<Discipline> appReadList(Discipline discipline) {
        return disciplineMapper.selectList(discipline);
    }

    @MethodRolePermission(group = "paperFile", name = "专业查看详细", value = "discipline:mr", groupName = "试卷文件组")
    @Override
    public Discipline appReadDetail(String id) {
        return disciplineMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "paperFile", name = "专业编辑", value = "discipline:mu", groupName = "试卷文件组")
    @Override
    public boolean appUpdate(Discipline discipline) {
        return disciplineMapper.update(discipline);
    }

    @MethodRolePermission(group = "paperFile", name = "专业删除", value = "discipline:md", groupName = "试卷文件组")
    @Override
    public boolean appDelete(String id) {
        return disciplineMapper.delete(id);
    }

    @MethodRolePermission(group = "paperFile", name = "专业添加", value = "discipline:mc", groupName = "试卷文件组")
    @Override
    public boolean appCreate(Discipline discipline) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        discipline.setDisciplineId(id);

        return disciplineMapper.insert(discipline);
    }
}
