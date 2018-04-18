package com.zhulin.sys.service.userinfo;

import com.zhulin.sys.pojo.SystemUserInfo;

public interface SystemUserInfoServiceI {
    SystemUserInfo queryUserInfoByUserId(String userId);
}
