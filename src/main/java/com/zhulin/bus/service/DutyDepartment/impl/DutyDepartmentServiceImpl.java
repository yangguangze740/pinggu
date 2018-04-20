package com.zhulin.bus.service.DutyDepartment.impl;

import com.zhulin.bus.bean.DutyDepartment;
import com.zhulin.bus.mapper.dutyDepartment.DutyDepartmentMapper;
import com.zhulin.bus.service.DutyDepartment.DutyDepartmentServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DutyDepartmentServiceImpl implements DutyDepartmentServiceI{

    @Autowired
    private DutyDepartmentMapper dutyDepartmentMapper;

    @Override
    public List<DutyDepartment> appReadList(DutyDepartment dutyDepartment) {
        return dutyDepartmentMapper.selectList(dutyDepartment);
    }

    @Override
    public DutyDepartment appReadDetail(String id) {
        return dutyDepartmentMapper.selectDetail(id);
    }

    @Override
    public boolean appUpdate(DutyDepartment dutyDepartment) {
        return dutyDepartmentMapper.update(dutyDepartment);
    }

    @Override
    public boolean appDelete(String id) {
        return dutyDepartmentMapper.delete(id);
    }

    @Override
    public boolean appCreate(DutyDepartment dutyDepartment) {
        String primaryKey = PrimaryKeyUtil.uuidPrimaryKey();
        dutyDepartment.setDutyDepartmentId(primaryKey);

        return dutyDepartmentMapper.insert(dutyDepartment);
    }
}
