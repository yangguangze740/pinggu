package com.zhulin.framework.service;

import java.util.List;

public interface ArcService<T> {
    // list查询
    List<T> appReadList(T t);
    // 详细信息
    T appReadDetail(String id);
    // 编辑保存
    boolean appUpdate(T t);
    // 删除操作
    boolean appDelete(String id);
    // 添加保存
    boolean appCreate(T t);
}
