package com.zhulin.sys.service.userinfo.impl;

import com.zhulin.pojo.SystemUserInfo;
import com.zhulin.sys.mapper.userinfo.SystemUserInfoMapper;
import com.zhulin.sys.service.userinfo.SystemUserInfoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SystemUserInfoServiceImpl implements SystemUserInfoServiceI {

    @Autowired
    private SystemUserInfoMapper userInfoMapper;

    @Transactional
    @Override
    public SystemUserInfo queryUserInfoByUserId(String userId) {
        return userInfoMapper.selectUserInfoByUserId(userId);
    }
}
