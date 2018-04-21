package com.zhulin.bus.service.user.rater.impl;


import com.zhulin.bus.bean.RateUser;
import com.zhulin.bus.mapper.user.rater.RateUserMapper;
import com.zhulin.bus.service.user.rater.RateUserServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public boolean appUpdate(RateUser rateUser) {
        return rateUserMapper.update(rateUser);
    }

    @Transactional
    @Override
    public boolean appDelete(String id) {
        return rateUserMapper.delete(id);
    }

    @Transactional
    @Override
    public boolean appCreate(RateUser rateUser) {
        String primaryKey = PrimaryKeyUtil.uuidPrimaryKey();
        rateUser.setRaterUserId(primaryKey);

        return rateUserMapper.insert(rateUser);
    }

}
