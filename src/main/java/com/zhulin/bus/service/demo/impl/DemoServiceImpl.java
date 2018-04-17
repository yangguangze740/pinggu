package com.zhulin.bus.service.demo.impl;

import com.zhulin.bus.bean.Demo;
import com.zhulin.bus.mapper.demo.DemoMapper;
import com.zhulin.bus.service.demo.DemoServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoServiceI {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Demo> appReadList(Demo demo) {
        return null;
    }

    @Override
    public Demo appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(Demo demo) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return false;
    }

    @Override
    public boolean appCreate(Demo demo) {
        return false;
    }
}
