package com.zhulin.bus.service.type;

import com.zhulin.bus.bean.Type;
import com.zhulin.framework.service.ArcService;

import java.util.List;
import java.util.Map;

public interface TypeServiceI extends ArcService<Type> {
    Map<String, List<Type>> readAllTypeByGroupName();

    List<Type> readHaveTypes(String id);

}
