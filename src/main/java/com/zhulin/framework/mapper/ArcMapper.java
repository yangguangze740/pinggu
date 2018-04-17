package com.zhulin.framework.mapper;

import java.util.List;

public interface ArcMapper<T> {
    // list查询
    List<T> selectList(T t);
    // 详细信息
    T selectDetail(String id);
    // 编辑保存
    boolean update(T t);
    // 删除操作
    boolean delete(String id);
    // 添加保存
    boolean insert(T t);
}
