package com.zhulin.sys.service.token;

import com.zhulin.sys.pojo.SystemUserToken;

public interface SystemUserTokenServiceI {
    SystemUserToken querySystemUserTokenByToken(String accessToken);
    SystemUserToken createToken(String userId);
}
