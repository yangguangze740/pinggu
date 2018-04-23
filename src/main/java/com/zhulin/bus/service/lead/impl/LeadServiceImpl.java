package com.zhulin.bus.service.lead.impl;

import com.zhulin.bus.bean.Lead;
import com.zhulin.bus.mapper.lead.LeadMapper;
import com.zhulin.bus.service.lead.LeadServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@ClassRolePermission(group = "supportFile", name = "牵头部门管理", value = "leadDepartment:f", menuValue = "/admin/lead")
@Service
public class LeadServiceImpl implements LeadServiceI{

    @Autowired
    private LeadMapper leadMapper;

    @MethodRolePermission(group = "supportFile", name = "牵头部门查看", value = "leadDepartment:fr", groupName = "牵头部门管理组")
    @Override
    public List<Lead> appReadList(Lead lead) {
        return leadMapper.selectList(lead);
    }

    @MethodRolePermission(group = "supportFile", name = "牵头部门详细", value = "leadDepartment:fd", groupName = "牵头部门管理组")
    @Override
    public Lead appReadDetail(String id) {
        return leadMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "supportFile", name = "牵头部门编辑", value = "leadDepartment:fe", groupName = "牵头部门管理组")
    @Transactional
    @Override
    public boolean appUpdate(Lead lead) {
        return leadMapper.update(lead);
    }

    @MethodRolePermission(group = "supportFile", name = "牵头部门删除", value = "leadDepartment:fd", groupName = "牵头部门管理组")
    @Transactional
    @Override
    public boolean appDelete(String id) {
        return leadMapper.delete(id);
    }

    @MethodRolePermission(group = "supportFile", name = "牵头部门添加", value = "leadDepartment:fc", groupName = "牵头部门管理组")
    @Transactional
    @Override
    public boolean appCreate(Lead lead) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        lead.setLeadDepartmentId(id);

        return leadMapper.insert(lead);
    }
}
