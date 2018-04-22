package com.zhulin.bus.service.element.impl;

import com.zhulin.bus.bean.Element;
import com.zhulin.bus.bean.Point;
import com.zhulin.bus.mapper.element.ElementMapper;
import com.zhulin.bus.service.element.ElementServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ClassRolePermission(group = "supportFile", name = "审查要素管理", value = "element:f", menuValue = "/admin/element")
@Service
public class ElementServiceImpl implements ElementServiceI{

    @Autowired
    private ElementMapper elementMapper;

    @MethodRolePermission(group = "supportFile", name = "审查要素查看", value = "element:fr", groupName = "审查要素管理组")
    @Override
    public List<Element> appReadList(Element element) {
        return elementMapper.selectList(element);
    }

    @MethodRolePermission(group = "supportFile", name = "审查要素详细", value = "element:fd", groupName = "审查要素管理组")
    @Override
    public Element appReadDetail(String id) {
        return elementMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "supportFile", name = "审查要素编辑", value = "element:fe", groupName = "审查要素管理组")
    @Transactional
    @Override
    public boolean appUpdate(Element element) {
        return elementMapper.update(element);
    }

    @MethodRolePermission(group = "supportFile", name = "审查要素删除", value = "element:fd", groupName = "审查要素管理组")
    @Transactional
    @Override
    public boolean appDelete(String id) {
        return elementMapper.delete(id);
    }

    @MethodRolePermission(group = "supportFile", name = "审查要素添加", value = "element:fc", groupName = "审查要素管理组")
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

    @Override
    public List<Point> queryPointByElementId(String elementId) {
       return elementMapper.selectElementProject(elementId);
    }
}
