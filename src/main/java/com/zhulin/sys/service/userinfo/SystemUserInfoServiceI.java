package com.zhulin.sys.service.userinfo;

import com.zhulin.pojo.SystemUserInfo;

public interface SystemUserInfoServiceI {
    SystemUserInfo queryUserInfoByUserId(String userId);
}
