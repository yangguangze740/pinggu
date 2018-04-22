package com.zhulin.bus.service.DutyDepartment.impl;

import com.zhulin.bus.bean.DutyDepartment;
import com.zhulin.bus.mapper.dutyDepartment.DutyDepartmentMapper;
import com.zhulin.bus.service.DutyDepartment.DutyDepartmentServiceI;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DutyDepartmentServiceImpl implements DutyDepartmentServiceI{

    @Autowired
    private DutyDepartmentMapper dutyDepartmentMapper;

    @MethodRolePermission(group = "supportFile", name = "责任部门查看", value = "dutyDepartment:fr", groupName = "责任部门管理组")
    @Override
    public List<DutyDepartment> appReadList(DutyDepartment dutyDepartment) {
        return dutyDepartmentMapper.selectList(dutyDepartment);
    }

    @MethodRolePermission(group = "supportFile", name = "责任部门详细", value = "dutyDepartment:fd", groupName = "责任部门管理组")
    @Override
    public DutyDepartment appReadDetail(String id) {
        return dutyDepartmentMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "supportFile", name = "责任部门编辑", value = "dutyDepartment:fe", groupName = "责任部门管理组")
    @Transactional
    @Override
    public boolean appUpdate(DutyDepartment dutyDepartment) {
        return dutyDepartmentMapper.update(dutyDepartment);
    }

    @MethodRolePermission(group = "supportFile", name = "审责任部门删除", value = "dutyDepartment:fd", groupName = "责任部门管理组")
    @Transactional
    @Override
    public boolean appDelete(String id) {
        return dutyDepartmentMapper.delete(id);
    }

    @MethodRolePermission(group = "supportFile", name = "审责任部门添加", value = "dutyDepartment:fc", groupName = "责任部门管理组")
    @Transactional
    @Override
    public boolean appCreate(DutyDepartment dutyDepartment) {
        String primaryKey = PrimaryKeyUtil.uuidPrimaryKey();
        dutyDepartment.setDutyDepartmentId(primaryKey);

        return dutyDepartmentMapper.insert(dutyDepartment);
    }

    @Override
    public List<DutyDepartment> haveDutyDepartments(String id) {
        return dutyDepartmentMapper.selectHaveDutyDepartments(id);
    }
}
