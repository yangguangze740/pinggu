package com.zhulin.bus.service.rateUser.impl;


import com.zhulin.bus.bean.RateUser;
import com.zhulin.bus.mapper.rateUser.RateUserMapper;
import com.zhulin.bus.service.rateUser.RateUserServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateUserServiceImpl implements RateUserServiceI{
    @Autowired
    private RateUserMapper rateUserMapper;

    @Override
    public List<RateUser> appReadList(RateUser rateUser) {
        return rateUserMapper.selectList(rateUser);
    }

    @Override
    public RateUser appReadDetail(String id) {
        return rateUserMapper.selectDetail(id);
    }

    @Override
    public boolean appUpdate(RateUser rateUser) {
        return rateUserMapper.update(rateUser);
    }

    @Override
    public boolean appDelete(String id) {
        return rateUserMapper.delete(id);
    }

    @Override
    public boolean appCreate(RateUser rateUser) {
        String primaryKey = PrimaryKeyUtil.uuidPrimaryKey();
        rateUser.setRaterUserId(primaryKey);

        return rateUserMapper.insert(rateUser);
    }

}
