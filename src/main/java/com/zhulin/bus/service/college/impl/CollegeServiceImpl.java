package com.zhulin.bus.service.college.impl;

import com.zhulin.bus.bean.College;
import com.zhulin.bus.mapper.college.CollegeMapper;
import com.zhulin.bus.service.college.CollegeServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeServiceI{

    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<College> appReadList(College college) {
        return collegeMapper.selectList(college);
    }

    @Override
    public College appReadDetail(String id) {
        return collegeMapper.selectDetail(id);
    }

    @Override
    public boolean appUpdate(College college) {
        return collegeMapper.update(college);
    }

    @Override
    public boolean appDelete(String id) {
        return collegeMapper.delete(id);
    }

    @Override
    public boolean appCreate(College college) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        college.setCollegeId(id);

        return collegeMapper.insert(college);
    }
}
