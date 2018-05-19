package com.zhulin.bus.service.bi.typeNumber.impl;

import com.zhulin.bus.bean.Department;
import com.zhulin.bus.bean.Type;
import com.zhulin.bus.bean.bi.DepartmentTypeNumber;
import com.zhulin.bus.bean.bi.TempTypeNumber;
import com.zhulin.bus.mapper.bi.typeNumber.TypeNumberMapperI;
import com.zhulin.bus.mapper.department.DepartmentMapper;
import com.zhulin.bus.mapper.type.TypeMapper;
import com.zhulin.bus.service.bi.typeNumber.TypeNumberServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeNumberServiceImpl implements TypeNumberServiceI{

    @Autowired
    private TypeNumberMapperI typeNumberMapperI;

    @Override
    public List<DepartmentTypeNumber> appReadList(DepartmentTypeNumber departmentTypeNumber) {
        return null;
    }

    @Override
    public DepartmentTypeNumber appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(DepartmentTypeNumber departmentTypeNumber) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return false;
    }

    @Override
    public boolean appCreate(DepartmentTypeNumber departmentTypeNumber) {
        return false;
    }

    @Override
    public List<TempTypeNumber> selectNumber(String departmentId) {
        return typeNumberMapperI.selectNumber(departmentId);
    }

    @Override
    public List<DepartmentTypeNumber> selectAllDepartment() {
        return typeNumberMapperI.selectDepartmentList(new DepartmentTypeNumber());
    }


    @Override
    public DepartmentTypeNumber selectDepartmentNameById(String departmentId) {
        return typeNumberMapperI.selectDepartmentName(departmentId);
    }

    @Override
    public List<DepartmentTypeNumber> selectTypeName(DepartmentTypeNumber departmentTypeNumber) {
        return typeNumberMapperI.selectTypeName(departmentTypeNumber);
    }
}
