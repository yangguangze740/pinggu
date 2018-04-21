package com.zhulin.bus.service.lead.impl;

import com.zhulin.bus.bean.Lead;
import com.zhulin.bus.mapper.lead.LeadMapper;
import com.zhulin.bus.service.lead.LeadServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LeadServiceImpl implements LeadServiceI{

    @Autowired
    private LeadMapper leadMapper;

    @Override
    public List<Lead> appReadList(Lead lead) {
        return leadMapper.selectList(lead);
    }

    @Override
    public Lead appReadDetail(String id) {
        return leadMapper.selectDetail(id);
    }

    @Transactional
    @Override
    public boolean appUpdate(Lead lead) {
        return leadMapper.update(lead);
    }

    @Transactional
    @Override
    public boolean appDelete(String id) {
        return leadMapper.delete(id);
    }

    @Transactional
    @Override
    public boolean appCreate(Lead lead) {
        String id = PrimaryKeyUtil.uuidPrimaryKey();
        lead.setLeadDepartmentId(id);

        return leadMapper.insert(lead);
    }
}
