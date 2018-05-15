package com.zhulin.bus.service.college.impl;

import com.zhulin.bus.bean.College;
import com.zhulin.bus.mapper.college.CollegeMapper;
import com.zhulin.bus.service.college.CollegeServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ClassRolePermission(group = "paperFile", name = "学院管理", value = "college:m", menuValue = "/admin/college")
public class CollegeServiceImpl implements CollegeServiceI{

    @Autowired
    private CollegeMapper collegeMapper;

    @MethodRolePermission(group = "paperFile", name = "学院查看", value = "college:mr", groupName = "试卷文件组")
    @Override
    public List<College> appReadList(College college) {
        return collegeMapper.selectList(college);
    }

    @MethodRolePermission(group = "paperFile", name = "学院查看详细", value = "college:mr", groupName = "试卷文件组")
    @Override
    public College appReadDetail(String id) {
        return collegeMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "paperFile", name = "学院编辑", value = "college:mu", groupName = "试卷文件组")
    @Override
    public boolean appUpdate(College college) {
        return collegeMapper.update(college);
    }

    @MethodRolePermission(group = "paperFile", name = "学院删除", value = "college:md", groupName = "试卷文件组")
    @Override
    public boolean appDelete(String id) {
        return collegeMapper.delete(id);
    }

    @MethodRolePermission(group = "paperFile", name = "学院添加", value = "college:mc", groupName = "试卷文件组")
    @Override
    public boolean appCreate(College college) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        college.setCollegeId(id);

        return collegeMapper.insert(college);
    }
}
