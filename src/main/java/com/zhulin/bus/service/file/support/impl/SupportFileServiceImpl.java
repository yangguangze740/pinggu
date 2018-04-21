package com.zhulin.bus.service.file.support.impl;

import com.zhulin.bus.bean.SupportFile;
import com.zhulin.bus.mapper.file.support.SupportFileMapperI;
import com.zhulin.bus.service.file.support.SupportFileServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportFileServiceImpl implements SupportFileServiceI{

    @Autowired
    private SupportFileMapperI supportFileMapperI;

    @Override
    public List<SupportFile> appReadList(SupportFile supportFile) {
        return null;
    }

    @Override
    public SupportFile appReadDetail(String id) {
        return null;
    }

    @Override
    public boolean appUpdate(SupportFile supportFile) {
        return false;
    }

    @Override
    public boolean appDelete(String id) {
        return false;
    }

    @Override
    public boolean appCreate(SupportFile supportFile) {
        return false;
    }
}
