package com.zhulin.bus.service.element.impl;

import com.zhulin.bus.bean.Element;
import com.zhulin.bus.mapper.element.ElementMapper;
import com.zhulin.bus.service.element.ElementServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ElementServiceImpl implements ElementServiceI{

    @Autowired
    private ElementMapper elementMapper;

    @Override
    public List<Element> appReadList(Element element) {
        return elementMapper.selectList(element);
    }

    @Override
    public Element appReadDetail(String id) {
        return elementMapper.selectDetail(id);
    }

    @Transactional
    @Override
    public boolean appUpdate(Element element) {
        return elementMapper.update(element);
    }

    @Transactional
    @Override
    public boolean appDelete(String id) {
        return elementMapper.delete(id);
    }

    @Transactional
    @Override
    public boolean appCreate(Element element) {
        String primaryKey = PrimaryKeyUtil.uuidPrimaryKey();
        element.setElementId(primaryKey);

        return elementMapper.insert(element);
    }


    @Override
    public List<Element> appReadProjectElements(String projectId) {
        return elementMapper.selectProjectElements(projectId);
    }
}
