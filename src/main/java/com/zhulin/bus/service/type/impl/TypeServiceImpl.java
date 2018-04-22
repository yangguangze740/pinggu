package com.zhulin.bus.service.type.impl;

import com.zhulin.bus.bean.Type;
import com.zhulin.bus.mapper.type.TypeMapper;
import com.zhulin.bus.service.type.TypeServiceI;
import com.zhulin.common.annotation.permission.ClassRolePermission;
import com.zhulin.common.annotation.permission.MethodRolePermission;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ClassRolePermission(group = "problem", name = "问题管理", value = "problem:m", menuValue = "/admin/type")
@Service
public class TypeServiceImpl implements TypeServiceI{

    @Autowired
    private TypeMapper typeMapper;

    @MethodRolePermission(group = "type", name = "问题类型查看", value = "type:mr", groupName = "类型组")
    @Override
    public List<Type> appReadList(Type type) {
        return typeMapper.selectList(type);
    }

    @MethodRolePermission(group = "type", name = "问题类型详细", value = "type:mr", groupName = "类型组")
    @Override
    public Type appReadDetail(String id) {
        return typeMapper.selectDetail(id);
    }

    @MethodRolePermission(group = "type", name = "问题类型查看", value = "type:mu", groupName = "类型组")
    @Transactional
    @Override
    public boolean appUpdate(Type type) {
        return typeMapper.update(type);
    }

    @MethodRolePermission(group = "type", name = "问题类型删除", value = "type:md", groupName = "类型组")
    @Transactional
    @Override
    public boolean appDelete(String id) {
        return typeMapper.delete(id);
    }

    @MethodRolePermission(group = "type", name = "问题类型添加", value = "type:mc", groupName = "类型组")
    @Transactional
    @Override
    public boolean appCreate(Type type) {
        type.setTypeId(PrimaryKeyUtil.uuidPrimaryKey());

        return typeMapper.insert(type);
    }

    @MethodRolePermission(group = "type", name = "问题类型查询", value = "type:mr", groupName = "类型组")
    @Override
    public Map<String, List<Type>> readAllTypeByGroupName() {
        List<Type> types = typeMapper.selectList(new Type());

        Map<String, List<Type>> groupTypes = new HashMap<>();

        for (Type type:types){
            String typeName = type.getTypeName();

            if (groupTypes.containsKey(typeName)){
                groupTypes.get(typeName).add(type);
            } else {
                List<Type> tempList = new ArrayList<>();
                tempList.add(type);

                groupTypes.put(typeName, tempList);
            }
        }

        return groupTypes;
    }

    @MethodRolePermission(group = "type", name = "问题类型查询", value = "type:mr", groupName = "类型组")
    @Override
    public List<Type> readHaveTypes(String id) {
        return typeMapper.selectHaveList(id);
    }
}
