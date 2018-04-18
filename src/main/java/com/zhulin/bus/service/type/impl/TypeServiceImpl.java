package com.zhulin.bus.service.type.impl;

import com.zhulin.bus.bean.Type;
import com.zhulin.bus.mapper.Type.TypeMapper;
import com.zhulin.bus.service.type.TypeServiceI;
import com.zhulin.common.db.PrimaryKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl implements TypeServiceI{

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> appReadList(Type type) {
        return typeMapper.selectList(type);
    }

    @Override
    public Type appReadDetail(String id) {
        return typeMapper.selectDetail(id);
    }

    @Override
    public boolean appUpdate(Type type) {
        return typeMapper.update(type);
    }

    @Override
    public boolean appDelete(String id) {
        return typeMapper.delete(id);
    }

    @Override
    public boolean appCreate(Type type) {
        type.setTypeId(PrimaryKeyUtil.uuidPrimaryKey());
        type.setTypeFileNumber(0);

        return typeMapper.insert(type);
    }

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

    @Override
    public List<Type> readHaveTypes(String id) {
        return typeMapper.selectHaveList(id);
    }
}
