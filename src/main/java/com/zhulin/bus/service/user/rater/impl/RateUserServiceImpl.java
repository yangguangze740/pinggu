package com.zhulin.bus.service.user.rater.impl;


import com.zhulin.bus.bean.RateUser;
import com.zhulin.bus.mapper.user.rater.RateUserMapper;
import com.zhulin.bus.service.user.rater.RateUserServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ClassRolePermission(group = "raterUser", name = "评审用户管理角色", value = "raterUser:m", menuValue = "/admin/user/rater")
@Service
public class RateUserServiceImpl implements RateUserServiceI{
    @Autowired
    private RateUserMapper rateUserMapper;

    @MethodRolePermission(group = "raterUser", name = "评审用户查看", value = "raterUser:mr", groupName = "普通用户组")
    @Override
    public List<RateUser> appReadList(RateUser rateUser) {
        return rateUserMapper.selectList(rateUser);
    }

    @MethodRolePermission(group = "raterUser", name = "评审用户详细", value = "raterUser:md", groupName = "普通用户组")
    @Override
    public RateUser appReadDetail(String id) {
        return rateUserMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "raterUser", name = "评审用户编辑", value = "raterUser:me", groupName = "普通用户组")
    @Transactional
    @Override
    public boolean appUpdate(RateUser rateUser) {
        return rateUserMapper.update(rateUser);
    }

    @MethodRolePermission(group = "raterUser", name = "评审用户删除", value = "raterUser:md", groupName = "普通用户组")
    @Transactional
    @Override
    public boolean appDelete(String id) {
        return rateUserMapper.delete(id);
    }

    @MethodRolePermission(group = "raterUser", name = "评审用户添加", value = "raterUser:mc", groupName = "普通用户组")
    @Transactional
    @Override
    public boolean appCreate(RateUser rateUser) {
        String primaryKey = PrimaryKeyUtil.uuidPrimaryKey();
        rateUser.setRaterUserId(primaryKey);

        return rateUserMapper.insert(rateUser);
    }

}
