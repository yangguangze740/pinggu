package com.zhulin.sys.service.token.impl;

import com.zhulin.common.token.TokenGenerator;
import com.zhulin.pojo.SystemUserToken;
import com.zhulin.sys.mapper.token.SystemUserTokenMapper;
import com.zhulin.sys.service.token.SystemUserTokenServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.sql.Timestamp;

@Service
public class SystemUserTokenServiceImpl implements SystemUserTokenServiceI {

    @Autowired
    private SystemUserTokenMapper userTokenMapper;

    private static final int EXPIRE = 60 * 60 * 1000; // 1小时

    @Transactional
    @Override
    public SystemUserToken querySystemUserTokenByToken(String accessToken) {
        return userTokenMapper.selectTokenInfoByToken(accessToken);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,
            rollbackFor = {RuntimeException.class, Exception.class, SQLException.class, ArithmeticException.class},
            propagation= Propagation.REQUIRED)
    @Override
    public SystemUserToken createToken(String userId) {
        String token = TokenGenerator.createValue();

        Timestamp now = new Timestamp(System.currentTimeMillis());
        Timestamp expireTime = new Timestamp(now.getTime() + EXPIRE * 12);

        SystemUserToken userToken = userTokenMapper.selectTokenByUserId(userId);

        if (userToken == null) {
            userToken = new SystemUserToken();

            userToken.setUserId(userId);
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);

            int updateNumber = userTokenMapper.insertNewUserToken(userToken);
        } else {
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);

            int updateNumber = userTokenMapper.updateUserToken(userToken);
        }

        return userToken;
    }
}
