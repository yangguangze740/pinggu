package com.zhulin.bus.service.user.general.impl;


import com.zhulin.bus.bean.User;
import com.zhulin.bus.mapper.user.general.GeneralUserMapper;
import com.zhulin.bus.service.user.general.GeneralUserServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ClassRolePermission(group = "generalUser", name = "普通用户管理角色", value = "generalUser:m", menuValue = "/admin/user/general")
@Service
public class GeneralUserServiceImpl implements GeneralUserServiceI {

    @Autowired
    private GeneralUserMapper generalUserMapper;

    @MethodRolePermission(group = "generalUser", name = "普通用户查看", value = "generalUser:mr", groupName = "普通用户组")
    @Override
    public List<User> appReadList(User user) {
        return generalUserMapper.selectList(user);
    }

    @MethodRolePermission(group = "generalUser", name = "普通用户详细", value = "generalUser:md", groupName = "普通用户组")
    @Override
    public User appReadDetail(String id) {
        return generalUserMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "generalUser", name = "普通用户编辑", value = "generalUser:me", groupName = "普通用户组")
    @Transactional
    @Override
    public boolean appUpdate(User user) {
        return generalUserMapper.update(user);
    }

    @MethodRolePermission(group = "generalUser", name = "普通用户删除", value = "generalUser:md", groupName = "普通用户组")
    @Transactional
    @Override
        public boolean appDelete(String id) {
        return generalUserMapper.delete(id);
    }

    @MethodRolePermission(group = "generalUser", name = "普通用户添加", value = "generalUser:mc", groupName = "普通用户组")
    @Transactional
    @Override
    public boolean appCreate(User user) {
        String primaryKey = PrimaryKeyUtil.uuidPrimaryKey();
        user.setUserId(primaryKey);

        return generalUserMapper.insert(user);
    }
}
