package com.zhulin.bus.service.log.impl;

import com.zhulin.bus.bean.Log;
import com.zhulin.bus.mapper.log.LogMapper;
import com.zhulin.bus.service.log.LogServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogServiceI{

    @Autowired
    private LogMapper logMapper;

    @Override
    public List<Log> appReadList(Log log) {
        return logMapper.selectList(log);
    }

    @Override
    public Log appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(Log log) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return false;
    }

    @Override
    public boolean appCreate(Log log) {
        return false;
    }
}
