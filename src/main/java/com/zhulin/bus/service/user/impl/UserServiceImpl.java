package com.zhulin.bus.service.user.impl;


import com.zhulin.bus.bean.User;
import com.zhulin.bus.mapper.user.UserMapper;
import com.zhulin.bus.service.user.UserServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI{
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> appReadList(User user) {
        return userMapper.selectList(user);
    }

    @Override
    public User appReadDetail(String id) {
        return userMapper.selectDetail(id);
    }

    @Override
    public boolean appUpdate(User user) {
        return userMapper.update(user);
    }

    @Override
    public boolean appDelete(String id) {
        return userMapper.delete(id);
    }

    @Override
    public boolean appCreate(User user) {
        String primaryKey = PrimaryKeyUtil.uuidPrimaryKey();
        user.setUserId(primaryKey);

        return userMapper.insert(user);
    }
}
