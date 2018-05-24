package com.zhulin.bus.service.department.impl;

import com.zhulin.bus.bean.*;
import com.zhulin.bus.bean.bi.DepartmentNumber;
import com.zhulin.bus.mapper.department.DepartmentMapper;
import com.zhulin.bus.mapper.dutyDepartment.DutyDepartmentMapper;
import com.zhulin.bus.mapper.lead.LeadMapper;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import com.zhulin.common.def.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@ClassRolePermission(group = "problem", name = "问题管理", value = "problem:m", menuValue = "/admin/department")
@Service
public class DepartmentServiceImpl implements DepartmentServiceI{

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private DutyDepartmentMapper dutyDepartmentMapper;
    @Autowired
    private LeadMapper leadMapper;

    @MethodRolePermission(group = "department", name = "部门查看", value = "department:mr", groupName = "部门组")
    @Override
    public List<Department> appReadList(Department department) {
        return departmentMapper.selectList(department);
    }

    @MethodRolePermission(group = "department", name = "部门详细", value = "department:mr", groupName = "部门组")
    @Override
    public Department appReadDetail(String id) {
        return departmentMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "department", name = "部门编辑", value = "department:mu", groupName = "部门组")
    @Transactional
    @Override
    public boolean appUpdate(Department department) {
        String departmentId = department.getDepartmentId();

        int deleteTypeNum = departmentMapper.deleteDepartmentType(departmentId);

        int editDepartment = departmentMapper.updateDepartment(department);

        List<DepartmentType> departmentTypes = new ArrayList<>();

        List<String> departmentIds = department.getTypeIds();

        for (String id : departmentIds) {
            DepartmentType departmentType = new DepartmentType();

            departmentType.setTypeId(id);
            departmentType.setDepartmentId(departmentId);

            departmentTypes.add(departmentType);
        }

        int insertDepartmentTypeNum = departmentMapper.insertDepartmentType(departmentTypes);

        return (deleteTypeNum >= 0)&&(editDepartment > 0)&&(insertDepartmentTypeNum == departmentIds.size());
    }

    @MethodRolePermission(group = "department", name = "部门删除", value = "department:md", groupName = "部门组")
    @Transactional
    @Override
    public boolean appDelete(String id) {
        int deleteDepartmentNum = departmentMapper.deleteDepartment(id);

        int deleteDepartmentTypeNum = departmentMapper.deleteDepartmentType(id);

        return (deleteDepartmentNum >= 0) && (deleteDepartmentTypeNum >= 0);
    }

    @MethodRolePermission(group = "department", name = "部门添加", value = "department:mc", groupName = "部门组")
    @Transactional
    @Override
    public boolean appCreate(Department department) {
        String departmentId = PrimaryKeyUtil.uuidPrimaryKey();
        department.setDepartmentId(departmentId);

        List<DepartmentType> departmentTypes = new ArrayList<>();
        List<String> typeIds = department.getTypeIds();

        for (String typeId : typeIds) {
            DepartmentType departmentType = new DepartmentType();

            departmentType.setDepartmentId(departmentId);
            departmentType.setTypeId(typeId);

            departmentTypes.add(departmentType);
        }

        int insertDepartmentNum = departmentMapper.insertDepartment(department);
        int insertDepartmentTypeNum = departmentMapper.insertDepartmentType(departmentTypes);

        DutyDepartment dutyDepartment = new DutyDepartment();
        dutyDepartment.setDutyDepartmentId(departmentId);
        dutyDepartment.setDutyName(department.getDepartmentName());
        dutyDepartment.setAdminId(department.getAdminId());
        dutyDepartment.setDutyAdd(Constants.DEPARTMENT_ADD);

        Lead lead = new Lead();
        lead.setLeadDepartmentId(departmentId);
        lead.setLeadName(department.getDepartmentName());
        lead.setAdminId(department.getAdminId());
        lead.setLeadAdd(Constants.DEPARTMENT_ADD);

        int insertDepartmentDuty = dutyDepartmentMapper.insertDepartment(dutyDepartment);
        int insertLeadDepartment = leadMapper.insertDeparment(lead);

        return ((insertDepartmentNum == 1)&&(insertDepartmentTypeNum == typeIds.size())&&(insertDepartmentDuty == 1)&&(insertLeadDepartment == 1));
    }

    @Transactional
    @Override
    public boolean updateProblem(Department department) {
        String departmentId = department.getDepartmentId();

        int deleteProNum = departmentMapper.deleteDepartmentPro(departmentId);

        List<DepartmentProblem> departmentProblems = new ArrayList<>();

        List<String> problemIds = department.getProblemIds();

        for (String id : problemIds) {
            DepartmentProblem departmentProblem = new DepartmentProblem();

            departmentProblem.setProblemId(id);
            departmentProblem.setDepartmentId(departmentId);

            departmentProblems.add(departmentProblem);
        }

        int insertDepartmentTypeNum = departmentMapper.insertDepartmentPro(departmentProblems);

        return (deleteProNum >= 0)&&(insertDepartmentTypeNum == problemIds.size());
    }

    @Override
    public List<DepartmentNumber> selectDepartmentFileNumber() {
        return departmentMapper.selectDepartmemtList();
    }
}
