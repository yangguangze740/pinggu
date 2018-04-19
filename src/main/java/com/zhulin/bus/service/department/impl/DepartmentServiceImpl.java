package com.zhulin.bus.service.department.impl;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.DepartmentProblem;
import com.zhulin.bus.bean.DepartmentType;
import com.zhulin.bus.bean.Type;
import com.zhulin.bus.mapper.department.DepartmentMapper;
import com.zhulin.bus.service.department.DepartmentServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentServiceI{

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> appReadList(Department department) {
        return departmentMapper.selectList(department);
    }

    @Override
    public Department appReadDetail(String id) {
        return departmentMapper.selectDetail(id);
    }

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

    @Transactional
    @Override
    public boolean appDelete(String id) {
        int deleteDepartmentNum = departmentMapper.deleteDepartment(id);

        int deleteDepartmentTypeNum = departmentMapper.deleteDepartmentType(id);

        return (deleteDepartmentNum >= 0) && (deleteDepartmentTypeNum >= 0);
    }

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

        return ((insertDepartmentNum == 1)&&(insertDepartmentTypeNum == typeIds.size()));
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
}
